<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.sql.*" %>
    <%@ page import = "java.util.*" %>
    <%@ page import = "com.koreait.board.db.BoardDAO" %>
    <%@ page import = "com.koreait.board.vo.BoardVO" %>
    <%
    	BoardVO vo =(BoardVO)request.getAttribute("data");
    	String strI_board = request.getParameter("i_board");
    	int i_board = Integer.parseInt(strI_board);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>번호 : ${data.i_board}</div>
<div>제목 : ${data.title}</div>
<div>내용 : ${data.ctnt}</div>
<div>작성자 : ${data.i_student}</div>
<button onclick="movetoWrite(<%=vo.getI_board()%>)">수정</button>
<button onClick="movetoDelete(<%=vo.getI_board()%>)">삭제</button>
</body>
<script>
function movetoWrite(i_board){
	console.log('movetoWrite-i_board:'+i_board)
	location.href = "boardWrite?i_board="+i_board;
}

function movetoDelete(i_board){
	alert('삭제하시겠습니까?');
	console.log('movetoDelete-i_board:'+i_board)
	location.href = "boardDelete?i_board="+i_board;
}
</script>
</html>