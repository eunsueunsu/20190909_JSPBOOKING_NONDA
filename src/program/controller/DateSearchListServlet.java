package program.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import program.model.service.ProgramService;
import program.model.vo.PageInfo;
import program.model.vo.Program;
import review.model.vo.Review;

/**
 * Servlet implementation class DateSearchServlet
 */
@WebServlet("/dSearch.do")
public class DateSearchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateSearchListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String year = request.getParameter("syear");
		String month = request.getParameter("smonth");
		String culture = request.getParameter("radio-group");
		
		String date = year + month;
		
		System.out.println("cultrue : " + culture);
		System.out.println("year : " + year);
		System.out.println("month : " + month);
		System.out.println("date : " + date);
		
		ArrayList<Program> plist = null;
		ArrayList<Review> rlist = new ArrayList<Review>();
		
		ProgramService ps = new ProgramService();
		
				
		// 페이징 처리에 필요한 변수들 
		
		// 1,2,3,4,5, --> 1 // 6,7,8,9,10 --> 6
		int startPage;
				
		// 하번에 표시할 페이지들 중 가장 뒤의 페이지
		int endPage;
				
		// 전체 페이지의 가장 마지막 페이지
		int maxPage;
				
		// 사용자가 위치한 현재 페이지
		int currentPage;
		
		// 총 페이지 수(한 페이지당 보여줄 게시글 수)
		int limit;
		
		// 처음 접속 시 페이지는 1페이지 부터 시작한다.
		currentPage = 1;
		
		// 글 개수 및 페이지 수 5개로 제한하기
		limit = 5;
		
		System.out.println("첫 currentPage : " + currentPage);
		// 만약에 사용자가 현재 페이지의 정보를 들고 왔다면
		// 현재 페이지의 정보를 1에서 특정 페이지로 수정해주어야 한다.
		if(request.getParameter("currentPage") != null) {
			System.out.println("currentPage가 실행된다ㅏㅏ");
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		System.out.println("두번쨰 currentPage : " + currentPage);
		// 페이징 처리
		int listCount = ps.getListCount(culture, date);
		
		System.out.println("총 게시물 개수 : " + listCount);
		
		// 만약 전체 게시글 수가 13개라면
		// 페이지는 1,2가 나와야한다.
		// ** 짜투리 게시글도 하나의 페이지로 처리해야한다.
		// 13 --> 1.3 --> 2(올림)
		maxPage = (int)((double)listCount / limit + 0.9);
		
		// 시작 페이지와 마지막 페이지 계산하기
		// 1~10 : 7, 7/10 --> 0.7 --> 1.6 --> 1  - 1 -- 0 * 10 + 1;
		// 11~20: 19, 19/10 -> 1.9 --> 2.8 --> 2 - 1 -- 1* 10 + 1;
		startPage = ((int)((double)currentPage/limit  + 0.9)-1) * limit +1;
		
		// 마지막 페이지
		// 1~ 10 : 10
		// 11~ 20 : 20
		endPage = startPage + limit -1;
		
		// 만약 마지막 페이지보다 현재 게시글이 끝나느 페이지가 적다면
		// 1~10 : 7....
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		plist = ps.selectList(currentPage, limit, culture, date);
		
		for(int i=0;i<listCount;i++) // 여기 오류 잡기
		{
			int pCode = plist.get(i).getpCode();
			
			System.out.println("pCode : " + pCode);
			
			rlist = ps.selecReviewtList(pCode, rlist);
			
			System.out.println("검토 rlist : " + rlist);

		}
		
		System.out.println("최종 rlist : " + rlist);
//		int pCode = plist.get(0).getpCode();
//		
//		System.out.println("pCode : " + pCode);
//		
//		rlist = ps.selecReviewtList(pCode);
		
		String page = "";
		
		if(plist != null) {
			page = "view/search_result.jsp";
			request.setAttribute("plist", plist);
			request.setAttribute("rlist", rlist);
			request.setAttribute("syear", year);
			request.setAttribute("smonth", month);
			request.setAttribute("culture", culture);
			
			PageInfo pi = new PageInfo(currentPage,listCount,limit,maxPage,startPage,endPage);
			request.setAttribute("pi", pi);
			
			request.getRequestDispatcher(page).forward(request, response);
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