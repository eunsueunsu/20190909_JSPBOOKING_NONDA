<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String referer = (String) request.getAttribute("referer");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="google-signin-client_id"
	content="811840163877-88dcret6juj73fhuiuk1l3jfc39svv8r.apps.googleusercontent.com">
<link rel="shortcut icon" href="/Nonda/resource/image/favicon.png"
	type="image/png">
<script src="/Nonda/resource/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" charset=UTF-8
	src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
<style>
	<%@ include file="/resource/css/login_css.css"%>
</style>
<title>NONDA_로그인</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<section>
	<div id="loginbox">
		<h1>회원 로그인</h1>

		<form method="post" action="/Nonda/LoginServlet?referer=<%=referer%>">
			<input type="text" id="mid" placeholder="이메일" name="mId"> <input
				type="password" id="mpw" placeholder="비밀번호" name="mPw">
			<button>로그인</button>
		</form>

		<img src="/Nonda/resource/image/googlelogin.png" id="googlelogin">
		<div id="googleSigninButton" style="display: none;"></div>

		<script><%@ include file="/resource/js/login_script.js"%></script>

		<img src="/Nonda/resource/image/naverlogin.PNG" id="naverlogin"
			onclick="">

		<%-- 		<img src="/Nonda/resource/image/naverlogin.PNG" id="naverlogin"
			onclick="location.href='<%=apiURL%>'"> --%>

		<div id="joinbox">
			<p>
				<a href="/Nonda/view/find_id_pwd.jsp">아이디/비밀번호 찾기</a>
			</p>
			<p>
				<a href="/Nonda/view/join.jsp" id="join">회원가입</a> <span
					class="bubble">1000 포인트 즉시 지급</span>
			</p>
		</div>
	</div>
	</section>

	<%@ include file="footer.jsp"%>
</body>
</html>