package org.stable.sdk.model.device.labwork.electrolytes.Cl;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.electrolytes.Cl.Cl_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.Cl.Cl_Method_Type;

public class ClDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public ClDevice() {
		super();
	}

	public ClDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.Cl;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		Cl_Method_Type cl_Method_Type = Cl_Method_Type.valueOf(methodType);

		return new Cl_Measurement(cl_Method_Type, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
