package point.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import point.model.vo.Point;

public class PointDao
{
	private Properties p;

	public PointDao()
	{
		p = new Properties();

		String filePath = PointDao.class.getResource("/config/point-query.properties").getPath();

		try
		{
			p.load(new FileReader(filePath));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public int pointCheck(Connection c, String mId)
	{
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = p.getProperty("pointCheck");

		try
		{
			pstmt = c.prepareStatement(sql);
			
			pstmt.setString(1, mId);

			rs = pstmt.executeQuery();

			if(rs.next())
				result = rs.getInt(1);
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
	
	public ArrayList<Point> selectList(Connection c, String mId)
	{
		ArrayList<Point> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = p.getProperty("selectList");
		
		try
		{
			pstmt = c.prepareStatement(sql);

			pstmt.setString(1, mId);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<Point>();
			
			while(rs.next())
			{
				Point p = new Point();
				
				p.setPoDate(rs.getString(1));
				p.setPoRecord(rs.getString(2));
				p.setPoCost(rs.getInt(3));
				
				list.add(p);
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

		return list;	
	}
}