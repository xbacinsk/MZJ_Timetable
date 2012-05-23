package timetabler;

import com.trolltech.qt.core.QCoreApplication;
import com.trolltech.qt.core.QTime;
import com.trolltech.qt.gui.QApplication;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import timetabler.entities.*;
import timetabler.ui.Ui_MainWindow;

public class Main{
    
    private static List<Course> inputContainer = new ArrayList<Course>();
    private static List<Course> outputContainer = new ArrayList<Course>();
    
    private static int labelWidth;
    private static int labelHeigth;
  
    public static void loadCourses(Timetabler tt){
            for (Course course : inputContainer){
                tt.getUi().listWidget.addItem(course.getCode() + "  " + course.getName());
            }
        }
    
    public static void initializeGUI(Timetabler tt){
        Ui_MainWindow gui = tt.getUi();
        
        gui.centralwidget.setBaseSize(845,390);
        
        gui.centralwidget.setMinimumWidth(845);
        gui.centralwidget.setMinimumHeight(390);       
    }   
    
    public static void main(String args[]){
            QApplication.initialize(args);

            //need to be filled for QSettings usage
            QCoreApplication.setOrganizationName("MZJ");
            QCoreApplication.setOrganizationDomain("mzj.net");
            QCoreApplication.setApplicationName("Timetabler");
            
            Timetabler timetabler = new Timetabler();
            timetabler.show();             

            loadCourses(timetabler);
            
            //initializeGUI(timetabler);
            
            QApplication.exec();
            
    }
    
    public static void filler(){
        Course course1 = new Course("SOC103", "Obecné sociologické teorie", new BigInteger("123"));
        List<Term> terms1 = new ArrayList<Term>();
        terms1.add(new Term(new Teacher("Csaba Szalo", new BigInteger("12456")), Days.MON, new QTime(14, 0), new QTime(16, 0), new Room("D3", new BigInteger("123")), 1));
        Lecture lecture1 = new Lecture(terms1);
        
        Course course2 = new Course("SOC106", "Metodologie sociálních věd", new BigInteger("234"));
        Course course3 = new Course("SOC109", "Demografie", new BigInteger("345"));
        Course course4 = new Course("PB138   ", "Moderní značkovací jazyky", new BigInteger("456"));
        Course course5 = new Course("PV174   ", "LEMMA", new BigInteger("567"));
        
        inputContainer.add(course1);
        inputContainer.add(course2);
        inputContainer.add(course3);
        inputContainer.add(course4);
        inputContainer.add(course5);
        
        
    }
    
}
 