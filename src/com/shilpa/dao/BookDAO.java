package com.shilpa.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.shilpa.connectionutil.ConnectionUtil;
import com.shilpa.model.Books;
import com.shilpa.model.Order;

public class BookDAO {
	private static JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	// public static void main(String[] args) throws ClassNotFoundException,
	// SQLException {
	public void register(Books book) throws SQLException, ClassNotFoundException {
		LocalDate p = LocalDate.parse("2016-12-12");

		String sql = "insert into books(name,price,published_date)values(?,?,?)";

		Object[] params = { book.getName(), book.getPrice(), book.getPublishedDate() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);

	}

	public List<Books> listBook() throws ClassNotFoundException, SQLException {
		// public static void main(String[] args) throws ClassNotFoundException,
		// SQLException {

		String sql = "select id,name,price,published_date from books ";

		List<Books> bookList = jdbcTemplate.query(sql, (rs, rowNo) -> {

			int id1 = rs.getInt("id");
			String name1 = rs.getString("name");
			int price = rs.getInt("price");
			Date publishedDate = rs.getDate("published_date");

			Books book = new Books();
			book.setId(id1);
			book.setName(name1);
			book.setPrice(price);
			book.setPublishedDate(publishedDate.toLocalDate());
			//bookList.add(book);
			return book;

		});
		// return bookList;
		System.out.println(bookList);
		//for (Books b : bookList) {
			//System.out.println(b);
		//}
		return bookList;

		// }

	}
}
