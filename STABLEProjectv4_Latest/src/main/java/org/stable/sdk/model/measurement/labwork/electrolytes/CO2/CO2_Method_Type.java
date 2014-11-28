package org.stable.sdk.model.measurement.labwork.electrolytes.CO2;

import org.stable.sdk.model.measurement.IMethodType;

public enum CO2_Method_Type implements IMethodType {
	TEST;

	private CO2_Method_Type() {
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
