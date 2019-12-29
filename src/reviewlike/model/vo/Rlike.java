package reviewlike.model.vo;

public class Rlike {

	private String rId; //좋아요한 아이디
	private int rNum; // 리뷰 넘버
	
	public Rlike() {
		
	}
	public Rlike(String rId, int rNum) {
		super();
		this.rId = rId;
		this.rNum = rNum;
	}
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	@Override
	public String toString() {
		return "reviewlike [rId=" + rId + ", rNum=" + rNum + "]";
	}
	
	
	
}
