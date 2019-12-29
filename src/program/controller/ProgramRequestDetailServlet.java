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
 * Servlet implementation class ProgramRequestDetailServlet
 */
@WebServlet("/pRequestDetail.pr")
public class ProgramRequestDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramRequestDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		Program p = new ProgramService().selectRequestDetail(pno);
		
		//System.out.println("selectone program: " + p);

		String page="";
		
		if(p != null) {
			page = "view/play_request/play_requestDetail.jsp";
			request.setAttribute("program", p);
		} else {
			System.out.println("공연게시요청 서블릿 실패");
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
