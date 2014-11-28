package org.stable.sdk.model.measurement.labwork.bloodgas.MetHb;

import org.stable.sdk.model.measurement.IMethodType;

public enum MetHb_Method_Type implements IMethodType {
	TEST,Arterial,Capillary;

	private MetHb_Method_Type() {
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
