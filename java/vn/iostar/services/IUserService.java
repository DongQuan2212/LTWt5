package vn.iostar.services;

import vn.iostar.Models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	
	UserModel FindByUserName(String username);
	
	void insert(UserModel user);


	UserModel register(String username, String email, String password);

	boolean send(String to,String subject,String password);
	
	


}
