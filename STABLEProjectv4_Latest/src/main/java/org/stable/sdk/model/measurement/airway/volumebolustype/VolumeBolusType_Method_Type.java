package org.stable.sdk.model.measurement.airway.volumebolustype;

import org.stable.sdk.model.measurement.IMethodType;

public enum VolumeBolusType_Method_Type implements IMethodType {
	MANUAL;

	private VolumeBolusType_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "VolumeBolusType SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
