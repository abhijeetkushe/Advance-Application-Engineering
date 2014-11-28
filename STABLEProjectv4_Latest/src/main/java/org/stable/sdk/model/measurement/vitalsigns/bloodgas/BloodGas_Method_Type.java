package org.stable.sdk.model.measurement.vitalsigns.bloodgas;

import org.stable.sdk.model.measurement.IMethodType;

public enum BloodGas_Method_Type implements IMethodType {
	MANUAL;

	private BloodGas_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "Blood Gas " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
