package org.stable.sdk.model.device.labwork.clotting.fibrinogen;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.clotting.fibrinogen.Fibrinogen_Measurement;
import org.stable.sdk.model.measurement.labwork.clotting.fibrinogen.Fibrinogen_Method_Type;

public class FibrinogenDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public FibrinogenDevice() {
		super();
	}

	public FibrinogenDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.Fibrinogen;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		Fibrinogen_Method_Type fibrinogen_Method_Type = Fibrinogen_Method_Type
				.valueOf(methodType);

		return new Fibrinogen_Measurement(fibrinogen_Method_Type,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
