package org.stable.sdk.model.measurement.sugar.treatment.bolusconc;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.NoUnit;

public class BolusConc_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BolusConc_Measurement() {
		super();
	}

	public BolusConc_Measurement(
			BolusConc_Method_Type desiredBolusConcType,
			MeasurementValue measurementValue) {

		setMethodType(desiredBolusConcType);
		NoUnit noUnit = new NoUnit();
		// noUnit.setValue(String.valueOf(value));
		setUnit(noUnit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.BOLUS_CONC;
	}

}
