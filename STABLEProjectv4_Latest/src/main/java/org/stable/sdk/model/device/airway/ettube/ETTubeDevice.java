package org.stable.sdk.model.device.airway.ettube;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.airway.ettube.ETTube_Measurement;
import org.stable.sdk.model.measurement.airway.ettube.ETTube_MeasurmentValue;
import org.stable.sdk.model.measurement.airway.ettube.ETTube_Method_Type;

public class ETTubeDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public ETTubeDevice() {
		super();
	}

	public ETTubeDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.ET_TUBE;
	 }

	public Measurement getMeasurement(String methodType, String measurementValue) {
		// TODO Auto-generated method stub

		ETTube_Method_Type ETTubeType = ETTube_Method_Type.valueOf(methodType);
		ETTube_MeasurmentValue etTube_MeasurmentValue = ETTube_MeasurmentValue
				.valueOf(measurementValue);

		return new ETTube_Measurement(ETTubeType, etTube_MeasurmentValue);
	}

}
