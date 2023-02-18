package com.assigment.caresoftinterfaces;

//import java.util.ArrayList;    //   NOT IN USE!!
//import java.util.Date;         //   NOT IN USE!!

//  Imports class definition
//  Implement HIPAACompliantUser!
public class Physician extends User implements HIPAACompliantUser {
											
//    private ArrayList<String> patientNotes;     //   NOT IN USE!!
	
	
    //  Constructor that takes an ID and makes it SUPER!
    public Physician(Integer id) {
    	super(id);
    }

	@Override // override the implement from HIPAACompliantUser
	public boolean assignPin(int i) {
		String numLength = Integer.toString(i);
		
		if ( numLength.length() == 4 ) {
			this.pin = i;
			return true;
		}
		return false;
	}

	@Override // override the implement from HIPAACompliantUser
	public boolean accessAuthorized(Integer i) {
		if(this.id == i) {
			return true;
		}
		return false;
	}
    
//    public void newPatientNotes(String notes, String patientName, Date date) {    //   NOT IN USE!!
//        String report = String.format(
//            "Datetime Submitted: %s \n", date);
//        report += String.format("Reported By ID: %s\n", this.id);
//        report += String.format("Patient Name: %s\n", patientName);
//        report += String.format("Notes: %s \n", notes);
//        this.patientNotes.add(report);
//    }

    
//    // Setters & Getters
//	public ArrayList<String> getPatientNotes() {    //   NOT IN USE!!
//		return patientNotes;
//	}
//
//	public void setPatientNotes(ArrayList<String> patientNotes) {    //   NOT IN USE!!
//		this.patientNotes = patientNotes;
//	}

}
