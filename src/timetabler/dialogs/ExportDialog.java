package timetabler.dialogs;

import com.trolltech.qt.core.QSettings;
import com.trolltech.qt.gui.QColor;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QPalette;
import timetabler.ui.Ui_ExportDialogUi;

/**
 *
 * @author Lenka Bacinska
 */
public class ExportDialog extends QDialog {

    private Ui_ExportDialogUi ui = new Ui_ExportDialogUi();

    public ExportDialog() {
        ui.setupUi(this);
    }

    /**
     * SLOT
     *
     * Called when OK button is pressed
     */
    @Override
    public void accept() {
        String name = ui.nameEdit.text();

        //colorize name if missing
            if (name == null || name.isEmpty()) {
                QPalette palette = ui.nameLabel.palette();
                palette.setColor(QPalette.ColorRole.WindowText, QColor.red);
                ui.nameLabel.setPalette(palette);
                ui.nameEdit.setFocus();
            return;
        }

        QSettings settings = new QSettings();
        settings.setValue("export/name", name);
        
        settings.setValue("export/color", ui.colorBox.isChecked());
        settings.setValue("export/room", ui.roomBox.isChecked());
        settings.setValue("export/teacher", ui.teacherBox.isChecked());

        setResult(QDialog.DialogCode.Accepted.value());
        hide();
    }

    /**
     * SLOT
     *
     * Called when Cancel button is pressed
     */
    @Override
    public void reject() {
        setResult(QDialog.DialogCode.Rejected.value());
        hide();
    }
}
