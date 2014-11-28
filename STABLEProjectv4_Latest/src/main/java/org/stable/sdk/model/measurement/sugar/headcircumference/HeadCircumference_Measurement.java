package org.stable.sdk.model.measurement.sugar.headcircumference;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.cm_Unit;

public class HeadCircumference_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public HeadCircumference_Measurement() {
		super();
	}

	public HeadCircumference_Measurement(
			HeadCircumference_Method_Type headCircumferenceType,
			MeasurementValue measurementValue) {

		setMethodType(headCircumferenceType);
		cm_Unit lengthMetric = new cm_Unit();
		setUnit(lengthMetric.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.HEAD_CIRCUMFRENCE;
	}

}
