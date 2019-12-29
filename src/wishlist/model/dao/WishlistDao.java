package wishlist.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import wishlist.model.vo.Wishlist;


public class WishlistDao {
	
	private Properties prop;
	
	public WishlistDao() {
		prop = new Properties();
		
		String filePath = WishlistDao.class
				.getResource("/config/wishlist-query.properties").getPath();
		
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
	public ArrayList<Wishlist> selectList(Connection con, String mId){
		
		ArrayList<Wishlist> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mId);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Wishlist>();
			
			while(rset.next()) {
				Wishlist w = new Wishlist();
				
				w.setmId(mId);
				w.setPcode(rset.getInt("PCODE"));
				w.setpEndDate(rset.getDate("PENDDATE"));
				w.setpStartDate(rset.getDate("PSTARTDATE"));
				w.setPposter(rset.getString("POSTER"));
				w.setPtitle(rset.getString("TITLE"));
				//w.setWno(rset.getInt("WNO"));
				w.setpGenre(rset.getString("PCATEGORY"));
				
				
				System.out.println("w데이터 확인: " + w);
				
				list.add(w);
				
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
	
	
	public int insertWishlist(Connection con, Wishlist w) {
		
		int result = 0;
		String sql = prop.getProperty("insertWishlist");
		
		System.out.println("insert sql: " + sql);
		
		PreparedStatement pstmt = null;
		
		//int pcode = 1;
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, w.getPcode());
			pstmt.setString(2, w.getmId());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public ArrayList<Wishlist> getListByPcode(Connection con, int pcode) {
		
		ArrayList<Wishlist> wlist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getListByPcode");
		System.out.println("getListByPcode wishlist sql: " + sql);
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pcode);
			
			rset = pstmt.executeQuery();
			
			wlist = new ArrayList<Wishlist>();
			
			while(rset.next()) {
				Wishlist w = new Wishlist();
				
				w.setmId(rset.getString("MID"));
				w.setPcode(rset.getInt("PCODE"));
				
				System.out.println("w 데이터 확인: " + w);
				
				wlist.add(w);
				System.out.println("wlist에 추가 완료!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return wlist;
		
	}
	
	public int deleteWishlist(Connection con, int pcode, String mId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteWishlist");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pcode);
			pstmt.setString(2, mId);
			
			result = pstmt.executeUpdate();
						
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
}
