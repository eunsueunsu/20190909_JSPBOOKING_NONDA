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
 * Servlet implementation class GoogleJoinServlet
 */
@WebServlet("/GoogleJoinServlet")
public class GoogleJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoogleJoinServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String mId = request.getParameter("mId");
		String mName = request.getParameter("mName");

		Member m = new Member(mId, mName, "google");
		MemberService ms = new MemberService();

		System.out.println("회원 가입 정보 : " + m);

		int result = ms.insertGoogle(m);

		if(result > 0)
		{
			System.out.println("회원 가입 성공");

			m = ms.selectGoogle(m);

			System.out.println("로그인 성공 : " + m);

			HttpSession session = request.getSession();
			session.setAttribute("member", m);
			
			response.sendRedirect("/Nonda/view/main.jsp");
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