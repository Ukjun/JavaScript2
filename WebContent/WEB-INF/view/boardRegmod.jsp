<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String strI_board = request.getParameter("i_board"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
     ul{
         list-style: none;
     }
     li label{
         float: left;
         width: 120px;
         text-align: right;
        padding-right: 10px;
        
     }
     .err{
     text-align : center;
     color : #e74c3c;
     }
</style>
<body>
<div class="err"> ${msg }
</div>
	<form id = "frm"  method="post" onsubmit="return chk()">
	<fieldset>
		<legend>
		<strong>게시판 작성</strong>
		</legend>
		<ul>
            <li><label>제목 : </label><input type="text" name="title" 
            id="title" autofocus placeholder="이름을 입력해주세요"></li>
            <li><label>내용 : </label><textarea name="ctnt" id="ctnt" cols="50" rows="6"
            placeholder="50자 이내로 써주세요"></textarea></li>
            <li><label>작성자 : </label><input type = "text" name="i_student" id="i_student"></li>
        </ul>
            <input type="submit" onclick="insertUpdate(${data.i_board})" value="작성">
            <input type="reset" value="다시 작성">
	</fieldset>
			
	</form>
		<script>
		function eleValid(ele,cmt){
			if(ele.value.length==0)	{
				alert(cmt);
				ele.focus();
				return true;
			}	
		}
		function chk(){
			console.log(`title : \${frm.title.value}`);
			console.log(`ctnt : \${frm.ctnt.value}`);
			console.log(`i_student : \${frm.i_student.value}`);
			if(eleValid(frm.title,'제목')){
				return false;
			}else if(eleValid(frm.ctnt,'내용')){
				return false;
			}else if(eleValid(frm.i_student,'작성자')){
				return false;
			}
		}
		
		function insertUpdate(strI_board){
			if(strI_board==0){
				frm.action = "/boardWrite"
			}else{
				frm.action = "/boardWrite?i_board="+strI_board;
			}
			
		}
		
		if(`${data.i_board}`!=0){
			document.getElementById("title").value = `${data.title}`;
			document.getElementById("ctnt").value = `${data.ctnt}`;
			document.getElementById("i_student").value = `${data.i_student}`;
			document.getElementById("i_student").readOnly = true;
		}
	</script>
</body>
</html>