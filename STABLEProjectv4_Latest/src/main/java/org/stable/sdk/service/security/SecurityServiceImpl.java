/**
 * 
 */
package org.stable.sdk.service.security;

import org.stable.sdk.DAO.common.IDao;
import org.stable.sdk.model.person.UserAccount;

/**
 * @author Amuthan Arulraj
 * 
 */
public class SecurityServiceImpl implements ISecurityService {

	private IDao<UserAccount, Integer> userAccountDao;

	public UserAccount authenticateUser(String username, String password) {
		for (UserAccount ua : userAccountDao.loadAll()) {
			if (username.equals(ua.getUsername())
					&& password.equals(ua.getPassword())) {
				return ua;
			}
		}
		return null;
	}
	
	public void createUserAccount(UserAccount userAccount) {
		 userAccountDao.create(userAccount);
	}

	/**
	 * @return the userAccountDao
	 */
	public IDao<UserAccount, Integer> getUserAccountDao() {
		return userAccountDao;
	}

	/**
	 * @param userAccountDao
	 *            the userAccountDao to set
	 */
	public void setUserAccountDao(IDao<UserAccount, Integer> userAccountDao) {
		this.userAccountDao = userAccountDao;
	}

}
