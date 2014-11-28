package org.stable.sdk.model.measurement.bloodpressure.pulsepressure;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.Pressure_Unit;

public class PulsePressure_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public PulsePressure_Measurement() {
		super();
	}

	public PulsePressure_Measurement(
			PulsePressure_Method_Type pulsePressureType,
			MeasurementValue measurementValue) {

		setMethodType(pulsePressureType);
		// APGAR_Unit apgar = APGAR_Unit.SCORE;
		Pressure_Unit pressure_Unit = new Pressure_Unit();
		setUnit(pressure_Unit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.PULSE_PRESSURE;
	}

}
