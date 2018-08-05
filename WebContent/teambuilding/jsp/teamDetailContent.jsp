<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$('document').ready(function(e) {
		$('#leader').click(function(e) {
			$('#leaderForm').submit();
		});
		$('#applyBtn').click(function(e) {
			$('#applyTry').text("지원 취소");
			$('#applyTry2').text("지원 취소");
		});
		$('#closeBtn').click(function(e) {
			$('#closeForm').submit();
		});
	});
</script>
</head>
<body>
	<div class="col-xs-6 col_content team_detail_text_font">
		<div
			class="row team_detail_row team_detail_row_content team_detail_box_content team_detail_main">
			<div class="team_detail_interval row team_detail_row ">
				<div class="col">
					<img class="team_detail_img_big" src="/image/cat.jpg">
				</div>
				<div class="col team_detail_main_text">
					<div>
						<label class="teamDetail">줌바 프로젝트</label>
					</div>
					<div>
						<label>FASTBOOSTER 팀</label>
					</div>
				</div>
				<div class="col team_detail_button_height">
					<div>
						<button type="button"
							class="btn team_detail_btn btn-md team_detail_btn_color">정보
							수정</button>
						<button type="button"
							class="btn team_detail_btn btn-md team_detail_btn_color"
							data-toggle="modal" data-target="#deleteModal"
							style="color: red;">팀 삭제</button>

						<!-- 팀 삭제 모달 -->
						<div class="modal team_detail_modal_font" id="deleteModal">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header team_detail_modal_title">주의</div>
									<!-- Modal body -->
									<div class="modal-body">
										<div class="row team_detail_row_text">팀 삭제시 되돌릴 수 없습니다.</div>
										<div
											class="row team_detail_row_text team_detail_text_color_red">정말
											삭제하시겠습니까?</div>
										<div class="row">
											<button type="button"
												class="btn team_detail_btn btn-mid team_detail_btn_submit team_detail_modal_btn_position"
												data-dismiss="modal">취소</button>
											<button type="button"
												class="btn team_detail_btn btn-mid team_detail_btn_submit team_detail_modal_btn_position"
												data-dismiss="modal">확인</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- 팀 삭제 모달 끝 -->

					</div>
					<!-- 지원자 보기 버튼 -->
					<div>
						<form action="myApplicant.do" method="post">
							<input type="hidden" name="team_id" value="팀아이디"> <input
								type="hidden" name="job" value="myApplicant">
							<button type="submit"
								class="btn team_detail_btn btn-md team_detail_btn_color btn_apply_member"
								id="myApplicants">지원자보기</button>
						</form>
					</div>
					<!-- 지원자 보기 버튼 끝 -->
				</div>
			</div>

			<!-- 팀에 대한 정보 -->
			<div class="row team_detail_row team_detail_leader">
				<form action="/teamwith/polog/jsp/polog.do" method="post"
					id="leaderForm">
					<input type="hidden" name="memberId" value="멤버아이디">
					<div
						class="col team_detail_hover_opacity team_detail_leader_effect">
						<div class="row team_detail_leader_width" id="leader">
							<div class="col">
								<img src="/image/dog.jpg"
									class="rounded-circle team_detail_img_mid">
							</div>
							<div class="col team_detail_button_height">
								<div>팀장 황규진 님</div>
								<div>개발자</div>
							</div>
						</div>
					</div>
				</form>

				<div class="col team_detail_sub">
					<div>로봇/자동차</div>
					<div>대전 &nbsp;&nbsp;&nbsp;모집중&nbsp;&nbsp;&nbsp;D-24</div>
				</div>
			</div>
			<!-- 팀에 대한 정보 끝 -->

			<!-- 지원하기, 모집완료 버튼 -->
			<div class="row team_detail_row team_detail_interval">
				<button type="button"
					class="btn team_detail_btn btn-md team_detail_btn_submit team_detail_btn_center"
					data-toggle="modal" data-target="#applyModal" id="applyTry">지원하기</button>
				<button id="closeBtn" type="button"
					class="btn team_detail_btn btn-md team_detail_btn_submit team_detail_btn_center">모집
					완료</button>
				<form action="./closeTeam.do" method="post" id="closeForm">
					<input type="hidden" value="${requestScope.teamDetailVO.teamId }">
				</form>
			</div>
			<!-- 지원하기, 모집완료 버튼 끝 -->

			<div class="team_detail_row team_detail_content_interval">
				<div class="row team_detail_row_title">팀 개요</div>
				<div class="row team_detail_row_text">teamSummary</div>
			</div>
			<div class="team_detail_row team_detail_content_interval">
				<div class="row team_detail_row_title">팀 소개</div>
				<div class="row team_detail_row_text">requestScope.teamDetailVO.teamContent</div>
			</div>
			<hr class="team_detail_my_hr">
			<div class="team_detail_row team_detail_content_interval">
				<div class="row team_detail_row_title">모집 팀원</div>
				<div class="row team_detail_row_text">모집 역할 :
					applicationScope.roles[recruitRole[1]]</div>
				<div class="row team_detail_row_text">모집 인원 : recruitRole[2]</div>
				<div class="row team_detail_row_text">우대 조건 : recruitRole[3]</div>
				<div class="row team_detail_row_text">역할 설명 : recruitRole[4]</div>
				<div class="row team_detail_row_text">요구 기술 : 기술1 기술2 기술3</div>
			</div>
			<hr class="team_detail_hr">
			<div class="team_detail_row team_detail_content_interval">
				<div class="row team_detail_row_title">공모전 정보</div>
				<div class="row team_detail_row_text">공모전 명:
					requestScope.teamDetailVO.teamContestName</div>
				<div class="row team_detail_row_text">
					공모전 url:&nbsp;&nbsp;<a
						href="requestScope.teamDetailVO.teamContestLink">requestScope.teamDetailVO.teamContestLink</a>
				</div>
			</div>

			<hr class="team_detail_hr">
			<jsp:include page="coworker.jsp" />
			<hr class="team_detail_hr">
			<jsp:include page="faq.jsp" />
			<hr class="team_detail_hr">
			<jsp:include page="recommandedMember.jsp" />
			<hr class="team_detail_hr">
			<jsp:include page="inquiry.jsp" />
			<div class="row team_detail_row team_detail_interval">
				<button type="button"
					class="btn team_detail_btn btn-md team_detail_btn_submit team_detail_btn_center"
					data-toggle="modal" data-target="#applyModal" id="applyTry">지원하기</button>
				<button id="closeBtn" type="button"
					class="btn team_detail_btn btn-md team_detail_btn_submit team_detail_btn_center">모집
					완료</button>
				<form action="./closeTeam.do" method="post" id="closeForm">
					<input type="hidden" value="${requestScope.teamDetailVO.teamId }">
				</form>
			</div>
			<!-- 지원하기 모달 -->
				<div class="modal team_detail_modal_font" id="applyModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header team_detail_modal_title">지원하기</div>
							<!-- Modal body -->
							<div class="modal-body">
								<form action="./apply.do" method="post" id="applyForm">
									<div class="row team_detail_row_text">
										지원 분야 <select class="team_detail_modal_element" id="role" name="role_id">
											<option>개발자
											</option>
											<option>디자이너
											</option>
										</select>
									</div>

									<div class="row team_detail_row_text team_detail_interval">간단면접</div>
									<div class="row team_detail_row_text team_detail_indent">Q:interviewQuestion</div>
									<div class="row team_detail_row_text">
										<textarea class="team_detail_textarea" id="interview_answer" name="interview_answer"></textarea>
									</div>

									<div class="row team_detail_row_text team_detail_content_interval">하고싶은 말</div>
									<div class="row team_detail_row_text">
										<textarea class="team_detail_textarea" id="freewriting" name="application_freewriting"></textarea>
									</div>
									<div class="row">
										<button type="button"
											class="team_detail_btn btn-mid team_detail_btn_submit team_detail_modal_btn_position"
											data-dismiss="modal">취소</button>
										<button type="button" id="applyBtn"
											class="team_detail_btn btn-mid team_detail_btn_submit team_detail_modal_btn_position"
											data-dismiss="modal">확인</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
		</div>
	</div>
	<!-- 내용끝 -->
</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(".btn_apply_member").click(function(e) {
		location.href = "test.jsp";
	})
</script>

</html>