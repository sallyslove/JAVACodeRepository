/*
 * defined person info
 * 
 * added by eligshn
 */
package com.ericsson.ma;


public class Person {
    private String adress;
    private String name;
    private String phoneNumber;
    
    public Person(){
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
    
    public void setPhoneNumber(String phoneNumber) {
       Util util = new Util();
       if(util.isNum(phoneNumber)){
           this.phoneNumber = phoneNumber;
       }
    }
}
