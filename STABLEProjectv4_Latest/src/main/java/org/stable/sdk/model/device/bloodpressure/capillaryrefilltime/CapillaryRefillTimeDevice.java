package org.stable.sdk.model.device.bloodpressure.capillaryrefilltime;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.bloodpressure.capillaryrefilltime.CapillaryRefillTime_Measurement;
import org.stable.sdk.model.measurement.bloodpressure.capillaryrefilltime.CapillaryRefillTime_Method_Type;

public class CapillaryRefillTimeDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public CapillaryRefillTimeDevice() {
		super();
	}

	public CapillaryRefillTimeDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.CAPILLARY_REFILL_TIME;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		CapillaryRefillTime_Method_Type capillaryRefillTimeType = CapillaryRefillTime_Method_Type
				.valueOf(methodType);

		return new CapillaryRefillTime_Measurement(capillaryRefillTimeType,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
