package org.stable.sdk.model.measurement.sugar.gestationalage;

import org.stable.sdk.model.measurement.MeasurementValue;

public class GestationalAgeValue implements MeasurementValue {

	private int weeks;
	private int day;

	public GestationalAgeValue(int weeks, int day) {
		this.weeks = weeks;
		this.day = day;
	}

	public String getMeasurementValue() {
		// TODO Auto-generated method stub
		return weeks + "-" + day + "/7";
	}

}
