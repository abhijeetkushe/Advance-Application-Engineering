package org.stable.sdk.model.measurement.bloodpressure.capillaryrefilltime;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.Time_Metric;

public class CapillaryRefillTime_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public CapillaryRefillTime_Measurement() {
		super();
	}

	public CapillaryRefillTime_Measurement(
			CapillaryRefillTime_Method_Type capillaryRefillTimeType,
			MeasurementValue measurementValue) {

		setMethodType(capillaryRefillTimeType);
		Time_Metric time_Metric = new Time_Metric();
		setUnit(time_Metric.getId());
		setValue(measurementValue.getMeasurementValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.CAPILLARY_REFILL_TIME;
	}

}
