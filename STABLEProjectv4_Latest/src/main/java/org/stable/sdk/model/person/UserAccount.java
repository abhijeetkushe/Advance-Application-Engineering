/**
 * 
 */
package org.stable.sdk.model.person;

import java.util.Date;

import org.stable.sdk.model.clinic.Clinic;
import org.stable.sdk.model.common.IStableModel;

/**
 * @author amuthanarulraj
 * 
 */
public class UserAccount implements IStableModel {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;
	private int userAccountID;
	private String username;
	private String password;
	private int status;
	private Employee employee;
	private Date createdOn;
	private Employee createdBy;
	private Date expireOn;
	private Clinic clinic;
	private int role=1;
	

	public UserAccount() {
		super();
	}

	/**
	 * @return the userAccountID
	 */
	public int getUserAccountID() {
		return userAccountID;
	}

	/**
	 * @param userAccountID
	 *            the userAccountID to set
	 */
	public void setUserAccountID(int userAccountID) {
		this.userAccountID = userAccountID;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the AccountStatus
	 */
	public AccountStatus getStatusEnum() {
		for (AccountStatus as : AccountStatus.values()) {
			if (getStatus() == as.getId()) {
				return as;
			}
		}
		return null;
	}

	/**
	 * @param accountStatus
	 *            the accountStatus to set
	 */
	public void setStatusEnum(AccountStatus accountStatus) {
		setStatus(accountStatus.getId());
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee
	 *            the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn
	 *            the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the createdBy
	 */
	public Employee getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the expireOn
	 */
	public Date getExpireOn() {
		return expireOn;
	}

	/**
	 * @param expireOn
	 *            the expireOn to set
	 */
	public void setExpireOn(Date expireOn) {
		this.expireOn = expireOn;
	}

	/**
	 * @return the clinic
	 */
	public Clinic getClinic() {
		return clinic;
	}

	/**
	 * @param clinic
	 *            the clinic to set
	 */
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
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
		result = prime * result
				+ (int) (userAccountID ^ (userAccountID >>> 32));
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		if (!(obj instanceof UserAccount)) {
			return false;
		}
		UserAccount other = (UserAccount) obj;
		if (userAccountID != other.userAccountID) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
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
		return getEmployee() != null ? getEmployee().fullName() : "";
	}
	
	public int getRole() {
		System.out.println(role);
		return role;
	}
	
	public void setRole(int role) {
		this.role = role;
	}

}
