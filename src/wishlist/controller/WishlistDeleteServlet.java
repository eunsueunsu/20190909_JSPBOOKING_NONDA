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

/**
 * Servlet implementation class WishlistDeleteServlet
 */
@WebServlet("/wDelete.wi")
public class WishlistDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishlistDeleteServlet() {
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
		System.out.println("wishlistdelete pcode: " + pcode);
		
		String mId = m.getmId();
		
		int result = new WishlistService().deleteWishlist(pcode,mId);
		
		if(result> 0) {
			System.out.println("위시리스트에서 삭제 성공!");
			
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(pcode,response.getWriter());
			
		} else {
			System.out.println("위시리스트에서 삭제 실패 ㅠ");
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
