<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row main_title">
		<div class="col">
			<span class="text_orange">나의</span>
			<span class="text_blue">팀</span>
		</div>
	</div>
	<div class="row main_row_whole">
		<label class="label_no_exist">
			아직 등록된 팀이 없습니다. 팀을 등록해주세요!
		</label>
	</div>
	<div class="row main_row_whole">
		<form action="teamDetail.do" method="post" id="myTeamForm${myTeam.teamId }">
			<input type="hidden" name="teamId" value="${myTeam.teamId }">
			<div class="col-xs-6 main_content_row" onclick="$('#myTeamForm${myTeam.teamId }').submit()">
				<div class="row main_content">
					<div class="col-xs-6 main_image_col">
						<img src="/image/team/team-1.jpg" class="main_image">
					</div>
					<div class="col-xs-6 main_content_text">
						<div class="row main_text">
							<label class="text-truncate main_text">프로젝트 명 예시입니다.</label>
						</div>
						<div class="row main_text">
							<label class="text-truncate main_text">카테고리 명 예시입니다.</label>
						</div>
						<div class="row main_text">
							<label class="text-truncate main_text main_text_team_name">팀 명 예시입니다.</label>
						</div>
					</div>
				</div>
			</div>			
		</form>
		<form action="teamDetail.do" method="post" id="myTeamForm${myTeam.teamId }">
			<input type="hidden" name="teamId" value="${myTeam.teamId }">
			<div class="col-xs-6 main_content_row" onclick="$('#myTeamForm${myTeam.teamId }').submit()">
				<div class="row main_content">
					<div class="col-xs-6 main_image_col">
						<img src="/image/team/team-2.jpg" class="main_image">
					</div>
					<div class="col-xs-6 main_content_text">
						<div class="row main_text">
							<label class="text-truncate main_text">프로젝트 명 예시입니다.</label>
						</div>
						<div class="row main_text">
							<label class="text-truncate main_text">카테고리 명 예시입니다.</label>
						</div>
						<div class="row main_text">
							<label class="text-truncate main_text main_text_team_name">팀 명 예시입니다.</label>
						</div>
					</div>
				</div>
			</div>			
		</form>		
	</div>
	<div class="row" style="margin: 20px auto">
		<form action="teamRegister.do" method="post">
			<input type="hidden" name="job" value="teamRegister">
			<button type="submit" class="btn btn-md btn_submit">팀 만들기</button>
		</form>
	</div>
</body>
</html>