package org.stable.sdk.model.order;

import org.stable.sdk.model.common.IStableModel;
import org.stable.sdk.model.encounter.Assessment;
import org.stable.sdk.model.encounter.Treatment;

public class Order implements IStableModel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long orderedOn;
	private long orderid;
	
	private  Assessment assessment;
	private Treatment treatment;
	
	public long getOrderedOn() {
		return orderedOn;
	}
	public void setOrderedOn(long orderedOn) {
		this.orderedOn = orderedOn;
	}
	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	
	public Assessment getAssessment() {
		return assessment;
	}
	
	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}
	
	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}
	
	public Treatment getTreatment() {
		return treatment;
	}
}
