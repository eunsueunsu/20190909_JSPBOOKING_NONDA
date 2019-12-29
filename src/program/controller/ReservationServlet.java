package program.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import point.model.service.PointService;
import program.model.service.ProgramService;
import program.model.vo.Program;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/reservation.do")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int pCode = Integer.parseInt(request.getParameter("pCode"));

		Program p = new ProgramService().getPInfo(pCode);

		System.out.println(p);

		request.setAttribute("program", p);

		HttpSession session = request.getSession();

		Member m = (Member) session.getAttribute("member");
		
		int point = new PointService().pointCheck(m.getmId());
		
		System.out.println(point);
		
		request.setAttribute("point", point);

		request.getRequestDispatcher("/view/reservation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}