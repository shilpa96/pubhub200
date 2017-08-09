package com.shilpa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.shilpa.connectionutil.ConnectionUtil;
import com.shilpa.model.Order;
import com.shilpa.model.Users;

public class OrderDAO {
	private static JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	// public static void main(String[] args) throws ClassNotFoundException,
	// SQLException {
	public void add(Order order) throws SQLException {

		String sql = "insert into orders(users_id,book_id,status,quantity,order_date)values(?,?,?,?,?)";
		Object[] params = { order.getUsersId(), order.getBookId(), order.getStatus(), order.getQuantity(),
				order.getOrderDate() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	// public static void main(String[] args) throws ClassNotFoundException,
	// SQLException {
	public List<Order> list() throws ClassNotFoundException, SQLException

	{
		String sql = "select id,users_id,book_id,status,quantity,order_date from orders ";
		List<Order> orderList = jdbcTemplate.query(sql, (rs, rowNo) -> {

			int id1 = rs.getInt("id");
			int userId = rs.getInt("users_id");
			int bookId = rs.getInt("book_id");
			String status = rs.getString("status");
			int quantity = rs.getInt("quantity");
			Date orderDate = rs.getDate("order_date");

			Order order = new Order();
			order.setId(id1);
			order.setUsersId(userId);
			order.setBookId(bookId);
			order.setStatus(status);
			order.setQuantity(quantity);
			order.setOrderDate(orderDate.toLocalDate());
			// order.add(order);
			return order;

		});
		// return bookList;
		System.out.println(orderList);

		return orderList;

	}

}
