package org.stable.sdk.model.measurement.sugar.treatment.vacat;

import org.stable.sdk.model.measurement.IMethodType;

public enum UAC_Method_Type implements IMethodType {
	MANUAL;

	private UAC_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "UAC SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
