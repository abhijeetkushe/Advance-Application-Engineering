package org.stable.sdk.model.measurement.vitalsigns.pHlevel;

import org.stable.sdk.model.measurement.IMethodType;

public enum pHLevel_Method_Type implements IMethodType {
	One_Minute,Arterial,Capillary;

	private pHLevel_Method_Type() {
		// TODO Auto-generated constructor stub
	}

	public String methodDescription() {
		return "pHLevel SCORE AT " + this.name();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
