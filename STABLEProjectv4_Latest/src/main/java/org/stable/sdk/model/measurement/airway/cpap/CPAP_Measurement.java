package org.stable.sdk.model.measurement.airway.cpap;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.units.NoUnit;

public class CPAP_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public CPAP_Measurement() {
		super();
	}

	public CPAP_Measurement(CPAP_Method_Type CPAPType,
			CPAP_MeasurmentValue value) {

		setMethodType(CPAPType);
		NoUnit noUnit = new NoUnit();
		setUnit(noUnit.getId());
		setValue(value.getValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		return MeasurementType.CPAP;
	}

}
