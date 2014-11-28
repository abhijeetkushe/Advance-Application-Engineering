package org.stable.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.service.measurement.MeasurementService;

public class TestMeasurement extends AbstractController {

	private MeasurementService measurementService;
	
	
	public TestMeasurement() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setMeasurementService(MeasurementService measurementService) {
		this.measurementService = measurementService;
	}
	
	public MeasurementService getMeasurementService() {
		return measurementService;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String patientID = request.getParameter("patientID");
		String resp = request.getParameter("resp");
		int patientId=0;
		if(patientID!=null && !"".equals(patientID)){
			patientId=Integer.parseInt(patientID);
		}
		measurementService.createMeasurement(1,patientId, DeviceType.HCO3, "MANUAL", "23");
		measurementService.createMeasurement(1,patientId, DeviceType.PO2, "Arterial", "24");
		measurementService.createMeasurement(1,patientId, DeviceType.PCO2, "Arterial", "26");
		measurementService.createMeasurement(1,patientId, DeviceType.RESPIRATORY_RATE, "Observation", resp);
		return new ModelAndView("test");
	}

}
