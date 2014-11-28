package org.stable.web.session.exception;

public class TimestampException extends Exception {

	private static final long serialVersionUID = 1L;

	private static String TSErr = "Incorrect timestamp!";

	public TimestampException() {

	}

	public String toString() {
		return TSErr;
	}
}
