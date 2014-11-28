package org.stable.sdk.model.measurement.sugar.gestationalage;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.units.GestationalAge_Unit;

public class GestationalAge_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public GestationalAge_Measurement() {
		super();
	}

	public GestationalAge_Measurement(
			GestationalAge_Method_Type gestationalAgeType,
			GestationalAgeValue value) {

		setMethodType(gestationalAgeType);
		GestationalAge_Unit gestationalAge_Unit = new GestationalAge_Unit();
		setUnit(gestationalAge_Unit.getId());
		setValue(value.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.GESTATIONAL_AGE;
	}

}
