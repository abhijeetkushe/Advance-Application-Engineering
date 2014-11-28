package org.stable.sdk.model.device.vitalsigns.temperature;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.vitalsigns.temperature.Temperature_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.temperature.Temperature_MethodType;

public class TemperatureDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public TemperatureDevice() {
		super();
	}

	public TemperatureDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.TEMPERATURE;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub
		Temperature_MethodType temperatureMethodType = Temperature_MethodType
				.valueOf(methodType);
		// float tempValue = Float.parseFloat(measurementValue);

		return new Temperature_Measurement(temperatureMethodType,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
