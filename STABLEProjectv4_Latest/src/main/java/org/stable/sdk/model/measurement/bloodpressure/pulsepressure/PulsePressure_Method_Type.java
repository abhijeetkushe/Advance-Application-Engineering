package org.stable.sdk.model.measurement.bloodpressure.pulsepressure;

import org.stable.sdk.model.measurement.IMethodType;

public enum PulsePressure_Method_Type implements IMethodType {
	MANUAL;

	private PulsePressure_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "PulsePressure SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
