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
 * Servlet implementation class ReviewInsertSelect
 */
@WebServlet("/rInsertSelect.re")
public class ReviewInsertSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pno = Integer.parseInt(request.getParameter("pcode"));
		System.out.println(pno);
		
		//int bno = Integer.parseInt(request.getParameter("bno"));
		//System.out.println("bno: " + bno);
		
		ReviewService rs = new ReviewService();
		Review r = rs.insertSelectOne(pno);
		
		System.out.println("insertselectselectone review: " + r);
		
		String page = "";
		
		if(r != null) {
			page = "view/reviewInsert.jsp?pcode=" + pno;
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
