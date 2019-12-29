//이름 마우스오버
$(function() {
	$("#loginname").hover(function() {
		$(this).css({
			"text-decoration" : "underline"
		});
	}, function() {
		$(this).css({
			"text-decoration" : "none"
		});
	});
});

//검색어 빈값 체크
function check() {

	if (totalsearch.kWord.value == ""||totalsearch.kWord.value == " ") {

		alert("검색어을 입력해 주세요.");

		totalsearch.kWord.focus();

		return false;

	}else return true;
}