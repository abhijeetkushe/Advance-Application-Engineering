package org.stable.sdk.model.device.sugar.treatment.bolusdose;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.sugar.treatment.bolusdose.BolusDose_Measurement;
import org.stable.sdk.model.measurement.sugar.treatment.bolusdose.BolusDose_Method_Type;

public class BolusDoseDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BolusDoseDevice() {
		super();
	}

	public BolusDoseDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	 public DeviceType defineDeviceType(){
		 return DeviceType.BOLUS_DOSE;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		BolusDose_Method_Type desiredBolusType = BolusDose_Method_Type.valueOf(methodType);

		return new BolusDose_Measurement(desiredBolusType,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
