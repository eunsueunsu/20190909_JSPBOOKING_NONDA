<%@page import="review.model.vo.Review"%>
<%@page import="booking.model.vo.Booking"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="/Nonda/resource/image/favicon.png"
   type="image/png">
<script src="/Nonda/resource/js/jquery-3.4.1.min.js"></script>
<script src="/Nonda/resource/js/mypage_script.js"></script>
<style>
<%@include file="/resource/css/mypage_css.css"%>
</style>
<title>NONDA_마이페이지</title>


<script>
   $(function() {
      window.name = "parentPage"; // 윈도우의 이름 설정(팝업창에서 부모페이지로 돌아오기 위해)

      //td에 마우스 오버시 색 변경
      $(".tdclass").mouseenter(function() {
         $(this).parent().css({
            "background" : "#E6E6E6",
            "cursor" : "pointer"
         });
      }).mouseout(function() {
         $(this).parent().css({
            "background" : "white"
         });
      });

   });

   function tab2Click() {
      console.log("2번 클릭");

      $.ajax({
         url : "/Nonda/selectList.bo",
         type : 'GET',
         dataType : 'json',
         success : function(data) {
            console.log("tab2 list ajax 성공");
            console.log(data);

            var $table = $('#tbBooking tbody'); // review 테이블에 내용 추가

            $('#tbBooking tbody *').remove();

            for ( var i in data) {
               // 내용을 담은 tr 태그 생성
               var $tr = $('<tr>');

               // 내용을 각각 표현할 td 태그 생성
               var $tdBookingGenre = $(
                     '<td class="tdclass viewBooking">').text(
                     data[i].bgenre);
               var $tdBookingDate = $(
                     '<td class="tdclass viewBooking">').text(
                     data[i].bdate);
               var $tdBookingNo = $(
                     '<td class="tdclass viewBooking">').text(
                     data[i].bno);
               var $tdBookingTitle = $('<td class="tdclass viewBooking"><a href="infoDetail.jsp">'
                     + data[i].ptitle + '</a>'); //공연명으로 바꿔야함   
               var $tdBookingViewdate = $(
                     '<td class="tdclass viewBooking">').text(
                     data[i].bviewDate + "/" + data[i].bcount
                           + "매");

               var url = "/Nonda/rInsertSelect.re?pcode="
                  + data[i].pcode;
               //+ "&bno=" + data[i].bno;
               
               // 날짜로 비교해서 링크 바꿔줘야함!)
               if (data[i].bdaynum < 0) {
                  
                  //var $tdBookingStatus = $('<td class="tdclass viewBooking">관람완료<br><a class="writeReview" href="' + url + '">리뷰쓰기 ></a></td>'); //현재상태로 바꿔야함
                  var $tdBookingStatus = $('<td class="tdclass viewBooking">관람완료<br><a class="writeReview" href="' + url + '">리뷰쓰기 ></a></td>'); //현재상태로 바꿔야함

               } else {
                  //상세보기페이지로 이동하도록 링크 변경해야함
                  var $tdBookingStatus = $('<td class="tdclass viewBooking">예매</td>'); //현재상태로 바꿔야함
               }

               $tr.append($tdBookingGenre).append($tdBookingDate)
                     .append($tdBookingNo).append(
                           $tdBookingTitle).append(
                           $tdBookingViewdate).append(
                           $tdBookingStatus)

               $table.append($tr);
            }

            $(".writeReview").click(function() {
               window.open(this.href, '_blanck','width=480, height=780, resizable=no');
               return false;
            });

         }
      });

   }

   function tab3Click() {

      console.log("3번 클릭");

      $.ajax({
         type : 'GET',
         url : "/Nonda/selectList.re",
         success : function(data) {
            console.log("list ajax 성공");
            console.log(data);

            var $table = $('#tbReview tbody'); // review 테이블에 내용 추가

            $('#tbReview tbody *').remove();

            for ( var i in data) {
               // 내용을 담은 tr 태그 생성
               var $tr = $('<tr>');

               // 내용을 각각 표현할 td 태그 생성
               var $tdReviewNo = $('<td class="tdclass viewReview">')
                     .text(data[i].rno);
               var $tdReviewTitle = $('<td class="tdclass viewReview">')
                     .text(data[i].rtitle);
               var $tdReviewWriter = $('<td class="tdclass viewReview">')
                     .text(data[i].rwriter);
               var $tdReviewDate = $('<td class="tdclass viewReview">')
                     .text(data[i].rdate);
               var $tdReviewCount = $('<td class="tdclass viewReview">')
                     .text(data[i].rrecommend);

               $tr.append($tdReviewNo).append($tdReviewTitle).append(
                     $tdReviewWriter).append($tdReviewDate).append(
                     $tdReviewCount)

               $table.append($tr);
            }

            //팝업창 띄우기
            $(".viewReview").mouseenter(function() {
               $(this).parent().css({
                  "background" : "#E6E6E6",
                  "cursor" : "pointer"
               });
            }).mouseout(function() {
               $(this).parent().css({
                  "background" : "white"
               });
            }).click(
                  function() {
                     var rno = $(this).parent().children().eq(0).text(); // td의 값으로 rno 저장
                     //var rno = data[i].rno;
                     window.open("/Nonda/selectOne.re?rno=" + rno,
                           "리뷰 확인",
                           "scrollbars=yes,width=480,height=780");
            });

         }
      });
   }

   // 위시리스트 탭 클릭
   function tab4Click() {

      console.log("4번 클릭");

      $.ajax({
         type : 'GET',
         url : "/Nonda/selectList.wi",
         success : function(data) {
            console.log("list ajax 성공");
            console.log(data);

            var $table = $('#tbWishlist tbody'); // review 테이블에 내용 추가

            $('#tbWishlist tbody *').remove();

            for ( var i in data) {
               // 내용을 담은 tr 태그 생성
               var $tr = $('<tr>');

               var num = 1;

               // 내용을 각각 표현할 td 태그 생성
               var $tdCheckbox = $('<td><input type="checkbox" id="checkbox" class="tab4_cb tdclass viewWishlist"></td>');
               var $tdWishlistNo = $(
                     '<td class="tdclass viewWishlist">').text(
                     num++);
               var $tdWishlistGenre = $(
                     '<td class="tdclass viewWishlist">').text(
                     data[i].pGenre);
               var $tdWishlistPoster = ('<td class="tdclass viewWishlist"><img src="/Nonda/resource/image/program/' + data[i].pposter + '" width=80px">');
               var $tdWishlistTitle = $(
                     '<td class="tdclass viewWishlist">').text(
                     data[i].ptitle);
               var $tdWishlistDate = $(
                     '<td class="tdclass viewWishlist">')
                     .text(
                           data[i].pStartDate + "~"
                                 + data[i].pEndDate);

               $tr.append($tdCheckbox).append($tdWishlistNo)
                     .append($tdWishlistGenre).append(
                           $tdWishlistPoster).append(
                           $tdWishlistTitle).append(
                           $tdWishlistDate)

               $table.append($tr);
            }

         }
      });
   }

   // 문의하기 탭 클릭
   function tab5Click() {

      console.log("5번 클릭");

      $.ajax({
         type : 'GET',
         url : "/Nonda/qListbyId.qna",
         success : function(data) {
            console.log("qna list ajax 성공");
            console.log(data);

            var $table = $('#tbQna tbody'); // review 테이블에 내용 추가

            $('#tbQna tbody *').remove();

            for ( var i in data) {
               // 내용을 담은 tr 태그 생성
               var $tr = $('<tr>');

               // 내용을 각각 표현할 td 태그 생성         
               var $tdQnaNo = $('<td class="tdclass viewQna">').text(data[i].qNum);
               var $tdPlayName = $('<td class="tdclass viewQna">').text(data[i].pTitle);
               var $tdQnaTitle = $('<td class="tdclass viewQna">').text(data[i].qTitle);
               var $tsQnaDate = $('<td class="tdclass viewQna">').text(data[i].qDate);
               var $tdAnswer = $('<td class="tdclass viewQna">').text(data[i].qCompletedOrNot);

               $tr.append($tdQnaNo)
                     .append($tdPlayName).append(
                           $tdQnaTitle).append(
                           $tsQnaDate).append(
                           $tdAnswer)

               $table.append($tr); 
            }
            
            //팝업창 띄우기
            $(".viewQna").mouseenter(function() {
               $(this).parent().css({
                  "background" : "#E6E6E6",
                  "cursor" : "pointer"
               });
            }).mouseout(function() {
               $(this).parent().css({
                  "background" : "white"
               });
            }).click(function() {
               var qno = $(this).parent().children().eq(0).text(); // td의 값으로 rno 저장
               //var qno = data[i].qNum;
               window.open("/Nonda/aDetail.qna?qno=" + qno,
                     "문의 확인",
                     "scrollbars=yes,width=480,height=780");
            });
      
         }
      
      });
      
      
      

   }
</script>


</head>
<body>
   <%@ include file="header.jsp"%>

   <section>
   <div class="box-wrapper">
      <div class="first-wrapper">
         <div class="profile-panel">
            <div class="mynonda">
               <p>MY NONDA</p>
            </div>

            <div class="myprofile-wrapper">
               <div class="myprofile">
                  <div class="profile-text username"><%=m.getmName()%></div>

                  <div class="profile-text profile_manage">
                     <%
                        if (m.getmAccess().equals("customer")) {
                     %>
                     일반 회원
                     <%
                        } else if (m.getmAccess().equals("company")) {
                     %>
                     업체 회원
                     <%
                        } else {
                     %>
                     관리자
                     <%
                        }
                     %>
                  </div>
               </div>
            </div>
         </div>

         <div class="point-panel">
            <div class="item">
               <div class="item-header text-md">사용 가능 포인트</div>
               <div class="item-count text-md" id="mypoint"></div>
            </div>

            <div class="item">
               <div class="item-header text-md">미사용 티켓</div>
               <div class="item-count text-md">0 장</div>
            </div>
         </div>
      </div>

      <div id="vtab">
         <ul class="tabs">
            <li data-tab="tab1" class="profile tab-item current"
               onclick="tab1Click()">
               <div class="tab-item">내 정보</div>
            </li>
            <li data-tab="tab2" class="tab-item ticket" onclick="tab2Click()">
               <div class="tab-item">예매 내역</div>
            </li>
            <li data-tab="tab3" id="litab3" class="review tab-item"
               onclick="tab3Click()">
               <div class="tab-item">내가 쓴 리뷰</div>
            </li>
            <li data-tab="tab4" class="wishlist tab-item" onclick="tab4Click()">
               <div class="tab-item">위시리스트</div>
            </li>
            <li data-tab="tab5" class="ask tab-item" onclick="tab5Click()">
               <div class="tab-item">문의내역 확인</div>
            </li>
            <li data-tab="tab6" class="point tab-item" onclick="tab6Click()">
               <div class="tab-item">포인트 현황</div>
            </li>
            <li data-tab="tab7" class="drop tab-item" onclick="tab7Click()">
               <div class="tab-item">회원 탈퇴</div>
            </li>

         </ul>

         <!-- 내 정보 tab -->
         <div id="tab1" class="tab-content current">
            <div id="tab1-1">
               <div class="mypage-wrapper">
                  <div class="form-group">
                     <div class="sub-title">
                        비밀번호 <span>*</span>
                     </div>

                     <div>
                        <input type="password" id="pwd-now" class="form-control"
                           placeholder="비밀번호를 입력해주세요.">
                     </div>
                  </div>

                  <input type="button" id="pwd-now-btn"
                     class="mypage-btn pwdnow-confirm" value="확인">

                  <div class="warning">
                     <label id="pw_warning"></label>
                  </div>
               </div>
            </div>

            <div id="tab1-2">
               <input type="button" class="mypage-btn btn1" value="수정하기">

               <div class="mypage-wrapper">
                  <div class="form-group">
                     <div class="row-group">
                        <div class="title">이메일(아이디)</div>

                        <div class="input-wrapper">
                           <div class="row">
                              <input class="form-control text-content" readonly type="text"
                                 value=<%=m.getmId()%>>
                           </div>
                        </div>
                     </div>

                     <div class="row-group">
                        <div class="title">이름</div>

                        <div class="input-wrapper">
                           <div class="row">
                              <input class="form-control text-content" readonly type="text"
                                 value=<%=m.getmName()%>>
                           </div>
                        </div>
                     </div>

                     <div class="row-group">
                        <div class="title">전화번호</div>

                        <div class="input-wrapper">
                           <div class="row">
                              <input class="form-control text-content can-modify" readonly
                                 type="text" id="phone">
                           </div>
                        </div>

                        <div class="warning">
                           <label id="phone_warning"></label>
                        </div>
                     </div>

                     <div class="row-group">
                        <div class="title newpwd">새 비밀번호</div>

                        <div class="input-wrapper">
                           <div class="row">
                              <input class="form-control text-content can-modify" readonly
                                 type="password" id="newpw">
                           </div>
                        </div>

                        <div class="warning">
                           <label id="pwd_warning"></label>
                        </div>
                     </div>

                     <div class="row-group">
                        <div class="title newpwd2">새 비밀번호 확인</div>

                        <div class="input-wrapper">
                           <div class="row">
                              <input class="form-control text-content can-modify" readonly
                                 type="password" id="newpwcheck">
                           </div>
                        </div>

                        <div class="warning">
                           <label id="pwdcheck_warning"></label>
                        </div>
                     </div>
                  </div>
               </div>

               <input type="button" class="mypage-btn btn2" value="확인"
                  onclick="memberUpdate()">
            </div>
         </div>

         <!-- 예매 내역 tab -->
         <div id="tab2" class="common_table tab2-table tab-content">

            <table cellspacing='0' class="tab2_tb" id="tbBooking">
               <thead>
                  <tr>
                     <th width="40px;">종류</th>
                     <th width="50px;">예매일</th>
                     <th width="53px;">예매번호</th>
                     <th width="120px;">상품명</th>
                     <th>이용일/매수</th>
                     <th width="60px;">현재상태</th>
                  </tr>
               </thead>

               <tbody>
                  <!-- ajax로 내용 추가 -->

               </tbody>
            </table>
         </div>

         <!-- 내가 쓴 리뷰 tab -->
         <div id="tab3" class="tab-content">
            <table class="checkbox_tb" id="tbReview">
               <colgroup>
                  <col width="50">
                  <col width="80">
                  <col width="20">
                  <col>
                  <col width="90">
               </colgroup>
               <thead>
                  <tr>
                     <th scope="col">번호</th>
                     <th scope="col" width=300px>공연명</th>
                     <th scope="col">작성자</th>
                     <th scope="col" class="side2">작성일</th>
                     <th scope="col">좋아요</th>
                  </tr>
               </thead>
               <tbody>

               </tbody>
            </table>

         </div>

         <!-- 위시리스트 tab -->
         <div id="tab4" class="tab-content">

            <table class="checkbox_tb" id="tbWishlist">
               <colgroup>
                  <col width="20">
                  <col width="50">
                  <col width="80">
                  <col width="20">
                  <col>
                  <col width="90">
               </colgroup>
               <thead>
                  <tr>
                     <th scope="col"><input type="checkbox" id="checkAll"></th>
                     <th scope="col">번호</th>
                     <th scope="col">장르</th>
                     <th scope="col">이미지</th>
                     <th scope="col" width="300px;">공연명</th>
                     <th scope="col" class="side2">기간</th>

                  </tr>
               </thead>
               <tbody>


               </tbody>
            </table>



         </div>

         <!-- 문의내역 확인 tab -->
         <div id="tab5" class="tab-content">
            <table class="checkbox_tb question" id="tbQna">
               <colgroup>
                  <col width="50">
                  <col width="80">
                  <col width="20">
                  <col>
                  <col width="90">
               </colgroup>
               <thead>
                  <tr>
                     <th scope="col">번호</th>
                     <th scope="col" width=300px>공연명</th>
                     <th scope="col" width=200px>제목</th>
                     <th scope="col" class="side2">질문일</th>
                     <th scope="col" class="answer">답변여부</th>
                  </tr>
               </thead>
               <tbody>
                  
               </tbody>
            </table>

         </div>

         <!-- 포인트 현황 tab -->
         <div id="tab6" class="common_table tab-content">
            <table cellspacing='0' class="tab6_tb" id="tbPoint">
               <thead>
                  <tr>
                     <th width="80px">날짜</th>
                     <th width="">내역</th>
                     <th width="80px">포인트</th>
                     <th width="80px">소계</th>
                  </tr>
               </thead>

               <tbody>
                  <!-- ajax로 내용 추가 -->

               </tbody>
            </table>
         </div>

         <!-- 회원 탈퇴 tab -->
         <div id="tab7" class="tab-content">
            <div id="tab7-1">
               <div class="mypage-wrapper">
                  <div class="form-group">
                     <div class="sub-title">
                        비밀번호 <span>*</span>
                     </div>

                     <div>
                        <input type="password" id="droppw" class="form-control"
                           placeholder="비밀번호를 입력해주세요.">
                     </div>
                  </div>

                  <input type="button" id="dropbtn"
                     class="mypage-btn pwdnow-confirm" value="확인">

                  <div class="warning">
                     <label id="droppw_warning"></label>
                  </div>
               </div>
            </div>

            <div id="tab7-2">
               <div class="droppage-wrapper">
                  <div class="drop-group">
                     <div class="sub-title">정말 탈퇴하시겠습니까? (탈퇴 시, 해당 아이디로는 재가입 할 수
                        없습니다.)</div>

                     <div>
                        <input type="button" class="mypage-btn droppw-confirm" value="예"
                           onclick="dropok()")> <input type="button"
                           class="mypage-btn droppw-confirm" value="아니오"
                           onclick="dropno()">
                     </div>
                  </div>
               </div>
            </div>
         </div>

      </div>

   </div>
   </section>

   <%@ include file="footer.jsp"%>
</body>
</html>