<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="cart.*" import="book.*" import="java.util.List"
	pageEncoding="UTF-8"%>
<%
CartService service = new SHCartService(new ListCartDAO());
List<CartItem> itemList = service.listAll();
//
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<style>
		input[type="number"]{
			width : 2.5em;
		}
		form{
			display : incline;
		}
		table{
			 border-collapse :collapse;
			 text-align :center;			
		}
		td{
			padding : 5px;
		}
	
	</style>
</head>
<body>
	<%@include file="/common/header.jsp"%>
	
	
	<%
	if (itemList.size() == 0) {
	%>
	<p>장바구니가 비어있습니다.</p>
	<%
	} else {
	BookService bookService = new BookService(new BookDAO());
	%>
	<table border=1>
		<tr>
			<th>아이디</th>
			<th>책아이디</th>
			<th>제목</th>
			<th>가격</th>
			<th>수량</th>
		</tr>
		
		<%
		int numItems = 0, totalPrice = 0;
		for (CartItem item : itemList) {
			Book book = bookService.read(item.getBookId());
			numItems += item.getQuantity();
			totalPrice += book.getPrice() * item.getQuantity();
		%>

		<tr>
			<td><%=item.getNo()%></td>
			<td><%=item.getBookId()%></td>
			<td><%=book.getTitle()%></td>
			<td><%=book.getPrice()%></td>
			<td><%=item.getQuantity()%></td>
			
			<td><form action = "update.jsp" method="post" onsumbmit="return isValidForm()">
					<input type="hidden" name="id" value="<%= item.getNo() %>">
					<input type="number" name="quantity" value="<%= item.getQuantity() %>">
					<input type="submit" value="수정">		 	
			</form>
			<button onclick="askConfrimRemove(<%= item.getNo() %>)">삭제</button>
			</td>
		</tr>
		
		<%
		}
		%>
	</table>
	<br>
	<p>
		총 상품가격 :<%=totalPrice%>원 (총<%=numItems%>권)
	</p>
	<button onclick="askConfrimOrder()">주문하기</button>
	<button onclick="askConfirmClear()">장바구니 비우기</button>
	<%}%>
	<%@include file="/common/footer.jsp"%>
	<script>
	function askConfrimOrder(){
		if(confirm("주문하시겠습니까?"))
		location = "<%=request.getContextPath()%>/order/order.jsp"
		}
	function askConfrimClear(){
		if(confirm("모든 도서를 삭제하시겠습니까?"))
		location = "<%=request.getContextPath()%>/cart/clear.jsp"
		}
	function askConfrimRemove(cartId){
		if(confirm("도서를 장바구니에 삭제하시겠습니까?"))
		location = "<%=request.getContextPath()%>/cart/remove.jsp?id=" +cartId;
		}
</script>
</body>
</html>