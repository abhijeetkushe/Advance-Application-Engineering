package org.stable.sdk.model.measurement.labwork.clotting.ptt;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.Time_Metric;

public class PartialThromboplastinTime_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public PartialThromboplastinTime_Measurement() {
		super();
	}

	public PartialThromboplastinTime_Measurement(
			PartialThromboplastinTime_Method_Type wbc_Method_Type,
			MeasurementValue measurementValue) {

		setMethodType(wbc_Method_Type);
		Time_Metric time_Metric = new Time_Metric();
		setUnit(time_Metric.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.Partial_Thromboplastin_Time;
	}

}
