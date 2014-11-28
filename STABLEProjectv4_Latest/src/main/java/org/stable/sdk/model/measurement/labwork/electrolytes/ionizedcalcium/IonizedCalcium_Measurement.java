package org.stable.sdk.model.measurement.labwork.electrolytes.ionizedcalcium;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.mmol_per_L_Unit;

public class IonizedCalcium_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public IonizedCalcium_Measurement() {
		super();
	}

	public IonizedCalcium_Measurement(
			IonizedCalcium_Method_Type ionizedCalcium_Method_Type,
			MeasurementValue measurementValue) {

		setMethodType(ionizedCalcium_Method_Type);
		mmol_per_L_Unit mmol_per_L_Unit = new mmol_per_L_Unit();
		setUnit(mmol_per_L_Unit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.Ionized_Calcium;
	}

}
