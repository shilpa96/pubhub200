package com.shilpa.connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionUtil {

	/*
	 * public static void main(String[] args) throws SQLException,
	 * ClassNotFoundException { Connection con = getConnection();
	 * System.out.println(con); }
	 * 
	 * public static Connection getConnection() throws SQLException,
	 * ClassNotFoundException { Class.forName("com.mysql.jdbc.Driver");
	 * Connection con =
	 * DriverManager.getConnection("jdbc:mysql://localhost:3306/bookapp","root",
	 * "root");
	 * 
	 * return con; }
	 */
	public static DataSource getDataSource() {

		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/bookapp");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;

	}

	public static JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		DataSource dataSource = getDataSource();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}
}
