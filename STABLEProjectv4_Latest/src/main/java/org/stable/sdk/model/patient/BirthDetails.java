/**
 * 
 */
package org.stable.sdk.model.patient;

import org.stable.sdk.model.common.IStableModel;
import org.stable.sdk.model.measurement.Measurement;
import org.stable.sdk.model.measurement.sugar.gestationalage.GestationalAge_Measurement;
import org.stable.sdk.model.measurement.sugar.headcircumference.HeadCircumference_Measurement;
import org.stable.sdk.model.measurement.sugar.height.Height_Measurement;
import org.stable.sdk.model.measurement.vitalsigns.weight.Weight_Measurement;

/**
 * @author amuthanarulraj
 * 
 */
public class BirthDetails implements IStableModel {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;
	private int birthdetailsId;
	private String location;
	private GestationalAge_Measurement gestationalAge_Measurement;
	private HeadCircumference_Measurement headCircumference_Measurement;
	private Height_Measurement height_Measurement;
	private Weight_Measurement weightMeasurement;
	private long birthTime;
	private int birthOrder;
	private String resuscitationAtBirth;
	private String resuscitationMeds;
	private String otherMeds;
	
	//private int personId;
	private Person person;
	
	
	
//	public int getPersonId() {
//		return personId;
//	}
//
//	public void setPersonId(int personId) {
//		this.personId = personId;
//	}

	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public void setPersonId(Person person) {
		this.person = person;
	}
	
	public int getBirthdetailsId() {
		return birthdetailsId;
	}

	public void setBirthdetailsId(int birthdetailsId) {
		this.birthdetailsId = birthdetailsId;
	}

	
	public Height_Measurement getHeight_Measurement() {
		return height_Measurement;
	}
	
	public void setHeight_Measurement(Height_Measurement height_Measurement) {
		this.height_Measurement = height_Measurement;
	}
	
	public Weight_Measurement getWeightMeasurement() {
		return weightMeasurement;
	}
	
	public void setWeightMeasurement(Weight_Measurement weightMeasurement) {
		this.weightMeasurement = weightMeasurement;
	}

	

	public int getBirthOrder() {
		return birthOrder;
	}

	public void setBirthOrder(int birthOrder) {
		this.birthOrder = birthOrder;
	}

	public String getResuscitationAtBirth() {
		return resuscitationAtBirth;
	}

	public void setResuscitationAtBirth(String resuscitationAtBirth) {
		this.resuscitationAtBirth = resuscitationAtBirth;
	}

	public String getResuscitationMeds() {
		return resuscitationMeds;
	}

	public void setResuscitationMeds(String resuscitationMeds) {
		this.resuscitationMeds = resuscitationMeds;
	}

	public String getOtherMeds() {
		return otherMeds;
	}

	public void setOtherMeds(String otherMeds) {
		this.otherMeds = otherMeds;
	}

	public long getBirthTime() {
		return birthTime;
	}

	public void setBirthTime(long birthTime) {
		this.birthTime = birthTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public GestationalAge_Measurement getGestationalAge_Measurement() {
		return gestationalAge_Measurement;
	}

	public void setGestationalAge_Measurement(
GestationalAge_Measurement gestationalAge_Measurement) {
		this.gestationalAge_Measurement = gestationalAge_Measurement;
	}

	public HeadCircumference_Measurement getHeadCircumference_Measurement() {
		return headCircumference_Measurement;
	}

	public void setHeadCircumference_Measurement(
			HeadCircumference_Measurement headCircumference_Measurement) {
		this.headCircumference_Measurement = headCircumference_Measurement;
	}

	public BirthDetails() {
		super();
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (birthdetailsId ^ (birthdetailsId >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BirthDetails)) {
			return false;
		}
		BirthDetails other = (BirthDetails) obj;
		if (birthdetailsId != other.birthdetailsId) {
			return false;
		}
		return true;
	}

}
