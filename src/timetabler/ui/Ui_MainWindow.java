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

public class Ui_MainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction actionOpen_time_table_from_PC;
    public QAction actionOpen_time_table_from_IS;
    public QAction actionExport_to_HTML_XML;
    public QAction actionExit;
    public QAction actionAbout_Timetabler;
    public QWidget centralwidget;
    public QHBoxLayout horizontalLayout_7;
    public QVBoxLayout verticalLayout_2;
    public QLabel label;
    public QListWidget listWidget;
    public QVBoxLayout verticalLayout;
    public QCheckBox checkBox;
    public QCheckBox checkBox_2;
    public QVBoxLayout verticalLayout_3;
    public QSpacerItem verticalSpacer;
    public QGroupBox groupBox_6;
    public QHBoxLayout horizontalLayout;
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
    public QHBoxLayout horizontalLayout_2;
    public QLabel label_17;
    public QGroupBox groupBox;
    public QLabel label_22;
    public QSpacerItem horizontalSpacer_2;
    public QHBoxLayout horizontalLayout_3;
    public QLabel label_18;
    public QGroupBox groupBox_2;
    public QLabel label_23;
    public QSpacerItem horizontalSpacer_3;
    public QHBoxLayout horizontalLayout_4;
    public QLabel label_19;
    public QGroupBox groupBox_3;
    public QLabel label_24;
    public QSpacerItem horizontalSpacer_4;
    public QHBoxLayout horizontalLayout_5;
    public QLabel label_20;
    public QGroupBox groupBox_4;
    public QLabel label_25;
    public QSpacerItem horizontalSpacer_5;
    public QHBoxLayout horizontalLayout_6;
    public QLabel label_21;
    public QGroupBox groupBox_5;
    public QLabel label_26;
    public QSpacerItem horizontalSpacer_6;
    public QMenuBar menubar;
    public QMenu menuFile;
    public QMenu menuHelp;
    public QStatusBar statusbar;

    public Ui_MainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(1020, 580).expandedTo(MainWindow.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(MainWindow.sizePolicy().hasHeightForWidth());
        MainWindow.setSizePolicy(sizePolicy);
        MainWindow.setMinimumSize(new QSize(1020, 580));
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
        horizontalLayout_7 = new QHBoxLayout(centralwidget);
        horizontalLayout_7.setObjectName("horizontalLayout_7");
        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2.setSpacing(0);
        verticalLayout_2.setObjectName("verticalLayout_2");
        label = new QLabel(centralwidget);
        label.setObjectName("label");
        label.setMinimumSize(new QSize(0, 20));
        QFont font = new QFont();
        font.setPointSize(10);
        label.setFont(font);

        verticalLayout_2.addWidget(label);

        listWidget = new QListWidget(centralwidget);
        listWidget.setObjectName("listWidget");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(listWidget.sizePolicy().hasHeightForWidth());
        listWidget.setSizePolicy(sizePolicy2);
        listWidget.setMinimumSize(new QSize(250, 0));
        listWidget.setMaximumSize(new QSize(250, 16777215));
        listWidget.setAcceptDrops(false);
        listWidget.setAutoFillBackground(false);

        verticalLayout_2.addWidget(listWidget);

        verticalLayout = new QVBoxLayout();
        verticalLayout.setObjectName("verticalLayout");
        verticalLayout.setContentsMargins(-1, 5, -1, -1);
        checkBox = new QCheckBox(centralwidget);
        checkBox.setObjectName("checkBox");

        verticalLayout.addWidget(checkBox);

        checkBox_2 = new QCheckBox(centralwidget);
        checkBox_2.setObjectName("checkBox_2");

        verticalLayout.addWidget(checkBox_2);


        verticalLayout_2.addLayout(verticalLayout);


        horizontalLayout_7.addLayout(verticalLayout_2);

        verticalLayout_3 = new QVBoxLayout();
        verticalLayout_3.setObjectName("verticalLayout_3");
        verticalSpacer = new QSpacerItem(20, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);

        verticalLayout_3.addItem(verticalSpacer);

        groupBox_6 = new QGroupBox(centralwidget);
        groupBox_6.setObjectName("groupBox_6");
        groupBox_6.setEnabled(false);
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(groupBox_6.sizePolicy().hasHeightForWidth());
        groupBox_6.setSizePolicy(sizePolicy3);
        groupBox_6.setMinimumSize(new QSize(700, 20));
        groupBox_6.setFlat(true);
        horizontalLayout = new QHBoxLayout(groupBox_6);
        horizontalLayout.setObjectName("horizontalLayout");
        label_2 = new QLabel(groupBox_6);
        label_2.setObjectName("label_2");
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(label_2.sizePolicy().hasHeightForWidth());
        label_2.setSizePolicy(sizePolicy4);
        label_2.setMinimumSize(new QSize(40, 0));

        horizontalLayout.addWidget(label_2);

        label_3 = new QLabel(groupBox_6);
        label_3.setObjectName("label_3");
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(label_3.sizePolicy().hasHeightForWidth());
        label_3.setSizePolicy(sizePolicy5);
        label_3.setMinimumSize(new QSize(40, 0));

        horizontalLayout.addWidget(label_3);

        label_4 = new QLabel(groupBox_6);
        label_4.setObjectName("label_4");
        QSizePolicy sizePolicy6 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy6.setHorizontalStretch((byte)0);
        sizePolicy6.setVerticalStretch((byte)0);
        sizePolicy6.setHeightForWidth(label_4.sizePolicy().hasHeightForWidth());
        label_4.setSizePolicy(sizePolicy6);
        label_4.setMinimumSize(new QSize(40, 0));

        horizontalLayout.addWidget(label_4);

        label_5 = new QLabel(groupBox_6);
        label_5.setObjectName("label_5");
        QSizePolicy sizePolicy7 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy7.setHorizontalStretch((byte)0);
        sizePolicy7.setVerticalStretch((byte)0);
        sizePolicy7.setHeightForWidth(label_5.sizePolicy().hasHeightForWidth());
        label_5.setSizePolicy(sizePolicy7);
        label_5.setMinimumSize(new QSize(40, 0));

        horizontalLayout.addWidget(label_5);

        label_6 = new QLabel(groupBox_6);
        label_6.setObjectName("label_6");
        QSizePolicy sizePolicy8 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy8.setHorizontalStretch((byte)0);
        sizePolicy8.setVerticalStretch((byte)0);
        sizePolicy8.setHeightForWidth(label_6.sizePolicy().hasHeightForWidth());
        label_6.setSizePolicy(sizePolicy8);
        label_6.setMinimumSize(new QSize(40, 0));

        horizontalLayout.addWidget(label_6);

        label_7 = new QLabel(groupBox_6);
        label_7.setObjectName("label_7");
        QSizePolicy sizePolicy9 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy9.setHorizontalStretch((byte)0);
        sizePolicy9.setVerticalStretch((byte)0);
        sizePolicy9.setHeightForWidth(label_7.sizePolicy().hasHeightForWidth());
        label_7.setSizePolicy(sizePolicy9);
        label_7.setMinimumSize(new QSize(40, 0));

        horizontalLayout.addWidget(label_7);

        label_8 = new QLabel(groupBox_6);
        label_8.setObjectName("label_8");
        QSizePolicy sizePolicy10 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy10.setHorizontalStretch((byte)0);
        sizePolicy10.setVerticalStretch((byte)0);
        sizePolicy10.setHeightForWidth(label_8.sizePolicy().hasHeightForWidth());
        label_8.setSizePolicy(sizePolicy10);
        label_8.setMinimumSize(new QSize(40, 0));

        horizontalLayout.addWidget(label_8);

        label_9 = new QLabel(groupBox_6);
        label_9.setObjectName("label_9");
        QSizePolicy sizePolicy11 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy11.setHorizontalStretch((byte)0);
        sizePolicy11.setVerticalStretch((byte)0);
        sizePolicy11.setHeightForWidth(label_9.sizePolicy().hasHeightForWidth());
        label_9.setSizePolicy(sizePolicy11);
        label_9.setMinimumSize(new QSize(40, 0));

        horizontalLayout.addWidget(label_9);

        label_10 = new QLabel(groupBox_6);
        label_10.setObjectName("label_10");
        QSizePolicy sizePolicy12 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy12.setHorizontalStretch((byte)0);
        sizePolicy12.setVerticalStretch((byte)0);
        sizePolicy12.setHeightForWidth(label_10.sizePolicy().hasHeightForWidth());
        label_10.setSizePolicy(sizePolicy12);
        label_10.setMinimumSize(new QSize(40, 0));

        horizontalLayout.addWidget(label_10);

        label_11 = new QLabel(groupBox_6);
        label_11.setObjectName("label_11");
        QSizePolicy sizePolicy13 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy13.setHorizontalStretch((byte)0);
        sizePolicy13.setVerticalStretch((byte)0);
        sizePolicy13.setHeightForWidth(label_11.sizePolicy().hasHeightForWidth());
        label_11.setSizePolicy(sizePolicy13);
        label_11.setMinimumSize(new QSize(40, 0));

        horizontalLayout.addWidget(label_11);

        label_12 = new QLabel(groupBox_6);
        label_12.setObjectName("label_12");
        QSizePolicy sizePolicy14 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy14.setHorizontalStretch((byte)0);
        sizePolicy14.setVerticalStretch((byte)0);
        sizePolicy14.setHeightForWidth(label_12.sizePolicy().hasHeightForWidth());
        label_12.setSizePolicy(sizePolicy14);
        label_12.setMinimumSize(new QSize(40, 0));

        horizontalLayout.addWidget(label_12);

        label_13 = new QLabel(groupBox_6);
        label_13.setObjectName("label_13");
        QSizePolicy sizePolicy15 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy15.setHorizontalStretch((byte)0);
        sizePolicy15.setVerticalStretch((byte)0);
        sizePolicy15.setHeightForWidth(label_13.sizePolicy().hasHeightForWidth());
        label_13.setSizePolicy(sizePolicy15);
        label_13.setMinimumSize(new QSize(40, 0));

        horizontalLayout.addWidget(label_13);

        label_14 = new QLabel(groupBox_6);
        label_14.setObjectName("label_14");
        QSizePolicy sizePolicy16 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy16.setHorizontalStretch((byte)0);
        sizePolicy16.setVerticalStretch((byte)0);
        sizePolicy16.setHeightForWidth(label_14.sizePolicy().hasHeightForWidth());
        label_14.setSizePolicy(sizePolicy16);
        label_14.setMinimumSize(new QSize(40, 0));

        horizontalLayout.addWidget(label_14);

        label_15 = new QLabel(groupBox_6);
        label_15.setObjectName("label_15");
        QSizePolicy sizePolicy17 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy17.setHorizontalStretch((byte)0);
        sizePolicy17.setVerticalStretch((byte)0);
        sizePolicy17.setHeightForWidth(label_15.sizePolicy().hasHeightForWidth());
        label_15.setSizePolicy(sizePolicy17);
        label_15.setMinimumSize(new QSize(40, 0));

        horizontalLayout.addWidget(label_15);

        label_16 = new QLabel(groupBox_6);
        label_16.setObjectName("label_16");
        QSizePolicy sizePolicy18 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy18.setHorizontalStretch((byte)0);
        sizePolicy18.setVerticalStretch((byte)0);
        sizePolicy18.setHeightForWidth(label_16.sizePolicy().hasHeightForWidth());
        label_16.setSizePolicy(sizePolicy18);
        label_16.setMinimumSize(new QSize(40, 0));
        label_16.setMargin(0);

        horizontalLayout.addWidget(label_16);


        verticalLayout_3.addWidget(groupBox_6);

        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2.setSpacing(6);
        horizontalLayout_2.setObjectName("horizontalLayout_2");
        horizontalLayout_2.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetDefaultConstraint);
        label_17 = new QLabel(centralwidget);
        label_17.setObjectName("label_17");
        QSizePolicy sizePolicy19 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy19.setHorizontalStretch((byte)0);
        sizePolicy19.setVerticalStretch((byte)0);
        sizePolicy19.setHeightForWidth(label_17.sizePolicy().hasHeightForWidth());
        label_17.setSizePolicy(sizePolicy19);
        label_17.setMinimumSize(new QSize(30, 20));
        QFont font1 = new QFont();
        font1.setPointSize(10);
        font1.setBold(false);
        font1.setWeight(50);
        label_17.setFont(font1);
        label_17.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);

        horizontalLayout_2.addWidget(label_17);

        groupBox = new QGroupBox(centralwidget);
        groupBox.setObjectName("groupBox");
        QSizePolicy sizePolicy20 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy20.setHorizontalStretch((byte)0);
        sizePolicy20.setVerticalStretch((byte)0);
        sizePolicy20.setHeightForWidth(groupBox.sizePolicy().hasHeightForWidth());
        groupBox.setSizePolicy(sizePolicy20);
        label_22 = new QLabel(groupBox);
        label_22.setObjectName("label_22");
        label_22.setGeometry(new QRect(5, 5, 78, 55));

        horizontalLayout_2.addWidget(groupBox);

        horizontalSpacer_2 = new QSpacerItem(34, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_2.addItem(horizontalSpacer_2);


        verticalLayout_3.addLayout(horizontalLayout_2);

        horizontalLayout_3 = new QHBoxLayout();
        horizontalLayout_3.setObjectName("horizontalLayout_3");
        horizontalLayout_3.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetDefaultConstraint);
        label_18 = new QLabel(centralwidget);
        label_18.setObjectName("label_18");
        QSizePolicy sizePolicy21 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy21.setHorizontalStretch((byte)0);
        sizePolicy21.setVerticalStretch((byte)0);
        sizePolicy21.setHeightForWidth(label_18.sizePolicy().hasHeightForWidth());
        label_18.setSizePolicy(sizePolicy21);
        label_18.setMinimumSize(new QSize(30, 20));
        QFont font2 = new QFont();
        font2.setPointSize(10);
        font2.setBold(false);
        font2.setWeight(50);
        label_18.setFont(font2);
        label_18.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);

        horizontalLayout_3.addWidget(label_18);

        groupBox_2 = new QGroupBox(centralwidget);
        groupBox_2.setObjectName("groupBox_2");
        QSizePolicy sizePolicy22 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy22.setHorizontalStretch((byte)0);
        sizePolicy22.setVerticalStretch((byte)0);
        sizePolicy22.setHeightForWidth(groupBox_2.sizePolicy().hasHeightForWidth());
        groupBox_2.setSizePolicy(sizePolicy22);
        label_23 = new QLabel(groupBox_2);
        label_23.setObjectName("label_23");
        label_23.setGeometry(new QRect(5, 5, 78, 55));

        horizontalLayout_3.addWidget(groupBox_2);

        horizontalSpacer_3 = new QSpacerItem(34, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_3.addItem(horizontalSpacer_3);


        verticalLayout_3.addLayout(horizontalLayout_3);

        horizontalLayout_4 = new QHBoxLayout();
        horizontalLayout_4.setObjectName("horizontalLayout_4");
        horizontalLayout_4.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetDefaultConstraint);
        label_19 = new QLabel(centralwidget);
        label_19.setObjectName("label_19");
        QSizePolicy sizePolicy23 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy23.setHorizontalStretch((byte)0);
        sizePolicy23.setVerticalStretch((byte)0);
        sizePolicy23.setHeightForWidth(label_19.sizePolicy().hasHeightForWidth());
        label_19.setSizePolicy(sizePolicy23);
        label_19.setMinimumSize(new QSize(30, 20));
        QFont font3 = new QFont();
        font3.setPointSize(10);
        font3.setBold(false);
        font3.setWeight(50);
        label_19.setFont(font3);
        label_19.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);

        horizontalLayout_4.addWidget(label_19);

        groupBox_3 = new QGroupBox(centralwidget);
        groupBox_3.setObjectName("groupBox_3");
        QSizePolicy sizePolicy24 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy24.setHorizontalStretch((byte)0);
        sizePolicy24.setVerticalStretch((byte)0);
        sizePolicy24.setHeightForWidth(groupBox_3.sizePolicy().hasHeightForWidth());
        groupBox_3.setSizePolicy(sizePolicy24);
        label_24 = new QLabel(groupBox_3);
        label_24.setObjectName("label_24");
        label_24.setGeometry(new QRect(10, 5, 78, 55));

        horizontalLayout_4.addWidget(groupBox_3);

        horizontalSpacer_4 = new QSpacerItem(34, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_4.addItem(horizontalSpacer_4);


        verticalLayout_3.addLayout(horizontalLayout_4);

        horizontalLayout_5 = new QHBoxLayout();
        horizontalLayout_5.setObjectName("horizontalLayout_5");
        horizontalLayout_5.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetDefaultConstraint);
        label_20 = new QLabel(centralwidget);
        label_20.setObjectName("label_20");
        QSizePolicy sizePolicy25 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy25.setHorizontalStretch((byte)0);
        sizePolicy25.setVerticalStretch((byte)0);
        sizePolicy25.setHeightForWidth(label_20.sizePolicy().hasHeightForWidth());
        label_20.setSizePolicy(sizePolicy25);
        label_20.setMinimumSize(new QSize(30, 20));
        QFont font4 = new QFont();
        font4.setPointSize(10);
        font4.setBold(false);
        font4.setWeight(50);
        label_20.setFont(font4);
        label_20.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);

        horizontalLayout_5.addWidget(label_20);

        groupBox_4 = new QGroupBox(centralwidget);
        groupBox_4.setObjectName("groupBox_4");
        QSizePolicy sizePolicy26 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy26.setHorizontalStretch((byte)0);
        sizePolicy26.setVerticalStretch((byte)0);
        sizePolicy26.setHeightForWidth(groupBox_4.sizePolicy().hasHeightForWidth());
        groupBox_4.setSizePolicy(sizePolicy26);
        label_25 = new QLabel(groupBox_4);
        label_25.setObjectName("label_25");
        label_25.setGeometry(new QRect(10, 5, 78, 55));

        horizontalLayout_5.addWidget(groupBox_4);

        horizontalSpacer_5 = new QSpacerItem(34, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_5.addItem(horizontalSpacer_5);


        verticalLayout_3.addLayout(horizontalLayout_5);

        horizontalLayout_6 = new QHBoxLayout();
        horizontalLayout_6.setObjectName("horizontalLayout_6");
        horizontalLayout_6.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetDefaultConstraint);
        label_21 = new QLabel(centralwidget);
        label_21.setObjectName("label_21");
        QSizePolicy sizePolicy27 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy27.setHorizontalStretch((byte)0);
        sizePolicy27.setVerticalStretch((byte)0);
        sizePolicy27.setHeightForWidth(label_21.sizePolicy().hasHeightForWidth());
        label_21.setSizePolicy(sizePolicy27);
        label_21.setMinimumSize(new QSize(30, 20));
        QFont font5 = new QFont();
        font5.setPointSize(10);
        font5.setBold(false);
        font5.setWeight(50);
        label_21.setFont(font5);
        label_21.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);

        horizontalLayout_6.addWidget(label_21);

        groupBox_5 = new QGroupBox(centralwidget);
        groupBox_5.setObjectName("groupBox_5");
        QSizePolicy sizePolicy28 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy28.setHorizontalStretch((byte)0);
        sizePolicy28.setVerticalStretch((byte)0);
        sizePolicy28.setHeightForWidth(groupBox_5.sizePolicy().hasHeightForWidth());
        groupBox_5.setSizePolicy(sizePolicy28);
        label_26 = new QLabel(groupBox_5);
        label_26.setObjectName("label_26");
        label_26.setGeometry(new QRect(5, 5, 78, 55));

        horizontalLayout_6.addWidget(groupBox_5);

        horizontalSpacer_6 = new QSpacerItem(34, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_6.addItem(horizontalSpacer_6);


        verticalLayout_3.addLayout(horizontalLayout_6);


        horizontalLayout_7.addLayout(verticalLayout_3);

        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 1020, 26));
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
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "List of seminars", null));
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
        checkBox.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Show seminars only", null));
        checkBox_2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Colorize", null));
        groupBox_6.setTitle("");
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
        label_17.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MON", null));
        groupBox.setTitle("");
        label_22.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        label_18.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TUE", null));
        groupBox_2.setTitle("");
        label_23.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        label_19.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "WED", null));
        groupBox_3.setTitle("");
        label_24.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        label_20.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "THU", null));
        groupBox_4.setTitle("");
        label_25.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        label_21.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "FRI", null));
        groupBox_5.setTitle("");
        label_26.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "TextLabel", null));
        menuFile.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "File", null));
        menuHelp.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Help", null));
    } // retranslateUi

}

