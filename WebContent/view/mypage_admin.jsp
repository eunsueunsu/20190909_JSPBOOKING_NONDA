<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/Nonda/resource/js/jquery-3.4.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="shortcut icon" href="/Nonda/resource/image/favicon.png"
	type="image/png">
<script src="/Nonda/resource/js/mypage_admin_script.js?ver=3"></script>
<style>
<%@include file="/resource/css/mypage_admin_css.css"%>
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

//checkAll
$(function() {
    var tbl = $(".checkbox_tb");

    // 테이블 헤더에 있는 checkbox 클릭시
    $(":checkbox:first", tbl).click(function(){
        // 클릭한 체크박스가 체크상태인지 체크해제상태인지 판단
        if( $(this).is(":checked") ){
            $(":checkbox", tbl).prop("checked", "checked");
        }
        else{
            $(":checkbox", tbl).prop('checked',false);
        }
    });

    // 헤더에 있는 체크박스외 다른 체크박스 클릭시
    $(":checkbox:not(:first)", tbl).click(function(){
        var allCnt = $(":checkbox:not(:first)", tbl).length;
        var checkedCnt = $(":checkbox:not(:first)", tbl).filter(":checked").length;
         
        // 전체 체크박스 갯수와 현재 체크된 체크박스 갯수를 비교해서 헤더에 있는 체크박스 체크할지 말지 판단
        if( allCnt==checkedCnt ){
            $(":checkbox:first", tbl).prop("checked", "checked");
        }
        else{
            $(":checkbox:first", tbl).prop("checked",false);
        }
    })
});


$(function () {
    $('#back-img').click(function () {
        $('#tab2-2').hide();
        $('#tab2-1').show();
    });
});

// 회원 관리_td 마우스오버 이벤트
$(function () {
    $('#tab2-2').hide();
    $(".edit_review").mouseenter(function () {
        $(this).parent().css({ "background": "#E6E6E6", "cursor": "pointer" });
    }).mouseout(function () {
        $(this).parent().css({ "background": "white" });
    }).click(function () {
        $('#tab2-1').hide();
        $('#tab2-2').show();
    });
});

$(function () {
    $(".tab4-td").mouseenter(function () {
        $(this).parent().css({ "background": "#E6E6E6", "cursor": "pointer" });
    }).mouseout(function () {
        $(this).parent().css({ "background": "white" });
    }).click(function () {

    });
});

</script>


</head>




<body>
	<%@ include file="header.jsp"%>

	<section>

	<div class="box-wrapper">

		<div id="vtab">
			<ul class="tabs">
				<li data-tab="tab1" class="confirm-play current">
					<div class="tab-item">공연 게시 요청</div>
				</li>
				<li data-tab="tab2" class="member">
					<div class="tab-item">회원 관리</div>
				</li>
				<li data-tab="tab3" class="recommend-play">
					<div class="tab-item">이달의 추천 관리</div>
				</li>
				<li data-tab="tab4" class="total-play">
					<div class="tab-item">등록된 공연</div>
				</li>
				<li data-tab="tab5" class="confirm-join">
					<div class="tab-item">업체 가입승인</div>
				</li>

			</ul>

			<!-- 공연 게시 요청 tab -->
			<div id="tab1" class="tab-content current">
				<div class="tab2-wrapper">
					<table class="checkbox_tb">
						<colgroup>
							<col width="50px">
							<col width="80px">
							<col width="80px">
							<col width="20px">
							<col width="20px">
						</colgroup>
						<thead>
							<tr>
								<th scope="col" width="60px;">종류</th>
								<th scope="col" width="200px;">play명</th>
								<th scope="col">신청자</th>
								<th scope="col">신청일</th>
								<th scope="col">상태</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="edit_review">전시회</td>
								<td class="edit_review">해리포터와 마법사의돌</td>
								<td class="edit_review">이지은</td>
								<td class="edit_review">2019.08.23</td>
								<td class="edit_review">대기중</td>
							</tr>

							<tr>
								<td class="edit_review">전시회</td>
								<td class="edit_review">해리포터와 마법사의돌</td>
								<td class="edit_review">이지은</td>
								<td class="edit_review">2019.08.23</td>
								<td class="edit_review">대기중</td>
							</tr>

						</tbody>
					</table>
				</div>

			</div>

			<!-- 회원 관리 tab -->
			<div id="tab2" class="tab-content">

				<div id="tab2-1">
					<div class="search">
						<div class="search_wrapper">
							<input type="text" class="search_input search-id"
								placeholder="이메일(아이디)로 검색하기"> <input type="button"
								class="search_btn search-id-btn" value="검색"> <select
								class="select_type">
								<option value="전체">전체회원</option>
								<option value="일반">일반회원</option>
								<option value="업체">업체회원</option>
							</select>
						</div>
					</div>

					<table class="checkbox_tb">
						<colgroup>
							<col width="100px">
							<col width="80px">
							<col width="80px">
							<col width="20px">
							<col width=50px;>
							<col width="50px">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">이메일(아이디)</th>
								<th scope="col">이름</th>
								<th scope="col">그룹</th>
								<th scope="col">가입일</th>
								<th scope="col">적립금</th>
								<th scope="col">리뷰</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="edit_review">lee_je0118@naver.com</td>
								<td class="edit_review">이지은</td>
								<td class="edit_review">일반</td>
								<td class="edit_review">2019.08.23</td>
								<td class="edit_review">3000</td>
								<td class="edit_review">34</td>
							</tr>

							<tr>
								<td class="edit_review">hello0011@naver.com</td>
								<td class="edit_review">이은수</td>
								<td class="edit_review">업체</td>
								<td class="edit_review">2019.08.23</td>
								<td class="edit_review">300</td>
								<td class="edit_review">4</td>
							</tr>

						</tbody>
					</table>
				</div>

				<div id="tab2-2">

					<div class="mypage-wrapper">
						<div class="id-group">
							<img id="back-img" src="/Nonda/resource/image/pre.png"> <span
								class="id">lee_je0118@naver.com</span>
						</div>

						<div class="form-group first">
							<div class="main-title">회원정보 조회</div>

							<div class="row-group">
								<div class="title">이름</div>
								<div class="input-wrapper">
									<div class="row">
										<input class="form-control text-content" readonly type="text"
											value="이지은">
									</div>
								</div>
							</div>
							<div class="row-group">
								<div class="title">이메일</div>
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
						</div>

						<div class="form-group second">
							<div class="point-title">적립금 지급</div>
							<div class="give-point">
								<input type="text" class="price" placeholder="금액"> <input
									type="text" class="reason" placeholder="사유"> <input
									type="button" class="point-confirm" value="확인">
							</div>

							<table class="checkbox_tb">
								<colgroup>
									<col width="80px">
									<col width="200px">
									<col width="80px">
									<col width="20px">
								</colgroup>
								<thead>
									<tr>
										<th scope="col">일자</th>
										<th scope="col" width="180px">사유</th>
										<th scope="col">금액</th>
										<th scope="col">잔액</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>2019.08.24</td>
										<td>블로그리뷰 작성</td>
										<td>+300</td>
										<td>300</td>
									</tr>

									<tr>
										<td>2019.08.24</td>
										<td>블로그리뷰 작성</td>
										<td>+300</td>
										<td>300</td>
									</tr>

								</tbody>
							</table>

						</div>

					</div>



				</div>

			</div>

			<!-- 이달의 추천 관리 tab -->
			<div id="tab3" class="tab-content">

				<div class="poster">
					<a href="./infoDetail.html"> <img
						src="../resource/image/poster1.png"> <span
						class="poster_con">
							<p>
								<b>제목입니당길게길게</b>
							</p>

					</span>
					</a>
				</div>


				<div class="poster">
					<a href="./infoDetail.html"> <img
						src="../resource/image/poster1.png"> <span
						class="poster_con">
							<p>
								<b>제목입니당길게길게</b>
							</p>

					</span>
					</a>
				</div>

				<div class="poster last_poster">
					<a href="./infoDetail.html"> <img
						src="../resource/image/poster1.png"> <span
						class="poster_con">
							<p>
								<b>제목입니당길게길게</b>
							</p>

					</span>
					</a>
				</div>

			</div>

			<!-- 등록된 공연 관리 -->
			<div id="tab4" class="tab-content">

				<div class="search">
					<div class="search_wrapper">
						<input type="text" class="search_input search-pname"
							placeholder="공연명으로 검색하기"> <input type="button"
							class="search_btn search-pname-btn" value="검색"> <select
							class="select_type">
							<option value="전체">전체</option>
							<option value="전시회">전시회</option>
							<option value="축제">축제</option>
							<option value="공연">공연</option>
						</select>
					</div>
				</div>

				<div class="table-wrapper">
					<table cellspacing='0' class="tab4_tb checkbox_tb">
						<thead>
							<tr>
								<th width="60px">장르</th>
								<th width="">공연명</th>
								<th width="100px">공연코드</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td class="tab4-td">축제</td>
								<td class="tab4-td">해리포터와 혼혈왕자</td>
								<td class="tab4-td">FE001122</td>
							</tr>

							<tr>
								<td class="tab4-td">축제</td>
								<td class="tab4-td">해리포터와 혼혈왕자</td>
								<td class="tab4-td">FE001122</td>
							</tr>

							<tr>
								<td class="tab4-td">축제</td>
								<td class="tab4-td">해리포터와 혼혈왕자</td>
								<td class="tab4-td">FE001122</td>
							</tr>

							<tr>
								<td class="tab4-td">축제</td>
								<td class="tab4-td">해리포터와 혼혈왕자</td>
								<td class="tab4-td">FE001122</td>
							</tr>

						</tbody>
					</table>
				</div>
			</div>

			<!-- 회원 관리 tab -->
			<div id="tab5" class="tab-content">
				<div class="tab5-table-wrapper">
					<table class="checkbox_tb">
						<colgroup>
							<col width="100px">
							<col width="80px">
							<col width="80px">
							<col width="20px">
							<col width=50px;>
							<col width="50px">
						</colgroup>
						<thead>
							<tr>
								<th scope="col"><input type="checkbox" id="checkAll"></th>
								<th scope="col">이메일(아이디)</th>
								<th scope="col">이름</th>
								<th scope="col">그룹</th>
								<th scope="col">가입요청일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox" id="checkbox"></td>
								<td class="edit_review">lee_je0118@naver.com</td>
								<td class="edit_review">이지은</td>
								<td class="edit_review">일반</td>
								<td class="edit_review">2019.08.23</td>
							</tr>

							<tr>
								<td><input type="checkbox" id="checkbox"></td>
								<td class="edit_review">hello0011@naver.com</td>
								<td class="edit_review">이은수</td>
								<td class="edit_review">업체</td>
								<td class="edit_review">2019.08.23</td>
							</tr>

						</tbody>
					</table>
				</div>

				<input type="button" value="가입 승인" class="confirm-join-btn">

			</div>
		</div>
		
	</section>
	<%@ include file="footer.jsp"%>

</body>

</html>