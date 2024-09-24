package vn.iostar.dao;

import java.util.List;

import vn.iostar.Models.UserModel;

public interface IUserDao {

	List<UserModel> findAll();

	UserModel findById(int id);

	void insert(UserModel user);

	UserModel findByUserName(String username);
	
	UserModel checkExistEmail(String email);
	
	UserModel checkExistUsername(String username);
	
	UserModel update(String email);
	
	
	
	
	

	
}
