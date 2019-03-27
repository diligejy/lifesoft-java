<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <!--<%@ page import = "book.BookDAO"%>-->
 --%>
<%--  <!-- <%@page import = "book.BookDTO" %>-->
 --%>
<%@ page import="book.*"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<%
		BookDAO dao = BookDAO.getDAO();
		ArrayList<BookDTO> list = dao.bookList();
	%>
	<ul>
		<%
			for (BookDTO dto : list) {
		%>
		<li><%=dto.getTitle()%></li>
		<%
			}
		%>
	</ul>
</body>
</html>