package org.stable.sdk.model.measurement.sugar.treatment.bolusinfusionrate;

import org.stable.sdk.model.measurement.IMethodType;

public enum BolusInfusionRate_Method_Type implements IMethodType {
	MANNUAl;

	private BolusInfusionRate_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "DesiredInfusionRate AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
