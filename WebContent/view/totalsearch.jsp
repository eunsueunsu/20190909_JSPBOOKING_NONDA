<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/Nonda/resource/js/jquery-3.4.1.min.js"></script>
<link rel="shortcut icon" href="/Nonda/resource/image/favicon.png"
	type="image/png">
		<!-- js파일 넣기 -->

<style>
	<%@ include file="/resource/css/totalsearch_css.css"%>
</style>
<title>NONDA_전체 검색</title>
</head>
<body>
<%@ include file="header.jsp"%>
    <section>
        <div id="totalbox">
            <div id="searchbar">
            <form action="/Nonda/view/totalsearch.jsp" 
             name="totalsearch2" method="GET" onsubmit="return check()" >
                <input type="text" id="bigblock" name="kWord">
                <input type="submit" value="검색" id="bigbtn">
                </form>
            </div>

            <div>
                    <br>
                <p>"<span id="kWord"></span> "에 대한 검색 결과입니다.</p>
                <br>
                <!-- <br><br> -->
                
                <h1 >진행중(<span id="nowPNum" class="searchnum">0</span>)</h1>
                <br>
                <div class="currentresult">
                <%for(int i=0; ;i++){ %>
                 <a id="presulta<%=i%>">
                    <div class="resultbox" id="resultbox<%=i %>" value="<%=i %>">
                   
                        <div class="posterbox">
                            <img src="../resource/image/poster2.png" class="posterimg" id="pPoster<%=i%>">
                        </div>
                        <div class="resulttextbox">
                            <span class="line">
                            <span id="pTitle<%=i%>">공연 제목 입니다.</span>
                            <br><br>
                            <span id="pCity<%=i%>">지역</span>
                            <span id="pPlace<%=i%>">장소</span>
                        </span>

                        </div>
                    </div>
            </a>
                
                <%
                if(i==5)break;
                }
                %>

				</div>


                <h2 id="nonedata">데이터가 없습니다.</h2>
                <br><br>
                <h1>마감(0)</h1>
                <br><br>

                <div class="currentresult">
                        <div class="resultbox">
                            <div class="posterbox">
                                <img src="../resource/image/poster2.png" class="posterimg">
                            </div>
                            <div class="resulttextbox">
                                <span class="line">
                                <span>공연 제목 입니다.</span>
                                <br><br>
                                <span>지역</span>
                                <span>장소</span>
                            </span>
    
                            </div>
                     
                      
    
                    </div>

				</div>

                <h2>데이터가 없습니다.</h2>
                <br><br>
                <h1>리뷰(<span id="reviewNum" class="searchnum">0</span>)</h1>
                <br><br>
                 <h2 id="rnonedata">데이터가 없습니다.</h2>
                 <%for(int i=0; ;i++){ %>
                    <div class="reviewresultbox" id="reviewresultbox<%=i %>" value=<%=i %>>
				<a id="rresulta<%=i %>">
                        <div class="reviewresult" >
                            <p class="size18" id="rpTitle<%=i%>" ></p>
                            <span  class="size18" id="rwId<%=i%>"> </span>
                            <span  class="size18" id="rDate<%=i%>"></span>
                            
                            <span class="review_star_rating img5Stars"> <span
									 id ="rstar<%=i %> class="img5Stars""></span>
								</span>
                            
                           <!--  <img src="../resource/image/5stars.png" alt="" class="stars" > -->
                            <p id="rContent<%=i%>"></p>
                        </div>

                        </a>

                    </div>
 				<%
                if(i==5)break;
                }
                %>


               
            </div>
        </div>
    </section>
    <%@ include file="footer.jsp"%>
</body>
		<script src="/Nonda/resource/js/totalsearch_script.js"></script>
</html>