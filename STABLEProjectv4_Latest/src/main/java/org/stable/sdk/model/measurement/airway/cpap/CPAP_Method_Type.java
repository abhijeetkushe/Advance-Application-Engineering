package org.stable.sdk.model.measurement.airway.cpap;

import org.stable.sdk.model.measurement.IMethodType;

public enum CPAP_Method_Type implements IMethodType {
	MANUAL;

	private CPAP_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "CPAP SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
