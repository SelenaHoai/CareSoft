package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;


public class Physician extends User implements HIPAACompliantUser{
	private ArrayList<String> patientNotes;


	//CONSTRUCTOR
	public Physician() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Physician(int id) {
		super(id);
	}

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		int length=String.valueOf(pin).length();
		if(length == 4) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if(this.getId() == confirmedAuthID) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	// METHOD
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	
    // GETTERS & SETTERS
    public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
    
	
	
	

}
