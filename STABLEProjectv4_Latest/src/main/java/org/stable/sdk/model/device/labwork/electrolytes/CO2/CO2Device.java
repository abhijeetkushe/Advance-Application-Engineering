package org.stable.sdk.model.device.labwork.electrolytes.CO2;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.electrolytes.CO2.CO2_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.CO2.CO2_Method_Type;

public class CO2Device extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public CO2Device() {
		super();
	}

	public CO2Device(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.CO2;
	 }
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		CO2_Method_Type cO2_Method_Type = CO2_Method_Type.valueOf(methodType);

		return new CO2_Measurement(cO2_Method_Type, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
