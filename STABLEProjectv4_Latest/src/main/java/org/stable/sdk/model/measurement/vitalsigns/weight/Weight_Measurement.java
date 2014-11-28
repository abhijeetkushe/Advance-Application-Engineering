package org.stable.sdk.model.measurement.vitalsigns.weight;

import java.util.Date;

import org.stable.sdk.model.measurement.IMeasurementType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.kg_Unit;

public class Weight_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public Weight_Measurement() {
		super();
	}

	public Weight_Measurement(Weight_Method_Type weightType,
			MeasurementValue value) {

		setMethodType(weightType);
		kg_Unit weightUnit = new kg_Unit();
		setUnit(weightUnit.getId());
		setValue(value.getMeasurementValue());

	}

	public Weight_Measurement(Weight_Method_Type type, kg_Unit unit,
			MeasurementValue value) {
		setMethodType(type);
		kg_Unit weightUnit = new kg_Unit();
		setUnit(weightUnit.getId());
		setValue(value.getMeasurementValue());
	}

	public Weight_Measurement(Weight_Method_Type type, kg_Unit unit,
			MeasurementValue value, Date dateTime) {
		setDateTime(dateTime);
		setMethodType(type);
		kg_Unit weightUnit = new kg_Unit();
		setUnit(weightUnit.getId());
		setValue(value.getMeasurementValue());
	}

	@Override
	public IMeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.WEIGHT;
	}

}
