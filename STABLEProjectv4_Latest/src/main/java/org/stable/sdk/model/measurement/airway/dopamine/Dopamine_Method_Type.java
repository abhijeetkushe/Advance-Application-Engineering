package org.stable.sdk.model.measurement.airway.dopamine;

import org.stable.sdk.model.measurement.IMethodType;

public enum Dopamine_Method_Type implements IMethodType {
	MANUAL;

	private Dopamine_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "Dopamine SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
