package org.stable.sdk.model.encounter;

import java.util.Date;

import org.stable.sdk.model.common.IStableModel;
import org.stable.sdk.model.patient.Patient;




public class Encounter implements IStableModel{

	private long encounterID;
	private long encounterDate;
	private Encounter followUp;
	private Treatment treatment;
	private Assessment assessment;
	private Patient patient;
	
	public Encounter() {
		// TODO Auto-generated constructor stub
		this.encounterDate=new Date().getTime();
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public long getEncounterID() {
		return encounterID;
	}
	
	public void setEncounterID(long encounterID) {
		this.encounterID = encounterID;
	}
	
	public Encounter getFollowUp() {
		return followUp;
	}
	
	public Assessment getAssessment() {
		return assessment;
	}
	
	public Treatment getTreatment() {
		return treatment;
	}
	
	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}
	
	public void setFollowUp(Encounter followUp) {
		this.followUp = followUp;
	}
	
	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}
	
	public long getEncounterDate() {
		return encounterDate;
	}
	
	public void setEncounterDate(long encounterDate) {
		this.encounterDate = encounterDate;
	}
	
	
}
