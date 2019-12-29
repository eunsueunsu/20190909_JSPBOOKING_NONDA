package wishlist.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import wishlist.model.dao.WishlistDao;
import wishlist.model.vo.Wishlist;

public class WishlistService {

	private WishlistDao wDao = new WishlistDao();
	
	public ArrayList<Wishlist> select(String mId){
		Connection con = getConnection();
		
		ArrayList<Wishlist> wlist = wDao.selectList(con, mId);
		
		close(con);
		
		return wlist;
	}
	
	public int insertWishlist(Wishlist w) {
		Connection con = getConnection();
		
		int result = wDao.insertWishlist(con,w);
		
		/*
		 * 0 : 실행한 행의 개수 없음
		 * 1 이상 : n개의 행 실행
		 * -1 : 실행중 에러발생
		 */
		
		if(result >=1) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}
	
	public ArrayList<Wishlist> getListByPcode(int pCode){
		
		Connection con = getConnection();
		
		ArrayList<Wishlist> wlist = wDao.getListByPcode(con, pCode);
		
		close(con);
		
		return wlist;
		
	}
	
	public int deleteWishlist(int pcode, String mId) {
		Connection con = getConnection();
		int result = wDao.deleteWishlist(con, pcode, mId);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
}
