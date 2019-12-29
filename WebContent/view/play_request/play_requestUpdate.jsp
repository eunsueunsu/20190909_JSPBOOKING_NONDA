<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="program.model.vo.*"%>
<%
	Program p = (Program)request.getAttribute("program");
	System.out.println("requestUpdate p: " + p);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 확인하기</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	
</script>

<style>
<%@include file ="/resource/css/play_request_css/play_requestDetail_css.css"%>
</style>

<style>
.btn-confirm {
	width: 120px;
	height: 40px;
	border: 1px solid rgb(185, 183, 183);
}
</style>


<script>
	$(function() {
		$("#pcategory").val($(hdCategory).val()).attr("selected","selected");
		$("#pgrade").val($(hdGrade).val()).attr("selected","selected");
		$("#pparking").val($(hdParking).val()).attr("selected","selected");
	});

</script>

</head>
<body>
	<%@ include file="../header.jsp"%>
	<section>
		<input type="hidden" id="hdCategory" value=<%=p.getpCategory() %>>
		<input type="hidden" id="hdGrade" value=<%=p.getpGrade() %>>
		<input type="hidden" id="hdParking" value=<%=p.getpParking() %>>
	

		<div class="outer">
			<form action="<%=request.getContextPath()%>/pUpdate.pr?pno=<%=p.getpCode() %>" method="post" enctype="multipart/form-data">
				<h2>공연 수정 요청</h2>
				<div class="tableArea">
					<table class="type05">
						<tr>
							<th scope="row">공연명</th>
							<td><input type="text" name="ptitle" value=<%=p.getpTitle() %>></td>
						</tr>
						<tr>
							<th scope="row">장르</th>
							<td><select name="pcategory" id="pcategory">
									<option value="exhibit" id="exhibit">전시</option>
									<option value="play" id="play">공연</option>
									<option value="festival" id="festival">축제</option>
							</select></td>
						</tr>
						<tr>
							<th scope="row">등급</th>
							<td><select name="pgrade" id="pgrade">
								<option value="전체관람가">전체관람가</option>
								<option value="8세 이상">8세 이상</option>
								<option value="만 7세 이상">만 7세 이상</option>
								<option value="만 13세 이상">만 13세 이상</option>
								<option value="중학생이상 관람가">중학생이상 관람가</option>
							</select></td>
						</tr>
						<tr>
							<th scope="row">관람시간</th>
							<td><input type="text" name="ptime" value=<%=p.getpTime() %>></td>
						</tr>

						<tr>
							<th scope="row">주차가능여부</th>
							<td><select name="pparking" id="pparking">
									<option value="P">유료</option>
									<option value="F">무료</option>
									<option value="X">불가능</option>
							</select></td>
						</tr>

						<tr>
							<th scope="row">지역(도시명)</th>
							<td><input type="text" name="pcity" value=<%=p.getpCity() %>></td>
						</tr>

						<tr>
							<th scope="row">장소(상세주소)</th>
							<td><input type="text" name="pplace" value=<%=p.getpPlace() %>></td>
						</tr>
						<tr>
							<th scope="row">기간</th>
							<td><input type="date" name="pstartdate" value=<%=p.getpStartdate() %>> ~ <input
								type="date" name="penddate" value=<%=p.getpEnddate() %>></td>
						</tr>
						<tr>
							<th scope="row">티켓가격</th>
							<td><input type="text" name="pprice" value=<%=p.getpPrice() %>></td>
						</tr>
						<tr>
							<th scope="row">포스터사진</th>
							<td><input type="file" name="pposter" id="pposter">
								<%=p.getpPoster() %><br>
								<img src="/Nonda/resource/image/program/<%=p.getpPoster()%>" width="200px;">
							</td>
						</tr>
						<tr>
							<th scope="row">상세정보사진</th>
							<td>
							<input type="file" name="pdetailimg" id="pdetailimg">
							<%=p.getpDetail() %>
							</td>
						</tr>

					</table>
					
					<input type="hidden" name="hdPoster" value=<%=p.getpPoster() %>>
					<input type="hidden" name="hdDetail" value=<%=p.getpDetail() %>>

					<div class=btn-area>
						<%-- <input type="button" value="확인(수정하기)" class="btn-confirm" onclick="location.href= 'pUpdate.pr?pno=<%=p.getpNum() %>'" > --%>
						<input type="submit" value="확인(수정하기)" class="btn-confirm">
					</div>

				</div>
			</form>
		</div>
	</section>
	<%@ include file="../footer.jsp"%>
</body>
</html>