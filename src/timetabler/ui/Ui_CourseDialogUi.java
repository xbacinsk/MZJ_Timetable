package timetabler.ui;
/********************************************************************************
 ** Form generated from reading ui file 'courseDialog.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.6.3
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_CourseDialogUi implements com.trolltech.qt.QUiForm<QDialog>
{
    public QVBoxLayout verticalLayout_4;
    public QHBoxLayout horizontalLayout_3;
    public QGroupBox daysBox;
    public QVBoxLayout verticalLayout;
    public QCheckBox daysMondayCheckBox;
    public QCheckBox daysTuesdayCheckBox;
    public QCheckBox daysWednesdayCheckBox;
    public QCheckBox daysThursdayCheckBox;
    public QCheckBox daysFridayCheckBox;
    public QCheckBox daysSaturdayCheckBox;
    public QCheckBox daysSundayCheckBox;
    public QSpacerItem verticalSpacer;
    public QGroupBox teachersBox;
    public QVBoxLayout verticalLayout_2;
    public QGroupBox timeBox;
    public QVBoxLayout verticalLayout_3;
    public QHBoxLayout horizontalLayout;
    public QLabel timeFromLabel;
    public QTimeEdit timeFromEdit;
    public QHBoxLayout horizontalLayout_2;
    public QLabel timeToLabel;
    public QTimeEdit timeToEdit;
    public QCheckBox lectureVisibilityCheckBox;
    public QSpacerItem verticalSpacer_2;
    public QHBoxLayout horizontalLayout_4;
    public QDialogButtonBox buttonBox;

    public Ui_CourseDialogUi() { super(); }

    public void setupUi(QDialog CourseDialogUi)
    {
        CourseDialogUi.setObjectName("CourseDialogUi");
        CourseDialogUi.resize(new QSize(442, 257).expandedTo(CourseDialogUi.minimumSizeHint()));
        verticalLayout_4 = new QVBoxLayout(CourseDialogUi);
        verticalLayout_4.setObjectName("verticalLayout_4");
        horizontalLayout_3 = new QHBoxLayout();
        horizontalLayout_3.setObjectName("horizontalLayout_3");
        daysBox = new QGroupBox(CourseDialogUi);
        daysBox.setObjectName("daysBox");
        verticalLayout = new QVBoxLayout(daysBox);
        verticalLayout.setObjectName("verticalLayout");
        daysMondayCheckBox = new QCheckBox(daysBox);
        daysMondayCheckBox.setObjectName("daysMondayCheckBox");
        daysMondayCheckBox.setChecked(true);

        verticalLayout.addWidget(daysMondayCheckBox);

        daysTuesdayCheckBox = new QCheckBox(daysBox);
        daysTuesdayCheckBox.setObjectName("daysTuesdayCheckBox");
        daysTuesdayCheckBox.setChecked(true);

        verticalLayout.addWidget(daysTuesdayCheckBox);

        daysWednesdayCheckBox = new QCheckBox(daysBox);
        daysWednesdayCheckBox.setObjectName("daysWednesdayCheckBox");
        daysWednesdayCheckBox.setChecked(true);

        verticalLayout.addWidget(daysWednesdayCheckBox);

        daysThursdayCheckBox = new QCheckBox(daysBox);
        daysThursdayCheckBox.setObjectName("daysThursdayCheckBox");
        daysThursdayCheckBox.setChecked(true);

        verticalLayout.addWidget(daysThursdayCheckBox);

        daysFridayCheckBox = new QCheckBox(daysBox);
        daysFridayCheckBox.setObjectName("daysFridayCheckBox");
        daysFridayCheckBox.setChecked(true);

        verticalLayout.addWidget(daysFridayCheckBox);

        daysSaturdayCheckBox = new QCheckBox(daysBox);
        daysSaturdayCheckBox.setObjectName("daysSaturdayCheckBox");
        daysSaturdayCheckBox.setChecked(true);

        verticalLayout.addWidget(daysSaturdayCheckBox);

        daysSundayCheckBox = new QCheckBox(daysBox);
        daysSundayCheckBox.setObjectName("daysSundayCheckBox");
        daysSundayCheckBox.setChecked(true);

        verticalLayout.addWidget(daysSundayCheckBox);

        verticalSpacer = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        verticalLayout.addItem(verticalSpacer);


        horizontalLayout_3.addWidget(daysBox);

        teachersBox = new QGroupBox(CourseDialogUi);
        teachersBox.setObjectName("teachersBox");

        horizontalLayout_3.addWidget(teachersBox);

        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2.setObjectName("verticalLayout_2");
        timeBox = new QGroupBox(CourseDialogUi);
        timeBox.setObjectName("timeBox");
        verticalLayout_3 = new QVBoxLayout(timeBox);
        verticalLayout_3.setObjectName("verticalLayout_3");
        horizontalLayout = new QHBoxLayout();
        horizontalLayout.setObjectName("horizontalLayout");
        timeFromLabel = new QLabel(timeBox);
        timeFromLabel.setObjectName("timeFromLabel");
        timeFromLabel.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.NoFrame);

        horizontalLayout.addWidget(timeFromLabel);

        timeFromEdit = new QTimeEdit(timeBox);
        timeFromEdit.setObjectName("timeFromEdit");
        timeFromEdit.setTime(new QTime(8, 0, 0));

        horizontalLayout.addWidget(timeFromEdit);


        verticalLayout_3.addLayout(horizontalLayout);

        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2.setObjectName("horizontalLayout_2");
        timeToLabel = new QLabel(timeBox);
        timeToLabel.setObjectName("timeToLabel");

        horizontalLayout_2.addWidget(timeToLabel);

        timeToEdit = new QTimeEdit(timeBox);
        timeToEdit.setObjectName("timeToEdit");
        timeToEdit.setTime(new QTime(20, 0, 0));

        horizontalLayout_2.addWidget(timeToEdit);


        verticalLayout_3.addLayout(horizontalLayout_2);


        verticalLayout_2.addWidget(timeBox);

        lectureVisibilityCheckBox = new QCheckBox(CourseDialogUi);
        lectureVisibilityCheckBox.setObjectName("lectureVisibilityCheckBox");
        lectureVisibilityCheckBox.setChecked(true);

        verticalLayout_2.addWidget(lectureVisibilityCheckBox);

        verticalSpacer_2 = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        verticalLayout_2.addItem(verticalSpacer_2);


        horizontalLayout_3.addLayout(verticalLayout_2);


        verticalLayout_4.addLayout(horizontalLayout_3);

        horizontalLayout_4 = new QHBoxLayout();
        horizontalLayout_4.setObjectName("horizontalLayout_4");
        buttonBox = new QDialogButtonBox(CourseDialogUi);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));

        horizontalLayout_4.addWidget(buttonBox);


        verticalLayout_4.addLayout(horizontalLayout_4);

        timeFromLabel.setBuddy(timeFromEdit);
        timeToLabel.setBuddy(timeToEdit);
        retranslateUi(CourseDialogUi);
        buttonBox.accepted.connect(CourseDialogUi, "accept()");
        buttonBox.rejected.connect(CourseDialogUi, "reject()");

        CourseDialogUi.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog CourseDialogUi)
    {
        CourseDialogUi.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "Course options", null));
        daysBox.setTitle(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "Days", null));
        daysMondayCheckBox.setText(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "Monday", null));
        daysTuesdayCheckBox.setText(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "Tuesday", null));
        daysWednesdayCheckBox.setText(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "Wednesday", null));
        daysThursdayCheckBox.setText(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "Thursday", null));
        daysFridayCheckBox.setText(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "Friday", null));
        daysSaturdayCheckBox.setText(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "Saturday", null));
        daysSundayCheckBox.setText(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "Sunday", null));
        teachersBox.setTitle(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "Teachers", null));
        timeBox.setTitle(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "Time", null));
        timeFromLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "From:", null));
        timeFromEdit.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "hh:mm", null));
        timeToLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "To:", null));
        timeToEdit.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "hh:mm", null));
        lectureVisibilityCheckBox.setText(com.trolltech.qt.core.QCoreApplication.translate("CourseDialogUi", "Show lecture", null));
    } // retranslateUi

}

