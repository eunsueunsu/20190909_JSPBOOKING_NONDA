package program.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import program.model.service.ProgramService;
import program.model.vo.Program;

/**
 * Servlet implementation class TotalProgramSerchServlet
 */
@WebServlet("/NowProgramSearchServlet")
public class NowProgramSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NowProgramSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String kWord=request.getParameter("kWord");
		System.out.println("서블릿의 키워트:"+kWord);
		ArrayList<Program> pList = new ProgramService().getPiNowByKeyword(kWord);
		
		response.setContentType("application/json; charset=UTF-8");

		new Gson().toJson(pList, response.getWriter());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
