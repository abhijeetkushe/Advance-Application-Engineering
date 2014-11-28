package org.stable.sdk.model.measurement.airway.volumebolusamount;

import org.stable.sdk.model.measurement.IMethodType;

public enum VolumeBolousAmount_Method_Type implements IMethodType {
	MANUAL;

	private VolumeBolousAmount_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "VolumeBolusAmount SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
