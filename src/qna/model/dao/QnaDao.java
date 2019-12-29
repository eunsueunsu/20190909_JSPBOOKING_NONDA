package qna.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import qna.model.vo.Qna;

public class QnaDao {

	private Properties prop;
	public QnaDao() {

		prop= new Properties();
		String filePath = QnaDao.class.getResource("/config/qna-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Qna> getQnaList(Connection con,int pCode) {

		ArrayList<Qna> qList = null;

		PreparedStatement pstmt=null;
		ResultSet rset = null;

		String sql = prop.getProperty("getQnaList");

		System.out.println(sql);

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pCode);

			rset=pstmt.executeQuery();

			qList = new ArrayList<Qna>();

			while(rset.next()) {
				Qna q= new Qna();
				q.setqNum(rset.getInt("QNUM"));
				q.setqId(rset.getString("QID"));
				q.setqTitle(rset.getString("QTITLE"));
				q.setqContent(rset.getString("QCONTENT"));
				q.setqDate(rset.getDate("QDATE"));
				q.setqAnswer(rset.getString("QANSWER"));
				q.setqCompletedOrNot(rset.getString("QCOMPLETE"));
				q.setpCode(pCode);

				qList.add(q);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return qList;
	}


	public int insertQna(Connection con, Qna q) {
		int result = 0;
		PreparedStatement pstmt=null;
		String sql = prop.getProperty("insertQna");
		System.out.println("insertQna 쿼리문 :"+sql);

		try {
			pstmt = con.prepareStatement(sql);
			//sql null 오류나는중

			pstmt.setString(1, q.getqId())	;
			pstmt.setString(2, q.getqTitle());
			pstmt.setString(3, q.getqContent());
			pstmt.setInt(4, q.getpCode());
			result = pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Qna> selectbyId(Connection con,String mId) {

		ArrayList<Qna> qList = null;

		PreparedStatement pstmt=null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectbyId");

		System.out.println(sql);

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mId);

			rset=pstmt.executeQuery();

			qList = new ArrayList<Qna>();

			while(rset.next()) {
				Qna q= new Qna();
				
				q.setqNum(rset.getInt("QNUM"));
				q.setqId(rset.getString("QID"));
				q.setqTitle(rset.getString("QTITLE"));
				q.setqContent(rset.getString("QCONTENT"));
				q.setqDate(rset.getDate("QDATE"));
				q.setqAnswer(rset.getString("QANSWER"));
				q.setqCompletedOrNot(rset.getString("QCOMPLETE"));
				q.setpCode(rset.getInt("PCODE"));
				q.setpTitle(rset.getString("PTITLE"));

				qList.add(q);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return qList;
	}
	
	
	public ArrayList<Qna> selectMyplay(Connection con,String mId) {

		ArrayList<Qna> qList = null;

		PreparedStatement pstmt=null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectMyplay");

		System.out.println(sql);

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mId);

			rset=pstmt.executeQuery();

			qList = new ArrayList<Qna>();

			while(rset.next()) {
				Qna q= new Qna();
				
				q.setqNum(rset.getInt("QNUM"));
				q.setqId(rset.getString("QID"));
				q.setqTitle(rset.getString("QTITLE"));
				q.setqContent(rset.getString("QCONTENT"));
				q.setqDate(rset.getDate("QDATE"));
				q.setqAnswer(rset.getString("QANSWER"));
				q.setqCompletedOrNot(rset.getString("QCOMPLETE"));
				q.setpCode(rset.getInt("PCODE"));
				q.setpTitle(rset.getString("PTITLE"));

				qList.add(q);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return qList;
	}

	
	public Qna selectOne(Connection con, int qno) {
		
		Qna q = null;
		PreparedStatement pstmt = null;
		ResultSet rset =null;

		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qno);

			// INSERT,UPDATE,DELETE : executeUpdate()
			// SELECT : executeQuery()
			rset = pstmt.executeQuery();

			if(rset.next()) {
				q = new Qna();
				
				q.setqNum(qno);
				q.setpTitle(rset.getString("PTITLE"));
				q.setqAnswer(rset.getString("QANSWER"));
				q.setqContent(rset.getString("QCONTENT"));
				q.setpCode(rset.getInt("PCODE"));
				q.setqId(rset.getString("QID"));
				q.setqTitle(rset.getString("QTITLE"));
				
			}
			
			System.out.println("qna 확인: " + q);
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return q;
		
		
	}
	
	
	public int updateAnswer(Connection con, Qna q) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateAnswer");

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, q.getqAnswer());
			pstmt.setInt(2, q.getqNum());

			result = pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}	

		return result;
		
	}
	

}
