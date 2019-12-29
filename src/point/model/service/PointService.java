package point.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import point.model.dao.PointDao;
import point.model.vo.Point;

public class PointService
{
	private Connection c;
	private PointDao pd = new PointDao();

	public int pointCheck(String mId)
	{
		c = getConnection();

		int result = pd.pointCheck(c, mId);

		close(c);

		return result;
	}
	
	public ArrayList<Point> selectList(String mId)
	{
		c = getConnection();

		ArrayList<Point> list = pd.selectList(c, mId);

		close(c);

		return list;
	}
}