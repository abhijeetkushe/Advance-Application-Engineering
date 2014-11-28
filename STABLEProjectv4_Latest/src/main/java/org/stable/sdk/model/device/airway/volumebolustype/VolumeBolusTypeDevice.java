package org.stable.sdk.model.device.airway.volumebolustype;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.airway.volumebolustype.VolumeBolusType_Measurement;
import org.stable.sdk.model.measurement.airway.volumebolustype.VolumeBolusType_Method_Type;

public class VolumeBolusTypeDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public VolumeBolusTypeDevice() {
		super();
	}

	public VolumeBolusTypeDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	
	 public DeviceType defineDeviceType(){
		 return DeviceType.VOLUME_BOLUS_TYPE;
	 }
	public Measurement getMeasurement(String methodType, String measurementValue) {
		// TODO Auto-generated method stub

		VolumeBolusType_Method_Type volumeBolusTypeType = VolumeBolusType_Method_Type
				.valueOf(methodType);
		int volumeBolusTypeValue = Integer.parseInt(measurementValue);
		return new VolumeBolusType_Measurement(volumeBolusTypeType,
				volumeBolusTypeValue);
	}

}
