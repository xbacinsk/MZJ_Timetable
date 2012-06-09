package timetabler.dialogs;

import com.trolltech.qt.QVariant;
import com.trolltech.qt.core.QObject;
import com.trolltech.qt.core.QSettings;
import com.trolltech.qt.core.QTime;
import com.trolltech.qt.gui.QCheckBox;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QSpacerItem;
import com.trolltech.qt.gui.QVBoxLayout;
import java.util.List;
import timetabler.entities.Course;
import timetabler.entities.Teacher;
import timetabler.ui.Ui_CourseDialogUi;

/**
 * Settings dialog for course.
 * 
 * Represents filter dialog which can reduce the options of placing course on 
 * timetable.
 * 
 * @author Michal Kimle
 * @version 2012-05-04
 */
public class CourseDialog extends QDialog{
  
  private Ui_CourseDialogUi ui = new Ui_CourseDialogUi();
  private Course course;
  
  public CourseDialog(Course course){
    this.course = course;
    ui.setupUi(this);
    loadSettings();
  }
  
  /**
   * SLOT
   * 
   * Called when OK button is pressed
   */
  @Override
  public void accept(){
    saveSettings();
    setResult(QDialog.DialogCode.Accepted.value());
    hide();
  }
  
  /**
   * SLOT
   * 
   * Called when Cancel button is pressed
   */
  @Override
  public void reject(){
    setResult(QDialog.DialogCode.Rejected.value());
    hide();
  }

  /**
   * Save/Create settings from GUI
   */
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
    
    settings.beginGroup(course.getCode() + "/time");
    settings.setValue("from", ui.timeFromEdit.time());
    settings.setValue("to", ui.timeToEdit.time());
    settings.endGroup();
    
    settings.setValue(course.getCode() + "/lecture", ui.lectureVisibilityCheckBox.isChecked());
    
    //getting settings from dynamically generated combo box for teachers
    List<QObject> boxes = ui.teachersBox.layout().children();
    settings.beginGroup(course.getCode() + "/teachers");
    for(QObject box : boxes){
      QCheckBox checkBox = (QCheckBox) box;
      settings.setValue(checkBox.text(), checkBox.isChecked());
    }
    settings.endGroup();
  }

  /**
   * Load/Create GUI settings from stored settings
   */
  private void loadSettings() {
    QSettings settings = new QSettings();
    
    settings.beginGroup(course.getCode() + "/days");
    ui.daysMondayCheckBox.setChecked(QVariant.toBoolean(settings.value("monday", true)));
    ui.daysTuesdayCheckBox.setChecked(QVariant.toBoolean(settings.value("tuesday", true)));
    ui.daysWednesdayCheckBox.setChecked(QVariant.toBoolean(settings.value("wednesday", true)));
    ui.daysThursdayCheckBox.setChecked(QVariant.toBoolean(settings.value("thursday", true)));
    ui.daysFridayCheckBox.setChecked(QVariant.toBoolean(settings.value("friday", true)));
    ui.daysSaturdayCheckBox.setChecked(QVariant.toBoolean(settings.value("saturday", true)));
    ui.daysSundayCheckBox.setChecked(QVariant.toBoolean(settings.value("sunday", true)));
    settings.endGroup();
    
    settings.beginGroup(course.getCode() + "/time");
    ui.timeFromEdit.setTime(QVariant.toTime(settings.value("from", new QTime(8, 0))));
    ui.timeToEdit.setTime(QVariant.toTime(settings.value("to", new QTime(20, 0))));
    settings.endGroup();
    
    ui.lectureVisibilityCheckBox.setChecked(QVariant.toBoolean(settings.value(course.getCode() + "/lecture", true)));
    
    List<Teacher> teachers = course.getTeachers();
    QVBoxLayout teachersLayout = new QVBoxLayout(ui.teachersBox);
    
    //dynamically creating combo boxes for teachers and loading their settings
    settings.beginGroup(course.getCode() + "/teachers");
    for(Teacher teacher : teachers){
      QCheckBox box = new QCheckBox(teacher.getName());
      teachersLayout.addWidget(box);
      box.setChecked(QVariant.toBoolean(settings.value(teacher.getName(), true)));
    }
    QSpacerItem spacer = new QSpacerItem(1,1,com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
    teachersLayout.addSpacerItem(spacer);
    settings.endGroup();
  }
  
}
