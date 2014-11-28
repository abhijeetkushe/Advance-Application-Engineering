package com.stable.sdk.service.lab;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.webflow.execution.RequestContext;
import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.encounter.Encounter;
import org.stable.sdk.model.measurement.Measurement;
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
import org.stable.sdk.model.order.Order;
import org.stable.sdk.model.patient.Patient;
import org.stable.sdk.model.test.CBC;
import org.stable.sdk.service.devices.DeviceService;
import org.stable.sdk.service.encounter.EncounterService;
import org.stable.sdk.service.patient.PatientService;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.me.pojo.Infant;
import com.me.pojo.LabTestDirectory;
import com.me.pojo.LabTests;
import com.me.pojo.RiskFactorDirectory;
import com.stable.sdk.riskmodel.RiskGenerate;
import com.webflow.util.CustomDateTool;
import com.webflow.util.LabModuleConstants;




public class DoctorService5 {

	private PatientService patientService;
	private DeviceService deviceService;
	private EncounterService encounterService;
	public static final String DATE_TIME_FORMAT="MM-dd-yyyy HH:mm";
	
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
		Patient selectedPatient=null;
		selectedPatient=patientService.searchForAPatientByID(55);
		RiskGenerate riskGen=new RiskGenerate();
		RiskFactorDirectory rfDir=riskGen.getRisk(selectedPatient);
		List infantList = new ArrayList();
		infantList.add(selectedPatient);
		context.getFlowScope().put("rfDir", rfDir);
		return selectedPatient;
	}
	
	public List<Infant> getInfantList(RequestContext context) {
		List<Infant> babyList = new ArrayList<Infant>(10);
		return babyList;
	}
	
	public Infant getSelectedInfo(RequestContext context) {
		Infant selectedInfant = null;
		return selectedInfant;
	}
	
	private Patient getPatient(String xml, Patient p) {
		ArrayList<Infant> infantList = null;
		return p;
	}
	
	public Patient getMedicalTestReport(RequestContext context) {
		Patient patient=patientService.searchForAPatientByID(62);
		for(int i=0;i<patient.getEncounters().size();i++){
			Collection<Order> colOrder=patient.getEncounters().get(i).getTreatment().getOrderList();

			Iterator<Order> iter=colOrder.iterator();
			while(iter.hasNext()){
				System.out.println(iter.next().getClass().getName());
			}
			patient.getEncounters().get(i).getTreatment().setOrderList(colOrder);
		}
		context.getFlowScope().put("dateTool", new CustomDateTool());
		context.getFlowScope().put("patient", patient);
		return patient;
	}

	
	public Patient enterMedicalTestAsEncounter(RequestContext context){
		
		String personId=context.getRequestParameters().get("patientId");
		String encounterDate=context.getRequestParameters().get("encounterDate");
		String cbcValue=context.getRequestParameters().get("CBC");
		String crpValue=context.getRequestParameters().get("CRP");
		String bgValue=context.getRequestParameters().get("BG");
		String csValue=context.getRequestParameters().get("CS");
		String elecValue=context.getRequestParameters().get("ELEC"); 
		String patientID=context.getRequestParameters().get("patientId");
		
		Patient patient=patientService.searchForAPatientByID(Integer.parseInt(patientID));
		List<Encounter> encounterList=null;
		Order enteredOrder=null;
		boolean testPresent=false;
		Encounter encounter=null;	
		try{
			encounterList=patient.getEncounters();
			for(int i=0;i<encounterList.size();i++){
				Encounter innerEnc=encounterList.get(i);
				if(innerEnc!=null && !innerEnc.getTreatment().getOrderList().isEmpty()){
							Collection<Order> orderColl=innerEnc.getTreatment().getOrderList();
					Iterator<Order> iterator=orderColl.iterator();
					while(iterator.hasNext()){
						Order order=iterator.next();
						if(order instanceof CBC && "true".equals(cbcValue) && ((CBC)order).getWbc_Measurement()==null){
							enteredOrder=order;
							testPresent=true;
							encounter=innerEnc;
						}
					}
				}
			}
			
		}
		catch(Exception e){
			
		}
	
		if("true".equals(cbcValue)){
			    CBC cbc=null;
			if(testPresent==true){
				cbc=(CBC)enteredOrder;
				cbc=(CBC)generateCBCTest(context,patient,cbc);
			}
			else{
				cbc=(CBC)generateCBCTest(context,patient,null);
				encounter=encounterService.createAssessmentForEncounter(Integer.parseInt(patientID), 1, cbc);
			}
			
			if(encounterDate!=null){
				Date date=CustomDateTool.parseDate(DATE_TIME_FORMAT, encounterDate);
				encounter.setEncounterDate(date.getTime());
				encounterList.add(encounter);
			}

			
		}
		context.getFlowScope().put("patient", patient);
		return patient;
		
	}
	
	
	public Order getSelectedMedicalTest(RequestContext context) {
		

		String patientID=context.getRequestParameters().get("patientId");
		String labTestName = context.getRequestParameters().get("name");
		String date = context.getRequestParameters().get("date");
		Patient patient=patientService.searchForAPatientByID(Integer.parseInt(patientID));
		
		CustomDateTool dateTool = new CustomDateTool();

		Date labTestDate = dateTool.parseDate(DATE_TIME_FORMAT, date);
		
		List<Encounter> encounterList=patient.getEncounters();
		
		Order enteredOrder=null;
		boolean testPresent=false;
		Encounter encounter=null;	

		for(int i=0;i<encounterList.size();i++){
			Encounter innerEnc=encounterList.get(i);
			if(innerEnc!=null && innerEnc.getEncounterDate()==labTestDate.getTime()){
						Collection<Order> orderColl=innerEnc.getTreatment().getOrderList();
				Iterator<Order> iterator=orderColl.iterator();
				while(iterator.hasNext()){
					Order order=iterator.next();
					if(order instanceof CBC && "CBC".equals(labTestName)){
						enteredOrder=order;
						testPresent=true;
						encounter=innerEnc;
					}
				}
			}
		}
		
		
		context.getFlowScope().put("patient", patient);
		context.getFlowScope().put("encounter", encounter);
		context.getFlowScope().put("selectedOrder", enteredOrder);
		context.getFlowScope().put("dateTool", new CustomDateTool());
		return enteredOrder;
	}
	
	
	public Boolean submitManroe(String isCBCpostive){
		if(isCBCpostive!=null && !"".equals(isCBCpostive)){
			Boolean cbcResult=new Boolean(isCBCpostive);
			return 	cbcResult;	
		}
		else return false;
	}

	
	
	private Order generateCBCTest(RequestContext context,Patient patient,CBC cbc){
		if(cbc==null){
			cbc=new CBC();
		}
		String wbcValue=context.getRequestParameters().get("WBC");
		if(wbcValue!=null){
			cbc.setWbc_Measurement((WBC_Measurement)getMeasurement("WBC", "TEST", wbcValue,patient));
		
			String hgbValue=context.getRequestParameters().get("Hgb");
			cbc.setHgb_Measurement((Hgb_Measurement)getMeasurement("Hgb", "TEST", hgbValue,patient));
		
			String neutrophils=context.getRequestParameters().get("NEUTROPHILS");
			cbc.setNeutrophils_Measurement((Neutrophils_Measurement)getMeasurement("NEUTROPHILS", "TEST", neutrophils,patient));
		
			String bandsValue=context.getRequestParameters().get("BANDS");
			cbc.setBands_Measurement(((Bands_Measurement)getMeasurement("BANDS", "TEST", bandsValue,patient)));
		
			String metaValue=context.getRequestParameters().get("METAMYELOCYTES");
			cbc.setMetamyelocytes_Measurement((Metamyelocytes_Measurement)getMeasurement("METAMYELOCYTES","TEST",metaValue,patient));
		
			String lymphsValue=context.getRequestParameters().get("LYMPHS");
			cbc.setLymphs_Measurement((Lymphs_Measurement)getMeasurement("LYMPHS","TEST",lymphsValue,patient));
		
			String eosValue=context.getRequestParameters().get("EOS");
			cbc.setEos_Measurement((Eos_Measurement)getMeasurement("EOS","TEST",eosValue,patient));
		
			String basosValue=context.getRequestParameters().get("BASOS");
			cbc.setBasos_Measurement((Basos_Measurement)getMeasurement("BASOS","TEST",basosValue,patient));
		
			String hctValue=context.getRequestParameters().get("Hct");
			cbc.setHct_Measurement((Hct_Measurement)getMeasurement("Hct","TEST",hctValue,patient));
		
			String pltsValue=context.getRequestParameters().get("PLTS");
			cbc.setPlts_Measurement((PLTS_Measurement)getMeasurement("PLTS", "TEST", pltsValue,patient));
		}	
		
			return cbc;
	}
	
	public LabTestDirectory enterMedicalTest(RequestContext context) {
		String medicalTextXml = context.getRequestParameters().get("xmlInput");
		Infant selectedInfant = null;
		selectedInfant = (Infant) context.getExternalContext().getSessionMap()
				.get("selectedBaby");
		LabTestDirectory labDir = null;
		// List<LabTests> labTestList=null;
		if (selectedInfant == null || selectedInfant.getLabDir() == null) {
			labDir = new LabTestDirectory();
			selectedInfant.setLabDir(labDir);
		}
		labDir = selectedInfant.getLabDir();
		labDir = getLabTests(medicalTextXml, labDir);
		selectedInfant.setLabDir(labDir);

		Patient patient = (Patient) context.getExternalContext()
				.getSessionMap().get("patient");

		
		context.getExternalContext().getSessionMap()
				.put("selectedBaby", selectedInfant);
		context.getFlowScope().put("selectedBaby", selectedInfant);
		context.getFlowScope().remove("medicalTests");
		context.getFlowScope().put("medicalTests", labDir);
		context.getExternalContext().getSessionMap().remove("medicalTests");
		context.getExternalContext().getSessionMap()
				.put("medicalTests", labDir);

		return labDir;
	}

	private LabTestDirectory getLabTests(String xml, LabTestDirectory labTestDir) {
		if (labTestDir == null) {
			labTestDir = new LabTestDirectory();
		}
		Reader reader = new StringReader(xml);
		InputSource source = new InputSource(reader);
		XPathFactory xpacFac = XPathFactory.newInstance();
		XPath xpac = xpacFac.newXPath();
		XPathExpression xPress = null;
		NodeList nodelist = null;
		try {
			xPress = xpac.compile("/person/testList/test");
			nodelist = (NodeList) xPress.evaluate(source,
					XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i = 0;

		LabTests labtest = new LabTests();
		while (i < nodelist.getLength()) {

			NodeList innnodeList = nodelist.item(i).getChildNodes();
			int j = 0;
			boolean newTest = false;
			while (j < innnodeList.getLength()) {

				String nodeName = innnodeList.item(j).getNodeName();
				String nodeValue = (innnodeList.item(j).getFirstChild()!=null)?
						innnodeList.item(j).getFirstChild().getNodeValue():null;

				Date date = null;
				Calendar cal = null;

				if (nodeName.equals("name")) {
					labtest = getMatchingLabTest(nodeValue, labTestDir);
					if (labtest == null) {
						labtest = new LabTests();
						labtest.setTestName(nodeValue);
						newTest = true;
					} else {
						labtest.setTestName(nodeValue);
					}
					System.out.println("Name: " + labtest.getTestName());

				} else if (nodeName.equals("date")) {
					date = CustomDateTool.parseDate(
							LabModuleConstants.DATE_FORMAT, nodeValue);
					labtest.setDate(date);
					System.out.println("Date: " + labtest.getDate());
					// labtest.setDate(date);

				} else if (nodeName.equals("hour")) {
					int hour = Integer.parseInt(nodeValue);
					cal = Calendar.getInstance();
					cal.setTime(labtest.getDate());
					cal.set(Calendar.HOUR_OF_DAY, hour);
					labtest.setDate(cal.getTime());

				} else if (nodeName.equals("min")) {
					int min = Integer.parseInt(nodeValue);
					cal = Calendar.getInstance();
					cal.setTime(labtest.getDate());
					cal.set(Calendar.MINUTE, min);
					labtest.setDate(cal.getTime());
				} else if (nodeName.equals("measurementList")) {
					Collection<Measurement> measurementCol = null;
					if (innnodeList.item(j).getChildNodes() != null
							&& innnodeList.item(j).getChildNodes().getLength() > 0) {
						measurementCol = getMeasurementList(innnodeList.item(j)
								.getChildNodes());
					}
					labtest.setMeasurementCollection(measurementCol);
				}
				j++;
			}
			// labtest.setStatus(true);
			if (newTest) {
				if ("CBC".equals(labtest.getTestName())) {
					labTestDir.getCbcTestList().add(labtest);
				} else if ("CRP".equals(labtest.getTestName())) {
					labTestDir.getCrpTestList().add(labtest);
				} else if ("ELEC".equals(labtest.getTestName())) {
					labTestDir.getElecTestList().add(labtest);
				} else if ("CS".equals(labtest.getTestName())) {
					labTestDir.getCsTestList().add(labtest);
				} else if ("BG".equals(labtest.getTestName())) {
					labTestDir.getBgTestList().add(labtest);
				}
			}
			i++;
		}
		return labTestDir;
	}

	private LabTests getMatchingLabTest(String testName,
			LabTestDirectory labTestDir) {
		LabTests matchingTest = null;
		List<LabTests> testList = null;
		if ("CBC".equals(testName)) {
			testList = labTestDir.getCbcTestList();
		} else if ("CRP".equals(testName)) {
			testList = labTestDir.getCrpTestList();
		} else if ("ELEC".equals(testName)) {
			testList = labTestDir.getElecTestList();
		} else if ("CS".equals(testName)) {
			testList = labTestDir.getCsTestList();
		} else if ("BG".equals(testName)) {
			testList = labTestDir.getBgTestList();
		}

		Iterator<LabTests> iterator = testList.iterator();
		while (iterator.hasNext()) {
			matchingTest = iterator.next();
			if (matchingTest != null
					&& matchingTest.getTestName().equals(testName)
					&& matchingTest.getDate() == null) {
				break;
			} else {
				matchingTest = null;
			}

		}
		return matchingTest;
	}

	private LabTests getSelectedLabTest(String testName, Date date,
			LabTestDirectory labTestDir) {
		LabTests matchingLabTest = null;
		;
		List<LabTests> testList = null;
		if ("CBC".equals(testName)) {
			testList = labTestDir.getCbcTestList();
		} else if ("CRP".equals(testName)) {
			testList = labTestDir.getCrpTestList();
		} else if ("ELEC".equals(testName)) {
			testList = labTestDir.getElecTestList();
		} else if ("CS".equals(testName)) {
			testList = labTestDir.getCsTestList();
		} else if ("BG".equals(testName)) {
			testList = labTestDir.getBgTestList();
		}
		for (LabTests test : testList) {
			if (testName.equals(test.getTestName())
					&& date.equals(test.getDate())) {

				matchingLabTest = test;
				break;
			}

		}
		return matchingLabTest;
	}

	private Collection<Measurement> getMeasurementList(
			NodeList measurementNodeList) {
		String deviceType = null;
		String methodType = null;
		String measurementValue = null;
		Collection<Measurement> measurementList = new ArrayList<Measurement>(10);

		// while (i < measurements.getLength()) {
		int i = 0;
		// NodeList innnodeList = measurements.item(i).getChildNodes();
		Measurement measurement = null;

		while (i < measurementNodeList.getLength()) {

			NodeList innnodeList = measurementNodeList.item(i).getChildNodes();
			int j = 0;
			while (j < innnodeList.getLength()) {
				String nodeName = innnodeList.item(j).getNodeName();
				String nodeValue = innnodeList.item(j).getFirstChild()
						.getNodeValue();
				if (nodeName.equals("deviceType") && nodeValue != null) {
					deviceType = nodeValue;
				} else if (nodeName.equals("methodType") && nodeValue != null) {
					methodType = nodeValue;
				} else if (nodeName.equals("measurementValue")
						&& nodeValue != null) {
					measurementValue = nodeValue;
				}
				j++;
			}
//			measurement = getMeasurement(deviceType, methodType,
//					measurementValue);
			measurementList.add(measurement);
			i++;
		}

		return measurementList;
	}

	private Measurement getMeasurement(String deviceType,
			String measurementMethod, String measureMentValue,Patient patient) {
		
		AbstractDevice device = deviceService.searchForDevice(1, DeviceType.valueOf(deviceType)).get(0);
		Measurement m = device.getMeasurement(measurementMethod, measureMentValue);	
		m.setPatient(patient);
		return m;
	}

}

