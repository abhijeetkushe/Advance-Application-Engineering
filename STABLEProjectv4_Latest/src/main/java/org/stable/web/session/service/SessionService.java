/**
 * 
 */
package org.stable.web.session.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.stable.web.session.Session;
import org.stable.web.session.SessionManager;
import org.stable.web.session.SessionParameters;
import org.stable.web.session.exception.AddrException;
import org.stable.web.session.exception.SessionLockedException;
import org.stable.web.session.exception.TimeoutException;
import org.stable.web.session.exception.TimestampException;

/**
 * @author Amuthan Arulraj
 * 
 */
public class SessionService {

	private SessionManager sManager = SessionManager.getInstance();

	public SessionService() {

	}

	public Session getSessionFromRequest(HttpServletRequest request) {

		String ipAddress = request.getRemoteAddr();
		String sessionID = null;
		String timestamp = null;

		// If Session parameters in header
		// sessionID = getSessionIDFromHeader(request);
		// timestamp = getTimestampFromHeader(request);

		// If session parameters in cookie
		sessionID = getSessionIDFromCookie(request);
		timestamp = getTimestampFromCookie(request);

		sManager = SessionManager.getInstance();
		Session session = null;
		try {
			session = sManager.lookup(sessionID, ipAddress, timestamp);
		} catch (TimeoutException toe) {
			// TODO add operation for caught exception
		} catch (TimestampException tse) {
			// TODO add operation for caught exception
		} catch (AddrException ae) {
			// TODO add operation for caught exception
		} catch (SessionLockedException sle) {
			// TODO add operation for caught exception
		}
		return session;
	}

	public String getSessionIDFromHeader(HttpServletRequest request) {
		String sessionID = null;
		sessionID = request.getHeader(SessionParameters.STABLE_SESSIONID);
		return sessionID;
	}

	public String getTimestampFromHeader(HttpServletRequest request) {
		String timestamp = null;
		timestamp = request.getHeader(SessionParameters.STABLE_TIMESTAMP);
		return timestamp;
	}

	public String getSessionIDFromCookie(HttpServletRequest request) {
		String sessionID = null;
		sessionID = getCookieValue(request, SessionParameters.STABLE_SESSIONID);
		return sessionID;
	}

	public String getTimestampFromCookie(HttpServletRequest request) {
		String timestamp = null;
		timestamp = getCookieValue(request, SessionParameters.STABLE_TIMESTAMP);
		return timestamp;
	}

	private String getCookieValue(HttpServletRequest request, String cookieName) {
		Cookie[] requestCookies = request.getCookies();
		String cookieValue = null;
		for (Cookie c : requestCookies) {
			if (c.getName().equals(cookieName)) {
				cookieValue = c.getValue();
			}
		}
		return cookieValue;
	}

	public void setSessionParametersOnHeader(HttpServletResponse response,
			Session session) {
		response.setHeader(SessionParameters.STABLE_SESSIONID, session
				.getStableSessionID());
		response.setHeader(SessionParameters.STABLE_TIMESTAMP, session
				.getTimestamp());
	}

	public void setSessionParametersOnCookie(HttpServletResponse response,
			Session session) {
		Cookie sessionIDCookie = new Cookie(SessionParameters.STABLE_SESSIONID,
				session.getStableSessionID());
		sessionIDCookie.setMaxAge(SessionParameters.MAX_COOKIE_AGE);
		response.addCookie(sessionIDCookie);

		Cookie timestampCookie = new Cookie(SessionParameters.STABLE_TIMESTAMP,
				session.getTimestamp());
		timestampCookie.setMaxAge(SessionParameters.MAX_COOKIE_AGE);
		response.addCookie(timestampCookie);
	}

}
