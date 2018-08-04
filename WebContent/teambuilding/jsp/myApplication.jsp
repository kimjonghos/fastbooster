<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/teambuilding/css/frame.css">
<link rel="stylesheet" href="/teambuilding/css/myApplication.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="home_container">
		<div class="row row_whole">
			<div class="col-xs-6 main_container">
				<!-- 시작 -->
				<div class="col-xs-6 col_container">
						<div class="row my_application_row">
							<div class="text_orange my_application_text_title">
								<h1>나의지원</h1>
							</div>
						</div>
						<div class="row table_whole">
							<table class="table table-hover text-truncate">
								<tr>
									<th>사진</th>
									<th>팀명</th>
									<th>모집분야</th>
									<th>지원날짜</th>
									<th>부가정보</th>
									<th>지원상태</th>
								</tr>
								<tr>
									<td><img src="${myApplication.teamPic }" class="rounded-circle" width="40" height="40"></td>
									<td>팀명입력</td>
									<td>모집분야입력</td>
									<td>지원날짜입력</td>
									<td><button type="button" class="btn btn_color btn_kyu" data-toggle="modal" data-target="#myModal${status.index }">보기</button></td>
									<td>지원상태입력</td>
								</tr>
							</table>
						</div>
						<div>
							<span>지원 내역이 없습니다.</span>
						</div>
				</div>
			</div>
			<div class="modal" id="myModal${status.index }">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header text_orange">간단면접</div>
						<div class="modal-body">
							<div class="row">매일 아침 7시부터 프로젝트 진행하는데 괜찮으세요?</div>
							<div class="row">
								<div class="col"></div>
								<div class="col-12">A:당연하죠</div>
							</div>
						</div>
						<div class="modal-header text_orange">하고싶은 말</div>
						<div class="modal-body">제발 저 좀 써주세요..</div>
						<div class="modal-footer">
							<button type="button" class="btn" data-dismiss="modal">확인</button>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 side_container">
				<div class="row side_row_whole">
					<jsp:include page="mainLogin.jsp" />
				</div>
				<div class="row side_row_whole">
					<jsp:include page="mainProfile.jsp" />
				</div>
				<div class="row side_row_whole">
					<jsp:include page="mainPortfolio.jsp" />
				</div>
			</div>
		</div>
		<div class="row row_whole">
			<jsp:include page="footer.jsp" />
		</div>
	</div>
</body>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/teambuilding/js/frame.js"></script>
</html>