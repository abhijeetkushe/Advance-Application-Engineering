/**
 * 
 */
package org.stable.sdk.model.patient;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.stable.sdk.model.bedlocation.BedLocation;
import org.stable.sdk.model.common.IStableModel;
import org.stable.sdk.model.device.IDevice;
import org.stable.sdk.model.person.Employee;

/**
 * @author Dsousa
 * 
 */
public class PatientBedLocation implements IStableModel {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;
	private int patientBedLocID;
	private Patient patient;
	private BedLocation bedLocation;
	private int status;
	private Date admittedOn;
	private Date dischargedOn;
	private List<Employee> careTakers;
	private Map<String, IDevice> deviceList;

	public PatientBedLocation() {
		super();
		careTakers = new ArrayList<Employee>();
		deviceList = new HashMap<String, IDevice>();
	}

	/**
	 * @return the patientBedLocID
	 */
	public int getPatientBedLocID() {
		return patientBedLocID;
	}

	/**
	 * @param patientBedLocID
	 *            the patientBedLocID to set
	 */
	public void setPatientBedLocID(int patientBedLocID) {
		this.patientBedLocID = patientBedLocID;
	}

	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient
	 *            the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * @return the bedLocation
	 */
	public BedLocation getBedLocation() {
		return bedLocation;
	}

	/**
	 * @param bedLocation
	 *            the bedLocation to set
	 */
	public void setBedLocation(BedLocation bedLocation) {
		this.bedLocation = bedLocation;
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
	 * @return the PBLStatus
	 */
	public PBLStatus getStatusEnum() {
		for (PBLStatus ps : PBLStatus.values()) {
			if (getStatus() == ps.getId()) {
				return ps;
			}
		}
		return null;
	}

	/**
	 * @param pblStatus
	 *            the pblStatus to set
	 */
	public void setStatusEnum(PBLStatus pblStatus) {
		setStatus(pblStatus.getId());
	}

	/**
	 * @return the admittedOn
	 */
	public Date getAdmittedOn() {
		return admittedOn;
	}

	/**
	 * @param admittedOn
	 *            the admittedOn to set
	 */
	public void setAdmittedOn(Date admittedOn) {
		this.admittedOn = admittedOn;
	}

	/**
	 * @return the dischargedOn
	 */
	public Date getDischargedOn() {
		return dischargedOn;
	}

	/**
	 * @param dischargedOn
	 *            the dischargedOn to set
	 */
	public void setDischargedOn(Date dischargedOn) {
		this.dischargedOn = dischargedOn;
	}

	/**
	 * @return the careTakers
	 */
	public List<Employee> getCareTakers() {
		return careTakers;
	}

	/**
	 * @param careTakers
	 *            the careTakers to set
	 */
	public void setCareTakers(List<Employee> careTakers) {
		this.careTakers = careTakers;
	}

	/**
	 * @return the deviceList
	 */
	public Map<String, IDevice> getDeviceList() {
		return deviceList;
	}

	/**
	 * @param deviceList
	 *            the deviceList to set
	 */
	public void setDeviceList(Map<String, IDevice> deviceList) {
		this.deviceList = deviceList;
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
		result = prime * result
				+ (int) (patientBedLocID ^ (patientBedLocID >>> 32));
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
		if (!(obj instanceof PatientBedLocation)) {
			return false;
		}
		PatientBedLocation other = (PatientBedLocation) obj;
		if (patientBedLocID != other.patientBedLocID) {
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
		return (patient != null ? patient.toString() + " " : "")
				+ ("status:" + status);
	}

}
