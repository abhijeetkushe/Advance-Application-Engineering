package org.stable.sdk.model.test;

import org.stable.sdk.model.measurement.airway.baseexcess.BaseExcess_Measurement;
import org.stable.sdk.model.measurement.labwork.bloodgas.MetHb.MetHb_Measurement;
import org.stable.sdk.model.measurement.labwork.bloodgas.PO2.PO2_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.hco3.HCO3_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.pHlevel.pHLevel_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.pco2.PCO2_Measurement;
import org.stable.sdk.model.order.Order;



public class BloodGas extends Order {
	
	private pHLevel_Measurement pHLevel_Measurement;
	private PCO2_Measurement pco2_Measurement;
	private HCO3_Measurement hco3_Measurement;
	private BaseExcess_Measurement baseExcess_Measurement;
	private MetHb_Measurement metHb_Measurement;
	private PO2_Measurement po2_measurment;
	public PO2_Measurement getPo2_measurment() {
		return po2_measurment;
	}

	public void setPo2_measurment(PO2_Measurement po2_measurment) {
		this.po2_measurment = po2_measurment;
	}

	public int getLabid() {
		return labid;
	}

	private int labid; 
	
	
	
	public int getLab_id() {
		return labid;
	}

	public void setLabid(int labid) {
		this.labid = labid;
	}

	public BloodGas() {
		// TODO Auto-generated constructor stub
	}
	
	public HCO3_Measurement getHco3_Measurement() {
		return hco3_Measurement;
	}
	
	public BaseExcess_Measurement getBaseExcess_Measurement() {
		return baseExcess_Measurement;
	}
	
	public MetHb_Measurement getMetHb_Measurement() {
		return metHb_Measurement;
	}
	
	public PCO2_Measurement getPco2_Measurement() {
		return pco2_Measurement;
	}
	
	public pHLevel_Measurement getpHLevel_Measurement() {
		return pHLevel_Measurement;
	}
	
	public void setBaseExcess_Measurement(
			BaseExcess_Measurement baseExcess_Measurement) {
		this.baseExcess_Measurement = baseExcess_Measurement;
	}
	
	public void setHco3_Measurement(HCO3_Measurement hco3_Measurement) {
		this.hco3_Measurement = hco3_Measurement;
	}
	
	public void setMetHb_Measurement(MetHb_Measurement metHb_Measurement) {
		this.metHb_Measurement = metHb_Measurement;
	}
	
	public void setPco2_Measurement(PCO2_Measurement pco2_Measurement) {
		this.pco2_Measurement = pco2_Measurement;
	}
	
	public void setpHLevel_Measurement(pHLevel_Measurement pHLevel_Measurement) {
		this.pHLevel_Measurement = pHLevel_Measurement;
	}
	

}
