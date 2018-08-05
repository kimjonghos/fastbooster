<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$('document').ready(function(e) {
		$('#inquiryAddBtn').click(function(e) {
			$('#addInquiryForm').submit();
		});
	});
</script>
</head>
<body>
	<div class="team_detail_row team_detail_content_interval">
		<div class="row team_detail_row team_detail_row_title">문의하기</div>
		<!--  댓글 입력 창 -->
		<div class="row team_detail_row team_detail_row_text team_detail_content_interval">
			<img src="/image/rabbit.jpg"
				class="rounded-circle team_detail_img_small"> <label class="team_detail_img_small_text">토깽이 </label>
			<form id="addInquiryForm" action="./addInquiry.do" method="post">
				<input class="comment_input" type="text" name="inquiry_content">
			</form>
			<button id="inquiryAddBtn" type="button"
				class="btn team_detail_btn btn-md team_detail_btn_color comment_btn_position">등록</button>
		</div>
		<!-- 댓글 보기 화면 -->
		<div class="team_detail_row team_detail_content_interval">
			<hr class="team_detail_my_hr">
			<c:forEach items="requestScope.inquiryMemberList "
				var="inquiryMember">
				<!-- 단일 댓글 -->
				<div class="row team_detail_row team_detail_row_text team_detail_content_interval">
					<!-- 작성자 사진 -->
					<img src="/image/cat.jpg "
						class="rounded-circle team_detail_img_small">&nbsp;&nbsp;
					<!-- 작성자 이름 -->
					<label class="inquiry_line_height">고양이
					</label>&nbsp;&nbsp;
					<!-- 댓글 내용 -->
					<label class="inquiry_line_height">냐옹~~
					</label>&nbsp;&nbsp;
					<!-- 작성 시간 -->
					<label class="inquiry_line_height">2018-08-05 </label>&nbsp;&nbsp;
					<!-- 대댓글 작성 입력칸 보이게 하는 버튼 -->
					<button class="btn btn-link btn-sm inquiry_btn_height"
						type="button">답글달기</button>
					<c:if
						test="inquiryMember.memberId eq sessionScope.memberBean.memberId ">
						<!-- 글쓴이가 로그인 세션 아이디와 일치한다면 수정버튼을 보이게 만든다. -->
						<button class="btn btn-link btn-sm inquiry_btn_height"
							type="button">수정</button>
						<!-- 글쓴이가 로그인 세션 아이디와 일치한다면 삭제버튼을 보이게 만든다. -->
						<button class="btn btn-link btn-sm inquiry_btn_height"
							type="button">삭제</button>
					</c:if>
				</div>

				<!-- 대댓글 -->
				<c:forEach items="requestScope.replyList " var="replyAry">
					<c:if test={not emptyreplyAry ">
						<c:forEach items="replyAry " var="reply">
							<c:if test="reply.inquiryId == inquiryMember.inquiryId">
								<div class="row team_detail_row team_detail_row_text team_detail_content_interval">
									<!-- 작성자 사진 -->
									&nbsp;&nbsp;<label class="comment_comment_logo">ㄴ</label>&nbsp;<img
										src="/image/dog.jpg " class="rounded-circle team_detail_img_small"> &nbsp;&nbsp;
									<!-- 작성자 이름 -->
									<label class="inquiry_line_height">개
										(팀장)</label>&nbsp;&nbsp;
									<!-- 대댓글 내용 -->
									<label class="inquiry_line_height">멍멍! </label>&nbsp;&nbsp;
									<!-- 글쓴이가 로그인 세션 아이디와 일치한다면 수정버튼을 보이게 만든다. -->
									<c:if
										test="reply.memberId eq sessionScope.memberBean.memberId ">
										<button class="btn btn-link btn-sm inquiry_btn_height"
											type="button">수정</button>
										<!-- 글쓴이가 로그인 세션 아이디와 일치한다면 삭제버튼을 보이게 만든다. -->
										<button class="btn btn-link btn-sm inquiry_btn_height"
											type="button">삭제</button>
									</c:if>
								</div>
							</c:if>
						</c:forEach>
					</c:if>
				</c:forEach>
			</c:forEach>
		</div>
	</div>
</body>
</html>