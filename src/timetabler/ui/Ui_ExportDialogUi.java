package timetabler.ui;

import com.trolltech.qt.core.QSize;
import com.trolltech.qt.gui.*;


public class Ui_ExportDialogUi implements com.trolltech.qt.QUiForm<QDialog>{

    public QVBoxLayout verticalLayout_3;
    public QHBoxLayout horizontalLayout_2;
    public QLabel nameLabel;
    public QLineEdit nameEdit;
    public QSpacerItem verticalSpacer_2;
    public QVBoxLayout verticalLayout_2;
    public QCheckBox colorBox;
    public QCheckBox roomBox;
    public QCheckBox teacherBox;
    public QSpacerItem verticalSpacer;
    public QDialogButtonBox buttonBox;
    
    public Ui_ExportDialogUi() { super(); }
    
    @Override
    public void setupUi(QDialog ExportDialogUi) {
        
        ExportDialogUi.setObjectName("ExportDialogUi");
        ExportDialogUi.resize(new QSize(271, 167).expandedTo(ExportDialogUi.minimumSizeHint()));
        
        verticalLayout_3 = new QVBoxLayout(ExportDialogUi);
        verticalLayout_3.setObjectName("verticalLayout_3");
        
        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2.setObjectName("horizontalLayout_2");
        
        nameLabel = new QLabel(ExportDialogUi);
        nameLabel.setObjectName("nameLabel");
        nameLabel.setText("XML file name:");
        
        horizontalLayout_2.addWidget(nameLabel);
        
        nameEdit = new QLineEdit(ExportDialogUi);
        nameEdit.setObjectName("nameEdit");

        horizontalLayout_2.addWidget(nameEdit);
        
        verticalLayout_3.addLayout(horizontalLayout_2);
        
        verticalSpacer_2 = new QSpacerItem(0, 0, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        verticalLayout_3.addItem(verticalSpacer_2);
        
        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2.setObjectName("verticalLayout_2");
        
        colorBox = new QCheckBox(ExportDialogUi);
        colorBox.setObjectName("colorBox");
        colorBox.setChecked(false);
        
        verticalLayout_2.addWidget(colorBox);
        
        roomBox = new QCheckBox(ExportDialogUi);
        roomBox.setObjectName("roomBox");
        roomBox.setChecked(false);
        
        verticalLayout_2.addWidget(roomBox);
        
        teacherBox = new QCheckBox(ExportDialogUi);
        teacherBox.setObjectName("teacherBox");
        teacherBox.setChecked(false);
        
        verticalLayout_2.addWidget(teacherBox);
        
        verticalLayout_3.addLayout(verticalLayout_2);
        
        verticalSpacer = new QSpacerItem(0, 0, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        verticalLayout_3.addItem(verticalSpacer);
        
        buttonBox = new QDialogButtonBox(ExportDialogUi);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));

        verticalLayout_3.addWidget(buttonBox);
        
        nameLabel.setBuddy(nameEdit);
        retranslateUi(ExportDialogUi);
        buttonBox.accepted.connect(ExportDialogUi, "accept()");
        buttonBox.rejected.connect(ExportDialogUi, "reject()");
        
        ExportDialogUi.connectSlotsByName();
    }
    
    
    void retranslateUi(QDialog LoginDialogUi)
    {
        LoginDialogUi.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("ExportDialogUi", "Dialog", null));
        nameLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("ExportDialogUi", "XML file name:", null));
        colorBox.setText("Colorize lectures and seminars");
        roomBox.setText("Link to IS room page");
        teacherBox.setText("Link to teacher's IS page");
    }
    
}
