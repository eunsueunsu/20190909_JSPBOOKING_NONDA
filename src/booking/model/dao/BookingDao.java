package booking.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import booking.model.vo.Booking;
import review.model.dao.ReviewDao;

public class BookingDao {
	
	private Properties prop;

	public BookingDao() {
		prop = new Properties();
		
		String filePath = BookingDao.class
				.getResource("/config/booking-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Booking> selectList(Connection con, String mId)  {
		
		ArrayList<Booking> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		System.out.println(sql);
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mId);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Booking>();
			
			while(rset.next()) {
				Booking b = new Booking();
				
				b.setBno(rset.getInt("BNO"));
				b.setBcount(rset.getInt("BCOUNT"));
				b.setBdate(rset.getDate("BDATE"));
				b.setBgenre(rset.getString("GENRE"));
				b.setbId(rset.getString("BID"));
				//b.setBstatus(rset.getString("BSTATUS"));
				b.setbValid(rset.getString("BVALID"));
				b.setBviewDate(rset.getDate("BVIEWDATE"));
				b.setPcode(rset.getInt("PCODE"));
				b.setPtitle(rset.getString("TITLE"));
				b.setBdaynum(rset.getInt("DAYNUM"));
				
				System.out.println("b데이터 확인: " + b);
				list.add(b);
				
				System.out.println("blist에 추가완료!");
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	
}
