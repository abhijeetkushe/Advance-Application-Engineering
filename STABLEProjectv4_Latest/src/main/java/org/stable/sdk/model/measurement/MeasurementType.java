package org.stable.sdk.model.measurement;

public enum MeasurementType implements IMeasurementType{
	BLOOD_GAS(1),
	BLOOD_GROUP(2),  //SAME
	BLOOD_PRESSURE(3),
	FiO2(4),
	HCO3(5),
	HEART_RATE(6),
	O2_SATURATION(7),
	PCO2(8),
	PH_LEVEL(9),
	RESPIRATORY_RATE(10),
	TEMPERATURE(11),
	WEIGHT(12),
	BASE_EXCESS(13),
	CPAP(14),
	DOPAMINE(15),
	ET_TUBE(16),
	O2_IN_USE(17),
	PPV(18),
	TRACHEAL_INCUBATION(19),
	VOLUME_BOLUS_AMOUNT(20),
	VOLUME_BOLUS_TYPE(21),
	PULSE_PRESSURE(22),
	CAPILLARY_REFILL_TIME(23),
	
	BIRTH_ORDER(24),
	GESTATIONAL_AGE(25),
	GLUCOSE_LEVEL(26),
	HEAD_CIRCUMFRENCE(27),
	HEIGHT(28),
	
	BOLUS_DOSE(29),
	BOLUS_CONC(30),
	BOLUS_INFUSION_RATE(31),
	
	DEXTROSE_CONC(32),
	DEXTROSE_HOURLY_INFUSION_RATE(33),
	DEXTROSE_RATE_OF_INFUSION(34),
	
	IV_AT(35),
	UVC_AT(36),
	UAC_AT(37), 
	WBC(38),
	Hgb(39),
	Hct(40),
	PLTS(41),
	NEUTROPHILS(42),
	BANDS(43),
	BASOS(44),
	EOS(45),
	LYMPHS(46),
	METAMYELOCYTES(47),
	MetHb(48),
	MONOS(49),
	Fibrinogen(50),
	Prothrombin_Time(51),
	Partial_Thromboplastin_Time(52),
	Cl(53),
	CO2(54),
	C_Reactive_Protein(55),
	K(56),
	Na(57),
	Ionized_Calcium(58),
	Total_Calcium(59),
	PO2(60);

	private int id;

	public int getId() {
		return this.id;
	}

	private MeasurementType(int id) {
		this.id = id;
	}

}
