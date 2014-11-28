package org.stable.sdk.model.measurement.labwork.cbc.neutrophils;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.Percentage_Unit;

public class Neutrophils_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public Neutrophils_Measurement() {
		super();
	}

	public Neutrophils_Measurement(
			Neutrophils_Method_Type neutrophils_Method_Type,
			MeasurementValue measurementValue) {

		setMethodType(neutrophils_Method_Type);
		Percentage_Unit percentage_Unit = new Percentage_Unit();
		setUnit(percentage_Unit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.NEUTROPHILS;
	}

}
