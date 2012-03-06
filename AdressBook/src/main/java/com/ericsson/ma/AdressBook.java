package com.ericsson.ma;
import java.util.HashMap;
import java.util.Set;

import com.ericsson.ma.PersonInfo;

public class AdressBook{
	private HashMap<String,PersonInfo> adressList;
	
	public AdressBook()	{
		this.adressList = new HashMap<String,PersonInfo>();
	}
	
	public AdressBook(PersonInfo x){
		System.out.println("create AdressBook with known info");
		HashMap<String,PersonInfo> GuyInfo = new HashMap<String,PersonInfo>();
		GuyInfo.put(x.getPhoneNumber(), x);
		this.adressList = GuyInfo;
	}
	
	public void add(PersonInfo x){
		this.adressList.put(x.getPhoneNumber(),x);
	}
	
	public HashMap<String,PersonInfo> getAdressList() {
		return adressList;
	}
	public void setAdressList(HashMap<String,PersonInfo> adressList) {
		this.adressList = adressList;
	}
	
	public String searchByPhone(String knowingNumber){
		Set<String> phoneNumbers = this.adressList.keySet();
		for(String num:phoneNumbers){
			if(num.contains(knowingNumber)){
				PersonInfo personFound = new PersonInfo();
				personFound = this.adressList.get(num);
				return personFound.getName();
			}		
		}

		String message = "No Such Phone Number Stored !";
		return message;

	}
}

