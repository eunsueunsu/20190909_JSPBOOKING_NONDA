//이메일 앞부분 유효성 체크
function emailCheck1() {
	var getEmail1 = RegExp(/^[A-Za-z0-9_\.\-]+$/);

	if ($("#useremail1").val() == "") {
		$("#email_warning").html("필수 입력 항목입니다.");
	} else if (!getEmail1.test($("#useremail1").val())) {
		$("#email_warning").html("형식에 맞지 않습니다.");
	} else {
		$("#email_warning").html("");
		emailCheck2();
	}
};

//이메일 중복 체크
function emailCheck2() {
	var email1 = $("#useremail1").val();
	var email2 = $("#useremail2").val();
	var mId = email1 + "@" + email2;

	$.ajax({
		url: "/Nonda/IdCheckServlet",
		type: "get",
		data: {
			mId: mId
		},
		success: function(data) {
			if (data == "0") { // 중복 X
				$("#email_warning").html("");
			} else { // 중복 O
				$("#email_warning").html("이미 사용 중입니다.");
			}
		}
	});
};

//email select
$(function() {
	$(".select_email").change(function() {
		$(".select_email option:selected").each(function() {
			if ($(this).val() == "0") {
				$("#useremail2").val("");
				$("#useremail2").attr("disabled", true);
			} else if ($(this).val() == "9") {
				$("#useremail2").val("");
				$("#useremail2").attr("disabled", false);
				$("#useremail2").focus();
			} else {
				$("#useremail2").val($(this).val());
				$("#useremail2").attr("disabled", true);
			}
		});
	});
});

//나머지 유효성 체크
function MemberValidation() {
	var getEmail1 = RegExp(/^[A-Za-z0-9_\.\-]+$/);
	var getEmail2 = RegExp(/^[A-Za-z0-9\-]+\.[A-Za-z0-9\-]{2,3}$/);
	var getPw = RegExp(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,15}$/);
	var getName = RegExp(/^[가-힣]{2,5}$/);
	var getPhone = RegExp(/^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})([0-9]{3,4})([0-9]{4})$/);

	if ($("#useremail1").val()=="" || $("#useremail2").val()=="") {
		$("#email_warning").html("필수 입력 항목입니다.");
		$("#useremail1").focus();
		return false;
	}

	if (!getEmail1.test($("#useremail1").val()) || !getEmail2.test($("#useremail2").val())) {
		$("#email_warning").html("형식에 맞지 않습니다.");
		$("#useremail1").focus();
		return false;
	}

	if ($("#email_warning").html() != "") {
		$("#useremail1").focus();
		return false;
	}

	if ($("#userpwd").val() == "") {
		$("#pwd_warning").html("필수 입력 항목입니다.");
		$("#userpwd").focus();
		return false;
	}

	if ($("#pwd_warning").html() != "") {
		$("#userpwd").focus();
		return false;
	}

	if ($("#userpwd-check").val()=="" || $("#userpwd").val()!=$("#userpwd-check").val()) {
		$("#pwdcheck_warning").html("비밀번호가 일치하지 않습니다.");
		$("#userpwd-check").focus();
		return false;
	}

	if ($("#username").val() == "") {
		$("#name_warning").html("필수 입력 항목입니다.");
		$("#username").focus()
		return false;
	}

	if ($("#name_warning").html() != "") {
		$("#username").focus();
		return false;
	}

	if ($("#userphone").val() == "") {
		$("#phone_warning").html("필수 입력 항목입니다.");
		$("#userphone").focus()
		return false;
	}

	if ($("#phone_warning").html() != "") {
		$("#userphone").focus();
		return false;
	}

	if($("input[name='mAge']:checked").length < 1) { // 연령대 체크 X -> default 20
		$("input[name='mAge']:radio[value='20']").prop('checked', true);
	}
};

//휴대폰번호 중복 체크
function phoneCheck() {
	var mPhone = $("#userphone").val();
	
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

//경고 문구
$(function() {
	var getEmail2 = RegExp(/^[A-Za-z0-9\-]+\.[A-Za-z0-9\-]{2,3}$/);
	var getPw = RegExp(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,15}$/);
	var getName = RegExp(/^[가-힣]{2,5}$/);
	var getPhone = RegExp(/^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})([0-9]{3,4})([0-9]{4})$/);

	$(".select_email").click(function() {
		if ($(".select_email option:selected").val()=="0" || $(".select_email option:selected").val()=="9") {
			$("#email_warning").html("필수 입력 항목입니다.");
		} else {
			$("#email_warning").html("");
			emailCheck2();
		}
	});

	$("#useremail2").keyup(function() {
		if ($("#useremail2").val() == "") {
			$("#email_warning").html("필수 입력 항목입니다.");
		} else if (!getEmail2.test($("#useremail2").val())) {
			$("#email_warning").html("형식에 맞지 않습니다.");
		} else {
			$("#email_warning").html("");
			emailCheck2();
		}
	});

	$("#userpwd").keyup(function() {
		if ($("#userpwd").val() == "") {
			$("#pwd_warning").html("필수 입력 항목입니다.");
		} else if (!getPw.test($("#userpwd").val())) {
			$("#pwd_warning").html("형식에 맞지 않습니다.");
		} else {
			$("#pwd_warning").html("");
		}
	});

	$("#userpwd-check").keyup(function() {
		if ($("#userpwd").val() != $("#userpwd-check").val()) {
			$("#pwdcheck_warning").html("비밀번호가 일치하지 않습니다.");
		} else {
			$("#pwdcheck_warning").html("");
		}
	});

	$("#username").keyup(function() {
		if ($("#username").val() == "") {
			$("#name_warning").html("필수 입력 항목입니다.");
		} else if (!getName.test($("#username").val())) {
			$("#name_warning").html("형식에 맞지 않습니다.");
		} else {
			$("#name_warning").html("");
		}
	});

	$("#userphone").keyup(function() {
		if ($("#userphone").val() == "") {
			$("#phone_warning").html("필수 입력 항목입니다.");
		} else if (!getPhone.test($("#userphone").val())) {
			$("#phone_warning").html("형식에 맞지 않습니다.");
		} else {
			$("#phone_warning").html("");
			phoneCheck();
		}
	});

	$("input[name='mAccess']").change(function() {
		if ($("input[name='mAccess']:checked").val() == "company") {
			$("#member-type_warning").html("업체 회원은 가입 승인을 받아야 합니다.");
		} else {
			$("#member-type_warning").html("");
		}
	});
});

//제출
function joinSubmit() {
	if (MemberValidation() == false) { // 유효성 검사 오류 -> 제출 X
		return false;
	} else if ($("input[name='mAccess']:checked").val() == "company") {
		alert("회원 가입 성공! 가입 승인을 기다려주세요~");
	} else {
		alert("회원 가입 성공! 1000 포인트 지급 완료~");
	}
};

//약관
$(function() {
	$("#join_agree-link1").click(function(event) {
		event.preventDefault();
		if ($("#join-term-service1").css("display") == "none") {
			$("#join-term-service1").css("display", "block");
			$("#join-term-service2").css("display", "none");
			$("#join-term-service3").css("display", "none");
			$("#join-term-service4").css("display", "none");
		} else {
			$("#join-term-service1").css("display", "none");
			$("#join-term-service2").css("display", "none");
			$("#join-term-service3").css("display", "none");
			$("#join-term-service4").css("display", "none");
		}
	});

	$("#join_agree-link2").click(function(event) {
		event.preventDefault();
		if ($("#join-term-service2").css("display") == "none") {
			$("#join-term-service1").css("display", "none");
			$("#join-term-service2").css("display", "block");
			$("#join-term-service3").css("display", "none");
			$("#join-term-service4").css("display", "none");
		} else {
			$("#join-term-service1").css("display", "none");
			$("#join-term-service2").css("display", "none");
			$("#join-term-service3").css("display", "none");
			$("#join-term-service4").css("display", "none");
		}
	});

	$("#join_agree-link3").click(function(event) {
		event.preventDefault();
		if ($("#join-term-service3").css("display") == "none") {
			$("#join-term-service1").css("display", "none");
			$("#join-term-service2").css("display", "none");
			$("#join-term-service3").css("display", "block");
			$("#join-term-service4").css("display", "none");
		} else {
			$("#join-term-service1").css("display", "none");
			$("#join-term-service2").css("display", "none");
			$("#join-term-service3").css("display", "none");
			$("#join-term-service4").css("display", "none");
		}
	});

	$("#join_agree-link4").click(function(event) {
		event.preventDefault();
		if ($("#join-term-service4").css("display") == "none") {
			$("#join-term-service1").css("display", "none");
			$("#join-term-service2").css("display", "none");
			$("#join-term-service3").css("display", "none");
			$("#join-term-service4").css("display", "block");
		} else {
			$("#join-term-service1").css("display", "none");
			$("#join-term-service2").css("display", "none");
			$("#join-term-service3").css("display", "none");
			$("#join-term-service4").css("display", "none");
		}
	});
});