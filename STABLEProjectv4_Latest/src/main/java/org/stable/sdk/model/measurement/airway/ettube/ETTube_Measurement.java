package org.stable.sdk.model.measurement.airway.ettube;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.MeasurementType;
import org.stable.sdk.model.units.NoUnit;

public class ETTube_Measurement extends Measurement {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;

	public ETTube_Measurement() {
		super();
	}

	public ETTube_Measurement(ETTube_Method_Type ETTubeType,
			ETTube_MeasurmentValue value) {

		setMethodType(ETTubeType);
		// APGAR_Unit apgar = APGAR_Unit.SCORE;
		NoUnit noUnit = new NoUnit();
		setUnit(noUnit.getId());
		setValue(value.getValue());
	}

	@Override
	public MeasurementType defineMeasurementType() {
		// TODO Auto-generated method stub
		return MeasurementType.ET_TUBE;
	}

}
