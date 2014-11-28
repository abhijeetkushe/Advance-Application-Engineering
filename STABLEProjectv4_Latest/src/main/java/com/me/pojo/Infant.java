/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.pojo;

import java.io.Serializable;

/**
 *
 * @author Venketesh
 */
public class Infant extends Patient implements Serializable {

private String dateOfBirth;
private String timeAtBirth;
private String gender;
private String weightAtBirth;
private String height;
private String bloodGroup;
private String deliveryMode;
private Patient patient;
private RiskFactorDirectory rfDir;
private LabTestDirectory labDir;


    public LabTestDirectory getLabDir() {
	return labDir;
}

public void setLabDir(LabTestDirectory labDir) {
	this.labDir = labDir;
}

	public RiskFactorDirectory getRfDir() {
        return rfDir;
    }

    public void setRfDir(RiskFactorDirectory rfDir) {
        this.rfDir = rfDir;
    }



    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getTimeAtBirth() {
        return timeAtBirth;
    }

    public void setTimeAtBirth(String timeAtBirth) {
        this.timeAtBirth = timeAtBirth;
    }

    public String getWeightAtBirth() {
        return weightAtBirth;
    }

    public void setWeightAtBirth(String weightAtBirth) {
        this.weightAtBirth = weightAtBirth;
    }




    

}
