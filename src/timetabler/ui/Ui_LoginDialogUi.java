package timetabler.ui;

/********************************************************************************
 ** Form generated from reading ui file 'loginDialog.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.6.3
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.QSize;
import com.trolltech.qt.gui.*;

public class Ui_LoginDialogUi implements com.trolltech.qt.QUiForm<QDialog>
{
    public QVBoxLayout verticalLayout_3;
    public QHBoxLayout horizontalLayout;
    public QVBoxLayout verticalLayout;
    public QLabel ucoLabel;
    public QLabel passLabel;
    public QVBoxLayout verticalLayout_2;
    public QLineEdit ucoEdit;
    public QLineEdit passEdit;
    public QSpacerItem verticalSpacer;
    public QDialogButtonBox buttonBox;

    public Ui_LoginDialogUi() { super(); }

  @Override
    public void setupUi(QDialog LoginDialogUi)
    {
        LoginDialogUi.setObjectName("LoginDialogUi");
        LoginDialogUi.resize(new QSize(271, 167).expandedTo(LoginDialogUi.minimumSizeHint()));
        verticalLayout_3 = new QVBoxLayout(LoginDialogUi);
        verticalLayout_3.setObjectName("verticalLayout_3");
        horizontalLayout = new QHBoxLayout();
        horizontalLayout.setObjectName("horizontalLayout");
        verticalLayout = new QVBoxLayout();
        verticalLayout.setObjectName("verticalLayout");
        ucoLabel = new QLabel(LoginDialogUi);
        ucoLabel.setObjectName("ucoLabel");

        verticalLayout.addWidget(ucoLabel);

        passLabel = new QLabel(LoginDialogUi);
        passLabel.setObjectName("passLabel");

        verticalLayout.addWidget(passLabel);


        horizontalLayout.addLayout(verticalLayout);

        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2.setObjectName("verticalLayout_2");
        ucoEdit = new QLineEdit(LoginDialogUi);
        ucoEdit.setObjectName("ucoEdit");

        verticalLayout_2.addWidget(ucoEdit);

        passEdit = new QLineEdit(LoginDialogUi);
        passEdit.setObjectName("passEdit");
        passEdit.setEchoMode(com.trolltech.qt.gui.QLineEdit.EchoMode.Password);

        verticalLayout_2.addWidget(passEdit);


        horizontalLayout.addLayout(verticalLayout_2);


        verticalLayout_3.addLayout(horizontalLayout);

        verticalSpacer = new QSpacerItem(20, 48, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        verticalLayout_3.addItem(verticalSpacer);

        buttonBox = new QDialogButtonBox(LoginDialogUi);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));

        verticalLayout_3.addWidget(buttonBox);

        ucoLabel.setBuddy(ucoEdit);
        passLabel.setBuddy(passEdit);
        retranslateUi(LoginDialogUi);
        buttonBox.accepted.connect(LoginDialogUi, "accept()");
        buttonBox.rejected.connect(LoginDialogUi, "reject()");

        LoginDialogUi.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog LoginDialogUi)
    {
        LoginDialogUi.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("LoginDialogUi", "IS Login", null));
        ucoLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("LoginDialogUi", "UCO:", null));
        passLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("LoginDialogUi", "Password:", null));
    } // retranslateUi

}

