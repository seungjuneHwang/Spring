<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>user/join_main.jsp</title>
	<meta charset="utf-8"/>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		function add_user(){
			// 입력한 내용을 추출
			var user_id = $("#user_id").val();
			var user_pw = $("#user_pw").val();
			var user_name = $("#user_name").val();
			// 서버로 보낼 파라미터 데이터를 담은 객체
			var param = {
				user_id : user_id,
				user_pw : user_pw,
				user_name : user_name
			};
			<c:url var="path1" value="/join_pro"/>
			<c:url var="path2" value="/join_result"/>
			$.ajax({
				url : "${path1}",
				type : "post",
				dataType : "text",
				data : param,
				success : function(a){
					if(a.trim() == "OK"){
						location.href = "${path2}";
					}
				}
			});
			
			return false;
		}
	</script>
</head>
<body>
	<form onsubmit="return add_user()">
		아이디 : <input type="text" id="user_id" name="user_id"/><br/>
		비밀번호 : <input type="password" id="user_pw" name="user_pw"/><br/>
		이름 : <input type="text" id="user_name" name="user_name"/><br/>
		<button type="submit">가입</button>
		<c:url var="path" value="/"/>
		<a href="${path }">취소</a>
	</form>
</body>
</html>








