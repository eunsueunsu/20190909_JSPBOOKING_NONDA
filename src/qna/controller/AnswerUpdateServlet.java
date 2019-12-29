package qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.model.service.QnaService;
import qna.model.vo.Qna;

/**
 * Servlet implementation class AnswerUpdateServlet
 */
@WebServlet("/update.qna")
public class AnswerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String answer = request.getParameter("answer");
		int qno = Integer.parseInt(request.getParameter("qno"));
		
		Qna q = new Qna();
				
		q.setqNum(qno);
		q.setqAnswer(answer);
		
		int result = new QnaService().updateAnswer(q);
		
		if(result >= 0) {
			response.sendRedirect("aDetail.qna?qno="+qno);
			
		}else {
			request.setAttribute("msg", "공지사항 수정 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp")
			.forward(request, response);
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
