package timetabler;

import com.trolltech.qt.QVariant;
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.xml.QDomDocument;
import com.trolltech.qt.xml.QDomElement;
import com.trolltech.qt.xml.QDomProcessingInstruction;
import com.trolltech.qt.xml.QDomText;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import timetabler.dialogs.ExportDialog;
import timetabler.entities.Course;
import timetabler.entities.Days;
import timetabler.entities.Room;
import timetabler.entities.Term;

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
        QTextStream out = new QTextStream(file);
        out.writeString(exportToXML().toString());
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
        int dif = maxTime().hour() - time.hour();
        for (int i = 0; i <= dif; i++) {
            QDomElement hourE = doc.createElement("hour");

            int diff = 12;
            if (i == dif) {
                diff = 10;
            }
            hourE.setAttribute("pdiff", 80 / dif);
            hourE.setAttribute("diff", diff);

            hourE.appendChild(doc.createTextNode(time.addSecs(3600 * i).toString("hh:mm")));

            hoursE.appendChild(hourE);
        }

        // creates element "days"
        QDomElement daysE = doc.createElement("days");
        rootElement.appendChild(daysE);
/*
        List<Term> terms = new ArrayList<Term>();
        for (Course course : courses) {
            if(course.getLectureVisibility()) terms.addAll(course.getLecture().getTerms());
            terms.add(course.getSeminar().getChosen());
        }

        for (int d = 0; d < 7; d++) {
            if (dayInTerms(Days.values()[d], terms)) {
                QDomElement dayE = doc.createElement("day");

                dayE.setAttribute("id", "" + Days.values()[d]);
                dayE.setAttribute("rows", 1);   // max num z kolizi - prepsat ked bude priznak

                for (int r = 1; r <= 1; r++) {   //pocet kolizi - radku
                    QDomElement rowE = doc.createElement("row");
                    rowE.setAttribute("num", r);

                    for (Term term : terms) {
                        //(cislokolize==r)
                        if ((term.getDay() == Days.values()[d])) {
                            QDomElement cellE = doc.createElement("cell");
                            Course course = new Course("", "", new BigInteger("0"));
                            for (Course c : courses) {
                                if (c.getSeminar().getChosen().equals(term) || c.getLecture().getTerms().contains(term)) {
                                    course = c;
                                }
                            }

                            QDomElement courseE = doc.createElement("course");
                            
                            if(QVariant.toBoolean(settings.value("export/color"))) {
                                String color = "";
                                if(course.getSeminar().getChosen().equals(term)) color = "d5f9d2";
                                if(course.getLecture().getTerms().contains(term)) color = "f9d5c5";
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
                            if (course.getSeminar().getChosen().equals(term)) {
                                code = code + "/" + course.getSeminar().getChosen().getGroupNum();
                            }
                            codeE.appendChild(doc.createTextNode(code));
                            courseE.appendChild(codeE);

                            // course name
                            QDomElement nameE = doc.createElement("name");
                            nameE.appendChild(doc.createTextNode(course.getName()));
                            courseE.appendChild(nameE);

                            // lecture teacher
                            QDomElement teacherE = doc.createElement("teacher");
                            teacherE.appendChild(doc.createTextNode(term.getTeacher().getName()));

                            // if user wants URL to Person page in IS
                            if (QVariant.toBoolean(settings.value("export/teacher"))) {
                                teacherE.setAttribute("id", "" + term.getTeacher().getTeacherId());
                            }
                            courseE.appendChild(teacherE);

                            // list of rooms, where the course is taught
                            QDomElement roomsE = doc.createElement("rooms");
                            for (Room room : term.getRooms()) {
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
                        }
                    }
                    dayE.appendChild(rowE);
                }
                daysE.appendChild(dayE);
            }
        }
*/
        return doc;
    }

    /**
     * Finds out the courses minimal time
     *
     * @return minimum of course times
     */
    private QTime minTime() {
        QTime min = new QTime(23, 0);
        /*for (Course course : courses) {

            for (Term term : course.getLecture().getTerms()) {
                QTime tmp = term.getTimeFrom();
                if (tmp.hour() < min.hour()) {
                    min = tmp;
                }
            }
        }*/
        return min;
    }

    /**
     * Finds out the courses maximal time
     *
     * @return maximum of course times
     */
    private QTime maxTime() {
        QTime max = new QTime(6, 0);
        /*for (Course course : courses) {
            QTime tmp = course.getLecture().getTerms().get(0).getTimeFrom();
            if (tmp.hour() > max.hour()) {
                max = tmp;
            }
        }*/
        return max;
    }

    /**
     * Finds out if there is any term in the given day
     *
     * @param day asked day
     * @param terms list of terms
     * @return true if there is at least one term in the given day
     */
    private Boolean dayInTerms(Days day, List<Term> terms) {
        for (Term term : terms) {
            if (term.getDay() == day) {
                return true;
            }
        }
        return false;
    }
}
