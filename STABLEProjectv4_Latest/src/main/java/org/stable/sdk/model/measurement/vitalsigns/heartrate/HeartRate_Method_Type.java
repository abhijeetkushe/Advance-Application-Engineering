package org.stable.sdk.model.measurement.vitalsigns.heartrate;

import org.stable.sdk.model.measurement.IMethodType;

public enum HeartRate_Method_Type implements IMethodType {
	MANUAL;

	private HeartRate_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "HeartRate SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return ordinal();
	}

}
