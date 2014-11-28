package org.stable.sdk.model.measurement.labwork.clotting.fibrinogen;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.mg_per_dL_Unit;

public class Fibrinogen_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public Fibrinogen_Measurement() {
		super();
	}

	public Fibrinogen_Measurement(
			Fibrinogen_Method_Type fibrinogen_Method_Type,
			MeasurementValue measurementValue) {

		setMethodType(fibrinogen_Method_Type);
		mg_per_dL_Unit mg_per_dL_Unit = new mg_per_dL_Unit();
		setUnit(mg_per_dL_Unit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.Fibrinogen;
	}

}
