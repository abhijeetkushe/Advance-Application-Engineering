package org.stable.sdk.model.measurement.sugar.birthorder;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.NoUnit;

public class BirthOrder_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BirthOrder_Measurement() {
		super();
	}

	public BirthOrder_Measurement(BirthOrder_Method_Type birthOrderType,
			MeasurementValue measurementValue) {

		setMethodType(birthOrderType);
		NoUnit noUnit = new NoUnit();
		setUnit(noUnit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.BIRTH_ORDER;
	}

}
