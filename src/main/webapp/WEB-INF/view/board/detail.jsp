<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<script type="text/javascript">
	function onClick() {
		if(${sessionScope._USER_.point}>=3){		
			<c:choose>
				<c:when test="${sessionScope._USER_.userId eq board.userId}">
					location.href="<c:url value="/viewFile/${board.boardId}" />";
				</c:when>
				<c:otherwise>
					if(confirm("다운로드를 하면 3포인트가 차감 됩니다. 다운로드 하시겠습니까?")){
						location.href="<c:url value="/viewFile/${board.boardId}" />";
					}
				</c:otherwise>
			</c:choose>
		}
	}
	
	$(document).ready(function(){
		$("body").on("click","#replyBtn",function(){
			$.post( "<c:url value="/addReply/${board.boardId }"/>"
					, $("#replyForm").serialize()
					, function(data){
				
				var form = $("#formDiv");
				$(form).remove();
				$("#replies").before(form);
				$("#parentReplyId").val("0");
				$("#reply").val("");
				
				$("#replies").html("");
				
				var reply = null;
				for(var i = 0; i < data.length; i++) {
					reply = $("#replyFormat");
					$(reply).find(".nickName").text(data[i].user.userNickName);
					$(reply).find(".date").text(data[i].createdDate);
					$(reply).find(".replyContent").text(data[i].reply);
					$("#replies").append($(reply).html()); //replies에 있는 테이블들을 추가시킨다
					$("#replies").find("table").last().css("margin-left", ((data[i].level - 1) * 50) + "px");
					$("#replies").find("table").last().data("replyid", data[i].replyId);//data - ___ 
					
				}
			});
		});
		
		$("#replies").on("click", "table", function() {
			console.log($(this).data("replyid"));
			$("#parentReplyId").val($(this).data("replyid"));
			var form = $("#formDiv");
			$(form).remove();
			$(this).after(form);
		});
		
		$.post( "<c:url value="/reply/${board.boardId }"/>"
				, {}
				, function(data){
			console.log(data);
			console.log(data.length);
			console.log(data[0].reply);//댓글만 알고싶을때
			console.log(data[0].user);//유저정보를 알고싶을때
			
			var reply = null;
			for(var i = 0; i < data.length; i++) {
				reply = $("#replyFormat");
				$(reply).find(".nickName").text(data[i].user.userNickName);
				$(reply).find(".date").text(data[i].createdDate);
				$(reply).find(".replyContent").text(data[i].reply);
				$("#replies").append($(reply).html()); //replies에 있는 테이블들을 추가시킨다
				$("#replies").find("table").last().css("margin-left", ((data[i].level - 1) * 30) + "px");
				$("#replies").find("table").last().data("replyid", data[i].replyId);//data - ___ 
				
			}
		});
	});
		
	
</script>
<body>
	<table>
		<tr>
			<td colspan="4">제목 : ${board.subject}</td>
		</tr>
		<tr>
			<td>글쓴이: ${board.user.userNickName}</td>
			<td>작성 날짜: ${board.createdDate }</td>
			<td>조회수: ${board.hit }</td>
			<td>추천수: ${board.recommend }</td>
			<c:if test="${not empty board.displayFileName}">
			<td>파일:<a href="javascript:void(0);" onclick="onClick()">${board.displayFileName}</a></td>
			</c:if>
		</tr>
		<tr>
			<td colspan="4">내용: ${board.content }</td>
		</tr>
	</table>
	<c:if test="${sessionScope._USER_.userId eq board.userId}">
		<input type="button" value="삭제하기" onclick="location.href='<c:url value="/delete/${board.boardId}" />'"/>
	</c:if>
	<input type="button" value="목록보기" onclick="location.href='<c:url value="/board" />'" />
	<hr/>
	<댓글>
	<div id="formDiv">
		<form id="replyForm" name="replyForm" method="post">
			<input type="hidden" id="parentReplyId" name="parentReplyId" value="0" />
			<input type="hidden" id="userId" name="userId" value="${sessionScope._USER_.userId }" readonly="readonly"/>
			<label for="reply">내용</label> 
			<input type="text" id="reply" name="reply" />
			<input type="button" id="replyBtn" value="등록"><br/><br/>
		</form>
	</div>
	
	<div id="replies">
		
	</div>
	
	<div id="replyFormat" style="display: none;">
		<table>
			<tr class="reply">
				<td><span class="nickName"></span></td>
				<td><span class="date"></span><td/>
				<td><span class="replyContent"></span></td>
			</tr>
		</table>	
	</div>
</body>
</html>