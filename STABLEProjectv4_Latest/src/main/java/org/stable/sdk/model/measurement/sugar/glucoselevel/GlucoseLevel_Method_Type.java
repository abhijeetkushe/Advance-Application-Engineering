package org.stable.sdk.model.measurement.sugar.glucoselevel;

import org.stable.sdk.model.measurement.IMethodType;

public enum GlucoseLevel_Method_Type implements IMethodType {
	Serum, BedSide;

	private GlucoseLevel_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "GlucoseLevel Screening AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
