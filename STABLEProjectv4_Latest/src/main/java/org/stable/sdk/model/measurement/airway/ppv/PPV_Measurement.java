package org.stable.sdk.model.measurement.airway.ppv;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.NoUnit;

public class PPV_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public PPV_Measurement() {
		super();
	}

	public PPV_Measurement(PPV_Method_Type PPVType,
			MeasurementValue measurementValue) {

		setMethodType(PPVType);
		// APGAR_Unit apgar = APGAR_Unit.SCORE;
		// apgar.setValue(value);
		NoUnit noUnit = new NoUnit();
		setUnit(noUnit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.PPV;
	}

}
