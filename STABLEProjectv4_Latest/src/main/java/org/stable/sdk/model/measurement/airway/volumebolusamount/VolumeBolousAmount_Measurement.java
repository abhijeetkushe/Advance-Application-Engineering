package org.stable.sdk.model.measurement.airway.volumebolusamount;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.NoUnit;

public class VolumeBolousAmount_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public VolumeBolousAmount_Measurement() {
		super();
	}

	public VolumeBolousAmount_Measurement(
			VolumeBolousAmount_Method_Type volumeBolusAmountType,
			MeasurementValue value) {

		setMethodType(volumeBolusAmountType);
		NoUnit noUnit = new NoUnit();
		// noUnit.setValue(String.valueOf(value));
		setUnit(noUnit.getId());
		setValue(value.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.VOLUME_BOLUS_AMOUNT;
	}

}
