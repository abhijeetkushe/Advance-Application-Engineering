package org.stable.sdk.model.measurement.vitalsigns.respiratoryrate;

import java.util.Date;

import org.stable.sdk.model.measurement.IMeasurementType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.measurement.MeasurementValue;
import org.stable.sdk.model.units.Per_Min_Unit;

public class RespiratoryRate_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public RespiratoryRate_Measurement() {
		super();
	}

	public RespiratoryRate_Measurement(
			RespiratoryRate_Method_Type RespiratoryRateType,
			MeasurementValue value) {

		setMethodType(RespiratoryRateType);
		Per_Min_Unit per_Min_Unit = new Per_Min_Unit();
		setUnit(per_Min_Unit.getId());
		setValue(value.getMeasurementValue());
	}

	public RespiratoryRate_Measurement(RespiratoryRate_Method_Type type,
			MeasurementValue value, Date dateTime) {

		setDateTime(dateTime);
		setMethodType(type);
		setValue(value.getMeasurementValue());
		Per_Min_Unit per_Min_Unit = new Per_Min_Unit();
		setUnit(per_Min_Unit.getId());
	}

	@Override
	public IMeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.RESPIRATORY_RATE;
	}

}
