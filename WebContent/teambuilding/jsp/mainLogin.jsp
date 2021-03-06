<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<form action="login.do" method="post">
		<div class="row login_row">
			<div class="col-xs-6 login_col_input">
				<div class="row login_row_input">
					<input type="text" name="memberId" placeholder="아이디"	class="login_input">
				</div>
				<div class="row login_row_input">
					<input type="password" name="memberPassword" placeholder="비밀번호" class="login_input">
				</div>
			</div>
			<div class="col-xs-6 login_col_btn">
				<button type="submit" id="login_btn" class="btn btn-md login_btn">로그인</button>
			</div>
		</div>
	</form>
	<div class="row login_row_link">
		<div class="col-xs-4 login_col_register">
			<a href="#" id="register" class="login_col_link">
				<label style="font-size: 20px; cursor: pointer">회원가입</label>
			</a>
		</div>
		<div class="col-xs-8 login_col_find">
			<a href="#" id="find_account" class="login_col_link">
				<label style="cursor: pointer">아이디/비밀번호찾기</label>
			</a>
		</div>
	</div>
</body>
</html>