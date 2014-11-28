package org.stable.sdk.model.measurement.airway.trachealincubation;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.cm_Unit;

public class TrachealIncubation_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public TrachealIncubation_Measurement() {
		super();
	}

	public TrachealIncubation_Measurement(
			TrachealIncubation_Method_Type trachealIncubationType,
			MeasurementValue measurementValue) {

		setMethodType(trachealIncubationType);
		cm_Unit cm_Unit = new cm_Unit();
		setUnit(cm_Unit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.TRACHEAL_INCUBATION;
	}

}
