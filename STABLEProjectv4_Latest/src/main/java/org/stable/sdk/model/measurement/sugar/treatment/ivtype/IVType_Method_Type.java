package org.stable.sdk.model.measurement.sugar.treatment.ivtype;

import org.stable.sdk.model.measurement.IMethodType;

public enum IVType_Method_Type implements IMethodType {
	MANUAL;

	private IVType_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "IVType AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
