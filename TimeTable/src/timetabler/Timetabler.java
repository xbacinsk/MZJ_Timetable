package timetabler;

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.core.QTime;
import com.trolltech.qt.gui.QWidget;
import java.util.ArrayList;
import java.util.List;
import timetabler.entities.*;

public class Timetabler extends QWidget{
  
    public Timetabler()
    {
        
    }
    
    /**
     * Method implements only testing data for GUI development.
     */
    public void Tester()
    {
        /**
         * Course Math.
         */
        Teacher mathTeacher = new Teacher("Panak",1);
        List<Room> rooms = new ArrayList<>();
        List<Term> sTerms = new ArrayList<>();
        Room mathRoom = new Room("G125",1);
        rooms.add(mathRoom);
        Term mathTerm = new Term(mathTeacher,new QDate(2012,5,5),
                new QTime(10,00),new QTime(12,00),rooms,15);
        Term mathS1 = new Term(mathTeacher,new QDate(2012,5,6),
                new QTime(10,00),new QTime(12,00),rooms,16);
        Term mathS2 = new Term(mathTeacher,new QDate(2012,5,5),
                new QTime(12,00),new QTime(14,00),rooms,17);
        Term mathS3 = new Term(mathTeacher,new QDate(2012,5,5),
                new QTime(8,00),new QTime(10,00),rooms,18);  
        sTerms.add(mathS3); sTerms.add(mathS2); sTerms.add(mathS1);
        Lecture mathLecture = new Lecture(mathTerm);
        Seminar mathSeminar = new Seminar(sTerms,mathS3);
        Course mathCourse = new Course(104,"Math104",104,mathLecture,
                mathSeminar);
         /**
         * Course .
         */
        Teacher mzjTeacher = new Teacher("Unknown",2);
        Room mzjRoom = new Room("G124",2);
        rooms.add(mathRoom);
        Term mzjTerm = new Term(mzjTeacher,new QDate(2012,5,5),
                new QTime(16,00),new QTime(18,00),rooms,19);
        Term mzjS1 = new Term(mzjTeacher,new QDate(2012,5,6),
                new QTime(12,00),new QTime(14,00),rooms,20);
        Term mzjS2 = new Term(mzjTeacher,new QDate(2012,5,5),
                new QTime(12,00),new QTime(14,00),rooms,21);
        Term mzjS3 = new Term(mzjTeacher,new QDate(2012,5,4),
                new QTime(8,00),new QTime(10,00),rooms,22);  
        sTerms.add(mzjS3); sTerms.add(mzjS2); sTerms.add(mzjS1);
        Lecture mzjLecture = new Lecture(mzjTerm);
        Seminar mzjSeminar = new Seminar(sTerms,mzjS2);
        Course mzjCourse = new Course(1,"MZJ",1,mzjLecture,
                mzjSeminar);
        
         /**
         * Course Math.
         */
        Teacher javaTeacher = new Teacher("Known",3);
        Room javaRoom = new Room("D1",3);
        rooms.add(javaRoom);
        Term javaTerm = new Term(javaTeacher,new QDate(2012,5,4),
                new QTime(10,00),new QTime(12,00),rooms,23);
        Term javaS1 = new Term(javaTeacher,new QDate(2012,5,4),
                new QTime(10,00),new QTime(12,00),rooms,24);
        Term javaS2 = new Term(javaTeacher,new QDate(2012,5,4),
                new QTime(12,00),new QTime(14,00),rooms,25);
        Term javaS3 = new Term(javaTeacher,new QDate(2012,5,3),
                new QTime(8,00),new QTime(10,00),rooms,26);  
        sTerms.add(javaS3); sTerms.add(javaS2); sTerms.add(javaS1);
        Lecture javaLecture = new Lecture(javaTerm);
        Seminar javaSeminar = new Seminar(sTerms,javaS1);
        Course javaCourse = new Course(999,"Java",999,javaLecture,
                javaSeminar);
        
    }
    
}