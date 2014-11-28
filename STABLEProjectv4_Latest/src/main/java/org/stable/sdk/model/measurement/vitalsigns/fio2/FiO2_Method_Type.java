package org.stable.sdk.model.measurement.vitalsigns.fio2;

import org.stable.sdk.model.measurement.IMethodType;

public enum FiO2_Method_Type implements IMethodType {
	MANUAL;

	private FiO2_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "FiO2 SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return ordinal();
	}

}
