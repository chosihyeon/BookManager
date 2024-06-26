<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="book.*"
    pageEncoding="UTF-8"%>
	
	<%
	BookService service = new BookService(new BookDAO());
	List<Book>bookList = service.listAll();
	%>
	
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<style>
	table{
		border-collapse:collapse;
		text-align : center;
	}
	td{
		padding:5px;
	}
</style>
</head>
<body>
	<%@ include file ="/common/header.jsp" %>
	<h3>도서목록</h3>
	<% if(bookList.size() == 0) { %>
	<p>등록된 책이 없습니다.</p>
	<%}else{ %>
		<table border = 1>
			<tr>
				<th>아이디</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
				<th>재고</th>
			</tr>
			<% for (Book book : bookList) { %>
				<tr>
					<td><%= book.getNo() %></td>
					<td>
						<a href="book/detailPage.jsp?id=<%= book.getNo() %>"> 
							<%= book.getTitle() %>
						</a>
					</td>
					<td><%= book.getAuthor() %></td>
					<td><%= book.getPrice() %></td>
				</tr>
				<% } %>
				
		</table>
		<% } %>
			<%@ include file="../common/footer.jsp" %>
</body>
</html>