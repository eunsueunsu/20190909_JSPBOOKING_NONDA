package wishlist.controller;

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
import wishlist.model.service.WishlistService;
import wishlist.model.vo.Wishlist;

/**
 * Servlet implementation class WishlistListServlet
 */
@WebServlet("/selectList.wi")
public class WishlistListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishlistListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Wishlist> wlist = new ArrayList<Wishlist>();

		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("member"); // session에서 회원 정보 가져오기
		
		String mId = m.getmId();
		System.out.println("mId: " + mId);
		
		
		// 공지사항 등록을 위한 VO 객체 만들기	
		WishlistService ws = new WishlistService();

		wlist = ws.select(mId);

		if(wlist != null) {
			System.out.println("wishlist db 기져오기 성공");
			System.out.println("servelet wlist: " + wlist);
			
			response.setContentType("application/json; charset=UTF-8");
			
			new Gson().toJson(wlist,response.getWriter());
			
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
