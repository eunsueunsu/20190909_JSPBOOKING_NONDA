package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class EmailFindServlet
 */
@WebServlet("/EmailFindServlet")
public class EmailFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailFindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String mName = request.getParameter("mName");
		String mPhone = request.getParameter("mPhone");
		
		MemberService ms = new MemberService();
		PrintWriter out = response.getWriter();
		
		String result = ms.emailFind(mName, mPhone);
		
		if(result == null)
		{
			out.println("<script>alert('가입한 정보가 없습니다.'); history.back();</script>");
			out.close();
		}
		else
		{
			out.println("<script>alert('가입한 이메일 : " + result + "'); history.back();</script>");
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