package program.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import program.model.service.ProgramService;
import program.model.vo.Program;

/**
 * Servlet implementation class ProgramUpdateViewServlet
 */
@WebServlet("/pUpView.pr")
public class ProgramUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProgramUpdateViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pno = Integer.parseInt(request.getParameter("pno"));
		//System.out.println("upview pno: " + pno);
		
		Program p = new ProgramService().updateView(pno);

		String page = "";

		if(p != null) {
			page = "view/play_request/play_requestUpdate.jsp";
			request.setAttribute("program", p);
		} else {
			System.out.println("pUpView 실패ㅡㅡ");
		}

		request.getRequestDispatcher(page).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
