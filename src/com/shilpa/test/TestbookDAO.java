package com.shilpa.test;

import java.sql.SQLException;
import java.time.LocalDate;

import com.shilpa.dao.BookDAO;
import com.shilpa.model.Books;

public class TestbookDAO {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		LocalDate date = LocalDate.parse("2016-12-12");
		Books book = new Books();
		book.setName("c++");
		book.setPrice(100);
		book.setPublishedDate(date);

		BookDAO bookdao = new BookDAO();
		//bookdao.register(book);
		System.out.println(book);
			}
}
