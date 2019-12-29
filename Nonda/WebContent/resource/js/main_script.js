//검색 기간
window.onload = function() {
	var now = new Date();
	var nyear = now.getFullYear();
	var nmonth = now.getMonth() + 1;
	var stryear = "";
	var strmonth = "";

	for (var i=nyear+1; i>=nyear-3; i--) {
		if (i == nyear) {
			stryear += "<option value=" + (nyear - 2000) + " selected>" + i + "년</option>";
		}
		else {
			stryear += "<option value=" + (i - 2000) + ">" + i + "년</option>";
		}
	}

	for(var i=1; i<=12; i++) {
		if (i == nmonth) {
			strmonth += "<option value=0" + nmonth + " selected>" + i + "월</option>";
		}
		else {
			if (10 <= i && i <= 12) {
				strmonth += "<option value=" + i + ">" + i + "월</option>";
			} else {
				strmonth += "<option value=0" + i + ">" + i + "월</option>";
			}
		}
	}

	document.getElementById("year").innerHTML = stryear;
	document.getElementById("month").innerHTML = strmonth;
};

//서브 메뉴 이동
function fnMove(seq) {
	var offset = $("#" + seq).offset();
	$('html, body').animate({
		scrollTop : offset.top
	}, 400);
};

//서브 메뉴 구성
$(function() {
	$.ajax({
		url: "/Nonda/BestListServlet",
		type: "get",
		success: function(data) {
			console.log(data);
			for (var i in data) {				
				$("#bu" + i).attr("href", "/Nonda/InfoDetailServlet?pCode=" + data[i].pCode);

				$("#bpp" + i).attr("src", "/Nonda/resource/image/program/" + data[i].pPoster);

				$("#bpt" + i).html(data[i].pTitle);

				if (data[i].pStartdate == data[i].pEnddate) {
					$("#bpse" + i).html("- 날짜 : " + data[i].pStartdate);
				} else {
					$("#bpse" + i).html("- 날짜 : " + data[i].pStartdate + " ~ " + data[i].pEnddate);
				}

				$("#bpcp" + i).html("- 장소 : " + data[i].pCity + " " + data[i].pPlace);
			}
		}
	});

	$.ajax({
		url: "/Nonda/EndListServlet",
		type: "get",
		success: function(data) {
			console.log(data);
			for (var i in data) {
				$("#eu" + i).attr("href", "/Nonda/InfoDetailServlet?pCode=" + data[i].pCode);

				$("#epp" + i).attr("src", "/Nonda/resource/image/program/" + data[i].pPoster);

				$("#ept" + i).html(data[i].pTitle);

				if (data[i].pStartdate == data[i].pEnddate) {
					$("#epse" + i).html("- 날짜 : " + data[i].pStartdate);
				} else {
					$("#epse" + i).html("- 날짜 : " + data[i].pStartdate + " ~ " + data[i].pEnddate);
				}

				$("#epcp" + i).html("- 장소 : " + data[i].pCity + " " + data[i].pPlace);
			}
		}
	});

	$.ajax({
		url: "/Nonda/OpenListServlet",
		type: "get",
		success: function(data) {
			console.log(data);
			for (var i in data) {
				$("#ou" + i).attr("href", "/Nonda/InfoDetailServlet?pCode=" + data[i].pCode);

				$("#opp" + i).attr("src", "/Nonda/resource/image/program/" + data[i].pPoster);

				$("#opt" + i).html(data[i].pTitle);

				if (data[i].pStartdate == data[i].pEnddate) {
					$("#opse" + i).html("- 날짜 : " + data[i].pStartdate);
				} else {
					$("#opse" + i).html("- 날짜 : " + data[i].pStartdate + " ~ " + data[i].pEnddate);
				}

				$("#opcp" + i).html("- 장소 : " + data[i].pCity + " " + data[i].pPlace);
			}
		}
	});
});

//카테고리 이동
var slideIndex1 = 1;
var slideIndex2 = 4;
var slideIndex3 = 7;
var slideIndex4 = 10;
var slideIndex5 = 13;

function poster_click(click,name,flag) {
	var start = 0;
	var end = 0;

	switch (click) {
	case 1: case 2: case 3: start = 1, end = 3, slideIndex1 = click; break;
	case 4: case 5: case 6: start = 4, end = 6, slideIndex2 = click; break;
	case 7: case 8: case 9: start = 7, end = 9, slideIndex3 = click; break;
	case 10: case 11: case 12: start = 10, end = 12, slideIndex4 = click; break;
	case 13: case 14: case 15: start = 13, end = 15, slideIndex5 = click; break;
	}

	for (var i=start;i<=end;i++) {
		if (i == click) {
			document.getElementById("all_poster" + click).style.display = "block";
			document.getElementById(flag).src = "/Nonda/resource/image/flag" + name + ".jpg";
			document.getElementById("move_btn" + click).style.backgroundColor = "#666";			
		} else {
			document.getElementById("all_poster" + i).style.display = "none";
			document.getElementById("move_btn" + i).style.backgroundColor = "#cfcfcf";
		}
	}
};

function slide1(n,turn) {
	showDivs(slideIndex1 += n,turn);
};

function slide2(n,turn) {
	showDivs(slideIndex2 += n,turn);
};

function slide3(n,turn) {
	showDivs(slideIndex3 += n,turn);
};

function slide4(n,turn) {
	showDivs(slideIndex4 += n,turn);
};

function slide5(n,turn) {
	showDivs(slideIndex5 += n,turn);
};

function showDivs(n,turn) {
	var start = 0;
	var end = 0;

	switch (turn) {
	case 1: case 3: start = 1, end = 3; break;
	case 4: case 6: start = 4, end = 6; break;
	case 7: case 9: start = 7, end = 9; break;
	case 10: case 12: start = 10, end = 12; break;
	case 13: case 15: start = 13, end = 15; break;
	}

	if (n > end) {
		n = start;

		if(start == 1)
			slideIndex1 = start;
		else if(start == 4)
			slideIndex2 = start;
		else if(start == 7)
			slideIndex3 = start;
		else if(start == 10)
			slideIndex4 = start;
		else if(start == 13)
			slideIndex5 = start;
	} else if (n < start) {
		n = end;

		if(start == 1)
			slideIndex1 = end;
		else if(start == 4)
			slideIndex2 = end;
		else if(start == 7)
			slideIndex3 = end;
		else if(start == 10)
			slideIndex4 = end;
		else if(start == 13)
			slideIndex5 = end;
	}

	for (var i = start; i <= end; i++) {
		if (n == i) {
			document.getElementById("all_poster" + n).style.display = "block";
			document.getElementById("move_btn" + n).style.backgroundColor = "#666";
		} else {
			document.getElementById("all_poster" + i).style.display = "none";
			document.getElementById("move_btn" + i).style.backgroundColor = "#cfcfcf";
		}
	}
};

function dateSearch() {
	$('#searchbtn').submit();
};