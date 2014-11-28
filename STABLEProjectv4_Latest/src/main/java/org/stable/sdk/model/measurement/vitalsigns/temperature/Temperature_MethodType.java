package org.stable.sdk.model.measurement.vitalsigns.temperature;

import org.stable.sdk.model.measurement.IMethodType;

public enum Temperature_MethodType implements IMethodType {

	Axillary("Child's Arm Pits"), Rectal("Child's rectum");

	private String methodDesc;

	private Temperature_MethodType(String methodDesc) {
		// TODO Auto-generated constructor stub
		this.methodDesc = methodDesc;
	}

	public String methodDescription() {
		// TODO Auto-generated method stub
		return methodDesc;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return ordinal();
	}

}
