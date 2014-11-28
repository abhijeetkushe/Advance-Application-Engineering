package org.stable.sdk.model.measurement.labwork.electrolytes.K;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.mmol_per_L_Unit;

public class K_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public K_Measurement() {
		super();
	}

	public K_Measurement(K_Method_Type k_Method_Type,
			MeasurementValue measurementValue) {

		setMethodType(k_Method_Type);
		mmol_per_L_Unit mmol_per_L_Unit = new mmol_per_L_Unit();
		setUnit(mmol_per_L_Unit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.K;
	}

}
