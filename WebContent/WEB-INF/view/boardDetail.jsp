<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.sql.*" %>
    <%@ page import = "java.util.*" %>
    <%@ page import = "com.koreait.board.db.BoardDAO" %>
    <%@ page import = "com.koreait.board.vo.BoardVO" %>
    <%
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	String strI_board = request.getParameter("i_board");
    	
    	String sql = "select title,ctnt,i_student from t_board where i_board= ?";
    	int i_board = Integer.parseInt(strI_board);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div><%=i_board %></div>
</body>
</html>