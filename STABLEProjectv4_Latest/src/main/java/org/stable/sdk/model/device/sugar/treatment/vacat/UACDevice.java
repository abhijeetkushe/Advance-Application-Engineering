package org.stable.sdk.model.device.sugar.treatment.vacat;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.sugar.treatment.vacat.UAC_Measurement;
import org.stable.sdk.model.measurement.sugar.treatment.vacat.UAC_Method_Type;

public class UACDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public UACDevice() {
		super();
	}

	public UACDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.UAC_AT;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		UAC_Method_Type uacMethodType = UAC_Method_Type.valueOf(methodType);

		return new UAC_Measurement(uacMethodType, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
