<%@page import="review.model.vo.Review"%>
<%@page import="booking.model.vo.Booking"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 
	//ArrayList<Review> rlist = (ArrayList<Review>)request.getAttribute("rlist"); 
	//System.out.println("rlist: " + rlist);
	
	//ArrayList<Booking> blist = (ArrayList<Booking>)request.getAttribute("blist");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/Nonda/resource/js/jquery-3.4.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="shortcut icon" href="/Nonda/resource/image/favicon.png"
	type="image/png">
<script src="/Nonda/resource/js/mypage_script.js?ver=3"></script>
<style>
<%@include file="/resource/css/mypage_company_css.css"%>
</style>
<title>NONDA_업체_마이페이지</title>

<script>

$(document).ready(function () {
	var $items = $('ul.tabs li');

	$items.click(function () {
		var tab_id = $(this).attr('data-tab');
		console.log(tab_id);
		
		$items.removeClass('current');
		$('.tab-content').removeClass('current');

		$(this).addClass('current');
		$("#" + tab_id).addClass('current')
		
	});
	
	
});

// 마우스 오버시 색변경 이벤트
$(function() {
	window.name="parentPage";  // 윈도우의 이름 설정(팝업창에서 부모페이지로 돌아오기 위해)
	
	//td에 마우스 오버시 색 변경
	$(".tdclass").mouseenter(function(){
		$(this).parent().css({"background":"#E6E6E6", "cursor":"pointer"});
	}).mouseout(function(){
		$(this).parent().css({"background":"white"});
	});
	
});
	
	
// 문의내역 탭 클릭
function tab2Click() {

	console.log("2번 클릭");

	$.ajax({
		type : 'GET',
		url : "/Nonda/selectMyplay.qna",
		success : function(data) {
			console.log("qna selectmyplay ajax 성공");
			console.log(data);

			var $table = $('#tbQna tbody'); // review 테이블에 내용 추가

			$('#tbQna tbody *').remove();

			for ( var i in data) {
				// 내용을 담은 tr 태그 생성
				var $tr = $('<tr>');

				// 내용을 각각 표현할 td 태그 생성			
				var $tdQnaNo = $('<td class="tdclass viewQna">').text(data[i].qNum);
				var $tdPlayName = $('<td class="tdclass viewQna">').text(data[i].pTitle);
				var $tdQnaTitle = $('<td class="tdclass viewQna">').text(data[i].qTitle);
				var $tsQnaDate = $('<td class="tdclass viewQna">').text(data[i].qDate);
				var $tdAnswer = $('<td class="tdclass viewQna">').text(data[i].qCompletedOrNot);

				$tr.append($tdQnaNo)
						.append($tdPlayName).append(
								$tdQnaTitle).append(
								$tsQnaDate).append(
								$tdAnswer)

				$table.append($tr); 
			}
			
			//리뷰 내역_팝업창 띄우기
			$(".viewQna").mouseenter(function() {
				$(this).parent().css({
					"background" : "#E6E6E6",
					"cursor" : "pointer"
				});
			}).mouseout(function() {
				$(this).parent().css({
					"background" : "white"
				});
			}).click(function() {
				var qno = $(this).parent().children().eq(0).text(); // td의 값으로 rno 저장
				//var qno = data[i].qNum;
				window.open("/Nonda/aDetail.qna?qno=" + qno,
						"문의 확인",
						"scrollbars=yes,width=480,height=780");
			});

		}
	});

}
	

// 아이디로 공연목록 불러오기
function tab3Click() {
	
	console.log("3번 클릭");
	
	$.ajax({
		type: 'GET',
		url : "/Nonda/pListbyId.pr",   
		success: function(data) {
			console.log("plistbyId ajax 성공");
			console.log(data);			
			
			var $table = $('#tab3-tb tbody');  // review 테이블에 내용 추가
			
			$('#tab3-tb tbody *').remove();
			
			for(var i in data) {
				// 내용을 담은 tr 태그 생성
				var $tr = $('<tr>');
				
				// 내용을 각각 표현할 td 태그 생성
				var $tdPlayNo = $('<td class="tdclass tab4-td">').text(data[i].pCode);
				var $tdPlayCategory = $('<td class="tdclass tab4-td">').text(data[i].pCategory);
				var $tdPlayTitle = $('<td class="tdclass tab4-td">').text(data[i].pTitle);
				var $tdPlayValid = $('<td class="tdclass tab4-td">').text(data[i].pValid);				
				
				
				$tr.append($tdPlayNo)
					.append($tdPlayCategory)
					.append($tdPlayTitle)
					.append($tdPlayValid)
					
				$table.append($tr);
			}
			
			//리뷰 내역_팝업창 띄우기
			$(".tdclass").mouseenter(function(){
				$(this).parent().css({"background":"#E6E6E6", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"white"});
			}).click(function(){
				var pno = $(this).parent().children().eq(0).text(); // td의 값으로 pno 저장
				console.log("pno: " + pno);
				location.href = "/Nonda/pRequestDetail.pr?pno=" + pno;
			});
			
		}
	});
}

//[공연 등록하기] 버튼 클릭
function addPlay() {
    location.href = "/Nonda/view/play_request/play_requestInsert.jsp";
}

</script>

</head>
<body>
	<%@ include file="header.jsp"%>

	<section>

	<div class="box-wrapper">

		<div class="first-wrapper">
			<div class="profile-panel">
				<div class="mynonda">
					<p>MY NONDA</p>
				</div>

				<div class="myprofile-wrapper">
					<div class="myprofile">
						<div class="profile-text username"><%=m.getmName()%></div>
						<div class="profile-text profile_manage">

							<%
									if (m.getmAccess().equals("customer")) {
								%>
							일반 회원
							<%
									} else if (m.getmAccess().equals("company")) {
								%>
							업체 회원
							<%
									} else if (m.getmAccess().equals("admin")) {
								%>
							관리자
							<%
									}
								%>
						</div>
					</div>
				</div>


			</div>

			<div class="point-panel">
				<div class="item">
					<div class="item-header text-md">예매율</div>
					<div class="item-count text-md">0 명</div>
				</div>
				<div class="item">
					<div class="item-header text-md">등록한 공연 수</div>
					<div class="item-count text-md">0 개</div>
				</div>
			</div>
		</div>

		<div id="vtab">
			<ul class="tabs">
				<li data-tab="tab1" class="profile current">
					<div class="tab-item">업체 정보</div>
				</li>
				<li data-tab="tab2" class="ask" onclick="tab2Click()">
					<div class="tab-item">문의 내역</div>
				</li>
				<li data-tab="tab3" class="play-info" onclick="tab3Click()">
					<div class="tab-item">공연정보 게시/수정</div>
				</li>
				<!-- <li data-tab="tab4" class="goal">
					<div class="tab-item">목표달성 현황</div>
				</li> -->

			</ul>

			<!-- 내 정보 tab -->
			<div id="tab1" class="tab-content current">
				<div id="tab1-1">
					<div class="mypage-wrapper">

						<div class="form-group">
							<div class='sub-title'>
								현재 비밀번호 <span class='required'>*</span>
							</div>
							<div class="form-control-pwd">
								<input type="password" id="pwd-now"
									class="form-control text-content"
									placeholder="현재 비밀번호를 입력해주세요." />
							</div>
							<div class="warning">
								<label id=name_warning></label>
							</div>
						</div>

						<input type="button" id="pwd-now-btn"
							class="mypage-btn pwdnow-confirm" value="확인">

					</div>
				</div>

				<div id="tab1-2">
					<input type="button" class="mypage-btn btn1" value="수정하기">

					<div class="mypage-wrapper">

						<div class="form-group">
							<div class="row-group">
								<div class="title">업체명</div>
								<div class="input-wrapper">
									<div class="row">
										<input class="form-control text-content" readonly type="text"
											value="이지은">
									</div>
								</div>
							</div>
							<div class="row-group">
								<div class="title">이메일(아이디)</div>
								<div class="input-wrapper">
									<div class="row">
										<input class="form-control text-content" readonly type="text"
											value="lee_je0118@naver.com">
									</div>
								</div>
							</div>
							<div class="row-group">
								<div class="title">전화번호</div>
								<div class="input-wrapper">
									<div class="row">
										<input class="form-control text-content can-modify" readonly
											type="text" value="01092358779">
									</div>
								</div>
							</div>

							<div class="row-group">
								<div class="title newpwd">새 비밀번호</div>
								<div class="input-wrapper">
									<div class="row">
										<input class="form-control text-content can-modify" readonly
											type="text" value="">
									</div>
								</div>
							</div>
							<div class="row-group">
								<div class="title newpwd2">새 비밀번호 확인</div>
								<div class="input-wrapper">
									<div class="row">
										<input class="form-control text-content can-modify" readonly
											type="text" value="">
									</div>
								</div>
							</div>
						</div>

					</div>
					<input type="button" class="mypage-btn btn2" value="확인">
				</div>

			</div>

			<!-- 문의내역 확인 tab -->
			<div id="tab2" class="tab-content">

				<table class="checkbox_tb question" id="tbQna">
					<colgroup>
						<col width="50">
						<col width="80">
						<col width="20">
						<col>
						<col width="90">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col" width=300px>공연명</th>
							<th scope="col" width=200px>제목</th>
							<th scope="col" class="side2">질문일</th>
							<th scope="col" class="answer">답변여부</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td class="">취소/환불</td>
							<td class=""><a href="#">환불해주세요</a></td>
							<td>2019.08.11 22:56</td>
							<td>답변완료</td>
						</tr>

					</tbody>
				</table>

			</div>

			<!-- 공연정보 게시/수정 tab -->
			<div id="tab3" class="tab-content">

				<div id="div-playAddBtn">
					<input type="button" id="playAddBtn" onclick="addPlay()"
						value="공연 등록하기">
				</div>

				<table class="checkbox_tb tab3-tb" id="tab3-tb">
					<colgroup>
						<col width="50">
						<col width="80">
						<col width="100">
						<col>
					</colgroup>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">분류</th>
							<th scope="col" width=300px>공연명</th>
							<th scope="col" class="side2">게시여부</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="tdclass play-detail">1</td>
							<td class="tdclass play-detail">play</td>
							<td class="tdclass play-detail"><a href="#">해리포터</a></td>
							<td class="tdclass play-detail">O</td>
						</tr>

					</tbody>
				</table>

			</div>

			<!-- 목표달성 현황 -->
			<!-- <div id="tab4" class="tab-content"></div> -->


		</div>

	</div>
	</section>

	<%@ include file="footer.jsp"%>
</body>
</html>