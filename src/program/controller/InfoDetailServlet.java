package program.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import program.model.service.ProgramService;
import program.model.vo.Program;
import qna.model.service.QnaService;
import qna.model.vo.Qna;
import review.model.service.ReviewService;
import review.model.vo.Review;
import reviewlike.model.service.RlikeService;
import wishlist.model.service.WishlistService;
import wishlist.model.vo.Wishlist;

/**
 * Servlet implementation class PlayInfoServlet
 */
@WebServlet("/InfoDetailServlet")
public class InfoDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public InfoDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pCode = Integer.parseInt(request.getParameter("pCode"));
		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("member");
		System.out.println(m);
	
		Program pi = new ProgramService().getPInfo(pCode);
		String page="";

		if(pi != null) {
			System.out.println("pi db 가져오기 성공");
			System.out.println("doget의 pi값 :" +pi);

			page = "view/infoDetail.jsp";
			request.setAttribute("p", pi);
		}else {

					request.setAttribute("msg", "공연 상세정보를 불러오지 못했습니다." );
		}
		//-----------------------review 불러오기-----------

		ArrayList<Review> rList = new ReviewService().getListByPcode(pCode);
		System.out.println("infodetail 서블릿의 리뷰리스트:" +rList);

		if(rList != null) {
			System.out.println("공연코드로 리뷰 가져오기 성공");
			request.setAttribute("rList", rList);
		}
		//------------ 좋아요 리스트 가져오기
		ArrayList<Integer> rLikeList;
		if(m!=null) {
			rLikeList =	new RlikeService().getRlikeList(pCode,m.getmId());
			request.setAttribute("rLikeList", rLikeList);
		}
		
		

		//	----------------qna 불러오기--------------
		ArrayList<Qna> q = new QnaService().getQnaList(pCode);
		System.out.println("infodetail 서블릿의  qna 리스트 :"+q);
		if(q !=null) {
			System.out.println("q db 가져오기 성공");
			request.setAttribute("q",q);
		}

		
		//---------------------- Best review 불러오기
		Review bSatisR= new ReviewService().getSatisR(pCode);
		if(bSatisR.getRcontent()!=null) {
			System.out.println("만족리뷰 있음 : "+bSatisR);
			request.setAttribute("bSatisR", bSatisR);
		}
		
		Review bUnsatisR= new ReviewService().getUnsatisR(pCode);
		if(bUnsatisR.getRcontent()!=null) {
			System.out.println("불만족 리뷰 있음 :"+bUnsatisR);
			request.setAttribute("bUnsatisR", bUnsatisR);
		}
		
		// ----------------- wishlist 불러오기----------------
	      ArrayList<Wishlist> wList = new WishlistService().getListByPcode(pCode);
	      
	      System.out.println("playinfo 서블릿의 wishlist: " + wList);
	      
	      if(wList != null) {
	         System.out.println("공연코드로 위시리스트 가져오기 성공");
	         request.setAttribute("wList", wList);
	      }	      
	      
	      //page = "view/infoDetail.jsp";
	      // pcode값 같이 페이지에 넘겨주기
	      request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
