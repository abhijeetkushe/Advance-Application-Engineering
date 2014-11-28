package org.stable.sdk.model.device.sugar.treatment.dextrosehourlyinfusionrate;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.sugar.treatment.dextrosehourlyinfusionrate.DextroseHourlyInfusionRate_Measurement;
import org.stable.sdk.model.measurement.sugar.treatment.dextrosehourlyinfusionrate.DextroseHourlyInfusionRate_Method_Type;

public class DextroseHourlyInfusionRateDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public DextroseHourlyInfusionRateDevice() {
		super();
	}

	public DextroseHourlyInfusionRateDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.DEXTROSE_HOURLY_INFUSION_RATE;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		DextroseHourlyInfusionRate_Method_Type infusionRateType = DextroseHourlyInfusionRate_Method_Type
				.valueOf(methodType);

		return new DextroseHourlyInfusionRate_Measurement(infusionRateType,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
