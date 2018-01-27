<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>board/board_write.jsp</title>
	<meta charset="utf-8"/>
</head>
<body>
	<form action="board_main.jsp" method="post">
		작성자 : 홍길동<br/>
		제목 : <input type="text" id="board_subject" name="board_subject"/><br/>
		내용 : <textarea id="board_content" name="board_content"></textarea><br/>
		<button type="submit">저장하기</button>
		<a href="board_main.jsp">목록</a>
	</form>
</body>
</html>






