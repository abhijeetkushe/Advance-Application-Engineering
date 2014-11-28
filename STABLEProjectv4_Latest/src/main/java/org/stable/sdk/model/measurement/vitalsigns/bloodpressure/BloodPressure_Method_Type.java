package org.stable.sdk.model.measurement.vitalsigns.bloodpressure;

import org.stable.sdk.model.measurement.IMethodType;

public enum BloodPressure_Method_Type implements IMethodType {
	ANALOG, DIGITAL;

	private BloodPressure_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "BloodPreasure AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return ordinal();
	}

}
