<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="qna.model.vo.*, member.model.vo.*"%>
<%
Qna q = (Qna)request.getAttribute("qna");
//System.out.println("answerDetail q: " + q);
Member m = (Member) session.getAttribute("member"); // 로그인 정보
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공연문의 확인하기</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
    
    
</script>

<style>
<
style>body {
	background: #fff;
	font-family: verdana;
}

.section {
	width: 100%;
	height: 1500px;
}

.outer {
	/* width: 800px; */
	margin: 0 auto;
}

h2 {
	padding-top: 20px;
	padding-bottom: 20px;
	/* margin-top: 20px; */
	font-size: 28px;
	text-align: center;
	background-color: #efefef;
}

table.type05 {
	border-collapse: separate;
	border-spacing: 1px;
	text-align: left;
	line-height: 1.5;
	border-top: 1px solid #ccc;
	margin: 20px 10px;
}

table.type05 th {
	width: 130px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
	background: #efefef;
}

table.type05 td {
	width: 650px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}

.btn-area {
	text-align: center;
}

.btn {
	width: 120px;
	height: 40px;
	border: 1px solid rgb(185, 183, 183);
}

.btn-confirm {
	margin-right: 10px;
}
</style>

</head>

<body>
	<section>
		<div class="outer">
		
		<form action="<%=request.getContextPath()%>/update.qna">
			<h2>공연문의 답변하기</h2>
			<div class="tableArea">
				<table class="type05">
					<tr>
						<th scope="row">공연명</th>
						<td><label><%=q.getpTitle() %></label></td>
					</tr>
					<tr>
						<th scope="row">작성자</th>
						<td><label><%=q.getqId() %></label></td>
					</tr>
					<tr>
						<th scope="row">문의제목</th>
						<td><label><%=q.getqTitle() %></label></td>
					</tr>
					<tr>
						<th scope="row">문의내용</th>
						<td height="200px"><label><%=q.getqContent() %> </label></td>
					</tr>

					<tr>
						<th scope="row">답변</th>
						<td height="200px">
							<%-- <label><%=q.getqAnswer() %></label> --%>
							<textarea class="txt" name="answer" id="reviewInput" cols="30" style="height: 190px;"><%=q.getqAnswer() %></textarea>
						</td>
					</tr>
				</table>

				<input type="hidden" name="qno" value="<%= q.getqNum() %>">
				

				<div class=btn-area>
					<!-- <input type="button" value="확인" class="btn-confirm btn"> -->
					<input type="submit" value="답변 등록하기" class="btn-updateRequest btn">
				</div>

			</div>
			</form>

		</div>

	</section>
</body>

</html>