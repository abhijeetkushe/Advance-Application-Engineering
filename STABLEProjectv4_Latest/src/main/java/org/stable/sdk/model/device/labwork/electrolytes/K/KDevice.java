package org.stable.sdk.model.device.labwork.electrolytes.K;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.electrolytes.K.K_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.K.K_Method_Type;

public class KDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public KDevice() {
		super();
	}

	public KDevice(String deviceName, String modelNumber, String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.K;
	 }	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		K_Method_Type k_Method_Type = K_Method_Type.valueOf(methodType);

		return new K_Measurement(k_Method_Type, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
