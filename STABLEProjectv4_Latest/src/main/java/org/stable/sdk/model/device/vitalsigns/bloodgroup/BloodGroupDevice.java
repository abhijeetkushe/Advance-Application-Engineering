package org.stable.sdk.model.device.vitalsigns.bloodgroup;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.vitalsigns.bloodgroup.BloodGroup_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.bloodgroup.BloodGroup_Method_Type;
import org.stable.sdk.model.measurement.vitalsigns.bloodgroup.BloodGroup_Value;

public class BloodGroupDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BloodGroupDevice() {
		super();
	}

	public BloodGroupDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.BLOOD_GROUP;
	 }
	
	public Measurement getMeasurement(String methodType, String measurementValue) {
		// TODO Auto-generated method stub

		BloodGroup_Method_Type BloodGroupType = BloodGroup_Method_Type
				.valueOf(methodType);
		BloodGroup_Value bloodGroupValue = BloodGroup_Value
				.valueOf(measurementValue);

		return new BloodGroup_Measurement(BloodGroupType, bloodGroupValue);
	}

}
