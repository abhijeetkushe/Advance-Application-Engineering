package org.stable.sdk.model.device.airway.volumebolusamount;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.airway.volumebolusamount.VolumeBolousAmount_Measurement;
import org.stable.sdk.model.measurement.airway.volumebolusamount.VolumeBolousAmount_Method_Type;

public class VolumeBolusAmountDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public VolumeBolusAmountDevice() {
		super();
	}

	public VolumeBolusAmountDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.VOLUME_BOLUS_AMOUNT;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		VolumeBolousAmount_Method_Type volumeBolusAmountType = VolumeBolousAmount_Method_Type
				.valueOf(methodType);

		return new VolumeBolousAmount_Measurement(volumeBolusAmountType,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
