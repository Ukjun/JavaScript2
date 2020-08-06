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
<style>
#first{
	margin: 0 auto;
	text-align: center;
}
table{
	border-collapse: collapse;
	margin: 0 auto;
	width: 300px;
}
table tr td {
	border : 1px solid black;
}
.itemRow{
	background-color: #ffffcc;
	cursor: pointer;
}
</style>
</head>
<body>
	<div id="first">리스트</div>
	<table>
	<tr>
			<th>NO</th>
			<th>제목</th>
	</tr>
	<% for(BoardVO vo : list) { %>
	<tr class="itemRow" onclick="moveToDetail(<%=vo.getI_board()%>)">
		<td><%=vo.getTitle()%></td>
		<td><%=vo.getCtnt()%></td>
		<td><%=vo.getI_student()%></td>
	</tr>
	<%}%>
	</table>
	
	<script>
	function moveToDetail(i_board){
		console.log('moveToDetail-i_board: '+i_board)
		location.href ="boardDetail?i_board="+i_board;
	}
	</script>
</body>
</html>