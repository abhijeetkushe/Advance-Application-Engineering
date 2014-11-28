package org.stable.sdk.model.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.stable.sdk.model.clinic.CareTeam;
import org.stable.sdk.model.common.Gender;
import org.stable.sdk.model.common.IStableModel;
import org.stable.sdk.model.patient.PatientBedLocation;

public class Employee implements IStableModel {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;
	private int employeeID;
	private String firstName;
	private String lastName;
	private String middleName;
	private String preferredName;
	private int gender;
	private boolean isActive;
	private int role;
	
	private Map<String, CareTeam> careTeams;
	private List<PatientBedLocation> currentPBLList;

	public Employee() {
		super();
		careTeams = new HashMap<String, CareTeam>();
		currentPBLList = new ArrayList<PatientBedLocation>();
	}

	/**
	 * @return the employeeID
	 */
	public int getEmployeeID() {
		return employeeID;
	}

	/**
	 * @param employeeID
	 *            the employeeID to set
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the preferredName
	 */
	public String getPreferredName() {
		return preferredName;
	}

	/**
	 * @param preferredName
	 *            the preferredName to set
	 */
	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}

	/**
	 * @return the gender
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * @return the gender
	 */
	public Gender getGenderEnum() {
		for (Gender g : Gender.values()) {
			if (getGender() == g.getId()) {
				return g;
			}
		}
		return null;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGenderEnum(Gender gender) {
		setGender(gender.getId());
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}

	/**
	 * @return the role
	 */
	public Role getRoleEnum() {
		for (Role r : Role.values()) {
			if (getRole() == r.getId()) {
				return r;
			}
		}
		return null;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRoleEnum(Role role) {
		setRole(role.getId());
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
	 * @return the currentPBLList
	 */
	public List<PatientBedLocation> getCurrentPBLList() {
		return currentPBLList;
	}

	/**
	 * @param currentPBLList
	 *            the currentPBLList to set
	 */
	public void setCurrentPBLList(List<PatientBedLocation> currentPBLList) {
		this.currentPBLList = currentPBLList;
	}

	public String fullName() {
		return (lastName != null ? lastName + ", " : "")
				+ (firstName != null ? firstName : "");
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
		result = prime * result + employeeID;
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
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (employeeID != other.employeeID) {
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
		return preferredName != null ? preferredName : "";
	}

}
