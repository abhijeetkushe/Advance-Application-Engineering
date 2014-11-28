package org.stable.sdk.service.encounter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.stable.sdk.DAO.common.IDao;
import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.encounter.Encounter;
import org.stable.sdk.model.encounter.Treatment;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.wbc.WBC_Measurement;
import org.stable.sdk.model.order.Order;
import org.stable.sdk.model.patient.Patient;
import org.stable.sdk.model.test.BloodGas;
import org.stable.sdk.model.test.CBC;
import org.stable.sdk.model.test.CRP;
import org.stable.sdk.model.test.Clotting;
import org.stable.sdk.service.devices.DeviceService;
import org.stable.sdk.service.measurement.MeasurementService;
import org.stable.sdk.service.patient.PatientService;

public class EncounterService implements IEncounterService {
	
	private IDao<Encounter, Integer> encounterDao;
	private PatientService patientService;
	private DeviceService deviceService;
	private MeasurementService measurementService;
	
	public EncounterService() {
		// TODO Auto-generated constructor stub
	}
	
	public IDao<Encounter, Integer> getEncounterDao() {
		return encounterDao;
	}
	
	public void setEncounterDao(IDao<Encounter, Integer> encounterDao) {
		this.encounterDao = encounterDao;
	}
	
	public PatientService getPatientService() {
		return patientService;
	}
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	public DeviceService getDeviceService() {
		return deviceService;
	}
	
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}
	
	public MeasurementService getMeasurementService() {
		return measurementService;
	}
	
	public void setMeasurementService(MeasurementService measurementService) {
		this.measurementService = measurementService;
	}
	
	public Encounter createAssesmentForEncounter(int patientID){
		Encounter encounter = new Encounter();
		
		return encounter;
	}
	
	
	
	
	public Encounter createAssessmentForEncounter(int patientID,int clinicID,Order order){
		Patient patient = patientService.searchForAPatientByID(patientID);
		Encounter encounter = new Encounter();
		encounter.setPatient(patient);
		
		Treatment treatment = new Treatment();
		Collection<Order> orders = treatment.getOrderList();
		
		encounter.setTreatment(treatment);
		orders.add(order);
		encounterDao.create(encounter);
		return encounter;
	}
	
	
	
	
	public Encounter createTreatmentForEncounter(int patientID,int clinicID){
		Patient patient = patientService.searchForAPatientByID(patientID);
		Encounter encounter = new Encounter();
		encounter.setPatient(patient);
		
		Treatment treatment = new Treatment();
		Collection<Order> orders = treatment.getOrderList();
		
		AbstractDevice device = deviceService.searchForDevice(1, DeviceType.WBC).get(0);
		Measurement m = device.getMeasurement("MANUAL", "45");
		m.setPatient(patient);
		
		
		CBC cbc = new CBC();
		cbc.setWbc_Measurement((WBC_Measurement)m);
		cbc.setOrderedOn(new Date().getTime());
		
		
		encounter.setTreatment(treatment);
		orders.add(cbc);
		encounterDao.create(encounter);
		
		return encounter;
		
		/*
		  Encounter e = new Encounter();
        e.setPatient(ptemp);
        
        Assessment a = new Assessment();
        

        Order o = new Order();
        o.setOrderType(assessmentName);
        o.setOrderedOn((new Date()).getTime());
    
        List<Order> oList = new ArrayList<Order>();
        oList.add(o);
        a.setOrderList(oList);
        o.setAssessment(a);
        System.out.println("assessment"+a.getAssessmentID());
        e.setAssessment(a);
        // encounters.add(e);
        ptemp.getEncounters().add(e);
        encounterDao.create(e);
        // patientDao.update(ptemp);

		 */
	}
	
	

}
