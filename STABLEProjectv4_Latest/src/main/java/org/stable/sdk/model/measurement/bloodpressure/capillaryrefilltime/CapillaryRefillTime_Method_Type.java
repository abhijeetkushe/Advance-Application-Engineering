package org.stable.sdk.model.measurement.bloodpressure.capillaryrefilltime;

import org.stable.sdk.model.measurement.IMethodType;

public enum CapillaryRefillTime_Method_Type implements IMethodType {
	MANUAL;

	private CapillaryRefillTime_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "CapillaryRefillTime SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
