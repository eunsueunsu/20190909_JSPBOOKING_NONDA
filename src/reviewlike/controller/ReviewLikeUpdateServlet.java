package reviewlike.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import member.model.vo.Member;
import review.model.service.ReviewService;
import reviewlike.model.service.RlikeService;

/**
 * Servlet implementation class ReviewLikeUpdateServlet
 */
@WebServlet("/ReviewLikeUpdateServlet")
public class ReviewLikeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewLikeUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("member");
		String rId=m.getmId();
		System.out.println(rId);

		int rno = Integer.parseInt(request.getParameter("rno"));
		System.out.println(rno);
		int pCode = Integer.parseInt(request.getParameter("pCode"));
		System.out.println("pCode:"+pCode);
		
		//값이 있으면 true
		Boolean isTrue = new RlikeService().likeIdCheck(rId, rno);// 좋아요 리스트에 데이터 있는지 확인
		
		
		Map<String,Integer> hMap= new HashMap<>(); // 에이작스로 반환해줄 결과값
		String update; // sql 에서 플러스할지 마이너스할지 결정해주는 값
		
		if(isTrue) { //true 일 경우 delete 실행
			//삭제 delete됐을 경우 data 1 반환
			update="minus";
			int result = new RlikeService().deleteRlike(rId, rno);
			int result2 = new ReviewService().updateLikeNum(update,rno);
			int likeNum = new ReviewService().getLikeNum(rno);
			if(result>0) {

				hMap.put("idCheck", 1);
				hMap.put("likeNum", likeNum);
				new Gson().toJson(hMap,response.getWriter());

			}else {

			}
			
			if(result2>0) {
				System.out.println("리뷰테이블 좋아요 업데이트 성공");
			}


		}else { //false일 경우 insert 실행
			//추가 insert했을 경우 data 0 반환
			update="plus";
			int result = new RlikeService().insertRlike(rId, rno,pCode);
			int result2 = new ReviewService().updateLikeNum(update,rno);
			int likeNum = new ReviewService().getLikeNum(rno);
			if(result>0) {

				hMap.put("idCheck", 0);
				hMap.put("likeNum", likeNum);
				new Gson().toJson(hMap,response.getWriter());

			}else {

			}
			
			if(result2>0) {
				System.out.println("리뷰테이블 좋아요 업데이트 성공");
			}

			
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
