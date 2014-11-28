package org.stable.sdk.model.measurement.sugar.treatment.uvcat;

import org.stable.sdk.model.measurement.IMethodType;

public enum UVC_Method_Type implements IMethodType {
	MANUAL;

	private UVC_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "UVC SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
