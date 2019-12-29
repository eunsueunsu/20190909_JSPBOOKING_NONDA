package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String mPhone = request.getParameter("mPhone");
		String mPw = request.getParameter("mPw");
		
		HttpSession session = request.getSession();

		Member m = (Member) session.getAttribute("member");

		m.setmPhone(mPhone);
		
		if(mPw != null)
			m.setmPw(mPw);

		System.out.println("변경한 회원 정보 : " + m);
		
		MemberService ms = new MemberService();
		
		int result = ms.updateOne(m);
		
		if(result > 0)
		{
			System.out.println("수정 성공 ");
			
			session.setAttribute("member", m);
			response.getWriter().print(1);
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