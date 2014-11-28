package org.stable.sdk.model.encounter;

import java.util.ArrayList;
import java.util.Collection;

import org.stable.sdk.model.common.IStableModel;
import org.stable.sdk.model.order.Order;

public class Assessment implements IStableModel {
	
	private long assessmentID;
	private Collection<Order> orderList;
	
	public Assessment() {
		// TODO Auto-generated constructor stub
	}
	
	public long getAssessmentID() {
		return assessmentID;
	}
	
	public void setAssessmentID(long assessmentID) {
		this.assessmentID = assessmentID;
	}
	
	public Collection<Order> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(Collection<Order> orderList) {
		this.orderList = orderList;
	}

}
