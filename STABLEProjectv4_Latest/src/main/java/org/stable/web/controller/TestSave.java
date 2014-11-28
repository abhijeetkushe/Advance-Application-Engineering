package org.stable.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.stable.sdk.DAO.common.IDao;
import org.stable.sdk.model.clinic.CareTeam;
import org.stable.sdk.model.clinic.Clinic;
import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceFactory;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.patient.Patient;
import org.stable.sdk.model.patient.Person;
import org.stable.sdk.model.person.Employee;
import org.stable.sdk.model.person.UserAccount;
import org.stable.sdk.service.patient.PatientService;

public class TestSave extends AbstractController {

	private IDao<UserAccount, Integer> userAccountDao;
	private IDao<Clinic, Integer> clinicDao;
	private IDao<Patient, Integer> patientDao;
	private IDao<Employee, Integer> employeeDao;
	private IDao<CareTeam, Integer> careTeamDao;
	private IDao<Measurement, Long> measurementDao;
	private IDao<Person, Integer> personDao;
	private IDao<AbstractDevice, Integer> deviceDao;
	//private PatientService patientService;

//	public PatientService getPatientService() {
//		return patientService;
//	}
//
//	public void setPatientService(PatientService patientService) {
//		this.patientService = patientService;
//	}

	public IDao<Person, Integer> getPersonDao() {
		return personDao;
	}

	public IDao<AbstractDevice, Integer> getDeviceDao() {
		return deviceDao;
	}

	public void setDeviceDao(IDao<AbstractDevice, Integer> deviceDao) {
		this.deviceDao = deviceDao;
	}

	public void setPersonDao(IDao<Person, Integer> personDao) {
		this.personDao = personDao;
	}

	public IDao<UserAccount, Integer> getUserAccountDao() {
		return userAccountDao;
	}

	public void setUserAccountDao(IDao<UserAccount, Integer> userAccountDao) {
		this.userAccountDao = userAccountDao;
	}

	public IDao<Clinic, Integer> getClinicDao() {
		return clinicDao;
	}

	public void setClinicDao(IDao<Clinic, Integer> clinicDao) {
		this.clinicDao = clinicDao;
	}

	public IDao<Patient, Integer> getPatientDao() {
		return patientDao;
	}

	public void setPatientDao(IDao<Patient, Integer> patientDao) {
		this.patientDao = patientDao;
	}

	public IDao<Employee, Integer> getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(IDao<Employee, Integer> employeeDao) {
		this.employeeDao = employeeDao;
	}

	public IDao<CareTeam, Integer> getCareTeamDao() {
		return careTeamDao;
	}

	public void setCareTeamDao(IDao<CareTeam, Integer> careTeamDao) {
		this.careTeamDao = careTeamDao;
	}

	public IDao<Measurement, Long> getMeasurementDao() {
		return measurementDao;
	}

	public void setMeasurementDao(IDao<Measurement, Long> measurementDao) {
		this.measurementDao = measurementDao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {

		Person p = new Person();
		p.setFirstName("Donald");
		p.setLastName("Trump");

		Patient patient = new Patient();
		patient.setPerson(p);
		patient.setStatus(1);
		personDao.create(p);

		patient = patientDao.loadAll().get(0);

		Clinic clinic = clinicDao.read(1);

		System.out.println(clinic);
		System.out.println();

		deviceDao.create(DeviceFactory.createDevice(DeviceType.WBC, "abc",clinic));
		deviceDao.create(DeviceFactory.createDevice(DeviceType.BLOOD_GAS,"def", clinic));
		deviceDao.create(DeviceFactory.createDevice(DeviceType.FiO2, "ghi",	clinic));
		deviceDao.create(DeviceFactory.createDevice(DeviceType.FiO2, "ghi",clinic));

		System.out.println("dEVICE creation is ok");
		
		// Devicclinic.getDeviceInventoryList();
		AbstractDevice abstractDevice = deviceDao.read(1);
		Measurement measurement = abstractDevice.getMeasurement("MANUAL", "245");
		measurement.setDevice(abstractDevice);
		measurement.setPatient(patient);
		System.out.println(measurement.getMeasurementID());

		measurementDao.create(measurement);

		patient.setClinic(clinic);
		patient.getMeasurements().add(measurement);
		patientDao.create(patient);
		System.out.println("Patient is Created");

		System.out.println("CREATE PATIENT METHOD CALL");

		// patientService= new PatientService();

		/*patientService.createPatientProfile("Boston", "123", "Ashwin",
				"Dsousa", "Male", "173", "100", "1.2", "2", "03261984",
				"120089", "1", "abc", "def", "ghi");*/

		return new ModelAndView("test");
	}

}
