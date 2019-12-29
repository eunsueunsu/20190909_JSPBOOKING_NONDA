package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String mId = request.getParameter("mEmail1") + "@" + request.getParameter("mEmail2");
		String mPw = request.getParameter("mPw");
		String mName = request.getParameter("mName");
		String mPhone = request.getParameter("mPhone");
		String mAccess = request.getParameter("mAccess");
		int mAge = Integer.parseInt(request.getParameter("mAge"));

		Member m = new Member(mId, mPw, mName, mPhone, mAccess, mAge);

		System.out.println("회원 가입 정보 : " + m);

		MemberService ms = new MemberService();

		int result = ms.insertOne(m);

		if(result > 0)
		{
			System.out.println("회원 가입 성공");
			
			response.sendRedirect("/Nonda/view/login.jsp");
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