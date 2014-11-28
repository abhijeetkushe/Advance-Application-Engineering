package org.stable.sdk.model.test;

import org.stable.sdk.model.measurement.labwork.crp.C_ReactiveProtein_Measurement;
import org.stable.sdk.model.order.Order;

public class CRP extends Order {
	
	private int lab_id; 
	private C_ReactiveProtein_Measurement C_Reactive_Protein_measurement;
	
	
	
	public int getLab_id() {
		return lab_id;
	}
	public void setLab_id(int lab_id) {
		this.lab_id = lab_id;
	}
	public C_ReactiveProtein_Measurement getC_Reactive_Protein_measurement() {
		return C_Reactive_Protein_measurement;
	}
	public void setC_Reactive_Protein_measurement(
			C_ReactiveProtein_Measurement c_Reactive_Protein_measurement) {
		C_Reactive_Protein_measurement = c_Reactive_Protein_measurement;
	}
	
	
	

}
