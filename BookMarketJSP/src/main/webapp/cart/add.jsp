<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="cart.*"
    pageEncoding="UTF-8"%>
<%
	CartService service = new SHCartService(new ListCartDAO());
	
	String bookIdStr = request.getParameter("bookId");
	
	if(bookIdStr == null || bookIdStr.isEmpty()){
		response.sendRedirect(request.getContextPath()+"/common/errorPage.jsp?bookIdErr=1");
		return;
	}
	
	if(service.add(new CartItem(Integer.parseInt(bookIdStr),1))){
		response.sendRedirect(request.getContextPath() +"/cart/main.jsp");
		
	}else{
		response.sendRedirect(request.getContextPath() +"/common/errorPage.jsp?bookIdErr=2");
		
	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>