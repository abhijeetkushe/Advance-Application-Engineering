package org.stable.sdk.model.measurement.labwork.cbc.wbc;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.K_per_Ul_Unit;

public class WBC_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public WBC_Measurement() {
		super();
	}

	public WBC_Measurement(WBC_Method_Type wbc_Method_Type,
			MeasurementValue measurementValue) {

		setMethodType(wbc_Method_Type);
		K_per_Ul_Unit wbc_Unit = new K_per_Ul_Unit();
		setUnit(wbc_Unit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.WBC;
	}

}
