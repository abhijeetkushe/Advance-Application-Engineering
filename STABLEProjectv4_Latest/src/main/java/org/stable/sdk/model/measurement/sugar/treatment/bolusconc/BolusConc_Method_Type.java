package org.stable.sdk.model.measurement.sugar.treatment.bolusconc;

import org.stable.sdk.model.measurement.IMethodType;

public enum BolusConc_Method_Type implements IMethodType {
	MANUAl;

	private BolusConc_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "DesiredBolusConc AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
