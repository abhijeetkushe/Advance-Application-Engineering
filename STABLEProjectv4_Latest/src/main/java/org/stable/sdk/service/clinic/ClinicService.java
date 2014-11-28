package org.stable.sdk.service.clinic;

import org.hibernate.HibernateException;
import org.stable.sdk.DAO.common.IDao;
import org.stable.sdk.model.clinic.Clinic;
import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceFactory;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.device.IDevice;
import org.stable.sdk.model.patient.Patient;
import org.stable.sdk.service.devices.DeviceService;

public class ClinicService {

	
	private IDao<Clinic, Integer> clinicalDao;
	private IDao<AbstractDevice, Integer> deviceDao;
	
	
	public ClinicService() {
		 System.out.println("Clinical Service "+clinicalDao);
		 
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public void setClinicalDao(IDao<Clinic, Integer> clinicalDao) {
		this.clinicalDao = clinicalDao;
	}
	
	private Clinic getClinic(Integer id){
		return clinicalDao.read(id);
	}
	
	
	public void setDeviceDao(IDao<AbstractDevice, Integer> deviceDao) {
		this.deviceDao = deviceDao;
	}
	
	public IDao<AbstractDevice, Integer> getDeviceDao() {
		return deviceDao;
	}
	
	
	public String getClinicName(Integer id){
		return getClinic(id).getClinicName();
		
	}
	
	public IDevice getDeviceByInventoryNumber(Integer id,String inventoryNumber){
		
		IDevice device = getClinic(id).getDeviceInventoryList().get(inventoryNumber);
		System.out.println("THIS IS THE DEVICE"+device);
		
		return device;
	}
	
	
	public Patient getPatientByID(Integer clinicId,Integer patientId){
		
		for(Patient p:getClinic(clinicId).getPatientList()){
			if(p.getPatientID()==patientId){
				return p;
			}
		}
		return null;
		
	}
	
	
	public boolean addDevice(Integer clinicId,
			String inventoryNumber,
		//	String deviceName,
		//	String modelNumber,
			DeviceType deviceType){
		Clinic clinic = null;
		try{
		//1. Read Clinic for given ID
		clinic =getClinic(clinicId);
		
		//2. Use the Device Service 
		DeviceService deviceService = new DeviceService();
		
		//3. Add the Device based on the clinic
		
		//AbstractDevice abstractDevice = deviceService.saveDevice(deviceType, inventoryNumber,c);
		//OR
		
		AbstractDevice abstractDevice = DeviceFactory.createDevice(deviceType,inventoryNumber,clinic);
		deviceDao.create(abstractDevice);
		
		
		
		return true;
		}catch(HibernateException he){
			he.printStackTrace();
			return false;
		}finally{
			if(clinic!=null)
			System.out.println("These are the number of devices "+clinic.getDeviceInventoryList());
		}
	}
	
	public void readAll(){
		clinicalDao.loadAll();
	}
	
	public DeviceType[] getListOfDevices(){
		
		return DeviceType.values();
		
	}
	
}
