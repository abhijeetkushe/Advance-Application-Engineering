package org.stable.sdk.model.device;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.stable.sdk.model.clinic.Clinic;
import org.stable.sdk.model.measurement.IMeasurementType;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.patient.PatientBedLocation;

public abstract class AbstractDevice implements IDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Identifying the Device <br>
	 * DeviceID 	:- System Identification <br>
	 * DeviceName 	:- Device Name <br>
	 * ModelNumber 	:- Device Model Number <br>
	 * InventoryNo 	:- The Inventory Number
	 */
	private int deviceID;
	
	private String deviceName;
	private String modelNumber;
	private String inventoryNumber;
	
	private int deviceStatus;
	private int deviceType;
	
	private int measurementType;
	private Collection<PatientBedLocation> patientBedLocList;

	private Clinic clinic; 	//Bi-Directional Mapping
	

	public AbstractDevice() {
		super();
		patientBedLocList = new ArrayList<PatientBedLocation>();
		setDeviceStatusEnum(DeviceStatus.AVAILIABLE);
	}

	public AbstractDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		this();
		this.deviceName = deviceName;
		this.modelNumber = modelNumber;
		this.inventoryNumber = inventoryNumber;
	}

	// abstract public Measurement getMeasurement(String type, String value);

	/**
	 * @return the deviceID
	 */
	public int getDeviceID() {
		return deviceID;
	}

	/**
	 * @param deviceID
	 *            the deviceID to set
	 */
	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
	}

	public Clinic getClinic() {
		return clinic;
	}
	
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @param deviceName
	 *            the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * @return the modelNumber
	 */
	public String getModelNumber() {
		return modelNumber;
	}

	/**
	 * @param modelNumber
	 *            the modelNumber to set
	 */
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	/**
	 * @return the inventoryNumber
	 */
	public String getInventoryNumber() {
		return inventoryNumber;
	}

	/**
	 * @param inventoryNumber
	 *            the inventoryNumber to set
	 */
	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	/**
	 * @return the deviceStatus
	 */
	public int getDeviceStatus() {
		return deviceStatus;
	}

	/**
	 * @param deviceStatus
	 *            the deviceStatus to set
	 */
	public void setDeviceStatus(int deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

//	/**
//	 * @return the DeviceStatus
//	 */
//	public DeviceStatus getDeviceStatusEnum() {
//	
//		for (DeviceStatus ds : DeviceStatus.values()) {
//			if (getDeviceStatus() == ds.getId()) {
//				return ds;
//			}
//		}
//		return null;
//	}
//	

	/**
	 * @param deviceStatus
	 *            the deviceStatus to set
	 */
	public void setDeviceStatusEnum(DeviceStatus deviceStatus) {
		setDeviceStatus(deviceStatus.getId());
	}

	
	abstract public DeviceType defineDeviceType();
	/**
	 * @return the deviceType
	 */
	public int getDeviceType() {
		return defineDeviceType().getId();
	}

	/**
	 * @param deviceType
	 *            the deviceType to set
	 */
	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the measurementType
	 */
	public int getMeasurementType() {
		return measurementType;
	}

	/**
	 * @param measurementType
	 *            the measurementType to set
	 */
	public void setMeasurementType(int measurementType) {
		this.measurementType = measurementType;
	}
	
	/**
	 * @return the measurementType
	 */
//	public MeasurementType getMeasurementTypeEnum() {
//		for(MeasurementType mt : MeasurementType.values()){
//			if(getMeasurementType() == mt.getId()){
//				return mt;
//			}
//		}
//		return null;
//	}

	/**
	 * @param measurementType
	 *            the measurementType to set
	 */
	public void setMeasurementTypeEnum(MeasurementType measurementType) {
		setMeasurementType(measurementType.getId());
	}

	/**
	 * <p>
	 * Retrives current bed locations
	 * </p>
	 * 
	 * @return the patientBedLocList
	 */
	public Collection<PatientBedLocation> getPatientBedLocList() {
		return patientBedLocList;
	}

	/**
	 * @param patientBedLocList
	 *            the patientBedLocList to set
	 */
	public void setPatientBedLocList(Collection<PatientBedLocation> patientBedLocList) {
		this.patientBedLocList = patientBedLocList;
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
		result = prime * result + deviceID;
		result = prime * result
				+ ((deviceName == null) ? 0 : deviceName.hashCode());
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
		if (!(obj instanceof AbstractDevice)) {
			return false;
		}
		AbstractDevice other = (AbstractDevice) obj;
		if (deviceID != other.deviceID) {
			return false;
		}
		if (deviceName == null) {
			if (other.deviceName != null) {
				return false;
			}
		} else if (!deviceName.equals(other.deviceName)) {
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
		return deviceName != null ? deviceName : "";
	}

}
