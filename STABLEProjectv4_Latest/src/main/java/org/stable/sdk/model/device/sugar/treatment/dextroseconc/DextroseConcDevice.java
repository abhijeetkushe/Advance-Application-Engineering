package org.stable.sdk.model.device.sugar.treatment.dextroseconc;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.sugar.treatment.dextroseconc.DextroseConc_Measurement;
import org.stable.sdk.model.measurement.sugar.treatment.dextroseconc.DextroseConc_Method_Type;

public class DextroseConcDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public DextroseConcDevice() {
		super();
	}

	public DextroseConcDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}
	 public DeviceType defineDeviceType(){
		 return DeviceType.DEXTROSE_CONC;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		DextroseConc_Method_Type dextroseConcType = DextroseConc_Method_Type
				.valueOf(methodType);

		return new DextroseConc_Measurement(dextroseConcType,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
