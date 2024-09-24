package vn.iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.Models.UserModel;
import vn.iostar.confligs.DBConnectMySQL;
import vn.iostar.dao.IUserDao;

public class UserDaoimpl extends DBConnectMySQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement preparedStatement = null;
	public ResultSet resultSet = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM users";
		List<UserModel> users = new ArrayList<>();
		try {
			conn = super.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserModel user = new UserModel(0, sql, sql, sql, sql, sql, 0, null);
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setFullname(resultSet.getString("fullname"));
				user.setImages(resultSet.getString("images"));
				user.setRoleid(resultSet.getInt("roleid"));
				user.setCreateDate(resultSet.getDate("createDate"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM users WHERE id=?";
		// UserModel users = new UserModel();
		try {
			conn = super.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserModel user = new UserModel(id, sql, sql, sql, sql, sql, id, null);
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));

				user.setEmail(resultSet.getString("email"));
				user.setFullname(resultSet.getString("fullname"));
				user.setImages(resultSet.getString("images"));
				user.setPassword(resultSet.getString("password"));
				user.setRoleid(resultSet.getInt("roleid"));
				user.setCreateDate(resultSet.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO users (username, email, password) VALUES (?,?,?)";
		try {
			conn = super.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		UserModel user = new UserModel(0, sql, sql, sql, sql, sql, 0, null);
		try {
			conn = super.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setFullname(resultSet.getString("fullname"));
				user.setImages(resultSet.getString("images"));
				user.setRoleid(resultSet.getInt("roleid"));
				user.setCreateDate(resultSet.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	

	@Override
	public UserModel checkExistEmail(String email) {
		String query = "select * from users where email = ?";
		try {
			conn = super.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return new UserModel(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), 0, null);
			}
		} catch (Exception ex) {
		}
		return null;

	}

	@Override
	public UserModel checkExistUsername(String username) {
		String query = "select * from users where username = ?";
		try {
			conn = super.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return new UserModel(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), 0, null);
			}
		} catch (Exception ex) {
		}
		return null;

	}

	@Override
	public UserModel update(String email) {
		String sql = "UPDATE users SET password = '123456' WHERE email = ?";
		try {
			conn = super.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	

	}
	public static void main(String[] args) {
		try {
			UserDaoimpl userDao = new UserDaoimpl();

			//userDao.update("22110213@student.hcmute.edu.vn");
			System.out.println(userDao.checkExistEmail("22110213@student.hcmute.edu.vn"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
