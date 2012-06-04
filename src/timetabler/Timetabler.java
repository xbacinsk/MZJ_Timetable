package timetabler;

import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QResizeEvent;
import java.util.List;
import timetabler.entities.Course;
import timetabler.exceptions.MissingLoginException;
import timetabler.ui.Ui_MainWindow;

public class Timetabler extends QMainWindow{
  
    private Ui_MainWindow ui = new Ui_MainWindow();    
        
    public Timetabler()
    {
        ui.setupUi(this);
        
        ui.actionOpen_time_table_from_IS.triggered.connect(this, "loadXmlFromIs()");
    }

    public Ui_MainWindow getUi() {
        return ui;
    }

    public void setUi(Ui_MainWindow ui) {
        this.ui = ui;
    }  
    
    @Override
    protected void resizeEvent(QResizeEvent qre) {
        qre.size().setHeight(ui.centralwidget.height() - 100);
        qre.size().setWidth(ui.centralwidget.width() / 4);
        super.resizeEvent(qre);
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
    
    public void xmlDataAvailable(List<Course> courses){
        /**
         * sem prichadzaju data z parsera...kod je len na otestovanie treba ho zmenit!!..ale to asi vidit :D
         */
        for(Course course : courses){
            System.out.println(course.toString());
        }
    }
}    