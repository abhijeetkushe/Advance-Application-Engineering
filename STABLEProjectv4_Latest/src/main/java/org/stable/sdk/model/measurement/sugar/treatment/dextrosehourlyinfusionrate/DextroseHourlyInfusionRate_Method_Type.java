package org.stable.sdk.model.measurement.sugar.treatment.dextrosehourlyinfusionrate;

import org.stable.sdk.model.measurement.IMethodType;

public enum DextroseHourlyInfusionRate_Method_Type implements IMethodType {
	MANUAL;

	private DextroseHourlyInfusionRate_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "APGAR SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
