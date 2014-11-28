package org.stable.sdk.model.measurement.sugar.treatment.dextroseconc;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.NoUnit;

public class DextroseConc_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public DextroseConc_Measurement() {
		super();
	}

	public DextroseConc_Measurement(DextroseConc_Method_Type dextroseConcType,
			MeasurementValue measurementValue) {

		setMethodType(dextroseConcType);
		// APGAR_Unit apgar = APGAR_Unit.SCORE;
		NoUnit noUnit = new NoUnit();
		setUnit(noUnit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.DEXTROSE_CONC;
	}

}
