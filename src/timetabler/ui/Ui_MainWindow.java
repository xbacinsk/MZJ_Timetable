package timetabler.ui;

/********************************************************************************
 ** Form generated from reading ui file 'timetabler.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.6.3
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction actionOpen_time_table_from_PC;
    public QAction actionOpen_time_table_from_IS;
    public QAction actionExport_to_HTML_XML;
    public QAction actionExit;
    public QAction actionAbout_Timetabler;
    public QAction actionResizeWindow;
    public QWidget centralwidget;
    public QListWidget listWidget;
    public QLabel label;
    public QLabel timeLabel1;
    public QLabel timeLabel2;
    public QLabel timeLabel3;
    public QLabel timeLabel4;
    public QLabel timeLabel5;
    public QLabel timeLabel6;
    public QLabel timeLabel7;
    public QLabel timeLabel8;
    public QLabel timeLabel9;
    public QLabel timeLabel10;
    public QLabel timeLabel11;
    public QLabel timeLabel12;
    public QLabel timeLabel13;
    public QLabel timeLabel14;
    public QLabel timeLabel15;
    public QGroupBox mondayGroupBox;
    public QLabel label_22;
    public QGroupBox tuesdayGroupBox;
    public QLabel label_23;
    public QGroupBox wednesdayGroupBox;
    public QLabel label_24;
    public QGroupBox thursdayGroupBox;
    public QLabel label_25;
    public QGroupBox fridayGroupBox;
    public QLabel label_26;
    public QLabel mondayLabel;
    public QLabel tuesdayLabel;
    public QLabel wednesdayLabel;
    public QLabel thursdayLabel;
    public QLabel fridayLabel;
    public QCheckBox checkBox;
    public QCheckBox checkBox_2;
    public QMenuBar menubar;
    public QMenu menuFile;
    public QMenu menuHelp;
    public QStatusBar statusbar;

    public Ui_MainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(845, 390).expandedTo(MainWindow.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(MainWindow.sizePolicy().hasHeightForWidth());
        MainWindow.setSizePolicy(sizePolicy);
        
        actionOpen_time_table_from_PC = new QAction(MainWindow);
        actionOpen_time_table_from_PC.setObjectName("actionOpen_time_table_from_PC");
        actionOpen_time_table_from_IS = new QAction(MainWindow);
        actionOpen_time_table_from_IS.setObjectName("actionOpen_time_table_from_IS");
        actionExport_to_HTML_XML = new QAction(MainWindow);
        actionExport_to_HTML_XML.setObjectName("actionExport_to_HTML_XML");
        actionExit = new QAction(MainWindow);
        actionExit.setObjectName("actionExit");
        actionAbout_Timetabler = new QAction(MainWindow);
        actionAbout_Timetabler.setObjectName("actionAbout_Timetabler");
        actionResizeWindow = new QAction(MainWindow);
        actionResizeWindow.setObjectName("actionResizeWindow");        
        
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        listWidget = new QListWidget(centralwidget);
        listWidget.setObjectName("listWidget");
        listWidget.setGeometry(new QRect(5, 26, 211, 271));
        listWidget.setAcceptDrops(false);
        listWidget.setAutoFillBackground(false);
        label = new QLabel(centralwidget);
        label.setObjectName("label");
        label.setGeometry(new QRect(10, 5, 101, 16));
        QFont font = new QFont();
        font.setPointSize(10);
        label.setFont(font);
        timeLabel1 = new QLabel(centralwidget);
        timeLabel1.setObjectName("label_2");
        timeLabel1.setGeometry(new QRect(261, 5, 31, 16));
        timeLabel2 = new QLabel(centralwidget);
        timeLabel2.setObjectName("label_3");
        timeLabel2.setGeometry(new QRect(296, 5, 31, 16));
        timeLabel3 = new QLabel(centralwidget);
        timeLabel3.setObjectName("label_4");
        timeLabel3.setGeometry(new QRect(336, 5, 31, 16));
        timeLabel4 = new QLabel(centralwidget);
        timeLabel4.setObjectName("label_5");
        timeLabel4.setGeometry(new QRect(371, 5, 31, 16));
        timeLabel5 = new QLabel(centralwidget);
        timeLabel5.setObjectName("label_6");
        timeLabel5.setGeometry(new QRect(411, 5, 31, 16));
        timeLabel6 = new QLabel(centralwidget);
        timeLabel6.setObjectName("label_7");
        timeLabel6.setGeometry(new QRect(451, 5, 31, 16));
        timeLabel7 = new QLabel(centralwidget);
        timeLabel7.setObjectName("label_8");
        timeLabel7.setGeometry(new QRect(491, 5, 31, 16));
        timeLabel8 = new QLabel(centralwidget);
        timeLabel8.setObjectName("label_9");
        timeLabel8.setGeometry(new QRect(531, 5, 31, 16));
        timeLabel9 = new QLabel(centralwidget);
        timeLabel9.setObjectName("label_10");
        timeLabel9.setGeometry(new QRect(571, 5, 31, 16));
        timeLabel10 = new QLabel(centralwidget);
        timeLabel10.setObjectName("label_11");
        timeLabel10.setGeometry(new QRect(611, 5, 31, 16));
        timeLabel11 = new QLabel(centralwidget);
        timeLabel11.setObjectName("label_12");
        timeLabel11.setGeometry(new QRect(651, 5, 31, 16));
        timeLabel12 = new QLabel(centralwidget);
        timeLabel12.setObjectName("label_13");
        timeLabel12.setGeometry(new QRect(691, 5, 31, 16));
        timeLabel13 = new QLabel(centralwidget);
        timeLabel13.setObjectName("label_14");
        timeLabel13.setGeometry(new QRect(731, 5, 31, 16));
        timeLabel14 = new QLabel(centralwidget);
        timeLabel14.setObjectName("label_15");
        timeLabel14.setGeometry(new QRect(771, 5, 31, 16));
        timeLabel15 = new QLabel(centralwidget);
        timeLabel15.setObjectName("label_16");
        timeLabel15.setGeometry(new QRect(811, 5, 31, 16));
        
        mondayGroupBox = new QGroupBox(centralwidget);
        mondayGroupBox.setObjectName("groupBox");
        mondayGroupBox.setGeometry(new QRect(259, 25, 568, 66));
                
        tuesdayGroupBox = new QGroupBox(centralwidget);
        tuesdayGroupBox.setObjectName("groupBox_2");
        tuesdayGroupBox.setGeometry(new QRect(259, 89, 568, 66));
                
        wednesdayGroupBox = new QGroupBox(centralwidget);
        wednesdayGroupBox.setObjectName("groupBox_3");
        wednesdayGroupBox.setGeometry(new QRect(259, 153, 568, 66));
                
        thursdayGroupBox = new QGroupBox(centralwidget);
        thursdayGroupBox.setObjectName("groupBox_4");
        thursdayGroupBox.setGeometry(new QRect(259, 217, 568, 66));
        
        fridayGroupBox = new QGroupBox(centralwidget);
        fridayGroupBox.setObjectName("groupBox_5");
        fridayGroupBox.setGeometry(new QRect(259, 281, 568, 66));
        
        label_22 = new QLabel(mondayGroupBox);
        label_22.setObjectName("label_22");
        label_22.setGeometry(new QRect(5, 5, 78, 55));
        
        label_23 = new QLabel(tuesdayGroupBox);
        label_23.setObjectName("label_23");
        label_23.setGeometry(new QRect(5, 5, 78, 55));
                
        label_24 = new QLabel(wednesdayGroupBox);
        label_24.setObjectName("label_24");
        label_24.setGeometry(new QRect(5, 5, 78, 55));
        
        label_25 = new QLabel(thursdayGroupBox);
        label_25.setObjectName("label_25");
        label_25.setGeometry(new QRect(5, 5, 78, 55));
        
        label_26 = new QLabel(fridayGroupBox);
        label_26.setObjectName("label_26");
        label_26.setGeometry(new QRect(5, 5, 78, 55));
        
        mondayLabel = new QLabel(centralwidget);
        mondayLabel.setObjectName("label_17");
        mondayLabel.setGeometry(new QRect(220, 50, 31, 16));
        QFont font1 = new QFont();
        font1.setPointSize(10);
        font1.setBold(false);
        font1.setWeight(50);
        mondayLabel.setFont(font1);
        mondayLabel.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        
        tuesdayLabel = new QLabel(centralwidget);
        tuesdayLabel.setObjectName("label_18");
        tuesdayLabel.setGeometry(new QRect(220, 115, 31, 16));
        QFont font2 = new QFont();
        font2.setPointSize(10);
        font2.setBold(false);
        font2.setWeight(50);
        tuesdayLabel.setFont(font2);
        tuesdayLabel.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        
        wednesdayLabel = new QLabel(centralwidget);
        wednesdayLabel.setObjectName("label_19");
        wednesdayLabel.setGeometry(new QRect(220, 175, 31, 16));
        QFont font3 = new QFont();
        font3.setPointSize(10);
        font3.setBold(false);
        font3.setWeight(50);
        wednesdayLabel.setFont(font3);
        wednesdayLabel.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        
        thursdayLabel = new QLabel(centralwidget);
        thursdayLabel.setObjectName("label_20");
        thursdayLabel.setGeometry(new QRect(220, 240, 31, 16));
        QFont font4 = new QFont();
        font4.setPointSize(10);
        font4.setBold(false);
        font4.setWeight(50);
        thursdayLabel.setFont(font4);
        thursdayLabel.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        
        fridayLabel = new QLabel(centralwidget);
        fridayLabel.setObjectName("label_21");
        fridayLabel.setGeometry(new QRect(220, 305, 31, 16));
        QFont font5 = new QFont();
        font5.setPointSize(10);
        font5.setBold(false);
        font5.setWeight(50);
        fridayLabel.setFont(font5);
        fridayLabel.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        
        checkBox = new QCheckBox(centralwidget);
        checkBox.setObjectName("checkBox");
        checkBox.setGeometry(new QRect(10, 305, 116, 17));
        checkBox_2 = new QCheckBox(centralwidget);
        checkBox_2.setObjectName("checkBox_2");
        checkBox_2.setGeometry(new QRect(10, 325, 70, 17));
        
        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 845, 26));
        menuFile = new QMenu(menubar);
        menuFile.setObjectName("menuFile");
        menuHelp = new QMenu(menubar);
        menuHelp.setObjectName("menuHelp");
        MainWindow.setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar.setObjectName("statusbar");
        MainWindow.setStatusBar(statusbar);

        menubar.addAction(menuFile.menuAction());
        menubar.addAction(menuHelp.menuAction());
        menuFile.addAction(actionOpen_time_table_from_PC);
        menuFile.addAction(actionOpen_time_table_from_IS);
        menuFile.addSeparator();
        menuFile.addAction(actionExport_to_HTML_XML);
        menuFile.addSeparator();
        menuFile.addAction(actionExit);
        menuHelp.addAction(actionAbout_Timetabler);
        retranslateUi(MainWindow);

        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
        actionOpen_time_table_from_PC.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Open file from PC", null));
        actionOpen_time_table_from_IS.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Open file from IS", null));
        actionExport_to_HTML_XML.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Export to HTML/XML", null));
        actionExit.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Exit", null));
        actionAbout_Timetabler.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "About Timetabler", null));
        actionResizeWindow.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "About Timetabler", null));
        listWidget.clear();
        
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "List of seminars", null));
        
        timeLabel1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "7:00", null));
        timeLabel2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "8:00", null));
        timeLabel3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "9:00", null));
        timeLabel4.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "10:00", null));
        timeLabel5.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "11:00", null));
        timeLabel6.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "12:00", null));
        timeLabel7.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "13:00", null));
        timeLabel8.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "14:00", null));
        timeLabel9.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "15:00", null));
        timeLabel10.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "16:00", null));
        timeLabel11.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "17:00", null));
        timeLabel12.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "18:00", null));
        timeLabel13.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "19:00", null));
        timeLabel14.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "20:00", null));
        timeLabel15.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "21:00", null));
        
        mondayGroupBox.setTitle("");
        label_22.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        tuesdayGroupBox.setTitle("");
        label_23.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        wednesdayGroupBox.setTitle("");
        label_24.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        thursdayGroupBox.setTitle("");
        label_25.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        fridayGroupBox.setTitle("");        
        label_26.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        
        mondayLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MON", null));
        tuesdayLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TUE", null));
        wednesdayLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "WED", null));
        thursdayLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "THU", null));
        fridayLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "FRI", null));
        
        checkBox.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Show seminars only", null));
        checkBox_2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Colorize", null));
        menuFile.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "File", null));
        menuHelp.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Help", null));
    } // retranslateUi
    
    public void resizeEvent(QResizeEvent event){
        
    }

}

