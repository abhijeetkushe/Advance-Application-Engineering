package org.stable.web.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.stable.sdk.DAO.common.IDao;
import org.stable.sdk.model.bedlocation.BedLocation;
import org.stable.sdk.model.clinic.CareTeam;
import org.stable.sdk.model.clinic.Clinic;
import org.stable.sdk.model.encounter.Encounter;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.order.Order;
import org.stable.sdk.model.patient.Patient;
import org.stable.sdk.model.patient.PatientBedLocation;
import org.stable.sdk.model.person.Employee;
import org.stable.sdk.model.person.UserAccount;
import org.stable.sdk.model.test.CBC;

public class HomeController extends AbstractController {

	private IDao<UserAccount, Integer> 	userAccountDao;
	private IDao<Clinic, Integer> 		clinicDao;
	private IDao<Patient, Integer> 		patientDao;
	private IDao<Employee, Integer> 	employeeDao;
	private IDao<CareTeam, Integer> 	careTeamDao;
	private IDao<Measurement, Long> 	measurementDao;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int patientid =1;
		
		if(request.getParameter("patientid")!=null){
			try{				
				patientid = Integer.parseInt(request.getParameter("patientid"));
			}catch(NumberFormatException nfe){
				nfe.printStackTrace();
			}
		}

		System.out.println("***************Retriving All List********************");
		System.out.println("UserDao list size = "		+ userAccountDao.loadAll().size());
		System.out.println("ClincDao list size = " 		+ clinicDao.loadAll().size());
		System.out.println("PatientDao list size = "	+ patientDao.loadAll().size());
		System.out.println("EmployeeDao list size = "	+ employeeDao.loadAll().size());
		System.out.println("MeasurementDao list size = "+ measurementDao.loadAll().size());
		
		System.out.println("****************Patient Info*************************");
		System.out.println("Patient " + patientDao.read(patientid)+ " measurement list size = "+ patientDao.read(1).getMeasurements().size());
		
		
		for (Measurement m : patientDao.read(patientid).getMeasurements()) {
			System.out.println("Patient Measurement = " + m);
			System.out.println("Measurement Class Name = "+ m.getClass().getName());
		}
		
		
		System.out.println("****************Patient Bed Info*********************");
		System.out.println("PatientBedList size = "+ patientDao.read(patientid).getPatientBedList().size());
		
		for (PatientBedLocation pbl : patientDao.read(patientid).getPatientBedList()) {
			for (Employee e : pbl.getCareTakers()) {
				System.out.println("PatientBed CareTakers = " + e);
			}
			for (String s : pbl.getDeviceList().keySet()) {
				System.out.println("PatientBed Device = " + s);
			}
		}
		
		for (PatientBedLocation pbl : patientDao.read(patientid).getPatientBedList()) {
			System.out.println("PatientBed toString = " + pbl);
		}
		
		for(Encounter e:patientDao.read(patientid).getEncounters()){
			
				Collection<Order>orderlist=e.getAssessment().getOrderList();
				System.out.println("sIZE"+orderlist.size());
				for(Order o:orderlist){
					System.out.println("Orders Assessment "+o.getOrderid());
					CBC cbc=(CBC)o;
					System.out.println(cbc.getWbc_Measurement());
					//System.out.println("HGB"+cbc.getHgb_Measurement());
					
				}
				
			}
		
		
		System.out.println("ENCOUNTER "+patientDao.read(patientid).getEncounters().size());
		
		for(Encounter e:patientDao.read(patientid).getEncounters()){
			System.out.println("Encounters "+e.getEncounterID());
		}

		
		
		
		System.out.println("****************Clinic Info**************************");
		
		System.out.println("ClincDao list size = " 		+ clinicDao.read(patientid).getCareTeams().size());
		
		for (String ct : clinicDao.read(patientid).getCareTeams().keySet()) {
			System.out.println("Clinc care team keys = " + ct);
		}
		
		for (CareTeam ct : clinicDao.read(patientid).getCareTeams().values()) {
			System.out.println("Clinc care team values = " + ct);
		}
		
		for (String key : clinicDao.read(patientid).getBedLocations().keySet()) {
			System.out.println("Clinic Bed Locations Keys = " + key);
		}
		
		for (BedLocation bl : clinicDao.read(patientid).getBedLocations().values()) {
			System.out.println("Clinic Bed Locations values = " + bl);
		}
		
		for (Employee e : clinicDao.read(patientid).getEmployeeDirectory()) {
			System.out.println("Clinic Employees = " + e);
		}
		
		for (Patient p : clinicDao.read(patientid).getPatientList()) {
			System.out.println("Clinic Patients = " + p);			
		}
		
		for (String d : clinicDao.read(patientid).getDeviceInventoryList().keySet()) {
			System.out.println("Clinc device key = " + d);
		}
		
		for (UserAccount u : clinicDao.read(patientid).getUserAccountDirectory()) {
			System.out.println("Clinc useraccount emp name = " + u);
		}
		System.out.println("****************Employee Info*************************");
		for (String key : employeeDao.read(patientid).getCareTeams().keySet()) {
			System.out.println("Employee care teams key= " + key);
		}
		for (PatientBedLocation pbl : employeeDao.read(patientid).getCurrentPBLList()) {
			System.out.println("Employee current PBL list size= " + pbl);
		}
		System.out.println("Employee gender enum= "+ employeeDao.read(patientid).getGenderEnum());
		
		System.out.println("****************Care Team Info************************");
		for (CareTeam ct : careTeamDao.loadAll()) {
			for (String s : ct.getBedLocationList().keySet()) {
				System.out.println("CareTeam BedLoc key = " + s);
			}
			
			for (BedLocation bl : ct.getBedLocationList().values()) {
				System.out.println("CareTeam BedLoc value = " + bl);
			}
			
			for (PatientBedLocation pbl : ct.getPatientBedList()) {
				System.out.println("CareTeam PatientBedLoc = " + pbl);
			}
			
			for (Employee e : ct.getTeamMembers()) {
				System.out.println("CareTeam employee = " + e);
			}
		}
		System.out.println("****************End of Test***************************");
		return new ModelAndView("test");
	}

	/**
	 * @return the userAccountDao
	 */
	public IDao<UserAccount, Integer> getUserAccountDao() {
		return userAccountDao;
	}

	/**
	 * @param userAccountDao
	 *            the userAccountDao to set
	 */
	public void setUserAccountDao(IDao<UserAccount, Integer> userAccountDao) {
		this.userAccountDao = userAccountDao;
	}

	/**
	 * @return the clinicDao
	 */
	public IDao<Clinic, Integer> getClinicDao() {
		return clinicDao;
	}

	/**
	 * @param clinicDao
	 *            the clinicDao to set
	 */
	public void setClinicDao(IDao<Clinic, Integer> clinicDao) {
		this.clinicDao = clinicDao;
	}

	/**
	 * @return the patientDao
	 */
	public IDao<Patient, Integer> getPatientDao() {
		return patientDao;
	}

	/**
	 * @param patientDao
	 *            the patientDao to set
	 */
	public void setPatientDao(IDao<Patient, Integer> patientDao) {
		this.patientDao = patientDao;
	}

	/**
	 * @return the employeeDao
	 */
	public IDao<Employee, Integer> getEmployeeDao() {
		return employeeDao;
	}

	/**
	 * @param employeeDao
	 *            the employeeDao to set
	 */
	public void setEmployeeDao(IDao<Employee, Integer> employeeDao) {
		this.employeeDao = employeeDao;
	}

	/**
	 * @return the careTeamDao
	 */
	public IDao<CareTeam, Integer> getCareTeamDao() {
		return careTeamDao;
	}

	/**
	 * @param careTeamDao
	 *            the careTeamDao to set
	 */
	public void setCareTeamDao(IDao<CareTeam, Integer> careTeamDao) {
		this.careTeamDao = careTeamDao;
	}

	/**
	 * @return the measurementDao
	 */
	public IDao<Measurement, Long> getMeasurementDao() {
		return measurementDao;
	}

	/**
	 * @param measurementDao
	 *            the measurementDao to set
	 */
	public void setMeasurementDao(IDao<Measurement, Long> measurementDao) {
		this.measurementDao = measurementDao;
	}

}
