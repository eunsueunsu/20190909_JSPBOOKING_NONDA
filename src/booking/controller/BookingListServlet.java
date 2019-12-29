package booking.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import booking.model.service.BookingService;
import booking.model.vo.Booking;
import member.model.vo.Member;

/**
 * Servlet implementation class BookingListServlet
 */
@WebServlet("/selectList.bo")
public class BookingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Booking> blist = new ArrayList<Booking>();
		
		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("member"); // session에서 회원 정보 가져오기
		
		String mId = m.getmId();
		//System.out.println("ajax mid: " + mId);
		
		BookingService bs = new BookingService();
		
		blist = bs.select(mId);
		
		if(blist != null) {
			System.out.println("booking db 가져오기 성공!!!!!!!!!!!");
			System.out.println("servlet blist: " + blist);
			
			request.setAttribute("blist", blist);
			
			response.setContentType("application/json; charset=UTF-8");
			
			new Gson().toJson(blist,response.getWriter());
			
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
