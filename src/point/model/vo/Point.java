package point.model.vo;

public class Point
{
	private String mId;
	private String poDate;
	private String poRecord;
	private int poCost;
	
	public Point() {

	}

	public Point(String mId, String poDate, String poRecord, int poCost) {
		super();
		this.mId = mId;
		this.poDate = poDate;
		this.poRecord = poRecord;
		this.poCost = poCost;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getPoDate() {
		return poDate;
	}

	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}

	public String getPoRecord() {
		return poRecord;
	}

	public void setPoRecord(String poRecord) {
		this.poRecord = poRecord;
	}

	public int getPoCost() {
		return poCost;
	}

	public void setPoCost(int poCost) {
		this.poCost = poCost;
	}

	@Override
	public String toString() {
		return "Point [mId=" + mId + ", poDate=" + poDate + ", poRecord=" + poRecord + ", poCost=" + poCost + "]";
	}
}