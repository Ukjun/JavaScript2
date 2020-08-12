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
 <%--    <%
    	if(errMsg !=null){
    %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#container{
		margin: 20 auto;
		text-align: center;
		line-height: 50px;
		border: 3px dotted #A8C8F9;
	}
</style>
</head>
<body>
<div id="container">
	<div>번호 : ${data.i_board}</div>
	<div>제목 : ${data.title}</div>
	<div>내용 : ${data.ctnt}</div>
	<div>작성자 : ${data.i_student}</div>
	<%-- <button onclick="movetoWrite(<%=i_board%>)">수정</button>&nbsp;&nbsp;&nbsp;&nbsp; --%>
	<a href="boardWrite?i_board=${data.i_board}"><button>수정</button></a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="boardDelete?i_board=<%=i_board%>"><button>삭제</button></a>
</div>
<%-- <form>
<fieldset>
<legend> <strong>글 내용 </strong></legend>
	<ul>
		<li>번호 : ${data.i_board}</li>
		<li>제목 : ${data.title}</li>
		<li>내용 : ${data.ctnt}</li>
		<li>작성자 : ${data.i_student}</li>
	</ul>
	<button onclick="movetoWrite(<%=vo.getI_board()%>)">수정</button>
	<button onClick="movetoDelete(<%=vo.getI_board()%>)">삭제</button>
</fieldset>
</form> --%>

</body>
<script>
function movetoWrite(i_board){
	console.log('movetoWrite-i_board:'+i_board)
	location.href = "boardWrite?i_board="+i_board;
}

function movetoDelete(i_board){
	if(confirm('삭제하시겠습니까?')){
		console.log('movetoDelete-i_board:'+i_board)
		location.href = "boardDelete?i_board="+i_board;	
	}else{
		return ;
	}
	
}
</script>
</html>