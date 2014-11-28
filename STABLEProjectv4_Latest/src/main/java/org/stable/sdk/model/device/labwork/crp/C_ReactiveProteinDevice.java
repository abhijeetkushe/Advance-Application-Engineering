package org.stable.sdk.model.device.labwork.crp;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.labwork.crp.C_ReactiveProtein_Measurement;
import org.stable.sdk.model.measurement.labwork.crp.C_ReactiveProtein_Method_Type;

public class C_ReactiveProteinDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public C_ReactiveProteinDevice() {
		super();
	}

	public C_ReactiveProteinDevice(String deviceName, String modelNumber,
			String inventoryNumber) {
		super(deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.C_Reactive_Protein;
	 }
	
	public Measurement getMeasurement(String methodType,
			final String measurementValue) {
		// TODO Auto-generated method stub

		C_ReactiveProtein_Method_Type c_ReactiveProtein_Method_Type = C_ReactiveProtein_Method_Type
				.valueOf(methodType);

		return new C_ReactiveProtein_Measurement(c_ReactiveProtein_Method_Type,
				new MeasurementValue() {

					public String getMeasurementValue() {
						// TODO Auto-generated method stub
						return measurementValue;
					}
				});
	}

}
