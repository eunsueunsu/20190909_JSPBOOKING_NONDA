<%@page import="java.text.DecimalFormat"%>
<%@page import="program.model.vo.Program"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	Program p = (Program)request.getAttribute("program");
	int point = (int) request.getAttribute("point");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="/Nonda/resource/image/favicon.png"
	type="image/png">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script src="/Nonda/resource/js/reservation_script.js"></script>
<style>
	<%@ include file="/resource/css/reservation_css.css"%>
</style>
<title>NONDA_결제</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<section>
	<input type="hidden" id="firstprice" value="<%=p.getpPrice()%>">
	<input type="hidden" id="firstpoint" value="<%=point%>">
	
	<div class="edge">
		<div class="choice">
			<div class="date">
				<label class="titlefont">날짜를 선택하세요.</label> <input type="text"
					id="datepicker">
			</div>

			<label class="title titlefont">티켓 매수를 선택하세요.</label>
			<div class="ticket">
				<label id="ticketresult">0 매 선택</label>
			</div>
			<div class="menu">
				<label>기본가</label> <label id="pPrice"></label> <select id="many">
					<option value="0" selected>0 매</option>
					<option value="1">1 매</option>
					<option value="2">2 매</option>
					<option value="3">3 매</option>
					<option value="4">4 매</option>
				</select>
			</div>

			<label class="title titlefont">포인트 할인을 적용하세요.</label>
			<hr>
			<div class="menu">
				<label>사용할 포인트</label>
				<input type="button" class="button" value="전액 사용">
				<label id="totalpoint">원 (사용 가능한 포인트 : <% DecimalFormat formatter = new DecimalFormat("###,###"); %> <%=formatter.format(point)%> 원)</label> <input
					type="text" id="usepoint" placeholder="0">
			</div>

			<label class="title titlefont">결제수단을 선택하세요.</label>
			<div class="type">
				<input type="radio" checked>
				<p>신용카드</p>
			</div>
		</div>

		<div class="result">
			<label class="title titlefont" id="title"><%=p.getpTitle() %></label>

			<div class="info">
				<label>관람일 :</label> <label id="date"></label>
				<p>현장수령</p>
			</div>

			<label class="title titlefont">결제금액</label>
			<div class="detail">
				<div>
					<label class="big">티켓금액</label> <label class="big" id="price"></label>
				</div>
				<div>
					<label>기본가</label> <label id="ticketprice"></label>
				</div>
				<div>
					<label>포인트 할인</label> <label id="point"></label>
				</div>
				<div>
					<label class="big">예매수수료</label> <label class="big" id="fee"></label>
				</div>
				<hr>
				<div>
					<label class="titlefont">총 결제금액</label> <label class="titlefont" id="total"></label>
				</div>
			</div>
			
			<button id="pay">결 제 하 기</button>
		</div>
	</div>
	</section>

	<%@ include file="footer.jsp"%>
</body>
</html>