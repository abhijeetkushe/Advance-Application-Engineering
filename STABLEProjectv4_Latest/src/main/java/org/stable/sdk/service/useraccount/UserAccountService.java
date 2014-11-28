package org.stable.sdk.service.useraccount;

import org.stable.sdk.DAO.common.IDao;
import org.stable.sdk.model.person.UserAccount;

public class UserAccountService implements IUserAccountService{

	private IDao<UserAccount, Integer> userAccountDAO;
	
	public UserAccountService() {
		// TODO Auto-generated constructor stub
	}
	
	public IDao<UserAccount, Integer> getUserAccountDAO() {
		return userAccountDAO;
	}
	
	public void setUserAccountDAO(IDao<UserAccount, Integer> userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}
	
	public UserAccount validateUser(String username,String password){
		System.out.println("UserName "+username);
		System.out.println("Password "+password);
		System.out.println(userAccountDAO);
		
		for(UserAccount ua:userAccountDAO.loadAll()){
			System.out.println("ua");
			if(ua.getUsername().equals(username) && ua.getPassword().equals(password)){
				System.out.println("in if");
				return ua;
			}
		}
		return null;
	}
	
	public String checkRole(UserAccount ua){
		System.out.println(ua);
		System.out.println(ua.getRole());
		return "role"+ua.getRole();
	}
}
