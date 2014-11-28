package org.stable.sdk.model.device.airway.o2inuse;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.airway.o2inuse.O2InUse_Measurement;
import org.stable.sdk.model.measurement.airway.o2inuse.O2InUse_Method_Type;

public class O2InUseDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public O2InUseDevice() {
		super();
	}

	public O2InUseDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.O2_IN_USE;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		O2InUse_Method_Type O2InUseType = O2InUse_Method_Type
				.valueOf(methodType);
		// int O2InUseValue = Integer.parseInt(measurementValue);

		return new O2InUse_Measurement(O2InUseType, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
