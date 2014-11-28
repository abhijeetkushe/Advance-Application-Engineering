package org.stable.sdk.model.measurement.sugar.treatment.dextroseinfusionrate;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.HourlyFluidRate_Unit;

public class DextroseInfusionRate_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public DextroseInfusionRate_Measurement() {
		super();
	}

	public DextroseInfusionRate_Measurement(
			DesiredInfusionRate_Method_Type desiredInfusionRateType,
			MeasurementValue measurementValue) {

		setMethodType(desiredInfusionRateType);
		HourlyFluidRate_Unit hourlyFluidRate_Unit = new HourlyFluidRate_Unit();
		setUnit(hourlyFluidRate_Unit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.DEXTROSE_HOURLY_INFUSION_RATE;
	}

}
