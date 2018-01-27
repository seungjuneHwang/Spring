<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>board/board_read.jsp</title>
	<meta charset="utf-8"/>
</head>
<body>
	작성자 : ${requestScope.board_bean.board_writer_name }<br/>
	제목 : ${requestScope.board_bean.board_subject }<br/>
	내용 : ${requestScope.board_bean.board_content }<br/>
	<c:url var="path" value="/board_main"/>
	<a href="${path }">목록</a>
</body>
</html>