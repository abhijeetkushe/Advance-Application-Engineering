package org.stable.sdk.model.measurement.labwork.cbc.hgb;

import org.stable.sdk.model.measurement.IMethodType;

public enum Hgb_Method_Type implements IMethodType {
	TEST;

	private Hgb_Method_Type() {
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
