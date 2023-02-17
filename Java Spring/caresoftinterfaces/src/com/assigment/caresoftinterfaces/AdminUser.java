package com.assigment.caresoftinterfaces;

import java.util.ArrayList;
import java.util.Date;

	//  Implement HIPAACompliantUser!
	//  Implement HIPAACompliantAdmin!
	//	Imports class definition...	
public class AdminUser extends User implements HIPAACompliantAdmin, HIPPAComplaintUser {
	
	
	private String role;
	private ArrayList<String> securityIncidents = new ArrayList<String>();

	// Implement a constructor that takes an ID and a role
	public AdminUser(Integer id) {
		super(id);
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return null;
	}

    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

	public boolean assignPin(int i) {
		String numLength = Integer.toString(i);
		
		if ( numLength.length() == 4 ) {
			return true;
		}
		return false;
	}


	public boolean accessAuthorized(int i) {
		if(this.id == i) {
			return true;
		}
		this.authIncident();
		return false;
	}
    
    
    // TO DO: Setters & Getters
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

}
