package com.shilpa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import com.shilpa.connectionutil.ConnectionUtil;
import com.shilpa.model.Users;

public class UserDAO {
	// public static void main(String[] args){
	private static JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void register(Users user) throws ClassNotFoundException, SQLException {

		String sql = "insert into users2(name,email,password)values(?,?,?)";
		Object[] params = { user.getName(), user.getEmail(), user.getPassword() };
		int rows = jdbcTemplate.update(sql, params);

		System.out.println(rows);
	}

	public Users login(String email, String password) throws SQLException, ClassNotFoundException {
		// public static void main(String[] args) throws ClassNotFoundException,
		// SQLException {

		String sql = "select user_id,name, email, password from users2 where email=? and password=?";
		Object[] params = { email, password };
		Users userclass = jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {

			int id = rs.getInt("user_id");
			String name = rs.getString("name");
			String email1 = rs.getString("email");
			String password1 = rs.getString("password");

			Users user = new Users();
			user.setId(id);
			user.setName(name);
			user.setEmail(email1);
			user.setPassword(password1);
			System.out.println(user);
			return user;
		});
		return userclass;

	}

}
