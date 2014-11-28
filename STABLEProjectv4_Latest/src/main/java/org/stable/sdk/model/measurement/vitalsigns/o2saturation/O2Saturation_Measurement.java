package org.stable.sdk.model.measurement.vitalsigns.o2saturation;

import org.stable.sdk.model.measurement.IMeasurementType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.Percentage_Unit;

public class O2Saturation_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public O2Saturation_Measurement() {
		super();
	}

	public O2Saturation_Measurement(O2Saturation_Method_Type O2SaturationType,
			MeasurementValue value) {

		setMethodType(O2SaturationType);
		Percentage_Unit percentage_Unit = new Percentage_Unit();
		setUnit(percentage_Unit.getId());
		setValue(value.getMeasurementValue());
	}

	@Override
	public IMeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.O2_SATURATION;
	}

}
