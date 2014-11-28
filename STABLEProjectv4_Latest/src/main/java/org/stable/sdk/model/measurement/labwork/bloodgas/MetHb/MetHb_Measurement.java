package org.stable.sdk.model.measurement.labwork.bloodgas.MetHb;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.Percentage_Unit;

public class MetHb_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public MetHb_Measurement() {
		super();
	}

	public MetHb_Measurement(MetHb_Method_Type metHb_Method_Type,
			MeasurementValue measurementValue) {

		setMethodType(metHb_Method_Type);
		Percentage_Unit percentage_Unit = new Percentage_Unit();
		setUnit(percentage_Unit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.MetHb;
	}

}
