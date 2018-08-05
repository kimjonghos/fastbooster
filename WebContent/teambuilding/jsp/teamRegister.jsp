<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/teambuilding/css/frame.css">
<link rel="stylesheet" href="/teambuilding/css/teamRegister.css">

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="home_container">
		<div class="row row_whole">
			<div class="col-xs-6 main_container">
				<div class="row main_row">
					<jsp:include page="teamRegisterForm.jsp" />
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