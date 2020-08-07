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
	margin-bottom: 30px
}
a{
	line-height: 30px;
}
table{
	border-collapse: collapse;
	margin: 0 auto;
	width: 300px;
}
table tr td {
	border : 1px solid black;
}
td {
	text-align: center;
}
.itemRow:hover{
	background-color: #ffffcc;
	cursor: pointer;
	animation-duration : 2s;
	animation-name : ani_hover;
}
 @keyframes ani_hover{
        from{
            background-color: white;
        }to{
            background-color: #ffcccc;
        }
   }

</style>
</head>
<body>
	<div id="first">게시판리스트
	<!-- 주소값은 보통 서블릿으로 지정한다. -->
	<br>
	<a href="/boardWrite"><button>글 쓰기</button></a>
	<table>
	<tr>
			<th>NO</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
	</tr>
	<% for(BoardVO vo : list) { %>
	<tr class="itemRow" onclick="moveToDetail(<%=vo.getI_board()%>)">
		<td><%=vo.getI_board()%></td>
		<td><%=vo.getTitle()%></td>
		<td><%=vo.getCtnt()%></td>
		<td><%=vo.getI_student()%></td>
	</tr>
	<%}%>
	</table>
	</div>
	<script>
	function moveToDetail(i_board){
		console.log('moveToDetail-i_board:'+i_board)
		location.href ="boardDetail?i_board="+i_board;
	}
	
	</script>
</body>
</html>