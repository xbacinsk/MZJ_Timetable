package timetabler;

import com.trolltech.qt.core.QByteArray;
import com.trolltech.qt.core.QFile;
import com.trolltech.qt.gui.QFileDialog;
import com.trolltech.qt.gui.QMainWindow;
import java.util.ArrayList;
import java.util.List;
import timetabler.entities.Course;
import timetabler.exceptions.MissingLoginException;
import timetabler.ui.Ui_MainWindow;

public class Timetabler extends QMainWindow{
  
    private Ui_MainWindow ui = new Ui_MainWindow();
    private List<Course> inputContainer = new ArrayList<Course>();
    private List<Course> outputContainer = new ArrayList<Course>();
      
    
        
    public Timetabler()
    {
        ui.setupUi(this);
        
        ui.actionOpen_time_table_from_IS.triggered.connect(this, "loadXmlFromIs()");
        ui.actionOpen_time_table_from_PC.triggered.connect(this, "loadXmlFromFile()");
    }
    
    public void weekendGUI(boolean b) {
        ui.weekendGUI(this, b);
    }
    
    public void initializeGUI(Timetabler tt){
        
        ui.label_46.hide();
        ui.label_48.hide();
        ui.saturdayBox.hide();
        ui.sundayBox.hide();
            
        weekendGUI(false);   
        
    }
    
    public void loadCourses(){
            Ui_MainWindow ui = this.getUi();
            
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

    public Ui_MainWindow getUi() {
        return ui;
    }

    public void setUi(Ui_MainWindow ui) {
        this.ui = ui;
    } 
    
    public void loadXmlFromIs(){
        Downloader d = new Downloader();
        Parser p = new Parser();
        
        d.xmlReady.connect(p, "readXml(QByteArray)");
        p.dataAvailable.connect(this, "xmlDataAvailable(List)");
        
        try{
            d.downloadTimetable();
        }catch(MissingLoginException ex){
            System.err.println(ex.toString());
        }
    }
    
    public void loadXmlFromFile(){
        String fileName = QFileDialog.getOpenFileName(this, tr("Open file"), ".", new QFileDialog.Filter(tr("XML files (*.xml)")));
        if(fileName == null || fileName.isEmpty())
            return;
        
        QFile file = new QFile(fileName);
        file.open(QFile.OpenModeFlag.ReadOnly);
        QByteArray ba = file.readAll();
        
        Parser p = new Parser();
        p.dataAvailable.connect(this, "xmlDataAvailable(List)");
        p.readXml(ba);        
    }
    
    public void xmlDataAvailable(List<Course> courses){
        /**
         * sem prichadzaju data z parsera...kod je len na otestovanie treba ho zmenit!!..ale to asi vidit :D
         */
        for(Course course : courses){
            System.out.println(course.toString());
        }
    }
}    