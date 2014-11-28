package org.stable.sdk.model.device.sugar.treatment.ivtype;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.sugar.treatment.ivtype.IVType_Measurement;
import org.stable.sdk.model.measurement.sugar.treatment.ivtype.IVType_Method_Type;

public class IVTypeDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public IVTypeDevice() {
		super();
	}

	public IVTypeDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.IV_AT;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		IVType_Method_Type IVTypeType = IVType_Method_Type.valueOf(methodType);

		return new IVType_Measurement(IVTypeType, new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

}
