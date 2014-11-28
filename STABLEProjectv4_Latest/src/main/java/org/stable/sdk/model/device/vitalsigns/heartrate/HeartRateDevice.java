package org.stable.sdk.model.device.vitalsigns.heartrate;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.vitalsigns.heartrate.HeartRate_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.heartrate.HeartRate_Method_Type;

public class HeartRateDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public HeartRateDevice() {
		super();
	}

	public HeartRateDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.HEART_RATE;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		HeartRate_Method_Type heartRateType = HeartRate_Method_Type
				.valueOf(methodType);

		return new HeartRate_Measurement(heartRateType, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
