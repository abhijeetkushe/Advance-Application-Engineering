package org.stable.sdk.model.measurement.vitalsigns.weight;

import org.stable.sdk.model.measurement.IMethodType;

public enum Weight_Method_Type implements IMethodType {
	Digital("Using a Digital Machine"), Analog("Usinga a Analog Machine");

	private String desc = "";

	private Weight_Method_Type(String desc) {

		this.desc = desc;
	}

	public String methodDescription() {
		return this.desc;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return ordinal();
	}

}
