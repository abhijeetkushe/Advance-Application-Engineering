package org.stable.sdk.model.measurement.labwork.cbc.plts;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.K_per_Ul_Unit;

public class PLTS_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public PLTS_Measurement() {
		super();
	}

	public PLTS_Measurement(PLTS_Method_Type wbc_Method_Type,
			MeasurementValue measurementValue) {

		setMethodType(wbc_Method_Type);
		K_per_Ul_Unit k_per_Ul_Unit = new K_per_Ul_Unit();
		setUnit(k_per_Ul_Unit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.PLTS;
	}

}
