package com.service;

import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.webflow.context.servlet.ServletExternalContext;
import org.springframework.webflow.execution.RequestContext;
import org.stable.sdk.model.clinic.Clinic;
import org.stable.sdk.model.device.AbstractDevice;
import org.stable.sdk.model.device.DeviceFactory;
import org.stable.sdk.model.device.DeviceType;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.service.patient.PatientService;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.me.pojo.BabyProfilePojo;
import com.me.pojo.Infant;
import com.me.pojo.LabTestDirectory;
import com.me.pojo.LabTests;
import com.me.pojo.Patient;
import com.me.pojo.RiskFactor;
import com.me.pojo.RiskFactorDirectory;
import com.webflow.util.LabModuleConstants;
import com.webflow.util.CustomDateTool;

public class DoctorService3 implements Serializable {

	private long infantCount;
	private HttpServletRequest request;
	private PatientService patientService;

	public PatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	public HttpServletRequest getRequest(RequestContext context) {
		ServletExternalContext externalContext = (ServletExternalContext) context
				.getExternalContext();
		HttpServletRequest req = (HttpServletRequest) externalContext
				.getNativeRequest();
		return req;
	}

	public ArrayList listAppointment(RequestContext context) {
		ArrayList aplist = new ArrayList();
		System.out.print("**list**");
		return aplist;
	}

	public String getEncounter(RequestContext context) {
		this.request = this.getRequest(context);
		return "encounter";
	}

	public ArrayList listAppointment() {
		ArrayList aplist = new ArrayList();

		return aplist;
	}

	public ArrayList getBabyResults(RequestContext context) {
		ArrayList babyResults = new ArrayList();
		return babyResults;
	}

	public ArrayList getANCList(RequestContext context) {
		ArrayList ancList = new ArrayList();
		return ancList;
	}

	public ArrayList getTestBabyResults(RequestContext context) {
		ArrayList testBabyResults = new ArrayList();
		return testBabyResults;
	}



	public List getBabies(String patientID) {
		List babiesList = new ArrayList(4);
		BabyProfilePojo babyProfile = new BabyProfilePojo();
		babyProfile.setDependentID("AAE2341-1");
		babyProfile.setPatientID("AAE2341");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2012);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DATE, 25);
		cal.set(Calendar.HOUR_OF_DAY, 13);
		cal.set(Calendar.MINUTE, 5);
		babyProfile.setDateOfBirth(cal.getTime());
		babyProfile.setDeliveryMode("Caesarean");
		babyProfile.setWeightAtBirth("12lbs");
		babyProfile.setGender("Male");
		babiesList.add(babyProfile);
		return babiesList;
	}
	public List<Infant> getInfantList(RequestContext context) {
		List<Infant> babyList = new ArrayList<Infant>(10);
		Patient patient = (Patient) context.getExternalContext()
				.getSessionMap().get("patient");
		if (patient != null) {
			babyList = patient.getInfantList();
		}
		context.getFlowScope().put("patient", patient);
		return babyList;
	}

	public Infant getSelectedInfo(RequestContext context) {
		Infant selectedInfant = null;
		String babyID = context.getRequestParameters().get("babyID");
		Patient patient = (Patient) context.getFlowScope().get("patient");
		List<Infant> infantList = patient.getInfantList();
		if (infantList != null) {
			for (Infant infant : infantList) {
				if (infant != null && infant.getPatientId().equals(babyID)) {
					selectedInfant = infant;
					break;
				}
			}
		}
		context.getFlowScope().put("selectedBaby", selectedInfant);
		context.getExternalContext().getSessionMap()
				.put("selectedBaby", selectedInfant);
		return selectedInfant;
	}

	public Infant getInfantInfo(RequestContext context) {
		Infant selectedInfant = null;
		selectedInfant = (Infant) context.getExternalContext().getSessionMap()
				.get("selectedBaby");
		List infantList = new ArrayList();
		infantList.add(selectedInfant);
		context.getFlowScope().put("infantList", infantList);
		context.getFlowScope().put("riskList",selectedInfant.getRfDir().getRiskList());
		return selectedInfant;
	}

	private Patient getPatient(String xml, Patient p) {

		ArrayList<Infant> infantList = null;
		if (p != null) {
			infantList = p.getInfantList();
		} else {
			p = new Patient();
			infantList = new ArrayList<Infant>(3);
		}
		Reader reader = new StringReader(xml);
		InputSource source = new InputSource(reader);
		XPathFactory xpacFac = XPathFactory.newInstance();
		XPath xpac = xpacFac.newXPath();
		XPathExpression xPress = null;
		NodeList nodelist = null;
		Node fullName = null;
		try {
			xPress = xpac.compile("/persons/person/patient/fullName");
			fullName = (Node) xPress.evaluate(source, XPathConstants.NODE);
			p.setFullName(fullName.getNodeValue());
			xPress = xpac.compile("/persons/person/patient/infants/infant");
			reader = new StringReader(xml);
			source = new InputSource(reader);
			nodelist = (NodeList) xPress.evaluate(source,
					XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i = 0;

		while (i < nodelist.getLength()) {
			Infant infant = new Infant();
			infant.setPatientId("AFF" + infantCount++);
			infant.setFullName(p.getFullName());
			NodeList innnodeList = nodelist.item(i).getChildNodes();
			int j = 0;
			while (j < innnodeList.getLength()) {
				String nodeName = innnodeList.item(j).getNodeName();
				String nodeValue = (innnodeList.item(j).getFirstChild()!=null)?
									innnodeList.item(j).getFirstChild().getNodeValue():null;

				if (nodeName.equals("dateOfBirth")) {
					infant.setDateOfBirth(nodeValue);

				}

				else if (nodeName.equals("timeAtBirth")) {

					infant.setTimeAtBirth(nodeValue);

				} else if (nodeName.equals("gender")) {

					infant.setGender(nodeValue);

				} else if (nodeName.equals("deliveryMode")) {

					infant.setDeliveryMode(nodeValue);

				} else if (nodeName.equals("weight")) {

					infant.setWeightAtBirth(nodeValue);

				} else if (nodeName.equals("height")) {

					infant.setHeight(nodeValue);
				} else if (nodeName.equals("bloodGroup")) {
					infant.setBloodGroup(nodeValue);
				}

				j++;
			}
			infantList.add(infant);
			i++;
		}
		p.setInfantList(infantList);

		return p;

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

		List<Infant> infantList = patient.getInfantList();
		if (infantList != null) {
			for (Infant infant : infantList) {
				if (infant != null
						&& infant.getPatientId().equals(
								selectedInfant.getPatientId())) {
					infant.setLabDir(selectedInfant.getLabDir());
					break;
				}
			}
		}
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

	public LabTestDirectory getMedicalTestReport(RequestContext context) {
		Infant selectedInfant = null;
		selectedInfant = (Infant) context.getExternalContext().getSessionMap()
				.get("selectedBaby");
		LabTestDirectory labDir = null;
		if (selectedInfant != null && selectedInfant.getLabDir() != null) {
			labDir = selectedInfant.getLabDir();
		} else {
			selectedInfant=new Infant();
			labDir = new LabTestDirectory();
			List<LabTests> cbcTestList=new ArrayList<LabTests>();
			LabTests test=new LabTests();
			test.setTestName("CBC");
			test.setDate(new Date());
			Collection<Measurement> measurementCollection=new ArrayList<Measurement>();
			measurementCollection.add(getMeasurement("WBC","TEST","15000"));
			measurementCollection.add(getMeasurement("Hgb","TEST","150"));
			measurementCollection.add(getMeasurement("NEUTROPHILS","TEST","15"));
			measurementCollection.add(getMeasurement("BANDS","TEST","15"));
			measurementCollection.add(getMeasurement("METAMYELOCYTES","TEST","15"));
			measurementCollection.add(getMeasurement("LYMPHS","TEST","15"));
			measurementCollection.add(getMeasurement("EOS","TEST","15"));
			measurementCollection.add(getMeasurement("BASOS","TEST","25"));
			measurementCollection.add(getMeasurement("Hct","TEST","234"));
			measurementCollection.add(getMeasurement("PLTS","TEST","245"));
			test.setMeasurementCollection(measurementCollection);
			cbcTestList.add(test);
			
			test=new LabTests();
			test.setTestName("CRP");
			test.setDate(new Date());
			cbcTestList.add(test);
			
			test=new LabTests();
			test.setTestName("CS");
			test.setDate(new Date());
			cbcTestList.add(test);
			
			test=new LabTests();
			test.setTestName("BG");
			test.setDate(new Date());
			cbcTestList.add(test);
			
			test=new LabTests();
			test.setTestName("ELEC");
			test.setDate(new Date());
			cbcTestList.add(test);
			labDir.setCbcTestList(cbcTestList);
			selectedInfant.setLabDir(labDir);
		}
		context.getFlowScope().put("selectedBaby", selectedInfant);
		context.getFlowScope().put("medicalTests", new ArrayList<LabTests>());
		context.getFlowScope().put("dateTool", new CustomDateTool());
		context.getExternalContext().getSessionMap()
		.put("selectedBaby", selectedInfant);
		return labDir;
	}

	public LabTestDirectory getSelectedMedicalTest(RequestContext context) {
		Infant selectedInfant = null;
		Date labTestDate = null;
		String labTestName = null;
		LabTests selectedLabTest = null;
		selectedInfant = (Infant) context.getExternalContext().getSessionMap()
				.get("selectedBaby");
		labTestName = context.getRequestParameters().get("name");
		String date = context.getRequestParameters().get("date");

		CustomDateTool dateTool = new CustomDateTool();

		labTestDate = dateTool.parseDate("MM-dd-yyyy HH:mm", date);

		LabTestDirectory labDir = null;

		if (selectedInfant != null && selectedInfant.getLabDir() != null) {
			labDir = selectedInfant.getLabDir();
		} else {
			labDir = new LabTestDirectory();
		}

		selectedLabTest = getSelectedLabTest(labTestName, labTestDate, labDir);
		System.out.println("selectedLabTest"+selectedLabTest);
		List<LabTests> medicalTests = new ArrayList<LabTests>(10);
		medicalTests.add(selectedLabTest);
		context.getFlowScope().put("selectedBaby", selectedInfant);
		context.getFlowScope().put("medicalTests", medicalTests);
		context.getFlowScope().put("dateTool", new CustomDateTool());
		return labDir;
	}

	public LabTestDirectory getMedicalTest(RequestContext context) {
		String medicalTextXml = context.getRequestParameters().get("xmlInput");
		Infant selectedInfant = null;
		selectedInfant = (Infant) context.getExternalContext().getSessionMap()
				.get("selectedBaby");
		LabTestDirectory labDir = selectedInfant.getLabDir();
		context.getFlowScope().put("selectedBaby", selectedInfant);
		context.getFlowScope().put("medicalTests", labDir);
		context.getFlowScope().put("dateTool", new CustomDateTool());
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
			measurement = getMeasurement(deviceType, methodType,
					measurementValue);
			measurementList.add(measurement);
			i++;
		}

		return measurementList;
	}

	private Measurement getMeasurement(String deviceType,
			String measurementMethod, String measureMentValue) {
		AbstractDevice device = DeviceFactory.createDevice(
				DeviceType.valueOf(deviceType).getId(), "0",  new Clinic());
		return device.getMeasurement(measurementMethod, measureMentValue);
	}

	public String addBabies(RequestContext context) {
		String returnVal = null;
		ServletExternalContext externalContext = (ServletExternalContext) context
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext
				.getNativeRequest();
		String xml = request.getParameter("xmlInput");

		Patient p = (Patient) context.getExternalContext().getSessionMap()
				.get("patient");
		p = getPatient(xml, p, context);
		context.getFlowScope().put("patient", p);
		context.getExternalContext().getSessionMap().put("patient", p);
		return returnVal;
	}

	public String addRisks(RequestContext context) {
		String returnVal = null;
		ServletExternalContext externalContext = (ServletExternalContext) context
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext
				.getNativeRequest();
		String xml = request.getParameter("xmlInput");

		Patient p = (Patient) context.getExternalContext().getSessionMap()
				.get("patient");
		p = getRisks(xml, p, context);
		context.getFlowScope().put("patient", p);
		context.getExternalContext().getSessionMap().put("patient", p);

		context.getFlowScope().put("riskList",
				p.getInfantList().get(0).getRfDir().getRiskList());
		return returnVal;
	}

	private Patient getPatient(String xml, Patient p, RequestContext context) {

		ArrayList<Infant> infantList = null;
		if (p != null) {
			infantList = p.getInfantList();
		} else {
			p = new Patient();
			infantList = new ArrayList<Infant>(3);
		}
		Reader reader = new StringReader(xml);
		InputSource source = new InputSource(reader);
		XPathFactory xpacFac = XPathFactory.newInstance();
		XPath xpac = xpacFac.newXPath();
		XPathExpression xPress = null;
		NodeList nodelist = null;
		Node fullName = null;
		try {
			xPress = xpac.compile("/persons/person/patient/fullName");
			fullName = (Node) xPress.evaluate(source, XPathConstants.NODE);
			p.setFullName(fullName.getNodeValue());
			xPress = xpac.compile("/persons/person/patient/infants/infant");
			reader = new StringReader(xml);
			source = new InputSource(reader);
			nodelist = (NodeList) xPress.evaluate(source,
					XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i = 0;

		while (i < nodelist.getLength()) {
			Infant infant = new Infant();
			infant.setPatientId("AFF" + infantCount++);
			infant.setFullName(p.getFullName());
			NodeList innnodeList = nodelist.item(i).getChildNodes();
			int j = 0;
			while (j < innnodeList.getLength()) {
				String nodeName = innnodeList.item(j).getNodeName();

				String nodeValue = innnodeList.item(j).getFirstChild()
						.getNodeValue();

				if (nodeName.equals("dateOfBirth")) {
					infant.setDateOfBirth(nodeValue);
				}
				else if (nodeName.equals("timeAtBirth")) {

					infant.setTimeAtBirth(nodeValue);

				} else if (nodeName.equals("gender")) {

					infant.setGender(nodeValue);

				} else if (nodeName.equals("deliveryMode")) {

					infant.setDeliveryMode(nodeValue);

				} else if (nodeName.equals("weight")) {

					infant.setWeightAtBirth(nodeValue);

				} else if (nodeName.equals("height")) {

					infant.setHeight(nodeValue);
				} else if (nodeName.equals("bloodGroup")) {
					infant.setBloodGroup(nodeValue);
				}

				j++;
			}
			infantList.add(infant);
			context.getExternalContext().getSessionMap().put("infant", infant);
			i++;
		}
		p.setInfantList(infantList);

		return p;

	}

	private List<RiskFactor> getRiskList(NodeList nList) {
		int i = 0;
		List<RiskFactor> rList = new ArrayList<RiskFactor>();

		RiskFactor rFactor = new RiskFactor();
		NodeList nodeList = null;

		while (i < nList.getLength()) {
			nodeList = nList.item(i).getChildNodes();
			int j = 0;
			rFactor = new RiskFactor();
			while (j < nodeList.getLength()) {
				String nodeName = nodeList.item(j).getNodeName();
				String nodeValue = (nodeList.item(j).getFirstChild()!=null)?
						nodeList.item(j).getFirstChild().getNodeValue():null;
				if (nodeName.equals("name")) {
					rFactor.setName(nodeValue);
				} else if (nodeName.equals("value")) {
					rFactor.setValue(nodeValue);
					// System.out.println("Value NodeValue: "+nodeValue);
				}

				j++;
			}
			// System.out.println("Value NodeValue: "+rFactor.getName());
			rList.add(rFactor);

			i++;
		}
		for (RiskFactor r : rList) {
			System.out.println("Risk Factor Name: " + r.getName());
		}

		return rList;
	}

	private Patient getRisks(String xml, Patient p, RequestContext context) {

		ArrayList<Infant> infantList = null;

		infantList = p.getInfantList();

		Reader reader = new StringReader(xml);
		InputSource source = new InputSource(reader);
		XPathFactory xpacFac = XPathFactory.newInstance();
		XPath xpac = xpacFac.newXPath();
		XPathExpression xPress = null;
		NodeList nodelist = null;

		try {

			xPress = xpac.compile("/persons/person/patient/infants/infant");
			reader = new StringReader(xml);
			source = new InputSource(reader);
			nodelist = (NodeList) xPress.evaluate(source,
					XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i = 0;

		while (i < nodelist.getLength()) {
			Infant infant = (Infant) context.getExternalContext()
					.getSessionMap().get("infant");
			List<RiskFactor> rFactor = null;
			RiskFactorDirectory rfDir = new RiskFactorDirectory();

			NodeList innnodeList = nodelist.item(i).getChildNodes();
			int j = 0;
			while (j < innnodeList.getLength()) {
				String nodeName = innnodeList.item(j).getNodeName();

				String nodeValue = (innnodeList.item(j).getFirstChild()!=null)?
							innnodeList.item(j).getFirstChild().getNodeValue():null;

				if (nodeName.equals("riskFactors")) {

					// System.out.println("Before Size: "+innnodeList.item(j).getChildNodes().getLength());
					rFactor = getRiskList(innnodeList.item(j).getChildNodes());

					// System.out.println("After Size: "+rFactor.size());
					System.out.println(rFactor.get(0).getName());
					System.out.println(rFactor.get(1).getName());
					System.out.println(rFactor.get(2).getName());
					rfDir.setRiskList(rFactor);
					infant.setRfDir(rfDir);
					// infant.setDateOfBirth(nodeValue);

				}

				j++;

				infantList.remove(infantList.size() - 1);
				infantList.add(infant);
				i++;

			}
		}
		p.setInfantList(infantList);

		return p;

	
	}
	
	public Boolean submitManroe(String isCBCpostive){
		if(isCBCpostive!=null && !"".equals(isCBCpostive)){
			Boolean cbcResult=new Boolean(isCBCpostive);
			return 	cbcResult;	
		}
		else return false;
	}

}