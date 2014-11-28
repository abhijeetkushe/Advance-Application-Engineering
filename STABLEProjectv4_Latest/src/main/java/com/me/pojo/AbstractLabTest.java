package com.me.pojo;

import java.io.Serializable;
import java.util.Collection;
import org.springframework.webflow.execution.RequestContext;

import org.stable.sdk.model.measurement.Measurement;

public abstract class AbstractLabTest implements Serializable{

	public abstract Collection<Measurement> getMeasurements(RequestContext context);
	
 
}
