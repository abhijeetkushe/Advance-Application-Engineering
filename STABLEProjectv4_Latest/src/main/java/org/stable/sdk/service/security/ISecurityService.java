/**
 * 
 */
package org.stable.sdk.service.security;

import org.stable.sdk.model.person.UserAccount;

/**
 * @author amuthanarulraj
 *
 */
public interface ISecurityService {
	
	public UserAccount authenticateUser(String username, String password);

}
