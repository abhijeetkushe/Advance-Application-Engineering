package org.stable.sdk.model.measurement.airway.dopamine;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.mcg_Unit;

public class Dopamine_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public Dopamine_Measurement() {
		super();
	}

	public Dopamine_Measurement(Dopamine_Method_Type dopamineType,
			MeasurementValue measurementValue) {

		setMethodType(dopamineType);
		// APGAR_Unit apgar = APGAR_Unit.SCORE;
		mcg_Unit mcg_UnitV = new mcg_Unit();
		setUnit(mcg_UnitV.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.DOPAMINE;
	}

}
