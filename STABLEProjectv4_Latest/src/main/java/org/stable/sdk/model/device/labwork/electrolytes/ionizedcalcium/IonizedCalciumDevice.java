package org.stable.sdk.model.device.labwork.electrolytes.ionizedcalcium;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.electrolytes.ionizedcalcium.IonizedCalcium_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.ionizedcalcium.IonizedCalcium_Method_Type;

public class IonizedCalciumDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public IonizedCalciumDevice() {
		super();
	}

	public IonizedCalciumDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.Ionized_Calcium;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		IonizedCalcium_Method_Type ionizedCalcium_Method_Type = IonizedCalcium_Method_Type
				.valueOf(methodType);

		return new IonizedCalcium_Measurement(ionizedCalcium_Method_Type,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
