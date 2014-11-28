package org.stable.sdk.model.device.sugar.treatment.bolusconc;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.sugar.treatment.bolusconc.BolusConc_Measurement;
import org.stable.sdk.model.measurement.sugar.treatment.bolusconc.BolusConc_Method_Type;

public class BolusConcDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BolusConcDevice() {
		super();
	}

	public BolusConcDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.BOLUS_CONC;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		BolusConc_Method_Type bolusConcMethodType = BolusConc_Method_Type.valueOf(methodType);

		return new BolusConc_Measurement(bolusConcMethodType,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
