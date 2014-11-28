package org.stable.sdk.model.measurement.sugar.treatment.dextroseconc;

import org.stable.sdk.model.measurement.IMethodType;

public enum DextroseConc_Method_Type implements IMethodType {
	MANUAL;

	private DextroseConc_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "DextroseConc AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
