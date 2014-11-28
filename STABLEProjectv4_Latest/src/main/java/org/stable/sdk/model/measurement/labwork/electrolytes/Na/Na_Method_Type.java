package org.stable.sdk.model.measurement.labwork.electrolytes.Na;

import org.stable.sdk.model.measurement.IMethodType;

public enum Na_Method_Type implements IMethodType {
	TEST;

	private Na_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
