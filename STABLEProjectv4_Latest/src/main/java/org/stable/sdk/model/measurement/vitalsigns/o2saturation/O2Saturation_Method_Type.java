package org.stable.sdk.model.measurement.vitalsigns.o2saturation;

import org.stable.sdk.model.measurement.IMethodType;

public enum O2Saturation_Method_Type implements IMethodType {
	One_Minute;

	private O2Saturation_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "O2Saturation SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return ordinal();
	}

}
