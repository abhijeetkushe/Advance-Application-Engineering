package org.stable.sdk.model.measurement.sugar.treatment.uvcat;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.NoUnit;

public class UVC_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public UVC_Measurement() {
		super();
	}

	public UVC_Measurement(UVC_Method_Type apgarType,
			MeasurementValue measurementValue) {

		setMethodType(apgarType);
		NoUnit noUnit = new NoUnit();
		setUnit(noUnit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.UVC_AT;
	}

}
