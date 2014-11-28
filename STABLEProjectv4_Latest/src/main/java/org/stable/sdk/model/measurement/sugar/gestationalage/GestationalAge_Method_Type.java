package org.stable.sdk.model.measurement.sugar.gestationalage;

import org.stable.sdk.model.measurement.IMethodType;

public enum GestationalAge_Method_Type implements IMethodType {
	MANUAL;

	private GestationalAge_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "GestationalAge SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
