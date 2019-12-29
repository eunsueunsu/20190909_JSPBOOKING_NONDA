package wishlist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import member.model.vo.Member;
import wishlist.model.service.WishlistService;
import wishlist.model.vo.Wishlist;

/**
 * Servlet implementation class WishlistInsertServlet
 */
@WebServlet("/wInsert.wi")
public class WishlistInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishlistInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("member"); // session에서 회원 정보 가져오기
		
		int pcode = Integer.parseInt(request.getParameter("pcode"));
		
		Wishlist w = new Wishlist();
		
		w.setmId(m.getmId());
		w.setPcode(pcode);
		
		WishlistService ws = new WishlistService();
		int result = ws.insertWishlist(w);
		
		if(result > 0) {
			// 공지사항 추가 성공
			System.out.println("위시리스트 추가 성공!!!");
			
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(w,response.getWriter());
			
			request.setAttribute("w", w);
			
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
