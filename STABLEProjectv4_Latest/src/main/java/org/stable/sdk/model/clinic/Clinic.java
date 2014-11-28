package org.stable.sdk.model.clinic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.stable.sdk.model.bedlocation.BedLocation;
import org.stable.sdk.model.common.IStableModel;
import org.stable.sdk.model.device.IDevice;
import org.stable.sdk.model.patient.Patient;
import org.stable.sdk.model.person.Employee;
import org.stable.sdk.model.person.UserAccount;

public class Clinic implements IStableModel {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;
	private int clinicID;
	private String clinicName = "";
	private Set<Patient> patientList;
	private Set<Employee> employeeDirectory;
	private Map<String, IDevice> deviceInventoryList;
	private Map<String, BedLocation> bedLocations;
	private Map<String, CareTeam> careTeams;
	private List<UserAccount> userAccountDirectory;
	
	public Clinic() {
		super();
		bedLocations = new HashMap<String, BedLocation>();
		patientList = new HashSet<Patient>();
		employeeDirectory = new HashSet<Employee>();
		deviceInventoryList = new HashMap<String, IDevice>();
		careTeams = new HashMap<String, CareTeam>();
		userAccountDirectory = new ArrayList<UserAccount>();
	}

	/**
	 * @return the clinicID
	 */
	public int getClinicID() {
		return clinicID;
	}

	/**
	 * @param clinicID
	 *            the clinicID to set
	 */
	public void setClinicID(int clinicID) {
		this.clinicID = clinicID;
	}

	/**
	 * @return the clinicName
	 */
	public String getClinicName() {
		return clinicName;
	}

	/**
	 * @param clinicName
	 *            the clinicName to set
	 */
	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	/**
	 * @return the patientList
	 */
	public Set<Patient> getPatientList() {
		return patientList;
	}

	/**
	 * @param patientList
	 *            the patientList to set
	 */
	public void setPatientList(Set<Patient> patientList) {
		this.patientList = patientList;
	}

	/**
	 * @return the employeeDirectory
	 */
	public Set<Employee> getEmployeeDirectory() {
		return employeeDirectory;
	}

	/**
	 * @param employeeDirectory
	 *            the employeeDirectory to set
	 */
	public void setEmployeeDirectory(Set<Employee> employeeDirectory) {
		this.employeeDirectory = employeeDirectory;
	}

	/**
	 * @return the deviceInventoryList
	 */
	public Map<String, IDevice> getDeviceInventoryList() {
		return deviceInventoryList;
	}

	/**
	 * @param deviceInventoryList
	 *            the deviceInventoryList to set
	 */
	public void setDeviceInventoryList(Map<String, IDevice> deviceInventoryList) {
		this.deviceInventoryList = deviceInventoryList;
	}

	/**
	 * @return the bedLocations
	 */
	public Map<String, BedLocation> getBedLocations() {
		return bedLocations;
	}

	/**
	 * @param bedLocations
	 *            the bedLocations to set
	 */
	public void setBedLocations(Map<String, BedLocation> bedLocations) {
		this.bedLocations = bedLocations;
	}

	/**
	 * @return the careTeams
	 */
	public Map<String, CareTeam> getCareTeams() {
		return careTeams;
	}

	/**
	 * @param careTeams
	 *            the careTeams to set
	 */
	public void setCareTeams(Map<String, CareTeam> careTeams) {
		this.careTeams = careTeams;
	}

	/**
	 * @return the userAccountDirectory
	 */
	public List<UserAccount> getUserAccountDirectory() {
		return userAccountDirectory;
	}

	/**
	 * @param userAccountDirectory
	 *            the userAccountDirectory to set
	 */
	public void setUserAccountDirectory(List<UserAccount> userAccountDirectory) {
		this.userAccountDirectory = userAccountDirectory;
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
		result = prime * result + clinicID;
		result = prime * result
				+ ((clinicName == null) ? 0 : clinicName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clinic other = (Clinic) obj;
		if (clinicID != other.clinicID)
			return false;
		if (clinicName == null) {
			if (other.clinicName != null)
				return false;
		} else if (!clinicName.equals(other.clinicName))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return clinicName;
	}

}
