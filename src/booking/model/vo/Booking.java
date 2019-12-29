package booking.model.vo;

import java.sql.Date;

public class Booking {
	
	private String bgenre; //종류(공연,축제,전시)
	private Date bdate; //예매일
	private int bno; //예매번호
	private int pcode; //공연코드
	private String ptitle; //공연명 
	private Date bviewDate; //관람일
	private int bcount; //매수
	private String bId; //예매자 id
	private String bstatus; //현재상태(관람완료, 예매)
	private String bValid; //예매상태(취소여부)
	private int bdaynum; // 현재날짜-관람일 저장할 변수
	
	public int getBdaynum() {
		return bdaynum;
	}

	public void setBdaynum(int bdaynum) {
		this.bdaynum = bdaynum;
	}

	public int getPcode() {
		return pcode;
	}
	
	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public Booking() {}

	public Booking(String bgenre, Date bdate, int bno, int pcode, Date bviewDate, int bcount, String bId,
			String bstatus, String bValid) {
		super();
		this.bgenre = bgenre;
		this.bdate = bdate;
		this.bno = bno;
		this.pcode = pcode;
		this.bviewDate = bviewDate;
		this.bcount = bcount;
		this.bId = bId;
		this.bstatus = bstatus;
		this.bValid = bValid;
	}

	public void setbValid(String bValid) {
		this.bValid = bValid;
	}

	public String getBgenre() {
		return bgenre;
	}

	public void setBgenre(String bgenre) {
		this.bgenre = bgenre;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public Date getBviewDate() {
		return bviewDate;
	}

	public void setBviewDate(Date bviewDate) {
		this.bviewDate = bviewDate;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}

	
	public String getbValid() {
		return bValid;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

	@Override
	public String toString() {
		return "Booking [bgenre=" + bgenre + ", bdate=" + bdate + ", bno=" + bno + ", pcode=" + pcode + ", bviewDate="
				+ bviewDate + ", bcount=" + bcount + ", bId=" + bId + ", bstatus=" + bstatus + ", bValid=" + bValid
				+ "]";
	}
	
	
}
