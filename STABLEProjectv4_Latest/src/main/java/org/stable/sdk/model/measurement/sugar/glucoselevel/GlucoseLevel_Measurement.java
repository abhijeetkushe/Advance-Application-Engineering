package org.stable.sdk.model.measurement.sugar.glucoselevel;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.GlucoseLevel_Unit;

public class GlucoseLevel_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public GlucoseLevel_Measurement() {
		super();
	}

	public GlucoseLevel_Measurement(GlucoseLevel_Method_Type glucoseLevelType,
			MeasurementValue measurementValue) {

		setMethodType(glucoseLevelType);
		GlucoseLevel_Unit glucoseLevel_Unit = new GlucoseLevel_Unit();
		setUnit(glucoseLevel_Unit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.GLUCOSE_LEVEL;
	}

}
