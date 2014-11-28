package org.stable.sdk.model.measurement.airway.o2inuse;

import org.stable.sdk.model.measurement.IMethodType;

public enum O2InUse_Method_Type implements IMethodType {
	MANUAL;

	private O2InUse_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "O2InUse SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
