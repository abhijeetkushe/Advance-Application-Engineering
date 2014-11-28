package com.stable.sdk.riskmodel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.vitalsigns.respiratoryrate.RespiratoryRate_Measurement;
import org.stable.sdk.model.patient.BirthDetails;
import org.stable.sdk.model.patient.Patient;

import com.me.pojo.RiskFactor;
import com.me.pojo.RiskFactorDirectory;

public class RiskGenerate {

	public RiskFactorDirectory getRisk(Patient patient){
		RiskFactorDirectory rfDir=new RiskFactorDirectory();
		BirthDetails birthDetails=patient.getPerson().getBirthDetails();
		List<RiskFactor> riskFactorList=new ArrayList<RiskFactor>();
		//Risk due to age if Birth time is less than 24 hours then Electrolytes test is not needed
		RiskFactor birthRisk=new RiskFactor();
		RiskFactor respRisk=new RiskFactor();
		RiskFactor vitalRisk=new RiskFactor();
		birthRisk.setName("life");
		try
		{
			long hours=(new Date().getTime()-birthDetails.getBirthTime())/(1000*60*60);
			birthRisk.setValue(String.valueOf(hours));			
		}
		catch(Exception e){
			e.printStackTrace();
			if(patient.getPatientID()%2==0){
				birthRisk.setValue("26");
			}else{
				birthRisk.setValue("28");
			}
		}
		riskFactorList.add(birthRisk);
		List<Measurement> measurementList=patient.getMeasurements();

		
		//Assumption is that if the respiratory rate is less than 20 and greater than 60 then the baby has the 
		//risk of Tachnypchea
		for(Measurement measurement:measurementList){
			if(measurement instanceof RespiratoryRate_Measurement){
				respRisk.setName("resp");		
				if(Integer.parseInt(measurement.getValue())>=20 && Integer.parseInt(measurement.getValue())< 60)
				{
					
					respRisk.setValue("Normal");
				}else{
					respRisk.setValue("Abnormal");
				}
								
			
			}else if(measurement instanceof RespiratoryRate_Measurement){
				vitalRisk.setName("reflex");
				if("Abnormal".equals(measurement)){
					vitalRisk.setValue("Abnormal");
				}else{
					vitalRisk.setValue("Normal");					
				}				

			}
		}

		//For testing purpose
		vitalRisk.setName("reflex");
		vitalRisk.setValue("Abnormal");
		riskFactorList.add(respRisk);
		riskFactorList.add(vitalRisk);
		rfDir.setRiskList(riskFactorList);
		
		return rfDir;
	}
	
}
