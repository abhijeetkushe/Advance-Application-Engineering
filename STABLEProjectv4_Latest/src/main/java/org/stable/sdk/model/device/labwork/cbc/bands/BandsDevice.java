package org.stable.sdk.model.device.labwork.cbc.bands;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.cbc.bands.Bands_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.bands.Bands_Method_Type;

public class BandsDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BandsDevice() {
		super();
	}

	public BandsDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.BANDS;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		Bands_Method_Type bands_Method_Type = Bands_Method_Type
				.valueOf(methodType);

		return new Bands_Measurement(bands_Method_Type, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
