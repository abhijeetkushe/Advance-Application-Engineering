package org.stable.sdk.model.device.sugar.gestationalage;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.sugar.gestationalage.GestationalAgeValue;
import org.stable.sdk.model.measurement.sugar.gestationalage.GestationalAge_Measurement;
import org.stable.sdk.model.measurement.sugar.gestationalage.GestationalAge_Method_Type;

public class GestationalAgeDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public GestationalAgeDevice() {
		super();
	}

	public GestationalAgeDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	 public DeviceType defineDeviceType(){
		 return DeviceType.GESTATIONAL_AGE;
	 }
	public Measurement getMeasurement(String methodType, String measurementValue) {
		// TODO Auto-generated method stub
		GestationalAge_Method_Type gestationalAgeType = GestationalAge_Method_Type.valueOf(methodType);
		int tempWeeks = Integer.parseInt(measurementValue.split("-")[0]);
		int tempDay = Integer.parseInt(measurementValue.split("-")[1]);
		GestationalAgeValue gestationalAgeValue = new GestationalAgeValue(tempWeeks, tempDay);

		return new GestationalAge_Measurement(gestationalAgeType,
				gestationalAgeValue);
	}

}
