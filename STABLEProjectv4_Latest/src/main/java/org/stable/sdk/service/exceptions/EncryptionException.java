/**
 * 
 */
package org.stable.sdk.service.exceptions;

/**
 * @author Amuthan Arulraj
 *
 */
public class EncryptionException extends Exception {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;
	
	public EncryptionException() {
		super();
	}
	
	public EncryptionException(String message) {
        super(message);
    }

    public EncryptionException(Throwable cause) {
        super(cause);
    }

    public EncryptionException(String message, Throwable cause) {
        super(message, cause);
    }

}
