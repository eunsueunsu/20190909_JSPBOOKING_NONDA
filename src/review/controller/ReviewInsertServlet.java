package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewInsertServlet
 */
@WebServlet("/rInsert.re")
public class ReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리뷰가 작성될 공연의 제목, 작성자id ,내용, 평점
		// request.getParameter()는 사용자가 요청하면서
		// 전달한 값을 문자열 형태로 받아오는 메소드이다.
		
		int pcode = Integer.parseInt(request.getParameter("pcode"));
		System.out.println(pcode);
		
		String rcontent = request.getParameter("content"); // jsp파일의 태그name으로 값 불러올수있음!	
		System.out.println("rcontent: " + rcontent);
		
		int rstar = Integer.parseInt(request.getParameter("star")); 		
		System.out.println("rstar: " + rstar);
			
		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("member"); // session에서 회원 정보 가져오기
		
		// 공지사항 등록을 위한 VO 객체 만들기
		Review r = new Review();

		r.setPcode(pcode);
		r.setRwriterId(m.getmId()); // 작성자 아이디를 현재 로그인한 회원으로 설정
		r.setRcontent(rcontent); // 내용
		r.setRstar(rstar); // 평점
		
		// View(JSP) --> Controller(Servlet) --> Service

		ReviewService rs = new ReviewService();
		int result = rs.insertReview(r);

		if(result > 0) {
			// 공지사항 추가 성공
			System.out.println("리뷰 추가 성공!!!");
			request.setAttribute("r", r);
			
		}else {
			// 공지사항 추가 실패
			request.setAttribute("msg", "공지사항 등록 실패!");
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
