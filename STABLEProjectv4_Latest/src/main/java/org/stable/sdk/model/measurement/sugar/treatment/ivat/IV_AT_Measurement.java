package org.stable.sdk.model.measurement.sugar.treatment.ivat;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.cm_Unit;

public class IV_AT_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public IV_AT_Measurement() {
		super();
	}

	public IV_AT_Measurement(IV_AT_Method_Type ivAtType, MeasurementValue value) {

		setMethodType(ivAtType);
		cm_Unit cm_Unit = new cm_Unit();
		setUnit(cm_Unit.getId());
		setValue(value.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.IV_AT;
	}

}
