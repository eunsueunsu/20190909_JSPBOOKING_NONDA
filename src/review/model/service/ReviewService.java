package review.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import review.model.dao.ReviewDao;
import review.model.vo.Review;

public class ReviewService {

	private ReviewDao rDao = new ReviewDao();

	/**
	 * 아이디로 리뷰 조회
	 * @return
	 */
	public ArrayList<Review> select(String mId){
		Connection con = getConnection();

		ArrayList<Review> rlist = rDao.selectList(con, mId);

		close(con);

		return rlist;
	}

	/**
	 * 리뷰 등록
	 * @param r
	 * @return
	 */
	public int insertReview(Review r) {
		Connection con = getConnection();

		int result = rDao.insertReview(con,r);

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

	public Review selectOne(int rno) {

		Connection con = getConnection();

		Review r = rDao.selectOne(con,rno);

		close(con);

		return r;
	}
	
	public Review insertSelectOne(int pno) {
		Connection con = getConnection();

		Review r = rDao.insertSelectOne(con,pno);

		close(con);

		return r;
	}

	/**
	 * 리뷰 수정페이지 정보 조회
	 * @param nno
	 * @return
	 */
	public Review updateView(int rno) {

		Connection con = getConnection();

		Review n = rDao.selectOne(con, rno);

		close(con);

		return n;
	}

	/**
	 * 리뷰 수정 
	 * @param n
	 * @return
	 */
	public int updateReview(Review r) {

		Connection con = getConnection();

		int result = rDao.updateReview(con,r);

		if(result > 0) commit(con);
		else rollback(con);

		close(con);

		return result;

	}

	public ArrayList<Review> getListByPcode(int pCode){

		Connection con = getConnection();

		ArrayList<Review> rlist = rDao.getListByPcode(con, pCode);

		close(con);

		return rlist;

	}


	public int updateLikeNum(String update, int rno) {
		Connection con = getConnection();

		int result=rDao.updateLikeNum(con,update, rno);
		if(result>0) commit(con);
		else rollback(con);

		close(con);
		return result;
	}

	public int getLikeNum(int rno) {
		Connection con = getConnection();

		int likeNum=rDao.getLikeNum(con,rno);


		close(con);
		return likeNum;
	}


	public Review getSatisR(int pCode) {
		Connection con = getConnection();
		Review satisR=rDao.getSatisR(con,pCode);

		close(con);
		return satisR;
	}

	public Review getUnsatisR(int pCode) {
		Connection con = getConnection();
		Review unsatisR=rDao.getUnsatisR(con,pCode);

		close(con);
		return unsatisR;
	}
	
	public ArrayList<Review> getReviewByKeyword(String kWord) {
		Connection con = getConnection();
		ArrayList<Review> rList=rDao.getReviewByKeyword(con,kWord);
		
		close(con);
		return rList;
		
	}
}
