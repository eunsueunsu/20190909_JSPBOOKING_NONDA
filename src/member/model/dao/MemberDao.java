package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;

public class MemberDao
{
	private Properties p;

	public MemberDao()
	{
		p = new Properties();

		String filePath = MemberDao.class.getResource("/config/member-query.properties").getPath();

		try
		{
			p.load(new FileReader(filePath));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	// 사용자 조회
	public Member selectOne(Connection c, Member m)
	{

		Member result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = p.getProperty("selectOne");

		try
		{
			pstmt = c.prepareStatement(sql);

			pstmt.setString(1, m.getmId());
			pstmt.setString(2, m.getmPw());

			rs = pstmt.executeQuery();

			if(rs.next())
			{
				result = new Member();

				result.setmId(m.getmId());
				result.setmPw(m.getmPw());
				result.setmName(rs.getString(3));
				result.setmPhone(rs.getString(4));
				result.setmAccess(rs.getString(5));
				result.setmAllow(rs.getString(6).charAt(0));
				result.setmAge(rs.getInt(7));
				result.setmValid(rs.getString(10).charAt(0));
				result.setmRoute(rs.getString(11));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}

		return result;
	}

	// 회원 가입
	public int insertOne(Connection c, Member m)
	{
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = p.getProperty("insertOne");

		try
		{
			pstmt = c.prepareStatement(sql);

			pstmt.setString(1, m.getmId());
			pstmt.setString(2, m.getmPw());
			pstmt.setString(3, m.getmName());
			pstmt.setString(4, m.getmPhone());
			pstmt.setString(5, m.getmAccess());
			pstmt.setInt(7, m.getmAge());
			pstmt.setString(8, m.getmId());
			pstmt.setString(9, "회원 가입 기념");

			if(m.getmAccess().equals("company"))
				pstmt.setString(6, "X");
			else
				pstmt.setString(6, "O");

			result = pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
		}

		return result;
	}

	// 이메일 중복 체크
	public int idCheck(Connection c, String mId)
	{
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = p.getProperty("idCheck");

		try
		{
			pstmt = c.prepareStatement(sql);

			pstmt.setString(1, mId);

			rs = pstmt.executeQuery();

			if(rs.next())
				result = 1;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}

		return result;
	}

	// 휴대폰번호 중복 체크
	public int phoneCheck(Connection c, String mPhone)
	{
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = p.getProperty("phoneCheck");

		try
		{
			pstmt = c.prepareStatement(sql);

			pstmt.setString(1, mPhone);

			rs = pstmt.executeQuery();

			if(rs.next())
				result = 1;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}

		return result;
	}

	// 비밀번호 체크
	public int pwCheck(Connection c, String mId, String mPw)
	{
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = p.getProperty("pwCheck");

		try
		{
			pstmt = c.prepareStatement(sql);

			pstmt.setString(1, mId);
			pstmt.setString(2, mPw);

			rs = pstmt.executeQuery();

			if(rs.next())
				result = 1;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}

		return result;
	}

	// 기존 휴대폰번호 조회
	public String prephoneCheck(Connection c, String mId)
	{
		String result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = p.getProperty("prephoneCheck");

		try
		{
			pstmt = c.prepareStatement(sql);

			pstmt.setString(1, mId);

			rs = pstmt.executeQuery();

			if(rs.next())
				result = rs.getString(1);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}

		return result;
	}

	// 회원 정보 수정
	public int updateOne(Connection c, Member m)
	{
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = p.getProperty("updateOne");

		try
		{
			pstmt = c.prepareStatement(sql);

			pstmt.setString(1, m.getmPhone());
			pstmt.setString(2, m.getmPw());
			pstmt.setString(3, m.getmId());

			result = pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
		}

		return result;
	}

	// 회원 탈퇴
	public int deleteOne(Connection c, String mId)
	{
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = p.getProperty("deleteOne");

		try
		{
			pstmt = c.prepareStatement(sql);

			pstmt.setString(1, mId);

			result = pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
		}

		return result;
	}

	// 구글 회원 가입
	public int insertGoogle(Connection c, Member m)
	{
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = p.getProperty("insertGoogle");

		try
		{
			pstmt = c.prepareStatement(sql);

			pstmt.setString(1, m.getmId());
			pstmt.setString(2, m.getmName());
			pstmt.setString(3, m.getmRoute());

			result = pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
		}

		return result;
	}

	// 구글 사용자 조회
	public Member selectGoogle(Connection c, Member m)
	{

		Member result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = p.getProperty("selectGoogle");

		try
		{
			pstmt = c.prepareStatement(sql);

			pstmt.setString(1, m.getmId());

			rs = pstmt.executeQuery();

			if(rs.next())
			{
				result = new Member();

				result.setmId(m.getmId());
				result.setmPw(m.getmPw());
				result.setmName(rs.getString(3));
				result.setmPhone(rs.getString(4));
				result.setmAccess(rs.getString(5));
				result.setmAllow(rs.getString(6).charAt(0));
				result.setmAge(rs.getInt(7));
				result.setmValid(rs.getString(10).charAt(0));
				result.setmRoute(rs.getString(11));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}

		return result;
	}

	// 이메일 찾기
	public String emailFind(Connection c, String mName, String mPhone)
	{
		String result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = p.getProperty("emailFind");

		try
		{
			pstmt = c.prepareStatement(sql);

			pstmt.setString(1, mName);
			pstmt.setString(2, mPhone);

			rs = pstmt.executeQuery();

			if(rs.next())
				result = rs.getString(1);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}

		return result;
	}

	// 비밀번호 찾기
	public int pwFind(Connection c, String mId, String mName, String mPhone)
	{
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = p.getProperty("pwFind");

		try
		{
			pstmt = c.prepareStatement(sql);

			pstmt.setString(1, mId);
			pstmt.setString(2, mName);
			pstmt.setString(3, mPhone);

			rs = pstmt.executeQuery();

			if(rs.next())
				result = 1;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}

		return result;
	}

	// 임시비밀번호로 변경
	public int pwChange(Connection c, String mId, String mPw)
	{
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = p.getProperty("pwChange");
		
		try
		{
			pstmt = c.prepareStatement(sql);

			pstmt.setString(1, mPw);
			pstmt.setString(2, mId);

			result = pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
		}

		return result;
	}
}