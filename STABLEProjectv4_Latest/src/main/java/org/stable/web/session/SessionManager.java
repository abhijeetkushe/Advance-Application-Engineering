package org.stable.web.session;

import java.util.concurrent.ConcurrentHashMap;

import org.stable.web.session.exception.AddrException;
import org.stable.web.session.exception.SessionLockedException;
import org.stable.web.session.exception.TimeoutException;
import org.stable.web.session.exception.TimestampException;

public class SessionManager {

	private static SessionManager instance;
	private ConcurrentHashMap<String, Session> sessions;

	public static SessionManager getInstance() {
		if (instance == null) {
			instance = new SessionManager();
		}
		return instance;
	}

	private SessionManager() {
		sessions = new ConcurrentHashMap<String, Session>();
	}

	public synchronized Session lookup(String sessionID, String addr,
			String timestamp) throws TimeoutException, AddrException,
			TimestampException, SessionLockedException {

		// Removing inactive sessions from the concurrent hashmap
		for (String key : sessions.keySet()) {
			if (!key.equals(sessionID)) {
				Session s = sessions.get(key);
				if (!s.isActive())
					sessions.remove(s);
			}
		}

		Session session;
		// A new session
		if (sessionID == null) {
			session = new Session();
			session.setIpAddress(addr);
			sessions.put(session.getStableSessionID(), session);
		} else {// An existing session
			session = sessions.get(sessionID);
			// Again checking for new session
			if (session == null) {
				session = new Session();
				session.setIpAddress(addr);
				sessions.put(session.getStableSessionID(), session);
			}
			if (!session.isAuthenticated()) {// Session is not authenticated
				// Inactive OR inconsistent address OR incorrect timestamp
				if (!session.isActive() || !session.getIpAddress().equals(addr)) { // ||!session.getTimestamp().equals(timestamp))
					// {
					sessions.remove(session.getStableSessionID());
					session = new Session();
					session.setIpAddress(addr);
					sessions.put(session.getStableSessionID(), session);
				}
				session.unLockSession();
				// Check whether session is locked
				if (session.isLocked()) {
					throw new SessionLockedException("Session is locked");
				}
			} else {// Session is authenticated
				// Inactive
				if (!session.isActive()) {
					sessions.remove(session.getStableSessionID());
					throw new TimeoutException();
				}
				// Inconsistent address
				if (!session.getIpAddress().equals(addr)) {
					sessions.remove(session.getStableSessionID());
					throw new AddrException();
				}
				// Incorrect timestamp
				if (!session.getTimestamp().equals(timestamp)) {
					sessions.remove(session.getStableSessionID());
					throw new TimestampException();
				}
			}
		}
		return session;
	}

	public synchronized void killSession(String id) {
		if (id != null)
			if (sessions.containsKey(id))
				sessions.remove(id);
	}

	public synchronized Session createSession(String addr) {
		Session session = new Session();
		session.setIpAddress(addr);
		sessions.put(session.getStableSessionID(), session);
		return session;
	}

	public synchronized Session copySession(Session session) {
		Session ss = new Session(session);
		sessions.put(ss.getStableSessionID(), ss);
		return ss;
	}

	public synchronized Session refreshSession(Session session) {
		if (session.isAuthenticated()) {
			String id = session.getStableSessionID();
			Session ss = new Session(session);
			ss.updateActivityTime();
			ss.updateTimestamp();
			sessions.put(ss.getStableSessionID(), ss);
			killSession(id);
			return ss;
		} else {
			return session;
		}
	}

	public Session getUserSession(String userid) {
		for (String id : sessions.keySet()) {
			Session ss = sessions.get(id);
			if (ss.isActive() && ss.isAuthenticated()) {
				if (ss.getUserID().equals(userid)) {
					return ss;
				}
			}
		}
		return null;
	}

}
