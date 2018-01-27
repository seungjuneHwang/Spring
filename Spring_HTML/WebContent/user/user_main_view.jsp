<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>user/user_main_view.jsp</title>
	<meta charset="utf-8"/>
</head>
<body>
	<form action="../board/board_main.jsp" action="post">
		아이디 : <input type="text" id="user_id" name="user_id"/><br/>
		비밀번호 : <input type="password" id="user_pw" name="user_pw"/><br/>
		<button type="submit">로그인</button>
		<a href="join_main.jsp">회원가입</a>
	</form>
</body>
</html>









