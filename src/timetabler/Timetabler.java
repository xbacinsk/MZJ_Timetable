package timetabler;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QFileDialog;
import com.trolltech.qt.gui.QListWidgetItem;
import com.trolltech.qt.gui.QMainWindow;
import java.util.ArrayList;
import java.util.List;
import timetabler.entities.Course;
import timetabler.entities.Days;
import timetabler.entities.Lecture;
import timetabler.entities.Seminar;
import timetabler.exceptions.MissingLoginException;
import timetabler.ui.Ui_MainWindow;

public class Timetabler extends QMainWindow {

    private Ui_MainWindow ui = new Ui_MainWindow();
    private List<Course> inputContainer = new ArrayList<Course>();
    private boolean choosingMode = false;
//    private List<Course> outputContainer = new ArrayList<Course>();

    public Timetabler() {
        ui.setupUi(this);

        ui.actionOpen_time_table_from_IS.triggered.connect(this, "loadXmlFromIs()");
        ui.actionOpen_time_table_from_PC.triggered.connect(this, "loadXmlFromFile()");
        ui.actionExport_to_HTML_XML.triggered.connect(this, "exportToXml()");
        ui.actionExit.triggered.connect(QApplication.instance(), "quit()");
        ui.actionClearLoginData.triggered.connect(this, "clearLoginData()");

        ui.listWidget.itemClicked.connect(this, "courseClicked(QListWidgetItem)");
        ui.listWidget.itemDoubleClicked.connect(this, "courseDoubleClicked(QListWidgetItem)");

        ui.checkBox.stateChanged.connect(this, "hideLecturesCheckBoxClicked(Integer)");
    }

    public void weekendGUI(boolean b) {
        ui.weekendGUI(this, b);
    }

    public void initializeGUI(Timetabler tt) {
        weekendGUI(false);

    }

    public void clearLoginData() {
        QSettings settings = new QSettings();
        settings.remove("login/uco");
        settings.remove("login/pass");
        
        for (Course course : inputContainer){
            for (Lecture lecture : course.getLectures()) {
                lecture.setVisible(false);
                lecture.clear();
            }
            for (Seminar seminar : course.getSeminars()) {
                seminar.setVisible(false);
                seminar.clear();
            }
        }
        inputContainer.removeAll(inputContainer);
        
        ui.listWidget.clear();
        ui.actionOpen_time_table_from_IS.setEnabled(true);
        ui.actionOpen_time_table_from_PC.setEnabled(true);        
        
//        System.out.println("Vymazano.");        
    }

    public void courseClicked(QListWidgetItem item) {
        Course course = (Course) item;
        if (course.getSeminars() != null) {
            for (Seminar seminar : course.getSeminars()) {
                seminar.setStyleSheet("background-color: rgba(255, 31, 2, 128);\n" + "border-color: rgb(0, 0, 0);");
                seminar.setVisible(true);
                //tu sa nemaju zobrazovat vsetky ale ma to brat ohlad na tie filtre!!!...filtre tam byt musia lebo to mame v popise projektu v ISe!!
                //pokial je uz nejaky seminar vybraty a ty kliknes znova na ten predmet tak aby ten vybraty semkinar zostal vybraty
                // redraw items in collision when showing up new item!
            }
//            System.out.println("courseClicked: " + course);
            choosingMode = true;
        }
    }

    public void courseDoubleClicked(QListWidgetItem item) {
        Course course = (Course) item;
        course.showSettings();
    }

    public void updateCourseOptions(Course course) {
        System.out.println("updateCourseOptions: " + course);
    }

    public void removeLecture(Course course) {
        QSettings settings = new QSettings();
        settings.setValue(course.getCode() + "/lecture", false);

        updateCourseOptions(course);
    }

    public void removeSeminar(Seminar seminar) {
        if (!choosingMode) {
            seminar.setVisible(false);
        }
    }

    public void chooseSeminar(Seminar seminar) {
        System.out.println("Vybran seminar: " + seminar.toString());
        if (choosingMode) {
            for (Seminar sem : seminar.getCourse().getSeminars()) {
                sem.setStyleSheet("background-color: rgb(149, 236, 174);\n");
                sem.setVisible(false);
            }
            seminar.setVisible(true);
        }
        choosingMode = false;
    }

    public void hideLecturesCheckBoxClicked(Integer n) {
        QSettings settings = new QSettings();

        for (Course course : inputContainer) {
            if (n == Qt.CheckState.Checked.value()) {
                settings.setValue(course.getCode() + "/lecture", false);
            } else {
                settings.setValue(course.getCode() + "/lecture", true);
            }

            updateCourseOptions(course);
        }
    }

    public void loadCourses() {
        ui.actionOpen_time_table_from_IS.setEnabled(false);
        ui.actionOpen_time_table_from_PC.setEnabled(false);

        Collisions cls = new Collisions();
        List<Lecture> lec = new ArrayList<Lecture>();
        List<Seminar> sem = new ArrayList<Seminar>();

        for (Course course : inputContainer) {
            ui.listWidget.addItem(course);
            course.optionsChanged.connect(this, "updateCourseOptions(Course)");
            course.removeLectureRequest.connect(this, "removeLecture(Course)");
            course.removeSeminarRequest.connect(this, "removeSeminar(Seminar)");

//            System.out.println(course.getName());

            if (course.getLectures() != null) {
                for (Lecture lecture : course.getLectures()) {
                    Days day = lecture.getDay();
                    int lectureLength = lecture.getLength();
                    /*
                    * Tady by měla být funkce, která určí výšku lectureHeight
                    * podle toho, jeslti se náhodou nepřekrývá s jiným
                    * předmětem. 0 / 1 / 2 překryté 60 / 30 / 20 px
                    *
                    * Podle toho by mělo být i nastavené lectureY. 5 / 35 / 45
                    * px
                    *
                    */
                    int max = 0;
                    int lectureY = 0;
                    int lectureHeight = 0;

                    lec = cls.Lecturedetection(lecture, inputContainer);
                    sem = cls.Seminardetection(lecture, inputContainer);

                    if (lec.isEmpty() && sem.isEmpty()) {
                        lectureHeight = 60;
                        lectureY = 5;
                        lecture.setPosition(1);
                    } else if (lec.isEmpty() && !sem.isEmpty()) {
                        for (Seminar s : sem) {
                            if (s.isVisible() && max < s.getPosition()) {
                                max = s.getPosition();
                            }
                        }
                        max++;
                        lectureY = cls.gui_y(max);
                        lectureHeight = cls.gui_height(max);
                        lecture.setPosition(max);
                    } else if (!lec.isEmpty() && sem.isEmpty()) {
                        for (Lecture s : lec) {
                            if (max < s.getPosition()) {
                                max = s.getPosition();
                            }
                        }
                        max++;
                        lectureY = cls.gui_y(max);
                        lectureHeight = cls.gui_height(max);
                        lecture.setPosition(max);
                    } else if (!lec.isEmpty() && !sem.isEmpty()) {
                        for (Lecture s : lec) {
                            if (max < s.getPosition()) {
                                max = s.getPosition();
                            }
                        }
                        for (Seminar s : sem) {
                            if (s.isVisible() && max < s.getPosition()) {
                                max = s.getPosition();
                            }
                        }
                        max++;
                        lectureY = cls.gui_y(max);
                        lectureHeight = cls.gui_height(max);
                        lecture.setPosition(max);
                    }

                    int lectureX = lecture.getTimeFrom().secsTo(new QTime(7, 0)) / -60;

                    switch (day) {
                        case MON:
                            lecture.setParent(ui.mondayBox);
                            break;
                        case TUE:
                            lecture.setParent(ui.tuesdayBox);
                            break;
                        case WED:
                            lecture.setParent(ui.wednesdayBox);
                            break;
                        case THU:
                            lecture.setParent(ui.thursdayBox);
                            break;
                        case FRI:
                            lecture.setParent(ui.fridayBox);
                            break;
                        case SAT:
                            lecture.setParent(ui.saturdayBox);
                            break;
                        case SUN:
                            lecture.setParent(ui.sundayBox);
                            break;

                    }
                    
                    switch (lecture.getPosition()) {
                        case 1: 
                            lecture.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+"p, li { white-space: pre-wrap; }\n"+"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">"+ lecture.getCourse().getCode() +"</span></p>\n"+"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">" + lecture.getCourse().getTeachers().get(0) + "</span></p>\n"+"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:7pt; text-decoration: underline;\">" + lecture.getRooms() + "</span></p></body></html>", null));
                            break;
                        case 2: 
                            lecture.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+"p, li { white-space: pre-wrap; }\n"+"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">"+ lecture.getCourse().getCode() +"</span></p>\n"+"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">" + lecture.getCourse().getTeachers().get(0) + "</span></p></body></html>", null));
                            break;
                        case 3: 
                            lecture.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+"p, li { white-space: pre-wrap; }\n"+"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">"+ lecture.getCourse().getCode() +"</span></p></body></html>", null));
                            break;
                    }
                    
                    lecture.setGeometry(lectureX, lectureY, lectureLength, lectureHeight);
                    lecture.setStyleSheet("background-color: rgb(108, 220, 100);\n" + "border-color: rgb(0, 0, 0);");
                    lecture.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.Box);
                    lecture.setAlignment(Qt.AlignmentFlag.AlignCenter);
                    lecture.setVisible(true);
                }
            }
            if (course.getSeminars() != null) {
                for (Seminar seminar : course.getSeminars()) {
                    Days day = seminar.getDay();
                    int seminarLength = seminar.getLength();
                    /*
                    * Tady by měla být funkce, která určí výšku lectureHeight
                    * podle toho, jeslti se náhodou nepřekrývá s jiným
                    * předmětem. 0 / 1 / 2 překryté 60 / 30 / 20 px
                    *
                    * Podle toho by mělo být i nastavené lectureY. 5 / 35 / 45
                    * px
                    *
                    */
                    int seminarHeight = 60;
                    int seminarY = 5;
                    int max = 0;
                    lec = cls.Lecturedetection(seminar, inputContainer);
                    sem = cls.Seminardetection(seminar, inputContainer);

                    if (lec.isEmpty() && sem.isEmpty()) {
                        seminarHeight = 60;
                        seminarY = 5;
                        seminar.setPosition(1);
                    } else if (lec.isEmpty() && !sem.isEmpty()) {
                        for (Seminar s : sem) {
                            if (max < s.getPosition()) {
                                max = s.getPosition();
                            }
                        }
                        max++;
                        seminarHeight = cls.gui_height(max);
                        seminarY = cls.gui_y(max);
                        seminar.setPosition(max);
                    } else if (!lec.isEmpty() && sem.isEmpty()) {
                        for (Lecture s : lec) {
                            if (max < s.getPosition()) {
                                max = s.getPosition();
                            }
                        }
                        max++;
                        seminarHeight = cls.gui_height(max);
                        seminarY = cls.gui_y(max);
                        seminar.setPosition(max);
                    } else if (!lec.isEmpty() && !sem.isEmpty()) {
                        for (Lecture s : lec) {
                            if (max < s.getPosition()) {
                                max = s.getPosition();
                            }
                        }
                        for (Seminar s : sem) {
                            if (max < s.getPosition()) {
                                max = s.getPosition();
                            }
                        }
                        max++;
                        seminarHeight = cls.gui_height(max);
                        seminarY = cls.gui_y(max);
                        seminar.setPosition(max);
                    }
                    int seminarX = seminar.getTimeFrom().secsTo(new QTime(7, 0)) / -60;

                    switch (day) {
                        case MON:
                            seminar.setParent(ui.mondayBox);
                            break;
                        case TUE:
                            seminar.setParent(ui.tuesdayBox);
                            break;
                        case WED:
                            seminar.setParent(ui.wednesdayBox);
                            break;
                        case THU:
                            seminar.setParent(ui.thursdayBox);
                            break;
                        case FRI:
                            seminar.setParent(ui.fridayBox);
                            break;
                        case SAT:
                            seminar.setParent(ui.saturdayBox);
                            break;
                        case SUN:
                            seminar.setParent(ui.sundayBox);
                            break;

                    }
                    seminar.setGeometry(seminarX, seminarY, seminarLength, seminarHeight);
                    switch (seminar.getPosition()) {
                        case 1: 
                            seminar.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+"p, li { white-space: pre-wrap; }\n"+"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">"+ seminar.getCourse().getCode() +"</span></p>\n"+"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">" + seminar.getGroupNum() + "</span></p>\n"+"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">Tulajova</span></p>\n"+"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:7pt; text-decoration: underline;\">" + seminar.getRooms() + "</span></p></body></html>", null));
                            break;
                        case 2: 
                            seminar.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+"p, li { white-space: pre-wrap; }\n"+"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">"+ seminar.getCourse().getCode() +"</span></p>\n"+"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">" + seminar.getCourse().getTeachers().get(0) + "</span></p></body></html>", null));
                            break;
                        case 3: 
                            seminar.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+"p, li { white-space: pre-wrap; }\n"+"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">"+ seminar.getCourse().getCode() +"</span></p></body></html>", null));
                            break;
                    }
                    seminar.setStyleSheet("background-color: rgb(149, 236, 174);\n" + "border-color: rgb(0, 0, 0);");
                    seminar.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.Box);
                    seminar.setAlignment(Qt.AlignmentFlag.AlignCenter);
                    seminar.setVisible(false);
                }
            }
        }
    }

    public Ui_MainWindow getUi() {
        return ui;
    }

    public void setUi(Ui_MainWindow ui) {
        this.ui = ui;
    }
    
    private void clearSettings(){
        QSettings settings = new QSettings();

        if (settings.contains("login/uco") && settings.contains("login/pass")) {
            String uco = settings.value("login/uco", "").toString();
            String pass = settings.value("login/pass", "").toString();
            settings.clear();
            settings.setValue("login/uco", uco);
            settings.setValue("login/pass", pass);
        } else {
            settings.clear();
        }
    }

    public void loadXmlFromIs() {
        clearSettings();

        Downloader d = new Downloader();
        Parser p = new Parser();

        d.xmlReady.connect(p, "readXml(QByteArray)");
        p.dataAvailable.connect(this, "xmlDataAvailable(List)");

        try {
            d.downloadTimetable();
        } catch (MissingLoginException ex) {
            System.err.println(ex.toString());
        }
    }

    public void loadXmlFromFile() {
        clearSettings();
        
        String fileName = QFileDialog.getOpenFileName(this, tr("Open file"), ".", new QFileDialog.Filter(tr("XML files (*.xml)")));
        if (fileName == null || fileName.isEmpty()) {
            return;
        }

        QFile file = new QFile(fileName);
        file.open(QFile.OpenModeFlag.ReadOnly);
        QByteArray ba = file.readAll();

        Parser p = new Parser();
        p.dataAvailable.connect(this, "xmlDataAvailable(List)");
        p.readXml(ba);
    }

    public void xmlDataAvailable(List<Course> courses) {
        /**
         * sem prichadzaju data z parsera...kod je len na otestovanie treba ho
         * zmenit!!..ale to asi vidit :D
         */
        inputContainer.addAll(courses);
        loadCourses();
        initializeGUI(this);
    }

    public void exportToXml() {
        Exporter exp = new Exporter(inputContainer);
        exp.writeXML();
    }
}
