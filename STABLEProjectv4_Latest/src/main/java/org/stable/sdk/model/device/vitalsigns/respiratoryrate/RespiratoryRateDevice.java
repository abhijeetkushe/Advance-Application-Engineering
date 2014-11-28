package org.stable.sdk.model.device.vitalsigns.respiratoryrate;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.vitalsigns.respiratoryrate.RespiratoryRate_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.respiratoryrate.RespiratoryRate_Method_Type;

public class RespiratoryRateDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public RespiratoryRateDevice() {
		super();
	}

	public RespiratoryRateDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.RESPIRATORY_RATE;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		RespiratoryRate_Method_Type respiratoryRateType = RespiratoryRate_Method_Type
				.valueOf(methodType);
		// int respiratoryRateValue = Integer.parseInt(measurementValue);

		return new RespiratoryRate_Measurement(respiratoryRateType,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
