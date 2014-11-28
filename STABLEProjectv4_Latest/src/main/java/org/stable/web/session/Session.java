package org.stable.web.session;

import java.util.Calendar;
import java.util.HashMap;
import java.util.UUID;

import org.stable.sdk.model.person.Role;

public class Session {

	private String stableSessionID;
	private String ipAddress;
	private String userID;
	private Role role;
	private Calendar lastActivityTime;
	private Integer failedLoginCount;
	private volatile Boolean isLocked;
	private String timestamp;
	private HashMap<String, Object> attributes;

	/** specifies maximum active period of a session in mins **/
	protected static final Integer MAX_ACTIVITY = 30;

	/** specifies maximum failed login attempts **/
	protected static final Integer MAX_FAILED_LOGIN = 3;

	/** specifies time for locking session in mins **/
	protected static final Integer UNLOCK_TIME = 30;

	public Session() {
		stableSessionID = UUID.randomUUID().toString();
		ipAddress = null;
		userID = null;
		role = null;
		lastActivityTime = Calendar.getInstance();
		failedLoginCount = 0;
		isLocked = false;
		timestamp = Long.toString(lastActivityTime.getTimeInMillis());
		attributes = new HashMap<String, Object>();
	}

	public Session(Session ss) {
		stableSessionID = UUID.randomUUID().toString();
		ipAddress = ss.getIpAddress();
		userID = ss.getUserID();
		role = ss.getRole();
		lastActivityTime = ss.getLastActivityTime();
		failedLoginCount = ss.getFailedLoginCount();
		isLocked = ss.isLocked();
		timestamp = ss.getTimestamp();
		attributes = ss.getAttributes();
	}

	/**
	 * <p>
	 * Returns true if session is active
	 * </p>
	 *
	 * @return boolean
	 */
	public boolean isActive() {
		Calendar now = Calendar.getInstance();
		Calendar temp = (Calendar) getLastActivityTime().clone();
		temp.add(Calendar.MINUTE, MAX_ACTIVITY);
		if (temp.before(now))
			return false;
		else
			return true;
	}

	/**
	 * <p>
	 * Returns true if this session is authenticated
	 * </p>
	 *
	 * @return boolean
	 */
	public boolean isAuthenticated() {
		return getUserID() != null;
	}

	/**
	 * @return true if session is locked
	 */
	public boolean isLocked() {
		return isLocked.booleanValue();
	}

	/**
	 * Increases failed login count and locks current session if it is higher<br>
	 * than MAX_FAILED_LOGIN count</p>
	 */
	public synchronized void failedLogin() {
		incrementFailedLoginCount();
		if (getFailedLoginCount() > MAX_FAILED_LOGIN) {
			System.out.println("session locked");
			lockSession();
		}
	}

	/**
	 * <p>
	 * Update last activity time with current time
	 * </p>
	 */
	protected synchronized void updateActivityTime() {
		setLastActivityTime(Calendar.getInstance());
	}

	/**
	 * <p>
	 * Update stableSessionId for current request
	 * </p>
	 */
	protected synchronized void updateID() {
		setStableSessionID(UUID.randomUUID().toString());
	}

	/**
	 * <p>
	 * Updates timestamp for the next request and sets the previousTimeStamp<br>
	 * with the old timestamp value
	 * </p>
	 */
	protected synchronized void updateTimestamp() {
		setTimestamp(Long.toString(Calendar.getInstance().getTimeInMillis()));
	}

	/**
	 * <p>
	 * Sets failed login count to zero
	 * </p>
	 */
	protected void resetFailedLoginCount() {
		setFailedLoginCount(0);
	}

	/**
	 * <p>
	 * Increments failed login count by 1
	 * </p>
	 */
	private void incrementFailedLoginCount() {
		failedLoginCount++;
	}

	/**
	 * <p>
	 * Adds a object to session attributes associated by a key
	 * </p>
	 *
	 * @param key
	 *            for the input object
	 * @param value
	 *            of the object
	 */
	public void addAttribute(String key, Object value) {
		getAttributes().put(key, value);
	}

	/**
	 * <p>
	 * Removes a object referenced by key from the session attributes
	 * </p>
	 *
	 * @param key
	 */
	public void removeAttribute(String key) {
		getAttributes().remove(key);
	}

	/**
	 * <p>
	 * Get session attribute object by key
	 * </p>
	 *
	 * @param key
	 * @return value
	 */
	public Object getAttribute(String key) {
		return getAttributes().get(key);
	}

	/**
	 * @return the sessionID
	 */
	public String getStableSessionID() {
		return stableSessionID;
	}

	/**
	 * @param sessionID
	 *            the sessionID to set
	 */
	private void setStableSessionID(String stableSessionID) {
		this.stableSessionID = stableSessionID;
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress
	 *            the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the lastActivityTime
	 */
	public Calendar getLastActivityTime() {
		return lastActivityTime;
	}

	/**
	 * @return the failedLoginCount
	 */
	public Integer getFailedLoginCount() {
		return failedLoginCount;
	}

	/**
	 * @param lastActivityTime
	 *            the lastActivityTime to set
	 */
	public void setLastActivityTime(Calendar lastActivityTime) {
		this.lastActivityTime = lastActivityTime;
	}

	/**
	 * @param failedLoginCount
	 *            the failedLoginCount to set
	 */
	public void setFailedLoginCount(Integer failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}

	/**
	 * Lock this session
	 */
	protected void lockSession() {
		this.isLocked = Boolean.TRUE;
	}

	/**
	 * <p>
	 * Unlock this session if current access time is UNLOCK_TIME mins after last
	 * <br>
	 * activity time and returns true is the operation is successful.
	 * </p>
	 *
	 * @return true if unlock is successful
	 */
	protected void unLockSession() {
		if (isLocked) {
			Calendar now = Calendar.getInstance();
			Calendar temp = (Calendar) getLastActivityTime().clone();
			temp.add(Calendar.MINUTE, UNLOCK_TIME);
			if (temp.before(now)) {
				this.isLocked = Boolean.FALSE;
				resetFailedLoginCount();
			}
		}
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	private void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the attributes
	 */
	public HashMap<String, Object> getAttributes() {
		return attributes;
	}

}
