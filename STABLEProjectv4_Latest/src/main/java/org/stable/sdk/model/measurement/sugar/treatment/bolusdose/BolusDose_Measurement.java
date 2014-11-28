package org.stable.sdk.model.measurement.sugar.treatment.bolusdose;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.InfusionRate_Unit_ml_kg;

public class BolusDose_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BolusDose_Measurement() {
		super();
	}

	public BolusDose_Measurement(BolusDose_Method_Type desiredBolusType,
			MeasurementValue measurementValue) {

		setMethodType(desiredBolusType);
		InfusionRate_Unit_ml_kg infusionRate_Unit_ml_kg = new InfusionRate_Unit_ml_kg();
		setUnit(infusionRate_Unit_ml_kg.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.BOLUS_DOSE;
	}

}
