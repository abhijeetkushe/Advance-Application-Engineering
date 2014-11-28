package org.stable.sdk.model.device.labwork.cbc.lymphs;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.cbc.lymphs.Lymphs_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.lymphs.Lymphs_Method_Type;

public class LymphsDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public LymphsDevice() {
		super();
	}

	public LymphsDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.LYMPHS;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		Lymphs_Method_Type lymphs_Method_Type = Lymphs_Method_Type
				.valueOf(methodType);

		return new Lymphs_Measurement(lymphs_Method_Type,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
