package org.stable.sdk.model.measurement.vitalsigns.bloodpressure;

import org.stable.sdk.model.measurement.IMeasurementType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.units.Pressure_Unit;

public class BloodPressure_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BloodPressure_Measurement() {
		super();
	}

	public BloodPressure_Measurement(
			BloodPressure_Method_Type bloodPreasureType,
			BloodPressureValue value) {

		setMethodType(bloodPreasureType);
		// APGAR_Unit apgar = APGAR_Unit.SCORE;
		Pressure_Unit pUnit = new Pressure_Unit();
		setUnit(pUnit.getId());
		setValue(value.getMeasurementValue());
	}

	@Override
	public IMeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.BLOOD_PRESSURE;
	}

}
