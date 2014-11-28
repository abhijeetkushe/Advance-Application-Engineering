/**
 * 
 */
package org.stable.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.stable.sdk.model.person.UserAccount;
import org.stable.sdk.service.security.SecurityServiceImpl;
import org.stable.web.session.Session;
import org.stable.web.session.SessionManager;
import org.stable.web.session.exception.SessionLockedException;
import org.stable.web.session.service.SessionService;

/**
 * @author Amuthan Arulraj
 * 
 */
public class LoginController extends AbstractController {

	private SecurityServiceImpl securityService;
	private SessionService sessionService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getRemoteAddr();

		sessionService = new SessionService();

		String stableSessionID = sessionService.getSessionIDFromCookie(request);
		String timestamp = sessionService.getTimestampFromCookie(request);

		UserAccount ua = securityService.authenticateUser(username, password);

		SessionManager sManager = SessionManager.getInstance();
		Session session = null;
		try {
			session = sManager.lookup(stableSessionID, address,
					timestamp);

			if (ua != null) {

				session.setUserID(Integer.toString(ua.getUserAccountID()));
				session.setRole(ua.getEmployee().getRoleEnum());

				sessionService.setSessionParametersOnCookie(response, session);

				System.out.println("login successful");

				return new ModelAndView("home", "user", ua);
			}
		} catch (Exception e) {
			return new ModelAndView("login");
		}

		session.failedLogin();
		sessionService.setSessionParametersOnCookie(response, session);
		System.out.println("login failed");

		return new ModelAndView("login");
	}

	/**
	 * @return the securityService
	 */
	public SecurityServiceImpl getSecurityService() {
		return securityService;
	}

	/**
	 * @param securityService
	 *            the securityService to set
	 */
	public void setSecurityService(SecurityServiceImpl securityService) {
		this.securityService = securityService;
	}

}