package org.stable.sdk.model.device.airway.cpap;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.airway.cpap.CPAP_Measurement;
import org.stable.sdk.model.measurement.airway.cpap.CPAP_MeasurmentValue;
import org.stable.sdk.model.measurement.airway.cpap.CPAP_Method_Type;

public class CPAPDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public CPAPDevice() {
		super();
	}

	public CPAPDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	
	 public DeviceType defineDeviceType(){
		 return DeviceType.CPAP;
	 }
	public Measurement getMeasurement(String methodType, String measurementValue) {
		// TODO Auto-generated method stub

		CPAP_Method_Type CPAPType = CPAP_Method_Type.valueOf(methodType);
		CPAP_MeasurmentValue cpap_MeasurmentValue = CPAP_MeasurmentValue
				.valueOf(measurementValue);

		// int CPAPValue = Integer.parseInt(measurementValue);

		return new CPAP_Measurement(CPAPType, cpap_MeasurmentValue);
	}

}
