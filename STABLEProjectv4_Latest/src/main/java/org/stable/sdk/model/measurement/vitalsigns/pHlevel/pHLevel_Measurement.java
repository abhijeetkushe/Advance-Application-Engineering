package org.stable.sdk.model.measurement.vitalsigns.pHlevel;

import org.stable.sdk.model.measurement.IMeasurementType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.NoUnit;

public class pHLevel_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public pHLevel_Measurement() {
		super();
	}

	public pHLevel_Measurement(pHLevel_Method_Type pHLevelType,
			MeasurementValue value) {

		setMethodType(pHLevelType);
		NoUnit unitLess = new NoUnit();
		setUnit(unitLess.getId());
		setValue(value.getMeasurementValue());
	}

	@Override
	public IMeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.PH_LEVEL;
	}

}
