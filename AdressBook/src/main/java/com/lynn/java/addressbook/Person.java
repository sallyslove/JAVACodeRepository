package com.lynn.java.addressbook;

import com.lynn.java.addressbook.util.Util;

public class Person {
    private String adress;
    private String name;
    private String phoneNumber;

    public Person() {
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
        if (Util.isNum(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
    }
}
