package org.stable.sdk.model.measurement.vitalsigns.bloodgas;

import org.stable.sdk.model.measurement.IMeasurementType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.mg_per_dL_Unit;

public class BloodGas_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BloodGas_Measurement() {
		super();
	}

	public BloodGas_Measurement(BloodGas_Method_Type bloodGasMethodType,
			MeasurementValue value) {
		setMethodType(bloodGasMethodType);
		mg_per_dL_Unit mg_per_dL_Unit = new mg_per_dL_Unit();
		setUnit(mg_per_dL_Unit.getId());
		setValue(value.getMeasurementValue());
	}

	@Override
	public IMeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.BLOOD_GAS;
	}

}
