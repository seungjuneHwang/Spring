<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- user/login_fail.jsp --%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="path" value="/"/>
<script>
	alert("로그인에 실패하였습니다");
	location.href = "${path}";
</script>