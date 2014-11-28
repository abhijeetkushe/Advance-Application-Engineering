/**
 * 
 */
package org.stable.sdk.model.patient;

import java.util.HashSet;
import java.util.Set;

import org.stable.sdk.model.common.Gender;
import org.stable.sdk.model.common.IStableModel;

/**
 * @author Amuthan Arulraj
 * 
 */
public class Person implements IStableModel {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;
	private int personID;
	private String firstName = "";
	private String lastName = "";
	private String preferredName = "";
	private boolean isMother = false;
	
	private Person myMother;
	private Person father;
	private Set<Person> myBabies;
	private BirthDetails birthDetails;
	public Person() {
		super();
		myBabies = new HashSet<Person>();
	
		
	}

	/**
	 * @return the personID
	 */
	
	
	public int getPersonID() {
		return personID;
	}

	public BirthDetails getBirthDetails() {
		return birthDetails;
	}

	public void setBirthDetails(BirthDetails birthDetails) {
		this.birthDetails = birthDetails;
	}

	/**
	 * @param personID
	 *            the personID to set
	 */
	public void setPersonID(int personID) {
		this.personID = personID;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the preferredName
	 */
	public String getPreferredName() {
		return preferredName;
	}

	/**
	 * @param preferredName
	 *            the preferredName to set
	 */
	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}

	/**
	 * @return the isMother
	 */
	public boolean isMother() {
		return isMother;
	}

	/**
	 * @param isMother
	 *            the isMother to set
	 */
	public void setMother(boolean isMother) {
		this.isMother = isMother;
	}

	/**
	 * @return the myMother
	 */
	public Person getMyMother() {
		return myMother;
	}

	/**
	 * @param myMother
	 *            the myMother to set
	 */
	public void setMyMother(Person myMother) {
		this.myMother = myMother;
	}

	/**
	 * @return the father
	 */
	public Person getFather() {
		return father;
	}

	/**
	 * @param father
	 *            the father to set
	 */
	public void setFather(Person father) {
		this.father = father;
	}

	/**
	 * @return the myBabies
	 */
	public Set<Person> getMyBabies() {
		return myBabies;
	}

	/**
	 * @param myBabies
	 *            the myBabies to set
	 */
	public void setMyBabies(Set<Person> myBabies) {
		this.myBabies = myBabies;
	}

	public String fullName() {
		return (lastName != null ? lastName + ", " : "")
				+ (firstName != null ? firstName : "");
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
		result = prime * result + personID;
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
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		if (personID != other.personID) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (lastName != null ? lastName + ", " : "")
				+ (firstName != null ? firstName : "");
	}

}
