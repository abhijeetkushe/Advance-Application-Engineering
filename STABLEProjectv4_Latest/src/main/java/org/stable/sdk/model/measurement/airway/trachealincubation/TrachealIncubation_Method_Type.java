package org.stable.sdk.model.measurement.airway.trachealincubation;

import org.stable.sdk.model.measurement.IMethodType;

public enum TrachealIncubation_Method_Type implements IMethodType {
	MANUAL;

	private TrachealIncubation_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "TrachealIncubation SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
