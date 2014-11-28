package org.stable.sdk.model.measurement.airway.ettube;

import org.stable.sdk.model.measurement.MeasurementValue;

public enum ETTube_MeasurmentValue implements MeasurementValue {
	YES("YES"), NO("NO");

	private String value;

	private ETTube_MeasurmentValue(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public String getMeasurementValue() {
		// TODO Auto-generated method stub
		return this.getValue();
	}

}
