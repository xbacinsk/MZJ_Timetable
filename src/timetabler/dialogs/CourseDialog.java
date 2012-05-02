package timetabler.dialogs;

import com.trolltech.qt.core.QObject;
import com.trolltech.qt.core.QSettings;
import com.trolltech.qt.core.QTime;
import com.trolltech.qt.gui.QCheckBox;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QVBoxLayout;
import java.util.List;
import timetabler.entities.Course;
import timetabler.entities.Teacher;
import timetabler.ui.Ui_CourseDialogUi;

public class CourseDialog extends QDialog{
  
  private Ui_CourseDialogUi ui = new Ui_CourseDialogUi();
  private Course course;
  
  public CourseDialog(Course course){
    this.course = course;
    ui.setupUi(this);
    loadSettings();
  }
  
  @Override
  public void accept(){
    saveSettings();
    setResult(QDialog.DialogCode.Accepted.value());
    close();
  }
  
  @Override
  public void reject(){
    setResult(QDialog.DialogCode.Rejected.value());
    close();
  }

  private void saveSettings() {
    QSettings settings = new QSettings();
    
    settings.beginGroup(course.getCode() + "/days");
    settings.setValue("monday", ui.daysMondayCheckBox.isChecked());
    settings.setValue("tuesday", ui.daysTuesdayCheckBox.isChecked());
    settings.setValue("wednesday", ui.daysWednesdayCheckBox.isChecked());
    settings.setValue("thursday", ui.daysThursdayCheckBox.isChecked());
    settings.setValue("friday", ui.daysFridayCheckBox.isChecked());
    settings.setValue("saturday", ui.daysSaturdayCheckBox.isChecked());
    settings.setValue("sunday", ui.daysSundayCheckBox.isChecked());
    settings.endGroup();
    
    settings.beginGroup(course.getCode() + "/week");
    settings.setValue("even", ui.weekEvenCheckBox.isChecked());
    settings.setValue("odd", ui.weekOddCheckBox.isChecked());
    settings.endGroup();
    
    settings.beginGroup(course.getCode() + "/time");
    settings.setValue("from", ui.timeFromEdit.time());
    settings.setValue("to", ui.timeToEdit.time());
    settings.endGroup();
    
    settings.setValue(course.getCode() + "/lecture", ui.lectureVisibilityCheckBox.isChecked());
    
    List<QObject> boxes = ui.teachersBox.children();
    settings.beginGroup(course.getCode() + "/teachers");
    for(QObject box : boxes){
      QCheckBox checkBox = (QCheckBox) box;
      settings.setValue(checkBox.text(), checkBox.isChecked());
    }
    settings.endGroup();
  }

  private void loadSettings() {
    QSettings settings = new QSettings();
    
    settings.beginGroup(course.getCode() + "/days");
    ui.daysMondayCheckBox.setChecked((Boolean) settings.value("monday", true));
    ui.daysTuesdayCheckBox.setChecked((Boolean) settings.value("tuesday", true));
    ui.daysWednesdayCheckBox.setChecked((Boolean) settings.value("wednesday", true));
    ui.daysThursdayCheckBox.setChecked((Boolean) settings.value("thursday", true));
    ui.daysFridayCheckBox.setChecked((Boolean) settings.value("friday", true));
    ui.daysSaturdayCheckBox.setChecked((Boolean) settings.value("saturday", true));
    ui.daysSundayCheckBox.setChecked((Boolean) settings.value("sunday", true));
    settings.endGroup();
    
    settings.beginGroup(course.getCode() + "/week");
    ui.weekEvenCheckBox.setChecked((Boolean) settings.value("even", true));
    ui.weekOddCheckBox.setChecked((Boolean) settings.value("odd", true));
    settings.endGroup();
    
    settings.beginGroup(course.getCode() + "/time");
    ui.timeFromEdit.setTime((QTime) settings.value("from", new QTime(8, 0)));
    ui.timeToEdit.setTime((QTime) settings.value("to", new QTime(20, 0)));
    settings.endGroup();
    
    ui.lectureVisibilityCheckBox.setChecked((Boolean) settings.value(course.getCode() + "/lecture", true));
    
    List<Teacher> teachers = course.getTeachers();
    QVBoxLayout teachersLayout = new QVBoxLayout(ui.teachersBox);
    
    settings.beginGroup(course.getCode() + "/teachers");
    for(Teacher teacher : teachers){
      QCheckBox box = new QCheckBox(teacher.getName());
      teachersLayout.addWidget(box);
      box.setChecked((Boolean) settings.value(teacher.getName(), true));
    }
    settings.endGroup();
  }
  
}
