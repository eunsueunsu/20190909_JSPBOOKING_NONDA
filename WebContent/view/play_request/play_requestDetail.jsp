<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="program.model.vo.*"%>
<%
	Program p = (Program)request.getAttribute("program");
	System.out.println("requestDetail p: " + p);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 확인하기</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
    
    function updateRequest() {
        location.href = "/Nonda/pUpView.pr?pcode="
    }
    
    </script>

<style>
<%@include file="/resource/css/play_request_css/play_requestDetail_css.css"%>
</style>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<section>
		<div class="outer">
		<form action="<%=request.getContextPath() %>/pInsert.pr" enctype="multipart/form-data" method="post" >
			<h2>공연 요청 조회</h2>
			<div class="tableArea">
				<table class="type05">
					<tr>
						<th scope="row">공연명</th>
						<td><label><%=p.getpTitle() %></label></td>
					</tr>
					<tr>
						<th scope="row">장르</th>
						<td><label><%=p.getpCategory() %></label></td>
					</tr>
					<tr>
						<th scope="row">등급</th>
						<td><label><%=p.getpGrade() %></label></td>
					</tr>
					<tr>
						<th scope="row">관람시간</th>
						<td><label><%=p.getpTime() %></label></td>
					</tr>

					<tr>
						<th scope="row">주차가능여부</th>
						<td><label><%=p.getpParking() %></label></td>
					</tr>

					<tr>
						<th scope="row">지역(도시명)</th>
						<td><label><%=p.getpCity()%></label></td>
					</tr>
					<tr>
						<th scope="row">장소(상세주소)</th>
						<td><label><%=p.getpPlace() %></label></td>
					</tr>
					<tr>
						<th scope="row">기간</th>
						<td><label><%=p.getpStartdate() %></label> ~ <label><%=p.getpEnddate() %></label></td>
					</tr>
					<tr>
						<th scope="row">티켓가격</th>
						<td><label><%=p.getpPrice() %></label></td>
					</tr>
					<tr>
						<th scope="row">포스터사진</th>
						<td>
							<a href="/Nonda/pfdown.pr?path=<%=p.getpPoster() %>">
							<%=p.getpPoster() %>
							</a> <br><br>
							<img src="/Nonda/resource/image/program/<%=p.getpPoster()%>" width="200px;">
						</td>
					</tr>
					<tr>
						<th scope="row">상세정보사진</th>
						<td>
							<a href="/Nonda/pfdown.pr?path=<%=p.getpDetail() %>">
							<%=p.getpDetail() %>
							</a> <br><br>
							<img src="/Nonda/resource/image/program/<%=p.getpDetail() %>" width="200px;">
							
						</td>
					</tr>

				</table>

				<div class=btn-area>
					<!-- <input type="submit" value="확인" class="btn-confirm btn">  -->
					<input type="button" value="수정하기" class="btn-updateRequest btn" onclick="location.href = '/Nonda/pUpView.pr?pno=<%=p.getpCode()%>'">
				</div>

			</div>
		</form>
		</div>

	</section>
	<%@ include file="../footer.jsp"%>

</body>
</html>