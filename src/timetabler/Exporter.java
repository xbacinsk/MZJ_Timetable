package timetabler;

import com.trolltech.qt.QVariant;
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.xml.QDomDocument;
import com.trolltech.qt.xml.QDomElement;
import com.trolltech.qt.xml.QDomProcessingInstruction;
import com.trolltech.qt.xml.QDomText;
import java.util.List;
import timetabler.dialogs.ExportDialog;
import timetabler.entities.*;

/**
 * Creates XML file from list of Course objects
 *
 * @author Lenka Bacinska
 * @version 2012-05-05
 */
public class Exporter extends QObject {

    private List<Course> courses;
    private QDomDocument doc = new QDomDocument();
    QSettings settings = new QSettings();
    private Boolean fail = false;

    public Exporter(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * Writes a XML file
     *
     */
    public void writeXML() {
        if (!settings.contains("export/name") || !fail) {
            ExportDialog dialog = new ExportDialog();
            if (dialog.exec() == QDialog.DialogCode.Rejected.value()) {
                dialog.close();
                return;
            }
            fail = false;
            dialog.close();
        }

        String name = QVariant.toString(settings.value("export/name"));

        QFile file = new QFile("misc/" + name + ".xml");
        if (!file.open(new QIODevice.OpenMode(QIODevice.OpenModeFlag.WriteOnly,
                QIODevice.OpenModeFlag.Text))) {
            return;
        }

        // writes out the XML document content
        file.write(exportToXML().toByteArray());
        file.close();
    }

    /**
     * Exports XML from given list of courses
     *
     * @return XML in QByteArray form
     */
    private QDomDocument exportToXML() {

        // creates XML document with root element "timetable"
        doc.setContent("<timetable/>");
        QDomElement rootElement = doc.documentElement();

        QDomProcessingInstruction pi1 = doc.createProcessingInstruction("xml", "version=\"1.0\" encoding=\"utf-8\"");
        doc.insertBefore(pi1, rootElement);

        // connects XML to XSLT
        QDomProcessingInstruction pi2 = doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"timetable.xsl\"");
        doc.insertBefore(pi2, rootElement);

        rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        rootElement.setAttribute("xmlns", "");
        rootElement.setAttribute("xsi:noNamespaceSchemaLocation", "timetable.xsd");

        // creates element "hours" with specific color
        QDomElement hoursE = doc.createElement("hours");
        rootElement.appendChild(hoursE);
        hoursE.setAttribute("bgcolor", "f5f5f5");

        // creates a list of hours with widths of their cells
        QTime time = minTime();
        int dif = maxTime().hour() - time.hour() + 1;
        for (int i = 0; i < dif; i++) {
            QDomElement hourE = doc.createElement("hour");

            int diff = 12;
            long pdiff = Math.round(12 * 60 / 100);
            if (i == dif - 1) {
                diff = 10;
                pdiff = Math.round(12 * maxTime().minute() / 100);
            }
            hourE.setAttribute("diff", diff);
            hourE.setAttribute("pdiff", pdiff);
            hourE.appendChild(doc.createTextNode(time.addSecs(3600 * i).toString("hh:mm")));

            hoursE.appendChild(hourE);
        }

        // creates element "days"
        QDomElement daysE = doc.createElement("days");
        rootElement.appendChild(daysE);

        // creates element "notes" (e.g. even/odd weeks)
        QDomElement notesE = doc.createElement("notes");
        int numNotes = 0;
        rootElement.appendChild(notesE);

        for (int d = 0; d < 7; d++) {

            // writes only days with at least one lecture or seminar
            if (CourseInDay(Days.values()[d])) {
                QDomElement dayE = doc.createElement("day");

                dayE.setAttribute("id", "" + Days.values()[d]);
                dayE.setAttribute("rows", maxPosition(d));   // max num z kolizi

                //number of collisions(rows in the day)
                for (int r = 1; r <= maxPosition(d); r++) {
                    QDomElement rowE = doc.createElement("row");
                    rowE.setAttribute("num", r);

                    QTime endTime = minTime();  // break begin
                    for (int i = 0; i < dif; i++) {
                        for (Course course : courses) {

                            if (course.getLectureVisibility() && !course.getLectures().isEmpty()) {
                                for (Lecture lecture : course.getLectures()) {

                                    if (lecture.getTimeFrom().equals(time.addSecs(3600 * i))) {
                                        if ((lecture.getPosition() == r) && (lecture.getDay() == Days.values()[d])) {

                                            // break cell
                                            if (!lecture.getTimeFrom().equals(endTime)) {
                                                rowE.appendChild(breakCell(endTime, lecture.getTimeFrom()));
                                            }

                                            QDomElement cellE = doc.createElement("cell");
                                            int diff = lecture.getLength();

                                            cellE.setAttribute("diff", 12 * diff / 60);
                                            cellE.setAttribute("pdiff", Math.round(12 * diff / 100));

                                            // creates element "course" with its info
                                            QDomElement courseE = doc.createElement("course");

                                            // cell color - if user wants colorize lectures/seminars
                                            if (QVariant.toBoolean(settings.value("export/color"))) {
                                                courseE.setAttribute("color", "e9d5e5");
                                            }

                                            // course id (for URL to course page in IS)
                                            QDomElement courseidE = doc.createElement("courseid");
                                            QDomText courseidT = doc.createTextNode("" + course.getId());
                                            courseidE.appendChild(courseidT);
                                            courseE.appendChild(courseidE);

                                            // course code
                                            QDomElement codeE = doc.createElement("code");
                                            String code = course.getCode();
                                            codeE.appendChild(doc.createTextNode(code));
                                            courseE.appendChild(codeE);

                                            // course name
                                            QDomElement nameE = doc.createElement("name");
                                            nameE.appendChild(doc.createTextNode(course.getName()));
                                            courseE.appendChild(nameE);

                                            // lecture teacher
                                            QDomElement teacherE = doc.createElement("teacher");
                                            teacherE.appendChild(doc.createTextNode(lecture.getTeacher().getName()));

                                            // if user wants URL to Person page in IS
                                            if (QVariant.toBoolean(settings.value("export/teacher"))) {
                                                teacherE.setAttribute("id", "" + lecture.getTeacher().getTeacherId());
                                            }
                                            courseE.appendChild(teacherE);

                                            // list of rooms, where the course is taught
                                            QDomElement roomsE = doc.createElement("rooms");
                                            for (Room room : lecture.getRooms()) {
                                                QDomElement roomE = doc.createElement("room");
                                                roomE.appendChild(doc.createTextNode(room.getName()));

                                                // if user wants URL to Room page in IS
                                                if (QVariant.toBoolean(settings.value("export/room"))) {
                                                    roomE.setAttribute("id", "" + room.getRoomId());
                                                }
                                                roomsE.appendChild(roomE);
                                            }
                                            courseE.appendChild(roomsE);
                                            cellE.appendChild(courseE);
                                            rowE.appendChild(cellE);

                                            endTime = lecture.getTimeTo();
                                        }
                                    }
                                }
                            }

                            if (!course.getSeminars().isEmpty()) {
                                for (Seminar seminar : course.getSeminars()) {

                                    if (seminar.isVisible() && seminar.getTimeFrom().equals(time.addSecs(3600 * i))) {
                                        if ((seminar.getPosition() == r) && (seminar.getDay() == Days.values()[d])) {

                                            // break cell
                                            if (!seminar.getTimeFrom().equals(endTime)) {
                                                rowE.appendChild(breakCell(endTime, seminar.getTimeFrom()));
                                            }

                                            // cell with course info
                                            QDomElement cellE = doc.createElement("cell");
                                            int diff = seminar.getLength();

                                            cellE.setAttribute("diff", 12 * diff / 60);
                                            cellE.setAttribute("pdiff", Math.round(12 * diff / 100));

                                            QDomElement courseE = doc.createElement("course");

                                            // if there is a note to the seminar
                                            if (!"".equals(seminar.toolTip())) {
                                                numNotes++;
                                                courseE.setAttribute("note", numNotes);
                                                QDomElement noteE = doc.createElement("note");
                                                noteE.setAttribute("id", numNotes);
                                                noteE.appendChild(doc.createTextNode(seminar.toolTip()));
                                                notesE.appendChild(noteE);
                                            }

                                            // if user wants to colorize lectures/seminars
                                            if (QVariant.toBoolean(settings.value("export/color"))) {
                                                String color = "d9f5d5";
                                                courseE.setAttribute("color", color);
                                            }

                                            // course id (for URL to course page in IS)
                                            QDomElement courseidE = doc.createElement("courseid");
                                            QDomText courseidT = doc.createTextNode("" + course.getId());
                                            courseidE.appendChild(courseidT);
                                            courseE.appendChild(courseidE);

                                            // course code with group number
                                            QDomElement codeE = doc.createElement("code");
                                            String code = course.getCode() + "/" + seminar.getGroupNum();
                                            codeE.appendChild(doc.createTextNode(code));
                                            courseE.appendChild(codeE);

                                            // course name
                                            QDomElement nameE = doc.createElement("name");
                                            nameE.appendChild(doc.createTextNode(course.getName()));
                                            courseE.appendChild(nameE);

                                            // seminar teacher
                                            QDomElement teacherE = doc.createElement("teacher");
                                            teacherE.appendChild(doc.createTextNode(seminar.getTeacher().getName()));

                                            // if user wants URL to Person page in IS
                                            if (QVariant.toBoolean(settings.value("export/teacher"))) {
                                                teacherE.setAttribute("id", "" + seminar.getTeacher().getTeacherId());
                                            }
                                            courseE.appendChild(teacherE);

                                            // list of rooms, where the seminar is taught
                                            QDomElement roomsE = doc.createElement("rooms");
                                            for (Room room : seminar.getRooms()) {
                                                QDomElement roomE = doc.createElement("room");
                                                roomE.appendChild(doc.createTextNode(room.getName()));

                                                // if user wants URL to Room page in IS
                                                if (QVariant.toBoolean(settings.value("export/room"))) {
                                                    roomE.setAttribute("id", "" + room.getRoomId());
                                                }
                                                roomsE.appendChild(roomE);
                                            }
                                            courseE.appendChild(roomsE);
                                            cellE.appendChild(courseE);
                                            rowE.appendChild(cellE);

                                            endTime = seminar.getTimeTo();
                                        }
                                    }
                                }
                            }
                            dayE.appendChild(rowE);
                        }
                    }

                    // break cell in the end of row
                    if (!maxTime().equals(endTime)) {
                        rowE.appendChild(breakCell(endTime, maxTime()));
                    }
                }
                daysE.appendChild(dayE);
            }
        }
        return doc;
    }

    /**
     * Finds out the courses minimal begin time
     *
     * @return minimum of course times
     */
    private QTime minTime() {
        QTime min = new QTime(23, 0);
        for (Course course : courses) {

            if (course.getLectureVisibility()) {
                if (course.getLectures() != null) {
                    for (Lecture lecture : course.getLectures()) {
                        QTime tmp = lecture.getTimeFrom();
                        if (tmp.hour() < min.hour()) {
                            min = tmp;
                        }
                    }
                }
            }

            if (course.getSeminars() != null) {
                for (Seminar seminar : course.getSeminars()) {
                    if (seminar.isVisible()) {
                        QTime tmp = seminar.getTimeFrom();
                        if (tmp.hour() < min.hour()) {
                            min = tmp;
                        }
                    }
                }
            }
        }
        return new QTime(min.hour(), 0);
    }

    /**
     * Finds out the courses maximal end time
     *
     * @return maximum of course times
     */
    private QTime maxTime() {
        QTime max = new QTime(6, 0);
        for (Course course : courses) {

            if (course.getLectureVisibility()) {
                if (course.getLectures() != null) {
                    for (Lecture lecture : course.getLectures()) {
                        QTime tmp = lecture.getTimeTo();
                        if (tmp.hour() > max.hour()) {
                            max = tmp;
                        }
                    }
                }
            }

            if (course.getSeminars() != null) {
                for (Seminar seminar : course.getSeminars()) {
                    if (seminar.isVisible()) {
                        QTime tmp = seminar.getTimeTo();
                        if (tmp.hour() > max.hour()) {
                            max = tmp;
                        }
                    }
                }
            }
        }
        return max;
    }

    /**
     * Finds out if there is any lecture/seminar in the given day
     *
     * @param day asked day
     * @return true if there is at least one term in the given day
     */
    private Boolean CourseInDay(Days day) {
        for (Course course : courses) {

            if (course.getLectureVisibility() && course.getLectures() != null) {
                for (Lecture lecture : course.getLectures()) {
                    if (lecture.getDay() == day) {
                        return true;
                    }
                }
            }

            if (course.getSeminars() != null) {
                for (Seminar seminar : course.getSeminars()) {
                    if (seminar.isVisible() && seminar.getDay() == day) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Finds out the max number of collisions in the given day
     *
     * @param day day with collisions
     * @return max number of collisions
     */
    private int maxPosition(int day) {
        int max = 0;
        for (Course course : courses) {

            if (course.getLectureVisibility() && course.getLectures() != null) {
                for (Lecture lecture : course.getLectures()) {
                    if (lecture.getDay() == Days.values()[day]) {
                        int tmp = lecture.getPosition();
                        if (tmp > max) {
                            max = tmp;
                        }
                    }
                }
            }

            if (course.getSeminars() != null) {
                for (Seminar seminar : course.getSeminars()) {
                    if (seminar.isVisible() && seminar.getDay() == Days.values()[day]) {
                        int tmp = seminar.getPosition();
                        if (tmp > max) {
                            max = tmp;
                        }
                    }
                }
            }
        }
        return max;
    }

    /**
     * Creates an empty cell
     *
     * @param breakBegin break begin tme
     * @param breakEnd break end time
     * @return element "cell" with "break" child
     */
    private QDomElement breakCell(QTime breakBegin, QTime breakEnd) {
        QDomElement breakCellE = doc.createElement("cell");

        int length = breakBegin.secsTo(breakEnd) / 60;

        breakCellE.setAttribute("diff", 12 * length / 60);  //colspan
        breakCellE.setAttribute("pdiff", Math.round(12 * length / 100));    //width

        QDomElement breakE = doc.createElement("break");
        breakCellE.appendChild(breakE);

        return breakCellE;
    }
}
