package org.stable.sdk.model.test;

import org.stable.sdk.model.measurement.labwork.clotting.fibrinogen.Fibrinogen_Measurement;
import org.stable.sdk.model.measurement.labwork.clotting.pt.ProthrombinTime_Measurement;
import org.stable.sdk.model.measurement.labwork.clotting.ptt.PartialThromboplastinTime_Measurement;
import org.stable.sdk.model.order.Order;

public class Clotting extends Order {
	
	private int lab_id; 
	private Fibrinogen_Measurement fibrinogen_measurement;
	private ProthrombinTime_Measurement prothrombin_measurement;
	private PartialThromboplastinTime_Measurement  thromboplastin_measurement;
	
	
	
	
	
	public int getLab_id() {
		return lab_id;
	}
	public void setLab_id(int lab_id) {
		this.lab_id = lab_id;
	}
	public Fibrinogen_Measurement getFibrinogen_measurement() {
		return fibrinogen_measurement;
	}
	public void setFibrinogen_measurement(
			Fibrinogen_Measurement fibrinogen_measurement) {
		this.fibrinogen_measurement = fibrinogen_measurement;
	}
	public ProthrombinTime_Measurement getProthrombin_measurement() {
		return prothrombin_measurement;
	}
	public void setProthrombin_measurement(
			ProthrombinTime_Measurement prothrombin_measurement) {
		this.prothrombin_measurement = prothrombin_measurement;
	}
	public PartialThromboplastinTime_Measurement getThromboplastin_measurement() {
		return thromboplastin_measurement;
	}
	public void setThromboplastin_measurement(
			PartialThromboplastinTime_Measurement thromboplastin_measurement) {
		this.thromboplastin_measurement = thromboplastin_measurement;
	}
	
	
	
	

}
