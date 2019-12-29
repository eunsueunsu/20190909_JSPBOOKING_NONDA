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
 * Servlet implementation class ReviewUpdateServlet
 */
@WebServlet("/rUpdate.re")
public class ReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String content = request.getParameter("rcontent");
		int rno = Integer.parseInt(request.getParameter("rno"));
		int rstar = Integer.parseInt(request.getParameter("hdstar"));
		
		Review r = new Review();
	
		r.setRno(rno);
		r.setRcontent(content);
		r.setRstar(rstar);
		
		int result = new ReviewService().updateReview(r);
		
		if(result > 0) {
			// 게시글 수정 성공
			response.sendRedirect("selectOne.re?rno="+rno);
		}else {
			// 게시글 수정 실패
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
