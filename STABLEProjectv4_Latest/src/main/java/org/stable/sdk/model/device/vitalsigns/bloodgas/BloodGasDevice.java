package org.stable.sdk.model.device.vitalsigns.bloodgas;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.vitalsigns.bloodgas.*;

public class BloodGasDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BloodGasDevice() {
		super();
	}

	public BloodGasDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);

	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.BLOOD_GAS;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		BloodGas_Method_Type BloodGasType = BloodGas_Method_Type.valueOf(methodType);
		// int BloodGasValue = Integer.parseInt(measurementValue);

		return new BloodGas_Measurement(BloodGasType, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
