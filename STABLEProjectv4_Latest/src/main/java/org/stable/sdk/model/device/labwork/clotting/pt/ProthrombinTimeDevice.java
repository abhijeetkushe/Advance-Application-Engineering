package org.stable.sdk.model.device.labwork.clotting.pt;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.clotting.pt.ProthrombinTime_Measurement;
import org.stable.sdk.model.measurement.labwork.clotting.pt.ProthrombinTime_Method_Type;

public class ProthrombinTimeDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public ProthrombinTimeDevice() {
		super();
	}

	public ProthrombinTimeDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.Prothrombin_Time;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		ProthrombinTime_Method_Type prothrombinTime_Method_Type = ProthrombinTime_Method_Type
				.valueOf(methodType);

		return new ProthrombinTime_Measurement(prothrombinTime_Method_Type,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
