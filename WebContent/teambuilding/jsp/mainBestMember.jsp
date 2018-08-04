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
			<span class="text_orange">우수</span>
			<span class="text_blue">회원</span>
		</div>
	</div>
	<div class="row main_row_whole">
		<label class="label_no_exist">
			아직 등록된 회원이 없습니다!
		</label>
	</div>	
	<div class="row best_member_row_whole">
		<form action="/teamwith/polog/jsp/polog.do" method="post" id="bestMemberForm${bestMember.memberId }">
			<input type="hidden" name="memberId" value="${bestMember.memberId }">
			<div class="col-xs-6 main_content_col" onclick="$('#bestMemberForm${bestMember.memberId }').submit()">
				<div class="row member_image_row">
					<img src="/image/member/joran.jpg" class="member_image">
				</div>
				<div class="row member_content_text">
					<div class="row member_text">
						<label class="member_text">조란님</label>
					</div>
					<div class="row member_text">
						<label class="member_text member_praise_text">425회 칭찬</label>
					</div>
				</div>
			</div>
		</form>
		<form action="/teamwith/polog/jsp/polog.do" method="post" id="bestMemberForm${bestMember.memberId }">
			<input type="hidden" name="memberId" value="${bestMember.memberId }">
			<div class="col-xs-6 main_content_col" onclick="$('#bestMemberForm${bestMember.memberId }').submit()">
				<div class="row member_image_row">
					<img src="/image/member/kimjongseung.jpg" class="member_image">
				</div>
				<div class="row member_content_text">
					<div class="row member_text">
						<label class="member_text">김종승님</label>
					</div>
					<div class="row member_text">
						<label class="member_text member_praise_text">410회 칭찬</label>
					</div>
				</div>
			</div>
		</form>		
		<form action="/teamwith/polog/jsp/polog.do" method="post" id="bestMemberForm${bestMember.memberId }">
			<input type="hidden" name="memberId" value="${bestMember.memberId }">
			<div class="col-xs-6 main_content_col" onclick="$('#bestMemberForm${bestMember.memberId }').submit()">
				<div class="row member_image_row">
					<img src="/image/member/hwangkyujin.jpg" class="member_image">
				</div>
				<div class="row member_content_text">
					<div class="row member_text">
						<label class="member_text">황규진님</label>
					</div>
					<div class="row member_text">
						<label class="member_text member_praise_text">388회 칭찬</label>
					</div>
				</div>
			</div>
		</form>	
		<form action="/teamwith/polog/jsp/polog.do" method="post" id="bestMemberForm${bestMember.memberId }">
			<input type="hidden" name="memberId" value="${bestMember.memberId }">
			<div class="col-xs-6 main_content_col" onclick="$('#bestMemberForm${bestMember.memberId }').submit()">
				<div class="row member_image_row">
					<img src="/image/member/yimkyungjun.jpg" class="member_image">
				</div>
				<div class="row member_content_text">
					<div class="row member_text">
						<label class="member_text">임경준님</label>
					</div>
					<div class="row member_text">
						<label class="member_text member_praise_text">320회 칭찬</label>
					</div>
				</div>
			</div>
		</form>					
	</div>
</body>
</html>