package timetabler;

import com.trolltech.qt.core.QCoreApplication;
import com.trolltech.qt.gui.QApplication;
import timetabler.ui.Ui_MainWindow;

public class Main{
       
    public static void main(String args[]){
            QApplication.initialize(args);

            //need to be filled for QSettings usage
            QCoreApplication.setOrganizationName("MZJ");
            QCoreApplication.setOrganizationDomain("mzj.net");
            QCoreApplication.setApplicationName("Timetabler");
            
            Timetabler timetabler = new Timetabler();                       

            timetabler.show();  
            
            QApplication.exec();
            
    }
    
}
 