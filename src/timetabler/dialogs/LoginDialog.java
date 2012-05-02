package timetabler.dialogs;

import com.trolltech.qt.core.QSettings;
import com.trolltech.qt.gui.QColor;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QPalette;
import timetabler.ui.Ui_LoginDialogUi;

public class LoginDialog extends QDialog{

  private Ui_LoginDialogUi ui = new Ui_LoginDialogUi();
  
  public LoginDialog() {
    ui.setupUi(this);
  }
  
  @Override
  public void accept() {
    String uco = ui.ucoEdit.text();
    String pass = ui.passEdit.text();
    
    if(uco == null || uco.isEmpty() || pass == null || pass.isEmpty()){
      if(uco == null || uco.isEmpty()){
        QPalette palette = ui.ucoLabel.palette();
        palette.setColor(QPalette.ColorRole.Text, QColor.red);
        ui.ucoLabel.setPalette(palette);
        
      }
      if(pass == null || pass.isEmpty()){
        QPalette palette = ui.passLabel.palette();
        palette.setColor(QPalette.ColorRole.Text, QColor.red);
        ui.passLabel.setPalette(palette);
        
      }
      return;
    }
    
    QSettings settings = new QSettings();
    settings.setValue("login/uco", uco);
    settings.setValue("login/pass", pass);
    setResult(QDialog.DialogCode.Accepted.value());
    close();
  }

  @Override
  public void reject() {
    setResult(QDialog.DialogCode.Rejected.value());
    close();
  }
  
}
