package qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import member.model.vo.Member;
import qna.model.service.QnaService;
import qna.model.vo.Qna;

/**
 * Servlet implementation class QnaSelectMyplayServlet
 */
@WebServlet("/selectMyplay.qna")
public class QnaSelectMyplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaSelectMyplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Qna> qlist = new ArrayList<Qna>();

		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("member"); // session에서 회원 정보 가져오기
		
		String mId = m.getmId();
		
		// 공지사항 등록을 위한 VO 객체 만들기	
		QnaService qs = new QnaService();
		qlist = qs.selectMyplay(mId);
		
		System.out.println("qlist: " + qlist);

		if(qlist != null) {
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(qlist,response.getWriter());
			
		}else {
			System.out.println("리스트가 null임");
			request.setAttribute("msg", "공지사항 목록 불러오기 에러!");
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
