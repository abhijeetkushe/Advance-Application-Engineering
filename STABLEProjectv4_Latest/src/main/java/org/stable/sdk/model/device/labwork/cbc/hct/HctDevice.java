package org.stable.sdk.model.device.labwork.cbc.hct;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.cbc.hct.Hct_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.hct.Hct_Method_Type;

public class HctDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public HctDevice() {
		super();
	}

	public HctDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.Hct;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		Hct_Method_Type hct_Method_Type = Hct_Method_Type.valueOf(methodType);

		return new Hct_Measurement(hct_Method_Type, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
