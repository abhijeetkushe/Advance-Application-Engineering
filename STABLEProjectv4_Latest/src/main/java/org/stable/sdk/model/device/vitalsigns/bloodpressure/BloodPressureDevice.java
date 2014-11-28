package org.stable.sdk.model.device.vitalsigns.bloodpressure;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.vitalsigns.bloodpressure.BloodPressureValue;
import org.stable.sdk.model.measurement.vitalsigns.bloodpressure.BloodPressure_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.bloodpressure.BloodPressure_Method_Type;

public class BloodPressureDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BloodPressureDevice() {
		super();
	}

	public BloodPressureDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.BLOOD_PRESSURE;
	 }
	
	public Measurement getMeasurement(String methodType, String measurementValue) {
		// TODO Auto-generated method stub

		BloodPressure_Method_Type bloodPressureType = BloodPressure_Method_Type
				.valueOf(methodType);

		int tempSystolicValue = Integer
				.parseInt(measurementValue.split("///")[0]);
		int tempDystolicValue = Integer
				.parseInt(measurementValue.split("///")[1]);
		BloodPressureValue bloodPressureValue = new BloodPressureValue(
				tempSystolicValue, tempDystolicValue);

		return new BloodPressure_Measurement(bloodPressureType,
				bloodPressureValue);
	}

}
