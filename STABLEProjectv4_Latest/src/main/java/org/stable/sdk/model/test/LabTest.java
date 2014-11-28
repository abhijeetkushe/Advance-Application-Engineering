package org.stable.sdk.model.test;

import java.sql.Date;

import org.stable.sdk.model.order.Order;

public class LabTest extends Order {
	
	private int testId;
	private Date occuredOn;

	public LabTest() {
		// TODO Auto-generated constructor stub
	}
	
	public int getTestId() {
		return testId;
	}
	
	public Date getOccuredOn() {
		return occuredOn;
	}
	
	public void setTestId(int testId) {
		this.testId = testId;
	}
	
	public void setOccuredOn(Date occuredOn) {
		this.occuredOn = occuredOn;
	}
	
}
