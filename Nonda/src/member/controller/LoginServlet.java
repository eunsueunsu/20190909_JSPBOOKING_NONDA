package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String referer = request.getParameter("referer");
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");

		Member m = new Member(mId, mPw);
		MemberService ms = new MemberService();
		PrintWriter out = response.getWriter();

		m = ms.selectOne(m);

		if(m != null) // 사용자 O
		{
			if(m.getmValid() == 'X') // 탈퇴한 회원
			{
				out.println("<script>alert('탈퇴한 회원입니다.'); history.back();</script>");
				out.close();
			}
			else
			{
				if(m.getmAllow() == 'X') // 업체 회원의 관리자 승인 전
				{
					out.println("<script>alert('가입 승인 대기 중입니다.'); history.back();</script>");
					out.close();
				}
				else // 로그인 O
				{
					System.out.println("로그인 성공 : " + m);

					HttpSession session = request.getSession();
					session.setAttribute("member", m);

					if(referer.equals("http://localhost:8888/Nonda/view/find_id_pwd.jsp") || referer.equals("http://localhost:8888/Nonda/view/join.jsp"))
						response.sendRedirect("/Nonda/view/main.jsp");
					else
						response.sendRedirect(referer);
				}
			}
		}
		else // 사용자 X
		{
			out.println("<script>alert('로그인에 실패하였습니다.'); history.back();</script>");
			out.close();
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