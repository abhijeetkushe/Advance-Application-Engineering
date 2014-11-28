package org.stable.sdk.model.device.labwork.cbc.monos;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.cbc.monos.Monos_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.monos.Monos_Method_Type;

public class MonosDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public MonosDevice() {
		super();
	}

	public MonosDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.MONOS;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		Monos_Method_Type monos_Method_Type = Monos_Method_Type
				.valueOf(methodType);

		return new Monos_Measurement(monos_Method_Type, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
