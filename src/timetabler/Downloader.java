package timetabler;

import com.trolltech.qt.core.QFile;
import com.trolltech.qt.core.QObject;
import com.trolltech.qt.core.QSettings;
import com.trolltech.qt.core.QUrl;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.webkit.QWebView;
import timetabler.dialogs.LoginDialog;
import timetabler.exceptions.MissingLoginException;

public class Downloader extends QObject{
  private QWebView web = new QWebView();
  
  public void downloadTimetable() throws MissingLoginException{
    QSettings settings = new QSettings();
    if(!settings.contains("login/uco") || !settings.contains("login/pass")){
      LoginDialog dialog = new LoginDialog();
      if(dialog.exec() == QDialog.DialogCode.Rejected.value()){
        return;
      }
    }
    
    if(!settings.contains("login/uco") || !settings.contains("login/pass"))
      throw new MissingLoginException("missing uco or password");
    
    String uco = (String) settings.value("login/uco");
    String pass = (String) settings.value("login/pass");
    
    QFile file = new QFile("conf/timetableUrl");
    QUrl url = new QUrl(file.readLine().toString());
    url.setUserName(uco);
    url.setPassword(pass);
    
    web.load(url);
  }
  
}
