package org.stable.sdk.model.device.labwork.electrolytes.Na;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.electrolytes.Na.Na_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.Na.Na_Method_Type;

public class NaDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public NaDevice() {
		super();
	}

	public NaDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	
	 public DeviceType defineDeviceType(){
		 return DeviceType.Na;
	 }
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		Na_Method_Type na_Method_Type = Na_Method_Type.valueOf(methodType);

		return new Na_Measurement(na_Method_Type, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
