package timetabler;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.QMessageBox;
import com.trolltech.qt.xmlpatterns.QXmlItem;
import com.trolltech.qt.xmlpatterns.QXmlQuery;
import com.trolltech.qt.xmlpatterns.QXmlResultItems;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import timetabler.entities.*;
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
    
    QXmlItem item = new QXmlItem(results.next());
    while(!item.isNull()){
        System.out.println(item.toAtomicValue().toString());
        
        String[] fields = item.toAtomicValue().toString().split(";");
        
        String[] teacherInfo = fields[7].split("#");
        Teacher teacher = new Teacher(teacherInfo[1], new BigInteger(teacherInfo[0]));
        
        List<Room> rooms = new ArrayList<Room>();
        String[] roomsInfo = fields[3].split("#");
        int i=0;
        while(i<roomsInfo.length){
            Room room = new Room(roomsInfo[i+1], new BigInteger(roomsInfo[i]));
            rooms.add(room);
            i+=2;
        }
        
        QLocale locale = new QLocale(QLocale.Language.Czech, QLocale.Country.CzechRepublic);
        
        Course course;
        String[] courseInfo = fields[4].split("/");
        if(courseInfo.length == 2){
            int groupNum = Integer.parseInt(courseInfo[1]);
            Term term = new Term(teacher, locale.toDate(fields[0], "ddd"), 
                                 QTime.fromString(fields[1], "hh:mm"),
                                 QTime.fromString(fields[2], "hh:mm"),
                                 rooms, groupNum);
            
            course = getCourse(courses, new BigInteger(fields[6]));
            if(course == null){
                List<Term> terms = new ArrayList<Term>();
                terms.add(term);
                Seminar seminar = new Seminar(terms);
                course = new Course(courseInfo[0], fields[5], new BigInteger(fields[6]));
                course.setSeminar(seminar);
                courses.add(course);
            }else{
                Seminar seminar = course.getSeminar();
                if(seminar == null){
                    List<Term> terms = new ArrayList<Term>();
                    terms.add(term);
                    seminar = new Seminar(terms);
                    course.setSeminar(seminar);
                }else{
                    seminar.getTerms().add(term);
                }
            }
        }else{
            Term term = new Term(teacher, locale.toDate(fields[0], "ddd"), 
                                 QTime.fromString(fields[1], "hh:mm"),
                                 QTime.fromString(fields[2], "hh:mm"),
                                 rooms, 0);
            
            course = getCourse(courses, new BigInteger(fields[6]));
            if(course == null){
                List<Term> terms = new ArrayList<Term>();
                terms.add(term);
                Lecture lecture = new Lecture(terms);
                course = new Course(courseInfo[0], fields[5], new BigInteger(fields[6]));
                course.setLecture(lecture);
                courses.add(course);
            }else{
                Lecture lecture = course.getLecture();
                if(lecture == null){
                    List<Term> terms = new ArrayList<Term>();
                    terms.add(term);
                    lecture = new Lecture(terms);
                    course.setLecture(lecture);
                }else{
                    lecture.getTerms().add(term);
                }
            }
        }
        
        item = results.next();
    }
    
    buffIn.close();
    file.close();
    dataAvailable.emit(courses);
  }
  
  Course getCourse(List<Course> courses, BigInteger courseId){
      for(Course course : courses){
          if(course.getId().equals(courseId))
              return course;
      }
      
      return null;
  }
}
