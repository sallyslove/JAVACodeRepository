package com.lynn.java.addressbook;

import com.lynn.java.addressbook.gui.Gui;


public class Runner {

    public static void main(String[] srgs) {
        System.setProperty("logback.configurationFile", "src/logback.xml");
        Gui addressBookGui = new Gui();
        addressBookGui.startGui();
    }
}
