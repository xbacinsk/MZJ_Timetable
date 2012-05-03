package timetabler;

import com.trolltech.qt.QSignalEmitter;
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.webkit.QWebView;
import timetabler.dialogs.LoginDialog;
import timetabler.exceptions.MissingLoginException;

public class Downloader extends QObject{
  private QWebView web = new QWebView();
  public final Signal1<QByteArray> xmlReady = new Signal1<QByteArray>();
  
  public Downloader(){
    web.loadFinished.connect(this, "loaded()");
  }
  
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
    file.open(QIODevice.OpenModeFlag.ReadOnly);
    QUrl url = new QUrl(file.readLine().data().stringValue());
    url.setUserName(uco);
    url.setPassword(pass);
    
    web.load(url);
  }
  
  private void loaded(){
    QByteArray ba = new QByteArray();
    ba.append(web.page().mainFrame().toHtml());
    
    xmlReady.emit(ba);
  }
  
}
