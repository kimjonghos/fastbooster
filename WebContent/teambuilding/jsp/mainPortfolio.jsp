<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="row side_title">
		<div class="col">
			<span class="text_orange">최근</span>
			<span class="text_blue">포트폴리오</span>
		</div>
	</div>
	<div class="row main_portfolio_row_whole">
		<label class="label_no_exist">
			등록된 포트폴리오가 없습니다!
		</label>
	</div>		
	<div class="row main_portfolio_row_whole">
		<form action="portfolioDetail.do" method="post"	id="recentPortfolioForm${recentPortfolio.portfolioId }">
			<div class="col-xs-6 main_portfolio_col" onclick="$('#recentPortfolioForm${recentPortfolio.portfolioId }').submit()">
				<div class="row main_portfolio_row_image">
					<img src="/image/portfolio/portfolio-1.jpg" class="main_portfolio_image">
				</div>
				<div class="row main_portfolio_row_text">
					<div class="row text-truncate main_portfolio_text_name">
						<label class="main_portfolio_label">임경준님</label>
					</div>
					<div class="text-truncate main_portfolio_text_title">
						<label class="main_portfolio_label">포트폴리오 예시 1번</label>
					</div>
				</div>
			</div>
		</form>
		<form action="portfolioDetail.do" method="post"	id="recentPortfolioForm${recentPortfolio.portfolioId }">
			<div class="col-xs-6 main_portfolio_col" onclick="$('#recentPortfolioForm${recentPortfolio.portfolioId }').submit()">
				<div class="row main_portfolio_row_image">
					<img src="/image/portfolio/portfolio-2.jpg" class="main_portfolio_image">
				</div>
				<div class="row main_portfolio_row_text">
					<div class="row text-truncate main_portfolio_text_name">
						<label class="main_portfolio_label">조란님</label>
					</div>
					<div class="text-truncate main_portfolio_text_title">
						<label class="main_portfolio_label">포트폴리오 예시 2번</label>
					</div>
				</div>
			</div>
		</form>			
	</div>
	<button type="button" class="btn btn-md btn_more">더보기</button>
</body>
</html>