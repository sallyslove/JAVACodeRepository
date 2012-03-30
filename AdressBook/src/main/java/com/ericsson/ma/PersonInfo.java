/*
 * defined person info
 * 
 * added by eligshn
 */
package com.ericsson.ma;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonInfo {
    private String adress;
    private String name;
    private String phoneNumber;
    
    public PersonInfo(){
        super();
        adress = "";
        name = "";
        phoneNumber = "";
        }
    
    public String getAdress() {
        return adress;
	    }
    
    public void setAdress(String adress) {
	    this.adress = adress;
	    }
    
    public String getName() {
	    return name;
	    }
    
    public void setName(String name) {
        if (name.isEmpty()) {
            return;
            }
	    this.name = name;
	    }
    
    public String getPhoneNumber() {
	    return phoneNumber;
	    }
    
    public boolean setPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(phoneNumber);
        if (!isNum.matches()) {            
            return false;
            }
        else{
            this.phoneNumber = phoneNumber;
            return true;
            }
	    }    
    }

