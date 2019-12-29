package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService
{
	private Connection c;
	private MemberDao md = new MemberDao();

	public Member selectOne(Member m)
	{
		c = getConnection();

		Member result = md.selectOne(c, m);

		if(result != null)
			commit(c);
		else
			rollback(c);

		close(c);

		return result;
	}

	public int insertOne(Member m)
	{
		c = getConnection();

		int result = md.insertOne(c, m);

		if(result > 0)
			commit(c);
		else
			rollback(c);

		close(c);

		return result;
	}

	public int idCheck(String mId)
	{
		c = getConnection();

		int result = md.idCheck(c, mId);

		close(c);

		return result;
	}

	public int phoneCheck(String mPhone)
	{
		c = getConnection();

		int result = md.phoneCheck(c, mPhone);

		close(c);

		return result;
	}

	public int pwCheck(String mId, String mPw)
	{
		c = getConnection();

		int result = md.pwCheck(c, mId, mPw);

		close(c);

		return result;
	}

	public String prephoneCheck(String mId)
	{
		c = getConnection();

		String result = md.prephoneCheck(c, mId);

		close(c);

		return result;
	}

	public int updateOne(Member m)
	{
		c = getConnection();

		int result = md.updateOne(c, m);

		if(result > 0)
			commit(c);
		else
			rollback(c);

		close(c);

		return result;
	}

	public int deleteOne(String mId)
	{
		c = getConnection();

		int result = md.deleteOne(c, mId);

		if(result > 0)
			commit(c);
		else
			rollback(c);

		close(c);

		return result;
	}

	public int insertGoogle(Member m)
	{
		c = getConnection();

		int result = md.insertGoogle(c, m);

		if(result > 0)
			commit(c);
		else
			rollback(c);

		close(c);

		return result;
	}

	public Member selectGoogle(Member m)
	{
		c = getConnection();

		Member result = md.selectGoogle(c, m);

		if(result != null)
			commit(c);
		else
			rollback(c);

		close(c);

		return result;
	}
	
	public String emailFind(String mName, String mPhone)
	{
		c = getConnection();

		String result = md.emailFind(c, mName, mPhone);

		close(c);

		return result;
	}
	
	public int pwFind(String mId, String mName, String mPhone)
	{
		c = getConnection();

		int result = md.pwFind(c, mId, mName, mPhone);

		close(c);

		return result;
	}
	
	public int pwChange(String mId, String mPw)
	{
		c = getConnection();

		int result = md.pwChange(c, mId, mPw);

		if(result > 0)
			commit(c);
		else
			rollback(c);

		close(c);

		return result;
	}
}