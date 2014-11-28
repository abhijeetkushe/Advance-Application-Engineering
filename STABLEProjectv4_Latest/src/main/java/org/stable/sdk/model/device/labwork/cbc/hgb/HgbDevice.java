package org.stable.sdk.model.device.labwork.cbc.hgb;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.cbc.hgb.Hgb_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.hgb.Hgb_Method_Type;

public class HgbDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public HgbDevice() {
		super();
	}

	public HgbDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.Hgb;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		Hgb_Method_Type hgb_Method_Type = Hgb_Method_Type.valueOf(methodType);

		return new Hgb_Measurement(hgb_Method_Type, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
