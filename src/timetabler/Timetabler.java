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
    private List<Course> outputContainer = new ArrayList<Course>();

    public Timetabler() {
        ui.setupUi(this);

        ui.actionOpen_time_table_from_IS.triggered.connect(this, "loadXmlFromIs()");
        ui.actionOpen_time_table_from_PC.triggered.connect(this, "loadXmlFromFile()");
        ui.actionExit.triggered.connect(QApplication.instance(), "quit()");

        ui.listWidget.itemClicked.connect(this, "courseClicked(QListWidgetItem)");
        ui.listWidget.itemDoubleClicked.connect(this, "courseDoubleClicked(QListWidgetItem)");

        ui.checkBox.stateChanged.connect(this, "hideLecturesCheckBoxClicked(Integer)");        
    }

    public void weekendGUI(boolean b) {
        ui.weekendGUI(this, b);
    }

    public void initializeGUI(Timetabler tt) {

//        ui.label_46.hide();
//        ui.label_48.hide();
//        ui.saturdayBox.hide();
//        ui.sundayBox.hide();

        weekendGUI(false);

    }

    public void courseClicked(QListWidgetItem item) {
        Course course = (Course) item;
        System.out.println("courseClicked: " + course);
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
        for (Course course : inputContainer) {
            ui.listWidget.addItem(course);
            course.optionsChanged.connect(this, "updateCourseOptions(Course)");
            course.removeLectureRequest.connect(this, "removeLecture(Course)");
            course.removeSeminarRequest.connect(this, "removeSeminar(Seminar)");

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
                    int lectureHeight = 60;
                    int lectureY = 5;
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
                    lecture.setGeometry(lectureX, lectureY, lectureLength, lectureHeight);
                    lecture.setText(lecture.getCourse().getCode());
                    lecture.setStyleSheet("background-color: rgb(108, 220, 100);\n" + "border-color: rgb(0, 0, 0);");
                    lecture.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.Box);
                    lecture.setAlignment(Qt.AlignmentFlag.AlignCenter);
                    lecture.show();

                    System.out.println(lecture.getCourse().getCode() + " " + lectureX + " " + lectureLength);

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

    public void loadXmlFromIs() {
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
//        for(Course course : courses){
//            System.out.println(course.toString());
//        }
        inputContainer.addAll(courses);
        loadCourses();
        initializeGUI(this);
    }
}
