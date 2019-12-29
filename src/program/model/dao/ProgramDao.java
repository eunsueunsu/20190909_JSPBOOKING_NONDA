package program.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import program.model.vo.Program;
import review.model.vo.Review;

public class ProgramDao
{
	private Properties prop; 

	public ProgramDao()
	{
		prop = new Properties();

		String filePath = ProgramDao.class.getResource("/config/program-query.properties").getPath();

		try
		{
			prop.load(new FileReader(filePath));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<Program> selectBest(Connection c)
	{
		ArrayList<Program> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectBest");
		
		try
		{
			pstmt = c.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			list = new ArrayList<Program>();
			
			while(rs.next())
			{
				Program p = new Program();
				
				p.setpCode(rs.getInt(1));
				p.setpPoster(rs.getString(2));
				p.setpTitle(rs.getString(3));
				p.setpStartdate(rs.getString(4));
				p.setpEnddate(rs.getString(5));
				p.setpCity(rs.getString(6));
				p.setpPlace(rs.getString(7));
				
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
	
	public ArrayList<Program> selectEnd(Connection c)
	{
		ArrayList<Program> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectEnd");
		
		try
		{
			pstmt = c.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			list = new ArrayList<Program>();
			
			while(rs.next())
			{
				Program p = new Program();
				
				p.setpCode(rs.getInt(1));
				p.setpPoster(rs.getString(2));
				p.setpTitle(rs.getString(3));
				p.setpStartdate(rs.getString(4));
				p.setpEnddate(rs.getString(5));
				p.setpCity(rs.getString(6));
				p.setpPlace(rs.getString(7));
				
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
	
	public ArrayList<Program> selectOpen(Connection c)
	{
		ArrayList<Program> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectOpen");
		
		try
		{
			pstmt = c.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			list = new ArrayList<Program>();
			
			while(rs.next())
			{
				Program p = new Program();
				
				p.setpCode(rs.getInt(1));
				p.setpPoster(rs.getString(2));
				p.setpTitle(rs.getString(3));
				p.setpStartdate(rs.getString(4));
				p.setpEnddate(rs.getString(5));
				p.setpCity(rs.getString(6));
				p.setpPlace(rs.getString(7));
				
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
	
	public Program getPInfo(Connection con,int pCode) {
		Program pi = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("getPInfo");
		System.out.println(sql);
		System.out.println("getPInfo의 pcode:"+pCode);
		try {
			pstmt=con.prepareStatement(sql);

			pstmt.setInt(1,pCode);

			rset=pstmt.executeQuery();

			if(rset.next()) {
				System.out.println("rset is exist");
				pi= new Program();
//				pr.set(rset.getInt("PCODE"));
//				pr.setpTitle(rset.getString("PTITLE"));
//				pr.setpStartDate(rset.getDate("PSTARTDATE"));
//				pr.setpEndDate(rset.getDate("PENDDATE"));
//				pr.setpGrade(rset.getString("PGRADE"));
//				pr.setPlaytime(rset.getInt("PTIME"));
//				pr.setCity(rset.getString("PCITY"));
//				pr.setPlaceName(rset.getString("PPLACE"));
//				pr.setTicketPrice(rset.getInt("PPRICE"));
//				pr.setPlayCode(pCode);
//				pr.setpScore(rset.getInt("PSCORE"));
//				pr.setpCategory(rset.getString("PCATEGORY"));
//				pr.setpPosterImg(rset.getString("PPOSTER"));
//				pr.setpInfoImg(rset.getString("PDETAIL"));
//				pr.setpParking(rset.getString("PPARKING"));
				pi.setpCode(rset.getInt("PCODE"));
				pi.setpCategory(rset.getString("PCATEGORY"));
				pi.setpTitle(rset.getString("PTITLE"));
				pi.setpStartdate(rset.getString("PSTARTDATE"));
				pi.setpEnddate(rset.getString("PENDDATE"));
				pi.setpCity(rset.getString("PCITY"));
				pi.setpPlace(rset.getString("PPLACE"));
				pi.setpPrice(rset.getInt("PPRICE"));
				pi.setpScore(rset.getFloat("PSCORE"));
				pi.setpGrade(rset.getString("PGRADE"));
				pi.setpTime(rset.getInt("PTIME"));
				pi.setpParking(rset.getString("PPARKING").charAt(0));
				pi.setpBest(rset.getString("PBEST").charAt(0));
				pi.setpPoster(rset.getString("PPOSTER"));
				pi.setpDetail(rset.getString("PDETAIL"));
				pi.setpValid(rset.getString("PVALID").charAt(0));
			}
			
			System.out.println("dao getPInfo의 pr :"+pi);

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);

		}
		return pi;
	}
	
public ArrayList<Program> selectListbyId(Connection con, String mId) {
		
		ArrayList<Program> plist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListbyId");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mId);
			
			rset = pstmt.executeQuery();
			
			plist = new ArrayList<Program>();
			
			while(rset.next()) {
				Program p = new Program();
				
				p.setpCategory(rset.getString("PCATEGORY"));
				p.setpCode(rset.getInt("PCODE"));
				p.setpTitle(rset.getString("PTITLE"));
				p.setpValid(rset.getString("PVALID").charAt(0));
				
				System.out.println("p 데이터확인: " + p);
				
				plist.add(p);
				
				System.out.println("리스트에 추가 완료!");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return plist;
		
	}
	
	// 공연게시 요청 Detail페이지로
	public Program selectRequestDetail(Connection con, int pno) {
		Program p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectRequestDetail");
		
		try {
			pstmt = con.prepareStatement(sql); // 미완성 쿼리
			pstmt.setInt(1, pno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Program();
				
				p.setpCode(pno);
				p.setpTitle(rset.getString("PTITLE"));
				p.setpCategory(rset.getString("PCATEGORY"));
				p.setpGrade(rset.getString("PGRADE"));
				p.setpTime(rset.getInt("PTIME"));
				p.setpParking(rset.getString("PPARKING").charAt(0));
				p.setpCity(rset.getString("PCITY")); //지역
				p.setpPlace(rset.getString("PPLACE"));
				p.setpStartdate(rset.getString("PSTARTDATE"));
				p.setpEnddate(rset.getString("PENDDATE"));
				p.setpPrice(rset.getInt("PPRICE"));
				p.setpPoster(rset.getString("PPOSTER"));
				p.setpDetail(rset.getString("PDETAIL"));
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return p;
		
	}
	
	/**
	 * 프로그램 추가
	 * @throws ParseException 
	 */
	public int insertProgram(Connection con, Program p) throws ParseException {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertProgram");
		
		System.out.println("sql: " + sql);
		
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date util_pStartdate = transFormat.parse(p.getpStartdate());
		Date util_pEnddate = transFormat.parse(p.getpEnddate());
		
		System.out.println("util startdate: " + util_pStartdate);
		System.out.println("util enddate: " + util_pEnddate);
		
		java.sql.Date pStartdate = new java.sql.Date(util_pStartdate.getTime());
		java.sql.Date pEnddate = new java.sql.Date(util_pEnddate.getTime());
		
		
		try {
			pstmt = con.prepareStatement(sql); // 미완성 쿼리
			
			pstmt.setString(1, p.getmId());
			pstmt.setString(2, p.getpCategory());
			pstmt.setString(3, p.getpTitle());
			pstmt.setDate(4, pStartdate);
			pstmt.setDate(5, pEnddate);
			pstmt.setString(6, p.getpCity());
			pstmt.setString(7, p.getpPlace());
			pstmt.setInt(8, p.getpPrice());
			pstmt.setString(9,p.getpGrade());
			pstmt.setInt(10, p.getpTime());
			pstmt.setString(11, Character.toString(p.getpParking()));
			pstmt.setString(12, p.getpPoster());
			pstmt.setString(13, p.getpDetail());
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/**
	 * 프로그램 정보 수정
	 * @throws ParseException 
	 */
	public int updateProgram(Connection con, Program p, String pposter, String pdetail) throws ParseException {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateProgram");
		
		System.out.println("sql: " + sql);

		// string -> util.date -> sql.date
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date util_pStartdate = transFormat.parse(p.getpStartdate());
		Date util_pEnddate = transFormat.parse(p.getpEnddate());
		
		System.out.println("util startdate: " + util_pStartdate);
		System.out.println("util enddate: " + util_pEnddate);
		
		java.sql.Date pStartdate = new java.sql.Date(util_pStartdate.getTime());
		java.sql.Date pEnddate = new java.sql.Date(util_pEnddate.getTime());
		
		try {
			pstmt = con.prepareStatement(sql); // 미완성 쿼리
			
			
			
			pstmt.setString(1, p.getmId());
			pstmt.setString(2, p.getpCategory());
			pstmt.setString(3, p.getpTitle());
			pstmt.setDate(4, pStartdate);
			pstmt.setDate(5, pEnddate);
			pstmt.setString(6, p.getpCity());
			pstmt.setString(7, p.getpPlace());
			pstmt.setInt(8, p.getpPrice());
			pstmt.setString(9,p.getpGrade());
			pstmt.setInt(10, p.getpTime());
			pstmt.setString(11, Character.toString(p.getpParking()));
			pstmt.setInt(14, p.getpCode());
//			pstmt.setString(12, p.getpPoster());
//			pstmt.setString(13, p.getpDetail());
			
			if(!p.getpPoster().equals(pposter)) { // 이미지를 업데이트했으면
				pstmt.setString(12, p.getpPoster());
			} else {
				pstmt.setString(12, pposter); // 업데이트안했으면
			}
			
			if(!p.getpDetail().equals(pdetail)) { // 이미지를 업데이트했으면
				pstmt.setString(13, p.getpDetail());
			} else {
				pstmt.setString(13, pdetail); // 업데이트안했으면
			}
			
			
			result = pstmt.executeUpdate();
			
			System.out.println("쿼리실행됨 업뎃완료");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	public int getListCount(Connection con, String culture, String date) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		
		try
		{
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, culture);
			pstmt.setString(2, date);
			pstmt.setString(3, date);
			
			rset = pstmt.executeQuery();
			
			if (rset.next())
			{
				listCount = rset.getInt(1);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Program> selectList(Connection con, int currentPage, int limit, String culture, String date) {
		ArrayList<Program> plist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try
		{
			pstmt = con.prepareStatement(sql);
			
			// 1. 마지막 행의번호
			// 2. 첫 행의 번호
			int startRow = (currentPage -1) * limit +1; // 1, 11
			
			int endRow = startRow + limit -1; // 10, 20
			
			pstmt.setString(1, culture);
			pstmt.setString(2, date);
			pstmt.setString(3, date);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
			rset = pstmt.executeQuery();
			
			plist = new ArrayList<Program>();
			
			while(rset.next())
			{
				Program pg = new Program();
				
				pg.setpCode(rset.getInt("PCODE"));
				pg.setpCategory(rset.getString("PCATEGORY"));
				pg.setpPoster(rset.getString("PPOSTER"));
				pg.setpTitle(rset.getString("PTITLE"));
				pg.setpPlace(rset.getString("PPLACE"));
				pg.setpPrice(rset.getInt("PPRICE"));
				pg.setpStartdate(rset.getString("PSTARTDATE"));
				pg.setpEnddate(rset.getString("PENDDATE"));
				pg.setpParking(rset.getString("PPARKING").charAt(0));
				
				
				plist.add(pg);

			}

			
			System.out.println("plist : " + plist);
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			close(rset);
			close(pstmt);
		}
		
		return plist;
	}
	
	public ArrayList<Review> selecReviewtList(Connection c, int pCode, ArrayList<Review> rlist) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("reviewList");
		
		try
		{
			pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, pCode);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				Review r = new Review();
				
				r.setPcode(rset.getInt("PCODE"));
				r.setRcontent(rset.getString("RCONTENT"));
				r.setRwriterId(rset.getString("RWRITERID"));
				
				rlist.add(r);
			}
			
			System.out.println("rlist : " + rlist);
		} catch(SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			close(rset);
			close(pstmt);
		}
		
		return rlist;
	}
	
	// 키워드로 프로그램 검색
		public ArrayList<Program> getPiNowByKeyword(Connection con,String kWord) {

			ArrayList<Program> pList = null;
			PreparedStatement pstmt=null;
			ResultSet rset= null;


			//검색어 공백 붙여서 검색


			String oneK=kWord.replace(" ", "");
			System.out.println("oneK:"+oneK);
			if(oneK.equals("")) return pList;

			String sql ="SELECT * FROM PROGRAM WHERE PENDDATE>=SYSDATE AND REPLACE(PTITLE,' ','') LIKE '%"+oneK+"%'";
			System.out.println("단일검색:"+sql);

			try {
				pstmt=con.prepareStatement(sql);
				rset=pstmt.executeQuery();
				pList= new ArrayList<Program>();


				while(rset.next()) {
					Program pi = new Program();
					pi.setpCode(rset.getInt("PCODE"));

					pi.setpTitle(rset.getString("PTITLE"));
					pi.setpEnddate(rset.getString("PENDDATE"));
					pi.setpCity(rset.getString("PCITY"));
					pi.setpPlace(rset.getString("PPLACE"));
					pi.setpPoster(rset.getString("PPOSTER"));
					System.out.println("단일검색 pi"+pi);
					pList.add(pi);

				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}

			//검색어 공백에 따라 나누어서 검색
			
			

			System.out.println("키워드:"+kWord);

			if(kWord.contains(" ")) {
				String[] kwNoSpace= kWord.split("\\s+");
				sql="SELECT * FROM PROGRAM WHERE PENDDATE>=SYSDATE AND REGEXP_LIKE(PTITLE, '";
				System.out.println("검색어 배열"+kwNoSpace.length);
				for(int i=0;i<kwNoSpace.length;i++) {
								
					if(kwNoSpace[i].equals(" ")) return pList; //키워드에 공백만 있을경우 리턴 시킴
					if(i!=(kwNoSpace.length-1)) {
						sql+=kwNoSpace[i]+"|";
					}else {
						sql+=kwNoSpace[i]+"')";
					}
				}
			}
			System.out.println(sql);

			try {
				pstmt=con.prepareStatement(sql);
				System.out.println("트라이문의 sql:"+sql);
				rset=pstmt.executeQuery();

				pList= new ArrayList<Program>();


				while(rset.next()) {
					Program pi = new Program();
					pi.setpCode(rset.getInt("PCODE"));

					pi.setpTitle(rset.getString("PTITLE"));
					pi.setpEnddate(rset.getString("PENDDATE"));
					pi.setpCity(rset.getString("PCITY"));
					pi.setpPlace(rset.getString("PPLACE"));
					pi.setpPoster(rset.getString("PPOSTER"));
					System.out.println("다중검색 pi"+pi);
					pList.add(pi);

				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}


			// 중복 제거
			
//			HashSet<Program> hSet = new HashSet<Program>(pList); 
//			ArrayList<Program> cList = new ArrayList<Program>(hSet);
			
			
			return pList;
		}
	
	
}