package org.stable.sdk.model.measurement.vitalsigns.heartrate;

import org.stable.sdk.model.measurement.IMeasurementType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.Per_Min_Unit;

public class HeartRate_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public HeartRate_Measurement() {
		super();
	}

	public HeartRate_Measurement(HeartRate_Method_Type heartRateType,
			MeasurementValue value) {

		setMethodType(heartRateType);
		// APGAR_Unit apgar = APGAR_Unit.SCORE;
		Per_Min_Unit per_Min_Unit = new Per_Min_Unit();
		setUnit(per_Min_Unit.getId());
		setValue(value.getMeasurementValue());

	}

	@Override
	public IMeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.HEART_RATE;
	}

}
