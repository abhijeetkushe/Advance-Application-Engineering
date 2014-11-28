package org.stable.sdk.model.device.labwork.cbc.neutrophils;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.cbc.neutrophils.Neutrophils_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.neutrophils.Neutrophils_Method_Type;

public class NeutrophilsDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public NeutrophilsDevice() {
		super();
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.NEUTROPHILS;
	 }

	public NeutrophilsDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		Neutrophils_Method_Type neutrophils_Method_Type = Neutrophils_Method_Type
				.valueOf(methodType);

		return new Neutrophils_Measurement(neutrophils_Method_Type,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
