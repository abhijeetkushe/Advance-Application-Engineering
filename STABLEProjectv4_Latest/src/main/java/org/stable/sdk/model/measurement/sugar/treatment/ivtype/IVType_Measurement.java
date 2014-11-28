package org.stable.sdk.model.measurement.sugar.treatment.ivtype;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.NoUnit;

public class IVType_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public IVType_Measurement() {
		super();
	}

	public IVType_Measurement(IVType_Method_Type IVTypeType,
			MeasurementValue value) {

		setMethodType(IVTypeType);
		NoUnit noUnit = new NoUnit();
		// apgar.setValue(value);
		setUnit(noUnit.getId());
		setValue(value.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.IV_AT;
	}

}
