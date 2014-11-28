package com.me.pojo;

import java.io.Serializable;
import java.util.Date;

public class BabyProfilePojo implements Serializable{

	
	private String dependentID;
	private String patientName;
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	private String patientID;
	private Date dateOfBirth;
	private String gender="Male";
	private String timeOfBirth;
	private String deliveryMode;
	private String weightAtBirth;
	public String getDependentID() {
		return dependentID;
	}
	public void setDependentID(String dependentID) {
		this.dependentID = dependentID;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTimeOfBirth() {
		return timeOfBirth;
	}
	public void setTimeOfBirth(String timeOfBirth) {
		this.timeOfBirth = timeOfBirth;
	}
	public String getDeliveryMode() {
		return deliveryMode;
	}
	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	public String getWeightAtBirth() {
		return weightAtBirth;
	}
	public void setWeightAtBirth(String weightAtBirth) {
		this.weightAtBirth = weightAtBirth;
	}
	
}
