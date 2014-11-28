package org.stable.sdk.model.measurement.vitalsigns.hco3;

import org.stable.sdk.model.measurement.IMeasurementType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.HCO3_Unit;

public class HCO3_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public HCO3_Measurement() {
		super();
	}

	public HCO3_Measurement(HCO3_Method_Type HCO3Type, MeasurementValue value) {

		setMethodType(HCO3Type);
		HCO3_Unit hco3_Unit = new HCO3_Unit();
		setUnit(hco3_Unit.getId());
		setValue(value.getMeasurementValue());

	}

	@Override
	public IMeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.HCO3;
	}

}
