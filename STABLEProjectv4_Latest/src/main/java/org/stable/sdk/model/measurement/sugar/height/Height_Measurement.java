package org.stable.sdk.model.measurement.sugar.height;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.cm_Unit;

public class Height_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public Height_Measurement() {
		super();
	}

	public Height_Measurement(Height_Method_Type heightType,
			MeasurementValue measurementValue) {

		setMethodType(heightType);
		cm_Unit lengthMetric = new cm_Unit();
		setUnit(lengthMetric.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.HEIGHT;
	}

}
