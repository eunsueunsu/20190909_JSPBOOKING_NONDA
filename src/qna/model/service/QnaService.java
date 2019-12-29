package qna.model.service;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import qna.model.dao.QnaDao;
import qna.model.vo.Qna;
public class QnaService {
	private QnaDao qDao = new QnaDao();
	
	public ArrayList<Qna> getQnaList(int pCode) {

		Connection con= getConnection();
		ArrayList<Qna> qList = qDao.getQnaList(con,pCode);
		
		close(con);
		return qList;
	}
	
	public int insertQna(Qna q) {
		
		Connection con = getConnection();
		int result = qDao.insertQna(con,q);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}
	
	public ArrayList<Qna> selectbyId(String mId) {
		Connection con= getConnection();
		ArrayList<Qna> qList = qDao.selectbyId(con,mId);
		
		close(con);
		return qList;
	}
	
	// 담당자로 문의 조회하기
	public ArrayList<Qna> selectMyplay(String mId) {
		Connection con= getConnection();
		ArrayList<Qna> qList = qDao.selectMyplay(con,mId);
		
		close(con);
		return qList;
	}
	
	public Qna selectOne(int qno) {
		Connection con= getConnection();
		Qna q = qDao.selectOne(con,qno);
		
		close(con);
		return q;
	}
	
	public Qna updateView(int qno) {
		Connection con = getConnection();
		
		Qna q = qDao.selectOne(con, qno);
		close(con);
		
		return q;
	}
	
	public int updateAnswer(Qna q) {
		Connection con = getConnection();

		int result = qDao.updateAnswer(con,q);
		if(result > 0) commit(con);
		else rollback(con);

		close(con);

		return result;
		
	}
	
	
	
}
