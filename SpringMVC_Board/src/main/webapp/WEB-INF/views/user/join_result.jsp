<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>user/join_result.jsp</title>
</head>
<body>
	회원가입이 완료되었습니다<br/>
	<c:url var="path" value="/"/>
	<a href="${path }">로그인하기</a>
</body>
</html>