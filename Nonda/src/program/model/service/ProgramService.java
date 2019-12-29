package program.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;

import program.model.dao.ProgramDao;
import program.model.vo.Program;
import review.model.vo.Review;

public class ProgramService
{
	private Connection c;
	private ProgramDao pd = new ProgramDao();

	public ArrayList<Program> selectBest()
	{
		c = getConnection();

		ArrayList<Program> list = pd.selectBest(c);

		close(c);

		return list;
	}

	public ArrayList<Program> selectEnd()
	{
		c = getConnection();

		ArrayList<Program> list = pd.selectEnd(c);

		close(c);

		return list;
	}
	
	public ArrayList<Program> selectOpen()
	{
		c = getConnection();

		ArrayList<Program> list = pd.selectOpen(c);

		close(c);

		return list;
	}
	
	public Program getPInfo(int pCode) {

		
		Connection con = getConnection();
		
		Program pi= pd.getPInfo(con,pCode);
		close(con);
		return pi;	
	}
	
	/////////////지은 추가한부분 ////////////////
	public ArrayList<Program> selectListbyId(String mId) {
		Connection con = getConnection();
		
		ArrayList<Program> plist = pd.selectListbyId(con, mId);
		
		close(con);
		return plist;
	}
	
	public Program selectRequestDetail(int pno) {
		Connection con = getConnection();
		Program p = pd.selectRequestDetail(con,pno);
		
		close(con);
		return p;
	}
	
	// 프로그램 추가 서블릿
	public int insertProgram(Program p) throws ParseException {
		Connection con = getConnection();
		int result = pd.insertProgram(con,p);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}
	
	public int updateProgram(Program p,String pposter, String pdetail) throws ParseException {
		Connection con = getConnection();
		int result = pd.updateProgram(con,p,pposter,pdetail);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}
	
	public Program updateView(int pno) {
		
		Connection con = getConnection();
		
		Program p = pd.getPInfo(con, pno);
		
		close(con);
		
		return p;
	}
	
	public int getListCount(String culture, String date) {
		c = getConnection();
		
		int listCount = pd.getListCount(c, culture, date);
		
		close(c);
		
		return listCount;
	}
	
	public ArrayList<Program> selectList(int currentPage, int limit, String culture, String date) {
		c = getConnection();
		
		ArrayList<Program> plist = pd.selectList(c, currentPage, limit, culture, date);
		
		close(c);
		
		return plist;
	}
	
	public ArrayList<Review> selecReviewtList(int pCode, ArrayList<Review> rlist) {
		c = getConnection();
		
		rlist = pd.selecReviewtList(c, pCode, rlist);
		
		close(c);
		
		return rlist;
	}
	
	public ArrayList<Program> getPiNowByKeyword(String kWord){
		Connection con = getConnection();
		
		ArrayList<Program> pList =pd.getPiNowByKeyword(con, kWord);
		close(con);
		return pList;
	}
	
	
}