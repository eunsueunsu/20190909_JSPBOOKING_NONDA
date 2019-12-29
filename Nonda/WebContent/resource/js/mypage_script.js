
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


var prephone = null;

//사용 가능 포인트
$(function() {
	$.ajax({
		url: "/Nonda/PointCheckServlet",
		type: "get",
		success: function(data) {
			$("#mypoint").html(data + " 원");
		}
	});
});

//내 정보
$(function () {
	var getPhone = RegExp(/^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})([0-9]{3,4})([0-9]{4})$/);
	var getPw = RegExp(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,15}$/);

	$("#tab1-2").hide();
	$(".btn2").hide();
	$(".newpwd").hide();
	$(".newpwd2").hide();

	$("#pwd-now").keyup(function() {
		$("#pw_warning").html("");
	});

	$("#pwd-now-btn").click(function() {
		var mPw = $("#pwd-now").val();

		if (mPw == "") {
			$("#pw_warning").html("입력해주세요.");
			$("#pwd-now").focus();
		}
		else {
			$.ajax({
				url: "/Nonda/PwCheckServlet",
				type: "get",
				data: {
					mPw: mPw
				},
				success: function(data) {
					if (data == "0") {
						$("#pw_warning").html("비밀번호가 틀렸습니다.");
						$("#pwd-now").focus();
					} else {
						$("#tab1-1").hide();
						$("#tab1-2").show();

						$.ajax({
							url: "/Nonda/PrephoneCheckServlet",
							type: "get",
							success: function(data) {
								$("#phone").val(data);
								prephone = data;
							}
						});
					}
				}
			});
		}
	});

	$(".btn1").click(function() {
		$(".btn2").show();
		$(".newpwd").show();
		$(".newpwd2").show();
		$(".can-modify").css("border", "1px solid gainsboro");
		$(".can-modify").attr('readonly', false);
	});

	$("#phone").keyup(function() {
		if ($("#phone").val() == "") {
			$("#phone_warning").html("필수 입력 항목입니다.");
		} else if (!getPhone.test($("#phone").val())) {
			$("#phone_warning").html("형식에 맞지 않습니다.");
		} else {
			$("#phone_warning").html("");
			phoneCheck();
		}
	});

	$("#newpw").keyup(function() {
		if ($("#newpw").val() == "") {
			$("#pwd_warning").html("");
		} else if (!getPw.test($("#newpw").val())) {
			$("#pwd_warning").html("형식에 맞지 않습니다.");
		} else {
			$("#pwd_warning").html("");
			newpwCheck();
		}
	});

	$("#newpwcheck").keyup(function() {
		if ($("#newpw").val()!=$("#newpwcheck").val()) {
			$("#pwdcheck_warning").html("비밀번호가 일치하지 않습니다.");
		} else {
			$("#pwdcheck_warning").html("");
		}
	});
});

//휴대폰번호 중복 체크
function phoneCheck() {
	var mPhone = $("#phone").val();

	if(mPhone != prephone) {
		$.ajax({
			url: "/Nonda/PhoneCheckServlet",
			type: "get",
			data: {
				mPhone: mPhone
			},
			success: function(data) {
				if (data == "0") {
					$("#phone_warning").html("");
				} else {
					$("#phone_warning").html("이미 사용 중입니다.");
				}
			}
		});
	}
};

//새로운 비밀번호 체크
function newpwCheck() {
	var mPw = $("#newpw").val();

	$.ajax({
		url: "/Nonda/PwCheckServlet",
		type: "get",
		data: {
			mPw: mPw
		},
		success: function(data) {
			if (data == "1") {
				$("#pwd_warning").html("기존과 같습니다.");
			}
		}
	});
};

//회원 정보 수정
function memberUpdate() {
	var mPhone = $("#phone").val();
	var mPw = $("#newpwcheck").val();

	if ($("#phone_warning").html()=="" && $("#pwd_warning").html()=="" && $("#pwdcheck_warning").html()=="") {
		if ($("#newpw").val()!="" && $("#newpwcheck").val()=="") {
			$("#pwdcheck_warning").html("비밀번호가 일치하지 않습니다.");
		} else if (mPhone==prephone && $("#newpw").val()=="") {         
			alert("변경된 회원 정보가 없습니다.");

			location.reload();
		} else if (mPhone!=prephone && $("#newpw").val()=="") {
			$.ajax({
				url: "/Nonda/MemberUpdateServlet",
				type: "get",
				data: {
					mPhone: mPhone
				},
				success: function(data) {
					if (data == "1") {;
					alert("회원 정보 수정이 완료되었습니다.");

					location.reload();
					}
				}
			});
		} else {
			$.ajax({
				url: "/Nonda/MemberUpdateServlet",
				type: "get",
				data: {
					mPhone: mPhone,
					mPw: mPw
				},
				success: function(data) {
					if (data == "1") {;
					alert("회원 정보 수정이 완료되었습니다.");

					location.reload();
					}
				}
			});
		}
	}
}

//내 정보
function tab1Click() {
	$("#tab1-1").show();
	$("#tab1-2").hide();
	$(".btn2").hide();
	$(".newpwd").hide();
	$(".newpwd2").hide();
	$(".can-modify").css("border", "0");
	$(".can-modify").attr("readonly", true);

	$("#pwd-now").val("");
	$("#newpw").val("");
	$("#newpwcheck").val("");
	$("#pw_warning").html("");
	$("#phone_warning").html("");
	$("#pwd_warning").html("");
	$("#pwdcheck_warning").html("");
};

//포인트 현황
function tab6Click() {
	$.ajax({
		url: "/Nonda/PointListServlet",
		type: "get",
		success: function(data) {
			console.log(data);

			var $table = $("#tbPoint tbody");
			$('#tbPoint tbody *').remove();
			var poSum = 0;

			for (var i in data) {
				var $tr = $("<tr>");
				var $tdpoDate = $("<td>").text(data[i].poDate);
				var $tdpoRecord = $("<td>").text(data[i].poRecord);

				if (data[i].poCost > 0) {
					var $tdpoCost = $("<td>").text("+" + data[i].poCost);
				} else {
					var $tdpoCost = $("<td>").text(data[i].poCost);
				}

				poSum += data[i].poCost;
				var $tdpoSum = $("<td>").text(poSum + "원");

				$tr.append($tdpoDate).append($tdpoRecord)
				.append($tdpoCost).append($tdpoSum)

				$table.append($tr);
			}
		}
	});
};

//회원 탈퇴
$(function () {
   $("#droppw").keyup(function() {
      $("#droppw_warning").html("");
   });
   
   $("#dropbtn").click(function() {
      var mPw = $("#droppw").val();

      if (mPw == "") {
         $("#droppw_warning").html("입력해주세요.");
         $("#droppw").focus();
      }
      else {
         $.ajax({
            url: "/Nonda/PwCheckServlet",
            type: "get",
            data: {
               mPw: mPw
            },
            success: function(data) {
               if (data == "0") {
                  $("#droppw_warning").html("비밀번호가 틀렸습니다.");
                  $("#droppw").focus();
               } else {
                  $("#tab7-1").hide();
                  $("#tab7-2").show();
               }
            }
         });
      }
   });
});

//회원 탈퇴
function tab7Click() {
   $("#tab7-1").show();
   $("#tab7-2").hide();
   $("#droppw").val("");
   $("#droppw_warning").html("");
};

//회원 탈퇴함
function dropok() {
   $.ajax({
      url: "/Nonda/MemberDeleteServlet",
      type: "get",
      success: function(data) {
         if (data == "1") {
            alert("회원 탈퇴가 완료되었습니다.");

            window.location.href = "/Nonda/view/main.jsp";
         }
      }
   });
};

//회원 탈퇴 안함
function dropno() {
   alert("회원 탈퇴가 취소되었습니다.");

   location.reload();
};


