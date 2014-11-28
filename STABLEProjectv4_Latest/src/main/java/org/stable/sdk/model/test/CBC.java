package org.stable.sdk.model.test;

import org.stable.sdk.model.measurement.labwork.cbc.bands.Bands_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.basos.Basos_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.eos.Eos_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.hct.Hct_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.hgb.Hgb_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.lymphs.Lymphs_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.metamyelocytes.Metamyelocytes_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.monos.Monos_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.neutrophils.Neutrophils_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.plts.PLTS_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.wbc.WBC_Measurement;
import org.stable.sdk.model.order.Order;

public class CBC extends Order {

	
	private int lab_id; 
	private WBC_Measurement wbc_Measurement;
	private Hgb_Measurement hgb_Measurement;
	private Hct_Measurement hct_Measurement;
	private PLTS_Measurement plts_Measurement;
	private Neutrophils_Measurement neutrophils_Measurement;
	private Bands_Measurement bands_Measurement;
	private Metamyelocytes_Measurement metamyelocytes_Measurement;
	private Lymphs_Measurement lymphs_Measurement;
	private Monos_Measurement monos_Measurement;
	private Basos_Measurement basos_Measurement;
	private Eos_Measurement eos_Measurement;
	
	public CBC() {
		// TODO Auto-generated constructor stub
	}
	public int getLab_id() {
		return lab_id;
	}

	public void setLab_id(int lab_id) {
		this.lab_id = lab_id;
	}
	public Bands_Measurement getBands_Measurement() {
		return bands_Measurement;
	}
	
	public Basos_Measurement getBasos_Measurement() {
		return basos_Measurement;
	}
	
	public Eos_Measurement getEos_Measurement() {
		return eos_Measurement;
	}
	
	public Hct_Measurement getHct_Measurement() {
		return hct_Measurement;
	}
	
	public Hgb_Measurement getHgb_Measurement() {
		return hgb_Measurement;
	}
	
	public Lymphs_Measurement getLymphs_Measurement() {
		return lymphs_Measurement;
	}
	
	public Metamyelocytes_Measurement getMetamyelocytes_Measurement() {
		return metamyelocytes_Measurement;
	}
	
	public Monos_Measurement getMonos_Measurement() {
		return monos_Measurement;
	}
	
	public Neutrophils_Measurement getNeutrophils_Measurement() {
		return neutrophils_Measurement;
	}
	
	public PLTS_Measurement getPlts_Measurement() {
		return plts_Measurement;
	}
	
	public WBC_Measurement getWbc_Measurement() {
		return wbc_Measurement;
	}
	
	
	public void setBands_Measurement(Bands_Measurement bands_Measurement) {
		this.bands_Measurement = bands_Measurement;
	}
	
	public void setBasos_Measurement(Basos_Measurement basos_Measurement) {
		this.basos_Measurement = basos_Measurement;
	}
	
	public void setEos_Measurement(Eos_Measurement eos_Measurement) {
		this.eos_Measurement = eos_Measurement;
	}
	
	
	public void setHct_Measurement(Hct_Measurement hct_Measurement) {
		this.hct_Measurement = hct_Measurement;
	}
	
	
	public void setHgb_Measurement(Hgb_Measurement hgb_Measurement) {
		this.hgb_Measurement = hgb_Measurement;
	}
	
	public void setLymphs_Measurement(Lymphs_Measurement lymphs_Measurement) {
		this.lymphs_Measurement = lymphs_Measurement;
	}
	
	public void setMetamyelocytes_Measurement(
			Metamyelocytes_Measurement metamyelocytes_Measurement) {
		this.metamyelocytes_Measurement = metamyelocytes_Measurement;
	}
	
	public void setMonos_Measurement(Monos_Measurement monos_Measurement) {
		this.monos_Measurement = monos_Measurement;
	}
	
	public void setNeutrophils_Measurement(
			Neutrophils_Measurement neutrophils_Measurement) {
		this.neutrophils_Measurement = neutrophils_Measurement;
	}
	
	
	public void setPlts_Measurement(PLTS_Measurement plts_Measurement) {
		this.plts_Measurement = plts_Measurement;
	}
	
	public void setWbc_Measurement(WBC_Measurement wbc_Measurement) {
		this.wbc_Measurement = wbc_Measurement;
	}
	

}
