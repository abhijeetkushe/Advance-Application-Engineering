/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.pojo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Venketesh
 */
public class Patient implements Serializable {


    private String patientId;
    private String fullName;
    
    //private RiskFactorDirectory riskFactorList;
    private ArrayList<Infant> infantList;

    public Patient()
    {
    //riskFactorList=new RiskFactorDirectory();
    infantList = new ArrayList<Infant>();
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ArrayList<Infant> getInfantList() {
        return infantList;
    }

    public void setInfantList(ArrayList<Infant> infantList) {
        this.infantList = infantList;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }



}
