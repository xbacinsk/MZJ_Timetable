package timetabler;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.webkit.QWebView;
import timetabler.dialogs.LoginDialog;
import timetabler.exceptions.MissingLoginException;

/**
 * Downloads timetable in form of xml
 * 
 * @author Michal Kimle
 * @version 2012-05-04
 */
public class Downloader extends QObject{
  /**
   * attribute responsible for downloading the file
   */
  private QWebView web = new QWebView();
  /**
   * Signal emitted when download is complete and xml is ready for parsing
   * 
   * @param xml in form of QByteArray
   */
  public final Signal1<QByteArray> xmlReady = new Signal1<QByteArray>();
  
  public Downloader(){
    web.loadFinished.connect(this, "loaded()");
  }
  
  /**
   * Downloads timetable in form of xml
   * 
   * @throws MissingLoginException 
   */
  public void downloadTimetable() throws MissingLoginException{
    //login
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
    file.close();
    
    web.load(url);
  }
  
  /**
   * SLOT
   * 
   * emits xmlReady signal when xml is loaded and ready
   */
  private void loaded(){
    QByteArray ba = new QByteArray();
    ba.append(web.page().mainFrame().toHtml());
    
    xmlReady.emit(ba);
  }
  
}
