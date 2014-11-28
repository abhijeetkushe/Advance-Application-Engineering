package org.stable.sdk.model.device.sugar.treatment.dextroseinfusionrate;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.sugar.treatment.dextroseinfusionrate.DesiredInfusionRate_Method_Type;
import org.stable.sdk.model.measurement.sugar.treatment.dextroseinfusionrate.DextroseInfusionRate_Measurement;

public class DextroseInfusionRateDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public DextroseInfusionRateDevice() {
		super();
	}

	public DextroseInfusionRateDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	
	 public DeviceType defineDeviceType(){
		 return DeviceType.DEXTROSE_INFUSION_RATE;
	 }

	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		DesiredInfusionRate_Method_Type desiredInfusionRateType = DesiredInfusionRate_Method_Type
				.valueOf(methodType);

		return new DextroseInfusionRate_Measurement(desiredInfusionRateType,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
