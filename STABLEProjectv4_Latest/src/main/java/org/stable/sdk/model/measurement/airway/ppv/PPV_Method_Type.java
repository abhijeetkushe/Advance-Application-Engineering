package org.stable.sdk.model.measurement.airway.ppv;

import org.stable.sdk.model.measurement.IMethodType;

public enum PPV_Method_Type implements IMethodType {
	MANUAL;

	private PPV_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "PPV SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
