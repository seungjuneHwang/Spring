<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>board/board_main.jsp</title>
	<meta charset="utf-8"/>
</head>
<body>
	<h1>${sessionScope.login_bean.user_name }님 환영합니다</h1>
	<c:url var="path" value="/board_write"/>
	<a href="${path }">글쓰기</a><br/>
	<table border="1">
		<tr>
			<td>제목</td>
			<td>작성자</td>
		</tr>
		<c:forEach var="item" items="${requestScope.board_list }">
		<tr>
			<c:url var="path" value="/board_read">
				<c:param name="board_idx" value="${item.board_idx }"/>
			</c:url>
			<td><a href="${path }">${item.board_subject }</a></td>
			<td>${item.board_writer_name }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>











