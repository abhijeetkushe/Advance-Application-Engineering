package org.stable.sdk.model.clinic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.stable.sdk.model.bedlocation.BedLocation;
import org.stable.sdk.model.common.IStableModel;
import org.stable.sdk.model.patient.PatientBedLocation;
import org.stable.sdk.model.person.Employee;

public class CareTeam implements IStableModel {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;
	private int careTeamID;
	private String careTeamName;
	private Employee teamLeader;
	private Set<Employee> teamMembers;
	private Map<String, BedLocation> bedLocationList;
	private List<PatientBedLocation> patientBedList;

	public CareTeam() {
		super();
		teamMembers = new HashSet<Employee>();
		bedLocationList = new HashMap<String, BedLocation>();
		patientBedList = new ArrayList<PatientBedLocation>();
	}

	/**
	 * @return the careTeamID
	 */
	public int getCareTeamID() {
		return careTeamID;
	}

	/**
	 * @param careTeamID
	 *            the careTeamID to set
	 */
	public void setCareTeamID(int careTeamID) {
		this.careTeamID = careTeamID;
	}

	/**
	 * @return the careTeamName
	 */
	public String getCareTeamName() {
		return careTeamName;
	}

	/**
	 * @param careTeamName
	 *            the careTeamName to set
	 */
	public void setCareTeamName(String careTeamName) {
		this.careTeamName = careTeamName;
	}

	/**
	 * @return the teamLeader
	 */
	public Employee getTeamLeader() {
		return teamLeader;
	}

	/**
	 * @param teamLeader
	 *            the teamLeader to set
	 */
	public void setTeamLeader(Employee teamLeader) {
		this.teamLeader = teamLeader;
	}

	/**
	 * @return the teamMembers
	 */
	public Set<Employee> getTeamMembers() {
		return teamMembers;
	}

	/**
	 * @param teamMembers
	 *            the teamMembers to set
	 */
	public void setTeamMembers(Set<Employee> teamMembers) {
		this.teamMembers = teamMembers;
	}

	/**
	 * @return the bedLocationList
	 */
	public Map<String, BedLocation> getBedLocationList() {
		return bedLocationList;
	}

	/**
	 * @param bedLocationList
	 *            the bedLocationList to set
	 */
	public void setBedLocationList(Map<String, BedLocation> bedLocationList) {
		this.bedLocationList = bedLocationList;
	}

	/**
	 * <p>
	 * Retrieves only active patient bed locations
	 * </p>
	 * 
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + careTeamID;
		result = prime * result
				+ ((careTeamName == null) ? 0 : careTeamName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CareTeam other = (CareTeam) obj;
		if (careTeamID != other.careTeamID)
			return false;
		if (careTeamName == null) {
			if (other.careTeamName != null)
				return false;
		} else if (!careTeamName.equals(other.careTeamName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return careTeamName;
	}

}
