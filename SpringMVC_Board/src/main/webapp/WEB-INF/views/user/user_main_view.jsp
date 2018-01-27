<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>user/user_main_view.jsp</title>
	<meta charset="utf-8"/>
</head>
<body>
	<c:url var="path" value="/login_pro"/>
	<form action="${path }" action="post">
		아이디 : <input type="text" id="user_id" name="user_id"/><br/>
		비밀번호 : <input type="password" id="user_pw" name="user_pw"/><br/>
		<button type="submit">로그인</button>
		<c:url var="path" value="/join_main"/>
		<a href="${path }">회원가입</a>
	</form>
</body>
</html>









