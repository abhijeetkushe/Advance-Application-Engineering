package org.stable.sdk.model.measurement.airway.cpap;

import org.stable.sdk.model.measurement.MeasurementValue;

public enum CPAP_MeasurmentValue implements MeasurementValue {
	PRESENT("PRESENT"), ABSENT("ABSENT");

	private String value;

	private CPAP_MeasurmentValue(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public String getMeasurementValue() {
		// TODO Auto-generated method stub
		return getValue();
	}

}
