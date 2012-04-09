/**
* Created : Mar 12, 2012
*
* This file is to build a simple GUI to interact with user.
* textFieldUser is for user input.
*/
package com.ericsson.ma;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.ericsson.ma.XMLFileGenerate;
import com.ericsson.ma.XMLFileSearch;
import com.ericsson.ma.XMLAddNewNode;

public class SimpleGui extends Thread{
    JFrame frame = new JFrame("Adress Book");
    JPanel panel = new JPanel();
    JButton buttonCreate = new JButton("Create new adress book! ");
    JButton buttonSearch = new JButton("Search person");
    JTextArea textFieldProgram  = new JTextArea();
    JTextField textFieldUser = new JTextField(20);
    JMenuBar menuBar = new JMenuBar();
    JMenu menuFile = new JMenu("File");
    JMenu menuHelp = new JMenu("Help");
    JMenuItem menuCreate = new JMenuItem("Create");
    JMenuItem menuSearch = new JMenuItem("Search");
    JMenuItem menuExit = new JMenuItem("Exit");
    JMenuItem menuAbout = new JMenuItem("About addressBook");
  
    //this flag shows read the xml file or write the xml file 
    boolean readOrWrite = false;  // read
    Font bigFont = new Font("sanserif", Font.BOLD, 16);
    Logger logger = LoggerFactory.getLogger(SimpleGui.class);
    
    //menu
    public void handleMenu(){
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
    
    
    //text field
    public void setTextField(){
        textFieldProgram.setEditable(false);
        textFieldProgram.setFont(bigFont);
        textFieldProgram.setLineWrap(true);
        textFieldProgram.setText("1\\ create a new adress book");
        textFieldProgram.append("\n"+"2\\ search person by phone"+"\n");
      
        textFieldUser.requestFocus();
        textFieldUser.addActionListener(new TextListener());
        }
    
    //panel
    public void setPanel(){
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        setTextField();
        panel.add(textFieldProgram);
        panel.add(textFieldUser);
    }
    
    //start 
    public void run() {
        logger.trace("FUNCTION ENTER: generate gui");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setPanel();  	
        handleMenu();
        frame.setJMenuBar(menuBar);
        frame.setContentPane(panel);
                
        frame.setSize(500, 500);
        frame.setVisible(true);
        }
    
    public class MenuCreateListerner implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            XMLFileGenerate xmlHandle = new XMLFileGenerate();
            xmlHandle.generateXMLFile();    
            xmlHandle = null;
            textFieldProgram.setText(" please input the info in the following textfield!"+"\n");
            textFieldProgram.append(" E.g. Mark/021-12345678/Tianshan Road");
            readOrWrite = true; //write
            }
        }
    
    
    public class MenuSearchListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            textFieldProgram.setText("please input the phone number."+"\n");
            readOrWrite = false; //read
            }
        }
    
    public class MenuExitListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
        }
    
    public class MenuAboutListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(frame, "Version 1.0", "About addressBook", 1);
            }
        }
    
    public class TextListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String userInput = textFieldUser.getText();
            textFieldUser.setText(null);
            if(userInput.isEmpty()){
                logger.debug("SimpleGui: the input from user is empty!");
                return;
                }
            
            XMLAddNewNode xmlHandle = new XMLAddNewNode();
            XMLFileSearch xmlHandelSearch = new XMLFileSearch();
            if(readOrWrite == true){
                xmlHandle.addNewNode(userInput);
                }
            else{
                ArrayList<PersonInfo> person = xmlHandelSearch.searchFile(userInput);
                
                if(person == null){
                    textFieldProgram.setText("no mapping found");
                    return;
                    }
                
                textFieldProgram.setText(null);
                if(person.isEmpty() != true){
                    for(short index = 0; index < person.size(); ++index){
                        textFieldProgram.append("name Found:  "+person.get(index).getName()+"\n");
                        textFieldProgram.append("phone number: " +person.get(index).getPhoneNumber()+"\n");
                        textFieldProgram.append("adress:  "+person.get(index).getAdress()+"\n");
                        }
                    }
                else{
                    textFieldProgram.setText("No mapping found!");
                    }
                }
            xmlHandle = null;
            }
        }
    }
