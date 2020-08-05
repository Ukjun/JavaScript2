<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.koreait.board.db.BoardDAO" %>
    <%@ page import = "com.koreait.board.vo.BoardVO" %>
    <%@ page import = "java.util.*" %>
    <%
    /* String strI_board = request.getParameter("i_board");
    List<BoardVO> boardList = new ArrayList(BoardDAO.selBoardList());
     */
    List<BoardVO> list = (List<BoardVO>)request.getAttribute("data");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>리스트</div>
	<table>
	<% for(BoardVO vo : list) { %>
	<tr>
		<td><%=vo.getI_board()%></td>
		<td><%=vo.getTitle()%></td>
		<td><%=vo.getCtnt()%></td>
		<td><%=vo.getI_student()%></td>
	</tr>
	<%}%>
	</table>
</body>
</html>