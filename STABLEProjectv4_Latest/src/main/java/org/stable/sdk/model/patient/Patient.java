package org.stable.sdk.model.patient;

import java.util.ArrayList;
import java.util.List;

import org.stable.sdk.model.clinic.Clinic;
import org.stable.sdk.model.common.IStableModel;
import org.stable.sdk.model.encounter.Encounter;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.vitalsigns.bloodpressure.BloodPressure_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.heartrate.HeartRate_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.temperature.Temperature_Measurement;

public class Patient implements IStableModel {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;
	private int patientID;
	private String patientTag = "";
	private Clinic clinic;
	private int status;
	private Person person;
	private String medicalRecord;
	private String location;
	
	private List<Measurement> measurements;
	private List<Encounter> encounters;
	private List<PatientBedLocation> patientBedList;

	private List<BloodPressure_Measurement> bloodPressure_Measurements;
	private List<Temperature_Measurement> temperature_Measurements;
	private List<HeartRate_Measurement> heartRate_Measurements;
	
//	private List<BloodPressure_Measurement> bloodPressure_Measurements;
//	private List<BloodPressure_Measurement> bloodPressure_Measurements;
//	private List<BloodPressure_Measurement> bloodPressure_Measurements;
	
	
	public Patient() {
		super();
		measurements = new ArrayList<Measurement>();
		patientBedList = new ArrayList<PatientBedLocation>();
		encounters = new ArrayList<Encounter>();
		
		
		
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(String medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public Patient(String patientTag) {
		super();
		System.out.println("Patient(patientTag)");
		this.patientTag = patientTag;
		measurements = new ArrayList<Measurement>();
		patientBedList = new ArrayList<PatientBedLocation>();
		encounters = new ArrayList<Encounter>();
	}

	/**
	 * @return the patientID
	 */
	public int getPatientID() {
		return patientID;
	}
	
	

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	/**
	 * @param patientID
	 *            the patientID to set
	 */
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	/**
	 * @return the patientTag
	 */
	public String getPatientTag() {
		return patientTag;
	}

	/**
	 * @param patientTag
	 *            the patientTag to set
	 */
	public void setPatientTag(String patientTag) {
		this.patientTag = patientTag;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public PatientStatus getStatusEnum() {
		for (PatientStatus ps : PatientStatus.values()) {
			if (getStatus() == ps.getId()) {
				return ps;
			}
		}
		return null;
	}

	/**
	 * @param patientStatus
	 *            the patientStatus to set
	 */
	public void setStatusEnum(PatientStatus patientStatus) {
		setStatus(patientStatus.getId());
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person
	 *            the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the measurements
	 */
	public List<Measurement> getMeasurements() {
		return measurements;
	}

	/**
	 * @param measurements
	 *            the measurements to set
	 */
	public void setMeasurements(List<Measurement> measurements) {
		this.measurements = measurements;
	}

	/**
	 * @return the patientBedList
	 */
	public List<PatientBedLocation> getPatientBedList() {
		return patientBedList;
	}

	/**
	 * @param patientBedList
	 *            the patientBedList to set
	 */
	public void setPatientBedList(List<PatientBedLocation> patientBedList) {
		this.patientBedList = patientBedList;
	}
	
	
	public List<Encounter> getEncounters() {
		return encounters;
	}
	
	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (patientID ^ (patientID >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Patient)) {
			return false;
		}
		Patient other = (Patient) obj;
		if (patientID != other.patientID) {
			return false;
		}
		return true;
	}
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return patientTag != null ? patientTag : "";
	}

}
