package wishlist.model.vo;

import java.sql.Date;

public class Wishlist {
	
	private int pcode;
	//private int wno;
	private String mId;
	private String pposter;
	private String ptitle;
	private Date pStartDate;
	private Date pEndDate;
	private String pGenre;
	
	public Wishlist() { }

	public Wishlist(int pcode, int wno, String mId, String pposter, String ptitle, Date pStartDate, Date pEndDate,
			String pGenre) {
		super();
		this.pcode = pcode;
		//this.wno = wno;
		this.mId = mId;
		this.pposter = pposter;
		this.ptitle = ptitle;
		this.pStartDate = pStartDate;
		this.pEndDate = pEndDate;
		this.pGenre = pGenre;
	}

	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

//	public int getWno() {
//		return wno;
//	}
//
//	public void setWno(int wno) {
//		this.wno = wno;
//	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getPposter() {
		return pposter;
	}

	public void setPposter(String pposter) {
		this.pposter = pposter;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public Date getpStartDate() {
		return pStartDate;
	}

	public void setpStartDate(Date pStartDate) {
		this.pStartDate = pStartDate;
	}

	public Date getpEndDate() {
		return pEndDate;
	}

	public void setpEndDate(Date pEndDate) {
		this.pEndDate = pEndDate;
	}

	public String getpGenre() {
		return pGenre;
	}

	public void setpGenre(String pGenre) {
		this.pGenre = pGenre;
	}

	@Override
	public String toString() {
		return "Wishlist [pcode=" + pcode  + ", mId=" + mId + ", pposter=" + pposter + ", ptitle="
				+ ptitle + ", pStartDate=" + pStartDate + ", pEndDate=" + pEndDate + ", pGenre=" + pGenre + "]";
	}

		
		
	
}
