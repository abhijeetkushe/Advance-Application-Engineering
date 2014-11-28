package org.stable.sdk.model.measurement.sugar.treatment.vacat;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.NoUnit;

public class UAC_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public UAC_Measurement() {
		super();
	}

	public UAC_Measurement(UAC_Method_Type apgarType,
			MeasurementValue measurementValue) {

		setMethodType(apgarType);
		NoUnit noUnit = new NoUnit();
		setUnit(noUnit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.UAC_AT;
	}

}
