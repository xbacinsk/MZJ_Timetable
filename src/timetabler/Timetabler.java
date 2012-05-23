package timetabler;

import com.trolltech.qt.core.QCoreApplication;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;
import timetabler.entities.*;
import timetabler.ui.Ui_MainWindow;

public class Timetabler extends QMainWindow{
  
    private Ui_MainWindow ui = new Ui_MainWindow();
    private Course course;
        
    public Timetabler()
    {
        ui.setupUi(this);    
    }
    
    public static void main(String args[]){
        QApplication.initialize(args);
    
        //need to be filled for QSettings usage
        QCoreApplication.setOrganizationName("MZJ");
        QCoreApplication.setOrganizationDomain("mzj.net");
        QCoreApplication.setApplicationName("Timetabler");
        
        Timetabler timetabler = new Timetabler();
        timetabler.show();
    }
    
    
}    