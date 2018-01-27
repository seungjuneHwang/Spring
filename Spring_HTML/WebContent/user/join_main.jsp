<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>user/join_main.jsp</title>
	<meta charset="utf-8"/>
</head>
<body>
	<form action="join_result.jsp">
		아이디 : <input type="text" id="user_id" name="user_id"/><br/>
		비밀번호 : <input type="password" id="user_pw" name="user_pw"/><br/>
		이름 : <input type="text" id="user_name" name="user_name"/><br/>
		<button type="submit">가입</button>
		<a href="user_main_view.jsp">취소</a>
	</form>
</body>
</html>








