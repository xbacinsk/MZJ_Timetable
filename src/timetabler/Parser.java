package timetabler;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.QMessageBox;
import com.trolltech.qt.xmlpatterns.QXmlQuery;
import com.trolltech.qt.xmlpatterns.QXmlResultItems;
import java.util.ArrayList;
import java.util.List;
import timetabler.entities.Course;
import timetabler.exceptions.InvalidQueryException;

/**
 * Parses xml timetable and creates Course objects.
 * 
 * Receives a signal from downloader and stores its data. Evaluates 
 * xquery (stored in conf/timetableQuery.xq) on xml data. Parses returned data 
 * and stores them into Course objects. When done emits signal with list of 
 * parsed Course objects.
 * 
 * @author Michal Kimle
 * @version 2012-05-04
 */
public class Parser extends QObject{
  private QByteArray xml;
  public final Signal1<List<Course>> dataAvailable = new Signal1<List<Course>>();
  
  /**
   * SLOT
   * 
   * Reads xml from QByteArray
   * 
   * @param ba xml in form of QByteArray
   */
  public void readXml(QByteArray ba){
    xml = ba;
    
    try{
      parseXml();
    }catch(InvalidQueryException ex){
      QMessageBox.StandardButtons buttons = new QMessageBox.StandardButtons();
      buttons.set(QMessageBox.StandardButton.Close);
      QMessageBox box = new QMessageBox(QMessageBox.Icon.Critical, "Error", ex.getMessage(),buttons);
      box.exec();
    }
  }
  
  /**
   * Parses xml and creates Course objects
   * 
   * @throws InvalidQueryException
   * 
   * @todo parsing results and creating Course objects from parsed data
   */
  private void parseXml() throws InvalidQueryException{
    List<Course> courses = new ArrayList<Course>();
    
    QBuffer buffIn = new QBuffer(xml);
    buffIn.open(QIODevice.OpenModeFlag.ReadOnly);
    
    QFile file = new QFile("conf/timetableQuery.xq");
    file.open(QIODevice.OpenModeFlag.ReadOnly);
    
    QXmlQuery qry = new QXmlQuery();
    qry.bindVariable("inputDocument", buffIn);
    qry.setQuery(file);
    
    if (!qry.isValid())
      throw new InvalidQueryException("invalid query");
    
    QXmlResultItems results = new QXmlResultItems();
    qry.evaluateTo(results);
    
    buffIn.close();
    file.close();
    dataAvailable.emit(courses);
  }
}
