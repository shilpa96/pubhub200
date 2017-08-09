<!docType HTML>

<%@page import="java.util.List"%>
<%@page import="com.shilpa.model.Books"%>
<%@page import="com.shilpa.dao.BookDAO"%>
<%@page import="com.shilpa.model.Users"%>
<html>
<head>
<title>BookApp_register</title>
</head>
<body>
	<%
		Users user = (Users) session.getAttribute("Logged_in_user");
	%>
	welcome<%=user.getName()%>
	<h3>list of books</h3>
	<%
		BookDAO bookdao = new BookDAO();
		List<Books> bookList = bookdao.listBook();
		//out.println("books:" + bookList);
	%>
	<table border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>price</th>
				<th>publishedDate</th>
			</tr>
		</thead>

		<%
			for (Books b : bookList) {
				out.println("<tr>");
				out.println("<td>" + b.getId() + "</td>");
				out.println("<td>" + b.getName() + "</td>");
				out.println("<td>" + b.getPrice() + "</td>");
				out.println("<td>" + b.getPublishedDate() + "</td>");
				out.println("</tr>");
			}
		%>
		</tbody>
	</table>

	<!--  <table>
	<tr>
				<td>1</td>
				<td>c++</td>
				<td>300</td>
				<td>2017-10-12</td>
			</tr>
			<tr>
				<td>2</td>
				<td>c</td>
				<td>400</td>
				<td>2013-12-12</td>
			</tr>

			<tr>
				<td>3</td>
				<td>DSP</td>
				<td>1050</td>
				<td>2017-09-12</td>
			</tr>
			<tr>
				<td>4</td>
				<td>DPST</td>
				<td>450</td>
				<td>2015-02-24</td>
			</tr>

</table>-->
	<a href="Order.jsp">Order Book</a>
</body>
</html>