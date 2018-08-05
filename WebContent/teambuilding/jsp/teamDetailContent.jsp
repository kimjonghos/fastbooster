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
		<div class="row team_detail_row team_detail_row_content team_detail_box_content"
			style="margin: auto; padding: 20px; text-align: center;">
			<div class="row team_detail_row" style="margin-top: 30px; margin-bottom: 30px;">
				<div class="col">
					<img src="/image/cat.jpg" width="150" height="150">
				</div>
				<div class="col" style="line-height: 50px; font-size: 25px;">
					<div>
						<label class="teamDetail">줌바 프로젝트</label>
					</div>
					<div>
						<label>FASTBOOSTER 팀</label>
					</div>
				</div>
				<div class="col" style="line-height: 50px;">
					<div>
						<button type="button" class="btn team_detail_btn btn-md team_detail_btn_color">정보 수정</button>
						<button type="button" class="btn team_detail_btn btn-md team_detail_btn_color"
							data-toggle="modal" data-target="#myModal0" style="color: red;">팀
							삭제</button>
						
						<!-- 팀 삭제 모달 -->
						<div class="modal" id="myModal0" style="font-size: 25px;">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header"
										style="color: #ff4111; text-align: center">주의</div>
									<!-- Modal body -->
									<div class="modal-body">
										<div class="row team_detail_row_text">팀 삭제시 되돌릴 수 없습니다.</div>
										<div class="row team_detail_row_text team_detail_text_color_red">정말 삭제하시겠습니까?</div>
										<div class="row">
											<button type="button" class="btn team_detail_btn btn-mid team_detail_btn_submit"
												data-dismiss="modal"
												style="margin-left: 70px; margin-bottom: 20px; margin-top: 30px;">취소</button>
											<button type="button" class="btn team_detail_btn btn-mid team_detail_btn_submit"
												data-dismiss="modal"
												style="margin-left: 70px; margin-bottom: 20px; margin-top: 30px;">확인</button>
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
								class="btn team_detail_btn btn-md team_detail_btn_color btn_apply_member" id="myApplicants">지원자보기</button>
						</form>
					</div>
					<!-- 지원자 보기 버튼 끝 -->
				</div>
			</div>
			
			<!-- 팀에 대한 정보 -->
			<div class="row team_detail_row" style="margin-top: 30px; background-color: #e6f2ff;">
				<form action="/teamwith/polog/jsp/polog.do" method="post"
					id="leaderForm">
					<input type="hidden" name="memberId" value="멤버아이디">
					<div class="col team_detail_hover_opacity"
						style="border: none; cursor: pointer;">
						<div class="row" style="width: 300px;" id="leader">
							<div class="col">
								<img src="/image/dog.jpg" class="rounded-circle" width="100px"
									height="100px">
							</div>
							<div class="col" style="line-height: 50px">
								<div>팀장 황규진 님</div>
								<div>개발자</div>
							</div>
						</div>
					</div>
				</form>

				<div class="col" style="line-height: 50px; background-color: #ffebcc;">
					<div>로봇/자동차</div>
					<div>대전 &nbsp;&nbsp;&nbsp;모집중&nbsp;&nbsp;&nbsp;D-24</div>
				</div>
			</div>
			<!-- 팀에 대한 정보 끝 -->
			
			<!-- 지원하기, 모집완료 버튼 -->
			<div class="row team_detail_row" style="margin-top: 30px;">
				<button type="button" class="btn team_detail_btn btn-md team_detail_btn_submit"
					data-toggle="modal" data-target="#myModal1" style="margin: auto;"
					id="applyTry">지원하기</button>
				<button id="closeBtn" type="button" class="btn team_detail_btn btn-md team_detail_btn_submit"
					style="margin: auto;">모집 완료</button>
				<form action="./closeTeam.do" method="post" id="closeForm">
					<input type="hidden" value="${requestScope.teamDetailVO.teamId }">
				</form>
			</div>
			<!-- 지원하기, 모집완료 버튼 끝 -->

			<div class="team_detail_row" style="margin-top: 20px;">
				<div class="row team_detail_row_title">팀 개요</div>
				<div class="row team_detail_row_text">teamSummary</div>
			</div>
			<div class="team_detail_row" style="margin-top: 20px;">
				<div class="row team_detail_row_title">팀 소개</div>
				<div class="row team_detail_row_text">requestScope.teamDetailVO.teamContent</div>
			</div>
				<hr class="team_detail_my_hr">
				<div class="team_detail_row" style="margin-top: 20px;">
					<div class="row team_detail_row_title">모집 팀원</div>
					<div class="row team_detail_row_text">모집 역할 :
						applicationScope.roles[recruitRole[1]] </div>
					<div class="row team_detail_row_text">모집 인원 : recruitRole[2] </div>
					<div class="row team_detail_row_text">우대 조건 : recruitRole[3] </div>
					<div class="row team_detail_row_text">역할 설명 : recruitRole[4] </div>
					<div class="row team_detail_row_text">
						요구 기술 : 기술1  기술2  기술3
					</div>
				</div>
			<hr class="team_detail_hr">
			<div class="team_detail_row" style="margin-top: 20px;">
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
			<div class="row team_detail_row" style="margin-top: 30px;">
						<button type="button" class="btn team_detail_btn btn-md team_detail_btn_submit"
							data-toggle="modal" data-target="#myModal1" style="margin: auto;"
							id="applyTry2">지원하기</button>
						<!-- loginID가 팀장 ID와 일치하는 경우 -->
						<button type="button" class="btn team_detail_btn btn-md team_detail_btn_submit"
							style="margin: auto;">모집 완료</button>
			</div>
			<div class="row" style="margin: auto; margin-top: 50px;">
				<div class="modal" id="myModal1" style="font-size: 25px;">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header" style="color: #ff4111;">지원하기</div>
							<!-- Modal body -->
							<div class="modal-body">
								<form action="./apply.do" method="post" id="applyForm">
									<div class="row team_detail_row_text">
										지원 분야 <select id="role" name="role_id"
											style="margin-left: 20px;">
												<option>applicationScope.roles[recruitRoleValue[1]] </option>
												<option>applicationScope.roles[recruitRoleValue[2]] </option>
										</select>
									</div>

									<div class="team_detail_row team_detail_row_text" style="margin-top: 30px;">간단면접</div>
										<div class="row team_detail_row_text" style="margin-left: 35px;">Q:interviewQuestion </div>
										<div class="row team_detail_row_text">
											<textarea id="interview_answer" name="interview_answer"
												style="margin-left: 35px; width: 300px;"></textarea>
										</div>

									<div class="team_detail_row team_detail_row_text" style="margin-top: 30px">하고싶은 말
									</div>
									<div class="team_detail_row team_detail_row_text">
										<textarea id="freewriting" name="application_freewriting"
											style="margin-left: 35px; width: 300px;"></textarea>
									</div>
									<div class="team_detail_row">
										<button type="button" class="team_detail_btn btn-mid team_detail_btn_submit"
											data-dismiss="modal"
											style="margin-left: 60px; margin-bottom: 20px; margin-top: 30px;">취소</button>
										<button type="button" id="applyBtn"
											class="team_detail_btn btn-mid team_detail_btn_submit"
											style="margin-left: 60px; margin-bottom: 20px; margin-top: 30px;"
											data-dismiss="modal">확인</button>
									</div>
								</form>
							</div>
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