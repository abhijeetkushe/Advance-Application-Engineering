package org.stable.sdk.model.measurement.airway.baseexcess;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.NoUnit;

public class BaseExcess_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BaseExcess_Measurement() {
		super();
	}

	public BaseExcess_Measurement(BaseExcess_Method_Type baseExcessType,
			MeasurementValue value){
		setMethodType(baseExcessType);
		NoUnit noUnit = new NoUnit();
		setUnit(noUnit.getId());
		setValue(value.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.BASE_EXCESS;
	}

}
