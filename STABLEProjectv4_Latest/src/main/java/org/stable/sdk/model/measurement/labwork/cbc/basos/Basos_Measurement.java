package org.stable.sdk.model.measurement.labwork.cbc.basos;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.Percentage_Unit;

public class Basos_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public Basos_Measurement() {
		super();
	}

	public Basos_Measurement(Basos_Method_Type basos_Method_Type,
			MeasurementValue measurementValue) {

		setMethodType(basos_Method_Type);
		Percentage_Unit percentage_Unit = new Percentage_Unit();
		setUnit(percentage_Unit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.BASOS;
	}

}
