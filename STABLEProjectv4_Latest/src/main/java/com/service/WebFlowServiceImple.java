package com.service;

import java.io.Serializable;
import org.springframework.webflow.execution.RequestContext;

public class WebFlowServiceImple implements Serializable {

	
	public String getViewName(RequestContext rc){
		
		String eventId=rc.getCurrentEvent().getId();
		String viewName=null;
		if(eventId.equals("cbcForm"))
		{
			viewName="cbcForm";
		}else if(eventId.equals("bgForm"))
		{
			viewName="bgForm";
		}else if(eventId.equals("crpForm"))
		{
			viewName="crpForm";
		}
		else if(eventId.equals("csForm"))
		{
			viewName="csForm";
		}
		else if(eventId.equals("elecForm"))
		{
			viewName="elecForm";
		}
		rc.getFlowScope().put("viewName", viewName);			
		return "success";
	}
	
public String getPreviousView(RequestContext rc){
		
		String eventId=rc.getCurrentEvent().getId();
		String viewName=null;
		if(eventId.equals("cbcForm"))
		{
			viewName="cbcForm";
		}else if(eventId.equals("bgForm"))
		{
			viewName="bgForm";
		}else if(eventId.equals("crpForm"))
		{
			viewName="crpForm";
		}
		else if(eventId.equals("csForm"))
		{
			viewName="csForm";
		}
		else if(eventId.equals("elecForm"))
		{
			viewName="elecForm";
		}
		rc.getFlowScope().put("viewName", viewName);			
		return "success";
	}
	
	
}
