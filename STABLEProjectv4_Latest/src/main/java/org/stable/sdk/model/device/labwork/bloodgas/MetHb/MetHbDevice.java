package org.stable.sdk.model.device.labwork.bloodgas.MetHb;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.bloodgas.MetHb.MetHb_Measurement;
import org.stable.sdk.model.measurement.labwork.bloodgas.MetHb.MetHb_Method_Type;

public class MetHbDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public MetHbDevice() {
		super();
	}

	public MetHbDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.MetHb;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		MetHb_Method_Type metHb_Method_Type = MetHb_Method_Type
				.valueOf(methodType);

		return new MetHb_Measurement(metHb_Method_Type, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
