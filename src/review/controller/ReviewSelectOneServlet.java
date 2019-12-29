package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewSelectOneServlet
 */
@WebServlet("/selectOne.re")
public class ReviewSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rno = Integer.parseInt(request.getParameter("rno"));
//		System.out.println(rno);
		
		ReviewService rs = new ReviewService();
		Review r = rs.selectOne(rno);
		
		System.out.println("selectone review: " + r);
		
		String page = "";
		
		if(r != null) {
			page = "view/reviewDetail.jsp";
			request.setAttribute("review", r);
		
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "리뷰 상세 보기 실패!");
		}
	
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
