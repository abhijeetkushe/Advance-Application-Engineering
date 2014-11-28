package com.me.pojo;

import java.util.Collection;

import org.springframework.webflow.execution.RequestContext;
import org.stable.sdk.model.measurement.Measurement;

public class BGLabTest extends AbstractLabTest {

	public Collection<Measurement> getMeasurementCollection() {
		return measurementCollection;
	}

	public void setMeasurementCollection(
			Collection<Measurement> measurementCollection) {
		this.measurementCollection = measurementCollection;
	}

	private Collection<Measurement> measurementCollection;

	@Override
	public Collection<Measurement> getMeasurements(RequestContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
