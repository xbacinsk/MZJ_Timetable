package timetabler;

import com.trolltech.qt.core.QByteArray;
import com.trolltech.qt.core.QFile;
import com.trolltech.qt.core.QIODevice;
import com.trolltech.qt.core.QObject;
import java.util.List;
import timetabler.entities.Course;

/**
 * Creates XML file from list of Course objects 
 * 
 * @author Lenka Bacinska
 * @version 2012-05-05
 */
public class Exporter extends QObject{
    
    private List<Course> courses;

    /**
     * Writes a XML file
     */
    public void writeXML(List<Course> courses) {
        this.courses = courses;
        
        QFile file = new QFile("misc/timetable.xml");
        file.open(QIODevice.OpenModeFlag.WriteOnly);
        
        file.write(exportToXML());
        
        file.close();
    }
    
    /**
     * Exports XML from given list of courses
     * 
     * @return XML in QByteArray form
     */
    private QByteArray exportToXML() {
        QByteArray data = new QByteArray("");
        
        // testing data
        data.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        data.append("<?xml-stylesheet type=\"text/xsl\" href=\"timetable.xsl\"?>");
        data.append("<timetable xsi:noNamespaceSchemaLocation=\"timetable.xsd\" "
                + "xmlns=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
        data.append("<a/><b>Timetabler</b></timetable>");
        
        return data;
    }
}
