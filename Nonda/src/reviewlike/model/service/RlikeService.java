package reviewlike.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import reviewlike.model.dao.RlikeDao;
import static common.JDBCTemplate.*;

public class RlikeService {
	private RlikeDao rDao = new RlikeDao();

	public Boolean likeIdCheck(String rId, int rno) {
		Connection con = getConnection();

		Boolean isTrue = rDao.likeIdCheck(con,rId,rno);
		close(con);
		return isTrue;

	}
	public int insertRlike(String rId,int rno,int pCode) {

		Connection con=getConnection();

		int result=rDao.insertRlike(con,rId,rno,pCode);

		if(result>0) commit(con);
		else rollback(con);

		close(con);
		return result;
	}
	public int deleteRlike(String rId,int rno) {

		Connection con=getConnection();

		int result=rDao.deleteRlike(con,rId,rno);

		if(result>0) commit(con);
		else rollback(con);

		close(con);
		return result;
	}
	
	public ArrayList<Integer> getRlikeList(int pCode,String rId) {
		Connection con= getConnection();
		
		ArrayList<Integer> rLikeList=rDao.getRlikeList(con,pCode,rId);
		
		close(con);
		return rLikeList;
	}

}
