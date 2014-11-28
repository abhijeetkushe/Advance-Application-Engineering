package org.stable.web.controller;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.service.clinic.ClinicService;
import org.stable.sdk.service.devices.DeviceService;

public class TestDeviceContoller extends AbstractController {

	private DeviceService deviceService;
	private ClinicService clinicService;
	
	
	public DeviceService getDeviceService() {
		return deviceService;
	}
	
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}
	
	public ClinicService getClinicService() {
		return clinicService;
	}
	
	public void setClinicService(ClinicService clinicService) {
		this.clinicService = clinicService;
	}
	
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		String whatToDo = request.getParameter("case");
		if(whatToDo.equalsIgnoreCase("ADD")){
		//	deviceService.saveDevice(DeviceType.WBC, "", clinic)
			for(DeviceType d:DeviceType.values()){
			clinicService.addDevice(1, d.toString()+new Random(new Date().getTime()).nextInt(), d);
			}
		}else if(whatToDo.equalsIgnoreCase("delete")){
			
		}
		
		
		return new ModelAndView("test");
	}

}
