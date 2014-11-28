package org.stable.sdk.model.device.vitalsigns.pHlevel;

import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.measurement.vitalsigns.pHlevel.pHLevel_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.pHlevel.pHLevel_Method_Type;

public class pHLevelDevice extends AbstractDevice {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public pHLevelDevice() {
		super();
	}

	public pHLevelDevice(String deviceName, String modelNumber,String inventoryNumber) {
		super( deviceName, modelNumber, inventoryNumber);
	}

	 public DeviceType defineDeviceType(){
		 return DeviceType.PH_LEVEL;
	 }
	
	public Measurement getMeasurement(String methodType,final String measurementValue) {
		// TODO Auto-generated method stub
		
		
		pHLevel_Method_Type pHLevelType = pHLevel_Method_Type.valueOf(methodType);
		//int pHLevelValue = Integer.parseInt(measurementValue);
		
		return new pHLevel_Measurement(pHLevelType, new MeasurementValue() {
			
			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return measurementValue;
			}
		});
	}

	



	
}
