function getParameterByName(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	results = regex.exec(location.search);
	return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}


$(function() {
	var kWord=getParameterByName('kWord');
	$("#kWord").html(kWord);
	console.log(kWord);
	if(kWord!==" "){
		//검색된 프로그램 불러오기
		$.ajax({
			type:"get",
			url:"/Nonda/NowProgramSearchServlet",
			data:{
				kWord:kWord
			},
			dataType:"json",
			success : function(data){
				console.log(data);
				$("#bigblock").val(kWord);
				for (var i in data) {
					$("#presulta" + i).attr("href", "/Nonda/InfoDetailServlet?pCode=" + data[i].pCode);

					$("#resultbox"+i).css('display','inline-block');
					$("#pPoster" + i).attr('src',"/Nonda/resource/image/program/"+data[i].pPoster);
					$("#pTitle"+i).html(data[i].pTitle);
					$("#pCity"+i).html(data[i].pCity);
					$("#pPlace"+i).html(data[i].pPlace);
//					$("#kWord").html(kWord);
					$("#nowPNum").html(data.length);
					$('#nonedata').empty();
					if($("#resultbox").val()>data.length){
						$("#resultbox").remove();


					}
				}
			},
			error : function(){
				alert("프로그램 검색 실패");
			}
		});
		//검색된 리뷰 가져오기
		$.ajax({
			type:"get",
			url:"/Nonda/ReviewSearchServlet",
			data:{
				kWord:kWord
			},
			dataType:"json",
			success : function(data){
				console.log(data);

				for (var i in data) {

					$("#rresulta" + i).attr("href", "/Nonda/InfoDetailServlet?pCode=" + data[i].pcode);
					$("#rpTitle"+i).html(data[i].rtitle);
					$('#rwId'+i).html(data[i].rwriterId);
					$("#rDate"+i).html(data[i].rdate);
					$("#rContent"+i).html(data[i].rcontent);
					$('#rstar'+i).css('width','(data[i].rstar*20)%');
					$("#reviewNum").html(data.length);
					$('#rnonedata').empty();
					if($("#reviewresultbox"+i).val()>data.length){
						$("#reviewresultbox").remove();

					}
				}

			},
			error : function(){
				alert("프로그램 검색 실패");
			}
		});
	}
});

function check() {

	if (totalsearch2.kWord.value == ""||totalsearch2.kWord.value == " ") {

		alert("검색어을 입력해 주세요.");

		totalsearch2.kWord.focus();

		return false;

	}else return true;
}




