package timetabler;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.network.QNetworkAccessManager;
import com.trolltech.qt.network.QNetworkReply;
import com.trolltech.qt.network.QNetworkReply.NetworkError;
import com.trolltech.qt.network.QNetworkRequest;
import timetabler.dialogs.LoginDialog;
import timetabler.exceptions.MissingLoginException;

/**
 * Downloads timetable in form of xml.
 *
 * Asks for login with login dialog and download timetable xml from IS. IS
 * timetable url is stored in file conf/timetableUrl. When the loading is done
 * it emits a signal for parser.
 *
 * @author Michal Kimle
 * @version 2012-06-04
 */
public class Downloader extends QObject {
    private QNetworkAccessManager qnam = new QNetworkAccessManager();
    private QNetworkReply reply;
    private boolean fail = false;
    /**
     * Signal emitted when download is complete and xml is ready for parsing
     *
     * @qtspecific-param xml in form of QByteArray
     */
    public final Signal1<QByteArray> xmlReady = new Signal1<QByteArray>();

    /**
     * Downloads timetable in form of xml
     *
     * @throws MissingLoginException
     */
    public void downloadTimetable() throws MissingLoginException {
        //login
        QSettings settings = new QSettings();
        if (!settings.contains("login/uco") || !settings.contains("login/pass") || fail) {
            LoginDialog dialog = new LoginDialog();
            if (dialog.exec() == QDialog.DialogCode.Rejected.value()) {
                dialog.close();
                return;
            }
            fail = false;
            dialog.close();
        }

        if (!settings.contains("login/uco") || !settings.contains("login/pass")) {
            throw new MissingLoginException("missing uco or password");
        }

        String uco = (String) settings.value("login/uco");
        String pass = (String) settings.value("login/pass");

        QFile file = new QFile("conf/timetableUrl");
        file.open(QIODevice.OpenModeFlag.ReadOnly);
        QUrl url = new QUrl(file.readLine().toString());
        url.setUserName(uco);
        url.setPassword(pass);
        file.close();

        reply = qnam.get(new QNetworkRequest(url));
        reply.finished.connect(this, "loaded()");
    }

    /**
     * SLOT
     *
     * emits xmlReady signal when xml is loaded and ready
     */
    private void loaded(){
        if(reply.error() == NetworkError.AuthenticationRequiredError){
            try{
                fail = true;
                downloadTimetable();
            }catch(MissingLoginException ex){
                System.err.println("Something went terribly wrong: " + ex.getMessage());
            }finally{
                return;
            }
        }

        QByteArray ba = reply.readAll();
        xmlReady.emit(ba);
    }
}
