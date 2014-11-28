package org.stable.sdk.model.device.vitalsigns.hco3;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.vitalsigns.hco3.HCO3_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.hco3.HCO3_Method_Type;

public class HCO3Device extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public HCO3Device() {
		super();
	}

	public HCO3Device(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.HCO3;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		HCO3_Method_Type hco3Type = HCO3_Method_Type.valueOf(methodType);

		return new HCO3_Measurement(hco3Type, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
