package org.stable.web.session.exception;

public class AddrException extends Exception {

	private static final long serialVersionUID = 1L;

	private static String AddrErr = "Inconsistent Address!";

	public AddrException() {

	}

	public String toString() {
		return AddrErr;
	}
}
