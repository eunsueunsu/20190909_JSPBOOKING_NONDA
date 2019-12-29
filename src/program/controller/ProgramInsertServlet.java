package program.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.model.vo.Member;
import program.model.service.ProgramService;
import program.model.vo.Program;

/**
 * Servlet implementation class ProgramInsertServlet
 */
@WebServlet("/pInsert.pr")
public class ProgramInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProgramInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("member"); // session에서 회원 정보 가져오기
		
		// 파일 처리용 서블릿
		// MultipartRequest

		// 1. 전송할 최대 크기 설정하기
		// 10MB -> (Byte 크기로 변환하기)
		// 1MB -> 1024KB -> 1KB -> 1024Byte
		int maxSize = 1024 * 1024 * 10;

		// 2. multipart/form-data 형식으로 전송되었는지 확인 (boardInsertForm 40줄의 enctype)
		if(!ServletFileUpload.isMultipartContent(request)) {
			// 만약 올바른 multipart/form-data로 전송되지 않았을 경우
			// 에러페이지로 즉시 이동시킨다.
			request.setAttribute("msg", "multipart를 통한 전송이 아닙니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}

		// 3. 웹 상의 루트(최상위 경로) 경로를 활용하여 저장할 폴더의 위치 지정하기
		String root = request.getServletContext().getRealPath("/");
		System.out.println(root);

		// 게시판의 첨부파일을 저장할 폴더 이름 지정
		// (폴더를 자동으로 만들어주지 않기 때문에 미리 폴더(boardUploadFiles)를 준비해야한다.)
		String savePath = root + "resource/image/program";
		System.out.println("savePath: " + savePath);

		
		System.out.println("request getContentType : " + request.getContentType());
		
		
		// 4. 실제 담아온 파일 기타 정보들을 활용하여 MultipartRequest 생성하기
		//    request -> MultipartRequest
		MultipartRequest mrequest = new MultipartRequest(
				request, // 변경하기 위한 원본 객체
				savePath, // 파일 저장 경로
				maxSize, //저장할 파일의 최대 크기
				"UTF-8", //저장할 문자셋 설정
				new DefaultFileRenamePolicy()
				// 만약 동일한 이름의 파일을 저장했을 경우 
				// 기존의 파일과 구분하기 위해 새로운 파일명 뒤에 숫자를 붙이는 규칙
				);
		// -- 파일 업로드 로직 실시 -- //

		// 5-1. 기본 전송값 처리
		//String writer = m.getmId();
		String ptitle = mrequest.getParameter("ptitle");
		
		String pcategory = mrequest.getParameter("pcategory");
		String pgrade = mrequest.getParameter("pgrade");
		char pparking = mrequest.getParameter("pparking").charAt(0);
		
		
		String ptime = mrequest.getParameter("ptime");
		String pcity = mrequest.getParameter("pcity");
		String pplace = mrequest.getParameter("pplace");
		String pstartdate = mrequest.getParameter("pstartdate");
		String penddate = mrequest.getParameter("penddate");
		String pprice = mrequest.getParameter("pprice");
		
		///////////////string to date/////////
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		java.sql.Date sqlPstartdate;
		java.sql.Date sqlPenddate;
		
		try {
			java.util.Date startdate = transFormat.parse(pstartdate);
			sqlPstartdate = new Date(startdate.getTime());
			
			java.util.Date enddate = transFormat.parse(penddate);
			sqlPenddate = new Date(enddate.getTime());
			
			// 5-2. 전송된 파일 처리하기
			// 전달받은 파일을 먼저 저장하고, 그 파일의 이름을 가져오는 메소드
			String pposter = mrequest.getFilesystemName("pposter");
			String pdetailimg = mrequest.getFilesystemName("pdetailimg");

			// 6. 전송된 파일 VO에 담아 서비스로 보내기
			Program p = new Program();

			p.setmId(m.getmId());
			p.setpCity(pcity);
			p.setpCategory(pcategory);
			p.setpEnddate(penddate);
			p.setpGrade(pgrade);
			p.setpDetail(pdetailimg);
			p.setpPlace(pplace);
			p.setpTime(Integer.parseInt(ptime));
			p.setpParking(pparking);
			p.setpPoster(pposter);
			p.setpStartdate(pstartdate);
			p.setpTitle(ptitle);
			p.setpPrice(Integer.parseInt(pprice));

			// 7. 서비스 결과 처리하기
			int result = new ProgramService().insertProgram(p);

			if(result > 0) {
				// 추가 완료되면 mypage로 이동
				response.sendRedirect("/Nonda/view/mypage_company.jsp");
			} else {
				request.setAttribute("msg", "게시글 작성 실패ㅠ");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
