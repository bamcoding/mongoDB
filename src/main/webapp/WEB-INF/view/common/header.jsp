<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function (){
		
	});
</script>
	<a href="<c:url value="/board"/>">게시판</a>
	<a href="<c:url value="/admin/history"/>">히스토리</a>
	<a href="<c:url value="/myPage"/>">마이페이지</a>
	
	<c:if test="${not empty sessionScope._USER_}">
	<a href="<c:url value="/logOut"/>">로그아웃</a>
	</c:if>
	<hr/>
</head>