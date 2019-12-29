<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Member m = (Member) session.getAttribute("member"); // 로그인 정보
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/Nonda/resource/js/header_script.js"></script>
<style>
	<%@ include file="/resource/css/header_css.css"%>
</style>
</head>
<body>
	<header>
	<div id="logobar">
		<a href="/Nonda/view/main.jsp"><img
			src="/Nonda/resource/image/logo1.png" id="logo"></a>

		<%
			if (m == null) { // 로그인 X -> 로그인/회원가입
		%>
		<p>
			<a href="/Nonda/login.do">로그인/회원가입</a>
		</p>
		<%
			} else { // 로그인 O -> 이름&로그아웃 버튼
		%>
		<p>
			<%
				if (m.getmAccess().equals("company")) {
			%>
			<a href="/Nonda/view/mypage_company.jsp" id="loginname"><%=m.getmName()%>
				님</a>
			<%
				} else if (m.getmAccess().equals("admin")) {
			%>
			<a href="/Nonda/view/mypage_admin.jsp" id="loginname"><%=m.getmName()%>
				님</a>
			<%
				} else {
			%>
			<a href="/Nonda/view/mypage.jsp" id="loginname"><%=m.getmName()%>
				님</a>
			<%
				}
			%>
			<img src="/Nonda/resource/image/logout.jpg"
				onclick="location.href='/Nonda/LogoutServlet'">
		</p>
		<%
			}
		%>
	</div>

	<div id="menubar">
		<ul>
			<li><a href="/Nonda/view/about.jsp">ABOUT</a></li>
			<li><a href="#">ALL PROGRAMS</a></li>
			<li><a href="#">REVIEW</a></li>
			<li><a href="#">NOTICE</a></li>
		</ul>

		<div>
			<form method="GET" action="/Nonda/view/totalsearch.jsp"
				name="totalsearch" onsubmit="return check()">
				<input type="text" placeholder="검색어 입력" id="block" name="kWord">
				<input type="submit" value="검색" id="btn">
			</form>
		</div>
	</div>
	</header>
</body>
</html>