package org.stable.sdk.model.encounter;

import java.util.ArrayList;
import java.util.Collection;

import org.stable.sdk.model.common.IStableModel;
import org.stable.sdk.model.order.Order;

public class Treatment implements IStableModel{
	
	private int treatmentID;
	
	private Collection<Order> orderList;

	public Treatment() {
		// TODO Auto-generated constructor stub
		orderList = new ArrayList<Order>();
	}

	public Collection<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(Collection<Order> orderList) {
		this.orderList = orderList;
	}
	
	public int getTreatmentID() {
		return treatmentID;
	}
	
	public void setTreatmentID(int treatmentID) {
		this.treatmentID = treatmentID;
	}
}
