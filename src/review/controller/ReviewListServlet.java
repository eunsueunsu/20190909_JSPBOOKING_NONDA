package review.controller;

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
import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewSelectServlet
 */
@WebServlet("/selectList.re")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리뷰는 여러 개를 받아
		// 목록 형태로 데이터를 전달하는 서블릿(ArrayList 형태로)
		
		ArrayList<Review> rlist = new ArrayList<Review>();

		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("member"); // session에서 회원 정보 가져오기
		
		String mId = m.getmId();
		//System.out.println("ajax mid: " + mId);
		
		// 공지사항 등록을 위한 VO 객체 만들기	
		ReviewService rs = new ReviewService();

		rlist = rs.select(mId);

		if(rlist != null) {
			//System.out.println("review db 기져오기 성공");
			//System.out.println("servelet rlist: " + rlist);
			
			//request.setAttribute("rlist", rlist);
			
			response.setContentType("application/json; charset=UTF-8");
			
			new Gson().toJson(rlist,response.getWriter());
			
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
