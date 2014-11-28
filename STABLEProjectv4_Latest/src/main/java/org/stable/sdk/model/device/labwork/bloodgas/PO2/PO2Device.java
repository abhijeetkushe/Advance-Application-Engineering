package org.stable.sdk.model.device.labwork.bloodgas.PO2;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.bloodgas.PO2.PO2_Measurement;
import org.stable.sdk.model.measurement.labwork.bloodgas.PO2.PO2_Method_Type;

public class PO2Device extends AbstractDevice{
	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public PO2Device() {
		super();
	}

	public PO2Device(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	 public DeviceType defineDeviceType(){
		 return DeviceType.PO2;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		PO2_Method_Type PO2Type = PO2_Method_Type.valueOf(methodType);
		// int PCO2Value = Integer.parseInt(measurementValue);

		return new PO2_Measurement(PO2Type, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
