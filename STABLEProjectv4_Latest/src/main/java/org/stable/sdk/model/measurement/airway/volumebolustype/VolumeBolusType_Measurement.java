package org.stable.sdk.model.measurement.airway.volumebolustype;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.units.NoUnit;

public class VolumeBolusType_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public VolumeBolusType_Measurement() {
		super();
	}

	public VolumeBolusType_Measurement(
			VolumeBolusType_Method_Type volumeBolusTypeType, int value) {

		setMethodType(volumeBolusTypeType);
		NoUnit noUnit = new NoUnit();
		setUnit(noUnit.getId());
		setValue(String.valueOf(value));
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.VOLUME_BOLUS_TYPE;
	}

}
