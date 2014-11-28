package org.stable.sdk.model.device.labwork.cbc.plts;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.cbc.plts.PLTS_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.plts.PLTS_Method_Type;

public class PLTSDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public PLTSDevice() {
		super();
	}

	public PLTSDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.PLTS;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		PLTS_Method_Type plts_Method_Type = PLTS_Method_Type
				.valueOf(methodType);

		return new PLTS_Measurement(plts_Method_Type, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
