package org.stable.sdk.model.measurement.sugar.treatment.dextrosehourlyinfusionrate;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.InfusionRate_Unit_ml_kg_day;

public class DextroseHourlyInfusionRate_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public DextroseHourlyInfusionRate_Measurement() {
		super();
	}

	public DextroseHourlyInfusionRate_Measurement(
			DextroseHourlyInfusionRate_Method_Type infusionRateType,
			MeasurementValue measurementValue) {

		setMethodType(infusionRateType);
		InfusionRate_Unit_ml_kg_day infusionRate_Unit_ml_kg_day = new InfusionRate_Unit_ml_kg_day();
		setUnit(infusionRate_Unit_ml_kg_day.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.DEXTROSE_HOURLY_INFUSION_RATE;
	}

}
