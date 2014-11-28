package com.me.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.stable.sdk.model.measurement.Measurement;

public class LabTests implements Serializable {

	private String testName;
	private Date date;
	private boolean status;
	private Map<String,String> value;
	private Collection<Measurement> measurementCollection;
	public Collection<Measurement> getMeasurementCollection() {
		return measurementCollection;
	}
	public void setMeasurementCollection(
			Collection<Measurement> measurementCollection) {
		this.measurementCollection = measurementCollection;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Map<String, String> getValue() {
		return value;
	}
	public void setValue(Map<String, String> value) {
		this.value = value;
	}
}
