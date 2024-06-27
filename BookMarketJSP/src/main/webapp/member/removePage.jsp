<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="member.*"
    pageEncoding="UTF-8"%>
<%
	String noStr = request.getParameter("no");
	if(noStr==null){
		response.sendRedirect("main.jsp");
	}else{
	MemberService service = new MemberService(new MemberDAO());
	Member member = service.read(Integer.parseInt(noStr));
	if(member==null){
	response.sendRedirect("main.jsp");	
	}else{
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 삭제 페이지</title>
</head>
<body>
	<h3>회원 삭제</h3>
		<ul>
		<li>회원번호 :<%=member.getNo() %></li>
		<li>아이디 :<%=member.getId() %></li>
		<li>닉네임 :<%=member.getNickname() %></li>
	</ul>
	<br>
	<a href="remove.jsp?no=<%=member.getNo()%>"><button>회원정보수정</button></a>
	<a href="detailPage.jsp?no=<%=member.getNo()%>">"><button>회원삭제</button></a>
</body>
</html>
			<%}
			}%>