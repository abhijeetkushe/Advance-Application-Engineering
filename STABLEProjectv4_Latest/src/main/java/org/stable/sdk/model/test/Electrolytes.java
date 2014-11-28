package org.stable.sdk.model.test;

import org.stable.sdk.model.measurement.labwork.cbc.hgb.Hgb_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.wbc.WBC_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.CO2.CO2_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.Cl.Cl_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.K.K_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.Na.Na_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.ionizedcalcium.IonizedCalcium_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.totalcalcium.TotalCalcium_Measurement;
import org.stable.sdk.model.order.Order;

public class Electrolytes extends Order {
	
	private int lab_id; 
	private Cl_Measurement cl_measurement;
	private CO2_Measurement co2_measurement;
	private IonizedCalcium_Measurement ionizedcalcium_measurement;
	private K_Measurement k_measurement;
	private Na_Measurement na_measurement;
	private TotalCalcium_Measurement totalcalcium_measurement;
	
	
	
	public int getLab_id() {
		return lab_id;
	}
	public void setLab_id(int lab_id) {
		this.lab_id = lab_id;
	}
	public Cl_Measurement getCl_measurement() {
		return cl_measurement;
	}
	public void setCl_measurement(Cl_Measurement cl_measurement) {
		this.cl_measurement = cl_measurement;
	}
	public CO2_Measurement getCo2_measurement() {
		return co2_measurement;
	}
	public void setCo2_measurement(CO2_Measurement co2_measurement) {
		this.co2_measurement = co2_measurement;
	}
	public IonizedCalcium_Measurement getIonizedcalcium_measurement() {
		return ionizedcalcium_measurement;
	}
	public void setIonizedcalcium_measurement(
			IonizedCalcium_Measurement ionizedcalcium_measurement) {
		this.ionizedcalcium_measurement = ionizedcalcium_measurement;
	}
	public K_Measurement getK_measurement() {
		return k_measurement;
	}
	public void setK_measurement(K_Measurement k_measurement) {
		this.k_measurement = k_measurement;
	}
	public Na_Measurement getNa_measurement() {
		return na_measurement;
	}
	public void setNa_measurement(Na_Measurement na_measurement) {
		this.na_measurement = na_measurement;
	}
	public TotalCalcium_Measurement getTotalcalcium_measurement() {
		return totalcalcium_measurement;
	}
	public void setTotalcalcium_measurement(
			TotalCalcium_Measurement totalcalcium_measurement) {
		this.totalcalcium_measurement = totalcalcium_measurement;
	}
	
	
	
	
	
	

}
