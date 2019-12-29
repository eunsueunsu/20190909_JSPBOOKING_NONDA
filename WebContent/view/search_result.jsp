<%@page import="java.text.DecimalFormat"%>
<%@page import="program.model.vo.Program"%>
<%@page import="program.model.vo.PageInfo"%>
<%@page import="review.model.vo.Review"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%
   ArrayList<Program> plist = (ArrayList<Program>)request.getAttribute("plist");
   ArrayList<Review> rlist = (ArrayList<Review>)request.getAttribute("rlist");
   PageInfo pi = (PageInfo)request.getAttribute("pi");
   
   int listCount   = pi.getListCount();
   int currentPage = pi.getCurrentPage();
   int maxPage     = pi.getMaxPage();
   int startPage   = pi.getStartPage();
   int endPage     = pi.getEndPage();
   
   String syear = (String)request.getAttribute("syear");
   String smonth = (String)request.getAttribute("smonth");
   String culture = (String)request.getAttribute("culture");
   

   
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="/Nonda/resource/image/favicon.png"
   type="image/png">
<script src="/Nonda/resource/js/jquery-3.4.1.min.js"></script>
<script src="/Nonda/resource/js/main_script.js"></script>
<style>
   <%@ include file="/resource/css/search_result_css.css"%>
   <%@ include file="/resource/css/searchbar_css.css"%>
</style>
<title>NONDA_검색</title>
</head>
<body>
   <%@ include file="header.jsp"%>

   <section>
   <div id="all_content">
      <div id="search_test">
         <div id="searchbar">
            <form action="/Nonda/dSearch.do" method="get">
               <select id="year" name="syear"></select> <select id="month"
                  name="smonth"></select>

               <div id="radio-pillbox">
                  <radiogroup>
                  <div>
                     <input type="radio" name="radio-group" value="play"> <label>공연</label>
                     </input>
                  </div>
                  <div>
                     <input type="radio" name="radio-group" value="exhibit"> <label>전시회</label>
                     </input>
                  </div>
                  <div>
                     <input type="radio" name="radio-group" value="festival">
                     <label>축제</label> </input>
                  </div>
                  </radiogroup>
               </div>

               <input type="image" src="/Nonda/resource/image/go.png"
                  id="searchbtn" onclick='dateSearch()'>
            </form>
         </div>
      </div>

      <div id="side_menu">
         <form action="/Nonda/#" id="sideSearch">
            <label>지역</label><br> <input type="checkbox" name="location"
               value="Gyeonggi">경기&nbsp;&nbsp;&nbsp;&nbsp; <input
               type="checkbox" name="location" value="Seoul">서울&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="location" value="Incheon">인천<br>
            <input type="checkbox" name="location" value="Gangwon">강원&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="location" value="Chungnam">충남&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="location" value="Chungbuk">충북<br>
            <input type="checkbox" name="location" value="Daejeon">대전&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="location" value="Gyeongbuk">경북&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="location" value="Gyeongnam">경남<br>
            <input type="checkbox" name="location" value="Daegu">대구&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="location" value="Busan">부산&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="location" value="Ulsan">울산<br>
            <input type="checkbox" name="location" value="Jeonbuk">전북&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="location" value="Jeonnam">전남&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="location" value="Gwangju">광주<br>
            <input type="checkbox" name="location" value="Jeju">제주
            <!-- </form> -->

            <div class="line"></div>

            <!-- <form> -->
            <label>금액</label> <input type="radio" name="money" value="9999">1만원
            이하<br> <input type="radio" name="money" value="30000">3만원
            이하<br> <input type="radio" name="money" value="50000">5만원
            이하<br> <input type="radio" name="money" value="70000">7만원
            이하<br> <input type="radio" name="money" value="90000">9만원
            이하<br> <input type="radio" name="money" value="100000">10만원
            이상<br>
            <!-- </form> -->

            <div class="line"></div>

            <!-- <form> -->
            <label>평점</label> <input type="checkbox" name="grade" value="1">1점&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="grade" value="2">2점&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="grade" value="3">3점<br> <input
               type="checkbox" name="grade" value="4">4점&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="grade" value="5">5점&nbsp;&nbsp;&nbsp;&nbsp;
            <!-- </form> -->

            <div class="line"></div>

            <!-- <form> -->
            <label>연령대</label> <input type="checkbox" name="age" value="1">어린이(만
            9세)<br> <input type="checkbox" name="age" value="2">10대&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="age" value="3">20대&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="age" value="4">30대<br> <input
               type="checkbox" name="age" value="5">40대
            이상&nbsp;&nbsp;&nbsp;&nbsp;
            <!-- </form> -->

            <div class="line"></div>

            <!-- <form> -->
            <label>주차가능</label> <input type="checkbox" name="parking"
               value="free">무료주차&nbsp;&nbsp;&nbsp;&nbsp; <input
               type="checkbox" name="parking" value="charge">유료주차 <input
               type="submit" value="GO">
         </form>
      </div>

      <div id="content">

         <%-- <% if(list.get(0).getpCategory().equals("play")){ %>
                   <%= "공연" %>
                   <% }else if(list.get(0).getpCategory().equals("exhibit")){ %>
                   <%= "전시회" %>
                   <% }else if(list.get(0).getpCategory().equals("festival")){ %>
                   <%= "축제" %>
                   <% } %> --%>

         <% if(listCount == 0 && culture != null){ %>
         <h1 class="msg">검색 결과가 없습니다.</h1>
         <% }else if(listCount == 0 && culture == null){ %>
         <h1 class="msg">공연, 전시회, 축제 중 한가지를 선택하세요.</h1>
         <% }else{ %>
         <% if(plist.get(0).getpCategory().equals("play")){ %>
         <h1>공연</h1>
         <% }else if(plist.get(0).getpCategory().equals("exhibit")){ %>
         <h1>전시회</h1>
         <% }else if(plist.get(0).getpCategory().equals("festival")){ %>
         <h1>축제</h1>
         <% } %>
         <% } %>

         <% for(Program p : plist){ %>
         <a href='/Nonda/InfoDetailServlet?pCode=<%=p.getpCode() %>'>
            <div class="inform">
               <div class="poster_size">
                  <%-- <% String text = new String(c.getpPoster().getBytes("utf-8"),"utf-8"); %> --%>
                  <img src=" /Nonda/resource/image/program/<%= p.getpPoster() %>">
               </div>

               <div class="inform_con">
                  <h2><%= p.getpTitle() %></h2>

                  <table>
                     <tr>
                        <th>장소</th>
                        <td><%= p.getpPlace() %></td>
                     </tr>
                     <tr>
                        <th>가격</th>
                        <td>
                           <% DecimalFormat formatter = new DecimalFormat("###,###"); %> <%=formatter.format(p.getpPrice()) %>원
                        </td>
                     </tr>
                     <tr>
                        <th>날짜</th>
                        <td><%= p.getpStartdate() %> ~ <%= p.getpEnddate() %></td>
                     </tr>
                     <tr>
                        <th>주차</th>
                        <td>
                           <% if(p.getpParking() == 'P'){ %> <%= "유료" %> <% }else if(p.getpParking() == 'F'){ %>
                           <%= "무료" %> <% }else{ %> <%= "불가능" %> <% } %>
                        </td>
                     </tr>
                  </table>

                  <div class="preview">
                     <div class="pre_one">
                     <% int cnt=0; 
                        for(Review r : rlist){%>
                        <% if(p.getpCode() == r.getPcode()){ %>
                        <h5><%= r.getRwriterId() %></h5>
                        <p><%= r.getRcontent() %></p>
                        <% 
                           cnt++;
                           } 
                        }
                        if(cnt == 0){ %>
                        <p>해당 공연의 리뷰가 아직 없습니다.</p>
                        <% } %>
                     </div>
                     <% cnt=0; %>
                  </div>
                  
               </div>
               <!-- .inform_con -->
            </div> <!-- .inform -->
         </a>
         <!-- 첫번째 정보 -->
         <% } %>
         <div id="pageBtn">
            <% if(listCount != 0){ %>
            <img src="/Nonda/resource/image/pre_double.png"
               onclick="location.href='<%= request.getContextPath() %>/dSearch.do?syear=<%= syear %>&smonth=<%= smonth %>&radio-group=<%= culture %>&currentPage=1'">
            <% if(currentPage == 1){ %>
            <img src="/Nonda/resource/image/pre.png">
            <% }else{ %>
            <img src="/Nonda/resource/image/pre.png"
               onclick="location.href='<%= request.getContextPath() %>/dSearch.do?syear=<%= syear %>&smonth=<%= smonth %>&radio-group=<%= culture %>&currentPage=<%= currentPage-1 %>'">
            <% } %>

            <% for(int i = startPage; i <= endPage; i++){ %>
            <% if(i == currentPage){ %>
            <button style="font-weight: bold;"><%= i %></button>
            <% }else{ %>
            <button style="color: #999;"
               onclick="location.href='<%= request.getContextPath() %>/dSearch.do?syear=<%= syear %>&smonth=<%= smonth %>&radio-group=<%= culture %>&currentPage=<%= i %>'"><%= i %></button>
            <% } %>
            <% } %>

            <% if(currentPage == maxPage){ %>
            <img src="/Nonda/resource/image/next.png">
            <% }else{ %>
            <img src="/Nonda/resource/image/next.png"
               onclick="location.href='<%= request.getContextPath() %>/dSearch.do?syear=<%= syear %>&smonth=<%= smonth %>&radio-group=<%= culture %>&currentPage=<%= currentPage+1 %>'">
            <% } %>
            <img src="/Nonda/resource/image/next_double.png"
               onclick="location.href='<%= request.getContextPath() %>/dSearch.do?syear=<%= syear %>&smonth=<%= smonth %>&radio-group=<%= culture %>&currentPage=<%= maxPage %>'">
            <% }else{ %>
            <div></div>
            <% } %>
         </div>
      </div>
      <!—#content —>
   </div>
   <!— #all_content —> </section>

   <%@ include file="footer.jsp"%>
</body>
</html>