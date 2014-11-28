package org.stable.sdk.model.device.vitalsigns.o2saturation;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.vitalsigns.o2saturation.O2Saturation_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.o2saturation.O2Saturation_Method_Type;

public class O2SaturationDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public O2SaturationDevice() {
		super();
	}

	public O2SaturationDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.O2_SATURATION;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		O2Saturation_Method_Type O2SaturationType = O2Saturation_Method_Type
				.valueOf(methodType);
		// int O2SaturationValue = Integer.parseInt(measurementValue);

		return new O2Saturation_Measurement(O2SaturationType,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
