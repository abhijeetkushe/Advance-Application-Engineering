package org.stable.sdk.model.measurement.airway.ettube;

import org.stable.sdk.model.measurement.IMethodType;

public enum ETTube_Method_Type implements IMethodType {
	MANUAL;

	private ETTube_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "ETTube SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
