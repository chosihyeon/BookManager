<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="cart.*"
    pageEncoding="UTF-8"%>
    
<%
	CartService service = new SHCartService(new ListCartDAO());
	
	if(service.clear()){
		response.sendRedirect(request.getContextPath() +"/cart/main.jsp");
	}else{
		response.sendRedirect(request.getContextPath() +"/common/errorPage.jsp?bookIdErr=1");
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