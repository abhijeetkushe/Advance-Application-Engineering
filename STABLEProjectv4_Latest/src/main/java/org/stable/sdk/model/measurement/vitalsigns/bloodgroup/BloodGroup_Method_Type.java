package org.stable.sdk.model.measurement.vitalsigns.bloodgroup;

import org.stable.sdk.model.measurement.IMethodType;

public enum BloodGroup_Method_Type implements IMethodType {
	TEST;

	private BloodGroup_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "APGAR SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
