package org.stable.sdk.model.measurement.sugar.height;

import org.stable.sdk.model.measurement.IMethodType;

public enum Height_Method_Type implements IMethodType {
	MANUAL;

	private Height_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "Height SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
