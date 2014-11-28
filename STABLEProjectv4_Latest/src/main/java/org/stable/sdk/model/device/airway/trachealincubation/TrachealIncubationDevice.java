package org.stable.sdk.model.device.airway.trachealincubation;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.airway.trachealincubation.TrachealIncubation_Measurement;
import org.stable.sdk.model.measurement.airway.trachealincubation.TrachealIncubation_Method_Type;

public class TrachealIncubationDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public TrachealIncubationDevice() {
		super();
	}

	public TrachealIncubationDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.TRACHEAL_INCUBATION;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		TrachealIncubation_Method_Type trachealIncubationType = TrachealIncubation_Method_Type
				.valueOf(methodType);

		return new TrachealIncubation_Measurement(trachealIncubationType,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
