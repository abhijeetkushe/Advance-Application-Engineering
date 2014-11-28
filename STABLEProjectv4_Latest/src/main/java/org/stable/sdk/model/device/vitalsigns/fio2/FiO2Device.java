package org.stable.sdk.model.device.vitalsigns.fio2;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.vitalsigns.fio2.FiO2_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.fio2.FiO2_Method_Type;

public class FiO2Device extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public FiO2Device() {
		super();
	}

	public FiO2Device(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.FiO2;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		FiO2_Method_Type fiO2Type = FiO2_Method_Type.valueOf(methodType);

		return new FiO2_Measurement(fiO2Type, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
