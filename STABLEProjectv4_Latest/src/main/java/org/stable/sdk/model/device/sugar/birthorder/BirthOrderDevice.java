package org.stable.sdk.model.device.sugar.birthorder;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.sugar.birthorder.BirthOrder_Measurement;
import org.stable.sdk.model.measurement.sugar.birthorder.BirthOrder_Method_Type;

public class BirthOrderDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BirthOrderDevice() {
		super();
	}

	public BirthOrderDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.BIRTH_ORDER;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		BirthOrder_Method_Type birthOrderType = BirthOrder_Method_Type
				.valueOf(methodType);

		return new BirthOrder_Measurement(birthOrderType,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
