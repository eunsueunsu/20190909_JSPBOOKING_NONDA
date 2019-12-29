<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="program.model.vo.*"%>
<%
	
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

</head>
<body>
	<%@ include file="../header.jsp"%>
	<section>

		<div class="outer">
			<form action="<%=request.getContextPath()%>/pInsert.pr" enctype="multipart/form-data" method="post">
				<h2>공연 게시 요청</h2>
				<div class="tableArea">
					<table class="type05">
						<tr>
							<th scope="row">공연명</th>
							<td><input type="text" name="ptitle"></td>
						</tr>
						<tr>
							<th scope="row">장르</th>
							<td><select name="pcategory">
									<option value="exhibit">전시</option>
									<option value="play">공연</option>
									<option value="festival">축제</option>
							</select></td>
						</tr>
						<tr>
							<th scope="row">등급</th>
							<td><select name="pgrade">
									<option value="전체관람가">전체관람가</option>
									<option value="8세 이상">8세 이상</option>
									<option value="만 7세 이상">만 7세 이상</option>
									<option value="만 13세 이상">만 13세 이상</option>
									<option value="중학생이상 관람가">중학생이상 관람가</option>
							</select></td>
						</tr>
						<tr>
							<th scope="row">관람시간</th>
							<td><input type="text" name="ptime"></td>
						</tr>

						<tr>
							<th scope="row">주차가능여부</th>
							<td><select name="pparking">
									<option value="P">유료</option>
									<option value="F">무료</option>
									<option value="X">불가능</option>
							</select></td>
						</tr>

						<tr>
							<th scope="row">지역(도시명)</th>
							<td><input type="text" name="pcity"></td>
						</tr>

						<tr>
							<th scope="row">장소(상세주소)</th>
							<td><input type="text" name="pplace"></td>
						</tr>
						<tr>
							<th scope="row">기간</th>
							<td><input type="date" name="pstartdate"> ~ <input
								type="date" name="penddate"></td>
						</tr>
						<tr>
							<th scope="row">티켓가격</th>
							<td><input type="text" name="pprice"></td>
						</tr>
						<tr>
							<th scope="row">포스터사진</th>
							<td><input type="file" name="pposter" id="pposter"></td>
						</tr>
						<tr>
							<th scope="row">상세정보사진</th>
							<td><input type="file" name="pdetailimg" id="pdetailimg"></td>
						</tr>

					</table>

					<div class=btn-area>
						<input type="submit" value="확인" class="btn-confirm">
					</div>

				</div>
			</form>
		</div>
	</section>
	<%@ include file="../footer.jsp"%>
</body>
</html>