package org.stable.sdk.model.device.labwork.clotting.ptt;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.clotting.ptt.PartialThromboplastinTime_Measurement;
import org.stable.sdk.model.measurement.labwork.clotting.ptt.PartialThromboplastinTime_Method_Type;

public class PartialThromboplastinTimeDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public PartialThromboplastinTimeDevice() {
		super();
	}

	
	
	public PartialThromboplastinTimeDevice(String deviceName,
			String modelNumber, String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	 public DeviceType defineDeviceType(){
		 return DeviceType.Partial_Thromboplastin_Time;
	 }
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		PartialThromboplastinTime_Method_Type partialThromboplastinTime_Method_Type = PartialThromboplastinTime_Method_Type
				.valueOf(methodType);

		return new PartialThromboplastinTime_Measurement(
				partialThromboplastinTime_Method_Type, new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
