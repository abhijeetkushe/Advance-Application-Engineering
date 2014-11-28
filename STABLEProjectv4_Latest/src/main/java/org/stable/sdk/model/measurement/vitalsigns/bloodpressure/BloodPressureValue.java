package org.stable.sdk.model.measurement.vitalsigns.bloodpressure;

import org.stable.sdk.model.measurement.MeasurementValue;

public class BloodPressureValue implements MeasurementValue {

	private int systolicValue;
	private int dystolicValue;

	public BloodPressureValue(int systolicValue, int dystolicValue) {
		// TODO Auto-generated constructor stub
		this.systolicValue = systolicValue;
		this.dystolicValue = dystolicValue;
	}

	public void setDystolicValue(int dystolicValue) {
		this.dystolicValue = dystolicValue;
	}

	public void setSystolicValue(int systolicValue) {
		this.systolicValue = systolicValue;
	}

	public int getDystolicValue() {
		return dystolicValue;
	}

	public int getSystolicValue() {
		return systolicValue;
	}

	public String getMeasurementValue() {
		// TODO Auto-generated method stub
		return systolicValue + "/" + dystolicValue;
	}
}
