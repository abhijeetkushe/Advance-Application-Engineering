package org.stable.sdk.model.measurement.vitalsigns.bloodgroup;

import org.stable.sdk.model.measurement.MeasurementValue;

public enum BloodGroup_Value implements MeasurementValue {
	O_Positive("O+"),
	A_Positive("A+"),
	B_Positive("B+"),
	AB_Positive("AB+"),
	O_Negative("O-"),
	A_Negative("A-"),
	B_Negative("B-"),
	AB_Negative("AB-");
	
	private String value;

	private BloodGroup_Value(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

	public String getMeasurementValue() {
		return value;
	}
}
