/**
 *
 */
package org.stable.web.spring;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.stable.web.common.AppParameters;
import org.stable.web.session.Session;
import org.stable.web.session.SessionManager;
import org.stable.web.session.service.SessionService;

/**
 * @author Amuthan Arulraj
 * 
 */
public class StableSessionInterceptor extends HandlerInterceptorAdapter {

	private SessionManager sManager = SessionManager.getInstance();

	/** Add URLs that are excluded to contain stableSessionID and timestamp **/
	private static final ArrayList<String> EXCLUDE_PATHS = new ArrayList<String>();
	private SessionService sessionService;

	static {
		EXCLUDE_PATHS.add(AppParameters.CONTEXT_PATH + "login.jsp");
		EXCLUDE_PATHS.add(AppParameters.CONTEXT_PATH + "home.htm");
	}

	// before the actual handler will be executed
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		if (EXCLUDE_PATHS.contains(request.getRequestURI())) {
//			System.out.println("prehandle 1: " + request.getRequestURI());
			return true;
		}

		sessionService = new SessionService();
		Session session = sessionService.getSessionFromRequest(request);

		if (session != null && session.isAuthenticated() && session.isActive()
				&& !session.isLocked()) {
//			System.out.println("session locked: " + session.isLocked());
//			System.out.println("prehandle 2: " + request.getRequestURI());
			return true;
		}
//		System.out.println("prehandle 3: " + request.getRequestURI());
		return false;
	}

	// after the handler is executed
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

//		System.out.println("posthandle 1: " + request.getRequestURI());
		if (!EXCLUDE_PATHS.contains(request.getRequestURI())) {

			sessionService = new SessionService();
			Session session = sManager.refreshSession(sessionService
					.getSessionFromRequest(request));

			if (session != null) {
				sessionService.setSessionParametersOnCookie(response, session);
			}
//			System.out.println("posthandle 2: " + request.getRequestURI());
		}
	}

}
