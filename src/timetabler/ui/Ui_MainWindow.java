package timetabler.ui;

/********************************************************************************
 ** Form generated from reading ui file 'timetabler_v2.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.6.3
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;
import timetabler.Timetabler;

public class Ui_MainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction actionOpen_time_table_from_PC;
    public QAction actionOpen_time_table_from_IS;
    public QAction actionExport_to_HTML_XML;
    public QAction actionExit;
    public QAction actionAbout_Timetabler;
    public QWidget centralwidget;
    public QLabel label;
    public QListWidget listWidget;
    public QCheckBox checkBox;
    public QLabel label_21;
    public QGroupBox fridayBox;
    public QLabel label_26;
    public QLabel label_2;
    public QLabel label_16;
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
    public QLabel label_17;
    public QGroupBox mondayBox;
    public QLabel label_22;
    public QLabel label_27;
    public QLabel label_28;
    public QLabel label_29;
    public QLabel label_30;
    public QLabel label_31;
    public QLabel label_32;
    public QLabel label_33;
    public QLabel label_34;
    public QLabel label_35;
    public QLabel label_36;
    public QLabel label_37;
    public QLabel label_38;
    public QLabel label_39;
    public QPushButton termButton;
    public QLabel label_18;
    public QGroupBox tuesdayBox;
    public QLabel label_23;
    public QLabel label_40;
    public QLabel label_41;
    public QLabel label_42;
    public QLabel label_43;
    public QLabel label_44;
    public QLabel label_45;
    public QLabel label_19;
    public QGroupBox wednesdayBox;
    public QLabel label_24;
    public QLabel label_20;
    public QGroupBox thursdayBox;
    public QLabel label_25;
    public QLabel label_46;
    public QGroupBox saturdayBox;
    public QLabel label_47;
    public QLabel label_48;
    public QGroupBox sundayBox;
    public QLabel label_49;
    public QMenuBar menubar;
    public QMenu menuFile;
    public QMenu menuHelp;
    public QStatusBar statusbar;

    public Ui_MainWindow() { super(); }
    
    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(1150, 571).expandedTo(MainWindow.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(MainWindow.sizePolicy().hasHeightForWidth());
        MainWindow.setSizePolicy(sizePolicy);
        MainWindow.setMinimumSize(new QSize(1150, 571));
        MainWindow.setMaximumSize(new QSize(1150, 571));
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
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(centralwidget.sizePolicy().hasHeightForWidth());
        centralwidget.setSizePolicy(sizePolicy1);
        centralwidget.setMinimumSize(new QSize(845, 390));
        label = new QLabel(centralwidget);
        label.setObjectName("label");
        label.setGeometry(new QRect(10, 10, 90, 20));
        label.setMinimumSize(new QSize(0, 20));
        QFont font = new QFont();
        font.setPointSize(10);
        label.setFont(font);
        listWidget = new QListWidget(centralwidget);
        listWidget.setObjectName("listWidget");
        listWidget.setGeometry(new QRect(10, 30, 210, 326));
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(listWidget.sizePolicy().hasHeightForWidth());
        listWidget.setSizePolicy(sizePolicy2);
        listWidget.setMinimumSize(new QSize(210, 0));
        listWidget.setMaximumSize(new QSize(210, 16777215));
        listWidget.setAcceptDrops(false);
        listWidget.setAutoFillBackground(false);
        listWidget.setProperty("isWrapping", false);
        listWidget.setUniformItemSizes(true);
        listWidget.setWordWrap(false);
        checkBox = new QCheckBox(centralwidget);
        checkBox.setObjectName("checkBox");
        checkBox.setGeometry(new QRect(15, 360, 117, 17));
        label_21 = new QLabel(centralwidget);
        label_21.setObjectName("label_21");
        label_21.setGeometry(new QRect(235, 335, 30, 20));
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(label_21.sizePolicy().hasHeightForWidth());
        label_21.setSizePolicy(sizePolicy3);
        label_21.setMinimumSize(new QSize(30, 20));
        QFont font1 = new QFont();
        font1.setPointSize(10);
        font1.setBold(false);
        font1.setWeight(50);
        label_21.setFont(font1);
        label_21.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        fridayBox = new QGroupBox(centralwidget);
        fridayBox.setObjectName("fridayBox");
        fridayBox.setGeometry(new QRect(275, 310, 850, 70));
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(fridayBox.sizePolicy().hasHeightForWidth());
        fridayBox.setSizePolicy(sizePolicy4);
//        label_26 = new QLabel(fridayBox);
//        label_26.setObjectName("label_26");
//        label_26.setGeometry(new QRect(5, 5, 60, 60));
        label_2 = new QLabel(centralwidget);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(266, 12, 40, 16));
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(label_2.sizePolicy().hasHeightForWidth());
        label_2.setSizePolicy(sizePolicy5);
        label_2.setMinimumSize(new QSize(40, 0));
        label_16 = new QLabel(centralwidget);
        label_16.setObjectName("label_16");
        label_16.setGeometry(new QRect(1106, 12, 40, 16));
        QSizePolicy sizePolicy6 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy6.setHorizontalStretch((byte)0);
        sizePolicy6.setVerticalStretch((byte)0);
        sizePolicy6.setHeightForWidth(label_16.sizePolicy().hasHeightForWidth());
        label_16.setSizePolicy(sizePolicy6);
        label_16.setMinimumSize(new QSize(40, 0));
        label_16.setMargin(0);
        label_3 = new QLabel(centralwidget);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(326, 12, 40, 16));
        QSizePolicy sizePolicy7 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy7.setHorizontalStretch((byte)0);
        sizePolicy7.setVerticalStretch((byte)0);
        sizePolicy7.setHeightForWidth(label_3.sizePolicy().hasHeightForWidth());
        label_3.setSizePolicy(sizePolicy7);
        label_3.setMinimumSize(new QSize(40, 0));
        label_4 = new QLabel(centralwidget);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(386, 12, 40, 16));
        QSizePolicy sizePolicy8 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy8.setHorizontalStretch((byte)0);
        sizePolicy8.setVerticalStretch((byte)0);
        sizePolicy8.setHeightForWidth(label_4.sizePolicy().hasHeightForWidth());
        label_4.setSizePolicy(sizePolicy8);
        label_4.setMinimumSize(new QSize(40, 0));
        label_5 = new QLabel(centralwidget);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(446, 12, 40, 16));
        QSizePolicy sizePolicy9 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy9.setHorizontalStretch((byte)0);
        sizePolicy9.setVerticalStretch((byte)0);
        sizePolicy9.setHeightForWidth(label_5.sizePolicy().hasHeightForWidth());
        label_5.setSizePolicy(sizePolicy9);
        label_5.setMinimumSize(new QSize(40, 0));
        label_6 = new QLabel(centralwidget);
        label_6.setObjectName("label_6");
        label_6.setGeometry(new QRect(506, 12, 40, 16));
        QSizePolicy sizePolicy10 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy10.setHorizontalStretch((byte)0);
        sizePolicy10.setVerticalStretch((byte)0);
        sizePolicy10.setHeightForWidth(label_6.sizePolicy().hasHeightForWidth());
        label_6.setSizePolicy(sizePolicy10);
        label_6.setMinimumSize(new QSize(40, 0));
        label_7 = new QLabel(centralwidget);
        label_7.setObjectName("label_7");
        label_7.setGeometry(new QRect(566, 12, 40, 16));
        QSizePolicy sizePolicy11 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy11.setHorizontalStretch((byte)0);
        sizePolicy11.setVerticalStretch((byte)0);
        sizePolicy11.setHeightForWidth(label_7.sizePolicy().hasHeightForWidth());
        label_7.setSizePolicy(sizePolicy11);
        label_7.setMinimumSize(new QSize(40, 0));
        label_8 = new QLabel(centralwidget);
        label_8.setObjectName("label_8");
        label_8.setGeometry(new QRect(626, 12, 40, 16));
        QSizePolicy sizePolicy12 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy12.setHorizontalStretch((byte)0);
        sizePolicy12.setVerticalStretch((byte)0);
        sizePolicy12.setHeightForWidth(label_8.sizePolicy().hasHeightForWidth());
        label_8.setSizePolicy(sizePolicy12);
        label_8.setMinimumSize(new QSize(40, 0));
        label_9 = new QLabel(centralwidget);
        label_9.setObjectName("label_9");
        label_9.setGeometry(new QRect(686, 12, 40, 16));
        QSizePolicy sizePolicy13 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy13.setHorizontalStretch((byte)0);
        sizePolicy13.setVerticalStretch((byte)0);
        sizePolicy13.setHeightForWidth(label_9.sizePolicy().hasHeightForWidth());
        label_9.setSizePolicy(sizePolicy13);
        label_9.setMinimumSize(new QSize(40, 0));
        label_10 = new QLabel(centralwidget);
        label_10.setObjectName("label_10");
        label_10.setGeometry(new QRect(746, 12, 40, 16));
        QSizePolicy sizePolicy14 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy14.setHorizontalStretch((byte)0);
        sizePolicy14.setVerticalStretch((byte)0);
        sizePolicy14.setHeightForWidth(label_10.sizePolicy().hasHeightForWidth());
        label_10.setSizePolicy(sizePolicy14);
        label_10.setMinimumSize(new QSize(40, 0));
        label_11 = new QLabel(centralwidget);
        label_11.setObjectName("label_11");
        label_11.setGeometry(new QRect(806, 12, 40, 16));
        QSizePolicy sizePolicy15 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy15.setHorizontalStretch((byte)0);
        sizePolicy15.setVerticalStretch((byte)0);
        sizePolicy15.setHeightForWidth(label_11.sizePolicy().hasHeightForWidth());
        label_11.setSizePolicy(sizePolicy15);
        label_11.setMinimumSize(new QSize(40, 0));
        label_12 = new QLabel(centralwidget);
        label_12.setObjectName("label_12");
        label_12.setGeometry(new QRect(866, 12, 40, 16));
        QSizePolicy sizePolicy16 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy16.setHorizontalStretch((byte)0);
        sizePolicy16.setVerticalStretch((byte)0);
        sizePolicy16.setHeightForWidth(label_12.sizePolicy().hasHeightForWidth());
        label_12.setSizePolicy(sizePolicy16);
        label_12.setMinimumSize(new QSize(40, 0));
        label_13 = new QLabel(centralwidget);
        label_13.setObjectName("label_13");
        label_13.setGeometry(new QRect(926, 12, 40, 16));
        QSizePolicy sizePolicy17 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy17.setHorizontalStretch((byte)0);
        sizePolicy17.setVerticalStretch((byte)0);
        sizePolicy17.setHeightForWidth(label_13.sizePolicy().hasHeightForWidth());
        label_13.setSizePolicy(sizePolicy17);
        label_13.setMinimumSize(new QSize(40, 0));
        label_14 = new QLabel(centralwidget);
        label_14.setObjectName("label_14");
        label_14.setGeometry(new QRect(986, 12, 40, 16));
        QSizePolicy sizePolicy18 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy18.setHorizontalStretch((byte)0);
        sizePolicy18.setVerticalStretch((byte)0);
        sizePolicy18.setHeightForWidth(label_14.sizePolicy().hasHeightForWidth());
        label_14.setSizePolicy(sizePolicy18);
        label_14.setMinimumSize(new QSize(40, 0));
        label_15 = new QLabel(centralwidget);
        label_15.setObjectName("label_15");
        label_15.setGeometry(new QRect(1046, 12, 40, 16));
        QSizePolicy sizePolicy19 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy19.setHorizontalStretch((byte)0);
        sizePolicy19.setVerticalStretch((byte)0);
        sizePolicy19.setHeightForWidth(label_15.sizePolicy().hasHeightForWidth());
        label_15.setSizePolicy(sizePolicy19);
        label_15.setMinimumSize(new QSize(40, 0));
        label_17 = new QLabel(centralwidget);
        label_17.setObjectName("label_17");
        label_17.setGeometry(new QRect(235, 55, 30, 20));
        QSizePolicy sizePolicy20 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy20.setHorizontalStretch((byte)0);
        sizePolicy20.setVerticalStretch((byte)0);
        sizePolicy20.setHeightForWidth(label_17.sizePolicy().hasHeightForWidth());
        label_17.setSizePolicy(sizePolicy20);
        label_17.setMinimumSize(new QSize(30, 20));
        QFont font2 = new QFont();
        font2.setPointSize(10);
        font2.setBold(false);
        font2.setWeight(50);
        label_17.setFont(font2);
        label_17.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        mondayBox = new QGroupBox(centralwidget);
        mondayBox.setObjectName("mondayBox");
        mondayBox.setGeometry(new QRect(275, 30, 850, 70));
        QSizePolicy sizePolicy21 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy21.setHorizontalStretch((byte)0);
        sizePolicy21.setVerticalStretch((byte)0);
        sizePolicy21.setHeightForWidth(mondayBox.sizePolicy().hasHeightForWidth());
        mondayBox.setSizePolicy(sizePolicy21);
//        label_22 = new QLabel(mondayBox);
//        label_22.setObjectName("label_22");
//        label_22.setGeometry(new QRect(5, 5, 60, 60));
//        label_27 = new QLabel(mondayBox);
//        label_27.setObjectName("label_27");
//        label_27.setGeometry(new QRect(65, 5, 60, 60));
//        label_28 = new QLabel(mondayBox);
//        label_28.setObjectName("label_28");
//        label_28.setGeometry(new QRect(125, 5, 60, 60));
//        label_29 = new QLabel(mondayBox);
//        label_29.setObjectName("label_29");
//        label_29.setGeometry(new QRect(185, 5, 60, 60));
//        label_30 = new QLabel(mondayBox);
//        label_30.setObjectName("label_30");
//        label_30.setGeometry(new QRect(245, 5, 60, 60));
//        label_31 = new QLabel(mondayBox);
//        label_31.setObjectName("label_31");
//        label_31.setGeometry(new QRect(305, 5, 55, 60));
//        label_32 = new QLabel(mondayBox);
//        label_32.setObjectName("label_32");
//        label_32.setGeometry(new QRect(365, 5, 60, 60));
//        label_32.setStyleSheet("background-color: rgb(149, 236, 174);\n"+"border-color: rgb(0, 0, 0);");
//        label_32.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.NoFrame);
//        label_32.setTextFormat(com.trolltech.qt.core.Qt.TextFormat.PlainText);
//        label_32.setScaledContents(false);
//        label_32.setWordWrap(false);
//        label_32.setMargin(0);
//        label_32.setIndent(-1);
//        label_33 = new QLabel(mondayBox);
//        label_33.setObjectName("label_33");
//        label_33.setGeometry(new QRect(425, 5, 60, 60));
//        label_33.setStyleSheet("background-color: rgb(108, 220, 100);\n"+"border-color: rgb(0, 0, 0);");
//        label_33.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.NoFrame);
//        label_33.setTextFormat(com.trolltech.qt.core.Qt.TextFormat.PlainText);
//        label_33.setScaledContents(false);
//        label_33.setWordWrap(false);
//        label_33.setMargin(0);
//        label_33.setIndent(-1);
//        label_34 = new QLabel(mondayBox);
//        label_34.setObjectName("label_34");
//        label_34.setGeometry(new QRect(485, 5, 60, 60));
//        label_35 = new QLabel(mondayBox);
//        label_35.setObjectName("label_35");
//        label_35.setGeometry(new QRect(545, 5, 60, 60));
//        label_36 = new QLabel(mondayBox);
//        label_36.setObjectName("label_36");
//        label_36.setGeometry(new QRect(605, 5, 60, 60));
//        label_37 = new QLabel(mondayBox);
//        label_37.setObjectName("label_37");
//        label_37.setGeometry(new QRect(665, 5, 60, 60));
//        label_38 = new QLabel(mondayBox);
//        label_38.setObjectName("label_38");
//        label_38.setGeometry(new QRect(725, 5, 60, 60));
//        label_39 = new QLabel(mondayBox);
//        label_39.setObjectName("label_39");
//        label_39.setGeometry(new QRect(785, 5, 60, 60));
//        termButton = new QPushButton(mondayBox);
//        termButton.setObjectName("termButton");
//        termButton.setGeometry(new QRect(305, 5, 60, 60));
        QPalette palette= new QPalette();
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(255, 31, 2));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(255, 31, 2));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(255, 31, 2));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(255, 31, 2));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(255, 31, 2));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(255, 31, 2));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(255, 31, 2));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(255, 31, 2));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(255, 31, 2));
//        termButton.setPalette(palette);
//        termButton.setAcceptDrops(false);
//        termButton.setAutoFillBackground(false);
//        termButton.setStyleSheet("background-color: rgba(255, 31, 2, 128);");
//        termButton.setCheckable(false);
//        termButton.setChecked(false);
//        termButton.setAutoDefault(false);
//        termButton.setDefault(false);
//        termButton.setFlat(false);
        label_18 = new QLabel(centralwidget);
        label_18.setObjectName("label_18");
        label_18.setGeometry(new QRect(235, 125, 30, 20));
        QSizePolicy sizePolicy22 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy22.setHorizontalStretch((byte)0);
        sizePolicy22.setVerticalStretch((byte)0);
        sizePolicy22.setHeightForWidth(label_18.sizePolicy().hasHeightForWidth());
        label_18.setSizePolicy(sizePolicy22);
        label_18.setMinimumSize(new QSize(30, 20));
        QFont font3 = new QFont();
        font3.setPointSize(10);
        font3.setBold(false);
        font3.setWeight(50);
        label_18.setFont(font3);
        label_18.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        tuesdayBox = new QGroupBox(centralwidget);
        tuesdayBox.setObjectName("tuesdayBox");
        tuesdayBox.setGeometry(new QRect(275, 100, 850, 70));
        QSizePolicy sizePolicy23 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy23.setHorizontalStretch((byte)0);
        sizePolicy23.setVerticalStretch((byte)0);
        sizePolicy23.setHeightForWidth(tuesdayBox.sizePolicy().hasHeightForWidth());
        tuesdayBox.setSizePolicy(sizePolicy23);
//        label_23 = new QLabel(tuesdayBox);
//        label_23.setObjectName("label_23");
//        label_23.setGeometry(new QRect(5, 5, 60, 60));
//        label_40 = new QLabel(tuesdayBox);
//        label_40.setObjectName("label_40");
//        label_40.setGeometry(new QRect(605, 5, 60, 30));
//        label_40.setStyleSheet("background-color: rgb(149, 236, 174);\n"+"border-color: rgb(0, 0, 0);");
//        label_40.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.Box);
//        label_40.setLineWidth(1);
//        label_40.setMidLineWidth(0);
//        label_41 = new QLabel(tuesdayBox);
//        label_41.setObjectName("label_41");
//        label_41.setGeometry(new QRect(485, 5, 120, 30));
//        label_41.setStyleSheet("background-color: rgb(149, 236, 174);\n"+"border-color: rgb(0, 0, 0);");
//        label_41.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.Box);
//        label_41.setLineWidth(1);
//        label_41.setMidLineWidth(0);
//        label_42 = new QLabel(tuesdayBox);
//        label_42.setObjectName("label_42");
//        label_42.setGeometry(new QRect(545, 35, 120, 30));
//        label_42.setStyleSheet("background-color: rgb(149, 236, 174);\n"+"border-color: rgb(0, 0, 0);");
//        label_42.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.Box);
//        label_42.setLineWidth(1);
//        label_42.setMidLineWidth(0);
//        label_43 = new QLabel(tuesdayBox);
//        label_43.setObjectName("label_43");
//        label_43.setGeometry(new QRect(725, 45, 120, 20));
//        label_43.setStyleSheet("background-color: rgb(149, 236, 174);\n"+"border-color: rgb(0, 0, 0);");
//        label_43.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.Box);
//        label_44 = new QLabel(tuesdayBox);
//        label_44.setObjectName("label_44");
//        label_44.setGeometry(new QRect(725, 25, 60, 20));
//        label_44.setStyleSheet("background-color: rgb(149, 236, 174);\n"+"border-color: rgb(0, 0, 0);");
//        label_44.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.Box);
//        label_45 = new QLabel(tuesdayBox);
//        label_45.setObjectName("label_45");
//        label_45.setGeometry(new QRect(665, 5, 120, 20));
//        label_45.setStyleSheet("background-color: rgb(149, 236, 174);\n"+"border-color: rgb(0, 0, 0);");
//        label_45.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.Box);
        label_19 = new QLabel(centralwidget);
        label_19.setObjectName("label_19");
        label_19.setGeometry(new QRect(235, 195, 30, 20));
        QSizePolicy sizePolicy24 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy24.setHorizontalStretch((byte)0);
        sizePolicy24.setVerticalStretch((byte)0);
        sizePolicy24.setHeightForWidth(label_19.sizePolicy().hasHeightForWidth());
        label_19.setSizePolicy(sizePolicy24);
        label_19.setMinimumSize(new QSize(30, 20));
        QFont font4 = new QFont();
        font4.setPointSize(10);
        font4.setBold(false);
        font4.setWeight(50);
        label_19.setFont(font4);
        label_19.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        wednesdayBox = new QGroupBox(centralwidget);
        wednesdayBox.setObjectName("wednesdayBox");
        wednesdayBox.setGeometry(new QRect(275, 170, 850, 70));
        QSizePolicy sizePolicy25 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy25.setHorizontalStretch((byte)0);
        sizePolicy25.setVerticalStretch((byte)0);
        sizePolicy25.setHeightForWidth(wednesdayBox.sizePolicy().hasHeightForWidth());
        wednesdayBox.setSizePolicy(sizePolicy25);
//        label_24 = new QLabel(wednesdayBox);
//        label_24.setObjectName("label_24");
//        label_24.setGeometry(new QRect(5, 5, 60, 60));
        label_20 = new QLabel(centralwidget);
        label_20.setObjectName("label_20");
        label_20.setGeometry(new QRect(235, 265, 30, 20));
        QSizePolicy sizePolicy26 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy26.setHorizontalStretch((byte)0);
        sizePolicy26.setVerticalStretch((byte)0);
        sizePolicy26.setHeightForWidth(label_20.sizePolicy().hasHeightForWidth());
        label_20.setSizePolicy(sizePolicy26);
        label_20.setMinimumSize(new QSize(30, 20));
        QFont font5 = new QFont();
        font5.setPointSize(10);
        font5.setBold(false);
        font5.setWeight(50);
        label_20.setFont(font5);
        label_20.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        thursdayBox = new QGroupBox(centralwidget);
        thursdayBox.setObjectName("thursdayBox");
        thursdayBox.setGeometry(new QRect(275, 240, 850, 70));
        QSizePolicy sizePolicy27 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy27.setHorizontalStretch((byte)0);
        sizePolicy27.setVerticalStretch((byte)0);
        sizePolicy27.setHeightForWidth(thursdayBox.sizePolicy().hasHeightForWidth());
        thursdayBox.setSizePolicy(sizePolicy27);
//        label_25 = new QLabel(thursdayBox);
//        label_25.setObjectName("label_25");
//        label_25.setGeometry(new QRect(5, 5, 60, 60));
        label_46 = new QLabel(centralwidget);
        label_46.setObjectName("label_46");
        label_46.setGeometry(new QRect(235, 405, 30, 20));
        QSizePolicy sizePolicy28 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy28.setHorizontalStretch((byte)0);
        sizePolicy28.setVerticalStretch((byte)0);
        sizePolicy28.setHeightForWidth(label_46.sizePolicy().hasHeightForWidth());
        label_46.setSizePolicy(sizePolicy28);
        label_46.setMinimumSize(new QSize(30, 20));
        QFont font6 = new QFont();
        font6.setPointSize(10);
        font6.setBold(false);
        font6.setWeight(50);
        label_46.setFont(font6);
        label_46.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        saturdayBox = new QGroupBox(centralwidget);
        saturdayBox.setObjectName("saturdayBox");
        saturdayBox.setGeometry(new QRect(275, 380, 850, 70));
        QSizePolicy sizePolicy29 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy29.setHorizontalStretch((byte)0);
        sizePolicy29.setVerticalStretch((byte)0);
        sizePolicy29.setHeightForWidth(saturdayBox.sizePolicy().hasHeightForWidth());
        saturdayBox.setSizePolicy(sizePolicy29);
//        label_47 = new QLabel(saturdayBox);
//        label_47.setObjectName("label_47");
//        label_47.setGeometry(new QRect(5, 5, 60, 60));
        label_48 = new QLabel(centralwidget);
        label_48.setObjectName("label_48");
        label_48.setGeometry(new QRect(235, 475, 30, 20));
        QSizePolicy sizePolicy30 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy30.setHorizontalStretch((byte)0);
        sizePolicy30.setVerticalStretch((byte)0);
        sizePolicy30.setHeightForWidth(label_48.sizePolicy().hasHeightForWidth());
        label_48.setSizePolicy(sizePolicy30);
        label_48.setMinimumSize(new QSize(30, 20));
        QFont font7 = new QFont();
        font7.setPointSize(10);
        font7.setBold(false);
        font7.setWeight(50);
        label_48.setFont(font7);
        label_48.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        sundayBox = new QGroupBox(centralwidget);
        sundayBox.setObjectName("sundayBox");
        sundayBox.setGeometry(new QRect(275, 450, 850, 70));
        QSizePolicy sizePolicy31 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy31.setHorizontalStretch((byte)0);
        sizePolicy31.setVerticalStretch((byte)0);
        sizePolicy31.setHeightForWidth(sundayBox.sizePolicy().hasHeightForWidth());
        sundayBox.setSizePolicy(sizePolicy31);
//        label_49 = new QLabel(sundayBox);
//        label_49.setObjectName("label_49");
//        label_49.setGeometry(new QRect(5, 5, 60, 60));
        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 1150, 26));
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
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "List of courses", null));
        listWidget.clear();

//        QListWidgetItem __item = new QListWidgetItem(listWidget);
//        __item.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "VB001 Specialist English", null));
//
//        QListWidgetItem __item1 = new QListWidgetItem(listWidget);
//        __item1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MB102 Matematika II", null));
//
//        QListWidgetItem __item2 = new QListWidgetItem(listWidget);
//        __item2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "PV113 Produkce audiovizu\u00e1ln\u00edho d\u00edla", null));
//
//        QListWidgetItem __item3 = new QListWidgetItem(listWidget);
//        __item3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "PB168 Kdesi cosi", null));
//
//        QListWidgetItem __item4 = new QListWidgetItem(listWidget);
//        __item4.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "IB001 Tamto a tohle", null));
        checkBox.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Show seminars only", null));
        label_21.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "FRI", null));
        fridayBox.setTitle("");
//        label_26.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "7:00", null));
        label_16.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "21:00", null));
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
        label_17.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MON", null));
        mondayBox.setTitle("");
//        label_22.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
//        label_27.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
//        label_28.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
//        label_29.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
//        label_30.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
//        label_31.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
//        label_32.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
//"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
//"p, li { white-space: pre-wrap; }\n"+
//"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">VB001</span></p>\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">01</span></p>\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">Tulajova</span></p>\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:7pt; text-decoration: underline;\">B527</span></p></body></html>", null));
//        label_33.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
//"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
//"p, li { white-space: pre-wrap; }\n"+
//"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">SOC103</span></p>\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">Tulajova</span></p>\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:7pt; text-decoration: underline;\">D3</span></p></body></html>", null));
//        label_34.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
//        label_35.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
//        label_36.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
//        label_37.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
//        label_38.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
//        label_39.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
//        termButton.setText("");
        label_18.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TUE", null));
        tuesdayBox.setTitle("");
//        label_23.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
//        label_40.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
//"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+"p, li { white-space: pre-wrap; }\n"+
//"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">SOC103</span></p>\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">Tulajova</span></p></body></html>", null));
//        label_41.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
//"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
//"p, li { white-space: pre-wrap; }\n"+
//"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">SOC103</span></p>\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">Tulajova</span></p></body></html>", null));
//        label_42.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
//"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
//"p, li { white-space: pre-wrap; }\n"+
//"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">SOC103</span></p>\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">Tulajova</span></p></body></html>", null));
//        label_43.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
//"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
//"p, li { white-space: pre-wrap; }\n"+
//"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">SOC103</span></p></body></html>", null));
//        label_44.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
//"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
//"p, li { white-space: pre-wrap; }\n"+
//"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">SOC103</span></p></body></html>", null));
//        label_45.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
//"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
//"p, li { white-space: pre-wrap; }\n"+
//"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
//"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600;\">SOC103</span></p></body></html>", null));
        label_19.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "WED", null));
        wednesdayBox.setTitle("");
//        label_24.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        label_20.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "THU", null));
        thursdayBox.setTitle("");
//        label_25.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        label_46.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "SAT", null));
        saturdayBox.setTitle("");
//        label_47.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        label_48.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "SUN", null));
        sundayBox.setTitle("");
//        label_49.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        menuFile.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "File", null));
        menuHelp.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Help", null));
    } // retranslateUi  
    
    
    // 432 571
    public void weekendGUI(Timetabler tt, boolean b) {
        if (b) {
            tt.setMinimumHeight(571);
            tt.setMaximumHeight(571);
            tt.setFixedHeight(571);
            tt.repaint();
        } else {
            tt.setMinimumHeight(431);
            tt.setMaximumHeight(431);
            tt.setFixedHeight(431);
            tt.repaint();
        }
    }   

}

