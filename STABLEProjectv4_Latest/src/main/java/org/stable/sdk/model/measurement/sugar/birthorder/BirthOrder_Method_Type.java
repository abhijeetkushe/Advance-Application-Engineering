package org.stable.sdk.model.measurement.sugar.birthorder;

import org.stable.sdk.model.measurement.IMethodType;

public enum BirthOrder_Method_Type implements IMethodType {
	MANUAL;

	private BirthOrder_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "BirthOrder SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
