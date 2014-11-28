package org.stable.sdk.model.measurement.vitalsigns.pco2;

import org.stable.sdk.model.measurement.IMethodType;

public enum PCO2_Method_Type implements IMethodType {
	Arterial, Capillary;

	private PCO2_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return this.name();
	}

	public int getId() {
		
		// TODO Auto-generated method stub
		return ordinal();
	}

}
