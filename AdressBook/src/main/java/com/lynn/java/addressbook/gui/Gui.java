package com.lynn.java.addressbook.gui;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.lynn.java.addressbook.Person;
import com.lynn.java.addressbook.storage.XmlStorage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui {
    private JFrame frame = new JFrame("Adress Book");
    private JPanel panel = new JPanel();
    private JTextArea textFieldProgram = new JTextArea();
    private JTextField textFieldUser = new JTextField(20);
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu("File");
    private JMenu menuHelp = new JMenu("Help");
    private JMenuItem menuCreate = new JMenuItem("Create");
    private JMenuItem menuSearch = new JMenuItem("Search");
    private JMenuItem menuExit = new JMenuItem("Exit");
    private JMenuItem menuAbout = new JMenuItem("About addressBook");

    // this flag shows read the xml file or write the xml file
    private boolean readOrWrite = false; // read
    private Font bigFont = new Font("sanserif", Font.BOLD, 16);
    private Logger logger = LoggerFactory.getLogger(Gui.class);

    public void startGui() {
        logger.trace("FUNCTION ENTER: generate gui");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setPanel();
        handleMenu();
        frame.setJMenuBar(menuBar);
        frame.setContentPane(panel);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    private void handleMenu() {
        menuFile.add(menuCreate);
        menuFile.add(menuSearch);
        menuFile.add(menuExit);
        menuHelp.add(menuAbout);
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        menuBar.getAccessibleContext();
        menuCreate.addActionListener(new MenuCreateListerner());
        menuSearch.addActionListener(new MenuSearchListener());
        menuExit.addActionListener(new MenuExitListener());
        menuAbout.addActionListener(new MenuAboutListener());
    }

    private void setPanel() {
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setTextField();
        panel.add(textFieldProgram);
        panel.add(textFieldUser);
    }

    private void setTextField() {
        textFieldProgram.setEditable(false);
        textFieldProgram.setFont(bigFont);
        textFieldProgram.setLineWrap(true);
        textFieldProgram.setText("1\\ create a new adress book");
        textFieldProgram.append("\n" + "2\\ search person by phone" + "\n");

        textFieldUser.requestFocus();
        textFieldUser.addActionListener(new TextListener());
    }

    private class MenuCreateListerner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            XmlStorage handler = new XmlStorage();
            handler.generateNewStorage();
            textFieldProgram.setText(" please input the info in the following textfield!" + "\n");
            textFieldProgram.append(" E.g. Mark/021-12345678/Tianshan Road");
            readOrWrite = true; // write
        }
    }

    private class MenuSearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            textFieldProgram.setText("please input the phone number." + "\n");
            readOrWrite = false; // read
        }
    }

    private class MenuExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class MenuAboutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frame, "Version 1.0", "About addressBook", 1);
        }
    }

    private class TextListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = textFieldUser.getText();
            textFieldUser.setText(null);
            if (userInput.isEmpty()) {
                logger.debug("SimpleGui: the input from user is empty!");
                return;
            }

            XmlStorage handler = new XmlStorage();
            if (readOrWrite == true) {
                create(userInput, handler);
            } else {
                search(userInput, handler);
            }
        }

        private void create(String userInput, XmlStorage xmlHandle) {
            xmlHandle.refreshData(userInput);
        }

        private void search(String userInput, XmlStorage xmlHandelSearch) {
            ArrayList<Person> searchData = (ArrayList<Person>) xmlHandelSearch.searchData(userInput);
            ArrayList<Person> person = searchData;
            textFieldProgram.setText(null);
            if (person.isEmpty() != true) {
                for (short index = 0; index < person.size(); ++index) {
                    textFieldProgram.append("name Found:  " + person.get(index).getName() + "\n");
                    textFieldProgram.append("phone number: " + person.get(index).getPhoneNumber() + "\n");
                    textFieldProgram.append("adress:  " + person.get(index).getAdress() + "\n");
                }
                return;
            }
            textFieldProgram.setText("no mapping found");
        }
    }
}
