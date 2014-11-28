package com.stable.sdk.service.lab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.webflow.execution.RequestContext;
import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.encounter.Encounter;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.airway.baseexcess.BaseExcess_Measurement;
import org.stable.sdk.model.measurement.labwork.bloodgas.MetHb.MetHb_Measurement;
import org.stable.sdk.model.measurement.labwork.bloodgas.PO2.PO2_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.bands.Bands_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.basos.Basos_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.eos.Eos_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.hct.Hct_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.hgb.Hgb_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.lymphs.Lymphs_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.metamyelocytes.Metamyelocytes_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.neutrophils.Neutrophils_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.plts.PLTS_Measurement;
import org.stable.sdk.model.measurement.labwork.cbc.wbc.WBC_Measurement;
import org.stable.sdk.model.measurement.labwork.clotting.fibrinogen.Fibrinogen_Measurement;
import org.stable.sdk.model.measurement.labwork.clotting.pt.ProthrombinTime_Measurement;
import org.stable.sdk.model.measurement.labwork.clotting.ptt.PartialThromboplastinTime_Measurement;
import org.stable.sdk.model.measurement.labwork.crp.C_ReactiveProtein_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.CO2.CO2_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.Cl.Cl_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.K.K_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.Na.Na_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.ionizedcalcium.IonizedCalcium_Measurement;
import org.stable.sdk.model.measurement.labwork.electrolytes.totalcalcium.TotalCalcium_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.hco3.HCO3_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.pHlevel.pHLevel_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.pco2.PCO2_Measurement;
import org.stable.sdk.model.order.Order;
import org.stable.sdk.model.patient.Patient;
import org.stable.sdk.model.test.BloodGas;
import org.stable.sdk.model.test.CBC;
import org.stable.sdk.model.test.CRP;
import org.stable.sdk.model.test.Clotting;
import org.stable.sdk.model.test.Electrolytes;
import org.stable.sdk.service.devices.DeviceService;
import org.stable.sdk.service.encounter.EncounterService;
import org.stable.sdk.service.patient.PatientService;

import com.me.pojo.RiskFactorDirectory;
import com.stable.sdk.riskmodel.RiskGenerate;
import com.webflow.util.CustomDateTool;

public class DoctorService4 {

	private PatientService patientService;
	private DeviceService deviceService;
	private EncounterService encounterService;
	public static final String DATE_TIME_FORMAT = "MM-dd-yyyy HH:mm";

	public EncounterService getEncounterService() {
		return encounterService;
	}

	public void setEncounterService(EncounterService encounterService) {
		this.encounterService = encounterService;
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

	public Patient getInfantInfo(RequestContext context) {
		Patient selectedPatient = null;
		String patientID = (String) context.getConversationScope().get(
		"patientId");
		selectedPatient = patientService.searchForAPatientByID(Integer.parseInt(patientID));
		RiskGenerate riskGen = new RiskGenerate();
		RiskFactorDirectory rfDir = riskGen.getRisk(selectedPatient);
		List infantList = new ArrayList();
		infantList.add(selectedPatient);
		context.getFlowScope().put("rfDir", rfDir);
		return selectedPatient;
	}
	
	public List<Patient> searchForAPatientByID(RequestContext context){
		String patientId=context.getRequestParameters().get("patientID");
		Patient	selectedPatient = patientService.searchForAPatientByID(Integer.parseInt(patientId));
		List<Patient> patientList=new ArrayList<Patient>(10);
		selectedPatient.setPerson(selectedPatient.getPerson());
		selectedPatient.getPerson().getFirstName();
		selectedPatient.getPerson().getLastName();
		patientList.add(selectedPatient);
		context.getConversationScope().put("patientId", patientId);
		return patientList;
	}
	

	public void getUpdatedMeasurements(RequestContext context){
		String patientID = (String) context.getConversationScope().get(
		"patientId");
		String labTestName = (String)context.getFlowScope().get("viewName");
		Patient patient = patientService.searchForAPatientByID(Integer
				.parseInt(patientID));
		List<Measurement> allMeasurements=patient.getMeasurements();
		List<Measurement> staticMeasurements=new ArrayList<Measurement>();
		if("bgForm".equals(labTestName)){
			boolean hco3Present=false;
			boolean pco2Present=false;
			boolean po2Present=false;
			for(int i=0;i<allMeasurements.size();i++){
				Measurement measurment=allMeasurements.get(i);
				if(measurment instanceof HCO3_Measurement && !hco3Present){
					staticMeasurements.add(measurment);
					hco3Present=true;
				}else if(measurment instanceof PCO2_Measurement && !pco2Present){
					staticMeasurements.add(measurment);
					pco2Present=true;
				}else if(measurment instanceof PO2_Measurement && !po2Present){
					staticMeasurements.add(measurment);
					po2Present=true;
				}
				if(po2Present&& hco3Present&&pco2Present){
					break;
				}
			}
		}
		context.getFlowScope().put("staticMeasurements", staticMeasurements);
	}
	
	public Patient enterMedicalTestAsEncounter(RequestContext context) {

		String encounterDate = context.getRequestParameters().get(
				"encounterDate");
		String cbcValue = context.getRequestParameters().get("CBC");
		String crpValue = context.getRequestParameters().get("CRP");
		String bgValue = context.getRequestParameters().get("BG");
		String csValue = context.getRequestParameters().get("CS");
		String elecValue = context.getRequestParameters().get("ELEC");
		String patientID = (String) context.getConversationScope().get(
				"patientId");

		Patient patient = patientService.searchForAPatientByID(Integer
				.parseInt(patientID));
		List<Encounter> encounterList = null;
		Order cbcEnteredOrder = null;
		Order crpEnteredOrder = null;
		Order bgEnteredOrder = null;
		Order csEnteredOrder = null;
		Order eleEnteredOrder = null;
		boolean testPresent = false;
		Encounter encounter = null;

		try {

			encounterList = patient.getEncounters();
			for (int i = 0; i < encounterList.size(); i++) {
				Encounter innerEnc = encounterList.get(i);
				if (innerEnc != null
						&& !innerEnc.getTreatment().getOrderList().isEmpty()) {
					Collection<Order> orderColl = innerEnc.getTreatment()
							.getOrderList();
					Iterator<Order> iterator = orderColl.iterator();
					while (iterator.hasNext()) {
						Order order = iterator.next();
						if (order instanceof CBC && "true".equals(cbcValue)
								&& ((CBC) order).getWbc_Measurement() == null) {
							cbcEnteredOrder = order;
							testPresent = true;
							encounter = innerEnc;
						}
						if (order instanceof CRP
								&& "true".equals(crpValue)
								&& ((CRP) order)
										.getC_Reactive_Protein_measurement() == null) {
							crpEnteredOrder = order;
							testPresent = true;
							encounter = innerEnc;
						}
						if (order instanceof Electrolytes
								&& "true".equals(elecValue)
								&& ((Electrolytes) order).getCl_measurement() == null) {
							eleEnteredOrder = order;
							testPresent = true;
							encounter = innerEnc;
						}

						if (order instanceof Clotting && "true".equals(csValue)
								&& ((Clotting) order).getProthrombin_measurement() == null) {
							csEnteredOrder = order;
							testPresent = true;
							encounter = innerEnc;
						}
						if (order instanceof BloodGas && "true".equals(bgValue)
								&& ((BloodGas) order).getpHLevel_Measurement() == null) {
							bgEnteredOrder = order;
							testPresent = true;
							encounter = innerEnc;
						}
					}
				}
			}
		} catch (Exception e) {

		}

		if ("true".equals(cbcValue)) {
			CBC cbc = null;
			if (cbcEnteredOrder != null) {
				cbc = (CBC) cbcEnteredOrder;
				cbc = (CBC) generateCBCTest(context, patient, cbc);
			} else {
				cbc = (CBC) generateCBCTest(context, patient, null);
				encounter = encounterService.createAssessmentForEncounter(
						Integer.parseInt(patientID), 1, cbc);

			}

			if (encounterDate != null) {
				Date date = CustomDateTool.parseDate(DATE_TIME_FORMAT,
						encounterDate);
				encounter.setEncounterDate(date.getTime());
				encounterList.add(encounter);
			}

		}

		if ("true".equals(crpValue)) {
			CRP crp = null;
			if (crpEnteredOrder != null) {
				crp = (CRP) crpEnteredOrder;
				crp = (CRP) generateCRPTest(context, patient, crp);
			} else {
				crp = (CRP) generateCRPTest(context, patient, null);
				encounter = encounterService.createAssessmentForEncounter(
						Integer.parseInt(patientID), 1, crp);
			}
			if (encounterDate != null) {
				Date date = CustomDateTool.parseDate(DATE_TIME_FORMAT,
						encounterDate);
				encounter.setEncounterDate(date.getTime());
				encounterList.add(encounter);
			}

		}

		if ("true".equals(bgValue)) {
			BloodGas bgas = null;

			if (bgEnteredOrder != null) {
				bgas = (BloodGas) bgEnteredOrder;
				bgas = (BloodGas) generateBloodgasTest(context, patient, bgas);
			} else {
				bgas = (BloodGas) generateBloodgasTest(context, patient, null);
				encounter = encounterService.createAssessmentForEncounter(
						Integer.parseInt(patientID), 1, bgas);
			}
		}

		if ("true".equals(csValue)) {
			Clotting clot = null;
			if (csEnteredOrder != null) {
				clot = (Clotting) csEnteredOrder;
				clot = (Clotting) generateclottingTest(context, patient, clot);
			} else {
				clot = (Clotting) generateclottingTest(context, patient, null);
				encounter = encounterService.createAssessmentForEncounter(
						Integer.parseInt(patientID), 1, clot);
			}
		}

		if ("true".equals(elecValue)) {
			Electrolytes elec = null;
			if (testPresent == true) {
				elec = (Electrolytes) eleEnteredOrder;
				elec = (Electrolytes) generateElectrolyteTest(context, patient,
						elec);
			} else {
				elec = (Electrolytes) generateElectrolyteTest(context, patient,
						null);
				encounter = encounterService.createAssessmentForEncounter(
						Integer.parseInt(patientID), 1, elec);

			}
		}

		if (encounterDate != null) {
			Date date = CustomDateTool.parseDate(DATE_TIME_FORMAT,
					encounterDate);
			encounter.setEncounterDate(date.getTime());
			encounterList.add(encounter);
		}
		context.getFlowScope().put("patient", patient);
		return patient;
	}

	public Order getSelectedMedicalTest(RequestContext context) {

		String patientID = (String) context.getConversationScope().get(
				"patientId");
		String labTestName = context.getRequestParameters().get("name");
		String date = context.getRequestParameters().get("date");
		Patient patient = patientService.searchForAPatientByID(Integer
				.parseInt(patientID));
		Date labTestDate = CustomDateTool.parseDate(DATE_TIME_FORMAT, date);

		List<Encounter> encounterList = patient.getEncounters();

		Order enteredOrder = null;
		Encounter encounter = null;

		for (int i = 0; i < encounterList.size(); i++) {
			Encounter innerEnc = encounterList.get(i);
			if (innerEnc != null
					&& innerEnc.getEncounterDate() == labTestDate.getTime()) {
				Collection<Order> orderColl = innerEnc.getTreatment()
						.getOrderList();
				Iterator<Order> iterator = orderColl.iterator();
				while (iterator.hasNext()) {
					Order order = iterator.next();
					if (order instanceof CBC && "CBC".equals(labTestName)) {
						enteredOrder = order;
						encounter = innerEnc;
					} else if (order instanceof CRP
							&& "CRP".equals(labTestName)) {
						enteredOrder = order;
						encounter = innerEnc;
					} else if (order instanceof Clotting
							&& "CS".equals(labTestName)) {
						enteredOrder = order;
						encounter = innerEnc;
					} else if (order instanceof Electrolytes
							&& "ELEC".equals(labTestName)) {
						enteredOrder = order;
						encounter = innerEnc;
					} else if (order instanceof BloodGas
							&& "BG".equals(labTestName)) {
						enteredOrder = order;
						encounter = innerEnc;
					}
				}
			}
		}
		String viewName = (String)context.getFlowScope().get("viewName");		
		List<Measurement> allMeasurements=patient.getMeasurements();
		List<Measurement> staticMeasurements=new ArrayList<Measurement>();
		if("bgForm".equals(viewName)){
			boolean hco3Present=false;
			boolean pco2Present=false;
			boolean po2Present=false;
			for(int i=0;i<allMeasurements.size();i++){
				Measurement measurment=allMeasurements.get(i);
				if(measurment instanceof HCO3_Measurement && !hco3Present){
					staticMeasurements.add(measurment);
					hco3Present=true;
				}else if(measurment instanceof PCO2_Measurement && !pco2Present){
					staticMeasurements.add(measurment);
					pco2Present=true;
				}else if(measurment instanceof PO2_Measurement && !po2Present){
					staticMeasurements.add(measurment);
					po2Present=true;
				}
				if(po2Present&& hco3Present&&pco2Present){
					break;
				}
			}
		}
		context.getFlowScope().put("staticMeasurements", staticMeasurements);
		context.getFlowScope().put("patient", patient);
		context.getFlowScope().put("encounter", encounter);
		context.getFlowScope().put("selectedOrder", enteredOrder);
		context.getFlowScope().put("dateTool", new CustomDateTool());
		context.getFlowScope().put("classLoader",Class.class);
		return enteredOrder;
	}

	public Patient getMedicalTestReport(RequestContext context) {
		String patientID = (String) context.getConversationScope().get(
				"patientId");
		Patient patient = patientService.searchForAPatientByID(Integer
				.parseInt(patientID));
		for (int i = 0; i < patient.getEncounters().size(); i++) {
			Collection<Order> colOrder = patient.getEncounters().get(i)
					.getTreatment().getOrderList();

			Iterator<Order> iter = colOrder.iterator();
			while (iter.hasNext()) {
				System.out.println(iter.next().getClass().getName());
			}
			patient.getEncounters().get(i).getTreatment()
					.setOrderList(colOrder);
		}
		context.getFlowScope().put("dateTool", new CustomDateTool());
		context.getFlowScope().put("patient", patient);

		return patient;
	}

	private Order generateCBCTest(RequestContext context, Patient patient,
			CBC cbc) {
		if (cbc == null) {
			cbc = new CBC();
		}
		String wbcValue = context.getRequestParameters().get("WBC");
		if (wbcValue != null) {
			cbc.setWbc_Measurement((WBC_Measurement) getMeasurement("WBC",
					"TEST", wbcValue, patient));

			String hgbValue = context.getRequestParameters().get("Hgb");
			cbc.setHgb_Measurement((Hgb_Measurement) getMeasurement("Hgb",
					"TEST", hgbValue, patient));

			String neutrophils = context.getRequestParameters().get(
					"NEUTROPHILS");
			cbc.setNeutrophils_Measurement((Neutrophils_Measurement) getMeasurement(
					"NEUTROPHILS", "TEST", neutrophils, patient));

			String bandsValue = context.getRequestParameters().get("BANDS");
			cbc.setBands_Measurement(((Bands_Measurement) getMeasurement(
					"BANDS", "TEST", bandsValue, patient)));

			String metaValue = context.getRequestParameters().get(
					"METAMYELOCYTES");
			cbc.setMetamyelocytes_Measurement((Metamyelocytes_Measurement) getMeasurement(
					"METAMYELOCYTES", "TEST", metaValue, patient));

			String lymphsValue = context.getRequestParameters().get("LYMPHS");
			cbc.setLymphs_Measurement((Lymphs_Measurement) getMeasurement(
					"LYMPHS", "TEST", lymphsValue, patient));

			String eosValue = context.getRequestParameters().get("EOS");
			cbc.setEos_Measurement((Eos_Measurement) getMeasurement("EOS",
					"TEST", eosValue, patient));

			String basosValue = context.getRequestParameters().get("BASOS");
			cbc.setBasos_Measurement((Basos_Measurement) getMeasurement(
					"BASOS", "TEST", basosValue, patient));

			String hctValue = context.getRequestParameters().get("Hct");
			cbc.setHct_Measurement((Hct_Measurement) getMeasurement("Hct",
					"TEST", hctValue, patient));

			String pltsValue = context.getRequestParameters().get("PLTS");
			cbc.setPlts_Measurement((PLTS_Measurement) getMeasurement("PLTS",
					"TEST", pltsValue, patient));
		}

		return cbc;
	}

	private Order generateCRPTest(RequestContext context, Patient patient,
			CRP crp) {

		if (crp == null) {
			crp = new CRP();
		}
		String crpValue = context.getRequestParameters().get(
				"C_Reactive_Protein");
		if (crpValue != null) {
			crp.setC_Reactive_Protein_measurement((C_ReactiveProtein_Measurement) getMeasurement(
					"C_Reactive_Protein", "TEST", crpValue, patient));
		}
		return crp;
	}

	private Order generateElectrolyteTest(RequestContext context,
			Patient patient, Electrolytes el) {

		if (el == null) {
			el = new Electrolytes();
		}

		String clValue = context.getRequestParameters().get("Cl");
		if (clValue != null) {
			el.setCl_measurement((Cl_Measurement) getMeasurement("Cl", "TEST",
					clValue, patient));

			String c02Value = context.getRequestParameters().get("CO2");
			el.setCo2_measurement((CO2_Measurement) getMeasurement("CO2",
					"TEST", c02Value, patient));

			String naValue = context.getRequestParameters().get("Na");
			el.setNa_measurement((Na_Measurement) getMeasurement("Na", "TEST",
					naValue, patient));

			String kValue = context.getRequestParameters().get("K");
			el.setK_measurement((K_Measurement) getMeasurement("K", "TEST",
					kValue, patient));

			String ioncValue = context.getRequestParameters().get(
					"Ionized_Calcium");
			el.setIonizedcalcium_measurement((IonizedCalcium_Measurement) getMeasurement(
					"Ionized_Calcium", "TEST", ioncValue, patient));

			String totcValue = context.getRequestParameters().get(
					"Total_Calcium");
			el.setTotalcalcium_measurement((TotalCalcium_Measurement) getMeasurement(
					"Total_Calcium", "TEST", totcValue, patient));

		}

		return el;
	}

	private Order generateBloodgasTest(RequestContext context, Patient patient,
			BloodGas bgas) {
		if (bgas == null) {
			bgas = new BloodGas();
		}
		
		String methodType=context.getRequestParameters().get("methodType");
		if(methodType!=null){
			
			String pH_LEVEL=context.getRequestParameters().get("PH_LEVEL");
			bgas.setpHLevel_Measurement((pHLevel_Measurement)getMeasurement("PH_LEVEL",methodType, pH_LEVEL, patient));
			
			String pCO2=context.getRequestParameters().get("PCO2");
			bgas.setPco2_Measurement((PCO2_Measurement)getMeasurement("PCO2",methodType, pCO2, patient));
			
			String pO2=context.getRequestParameters().get("PO2");
			bgas.setPo2_measurment((PO2_Measurement)getMeasurement("PO2",methodType, pO2, patient));
			
			String hCO3 = context.getRequestParameters().get("HCO3");
			bgas.setHco3_Measurement((HCO3_Measurement) getMeasurement("HCO3",methodType, hCO3, patient));
			
			String bASE = context.getRequestParameters().get("BASE_EXCESS");
			bgas.setBaseExcess_Measurement((BaseExcess_Measurement) getMeasurement("BASE_EXCESS",methodType, bASE, patient));
			
			String methbValue = context.getRequestParameters().get("MetHb");
			bgas.setMetHb_Measurement((MetHb_Measurement) getMeasurement("MetHb",methodType, methbValue, patient));
		}	
		return bgas;
	}

	public void submitManroe(RequestContext context){
		String isCBCpostive =context.getRequestParameters().get("isCBCpostive");
		String cbcResult=null;
		if(isCBCpostive!=null && !"".equals(isCBCpostive)){
			Boolean cbc=new Boolean(isCBCpostive);
			if(cbc==false){
				cbcResult="cbcNegative";	
			}
			else{
				cbcResult="cbcPositive";
			}
		}
		context.getConversationScope().put("cbcResult", cbcResult);
	
	}
	
	private Order generateclottingTest(RequestContext context, Patient patient,
			Clotting clot) {
		if (clot == null) {
			clot = new Clotting();
		}

		String Fibrinogenvalue = context.getRequestParameters().get(
				"Fibrinogen");
		if(Fibrinogenvalue!=null){
			clot.setFibrinogen_measurement((Fibrinogen_Measurement) getMeasurement(
				"Fibrinogen", "TEST", Fibrinogenvalue, patient));

			String ProthrombinTimevalue = context.getRequestParameters().get(
				"Prothrombin_Time");
			clot.setProthrombin_measurement((ProthrombinTime_Measurement) getMeasurement(
				"Prothrombin_Time", "TEST", ProthrombinTimevalue, patient));

			String PartialThromboplastinTimevalue = context.getRequestParameters()
				.get("Partial_Thromboplastin_Time");
			clot.setThromboplastin_measurement((PartialThromboplastinTime_Measurement) getMeasurement(
				"Partial_Thromboplastin_Time", "TEST",
				PartialThromboplastinTimevalue, patient));
		}	
		return clot;
	}

	private Measurement getMeasurement(String deviceType,
			String measurementMethod, String measureMentValue, Patient patient) {

		AbstractDevice device = deviceService.searchForDevice(1,
				DeviceType.valueOf(deviceType)).get(0);
		Measurement m = device.getMeasurement(measurementMethod,
				measureMentValue);
		m.setPatient(patient);
		return m;
	}
	
	public String addPatientId(String patientId){
		
		return patientId;
	}

}