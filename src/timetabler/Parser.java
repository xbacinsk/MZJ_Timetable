package timetabler;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.QMessageBox;
import com.trolltech.qt.xmlpatterns.QXmlItem;
import com.trolltech.qt.xmlpatterns.QXmlQuery;
import com.trolltech.qt.xmlpatterns.QXmlResultItems;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import timetabler.entities.*;
import timetabler.exceptions.InvalidQueryException;
import timetabler.exceptions.InvalidXmlDataException;
import timetabler.exceptions.ParsingException;

/**
 * Parses xml timetable and creates Course objects.
 *
 * Receives a signal from downloader and stores its data. Evaluates xquery
 * (stored in conf/timetableQuery.xq) on xml data. Parses returned data and
 * stores them into Course objects. When done emits signal with list of parsed
 * Course objects.
 *
 * @author Michal Kimle
 * @version 2012-06-04
 */
public class Parser extends QObject {

    private QByteArray xml;
    public final Signal1<List<Course>> dataAvailable = new Signal1<List<Course>>();

    /**
     * SLOT
     *
     * Reads xml from QByteArray
     *
     * @param ba xml in form of QByteArray
     */
    public void readXml(QByteArray ba) {
        xml = ba;
        try {
            parseXml();
        } catch (ParsingException ex) {
            QMessageBox.StandardButtons buttons = new QMessageBox.StandardButtons();
            buttons.set(QMessageBox.StandardButton.Close);
            QMessageBox box = new QMessageBox(QMessageBox.Icon.Critical, "Parsing error",ex.getMessage(), buttons);
            box.exec();
        }
    }

    /**
     * Parses xml and creates Course objects
     *
     * @throws InvalidQueryException
     */
    private void parseXml() throws InvalidQueryException, InvalidXmlDataException {
        List<Course> courses = new ArrayList<Course>();

        QBuffer buffIn = new QBuffer(xml);
        buffIn.open(QIODevice.OpenModeFlag.ReadOnly);

        QFile file = new QFile("conf/timetableQuery.xq");
        file.open(QIODevice.OpenModeFlag.ReadOnly);

        QXmlQuery qry = new QXmlQuery();
        qry.bindVariable("inputDocument", buffIn);
        qry.setQuery(file);

        if (!qry.isValid()) {
            throw new InvalidQueryException("Invalid xquery");
        }

        QXmlResultItems results = new QXmlResultItems();
        qry.evaluateTo(results);

        QXmlItem item = new QXmlItem(results.next());
        if (item.isNull()) {
            throw new InvalidXmlDataException("Invalid XML data\n" + "Make sure you are using XML file created by IS with options \"včetně všech seminářů zobrazovaných předmětů\" and \"vypisovat i učitele\"");
        }
        while (!item.isNull()) {
            //for each item

            String[] fields = item.toAtomicValue().toString().split("@");
            if(fields.length != 9 && fields.length != 8){
                throw new InvalidXmlDataException("Invalid XML data\n" + "Make sure you are using XML file created by IS with options \"včetně všech seminářů zobrazovaných předmětů\" and \"vypisovat i učitele\"");
            }

            //parsing teacher
            String[] teacherInfo = fields[7].split("#");
            Teacher teacher = new Teacher(teacherInfo[1], new BigInteger(teacherInfo[0]));

            //parsing rooms
            List<Room> rooms = new ArrayList<Room>();
            String[] roomsInfo = fields[3].split("#");
            int i = 0;
            while (i < roomsInfo.length) {
                Room room = new Room(roomsInfo[i + 1], new BigInteger(roomsInfo[i]));
                rooms.add(room);
                i += 2;
            }

            //language control for day names
            QLocale locale;
            if (fields[0].length() == 2) {
                locale = new QLocale(QLocale.Language.Czech, QLocale.Country.CzechRepublic);
            } else {
                locale = new QLocale(QLocale.Language.English, QLocale.Country.UnitedStates);
            }

            //parsing course
            Course course;
            String[] courseInfo = fields[4].split("/");

            //its a seminar
            if (courseInfo.length == 2) {
                int groupNum = Integer.parseInt(courseInfo[1]);
                Seminar seminar = new Seminar(teacher, Days.values()[locale.toDate(fields[0], "ddd").dayOfWeek() - 1],
                        QTime.fromString(fields[1], "hh:mm"),
                        QTime.fromString(fields[2], "hh:mm"),
                        rooms, groupNum, null);

                //check for comments
                if (fields.length == 9 && !fields[8].isEmpty()) {
                    String[] comments = fields[8].split("#");
                    StringBuilder builder = new StringBuilder();
                    for(String comment : comments){
                        builder.append(comment);
                        builder.append('\n');
                    }
                    builder.deleteCharAt(builder.length()-1);

                    seminar.setToolTip(builder.toString());
                }

                course = getCourse(courses, new BigInteger(fields[6]));

                if (course == null){
                    course = new Course(courseInfo[0], fields[5], new BigInteger(fields[6]));
                    courses.add(course);
                }
                    
                if (course.getSeminars() == null) {
                    List<Seminar> seminars = new ArrayList<Seminar>();
                    course.setSeminars(seminars);
                }

                seminar.setCourse(course);
                course.getSeminars().add(seminar);
                seminar.requestSettings.connect(course, "showSettings()");
                seminar.requestRemoval.connect(course, "removeSeminar(Seminar)");
//                seminar.requestChoose.connect(course, "chooseSeminar(Seminar)");

                //its a lecture
            } else {
                Lecture lecture = new Lecture(teacher, Days.values()[locale.toDate(fields[0], "ddd").dayOfWeek() - 1],
                        QTime.fromString(fields[1], "hh:mm"),
                        QTime.fromString(fields[2], "hh:mm"),
                        rooms, null);
                
                //check for comments
                if (fields.length == 9 && !fields[8].isEmpty()) {
                    String[] comments = fields[8].split("#");
                    StringBuilder builder = new StringBuilder();
                    for(String comment : comments){
                        builder.append(comment);
                        builder.append('\n');
                    }
                    builder.deleteCharAt(builder.length()-1);

                    lecture.setToolTip(builder.toString());
                }

                course = getCourse(courses, new BigInteger(fields[6]));
                if (course == null){ 
                    course = new Course(courseInfo[0], fields[5], new BigInteger(fields[6]));
                    courses.add(course);
                }
                
                if (course.getLectures() == null){
                    List<Lecture> lectures = new ArrayList<Lecture>();
                    course.setLectures(lectures);
                }
                
                lecture.setCourse(course);
                course.getLectures().add(lecture);
                lecture.requestSettings.connect(course, "showSettings()");
                lecture.requestRemoval.connect(course, "removeLecture()");
            }

            item = results.next();
        }

        buffIn.close();
        file.close();
        dataAvailable.emit(courses);
    }

    /**
     * Returns Course with given id from given list
     * 
     * @param courses list of courses to search in
     * @param courseId course id to search for
     * @return course with given id
     */
    Course getCourse(List<Course> courses, BigInteger courseId) {
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                return course;
            }
        }

        return null;
    }
}
