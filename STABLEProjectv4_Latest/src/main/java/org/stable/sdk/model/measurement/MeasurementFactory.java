package org.stable.sdk.model.measurement;

import org.stable.sdk.model.measurement.airway.baseexcess.BaseExcess_Method_Type;
import org.stable.sdk.model.measurement.labwork.cbc.bands.Bands_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.bands.Bands_Method_Type;
import org.stable.sdk.model.measurement.vitalsigns.bloodgas.BloodGas_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.bloodgas.BloodGas_Method_Type;

public class MeasurementFactory {

	public static Measurement getMeasurement(int measurementType,
			int methodType, final String value) {
		Measurement measurement = null;
		MeasurementType mType = MeasurementType.values()[measurementType];

		MeasurementValue measurementValue = new MeasurementValue() {

			public String getMeasurementValue() {
				// TODO Auto-generated method stub
				return value;
			}
		};

		switch (mType) {
		case BLOOD_GAS:

			BloodGas_Method_Type bloodGasMethodType = BloodGas_Method_Type
					.values()[methodType];

			measurement = new BloodGas_Measurement(bloodGasMethodType,
					measurementValue);
			return measurement;

		case BANDS:
			Bands_Method_Type bands_Method_Type = Bands_Method_Type.values()[methodType];
			measurement = new Bands_Measurement(bands_Method_Type,
					measurementValue);
			return measurement;

		case BASE_EXCESS:
			BaseExcess_Method_Type baseExcess_Method_Type = BaseExcess_Method_Type
					.values()[methodType];

		}

		return measurement;
	}

}
