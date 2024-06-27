<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="book.*"
    pageEncoding="UTF-8"%>
<% 
	String idStr = request.getParameter("id");
	if(idStr == null || idStr.isEmpty()){
		response.sendRedirect(request.getContextPath()+"/common/errorPage.jsp?idError=1");
	}else{
		BookService service = new BookService(new BookDAO());
		Book book = service.read(Integer.parseInt(idStr));
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세 정보</title>
</head>
<body>
	<%@ include file="/common/header.jsp" %>
	<h3>도서 상세 정보</h3>
	<% if (book == null){ %>
		<p>도서 정보가 없습니다.</p>
	<%}else{ %>
		<ul>
			<li>아이디 :<%=book.getNo() %></li>
			<li>제목 :<%=book.getTitle() %></li>
			<li>저자 :<%=book.getAuthor() %></li>
			<li>출판사 :<%=book.getPublisher() %></li>
			<li>가격 :<%=book.getPrice() %></li>
		</ul>
		<br>
		<% char memberType = 'M';
			if(memberType == 'A') { %>
			<a href="modifyPage.jsp?id=<%=book.getNo() %>"><button>수정</button></a>
			<a href="removePage.jsp?id=<%=book.getNo() %>"><button>삭제</button></a>
		<% } else if (memberType == 'M'){ %>
			<a href="<%= request.getContextPath() %>/cart/add.jsp?bookId=<%=book.getNo() %>"><button>장바구니 담기</button></a>
			<a href="<%= request.getContextPath() %>/index.jsp %>"><button>장바구니 담기</button></a>
		
		<%}%>
	<%}%>
	<%@ include file="/common/footer.jsp" %>
</body>
</html>
<% }%>