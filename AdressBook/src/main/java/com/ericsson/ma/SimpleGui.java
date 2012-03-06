package com.ericsson.ma;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.awt.BorderLayout;
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
       boolean readOrWrite = false;  // read
       Font bigFont = new Font("sanserif", Font.BOLD, 16);
       Logger logger = LoggerFactory.getLogger(SimpleGui.class);
       
       public void run() {
    	   logger.trace("FUNCTION ENTER: generate gui");
    	   this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	   this.frame.getContentPane().add(BorderLayout.SOUTH,button1);

    	   panel.setBackground(Color.WHITE);
    	   panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
    	 
    	   textFieldProgram.setEditable(false);
    	   textFieldProgram.setFont(bigFont);
    	   textFieldProgram.setLineWrap(true);
    	   textFieldProgram.setText("operations you could do:"+"\n"+"1\\ create a new adress book by click on create button");
    	   textFieldProgram.append("\n"+"2\\ search person by phone by click on search button"+"\n");
    	   textFieldProgram.append("  default adress book will be used!");
    	   panel.add(textFieldProgram);
    	   panel.add(textFieldUser);
    	   textFieldUser.requestFocus();
//    	   panel.add(buttonCreate);
//    	   panel.add(buttonSearch);
    	 
    	   frame.getContentPane().add(BorderLayout.NORTH,buttonCreate);
    	   frame.getContentPane().add(BorderLayout.SOUTH,buttonSearch);

    	   frame.getContentPane().add(BorderLayout.CENTER,panel);

    	   frame.setSize(500, 500);
    	   frame.setVisible(true);
    	   
    	   buttonCreate.addActionListener(new ButtonCreateListener());
    	   buttonSearch.addActionListener(new ButtonSearchListener());
    	   textFieldUser.addActionListener(new TextListener());
       }

    public class ButtonCreateListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		XMLFileGenerate xmlHandle = new XMLFileGenerate();
    		xmlHandle.generateXMLFile();
    		xmlHandle = null;
    		textFieldProgram.setText(" please input the info in the following textfield!"+"\n");
    		textFieldProgram.append(" format as Mark/021-12345678/Tianshan Road");
    		textFieldProgram.append("\n please end with an enter");
    		textFieldProgram.append("\n whenever you finish input,just click on search button to start search");
    		readOrWrite = true; //write
    	}
    }
    
    public class TextListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		String userInput = textFieldUser.getText();
    	        textFieldUser.setText(null);
	 
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
    
    public class ButtonSearchListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		textFieldProgram.setText("please input the phone number."+"\n"+"you could just input part of the phone number"+"\n");
    		textFieldProgram.append("For example: if you wish to search phone number 12345, you could just input 123."+"\n");
    		textFieldProgram.append("please end your input with an enter!");
    		readOrWrite = false; //read
    	}
    }
       
}
