<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<body>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<table>
<tr>
<th>OPER_HIST_ID</th>
<th>USR_ID</th>
<th>OPER</th>
<th>IP</th>
<th>OPER_TYPE</th>
<th>CRT_DT</th>
</tr>
<c:forEach var="history" items="${historyList}">
	<tr>
		<td>${history.operationHistoryId}</td>
		<td>${history.userId}</td>
		<td>${history.operation}</td>
		<td>${history.ip}</td>
		<td>${history.createdDate}</td>
		<td>${history.operationType}</td>
	</tr>
</c:forEach>
</table>

<form id="searchHistroyForm">
${page}
<select name="type">
<option value="1" ${searchVO.type eq 1 ? "selected" : ""}>operationHistoryId</option>
<option value="2" ${searchVO.type eq 2 ? "selected" : ""}>userId</option>
<option value="3" ${searchVO.type eq 3 ? "selected" : ""}>operation</option>
<option value="4" ${searchVO.type eq 4 ? "selected" : ""}>ip</option>
<option value="5" ${searchVO.type eq 5 ? "selected" : ""}>createdDate</option>
<option value="6" ${searchVO.type eq 6 ? "selected" : ""}>operationType</option>
</select>
<input type="text" name="keyword" value="${searchVO.keyword}"/>
<input type="button" value="검색" onclick="movePage(0);"/>
</form>

</body>
</html>