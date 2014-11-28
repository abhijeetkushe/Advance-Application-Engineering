package org.stable.sdk.model.measurement.labwork.bloodgas.PO2;

import org.stable.sdk.model.measurement.IMethodType;

public enum PO2_Method_Type implements IMethodType {
	Arterial,Capillary;

	private PO2_Method_Type() {
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
