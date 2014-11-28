package org.stable.sdk.model.measurement.airway.o2inuse;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.Percentage_Unit;

public class O2InUse_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public O2InUse_Measurement() {
		super();
	}

	public O2InUse_Measurement(O2InUse_Method_Type O2InUseType,
			MeasurementValue measurementValue) {

		setMethodType(O2InUseType);
		// APGAR_Unit apgar = APGAR_Unit.SCORE;
		Percentage_Unit percentage_Unit = new Percentage_Unit();
		setUnit(percentage_Unit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.O2_IN_USE;
	}

}
