package org.stable.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.service.clinic.ClinicService;

public class TestObject extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		
		ClinicService clinicService = new ClinicService();
		//DeviceType deviceType[] = clinicService.getListOfDevices();
		//AbstractDevice abstractDevice	=	clinicService.addDevice(1, "A/324/234",  DeviceType.BASOS);
		
		
		
		return  new ModelAndView("test");
	}

}
