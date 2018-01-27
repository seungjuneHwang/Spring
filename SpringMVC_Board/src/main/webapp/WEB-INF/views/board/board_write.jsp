<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>board/board_write.jsp</title>
	<meta charset="utf-8"/>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		function add_board(){
			// 파라미터 셋팅
			var param = {
				board_subject : $("#board_subject").val(),
				board_content : $("#board_content").val()
			};
			
			<c:url var="path1" value="/board_write_pro"/>
			<c:url var="path2" value="/board_main"/>
			$.ajax({
				url : "${path1}",
				type : "post",
				dataType : "text",
				data : param,
				success : function(a){
					if(a.trim() == "OK"){
						alert("저장되었습니다");
						location.href="${path2}";
					}
				}
			});
			
			return false;
		}
	</script>
</head>
<body>
	<form onsubmit="return add_board()">
		작성자 : ${sessionScope.login_bean.user_name }<br/>
		제목 : <input type="text" id="board_subject" name="board_subject"/><br/>
		내용 : <textarea id="board_content" name="board_content"></textarea><br/>
		<button type="submit">저장하기</button>
		<c:url var="path" value="/board_main"/>
		<a href="${path }">목록</a>
	</form>
</body>
</html>






