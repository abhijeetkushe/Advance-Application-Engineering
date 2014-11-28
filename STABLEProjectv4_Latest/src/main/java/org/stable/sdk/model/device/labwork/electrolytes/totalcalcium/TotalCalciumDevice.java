package org.stable.sdk.model.device.labwork.electrolytes.totalcalcium;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.electrolytes.totalcalcium.TotalCalcium_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.totalcalcium.TotalCalcium_Method_Type;

public class TotalCalciumDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public TotalCalciumDevice() {
		super();
	}

	public TotalCalciumDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.Total_Calcium;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		TotalCalcium_Method_Type totalCalcium_Method_Type = TotalCalcium_Method_Type
				.valueOf(methodType);

		return new TotalCalcium_Measurement(totalCalcium_Method_Type,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
