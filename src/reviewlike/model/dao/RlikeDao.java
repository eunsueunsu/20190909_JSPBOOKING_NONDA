package reviewlike.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class RlikeDao {
	
	private Properties prop;
	
	public RlikeDao() {
		prop= new Properties();
		String filePath = RlikeDao.class.getResource("/config/rlike-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Boolean likeIdCheck(Connection con,String rId, int rno) {
		
		Boolean isTrue=false;
		
		PreparedStatement pstmt=null;
		ResultSet rset= null;
		
		String sql = prop.getProperty("likeIdCheck");
		System.out.println(sql);
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, rId);
			pstmt.setInt(2, rno);
			rset=pstmt.executeQuery();
			//값이 있으면 true
			if(rset.next()) {
				isTrue=true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return isTrue;
	}
	
	
	public int insertRlike(Connection con,String rId, int rno,int pCode) {
		
		int result=0;
		PreparedStatement pstmt=null;
		String sql= prop.getProperty("insertRlike");
		System.out.println(sql);
		
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, rId);
			pstmt.setInt(2, rno);
			pstmt.setInt(3, pCode);
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteRlike(Connection con, String rId, int rno) {
		
		int result=0;
		PreparedStatement pstmt=null;
		String sql= prop.getProperty("deleteRlike");
		System.out.println(sql);
		
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, rId);
			pstmt.setInt(2, rno);
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Integer> getRlikeList(Connection con,int pCode, String rId) {
		
		ArrayList<Integer> rLikeList=null;
		PreparedStatement pstmt=null;
		ResultSet rset= null;
		
		String sql = prop.getProperty("getRlikeList");
		System.out.println(sql);
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pCode);
			pstmt.setString(2, rId);
			rset=pstmt.executeQuery();
			rLikeList= new ArrayList<Integer>();
			
			while(rset.next()) {
				
				int rno=rset.getInt("RNO");
				rLikeList.add(rno);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return rLikeList;
	}
	
}
