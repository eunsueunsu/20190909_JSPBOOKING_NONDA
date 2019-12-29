<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="/Nonda/resource/image/favicon.png"
	type="image/png">
<script src="/Nonda/resource/js/jquery-3.4.1.min.js"></script>
<style>
	<%@ include file="/resource/css/find_id_pwd_css.css"%>
</style>
<title>NONDA_아이디비밀번호찾기</title>
<body>
	<%@ include file="header.jsp"%>

	<section>
	<div class="panel-title-wrapper">
		<div class="panel-title">아이디 찾기</div>
	</div>

	<div class="member-panel member-panel-id">
		<div class="panel-body">
			<div class="member-title">
				NONDA 가입 시 사용한 이름과 휴대폰번호를 입력해주시면 가입한 이메일을 알려드립니다.<br>(단, 소셜
				로그인은 제외)
			</div>
			<div class="form-wrapper">
				<form method="post" action="/Nonda/EmailFindServlet">
					<div class="form-group">
						<div class="content-title-box">
							<div class="sub-title">이름 *</div>
						</div>
						<div class="row">
							<input type="text" class="form-control" placeholder="이름"
								name="mName">
						</div>
					</div>

					<div class="form-group">
						<div class="content-title-box">
							<div class="sub-title">휴대폰번호 *</div>
						</div>
						<div class="row">
							<input type="text" class="form-control" placeholder="- 빼고 입력"
								name="mPhone">
						</div>
					</div>

					<div class="btn_wrap">
						<button class="findid-btn">아이디 찾기</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="panel-title-wrapper">
		<div class="panel-title panel-title-pwd">비밀번호 찾기</div>
	</div>

	<div class="member-panel member-panel-pwd">
		<div class="panel-body">
			<div class="member-title">
				NONDA 가입 시 사용한 이메일, 이름, 휴대폰번호를 입력해주시면 임시 비밀번호를 발송해드립니다.<br>(단,
				소셜 로그인은 제외)
			</div>
			<div class="form-wrapper">
				<form method="post" action="/Nonda/PwFindServlet">
					<div class="form-group">
						<div class="content-title-box">
							<div class="sub-title">이메일(아이디) *</div>
						</div>
						<div class="row">
							<input type="text" class="form-control" placeholder="E-mail"
								name="mId">
						</div>
					</div>

					<div class="form-group">
						<div class="content-title-box">
							<div class="sub-title">이름 *</div>
						</div>
						<div class="row">
							<input type="text" class="form-control" placeholder="이름"
								name="mName">
						</div>
					</div>

					<div class="form-group">
						<div class="content-title-box">
							<div class="sub-title">휴대폰번호 *</div>
						</div>
						<div class="row">
							<input type="text" class="form-control" placeholder="휴대폰번호"
								name="mPhone">
						</div>
					</div>

					<div class="btn_wrap">
						<button class="findid-btn">비밀번호 찾기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>

	<%@ include file="footer.jsp"%>
</body>
</html>