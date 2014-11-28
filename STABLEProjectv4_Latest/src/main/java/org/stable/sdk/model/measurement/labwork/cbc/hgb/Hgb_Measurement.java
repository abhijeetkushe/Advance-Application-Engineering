package org.stable.sdk.model.measurement.labwork.cbc.hgb;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.Hgb_Unit;

public class Hgb_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public Hgb_Measurement() {
		super();
	}

	public Hgb_Measurement(Hgb_Method_Type wbc_Method_Type,
			MeasurementValue measurementValue) {

		setMethodType(wbc_Method_Type);
		Hgb_Unit hgb_Unit = new Hgb_Unit();
		setUnit(hgb_Unit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.Hgb;
	}

}
