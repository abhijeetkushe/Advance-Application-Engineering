package org.stable.sdk.model.measurement.labwork.electrolytes.ionizedcalcium;

import org.stable.sdk.model.measurement.IMethodType;

public enum IonizedCalcium_Method_Type implements IMethodType {
	TEST;

	private IonizedCalcium_Method_Type() {
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
