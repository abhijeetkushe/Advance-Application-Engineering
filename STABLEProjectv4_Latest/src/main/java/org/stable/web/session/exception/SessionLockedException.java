/**
 * 
 */
package org.stable.web.session.exception;

/**
 * @author Amuthan Arulraj
 *
 */
public class SessionLockedException extends Exception {
	
	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;
	
	public SessionLockedException() {
		super();
	}
	
	public SessionLockedException(String message) {
        super(message);
    }

    public SessionLockedException(Throwable cause) {
        super(cause);
    }

    public SessionLockedException(String message, Throwable cause) {
        super(message, cause);
    }
}
