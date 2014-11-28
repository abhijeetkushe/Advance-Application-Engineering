package org.stable.sdk.model.measurement.vitalsigns.hco3;

import org.stable.sdk.model.measurement.IMethodType;

public enum HCO3_Method_Type implements IMethodType {
	CALCULATED, MANUAL,Arterial,Capillary;

	private HCO3_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "HCO3 SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return ordinal();
	}

}
