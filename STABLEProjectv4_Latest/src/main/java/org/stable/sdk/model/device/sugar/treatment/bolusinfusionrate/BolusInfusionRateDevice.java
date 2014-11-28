package org.stable.sdk.model.device.sugar.treatment.bolusinfusionrate;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.sugar.treatment.bolusinfusionrate.BolusInfusionRate_Measurement;
import org.stable.sdk.model.measurement.sugar.treatment.bolusinfusionrate.BolusInfusionRate_Method_Type;

public class BolusInfusionRateDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BolusInfusionRateDevice() {
		super();
	}

	public BolusInfusionRateDevice(String deviceName,
			String modelNumber, String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.BOLUS_INFUSION_RATE;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		BolusInfusionRate_Method_Type bolusInfusionRate_Method_Type = BolusInfusionRate_Method_Type
				.valueOf(methodType);

		return new BolusInfusionRate_Measurement(
				bolusInfusionRate_Method_Type, new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
