<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="/Nonda/resource/image/favicon.png"
	type="image/png">
<script src="/Nonda/resource/js/jquery-3.4.1.min.js"></script>
<script src="/Nonda/resource/js/main_script.js"></script>
<style>
	<%@ include file="/resource/css/main_css.css"%>
</style>
<title>NONDA_메인</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<section>
	<div id="mainscreen">
		<div id="searchbar">
			<form action="/Nonda/dSearch.do" method="get">
				<select id="year" name="syear"></select> <select id="month" name="smonth"></select>
	
				<div id="radio-pillbox">
					<radiogroup>
					<div>
						<input type="radio" name="radio-group" value="play"> <label>공연</label> </input>
					</div>
					<div>
						<input type="radio" name="radio-group" value="exhibit"> <label>전시회</label>
						</input>
					</div>
					<div>
						<input type="radio" name="radio-group" value="festival"> <label>축제</label> </input>
					</div>
					</radiogroup>
				</div>
	
				<input type="image"
					src="/Nonda/resource/image/go.png" id="searchbtn" onclick='dateSearch()'>
			</form>
		</div>

		<div id="main_submenu">
			<img src="/Nonda/resource/image/icon1.png"
				onmouseover="this.src='/Nonda/resource/image/icon6.png'"
				onmouseout="this.src='/Nonda/resource/image/icon1.png'"
				onclick="fnMove('best')"> <img
				src="/Nonda/resource/image/icon2.png"
				onmouseover="this.src='/Nonda/resource/image/icon7.png'"
				onmouseout="this.src='/Nonda/resource/image/icon2.png'"
				onclick="fnMove('end')"> <img
				src="/Nonda/resource/image/icon3.png"
				onmouseover="this.src='/Nonda/resource/image/icon8.png'"
				onmouseout="this.src='/Nonda/resource/image/icon3.png'"
				onclick="fnMove('open')"> <img
				src="/Nonda/resource/image/icon4.png"
				onmouseover="this.src='/Nonda/resource/image/icon9.png'"
				onmouseout="this.src='/Nonda/resource/image/icon4.png'"
				onclick="fnMove('order')"> <img
				src="/Nonda/resource/image/icon5.png"
				onmouseover="this.src='/Nonda/resource/image/icon10.png'"
				onmouseout="this.src='/Nonda/resource/image/icon5.png'"
				onclick="fnMove('review')">
		</div>
	</div>

	<div id="play" class="field">
		<div class="play_field"></div>
	</div>

	<div id="best" class="field">
		<div class="field2">
			<div class="field_header">
				<div class="flag">
					<img src="/Nonda/resource/image/flag1.jpg" id="best_flag">
				</div>

				<div class="poster_title">
					<img src="/Nonda/resource/image/title1.png" class="title_o">
				</div>
			</div>

			<img src="/Nonda/resource/image/pre.png" class="slide_btn pre_btn"
				onclick="slide1(-1, 1);"> <img
				src="/Nonda/resource/image/next.png" class="slide_btn next_btn"
				onclick="slide1(1, 3);">

			<div id="all_poster1">
				<div class="poster">
					<a id="bu0">
						<div class="poster_size">
							<img id="bpp0">
						</div>
						<div class="poster_con">
							<p>
								<b id="bpt0"></b>
							</p>
							<p id="bpse0"></p>
							<p id="bpcp0"></p>
						</div>
					</a>
				</div>

				<div class="poster">
					<a id="bu1">
						<div class="poster_size">
							<img id="bpp1">
						</div>
						<div class="poster_con">
							<p>
								<b id="bpt1"></b>
							</p>
							<p id="bpse1"></p>
							<p id="bpcp1"></p>
						</div>
					</a>
				</div>

				<div class="poster last_poster">
					<a id="bu2">
						<div class="poster_size">
							<img id="bpp2">
						</div>
						<div class="poster_con">
							<p>
								<b id="bpt2"></b>
							</p>
							<p id="bpse2"></p>
							<p id="bpcp2"></p>
						</div>
					</a>
				</div>
			</div>
			<!-- #all_poster1 end -->

			<div id="all_poster2">
				<div class="poster">
					<a id="bu3">
						<div class="poster_size">
							<img id="bpp3">
						</div>
						<div class="poster_con">
							<p>
								<b id="bpt3"></b>
							</p>
							<p id="bpse3"></p>
							<p id="bpcp3"></p>
						</div>
					</a>
				</div>

				<div class="poster">
					<a id="bu4">
						<div class="poster_size">
							<img id="bpp4">
						</div>
						<div class="poster_con">
							<p>
								<b id="bpt4"></b>
							</p>
							<p id="bpse4"></p>
							<p id="bpcp4"></p>
						</div>
					</a>
				</div>

				<div class="poster last_poster">
					<a id="bu5">
						<div class="poster_size">
							<img id="bpp5">
						</div>
						<div class="poster_con">
							<p>
								<b id="bpt5"></b>
							</p>
							<p id="bpse5"></p>
							<p id="bpcp5"></p>
						</div>
					</a>
				</div>
			</div>
			<!-- #all_poster2 end -->

			<div id="all_poster3">
				<div class="poster">
					<a id="bu6">
						<div class="poster_size">
							<img id="bpp6">
						</div>
						<div class="poster_con">
							<p>
								<b id="bpt6"></b>
							</p>
							<p id="bpse6"></p>
							<p id="bpcp6"></p>
						</div>
					</a>
				</div>

				<div class="poster">
					<a id="bu7">
						<div class="poster_size">
							<img id="bpp7">
						</div>
						<div class="poster_con">
							<p>
								<b id="bpt7"></b>
							</p>
							<p id="bpse7"></p>
							<p id="bpcp7"></p>
						</div>
					</a>
				</div>

				<div class="poster last_poster">
					<a id="bu8">
						<div class="poster_size">
							<img id="bpp8">
						</div>
						<div class="poster_con">
							<p>
								<b id="bpt8"></b>
							</p>
							<p id="bpse8"></p>
							<p id="bpcp8"></p>
						</div>
					</a>
				</div>
			</div>
			<!-- #all_poster3 end -->

			<div class="all_btn">
				<div class="move_btn" id="move_btn1"
					onclick="poster_click(1, 1, 'best_flag');"
					style="background-color: #666;"></div>
				<div class="move_btn" id="move_btn2"
					onclick="poster_click(2, 2, 'best_flag');"></div>
				<div class="move_btn" id="move_btn3"
					onclick="poster_click(3, 3, 'best_flag');"></div>
			</div>
		</div>
	</div>
	<!-- #best -->

	<div id="end" class="field">
		<div class="field2">
			<div class="field_header">
				<div class="flag">
					<img src="/Nonda/resource/image/flag1.jpg" id="end_flag">
				</div>

				<div class="poster_title">
					<img src="/Nonda/resource/image/title5.png" class="title_o">
				</div>

				<div class="more">
					<p>
						<a href="#">VIEW MORE <img
							src="/Nonda/resource/image/v_arrow.png"></a>
					</p>
				</div>
			</div>

			<img src="/Nonda/resource/image/pre.png" class="slide_btn pre_btn"
				onclick="slide2(-1, 4);"> <img
				src="/Nonda/resource/image/next.png" class="slide_btn next_btn"
				onclick="slide2(1, 6);">

			<div id="all_poster4">
				<div class="poster">
					<a id="eu0">
						<div class="poster_size">
							<img id="epp0">
						</div>
						<div class="poster_con">
							<p>
								<b id="ept0"></b>
							</p>
							<p id="epse0"></p>
							<p id="epcp0"></p>
						</div>
					</a>
				</div>

				<div class="poster">
					<a id="eu1">
						<div class="poster_size">
							<img id="epp1">
						</div>
						<div class="poster_con">
							<p>
								<b id="ept1"></b>
							</p>
							<p id="epse1"></p>
							<p id="epcp1"></p>
						</div>
					</a>
				</div>

				<div class="poster last_poster">
					<a id="eu2">
						<div class="poster_size">
							<img id="epp2">
						</div>
						<div class="poster_con">
							<p>
								<b id="ept2"></b>
							</p>
							<p id="epse2"></p>
							<p id="epcp2"></p>
						</div>
					</a>
				</div>
			</div>
			<!-- #all_poster4 end -->

			<div id="all_poster5">
				<div class="poster">
					<a id="eu3">
						<div class="poster_size">
							<img id="epp3">
						</div>
						<div class="poster_con">
							<p>
								<b id="ept3"></b>
							</p>
							<p id="epse3"></p>
							<p id="epcp3"></p>
						</div>
					</a>
				</div>

				<div class="poster">
					<a id="eu4">
						<div class="poster_size">
							<img id="epp4">
						</div>
						<div class="poster_con">
							<p>
								<b id="ept4"></b>
							</p>
							<p id="epse4"></p>
							<p id="epcp4"></p>
						</div>
					</a>
				</div>

				<div class="poster last_poster">
					<a id="eu5">
						<div class="poster_size">
							<img id="epp5">
						</div>
						<div class="poster_con">
							<p>
								<b id="ept5"></b>
							</p>
							<p id="epse5"></p>
							<p id="epcp5"></p>
						</div>
					</a>
				</div>
			</div>
			<!-- #all_poster5 end -->

			<div id="all_poster6">
				<div class="poster">
					<a id="eu6">
						<div class="poster_size">
							<img id="epp6">
						</div>
						<div class="poster_con">
							<p>
								<b id="ept6"></b>
							</p>
							<p id="epse6"></p>
							<p id="epcp6"></p>
						</div>
					</a>
				</div>

				<div class="poster">
					<a id="eu7">
						<div class="poster_size">
							<img id="epp7">
						</div>
						<div class="poster_con">
							<p>
								<b id="ept7"></b>
							</p>
							<p id="epse7"></p>
							<p id="epcp7"></p>
						</div>
					</a>
				</div>

				<div class="poster last_poster">
					<a id="eu8">
						<div class="poster_size">
							<img id="epp8">
						</div>
						<div class="poster_con">
							<p>
								<b id="ept8"></b>
							</p>
							<p id="epse8"></p>
							<p id="epcp8"></p>
						</div>
					</a>
				</div>
			</div>
			<!-- #all_poster6 end -->

			<div class="all_btn">
				<div class="move_btn" id="move_btn4"
					onclick="poster_click(4, 1, 'end_flag');"
					style="background-color: #666;"></div>
				<div class="move_btn" id="move_btn5"
					onclick="poster_click(5, 2, 'end_flag');"></div>
				<div class="move_btn" id="move_btn6"
					onclick="poster_click(6, 3, 'end_flag');"></div>
			</div>
		</div>
	</div>
	<!-- #end -->

	<div id="open" class="field">
		<div class="field2">
			<div class="field_header">
				<div class="flag">
					<img src="/Nonda/resource/image/flag1.jpg" id="open_flag">
				</div>

				<div class="poster_title">
					<img src="/Nonda/resource/image/title3.png" class="title_o">
				</div>

				<div class="more">
					<p>
						<a href="#">VIEW MORE <img
							src="/Nonda/resource/image/v_arrow.png"></a>
					</p>
				</div>
			</div>

			<img src="/Nonda/resource/image/pre.png" class="slide_btn pre_btn"
				onclick="slide3(-1, 7);"> <img
				src="/Nonda/resource/image/next.png" class="slide_btn next_btn"
				onclick="slide3(1, 9);">

			<div id="all_poster7">
				<div class="poster">
					<a id="ou0">
						<div class="poster_size">
							<img id="opp0">
						</div>
						<div class="poster_con">
							<p>
								<b id="opt0"></b>
							</p>
							<p id="opse0"></p>
							<p id="opcp0"></p>
						</div>
					</a>
				</div>

				<div class="poster">
					<a id="ou1">
						<div class="poster_size">
							<img id="opp1">
						</div>
						<div class="poster_con">
							<p>
								<b id="opt1"></b>
							</p>
							<p id="opse1"></p>
							<p id="opcp1"></p>
						</div>
					</a>
				</div>

				<div class="poster last_poster">
					<a id="ou2">
						<div class="poster_size">
							<img id="opp2">
						</div>
						<div class="poster_con">
							<p>
								<b id="opt2"></b>
							</p>
							<p id="opse2"></p>
							<p id="opcp2"></p>
						</div>
					</a>
				</div>
			</div>
			<!-- #all_poster7 end -->

			<div id="all_poster8">
				<div class="poster">
					<a id="ou3">
						<div class="poster_size">
							<img id="opp3">
						</div>
						<div class="poster_con">
							<p>
								<b id="opt3"></b>
							</p>
							<p id="opse3"></p>
							<p id="opcp3"></p>
						</div>
					</a>
				</div>

				<div class="poster">
					<a id="ou4">
						<div class="poster_size">
							<img id="opp4">
						</div>
						<div class="poster_con">
							<p>
								<b id="opt4"></b>
							</p>
							<p id="opse4"></p>
							<p id="opcp4"></p>
						</div>
					</a>
				</div>

				<div class="poster last_poster">
					<a id="ou5">
						<div class="poster_size">
							<img id="opp5">
						</div>
						<div class="poster_con">
							<p>
								<b id="opt5"></b>
							</p>
							<p id="opse5"></p>
							<p id="opcp5"></p>
						</div>
					</a>
				</div>
			</div>
			<!-- #all_poster8 end -->

			<div id="all_poster9">
				<div class="poster">
					<a id="ou6">
						<div class="poster_size">
							<img id="opp6">
						</div>
						<div class="poster_con">
							<p>
								<b id="opt6"></b>
							</p>
							<p id="opse6"></p>
							<p id="opcp6"></p>
						</div>
					</a>
				</div>

				<div class="poster">
					<a id="ou7">
						<div class="poster_size">
							<img id="opp7">
						</div>
						<div class="poster_con">
							<p>
								<b id="opt7"></b>
							</p>
							<p id="opse7"></p>
							<p id="opcp7"></p>
						</div>
					</a>
				</div>

				<div class="poster last_poster">
					<a id="ou8">
						<div class="poster_size">
							<img id="opp8">
						</div>
						<div class="poster_con">
							<p>
								<b id="opt8"></b>
							</p>
							<p id="opse8"></p>
							<p id="opcp8"></p>
						</div>
					</a>
				</div>
			</div>
			<!-- #all_poster9 end -->

			<div class="all_btn">
				<div class="move_btn" id="move_btn7"
					onclick="poster_click(7, 1, 'open_flag');"
					style="background-color: #666;"></div>
				<div class="move_btn" id="move_btn8"
					onclick="poster_click(8, 2, 'open_flag');"></div>
				<div class="move_btn" id="move_btn9"
					onclick="poster_click(9, 3, 'open_flag');"></div>
			</div>
		</div>
	</div>
	<!-- #open -->

	<div id="order" class="field">
		<div class="field2">
			<div class="field_header">
				<div class="flag">
					<img src="/Nonda/resource/image/flag1.jpg" id="order_flag">
				</div>

				<div class="poster_title">
					<img src="/Nonda/resource/image/title4_1.png" class="title_o">
				</div>
			</div>

			<div id="all_poster10">
				<div class="poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>첫번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>

				<div class="poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>첫번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>

				<img src="/Nonda/resource/image/pre.png" class="slide_btn pre_btn"
					onclick="slide4(-1, 10);"> <img
					src="/Nonda/resource/image/next.png" class="slide_btn next_btn"
					onclick="slide4(1, 12);">

				<div class="poster last_poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>첫번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>
			</div>
			<!-- #all_poster10 end -->

			<div id="all_poster11">
				<div class="poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>두번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>

				<div class="poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>두번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>

				<div class="poster last_poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>두번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>
			</div>
			<!-- #all_poster11 end -->

			<div id="all_poster12">
				<div class="poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>세번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>

				<div class="poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>세번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>

				<div class="poster last_poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>세번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>
			</div>
			<!-- #all_poster12 end -->

			<div class="all_btn">
				<div class="move_btn" id="move_btn10"
					onclick="poster_click(10, 1, 'order_flag');"
					style="background-color: #666;"></div>
				<div class="move_btn" id="move_btn11"
					onclick="poster_click(11, 2, 'order_flag');"></div>
				<div class="move_btn" id="move_btn12"
					onclick="poster_click(12, 3, 'order_flag');"></div>
			</div>
		</div>
	</div>
	<!-- #order -->

	<div id="review" class="field">
		<div class="field2">
			<div class="field_header">
				<div class="flag">
					<img src="/Nonda/resource/image/flag1.jpg" id="review_flag">
				</div>

				<div class="poster_title">
					<img src="/Nonda/resource/image/title2.png" class="title_o">
				</div>
			</div>

			<img src="/Nonda/resource/image/pre.png" class="slide_btn pre_btn"
				onclick="slide5(-1, 13);"> <img
				src="/Nonda/resource/image/next.png" class="slide_btn next_btn"
				onclick="slide5(1, 15);">

			<div id="all_poster13">
				<div class="poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>첫번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>

				<div class="poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>첫번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>

				<div class="poster last_poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>첫번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>
			</div>
			<!-- #all_poster13 end -->

			<div id="all_poster14">
				<div class="poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>두번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>

				<div class="poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>두번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>

				<div class="poster last_poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>두번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>
			</div>
			<!-- #all_poster14 end -->

			<div id="all_poster15">
				<div class="poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>세번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>

				<div class="poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>세번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>

				<div class="poster last_poster">
					<a href="#">
						<div class="poster_size">
							<img src="/Nonda/resource/image/poster1.png">
						</div> <span class="poster_con">
							<p>
								<b>세번째 화면</b>
							</p>
							<p>- 기간 : 언제일까요?</p>
							<p>- 장소 : 어딜까요?</p>
					</span>
					</a>
				</div>
			</div>
			<!-- #all_poster15 end -->

			<div class="all_btn">
				<div class="move_btn" id="move_btn13"
					onclick="poster_click(13, 1, 'review_flag');"
					style="background-color: #666;"></div>
				<div class="move_btn" id="move_btn14"
					onclick="poster_click(14, 2, 'review_flag');"></div>
				<div class="move_btn" id="move_btn15"
					onclick="poster_click(15, 3, 'review_flag');"></div>
			</div>
		</div>
	</div>
	<!— #review —>

	<div id="play2"></div>
	</section>

	<%@ include file="footer.jsp"%>
	<%@ include file="top.jsp"%>
</body>
</html>