package org.stable.sdk.model.device.airway.baseexcess;

import java.util.List;


import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.airway.baseexcess.BaseExcess_Measurement;
import org.stable.sdk.model.measurement.airway.baseexcess.BaseExcess_Method_Type;
import org.stable.sdk.model.patient.PatientBedLocation;

public class BaseExcessDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BaseExcessDevice() {
		super();
	}

	public BaseExcessDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.BASE_EXCESS;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		BaseExcess_Method_Type baseExcessType = BaseExcess_Method_Type
				.valueOf(methodType);
		// int baseExcessValue = Integer.parseInt(measurementValue);

		return new BaseExcess_Measurement(baseExcessType,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

	

}
