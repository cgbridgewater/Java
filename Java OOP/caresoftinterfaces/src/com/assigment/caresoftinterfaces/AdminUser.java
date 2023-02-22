package com.assigment.caresoftinterfaces;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
		
	private String role;
	private ArrayList<String> securityIncidents = new ArrayList<String>();

	public AdminUser(Integer id) {
		super(id);
		this.role = role;  // NOT IN USE !!
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return null;
	}
    
	public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

	@Override // override the implement from HIPAACompliantUser
	public boolean assignPin(int i) {
		String numLength = Integer.toString(i);
		
		if ( numLength.length() == 4 ) {
			return true;
		}
		return false;
	}

	@Override // override the implement from HIPAACompliantUser
	public boolean accessAuthorized(Integer i) {
		if(this.id == i) {
			return true;
		}
		this.authIncident();
		return false;
	}
    
	//  Setters & Getters
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	//  public void newIncident(String notes) {  // NOT IN USE !!
	//  String report = String.format(
	//      "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", new Date(), this.id, notes
	//  );
	//  securityIncidents.add(report);
	//}
	
	//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}
//
//
//	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
//		this.securityIncidents = securityIncidents;
//	}

}
