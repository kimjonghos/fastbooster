<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="row profile_row_pic">
		<img src="/image/member/yimkyungjun.jpg" class="profile_pic">
	</div>
	<div class="row profile_info">
		<div class="profile_text_name">임경준</div>
		<form action="login.do" method="post">
			<input type="hidden" name="job" value="logout">
			<button type="submit" class="btn_logout">로그아웃</button>
		</form>
	</div>
	<div class="row profile_row">
		<div class="col-xs-4 profile_col">
			<label class="profile_label">알림</label>
		</div>

		<div class="col-xs-4 profile_col">
			<label class="profile_label">나의 지원</label>
		</div>

		<div class="col-xs-4 profile_col">
			<label class="profile_label">나의 팀</label>
		</div>
	</div>
	<div class="row profile_row">
		<div class="col-xs-4 profile_col">
			<button type="button" class="btn btn-md btn_profile">0</button>
		</div>
		<div class="col-xs-4 profile_col">
			<form action="myApplication.do" method="post">
				<input type="hidden" name="memberId" value="${sessionScope.memberBean.memberId }">
				<input type="hidden" name="job" value="myApplication">
				<button type="submit" id="my_application" class="btn btn-md btn_profile">0</button>
			</form>
		</div>
		<div class="col-xs-4 profile_col">
			<form action="myTeam.do" method="post">
				<input type="hidden" name="memberId" value="kyujin1">
				<button type="submit" class="btn btn-md btn_profile">2</button>
			</form>
		</div>
	</div>
	<div class="row profile_row profile_row_btn">
		<form action="/teamwith/polog/jsp/polog.do" method="post">
			<input type="hidden" name="memberId" value="${sessionScope.memberBean.memberId }">
			<button type="submit" class="btn btn-md btn_submit">나의 폴로그</button>
		</form>
	</div>
</body>
</html>