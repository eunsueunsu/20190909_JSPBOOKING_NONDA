package booking.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import booking.model.dao.BookingDao;
import booking.model.vo.Booking;

public class BookingService {

private BookingDao bDao = new BookingDao();
	
	/**
	 * 아이디로 리뷰 조회
	 * @return
	 */
	public ArrayList<Booking> select(String mId){
		Connection con = getConnection();
		
		ArrayList<Booking> rlist = bDao.selectList(con, mId);
		
		close(con);
		
		return rlist;
	}
	
}
