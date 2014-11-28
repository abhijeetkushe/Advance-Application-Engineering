package org.stable.sdk.model.device.vitalsigns.weight;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.vitalsigns.weight.Weight_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.weight.Weight_Method_Type;

public class WeightDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public WeightDevice() {
		super();
	}

	public WeightDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.WEIGHT;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		Weight_Method_Type weightType = Weight_Method_Type.valueOf(methodType);
		// float weightValue = Float.parseFloat(measurementValue);

		return new Weight_Measurement(weightType, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
