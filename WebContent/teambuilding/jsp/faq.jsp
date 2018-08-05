<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">


<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$('document').ready(function(e) {
		$('#img').click(function(e) {
			$('#leaderForm').submit();
		});
	});
</script>
<body>
	<div class="team_detail_row team_detail_content_interval">
		<div class="row team_detail_row_title">FAQ</div>
		<c:forEach items="requestScope.faqList " var="faq">
			<div class="row team_detail_row_text team_detail_content_interval">Q: 주로 언제 작업하나요? </div>
			<div class="row team_detail_row_text team_detail_content_interval team_detail_indent">
				<label class="team_detail_indent">팀장 답변 : 아침 9시부터 작업합니다. </label>
			</div>
			<form id="leaderForm" action="./polog.do" method="post">
				<input type="hidden" value="requestScope.teamDetailVO.memberId ">
			</form>
		</c:forEach>
	</div>
</body>
</html>