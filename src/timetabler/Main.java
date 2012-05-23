package timetabler;

import com.trolltech.qt.core.QCoreApplication;
import com.trolltech.qt.core.QDate;
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
    
    public static void resizeAction(Timetabler tt){
        Ui_MainWindow gui = tt.getUi();
        gui.listWidget.setBaseSize((gui.centralwidget.width() / 4), (gui.centralwidget.width() - 100));        
    }
    
    public static void main(String args[]){
            QApplication.initialize(args);

            //need to be filled for QSettings usage
            QCoreApplication.setOrganizationName("MZJ");
            QCoreApplication.setOrganizationDomain("mzj.net");
            QCoreApplication.setApplicationName("Timetabler");
            
            Timetabler timetabler = new Timetabler();
            timetabler.show();            

            inputContainer.add(new Course("SOC103", "Obecné sociologické teorie", new BigInteger("123")));
            inputContainer.add(new Course("SOC106", "Metodologie sociálních věd", new BigInteger("234")));
            inputContainer.add(new Course("SOC109", "Demografie", new BigInteger("345")));
            inputContainer.add(new Course("PB138   ", "Moderní značkovací jazyky", new BigInteger("456")));
            inputContainer.add(new Course("PV174   ", "LEMMA", new BigInteger("567")));

            loadCourses(timetabler);
            
            initializeGUI(timetabler);
            
            QApplication.exec();
                       
            //timetabler.getUi().actionResizeWindow.triggered.
            
     }  
}
 