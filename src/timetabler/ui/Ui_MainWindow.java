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
    public QWidget centralwidget;
    public QListWidget listWidget;
    public QLabel label;
    public QLabel label_2;
    public QLabel label_3;
    public QLabel label_4;
    public QLabel label_5;
    public QLabel label_6;
    public QLabel label_7;
    public QLabel label_8;
    public QLabel label_9;
    public QLabel label_10;
    public QLabel label_11;
    public QLabel label_12;
    public QLabel label_13;
    public QLabel label_14;
    public QLabel label_15;
    public QLabel label_16;
    public QGroupBox groupBox;
    public QLabel label_22;
    public QGroupBox groupBox_2;
    public QLabel label_23;
    public QGroupBox groupBox_3;
    public QLabel label_24;
    public QGroupBox groupBox_4;
    public QLabel label_25;
    public QGroupBox groupBox_5;
    public QLabel label_26;
    public QLabel label_17;
    public QLabel label_18;
    public QLabel label_19;
    public QLabel label_20;
    public QLabel label_21;
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
        label_2 = new QLabel(centralwidget);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(261, 5, 31, 16));
        label_3 = new QLabel(centralwidget);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(296, 5, 31, 16));
        label_4 = new QLabel(centralwidget);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(336, 5, 31, 16));
        label_5 = new QLabel(centralwidget);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(371, 5, 31, 16));
        label_6 = new QLabel(centralwidget);
        label_6.setObjectName("label_6");
        label_6.setGeometry(new QRect(411, 5, 31, 16));
        label_7 = new QLabel(centralwidget);
        label_7.setObjectName("label_7");
        label_7.setGeometry(new QRect(451, 5, 31, 16));
        label_8 = new QLabel(centralwidget);
        label_8.setObjectName("label_8");
        label_8.setGeometry(new QRect(491, 5, 31, 16));
        label_9 = new QLabel(centralwidget);
        label_9.setObjectName("label_9");
        label_9.setGeometry(new QRect(531, 5, 31, 16));
        label_10 = new QLabel(centralwidget);
        label_10.setObjectName("label_10");
        label_10.setGeometry(new QRect(571, 5, 31, 16));
        label_11 = new QLabel(centralwidget);
        label_11.setObjectName("label_11");
        label_11.setGeometry(new QRect(611, 5, 31, 16));
        label_12 = new QLabel(centralwidget);
        label_12.setObjectName("label_12");
        label_12.setGeometry(new QRect(651, 5, 31, 16));
        label_13 = new QLabel(centralwidget);
        label_13.setObjectName("label_13");
        label_13.setGeometry(new QRect(691, 5, 31, 16));
        label_14 = new QLabel(centralwidget);
        label_14.setObjectName("label_14");
        label_14.setGeometry(new QRect(731, 5, 31, 16));
        label_15 = new QLabel(centralwidget);
        label_15.setObjectName("label_15");
        label_15.setGeometry(new QRect(771, 5, 31, 16));
        label_16 = new QLabel(centralwidget);
        label_16.setObjectName("label_16");
        label_16.setGeometry(new QRect(811, 5, 31, 16));
        groupBox = new QGroupBox(centralwidget);
        groupBox.setObjectName("groupBox");
        groupBox.setGeometry(new QRect(259, 25, 568, 66));
        label_22 = new QLabel(groupBox);
        label_22.setObjectName("label_22");
        label_22.setGeometry(new QRect(5, 5, 78, 55));
        groupBox_2 = new QGroupBox(centralwidget);
        groupBox_2.setObjectName("groupBox_2");
        groupBox_2.setGeometry(new QRect(259, 89, 568, 66));
        label_23 = new QLabel(groupBox_2);
        label_23.setObjectName("label_23");
        label_23.setGeometry(new QRect(5, 5, 78, 55));
        groupBox_3 = new QGroupBox(centralwidget);
        groupBox_3.setObjectName("groupBox_3");
        groupBox_3.setGeometry(new QRect(259, 153, 568, 66));
        label_24 = new QLabel(groupBox_3);
        label_24.setObjectName("label_24");
        label_24.setGeometry(new QRect(10, 5, 78, 55));
        groupBox_4 = new QGroupBox(centralwidget);
        groupBox_4.setObjectName("groupBox_4");
        groupBox_4.setGeometry(new QRect(259, 217, 568, 66));
        label_25 = new QLabel(groupBox_4);
        label_25.setObjectName("label_25");
        label_25.setGeometry(new QRect(10, 5, 78, 55));
        groupBox_5 = new QGroupBox(centralwidget);
        groupBox_5.setObjectName("groupBox_5");
        groupBox_5.setGeometry(new QRect(259, 281, 568, 66));
        label_26 = new QLabel(groupBox_5);
        label_26.setObjectName("label_26");
        label_26.setGeometry(new QRect(5, 5, 78, 55));
        label_17 = new QLabel(centralwidget);
        label_17.setObjectName("label_17");
        label_17.setGeometry(new QRect(220, 50, 31, 16));
        QFont font1 = new QFont();
        font1.setPointSize(10);
        font1.setBold(false);
        font1.setWeight(50);
        label_17.setFont(font1);
        label_17.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        label_18 = new QLabel(centralwidget);
        label_18.setObjectName("label_18");
        label_18.setGeometry(new QRect(220, 115, 31, 16));
        QFont font2 = new QFont();
        font2.setPointSize(10);
        font2.setBold(false);
        font2.setWeight(50);
        label_18.setFont(font2);
        label_18.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        label_19 = new QLabel(centralwidget);
        label_19.setObjectName("label_19");
        label_19.setGeometry(new QRect(220, 175, 31, 16));
        QFont font3 = new QFont();
        font3.setPointSize(10);
        font3.setBold(false);
        font3.setWeight(50);
        label_19.setFont(font3);
        label_19.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        label_20 = new QLabel(centralwidget);
        label_20.setObjectName("label_20");
        label_20.setGeometry(new QRect(220, 240, 31, 16));
        QFont font4 = new QFont();
        font4.setPointSize(10);
        font4.setBold(false);
        font4.setWeight(50);
        label_20.setFont(font4);
        label_20.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        label_21 = new QLabel(centralwidget);
        label_21.setObjectName("label_21");
        label_21.setGeometry(new QRect(220, 305, 31, 16));
        QFont font5 = new QFont();
        font5.setPointSize(10);
        font5.setBold(false);
        font5.setWeight(50);
        label_21.setFont(font5);
        label_21.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
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
        listWidget.clear();

        QListWidgetItem __item = new QListWidgetItem(listWidget);
        __item.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "VB001 Specialist English", null));

        QListWidgetItem __item1 = new QListWidgetItem(listWidget);
        __item1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MB102 Matematika II", null));

        QListWidgetItem __item2 = new QListWidgetItem(listWidget);
        __item2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "PV113 Produkce audiovizu\u00e1ln\u00edho d\u00edla", null));

        QListWidgetItem __item3 = new QListWidgetItem(listWidget);
        __item3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "PB168 Kdesi cosi", null));

        QListWidgetItem __item4 = new QListWidgetItem(listWidget);
        __item4.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "IB001 Tamto a tohle", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "List of seminars", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "7:00", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "8:00", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "9:00", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "10:00", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "11:00", null));
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "12:00", null));
        label_8.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "13:00", null));
        label_9.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "14:00", null));
        label_10.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "15:00", null));
        label_11.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "16:00", null));
        label_12.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "17:00", null));
        label_13.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "18:00", null));
        label_14.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "19:00", null));
        label_15.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "20:00", null));
        label_16.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "21:00", null));
        groupBox.setTitle("");
        label_22.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        groupBox_2.setTitle("");
        label_23.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        groupBox_3.setTitle("");
        label_24.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        groupBox_4.setTitle("");
        label_25.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        groupBox_5.setTitle("");
        label_26.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        label_17.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MON", null));
        label_18.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TUE", null));
        label_19.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "WED", null));
        label_20.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "THU", null));
        label_21.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "FRI", null));
        checkBox.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Show seminars only", null));
        checkBox_2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Colorize", null));
        menuFile.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "File", null));
        menuHelp.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Help", null));
    } // retranslateUi

}

