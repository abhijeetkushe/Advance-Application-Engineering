package org.stable.sdk.model.measurement.airway.baseexcess;

import org.stable.sdk.model.measurement.IMethodType;

public enum BaseExcess_Method_Type implements IMethodType {
	Measurement,Arterial,Capillary;

	private BaseExcess_Method_Type() {
	}

	public String methodDescription() {
		return "the amount of acid or base required to titrate"
				+ " a sample of whole arterial blood to the normal"
				+ " pH of 7.4" + this.name();
	}

	public int getId() {
		return 0;
	}

}
