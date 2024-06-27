<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="cart.*"
    pageEncoding="UTF-8"%>
<%
	String idStr = request.getParameter("no");
	if(idStr == null || idStr.isEmpty()){
	response.sendRedirect(request.getContextPath() +"/common/errorPage.jsp?cartIdErr=1");
	return;
	}
	CartService service = new SHCartService(new ListCartDAO());
	if(service.remove(Integer.parseInt(idStr))){
		response.sendRedirect(request.getContextPath() +"/cart/main.jsp");
		
	}else{
		response.sendRedirect(request.getContextPath() +"/common/errorPage.jsp?bookIdErr=1");
		
	}


%>
