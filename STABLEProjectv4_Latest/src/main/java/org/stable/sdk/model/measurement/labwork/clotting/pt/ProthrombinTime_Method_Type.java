package org.stable.sdk.model.measurement.labwork.clotting.pt;

import org.stable.sdk.model.measurement.IMethodType;

public enum ProthrombinTime_Method_Type implements IMethodType {
	TEST;

	private ProthrombinTime_Method_Type() {
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
