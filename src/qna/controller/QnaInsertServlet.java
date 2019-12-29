package qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import qna.model.service.QnaService;
import qna.model.vo.Qna;

/**
 * Servlet implementation class QnaInsertServlet
 */
@WebServlet("/qInsert.do")
public class QnaInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QnaInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("member");

		//System.out.println(m);
		//		PlayInfo pi = (PlayInfo)request.getAttribute("p");
		//		System.out.println("QnainsertServlet의"+pi);


		//		q.setqId(m.getmId());
		//		q.setqTitle(request.getParameter("title"));
		//		q.setqContent(request.getParameter("content"));
		
		System.out.println("qnainsertservlet");
		
		System.out.println(m.getmId());
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = m.getmId();

		int pCode =Integer.parseInt(request.getParameter("pcode"));
		
		//		int pNum = pi.getpNum();
		//		String pCode =playCode+pNum;
		System.out.println("QnainsertServlet의"+pCode);

		Qna q = new Qna(writer,title,content,pCode);

		//서비스로 보내서 인서트메소드 호출
		int result = new QnaService().insertQna(q);

		if(result>0) {
			response.sendRedirect("InfoDetailServlet?pCode=" + pCode);
		}else {
			request.setAttribute("msg", "문의글 작성 실패");
			System.out.println("문의글 작성 실패");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
