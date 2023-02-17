package com.assigment.caresoftinterfaces;

import java.util.ArrayList;
import java.util.Date;

//  Imports class definition
//  Implement HIPAACompliantUser!
public class Physician extends User implements HIPPAComplaintUser {
	
    private ArrayList<String> patientNotes;
	
	
    //  Constructor that takes an ID   
    public Physician(Integer id) {
    	super(id);
    }
    
    
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    
    // Setters & Getters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
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
		return false;
	}
}
