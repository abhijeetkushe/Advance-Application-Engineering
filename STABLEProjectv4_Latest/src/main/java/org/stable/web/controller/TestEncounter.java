package org.stable.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.stable.sdk.service.encounter.EncounterService;

public class TestEncounter extends AbstractController{
	private EncounterService encounterService;
	
	public TestEncounter() {
		// TODO Auto-generated constructor stub
	}
	
	public void setEncounterService(EncounterService encounterService) {
		this.encounterService = encounterService;
	}
	
	public EncounterService getEncounterService() {
		return encounterService;
	}
	
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		encounterService.createTreatmentForEncounter(48,1);
		
		return new ModelAndView("test");
	}

}
