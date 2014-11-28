package org.stable.sdk.service.measurement;

import org.stable.sdk.DAO.common.IDao;
import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.patient.Patient;
import org.stable.sdk.service.devices.DeviceService;
import org.stable.sdk.service.patient.PatientService;

public class MeasurementService implements IMeasurementService{

	private IDao<Measurement, Integer> measurementDao;
	private DeviceService deviceService;
	private PatientService patientService;
	
	public MeasurementService() {
		// TODO Auto-generated constructor stub
	}
	
	public IDao<Measurement, Integer> getMeasurementDao() {
		return measurementDao;
	}
	
	public void setMeasurementDao(IDao<Measurement, Integer> measurementDao) {
		this.measurementDao = measurementDao;
	}
	
	public DeviceService getDeviceService() {
		return deviceService;
	}
	
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}
	
	
	public PatientService getPatientService() {
		return patientService;
	}
	
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	public Measurement createMeasurement(int clinicID,int patientID,DeviceType deviceType,String methodType,String value){
	
		Patient patient = patientService.searchForAPatientByID(patientID);
		AbstractDevice abstractDevice = deviceService.searchForDevice(clinicID, deviceType).get(0);
		Measurement m = abstractDevice.getMeasurement(methodType, value);
		m.setPatient(patient);
		measurementDao.create(m);
		return m;
	}
	
}
