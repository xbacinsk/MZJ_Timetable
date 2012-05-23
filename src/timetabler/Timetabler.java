package timetabler;

import com.trolltech.qt.gui.QMainWindow;
import timetabler.ui.Ui_MainWindow;

public class Timetabler extends QMainWindow{
  
    private Ui_MainWindow ui = new Ui_MainWindow();    
        
    public Timetabler()
    {
        ui.setupUi(this);
    }

    public Ui_MainWindow getUi() {
        return ui;
    }

    public void setUi(Ui_MainWindow ui) {
        this.ui = ui;
    }   
    
}    