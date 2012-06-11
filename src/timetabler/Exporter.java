package timetabler;

import com.trolltech.qt.QVariant;
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.xml.*;
import java.math.BigInteger;
import java.util.ArrayList;
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
     * @param courses list of courses (from parsed XML)
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
            int pdiff = 7;
            if (i == dif - 1) {
                diff = 10;
                pdiff = 6;
            }

            long di = Math.round(60 / 7.83);
            hourE.setAttribute("diff", diff);

            hourE.setAttribute("pdiff", pdiff);
//            hourE.setAttribute("diff", diff);

            hourE.appendChild(doc.createTextNode(time.addSecs(3600 * i).toString("hh:mm")));

            hoursE.appendChild(hourE);
        }

        // creates element "days"
        QDomElement daysE = doc.createElement("days");
        rootElement.appendChild(daysE);


        for (int d = 0; d < 7; d++) {
            if (CourseInDay(Days.values()[d])) {
                QDomElement dayE = doc.createElement("day");

                dayE.setAttribute("id", "" + Days.values()[d]);
                dayE.setAttribute("rows", 1);   // max num z kolizi - prepsat ked bude priznak

                for (int r = 1; r <= 1; r++) {   //pocet kolizi - radku
                    QDomElement rowE = doc.createElement("row");
                    rowE.setAttribute("num", r);


                    QTime endTime = minTime();
                    for (int i = 0; i < dif; i++) {

                        for (Course course : courses) {
                            if (course.getLectureVisibility() && (course.getLectures() != null)) {
                                for (Lecture lecture : course.getLectures()) {                                    
                                    if (lecture.getTimeFrom().equals(time.addSecs(3600 * i))) {
                                        //(cislokolize==r)
                                        if ((lecture.getDay() == Days.values()[d])) {

                                            if (!lecture.getTimeFrom().equals(endTime)) {
                                                QDomElement breakCellE = doc.createElement("cell");
                                                
                                                int diff = (lecture.getTimeFrom().hour() * 60 + lecture.getTimeFrom().minute()) - (endTime.hour() * 60 + endTime.minute());

                                                breakCellE.setAttribute("diff", dif * diff / 60);
                                                breakCellE.setAttribute("pdiff", Math.round(dif * diff / 100));

                                                QDomElement breakE = doc.createElement("break");
                                                breakCellE.appendChild(breakE);
                                                rowE.appendChild(breakCellE);
                                            }

                                            QDomElement cellE = doc.createElement("cell");
                                            int diff = (lecture.getTimeTo().hour() * 60 + lecture.getTimeTo().minute()) - (lecture.getTimeFrom().hour() * 60 + lecture.getTimeFrom().minute());

                                            cellE.setAttribute("diff", dif * diff / 60);
                                            cellE.setAttribute("pdiff", Math.round(dif * diff / 100));

                                            QDomElement courseE = doc.createElement("course");

                                            if (QVariant.toBoolean(settings.value("export/color"))) {
                                                String color = "e9d5e5";
                                                courseE.setAttribute("color", color);
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


                            /*
                             * if(course.getSeminars() != null) for (Seminar
                             * seminar : course.getSeminars()) {
                             * //(cislokolize==r) if ((seminar.getDay() ==
                             * Days.values()[d])) {
                             *
                             * QDomElement breakCellE =
                             * doc.createElement("cell");
                             * breakCellE.setAttribute("pdiff", 12);
                             * breakCellE.setAttribute("diff", 10); QDomElement
                             * breakE = doc.createElement("break");
                             * breakCellE.appendChild(breakE);
                             * rowE.appendChild(breakCellE);
                             *
                             *
                             * QDomElement cellE = doc.createElement("cell");
                             * cellE.setAttribute("pdiff", 12);
                             * cellE.setAttribute("diff", 10);
                             *
                             *
                             *
                             * QDomElement courseE =
                             * doc.createElement("course");
                             *
                             * if(QVariant.toBoolean(settings.value("export/color")))
                             * { String color = "d9f5d5";
                             * courseE.setAttribute("color", color); }
                             *
                             * // course id (for URL to course page in IS)
                             * QDomElement courseidE =
                             * doc.createElement("courseid"); QDomText courseidT
                             * = doc.createTextNode("" + course.getId());
                             * courseidE.appendChild(courseidT);
                             * courseE.appendChild(courseidE);
                             *
                             * // course code QDomElement codeE =
                             * doc.createElement("code"); String code =
                             * course.getCode(); code = code + "/" +
                             * seminar.getGroupNum();
                             * codeE.appendChild(doc.createTextNode(code));
                             * courseE.appendChild(codeE);
                             *
                             * // course name QDomElement nameE =
                             * doc.createElement("name");
                             * nameE.appendChild(doc.createTextNode(course.getName()));
                             * courseE.appendChild(nameE);
                             *
                             * // lecture teacher QDomElement teacherE =
                             * doc.createElement("teacher");
                             * teacherE.appendChild(doc.createTextNode(seminar.getTeacher().getName()));
                             *
                             * // if user wants URL to Person page in IS if
                             * (QVariant.toBoolean(settings.value("export/teacher")))
                             * { teacherE.setAttribute("id", "" +
                             * seminar.getTeacher().getTeacherId()); }
                             * courseE.appendChild(teacherE);
                             *
                             * // list of rooms, where the course is taught
                             * QDomElement roomsE = doc.createElement("rooms");
                             * for (Room room : seminar.getRooms()) {
                             * QDomElement roomE = doc.createElement("room");
                             * roomE.appendChild(doc.createTextNode(room.getName()));
                             *
                             * // if user wants URL to Room page in IS if
                             * (QVariant.toBoolean(settings.value("export/room")))
                             * { roomE.setAttribute("id", "" +
                             * room.getRoomId()); } roomsE.appendChild(roomE); }
                             * courseE.appendChild(roomsE);
                             * cellE.appendChild(courseE);
                             *
                             * rowE.appendChild(cellE); } }
                             */

                            dayE.appendChild(rowE);

                        }
                    }


                    if (!maxTime().equals(endTime)) {
                        QDomElement breakCellE = doc.createElement("cell");
                        int diff = (maxTime().hour() * 60 + maxTime().minute()) - (endTime.hour() * 60 + endTime.minute());

                        breakCellE.setAttribute("diff", dif * diff / 60);
                        breakCellE.setAttribute("pdiff", Math.round(dif * diff / 100));

                        QDomElement breakE = doc.createElement("break");
                        breakCellE.appendChild(breakE);
                        rowE.appendChild(breakCellE);
                    }


                }
                daysE.appendChild(dayE);
            }
        }

        return doc;
    }

    /**
     * Finds out the courses minimal time
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
                    QTime tmp = seminar.getTimeFrom();
                    if (tmp.hour() < min.hour()) {
                        min = tmp;
                    }
                }
            }
        }
        return min;
    }

    /**
     * Finds out the courses maximal time
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
                    QTime tmp = seminar.getTimeTo();
                    if (tmp.hour() > max.hour()) {
                        max = tmp;
                    }
                }
            }
        }
        return max;
    }

    /**
     * Finds out if there is any term in the given day
     *
     * @param day asked day
     * @param terms list of terms
     * @return true if there is at least one term in the given day
     */
    private Boolean CourseInDay(Days day) {
        for (Course course : courses) {

            if (course.getLectureVisibility()) {
                if (course.getLectures() != null) {
                    for (Lecture lecture : course.getLectures()) {
                        if (lecture.getDay() == day) {
                            return true;
                        }
                    }
                }
            }

            if (course.getSeminars() != null) {
                for (Seminar seminar : course.getSeminars()) {
                    if (seminar.getDay() == day) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
