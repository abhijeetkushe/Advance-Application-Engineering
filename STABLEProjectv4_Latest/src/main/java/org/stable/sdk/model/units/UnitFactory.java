package org.stable.sdk.model.units;


public class UnitFactory {

	private UnitFactory(){
		
	}
	public static Unit  getUnit(int i) {

		switch (i) {
		case 0:
			return new APGAR_Unit();
		case 1:
			return new mg_per_dL_Unit();
		case 2:
			return new GestationalAge_Unit();
		case 3:
			return new GlucoseLevel_Unit();
		case 4:
			return new HourlyFluidRate_Unit();
		case 5:
			return new InfusionRate_Unit_ml_kg();
		case 6:
			return new InfusionRate_Unit_ml_kg_day();
		case 7:
			return new cm_Unit();
		case 8:
			return new mcg_Unit();
		case 9:
			return new NoUnit();
		case 10:
			return new Per_Min_Unit();
		case 11:
			return new Pressure_Unit();
		case 12:
			return new Temperature_Metric();
		case 13:
			return new Time_Metric();
		case 14:
			return new kg_Unit();
		case 15:
			return new K_per_Ul_Unit();
		case 16:
			return new Hgb_Unit();
		case 17:
			return new mmol_per_L_Unit();
		default:
			return null;
		}

	}

}
