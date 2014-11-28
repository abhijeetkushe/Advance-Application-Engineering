package org.stable.sdk.model.device.labwork.cbc.metamyelocytes;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.cbc.metamyelocytes.Metamyelocytes_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.metamyelocytes.Metamyelocytes_Method_Type;

public class MetamyelocytesDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public MetamyelocytesDevice() {
		super();
	}

	public MetamyelocytesDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.METAMYELOCYTES;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		Metamyelocytes_Method_Type metamyelocytes_Method_Type = Metamyelocytes_Method_Type
				.valueOf(methodType);

		return new Metamyelocytes_Measurement(metamyelocytes_Method_Type,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
