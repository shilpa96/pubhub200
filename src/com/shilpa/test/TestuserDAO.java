package com.shilpa.test;

import java.sql.SQLException;

import com.shilpa.dao.UserDAO;
import com.shilpa.model.Users;

public class TestuserDAO {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		 Users user=new Users();

		 user.setName( "sheela");
		 user.setEmail( "sssi@gmail.com");
		user.setPassword( "123");
		
		UserDAO userdao = new UserDAO();
		userdao.register(user);

		//String email = "shheela";
		//String password = "she";

		//User user = userdao.login(email, password);
		System.out.println(user);

	}


}
