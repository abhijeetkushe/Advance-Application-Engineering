package org.stable.sdk.model.device.sugar.glucoselevel;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.sugar.glucoselevel.GlucoseLevel_Measurement;
import org.stable.sdk.model.measurement.sugar.glucoselevel.GlucoseLevel_Method_Type;

public class GlucoseLevelDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public GlucoseLevelDevice() {
		super();
	}

	public GlucoseLevelDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	 public DeviceType defineDeviceType(){
		 return DeviceType.GLUCOSE_LEVEL;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		GlucoseLevel_Method_Type apgarType = GlucoseLevel_Method_Type
				.valueOf(methodType);

		return new GlucoseLevel_Measurement(apgarType, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
