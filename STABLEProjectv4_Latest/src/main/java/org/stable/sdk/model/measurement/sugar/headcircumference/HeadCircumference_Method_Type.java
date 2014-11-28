package org.stable.sdk.model.measurement.sugar.headcircumference;

import org.stable.sdk.model.measurement.IMethodType;

public enum HeadCircumference_Method_Type implements IMethodType {
	MANUAL;

	private HeadCircumference_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "HEAD CIRCUMFRENCE SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
