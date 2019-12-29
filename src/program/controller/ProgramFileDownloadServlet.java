package program.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProgramFileDownloadServlet
 */
@WebServlet("/pfdown.pr")
public class ProgramFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProgramFileDownloadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//저장할 파일 이름 가져오기
		String fileName = request.getParameter("path");

		//실제 파일이 저장된 폴더의 경로
		String folder = request.getServletContext().getRealPath("/resource/image/UploadFiles");

		//파일을 서버에서 사용자에게 전달하는 ServletOutputStream 생성하기
		ServletOutputStream downstream = response.getOutputStream();

		// 네트워크로 전달할 설정을 헤더라는 설정 공간에 등록
		response.addHeader("Content-Disposition", "attachment;filename=\"" + new String(fileName.getBytes("UTF-8"),"ISO-8859-1")+"\"");

		File downFile = new File(folder + "/" + fileName);

		// 전송할 크기만큼 사용자가 컴퓨터에게 공간 확보 요청하기
		response.setContentLength((int)downFile.length());

		// 폴더에서 버퍼를 사용하여 일정 단위로 파일을 읽어오기
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(downFile));

		int readData = 0;

		while((readData = bin.read()) != 1) {
			downstream.write(readData);
		}

		downstream.close();
		bin.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
