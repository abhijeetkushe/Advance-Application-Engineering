package org.stable.sdk.model.measurement.sugar.treatment.ivat;

import org.stable.sdk.model.measurement.IMethodType;

public enum IV_AT_Method_Type implements IMethodType {
	MANUAL;

	private IV_AT_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "IV AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
