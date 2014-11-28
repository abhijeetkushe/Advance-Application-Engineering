/**
 * 
 */
package org.stable.sdk.model.device;

import java.util.Collection;
import java.util.List;

import org.stable.sdk.model.clinic.Clinic;
import org.stable.sdk.model.common.IStableModel;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.patient.PatientBedLocation;

/**
 * @author amuthanarulraj
 * 
 */
public interface IDevice extends IStableModel {

	public int getDeviceID();

	public void setDeviceID(int deviceID);

	public String getDeviceName();

	public void setDeviceName(String deviceName);

	public String getModelNumber();

	public void setModelNumber(String modelNumber);

	public String getInventoryNumber();

	public void setInventoryNumber(String inventoryNumber);

	public int getDeviceStatus();

	public void setDeviceStatus(int deviceStatus);

	public int getDeviceType();
	
	public Clinic getClinic();
	
	public void setClinic(Clinic clinic);	
	

	public void setDeviceType(int deviceType);
	
	public int getMeasurementType();
	
	public void setMeasurementType(int measurementType);

	public Collection<PatientBedLocation> getPatientBedLocList();

	public void setPatientBedLocList(Collection<PatientBedLocation> patientBedLocList);

	public Measurement getMeasurement(String type, String value);
}
