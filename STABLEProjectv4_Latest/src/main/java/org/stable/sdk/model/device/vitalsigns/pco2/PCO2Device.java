package org.stable.sdk.model.device.vitalsigns.pco2;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.vitalsigns.pco2.PCO2_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.pco2.PCO2_Method_Type;

public class PCO2Device extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public PCO2Device() {
		super();
	}

	public PCO2Device(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	 public DeviceType defineDeviceType(){
		 return DeviceType.PCO2;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		PCO2_Method_Type PCO2Type = PCO2_Method_Type.valueOf(methodType);
		// int PCO2Value = Integer.parseInt(measurementValue);

		return new PCO2_Measurement(PCO2Type, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
