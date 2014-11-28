package org.stable.sdk.model.device.sugar.headcircumference;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.sugar.headcircumference.HeadCircumference_Measurement;
import org.stable.sdk.model.measurement.sugar.headcircumference.HeadCircumference_Method_Type;

public class HeadCircumferenceDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public HeadCircumferenceDevice() {
		super();
	}

	public HeadCircumferenceDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	public DeviceType defineDeviceType(){
		 return DeviceType.HEAD_CIRCUMFRENCE;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		HeadCircumference_Method_Type headCircumferenceType = HeadCircumference_Method_Type
				.valueOf(methodType);

		return new HeadCircumference_Measurement(headCircumferenceType,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
