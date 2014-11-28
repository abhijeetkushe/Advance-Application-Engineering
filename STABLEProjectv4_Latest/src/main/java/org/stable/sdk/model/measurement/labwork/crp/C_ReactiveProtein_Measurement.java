package org.stable.sdk.model.measurement.labwork.crp;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.mg_per_dL_Unit;

public class C_ReactiveProtein_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public C_ReactiveProtein_Measurement() {
		super();
	}

	public C_ReactiveProtein_Measurement(
			C_ReactiveProtein_Method_Type wbc_Method_Type,
			MeasurementValue measurementValue) {

		setMethodType(wbc_Method_Type);
		mg_per_dL_Unit mg_per_dL_Unit = new mg_per_dL_Unit();
		setUnit(mg_per_dL_Unit.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.C_Reactive_Protein;
	}

}
