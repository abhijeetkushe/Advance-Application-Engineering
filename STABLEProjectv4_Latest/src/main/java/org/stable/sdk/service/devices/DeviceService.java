package org.stable.sdk.service.devices;

import java.util.ArrayList;

import org.stable.sdk.DAO.common.IDao;
import org.stable.sdk.model.clinic.Clinic;
import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceFactory;
import org.stable.sdk.model.device.DeviceType;

public class DeviceService implements IDeviceService {

	// private IDao<Dev, Serializable>
	private IDao<AbstractDevice, Integer> deviceDao;

	public DeviceService() {
		// TODO Auto-generated constructor stub
	}

	public IDao<AbstractDevice, Integer> getDeviceDao() {
		return deviceDao;
	}

	public void setDeviceDao(IDao<AbstractDevice, Integer> deviceDao) {
		System.out.println("DEVICE IS REVEIVING A DAO");
		this.deviceDao = deviceDao;
	}

	public AbstractDevice saveDevice(DeviceType deviceType,
			String inventoryNumber, Clinic clinic) {
		AbstractDevice abstractDevice = DeviceFactory.createDevice(deviceType,
				inventoryNumber, clinic);
		deviceDao.create(abstractDevice);
		return abstractDevice;
	}

	public ArrayList<AbstractDevice> searchForDevice(int clinicID,
			DeviceType deviceType) {
		ArrayList<AbstractDevice> deviceTypeDevices = new ArrayList<AbstractDevice>();
		ArrayList<AbstractDevice> abstractDevices = deviceDao.loadAll();
		for (AbstractDevice d : abstractDevices) {
			
			if(d.getClinic().getClinicID()==clinicID && d.getDeviceType() == deviceType.getId()){
				deviceTypeDevices.add(d);
			}
		}

		return deviceTypeDevices;
	}
}
