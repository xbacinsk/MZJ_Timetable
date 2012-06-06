package timetabler;

import com.trolltech.qt.core.QCoreApplication;
import com.trolltech.qt.core.QRect;
import com.trolltech.qt.core.QSize;
import com.trolltech.qt.core.QTime;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QLabel;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import timetabler.entities.*;
import timetabler.ui.Ui_MainWindow;

public class Main{
    
    private static List<Course> inputContainer = new ArrayList<Course>();
    private static List<Course> outputContainer = new ArrayList<Course>();
      
    public static void loadCourses(Timetabler tt){
            Ui_MainWindow ui = tt.getUi();
            
            for (Course course : inputContainer){
                ui.listWidget.addItem(course.getCode() + "  " + course.getName());                               
            }
            
//            QLabel label = new QLabel(ui.mondayBox);
//            label.setGeometry(new QRect(5, 5, 20, 20));
//            label.setObjectName(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "label", null));
//            label.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "LABELLABELLABEL", null));
//            label.setMinimumSize(new QSize(40, 10));

            //label.setObjectName("PB168_label");
//            ui.horizontalLayout_2.addWidget(
//            ui.mondayBox.repaint();
            
//            for (int i = 0; i <= 0; i++){
//            QLabel label = new QLabel(ui.mondayBox);
//            label.setGeometry((i * labelW) + 5, labelH, 80, 80);
//            label.setMinimumSize(new QSize(40, 40));
//            label.setText(String.valueOf(ui.mondayBox.geometry().size()));
//            label.setObjectName(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "lecture"+i, null));
//            label.setStyleSheet("QLabel { background-color : black; color : white; }");
//            }
            
        }
    
    public static void initializeGUI(Timetabler tt){
        Ui_MainWindow ui = tt.getUi();
        
//        ui.label_46.hide();
//        ui.label_48.hide();
//        ui.saturdayBox.hide();
//        ui.sundayBox.hide();
            
        //tt.weekendGUI(false);   
        
    }   
    
    public static void main(String args[]){
            QApplication.initialize(args);

            //need to be filled for QSettings usage
            QCoreApplication.setOrganizationName("MZJ");
            QCoreApplication.setOrganizationDomain("mzj.net");
            QCoreApplication.setApplicationName("Timetabler");
            
            Timetabler timetabler = new Timetabler();                       

            //filler();
            loadCourses(timetabler);           
            timetabler.show();  
            
            QApplication.exec();
            
    }
    
    /* zakomentovane len na testovacie ucely..ale mam pocit ze to aj tka pojde prec, ze
     *
    public static void filler(){
        Term term1 = new Term(new Teacher("Csaba Szalo", new BigInteger("12456")), Days.MON, new QTime(14, 0), new QTime(16, 0), new Room("D3", new BigInteger("123")), 1);
        Lecture lecture1 = new Lecture(term1);
        Course course1 = new Course("SOC103", "Obecné sociologické teorie", new BigInteger("123"),lecture1,null);
        
        Term term2 = new Term(new Teacher("Hejkal Brandorad", new BigInteger("13579")), Days.THU, new QTime(8, 0), new QTime(12, 0), new Room("D1", new BigInteger("3")), 1);
        Lecture lecture2 = new Lecture(term2);
        Course course2 = new Course("SOC106", "Metodologie sociálních věd", new BigInteger("234"),lecture2,null);
        
        Course course3 = new Course("SOC109", "Demografie", new BigInteger("345"),null,null);
        Course course4 = new Course("PB138   ", "Moderní značkovací jazyky", new BigInteger("456"),null,null);
        Course course5 = new Course("PV174   ", "LEMMA", new BigInteger("567"),null,null);
        
        inputContainer.add(course1);
        inputContainer.add(course2);
        inputContainer.add(course3);
        inputContainer.add(course4);
        inputContainer.add(course5);
        
        
    }*/
    
}
 