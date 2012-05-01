package timetabler.dialogs;

import com.trolltech.qt.core.QSettings;
import com.trolltech.qt.core.QTime;
import com.trolltech.qt.gui.QDialog;
import timetabler.entities.Course;
import timetabler.ui.Ui_CourseDialogUi;

public class CourseDialog extends QDialog{
  
  private Ui_CourseDialogUi ui = new Ui_CourseDialogUi();
  
  public CourseDialog(Course course){
    ui.setupUi(this);
    loadSettings(course);
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
    throw new UnsupportedOperationException("Not yet implemented");
  }

  private void loadSettings(Course course) {
    
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
    
    /* TODO:
     * nacitavanie ucitelov
     * kazdu tu zmenu nieocoho connectnut na slot ktory bude prepocitavat tie moznosti
     * saveSettings()
     */
  }
  
}
