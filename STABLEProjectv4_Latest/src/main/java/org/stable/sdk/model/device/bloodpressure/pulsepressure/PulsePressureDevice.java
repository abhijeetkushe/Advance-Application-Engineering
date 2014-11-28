package org.stable.sdk.model.device.bloodpressure.pulsepressure;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.bloodpressure.pulsepressure.PulsePressure_Measurement;
import org.stable.sdk.model.measurement.bloodpressure.pulsepressure.PulsePressure_Method_Type;

public class PulsePressureDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public PulsePressureDevice() {
		super();
	}

	public PulsePressureDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.PULSE_PRESSURE;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		PulsePressure_Method_Type pulsePressureType = PulsePressure_Method_Type
				.valueOf(methodType);

		return new PulsePressure_Measurement(pulsePressureType,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
