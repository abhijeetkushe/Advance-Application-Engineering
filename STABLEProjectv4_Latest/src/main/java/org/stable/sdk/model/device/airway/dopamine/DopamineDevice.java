package org.stable.sdk.model.device.airway.dopamine;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.airway.dopamine.Dopamine_Measurement;
import org.stable.sdk.model.measurement.airway.dopamine.Dopamine_Method_Type;

public class DopamineDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public DopamineDevice() {
		super();
	}

	public DopamineDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.DOPAMINE;
	 }
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		Dopamine_Method_Type dopamineType = Dopamine_Method_Type
				.valueOf(methodType);

		return new Dopamine_Measurement(dopamineType, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
