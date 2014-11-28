package org.stable.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.stable.sdk.model.patient.Patient;
import org.stable.sdk.service.patient.PatientService;

public class TestPatient extends AbstractController {

	private PatientService patientService;
	
	public TestPatient() {
		// TODO Auto-generated constructor stub
	}
	
	public PatientService getPatientService() {
		return patientService;
	}
	
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		patientService.createPatientProfile("Boston", "MR-NO11", "FirstName", "LastName", "M", "150", "160","50", "35-3", "3/3/2011", "12:30", "1", "resuscitationAtBirth", "resuscitationMeds", "otherMeds",1);
		return new ModelAndView("test");
	}

}
