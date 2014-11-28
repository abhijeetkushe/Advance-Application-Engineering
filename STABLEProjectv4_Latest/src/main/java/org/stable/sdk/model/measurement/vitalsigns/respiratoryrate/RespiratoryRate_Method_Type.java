package org.stable.sdk.model.measurement.vitalsigns.respiratoryrate;

import org.stable.sdk.model.measurement.IMethodType;

public enum RespiratoryRate_Method_Type implements IMethodType {
	Observation("Rise and Fall of the Chest");

	private String desc;

	private RespiratoryRate_Method_Type(String desc) {
		// TODO Auto-generated constructor stub
		this.desc = desc;
	}

	public String methodDescription() {
		return "RespiratoryRate  " + this.desc;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return ordinal();
	}

}
