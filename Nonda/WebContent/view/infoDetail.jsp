<%@page import="java.text.DecimalFormat"%>
<%@page import="qna.model.vo.Qna"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="program.model.vo.*,java.util.*,review.model.vo.*,wishlist.model.vo.*"%>

<%
	Program pi = (Program)request.getAttribute("p");
	System.out.println("jsp의 pi"+pi);

	ArrayList<Review> rList = (ArrayList<Review>) request.getAttribute("rList");
	if (rList != null) {
		System.out.println("jsp에 review정보 불러오기 성공");
		System.out.println("jsp의 리뷰 리스트: "+rList);
	}
	ArrayList<Qna> q = (ArrayList<Qna>) request.getAttribute("q");

	ArrayList<Integer> rLikeList = (ArrayList<Integer>) request.getAttribute("rLikeList");
	System.out.println(rLikeList);
	
	Review bSatisR=(Review)request.getAttribute("bSatisR");
	Review bUnsatisR=(Review)request.getAttribute("bUnsatisR");
	
	System.out.println(bSatisR);
	System.out.println(bUnsatisR);
	
	ArrayList<Wishlist> wList = (ArrayList<Wishlist>) request.getAttribute("wList");
	
	System.out.println(wList);
	
	
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<script src="/Nonda/resource/js/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<!-- <meta http-equiv="X-UA-Compatible" content="ie=edge"> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="shortcut icon" href="/Nonda/resource/image/favicon.png"
	type="image/png">
<script>
function dologin() {
	alert("로그인이 필요합니다.");
};
</script>

<style>
<%@includefile="/resource/css/infoDetail_css.css"%>
</style>

<title>NONDA</title>

</head>
<!-- pcode 저장할 hidden필드 -->
<input type="hidden" name="hdPcode" id="hdPcodeId"
   value=<%=pi.getpCode()%>>


<body>
	<%@ include file="header.jsp"%>
	
	<section>

		<div id="top-box">


			<div class="topboxdiv">
				<img src="/Nonda/resource/image/program/<%=pi.getpPoster()%>"
					style="width: 320px;">


			</div>

			<div class="topboxdiv tb2">
				<!-- 포스터 옆 정보 박스 -->
				<div class="infobox_1">
					<div class="titlebox">
						<p><%=pi.getpTitle()%></p>
					</div>

					<div>
						<p></p>
						<p><%=pi.getpScore()%></p>
						<img src="/Nonda/resource/image/star.png" alt="" class="imgStar">
					</div>
					<hr>
				</div>
				<br>
				<div>
					<div class="infobox_2 ifb1">
						<p>장르</p>
						<p>날짜</p>
						<p>등급</p>
						<p>관람시간</p>
						<p>장소</p>
						<P>주차</P>

						<p>티켓 가격</p>
					</div>

					<div class="infobox_2 ifb2">
						<!-- db에서 가져올 부분 -->

						<%
							String c = null;
							if (pi.getpCategory().equals("exhibit")) {
								c = "전시회";
							} else if (pi.getpCategory().equals("play")) {
								c = "공연";
							} else {
								c = "축제";
							}
							String p = null;
							if (/* pi.getpParking().equals("X") */pi.getpParking()=='X') {
								p = "주차 불가";
							} else if (pi.getpParking()=='F') {
								p = "무료주차";
							} else {
								p = "유료주차";
							}
						%>

						<p><%=c%></p>
						<p><%=pi.getpStartdate()%> ~ <%=pi.getpEnddate()%></p>
						<p><%=pi.getpGrade()%></p>
						<p><%=pi.getpTime()%>분
						</p>
						<p><%=pi.getpCity()%>
							<%=pi.getpPlace()%></p>
						<p><%=p%></p>
						<p><% DecimalFormat formatter = new DecimalFormat("###,###"); %> <%=formatter.format(pi.getpPrice()) %>원
						</p>

					</div>



				</div>


				<hr>
<!-- 				
				
				<div id="button-box">
					<a href="#"> <img src="/Nonda/resource/image/contract.png"
						alt="" class="imgReview">
					</a> <a href="#"> <img src="/Nonda/resource/image/like.png" alt=""
						class="imgLike">
					</a> <a href="#"> <img src="/Nonda/resource/image/share.png" alt=""
						class="imgShare">
					</a>
					<button class="bookingButton">예매하기</button>
					response.sendRedirect("selectOne.bo?bno="+bno); 형식으로

				</div>







			</div>


		</div>
 -->
 <%
               if (m == null) { // 로그인 안했을경우
            %>
            <div id="button-box">
               <a href="#"> <img src="/Nonda/resource/image/contract.png"
                  alt="" class="imgReview">
               </a> <img src="/Nonda/resource/image/like.png" id="likeImg" alt=""
                  class="imgLike" onclick="loginPlease()"> <a href="#"> <img
                  src="/Nonda/resource/image/share.png" alt="" class="imgShare">
               </a>
               <button class="bookingButton" onclick="dologin()">예매하기</button>
               <!-- response.sendRedirect("selectOne.bo?bno="+bno); 형식으로 -->

            </div>
            <%
               } else { // 로그인 했을경우
            %>
            <div id="button-box">
               <a href="#"> <img src="/Nonda/resource/image/contract.png"
                  alt="" class="imgReview">
               </a>

               <%
                  int val = 0;
                     
                     for (int i = 0; i < wList.size(); i++) {
                        // 해당 공연을 현재 로그인한 회원이 위시리스트에 추가했을 경우        
                        if (wList.get(i).getmId().equals(m.getmId())) {
                           //System.out.println("아이디가있다!!!!!!!!!!");
                           //wno = wList.get(i).getWno();
                           //System.out.println("wno: " + wno);

                           val++;
               %>
               <!-- 위시리스트 번호 저장할 hidden 필드 -->

               <!-- <img src="/Nonda/resource/image/like_full.png" id="likeImg" alt="" class="imgLike full-arrow" onclick="deleteWishlist()"> -->
               <img src="/Nonda/resource/image/like_full.png" id="likeImg" alt=""
                  class="imgLike full-arrow" onclick="wishlist()">
               <%
                  break;
                        }
                     }
               %>

               <%
                  if (val == 0) { // 로그인한 회원의 위시리스트에 없을 경우 
                                 // 빈하트 이미지로 변경, 클릭시 위시리스트에 추가
               %>
               <!-- <img src="/Nonda/resource/image/like.png" id="likeImg" alt="" class="imgLike empty-arrow" onclick="addWishlist()">  -->
               <img src="/Nonda/resource/image/like.png" id="likeImg" alt=""
                  class="imgLike empty-arrow" onclick="wishlist()">
               <%
                  }
               %>


               <a href="#"> <img src="/Nonda/resource/image/share.png" alt=""
                  class="imgShare">
               </a>
               <button class="bookingButton" onclick="location.href='/Nonda/reservation.do?pCode=<%=pi.getpCode()%>'">예매하기</button>
               <!-- response.sendRedirect("selectOne.bo?bno="+bno); 형식으로 -->

            </div>
            <%
               }
            %>

         </div>


      </div>
 
		<!-- 하단박스 -->
		<div id="bottomBox">

			<div class="tab">
				<button class="tablinks" onclick="fnMove('1')">상세정보</button>
				<button class="tablinks" onclick="fnMove('2')">후기</button>
				<button class="tablinks" onclick="fnMove('3')">Q&A</button>
			</div>


			<!-- Tab content -->
			<div id="tContentdiv1" class="tabcontent">

<!-- 				<h3>상세정보</h3> -->
				<br>
				<p></p>
				<br> <br> <img src="/Nonda/resource/image/program/<%=pi.getpDetail()%>" alt=""
					class="infoImg">



			</div>
			<hr>

			<div id="tContentdiv2" class="tabcontent">
				<!-- <h3>후기 (00)</h3> -->

				<div class="rboxtop">
					<div class="gradebox">
						<h3>REVIEW</h3>
						<br> <br> <span class="star_rating"> <span
							style="width: <%=pi.getpScore() * 20%>%"> <!-- <img src="../resource/image/5stars.png" class="star" > -->
						</span>
						</span> &nbsp;&nbsp;&nbsp; <span class="info_grade"> <%=pi.getpScore()%>
						</span> &nbsp;
						<%
							if (rList.size() != 0) {
						%>
						<span> <%=rList.size()%> 개의 후기
						</span>
						<%
							}
						%>
						<!-- nomal 리뷰탭에 "등록된 후기가 없습니다." 띄울거라 여기서는  안보이게함  -->


					</div>
					<%if(bSatisR!=null){ %>
					<div class="satisReview">
						
						<hr>
						<p>만족 후기 BEST</p>
						<br>
						<div class="userTag">
							<img src="<%=bSatisR.getrFaceImg() %>"
								class="profileImg"> &nbsp;
							<p><%=bSatisR.getRwriterId() %></p>

							<span class="review_star_rating img5Stars"> <span
									class="img5Stars" style="width:<%=bSatisR.getRstar() * 20%>%"></span>
								</span>

						</div>

						<div class="articleR">
							<br>
							<p class="bestRcontent"><%=bSatisR.getRcontent() %></p>
							<br>
							<div class="like_modifybutton">


									<%
										String emptyLike = "/Nonda/resource/image/empty_love.png";
											String Like = "/Nonda/resource/image/love.png";

											if (m != null) {

												if (rLikeList.contains(bSatisR.getRno())) {
									%>



									<li><img src="<%=Like%>" class="like<%=bSatisR.getRno()%> rlike"
										onclick="reviewlike(<%=bSatisR.getRno()%>,<%=pi.getpCode()%>,<%=bSatisR.getRrecommend()%>)">
										</li>
									<%
										} else {
									%>
									<img src="<%=emptyLike%>" class="like<%=bSatisR.getRno()%> rlike"
										onclick="reviewlike(<%=bSatisR.getRno()%>,<%=pi.getpCode()%>,<%=bSatisR.getRrecommend()%>)">
									</li>
									<%
										}
											} else {
									%>
									<img src="<%=emptyLike%>" class="like<%=bSatisR.getRno()%> rlike" onclick="loginplease()">
									</li>
									<%
										}
									%>
									<li><span> 좋아요 <span class="rNum<%=bSatisR.getRno()%>"><%=bSatisR.getRrecommend()%></span>
											개
									</span></li>
						</div>
					</div>
					
					</div>
					<%
					}
					%>


					<%if(bUnsatisR!=null){ %>
					<div class="unsatisReview">
						
						<hr>
						<p>불만족 후기 BEST</p>
						<br>
						<div class="userTag">
							<img src="<%=bUnsatisR.getrFaceImg() %>" alt=""
								class="profileImg"> &nbsp;
							<p><%=bUnsatisR.getRwriterId() %></p>

							<span class="review_star_rating img5Stars"> <span
									class="img5Stars" style="width:<%=bUnsatisR.getRstar() * 20%>%"></span>
								</span>

						</div>

						<div class="articleR">
							<br>
							<p class="bestRcontent"><%=bUnsatisR.getRcontent() %></p>
							<br>
							<div class="like_modifybutton">


									<%
										String emptyLike = "/Nonda/resource/image/empty_love.png";
											String Like = "/Nonda/resource/image/love.png";

											if (m != null) {

												if (rLikeList.contains(bUnsatisR.getRno())) {
									%>



									<li><img src="<%=Like%>" class="like<%=bUnsatisR.getRno()%> rlike"
										onclick="reviewlike(<%=bUnsatisR.getRno()%>,<%=pi.getpCode()%>,<%=bUnsatisR.getRrecommend()%>)">
										</li>
									<%
										} else {
									%>
									<img src="<%=emptyLike%>" class="like<%=bUnsatisR.getRno()%> rlike"
										onclick="reviewlike(<%=bUnsatisR.getRno()%>,<%=pi.getpCode()%>,<%=bUnsatisR.getRrecommend()%>)">
									</li>
									<%
										}
											} else {
									%>
									<img src="<%=emptyLike%>" class="like<%=bUnsatisR.getRno()%> rlike" onclick="loginplease()">
									</li>
									<%
										}
									%>
									<li><span> 좋아요 <span class="rNum<%=bUnsatisR.getRno()%>"><%=bUnsatisR.getRrecommend()%></span>
											개
									</span></li>
						</div>
					</div>
					</div>
					<%
					}
					%>


				<div class="rboxbottom">
					<div class="nomalReview">

						<br>
						<div class="reviewTab">
							<!-- <h3>후기 (3)</h3> -->
							<span><a href="#">베스트순</a></span> <span><a href="#">최신순</a></span>
						</div>
						<%
							int i = 0;
							for (Review r : rList) {
								i++;
						%>
						<div class="review">
							<div class="userTag2">
								<br> <br><img src="<%=r.getrFaceImg() %>" class="profileImg pimg2">
									<!-- class="profileImg pimg2" <%=r.getrFaceImg()%>-->
								<p class="userName">
									<%=r.getRwriterId()%>
								</p>
								<span class="review_star_rating img5Stars"> <span
									class="img5Stars" style="width:<%=r.getRstar() * 20%>%"></span>
								</span>
								<!-- <img src="/Nonda/resource/image/5stars.png" alt=""
									class="img5Stars"> -->
								<%-- <%=r.getRstar()*20%> --%>

								<p><%=r.getRdate()%></p>

							</div>
							<div class="articleR2">
								<p class="review_content"><%=r.getRcontent()%>
								</p>
								<br>

								<div class="like_modifybutton">


									<%
										String emptyLike = "/Nonda/resource/image/empty_love.png";
											String Like = "/Nonda/resource/image/love.png";

											if (m != null) {

												if (rLikeList.contains(r.getRno())) {
									%>



									<li><img src="<%=Like%>" class="like<%=r.getRno()%> rlike"
										onclick="reviewlike(<%=r.getRno()%>,<%=pi.getpCode()%>,<%=r.getRrecommend()%>)"></li>
									<% 
										} else {
									%>
									<img src="<%=emptyLike%>" class="like<%=r.getRno()%> rlike"
										onclick="reviewlike(<%=r.getRno()%>,<%=pi.getpCode()%>,<%=r.getRrecommend()%>)">
						</li>
									<%
										}
											} else {
									%>
									<img src="<%=emptyLike%>" class="like<%=r.getRno()%> rlike" onclick="loginplease()">
									</li>
									<%
										}
									%>
									<li><span> 좋아요 <span class="rNum<%=r.getRno()%>"><%=r.getRrecommend()%></span>
											개
									</span></li>

									<%
										if (m != null && m.getmId().equals(r.getRwriterId())) {
									%>
									<li><button class="reviewmodify rightbutton">수정</button></li>
									<li><button class="reviewdelete rightbutton">삭제</button></li>

									<%
										}
									%>
								</div>
							</div>

						</div>
						<%
							}
						%>


						<!-- 	<div class="review">

							<div class="userTag2">
								<br> <br> <img
									src="/Nonda/resource/image/새 폴더/man.png" alt=""
									class="profileImg pimg2">
								<p class="userName">열일BUT느림</p>
								<img src="/Nonda/resource/image/5stars.png" alt=""
									class="img5Stars">

								<p>2019.07.11</p>

							</div>
							<div class="articleR2">
								<p>빨간 맛 궁금해 honey 깨물면 점점 녹아든 스트로베리 그 맛 코너 캔디 샵 찾아 봐 baby 내가
									제일 좋아하는 건 여름 그 맛 야자나무 그늘 아래 졸고 싶고 뜨거운 여름밤의 바람은 불고 너무 쉽게 사랑 빠져
									버릴 나인틴 우린 제법 어울리고 또 멋져 좋아 첫눈에 반해 버린 네가 자꾸만 생각나 내 방식대로 갈래 빨간 맛
									궁금해 honey 깨물면 점점 녹아든 스트로베리 그 맛 코너 캔디 샵 찾아 봐 baby 내가 제일 좋아하는 건
									여름 그 맛, yeah 일곱 개의 무지갯빛 문을 열어 너의 세상은 짜릿해 멋있어, um 태양보다 빨간 네 사랑의
									색깔 내가 가질래 내 멋대로 할래 날 봐 넌 뭘 생각하는데 오늘 뭘 할 수 있을까 내 맘대로 상상해</p>
								<br>
								<div class="like_modifybutton">

									<li><button>좋아요</button></li>
									<li><span>
											<p class="reviewlikenumber">2개</p>
									</span></li>
									<li><button class="reviewmodify rightbutton">수정</button></li>
									<li><button class="reviewdelete rightbutton">삭제</button></li>


								</div>
							</div>
						</div> -->


					</div>

				</div>
			</div>

		</div>
		<hr>

		<div id="tContentdiv3" class="tabcontent">

			<div class="qna_container">
				<div class="page_header">
					<li>
						<h3>Q & N</h3>
					</li>
					<%
						if (m != null) {
					%>
					<li><button class="qna_write qna_write_function">문의하기</button></li>
					<%
						}else{
					%>
					<li><button class="qna_write" onclick="loginplease()">문의하기</button></li>
					<%
					}
					%>
					<!-- else로 로그인 정보 없을경우 다른 버튼 띄우기-->
				</div>
				<div id="content"></div>
				<div class="table_container">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">글번호</th>
								<th scope="col">제목</th>
								<th scope="col">글쓴이</th>
								<th scope="col">날짜</th>
								<th scope="col">답변여부</th>

							</tr>
						</thead>
						<tbody>
							<%int qbNum=0;
								for (Qna qna : q) {
									qbNum++;
								
							%>
							<tr class="qtclick">
								<th scope="row"><%=qbNum%></th>

								<td><%=qna.getqTitle()%></td>
								<td><%=qna.getqId()%></td>
								<td><%=qna.getqDate()%></td>
								<%-- <% if(qna.getqCompletedOrNot().equals("X")){%>  --%>
								<%
									if (qna.getqAnswer() == null) {
								%>

								<td>답변대기</td>
								<%
									} else {
								%>
								<td>답변완료</td>
								<%
									}
								%>

							</tr>

							<tr class="article">
								<td class="QuestionBox" colspan="5" width="930px">
									<div class="QuestionBox_div">
										<%=qna.getqContent()%>
										<%
											if (qna.getqAnswer() != null) {
										%>
										<hr>
										<p><%=qna.getqAnswer()%>
										</p>

										<%
											}
										%>


									</div>
								</td>
							</tr>
							<%
								}
							%>


						</tbody>
					</table>

				</div>

			</div>
			<!-- </div> -->

		</div>

		</div>

		<div class="dim2"></div>
		</div>

		<!-- 문의하기팝업 nonedisplay -->
		<form name="qna" onsubmit="return checkqna()"
			action="<%=request.getContextPath()%>/qInsert.do" method="post">
			<div class="popup_qna">
				<div class="QnaLogoDiv">
					<img src="/Nonda/resource/image/logo1.png" alt="" class="QnaLogo">
				</div>
				<div class="QnaInputTitle">
					<input type="text" class="QnaTitle" placeholder="제목을 입력하세요"
						name="title">
				</div>
				<div class="QnaInputArticle">
					<textarea class="QnaArticle" id="" placeholder="무엇이 궁굼하신가요?"
						name="content"></textarea>

				</div>
				<!-- 공연코드를 넘겨주는 히든필드 -->
				<div>
					<input type=hidden name=pcode id=pcode value=<%=pi.getpCode()%>>
				</div>

				<div class="QnaWritingPage__Buttons">
					<!-- <button class="CancelButton">취소</button> -->
					<input type="button" class="CancelButton" value="취소">
					<button type="submit" class="qnawWritingPage__SubmitButton">완료</button>




				</div>
			</div>
		</form>


	</section>

	<%@ include file="footer.jsp"%>
	<%@ include file="top.jsp"%>

</body>
<script>
	$(function() {
		var out = $("#pcode").val();
		/* console.log(out); */
	});
	
	function checkqna() {

		if (qna.title.value == "") {

			alert("값을 입력해 주세요.");

			qna.title.focus();

			return false;

		}

		else if (qna.content.value == "") {

			alert("값을 입력해 주세요.");

			qna.content.focus();

			return false;

		}

		else
			return true;

	}

		
		
		function reviewlike(rno,pCode,rRec){
			console.log(rno,pCode,rRec);
	      $.ajax({
	               type: "get",
	               url: "/Nonda/ReviewLikeUpdateServlet",
	               data: {rno: rno,pCode:pCode},
	               dataType: "json",
	               success: function(data) {
	            	   console.log(data);
	            
						var likeImg=$('.like'+rno);
						var rNum=$('.rNum'+rno);
						console.log(data.idCheck);
	                if(data.idCheck==1){
	            	 //삭제 delete됐을 경우 data 1 반환
	               
	            	   console.log('좋아요 삭제됨');
	            	 	
	            	   likeImg.attr('src','/Nonda/resource/image/empty_love.png'); //빈하트
	            	   
	            	   rNum.text(data.likeNum); //업데이트된 좋아요수 가져와서 출력
	            	   
	            	   }else{//추가 insert했을 경우 data 0 반환
	            		   console.log('else');
	            		 
	            		 likeImg.attr('src','/Nonda/resource/image/love.png');
	            		 
	            		 rNum.text(data.likeNum); //업데이트된 좋아요수 가져와서 출력
	            		 
	            		   } 
	               
	            },
	                error: function() {
	                	console.log("실패!!");
	            }
	      }); 
	}
	
	function loginplease(){
		alert("로그인 먼저 해주세요 ^ㅁ^");
	}
	
	// 로그인해주세요 alert를 띄우는 메서드
	   function loginPlease() {
	      alert("로그인을 먼저 해주세요!");
	   }

	   function wishlist() {

	      var pcode = $("#hdPcodeId").val();

	      // 색칠된 하트일때
	      if ($("#likeImg").attr('src') == "/Nonda/resource/image/like_full.png") {

	         $
	               .ajax({
	                  type : "GET",
	                  url : "/Nonda/wDelete.wi?pcode=" + pcode,
	                  dataType : 'json',
	                  data : {
	                     pcode : pcode
	                  },
	                  success : function(data) {
	                     //console.log(data);

	                     $("#likeImg").attr('src',
	                           "/Nonda/resource/image/like.png");
	                     console.log("Delete ajax 성공");

	                  },
	                  error : function() {
	                     alert("delete 실패 ㅠ");
	                  }
	               });

	      } else { // 빈하트일때

	         console.log("비어있음");

	         console.log("infoDetail.jsp pcode: " + pcode);

	         $.ajax({
	            type : "GET",
	            url : "/Nonda/wInsert.wi",
	            dataType : 'json',
	            data : {
	               pcode : pcode
	            },
	            success : function(data) {
	               //console.log(data);

	               $("#likeImg").attr('src',
	                     "/Nonda/resource/image/like_full.png");
	               console.log("Insert ajax 성공");

	            },
	            error : function() {
	               alert("insert 실패 ㅠ");
	            }
	         });

	      }
	   }

	// 여기 없으면 디테일페이지에서 검색기능이 되지 않음
	   function check() {

			if (totalsearch.kWord.value == ""||totalsearch.kWord.value == " ") {

				alert("검색어를 입력해 주세요.");

				totalsearch.kWord.focus();

				return false;

			}else return true;
		}
	
</script>
<!-- 탭고정 쿼리가 안먹혀서 그것도 아래로 옮겼더니 해결됨 -->
<script src="/Nonda/resource/js/infoDetail_script.js"></script>
<script src="/Nonda/resource/js/infoDetail_arcodian_script.js"></script>
<!-- display none  div  -->
<div class="popupR"></div>

</html>