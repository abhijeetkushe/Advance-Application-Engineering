package org.stable.sdk.model.measurement.vitalsigns.temperature;

import java.util.Date;

import org.stable.sdk.model.measurement.IMeasurementType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.Temperature_Metric;

public class Temperature_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public Temperature_Measurement() {
		super();
	}

	public Temperature_Measurement(Temperature_MethodType type,
			MeasurementValue value) {

		Temperature_Metric unit = new Temperature_Metric();
		setUnit(unit.getId());
		setMethodType(type);
		setValue(value.getMeasurementValue());

	}

	public Temperature_Measurement(Temperature_MethodType type,
			Temperature_Metric unit, MeasurementValue value) {
		setMethodType(type);
		setUnit(unit.getId());
		setValue(value.getMeasurementValue());
	}

	public Temperature_Measurement(Temperature_MethodType type,
			Temperature_Metric unit, MeasurementValue value, Date dateTime) {
		setDateTime(dateTime);
		setMethodType(type);
		setUnit(unit.getId());
		setValue(value.getMeasurementValue());
	}

	@Override
	public IMeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.TEMPERATURE;
	}

}
