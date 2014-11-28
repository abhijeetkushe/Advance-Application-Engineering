package org.stable.web.session.exception;

public class TimeoutException extends Exception {

	private static final long serialVersionUID = 1L;

	private static String TimeoutErr = "Timeout!";

	public TimeoutException() {

	}

	public String toString() {
		return TimeoutErr;
	}
}
