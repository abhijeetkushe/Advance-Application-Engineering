package org.stable.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.stable.sdk.service.clinic.ClinicService;
import org.stable.sdk.service.devices.DeviceService;

public class TestMeasurementController extends AbstractController {

	private DeviceService deviceService;
	private ClinicService clinicService;
	
	public TestMeasurementController() {
		// TODO Auto-generated constructor stub
	}
	
	public DeviceService getDeviceService() {
		return deviceService;
	}
	
	public ClinicService getClinicService() {
		return clinicService;
	}
	
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}
	
	public void setClinicService(ClinicService clinicService) {
		this.clinicService = clinicService;
	}
	
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		return new ModelAndView("test");
	}

}
