package review.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import review.model.vo.Review;

public class ReviewDao {

	private Properties prop;

	public ReviewDao() {
		prop = new Properties();

		String filePath = ReviewDao.class
				.getResource("/config/review-query.properties").getPath();

		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 리뷰 조회
	 * @param con
	 * @return
	 */
	public ArrayList<Review> selectList(Connection con, String mId){

		ArrayList<Review> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectList");


		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mId);

			rset = pstmt.executeQuery();

			list = new ArrayList<Review>();

			while(rset.next()) {
				Review r = new Review();

				r.setRno(rset.getInt("RNO"));
				r.setPcode(rset.getInt("PCODE"));
				r.setRtitle(rset.getString("TITLE"));
				r.setRcontent(rset.getString("RCONTENT"));
				r.setRwriter(rset.getString("RWRITERID"));
				r.setRwriterId(rset.getString("RWRITERID"));
				r.setRdate(rset.getDate("RDATE"));
				r.setRrecommend(rset.getInt("RRECOMMEND"));
				r.setRstar(rset.getInt("RSTAR"));
				r.setStatus(rset.getString("RSTATUS"));
				r.setPoster(rset.getString("POSTER"));

				System.out.println("r데이터 확인: " + r);

				list.add(r);

				System.out.println("리스트에 추가 완료!");
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;

	}

	/**
	 * 리뷰 추가
	 * @param con
	 * @param n
	 * @return
	 */
	public int insertReview(Connection con,Review r) {

		int result = 0; // SQL의 결과
		String sql = prop.getProperty("insertReview");

		System.out.println("insert sql: " + sql);

		PreparedStatement pstmt = null;

		
		System.out.println(r.getPcode());
		//int pcode = 1;
		
		String face[] = {"/Nonda/resource/image/face/boy1.png","/Nonda/resource/image/face/boy2.png","/Nonda/resource/image/face/girl1.png","/Nonda/resource/image/face/girl2.png","/Nonda/resource/image/face/girl3.png","/Nonda/resource/image/face/man.png","/Nonda/resource/image/face/man1.png","/Nonda/resource/image/face/man2.png","/Nonda/resource/image/face/man3.png"};
		int ran = (int)(Math.random()*8) + 0;
		
		//r.setrFaceImg(face[ran]);

		try {
			// 미완성된 SQL 준비
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, r.getPcode());
			pstmt.setString(2, r.getRcontent());
			pstmt.setString(3, r.getRwriterId());
			pstmt.setInt(4, r.getRstar());
			pstmt.setString(5, face[ran]);

			// 결과 확인
			result = pstmt.executeUpdate();

			// View -> Servlet -> Service -> Dao <-> DB

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 게시글 한개 조회
	 * @param con
	 * @param nno
	 * @return
	 */
	public Review selectOne(Connection con, int rno) {

		Review r = null;
		PreparedStatement pstmt = null;
		ResultSet rset =null;

		String sql = prop.getProperty("selectOne");

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rno);

			// INSERT,UPDATE,DELETE : executeUpdate()
			// SELECT : executeQuery()
			rset = pstmt.executeQuery();

			if(rset.next()) {

				r = new Review();

				r.setRno(rno);
				r.setPcode(rset.getInt("PCODE"));
				r.setRtitle(rset.getString("TITLE"));
				r.setRcontent(rset.getString("RCONTENT"));
				r.setRwriter(rset.getString("RWRITERID"));
				r.setRwriterId(rset.getString("RWRITERID"));
				r.setRdate(rset.getDate("RDATE"));
				r.setRrecommend(rset.getInt("RRECOMMEND"));
				r.setRstar(rset.getInt("RSTAR"));
				r.setStatus(rset.getString("RSTATUS"));
				r.setPoster(rset.getString("POSTER"));
				r.setBno(rset.getInt("BNO"));
			}

			System.out.println("review 확인 : " + r);

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return r;
	}
	
	public Review insertSelectOne(Connection con, int pno) {

		Review r = null;
		PreparedStatement pstmt = null;
		ResultSet rset =null;

		String sql = prop.getProperty("insertSelectOne");

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pno);

			// INSERT,UPDATE,DELETE : executeUpdate()
			// SELECT : executeQuery()
			rset = pstmt.executeQuery();

			if(rset.next()) {

				r = new Review();

				r.setPcode(pno);
				//r.setPcode(rset.getInt("PCODE"));
				r.setRtitle(rset.getString("TITLE"));
//				/r.setBno(rset.getInt("BNO"));
				r.setPoster(rset.getString("POSTER"));
				
			}

			System.out.println("review 확인 : " + r);

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return r;
	}

	/**
	 * 공지사항 수정
	 * @param con
	 * @param n
	 * @return
	 */
	public int updateReview(Connection con, Review n) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateReview");

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, n.getRstar());
			pstmt.setString(2, n.getRcontent());
			pstmt.setInt(3, n.getRno());

			result = pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}	

		return result;
	}

	public ArrayList<Review> getListByPcode(Connection con, int pCode){

		ArrayList<Review> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("getListByPcode");
		System.out.println("getListByPcode sql: " + sql);


		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pCode);

			rset = pstmt.executeQuery();

			list = new ArrayList<Review>();

			while(rset.next()) {
				Review r = new Review();

				r.setRno(rset.getInt("RNO"));
				r.setPcode(rset.getInt("PCODE"));

				r.setRcontent(rset.getString("RCONTENT"));
				r.setRwriter(rset.getString("RWRITERID"));
				r.setRwriterId(rset.getString("RWRITERID"));
				r.setRdate(rset.getDate("RDATE"));
				r.setRrecommend(rset.getInt("RRECOMMEND"));
				r.setRstar(rset.getInt("RSTAR"));
				r.setStatus(rset.getString("RSTATUS"));
				r.setrFaceImg(rset.getString("RFACE"));

				System.out.println("r데이터 확인: " + r);

				list.add(r);

				System.out.println("리스트에 추가 완료!");
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;

	}

	//리뷰 좋아요 넘버 update
	public int updateLikeNum(Connection con,String update, int rno) {

		int result = 0;

		PreparedStatement pstmt = null;
		String sql;
		if(update.equals("plus")) {
			sql = prop.getProperty("likeNumPlus");
			System.out.println(sql);
			//은수언니 화이팅♥
		}else {
			sql=prop.getProperty("likeNumMinus");
			System.out.println(sql);
		}


		try {
			pstmt=con.prepareStatement(sql);
			//	         pstmt.setInt(1, likeNum);
			pstmt.setInt(1, rno);

			result=pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {

			close(pstmt);
		}
		return result;

	}


	public int getLikeNum(Connection con,int rno) {
		int likeNum = 0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;

		String sql=prop.getProperty("getLikeNum");
		System.out.println(sql);

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, rno);
			rset=pstmt.executeQuery();

			if(rset.next()) {
				likeNum=rset.getInt("RRECOMMEND");
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return likeNum;
	}


	public Review getSatisR(Connection con, int pCode) {
		Review r = null;
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		String sql = prop.getProperty("getSatisR");

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pCode);

			rset=pstmt.executeQuery();
			r= new Review();
			while(rset.next()) {

				r.setRno(rset.getInt("RNO"));
				r.setPcode(rset.getInt("PCODE"));

				r.setRcontent(rset.getString("RCONTENT"));
				r.setRwriter(rset.getString("RWRITERID"));
				r.setRwriterId(rset.getString("RWRITERID"));
				r.setRdate(rset.getDate("RDATE"));
				r.setRrecommend(rset.getInt("RRECOMMEND"));
				r.setRstar(rset.getInt("RSTAR"));
				r.setStatus(rset.getString("RSTATUS"));
				r.setrFaceImg(rset.getString("RFACE"));
			}
			System.out.println("만족리뷰 r:"+r);

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return r;
	}

	public Review getUnsatisR(Connection con,int pCode) {
		Review r = null;
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		String sql = prop.getProperty("getUnsatisR");

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pCode);

			rset=pstmt.executeQuery();
			r= new Review();
			while(rset.next()) {

				r.setRno(rset.getInt("RNO"));
				r.setPcode(rset.getInt("PCODE"));

				r.setRcontent(rset.getString("RCONTENT"));
				r.setRwriter(rset.getString("RWRITERID"));
				r.setRwriterId(rset.getString("RWRITERID"));
				r.setRdate(rset.getDate("RDATE"));
				r.setRrecommend(rset.getInt("RRECOMMEND"));
				r.setRstar(rset.getInt("RSTAR"));
				r.setStatus(rset.getString("RSTATUS"));
				r.setrFaceImg(rset.getString("RFACE"));
			}
			System.out.println("불만족리뷰 r:"+r);

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return r;
	}
	
	public ArrayList<Review> getReviewByKeyword(Connection con,String kWord){
		   ArrayList<Review> rList = null;
			PreparedStatement pstmt=null;
			ResultSet rset= null;
			String sql=null;
			
			//다중 검색
			if(kWord.contains(" ")) {
				String[] kwNoSpace= kWord.split("\\s+");
				sql="SELECT R.PCODE,\r\n" + 
						"P.PTITLE,\r\n" + 
						"R.RCONTENT,\r\n" + 
						"R.RSTAR,\r\n" + 
						"R.RDATE,\r\n" + 
						"R.RWRITERID\r\n" + 
						"FROM REVIEW R,PROGRAM P WHERE R.PCODE=P.PCODE AND REGEXP_LIKE(R.RCONTENT, '";
				System.out.println("검색어 배열"+kwNoSpace.length);
				for(int i=0;i<kwNoSpace.length;i++) {
								
					if(kwNoSpace[i].equals(" ")) return rList; //키워드에 공백만 있을경우 리턴 시킴
					if(i!=(kwNoSpace.length-1)) {
						sql+=kwNoSpace[i]+"|";
					}else {
						sql+=kwNoSpace[i]+"')";
					}
				}
			}else {
			
			//단일 검색
//			sql=prop.getProperty("getReviewByKeyword");
			sql="SELECT R.PCODE,\r\n" + 
					"P.PTITLE,\r\n" + 
					"R.RCONTENT,\r\n" + 
					"R.RSTAR,\r\n" + 
					"R.RDATE,\r\n" + 
					"R.RWRITERID\r\n" + 
					"FROM REVIEW R,PROGRAM P WHERE R.PCODE=P.PCODE AND RCONTENT LIKE '%"+kWord+"%'";
			System.out.println(sql);
	   }
			System.out.println("리뷰 검색 설정된 sql"+sql);
			try {
				System.out.println("try문 들어왔는지");
				System.out.println(kWord);
				pstmt=con.prepareStatement(sql);
				
				
				
				System.out.println("리뷰 try의 sql"+sql);
//				pstmt.setString(1, kWord);
				
				rset=pstmt.executeQuery();
				rList=new ArrayList<Review>();
				while(rset.next()) {
					Review r= new Review();
					r.setPcode(rset.getInt("PCODE"));
					r.setRtitle(rset.getString("PTITLE"));
					r.setRcontent(rset.getString("RCONTENT"));
					r.setRstar(rset.getInt("RSTAR"));
					r.setRdate(rset.getDate("RDATE"));
					r.setRwriterId(rset.getString("RWRITERID"));
					
					rList.add(r);
					
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
		   
		   return rList;
		   
	   }
	
	
}

