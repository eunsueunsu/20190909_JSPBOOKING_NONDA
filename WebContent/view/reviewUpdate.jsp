<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="review.model.vo.*" %>
<%

//ReviewUpdateViewServlet에서 가져온 review
Review r = (Review)request.getAttribute("review");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>리뷰 수정하기</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    
    <script>
    
    // 부모페이지로 돌아가기 위해
    // 확인버튼 클릭시 호출되는 함수
    function goSubmit() {
    	
    	/////////////////////////////////////
    	var star = $("#hdField").val();
    	var content = $("#reviewInput").val();
    	
    	console.log(star);
    	console.log(content);
    	
    	$.ajax({
    		type: "GET",
    		url : "/Nonda/rInsert.re", 
    		data: {star:star, content:content},
    		success: function(data) {
    	 		console.log("Insert ajax 성공");
    	 			
    		}, error: function() {
    			alert("실패 ㅠ");
    		}
    	});  
    	//////////////////////////////////////
    	
    	var formId = document.getElementById("form-id"); //form을 아이디로 불러옴
    	window.opener.name = "parentPage"; 
    	formId.target = "parentPage"; //부모페이지로 submit
    	formId.action="/Nonda/view/mypage.jsp"; // submit시 mypage로 이동
    	formId.submit();
    	self.close();
    }
    
    $(function() {
    	var star = $("#hdField").val(); // 변수에 평점 저장
    	//var star=3;
    	
    	// 불러운 평점에 맞게 채워진star이미지로 변경
    	for(var i=1; i<=star; i++) {
    		$("#star"+i).attr('src','/Nonda/resource/image/full_star.png'); 
    	}
    	
    });
    
        $(function() {
        	var starId;
            $('#star1').click(function() {
                $("#star1").attr('src','/Nonda/resource/image/full_star.png');
                $("#star2, #star3, #star4, #star5").attr('src','/Nonda/resource/image/empty_star.png');
               	$("#hdField").val(1);
            });

            $('#star2').click(function() {
                $("#star1, #star2").attr('src','/Nonda/resource/image/full_star.png');
                $("#star3, #star4, #star5").attr('src','/Nonda/resource/image/empty_star.png');
                $("#hdField").val(2);
            });

            $('#star3').click(function() {
                $("#star1, #star2, #star3").attr('src','/Nonda/resource/image/full_star.png');
                $("#star4, #star5").attr('src','/Nonda/resource/image/empty_star.png');
                $("#hdField").val(3);
            });

            $('#star4').click(function() {
                $("#star1, #star2, #star3, #star4").attr('src','/Nonda/resource/image/full_star.png');
                $("#star5").attr('src','/Nonda/resource/image/empty_star.png');
                $("#hdField").val(4);
            });

            $('#star5').click(function() {
                $("#star1, #star2, #star3, #star4, #star5").attr('src','/Nonda/resource/image/full_star.png');
                $("#hdField").val(5);
            });

        });

        

    </script>

    <style type="text/css">

        body, input, textarea, button {
            font-family: 나눔고딕, 맑은고딕, 돋움;
            font-size: 12px;
        }

        body, p, h1, input, textarea, button {
            margin: 0;
            padding: 0;
        }

        div {
            display: block;
        }

        header {
            display: block;
        }

        .head {
            background-color: #2b96ed;
        }

        .head .title {
            padding: 0 60px;
            text-align: center;
        }

        .head .title .title_span {
            font-size:18px;
            line-height: 50px;
            color:#fff;
        }

        .section {
            background-color: #f4f4f4;
        }

        .play-info {
            background-color: white;
        }

        .play-info .play-info-area {
            display: table;
            overflow: hidden;
            width: 100%;
            height: 180px;
            padding: 10px 20px 20px 20px;
            box-sizing: border-box;
            table-layout: fixed;
        }

        .play-info .play-img {
            /* display: table-cell; */
            width: 120px;
            vertical-align: middle;

            /* position: absolute; */
            
            padding-left: 70px;
            padding-top: 20px;
            z-index: 1;
            /* border: 1px solid rgba(0, 0, 0, 0.04); */
            /* content: ''; */
        }

        .play-img img {
            width: 100%;
            height: auto;
            /* vertical-align: top; */

            border: 0;
        }

        .play-info .play-txt {
            display: table-cell;
            overflow: hidden;
            padding-left: 14px;
            text-align: left;
            vertical-align: middle;
        }

        .play-info .play-txt .play-name {
            display: block;
            overflow: hidden;
            text-overflow: ellipsis;
            line-height: 17px;
            white-space: nowrap;
            margin-top: 8px;
            font-size: 14px;
        }

        .play-info .play-txt .play-date {
            display: block;
            overflow: hidden;
            text-overflow: ellipsis;
            line-height: 17px;
            white-space: nowrap;
            margin-top: 5px;
            font-size: 13px;
            color: #959595;
        }

        .section .review-area {
            margin-top: 9px;
            background-color: white;
            text-align: center;
        }

        .star-area {
            border-top: 0;
            background-color: #fff;
            text-align: center;
        }

        .star-area strong {
            display: block;
            border-top: 1px solid #eee;
            padding-top: 28px;
            font-size: 18px;
            font-weight: bold;
        }

        .star-line {
            width: 100%;
            height: 200px;
            position: relative;
            padding: 12px 0 26px;
        }

        .star {
            width: 100%;
            height: 100px;
            position: relative;
            white-space: nowrap;
            float: right;
            border-bottom: 1px solid #eee;
            margin-bottom: 20px;
        }

        .star img {
            width: 12%;
            height: auto;
            padding-top: 15px;
        }

        .text-please {
            /* border-top: 1px solid #eee; */
            background-color: #fff;
            text-align: center;
        }

        .text-please strong {
            display: block;
            padding-top: 28px;
            padding-bottom: 20px;
            font-size: 18px;
            font-weight: bold;
        }

       .txtarea-panel {
            position: relative;
            margin: 11px 20px 0;
            /* padding: 10px 10px 11px; */
            margin-top: 20px;
            border: 1px solid #cbcbcb;
            background-color: #f4f4f4;
        }

        .txt {
            font-size: 15px;
            padding: 10px;
        }

        .txtarea-panel textarea {
            border: none;
            background-color: transparent;
            box-sizing: border-box;
            font-size: 15px;
            color: #555;
        }

        .section .btn-area {
            background-color: #fff;
            text-align: center;
            margin-bottom: 10px;
        }

        .section .btn-area .btn-line {
            padding-top: 33px;
            display: table;
            margin: 0 auto;
            padding: 20px 2px 0;
            box-sizing: border-box;
            table-layout: fixed;
        }

        .btn-line .cancel-area, .btn-line .confirm-area {
            display: table-cell;
            width: 180px;
            padding: 0 2px;
        }

        .section .cancel-area .cancel-btn {
            border-color: #c5cbd0;
            color: #555;
        }

        .section .btn-line .cancel-btn, .section .btn-line .confirm-btn {
            width: 100%;
            height: 40px;
            background-color: transparent;
            cursor: pointer;
            border: 1px solid;
            line-height: 38px;
            font-size: 13px;
            font-weight: 500;
            text-align: center;
        }

        .cancel-btn {
            border-color: rgba(0, 0, 0, 0.1);
            background-color: #2b96ed;
            color: #fff;
        }

    </style>
</head>
<body onresize="parent.resizeTo(480,780)">
    
    <header class="head">
        <h1 class="title">
            <span class="title_span">리뷰 수정하기</span>
        </h1>
    </header>

    <form id="form-id" class="section" method="post">
        <div class="play-info">
            <div class="play-info-area">
               <div class="play-img">
                    <a href="/Nonda/infoDetail.jsp">
                        <img src="/Nonda/resource/image/program/<%=r.getPoster() %>">
                    </a>
                </div> 
               <div class="play-txt">
                   <p class="play-name" name="title"><%=r.getRtitle() %></p>
                   <p class="play-date">2019.08.01</p>
                   <input type="hidden" name="rno" value="<%= r.getRno() %>">
               </div>
            </div>

            <div class="review-area">
                <div class="star-area">
                    <strong>play의 평점을 선택해주세요!</strong>
                    <div class="star_line">
                        <div class="star">
                        <input type="hidden" id="hdField" name="hdstar" value=<%=r.getRstar() %>>
                        
                            <img id="star1" src="/Nonda/resource/image/empty_star.png">
                            <img id="star2" src="/Nonda/resource/image/empty_star.png">
                            <img id="star3" src="/Nonda/resource/image/empty_star.png">
                            <img id="star4" src="/Nonda/resource/image/empty_star.png">
                            <img id="star5" src="/Nonda/resource/image/empty_star.png">
                        </div>
                    </div>
                </div>
                <div class="text-please">
                    <strong>좀 더 자세히 알려주세요!</strong>
                    <div class="txtarea_line">
                        <div class="txtarea_panel">
                        	<!-- textarea name으로 내용 불러옴 -->
                            <textarea class="txt" id="reviewInput" name="rcontent" cols="30" style="width: 400px; height: 200px;"><%= r.getRcontent() %></textarea>
                        </div>
                    </div>

                </div>
            </div>

            <div class="btn-area">
                <div class="btn-line">
                <div class="confirm-area">
                    <button class="confirm-btn" type="submit" onclick="complete()">확인(수정완료)</button>
                </div>
            </div>
            </div>

        </div>
        <script>
        function complete(){
			$("#form-id").attr("action","/Nonda/rUpdate.re");	
		}
        </script>
    </form>

</body>
</html>