package org.stable.sdk.model.measurement.sugar.treatment.bolusdose;

import org.stable.sdk.model.measurement.IMethodType;

public enum BolusDose_Method_Type implements IMethodType {
	MANUAL;

	
	
	private BolusDose_Method_Type() {
		// TODO Auto-generated constructor stub
	}
	
	public String methodDescription() {
		return "DesiredBolus SCORE AT "+this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

}
