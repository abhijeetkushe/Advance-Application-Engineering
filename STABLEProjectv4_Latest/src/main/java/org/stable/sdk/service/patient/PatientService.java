package org.stable.sdk.service.patient;

import java.util.ArrayList;

import org.stable.sdk.DAO.common.IDao;
import org.stable.sdk.model.clinic.Clinic;
import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceFactory;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.sugar.gestationalage.GestationalAge_Measurement;
import org.stable.sdk.model.measurement.sugar.headcircumference.HeadCircumference_Measurement;
import org.stable.sdk.model.measurement.sugar.height.Height_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.weight.Weight_Measurement;
import org.stable.sdk.model.patient.BirthDetails;
import org.stable.sdk.model.patient.Patient;
import org.stable.sdk.model.patient.PatientStatus;
import org.stable.sdk.model.patient.Person;
import org.stable.sdk.service.devices.DeviceService;

public class PatientService implements IPatientService {

	private IDao<Patient, Integer> patientDao;
	private IDao<Clinic, Integer> clinicDao;
	private IDao<Person, Integer> personDao;
	
	private IDao<BirthDetails, Integer> birthDetailsDao;

	private DeviceService deviceService;
	
	
	public PatientService() {
		// TODO Auto-generated constructor stub
	}
	
	public DeviceService getDeviceService() {
		return deviceService;
	}
	
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}
	
	public IDao<BirthDetails, Integer> getBirthDetailsDao() {
		return birthDetailsDao;
	}

	public void setBirthDetailsDao(IDao<BirthDetails, Integer> birthDetailsDao) {
		this.birthDetailsDao = birthDetailsDao;
	}

	public IDao<Person, Integer> getPersonDao() {
		return personDao;
	}

	public void setPersonDao(IDao<Person, Integer> personDao) {
		this.personDao = personDao;
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
		System.out.println("The object is set... ");
		this.patientDao = patientDao;
	}

	public java.util.ArrayList<Patient> listAllPatients() {

		ArrayList<Patient> patientlist = patientDao.loadAll();
		System.out.println("Search Paitent is called" + patientlist);

		System.out.println(" Total No Patients ::" + patientlist.size());
		return patientlist;

	}
	
	public java.util.ArrayList<Patient> listAllPatients(int clinicID) {

		Clinic clinic = clinicDao.read(clinicID);
		ArrayList<Patient> patientlist = new ArrayList<Patient>(clinic.getPatientList());
		System.out.println("Search Paitent is called" + patientlist);

		System.out.println(" Total No Patients ::" + patientlist.size());
		return patientlist;

	}

	public Patient searchForAPatientByID(Integer patientID) {

		Patient patient = patientDao.read(patientID);
		System.out.println("Search Paitent is called");

		return patient;

	}

	public ArrayList<Patient> searchForPatientsByFirstName(String firstName) {

		ArrayList<Patient> tempListOfPatient = new ArrayList<Patient>();

		for (Patient p : patientDao.loadAll()) {
			Person tp = p.getPerson();
			if (tp.getFirstName().contains(firstName)) {
				tempListOfPatient.add(p);
			}
		}

		return tempListOfPatient;

	}

	public ArrayList<Patient> searchForPatientsByLastName(String lastName) {

		ArrayList<Patient> tempListOfPatient = new ArrayList<Patient>();

		for (Patient p : patientDao.loadAll()) {
			Person tp = p.getPerson();
			if (tp.getLastName().contains(lastName)) {
				tempListOfPatient.add(p);
			}
		}

		return tempListOfPatient;

	}

	

	public String createPatientProfile(String location, String medicalRecordNo,
			String firstName, String lastName, String gender, String height,
			String weight, String headCircumference, String gestationalAge,
			String birthDate, String birthTime, String birthOrder,
			String resuscitationAtBirth, String resuscitationMeds,
			String otherMeds,
			int clinicID) throws Exception {

		Clinic clinic = clinicDao.read(clinicID);
////////////PESON DETAILS //////////////////
		Person person = new Person();
		
		person.setFirstName(firstName);
		person.setLastName(lastName);
		
		//patientDao.create(patient);
	
		//personDao.create(person);
		
		///////////// PATIENT DETAILS
		Patient patient = new Patient();
		patient.setClinic(clinic);
		patient.setStatusEnum(PatientStatus.BORN);
		patient.setMedicalRecord(medicalRecordNo);
		patient.setLocation(location);
		patient.setPerson(person);
		
	
		patientDao.create(patient);
		//////////// BIRTH DETAILS DETAILS //////////////////
		BirthDetails birthDetails = new BirthDetails();
		birthDetails.setBirthOrder(Integer.parseInt(birthOrder));
		birthDetails.setResuscitationAtBirth(resuscitationAtBirth);
		birthDetails.setResuscitationMeds(resuscitationMeds);
		birthDetails.setOtherMeds(otherMeds);
		
		
		AbstractDevice abstractDevice1 = null;
		Measurement measurement1 = null;
		//AbstractDevice gestAgeAbstractDevice = DeviceFactory.createDevice(DeviceType.GESTATIONAL_AGE, "123", clinic);
		abstractDevice1 = deviceService.searchForDevice(clinicID, DeviceType.GESTATIONAL_AGE).get(0);
		measurement1  = abstractDevice1.getMeasurement("MANUAL", gestationalAge);
		measurement1.setPatient(patient);		
		birthDetails.setGestationalAge_Measurement( (GestationalAge_Measurement)measurement1 );

		AbstractDevice abstractDevice2 = null;
		Measurement measurement2 = null;
		//AbstractDevice headCircumferenceAbstractDevice = DeviceFactory.createDevice(DeviceType.HEAD_CIRCUMFRENCE, "456", clinic);
		abstractDevice2 = deviceService.searchForDevice(clinicID, DeviceType.HEAD_CIRCUMFRENCE).get(0);
		measurement2 =  abstractDevice2.getMeasurement("MANUAL", headCircumference);
		measurement2.setPatient(patient);
		birthDetails.setHeadCircumference_Measurement((HeadCircumference_Measurement)measurement2);

		AbstractDevice abstractDevice3 = null;
		Measurement measurement3 = null;
		//AbstractDevice heightAbstractDevice = DeviceFactory.createDevice(DeviceType.HEIGHT, "789", clinic);
		abstractDevice3 =  deviceService.searchForDevice(clinicID, DeviceType.HEIGHT).get(0);
		measurement3  = abstractDevice3.getMeasurement("MANUAL", height);
		measurement3.setPatient(patient);
		birthDetails.setHeight_Measurement((Height_Measurement) measurement3);
		
		AbstractDevice abstractDevice4 = null;
		Measurement measurement4 = null;
		abstractDevice4 =  deviceService.searchForDevice(clinicID, DeviceType.WEIGHT).get(0);
		measurement4  = abstractDevice4.getMeasurement("Digital", height);
		measurement4.setPatient(patient);
		birthDetails.setWeightMeasurement((Weight_Measurement) measurement4);
		person.setBirthDetails(birthDetails);
		birthDetails.setPersonId(person);
		birthDetailsDao.create(birthDetails);
		//////////////////////////////////////////////////////////////////////////////////////////
		//int personID = person.getPersonID();
		
		

		
		
		return "success";
	}

}
