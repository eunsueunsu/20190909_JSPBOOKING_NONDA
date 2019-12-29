$(function() {
	$.datepicker.setDefaults({
		dateFormat: 'yy/mm/dd',
		prevText: '이전 달',
		nextText: '다음 달',
		monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		dayNames: ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		showMonthAfterYear: true,
		yearSuffix: '년'
	});

	$("#datepicker").datepicker({
		beforeShowDay: selectableDays,
		
		onSelect:function(dateText, inst) {
	        $("#date").html(dateText);
	    }
	});

	var enableDay = ['21/9/2019','22/9/2019'];
	
	function selectableDays(date) {
	dummy = date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear();
	if ($.inArray(dummy, enableDay) > -1) {
	return [true, ""];
	}
	return [false, ""];
	};
});

$(function() {
	var sum = 0;
	var ticket = 0;
	var fee = 0;
	
	$("#pPrice").html(numberWithCommas($("#firstprice").val())+"원");
	
	$("#many").change(function() {
		$("#many option:selected").each(function() {
			if ($(this).val() == "0") {
				$("#ticketprice").html("");
				$("#ticketresult").html("0 매 선택");
				$("#fee").html("");
				ticket = 0;
				fee = 0;
				$("#price").html("");
				$("#point").html("");
			} else if ($(this).val() == "1") {
				$("#ticketprice").html(numberWithCommas($("#firstprice").val())+"원");
				$("#ticketresult").html("1 매 선택");
				$("#fee").html("500원");
				ticket = $("#firstprice").val();
				fee = 500;
				$("#price").html(numberWithCommas(ticket)+"원")
			} else if ($(this).val() == "2") {
				$("#ticketprice").html(numberWithCommas($("#firstprice").val()*2)+"원");
				$("#ticketresult").html("2 매 선택");
				$("#fee").html(numberWithCommas(500*2)+"원");
				ticket = $("#firstprice").val()*2;
				fee = 500*2;
				$("#price").html(numberWithCommas(ticket)+"원")
			} else if ($(this).val() == "3") {
				$("#ticketprice").html(numberWithCommas($("#firstprice").val()*3)+"원");
				$("#ticketresult").html("3 매 선택");
				$("#fee").html(numberWithCommas(500*3)+"원");
				ticket = $("#firstprice").val()*3;
				fee = 500*3;
				$("#price").html(numberWithCommas(ticket)+"원")
			} else if ($(this).val() == "4") {
				$("#ticketprice").html(numberWithCommas($("#firstprice").val()*4)+"원");
				$("#ticketresult").html("4 매 선택");
				$("#fee").html(numberWithCommas(500*4)+"원");
				ticket = $("#firstprice").val()*4;
				fee = 500*4;
				$("#price").html(numberWithCommas(ticket)+"원")
			}
		});
	});
	
	$(".button").click(function() {
		$("#usepoint").val($("#firstpoint").val());
		$("#point").html("-"+numberWithCommas($("#firstpoint").val())+"원");
		sum = ticket - $("#firstpoint").val();
		$("#price").html(numberWithCommas(sum)+"원")
	});
	
	$("#usepoint").keyup(function() {
		if($("#usepoint").val() == "") {
			$("#point").html("");
		} else {
			$("#point").html("-"+numberWithCommas($("#usepoint").val())+"원");
			sum = ticket - $("#usepoint").val();
			$("#price").html(numberWithCommas(sum)+"원")
			$("#total").html(numberWithCommas(sum+fee)+"원")
		}
	});
});

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
};

$(function() {
	$("#pay").click(function () {
		var IMP = window.IMP;
		IMP.init('imp98540437');
		
		IMP.request_pay({
			pg: 'inicis',
			pay_method: 'card',
			merchant_uid: 'merchant_' + new Date().getTime(),
			name: '제19회 소래포구 축제',
			amount: 1000,
			buyer_email: 'myalvina@naver.com',
			buyer_name: '박희정',
			buyer_tel: '010-5647-4150',
			buyer_addr: '서울특별시 강남구 테헤란로 14길 6',
			buyer_postcode: '06234',
		}, function (rsp) {
			console.log(rsp);
			if (rsp.success) {
				var msg = '결제가 완료되었습니다. 마이페이지 예매내역에서 확인 가능합니다.';
				
				window.location.href="/Nonda/view/mypage.jsp";
			} else {
				var msg = '결제를 취소하셨습니다.';
				
				alert(msg);
				
				location.reload();
			}
		});
	});
});