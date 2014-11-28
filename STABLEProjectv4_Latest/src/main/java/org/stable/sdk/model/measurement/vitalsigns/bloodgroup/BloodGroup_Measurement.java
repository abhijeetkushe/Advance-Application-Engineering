package org.stable.sdk.model.measurement.vitalsigns.bloodgroup;

import org.stable.sdk.model.measurement.IMeasurementType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.units.NoUnit;

public class BloodGroup_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public BloodGroup_Measurement() {
		super();
	}

	public BloodGroup_Measurement(BloodGroup_Method_Type BloodGroupType,
			BloodGroup_Value value) {
		setMethodType(BloodGroupType);
		NoUnit unit = new NoUnit();
		setUnit(unit.getId());
		setValue(value.toString());

	}

	@Override
	public IMeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.BLOOD_GROUP;
	}

}
