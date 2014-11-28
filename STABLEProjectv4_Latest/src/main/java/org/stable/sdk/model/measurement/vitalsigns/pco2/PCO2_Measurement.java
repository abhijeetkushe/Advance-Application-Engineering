package org.stable.sdk.model.measurement.vitalsigns.pco2;

import org.stable.sdk.model.measurement.IMeasurementType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.Pressure_Unit;

public class PCO2_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public PCO2_Measurement() {
		super();
	}

	public PCO2_Measurement(PCO2_Method_Type PCO2Type, MeasurementValue value) {

		setMethodType(PCO2Type);
		Pressure_Unit pressure_Unit = new Pressure_Unit();
		setUnit(pressure_Unit.getId());
		setValue(value.getMeasurementValue());
	}

	@Override
	public IMeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.PCO2;
	}

}
