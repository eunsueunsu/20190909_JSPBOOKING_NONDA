package program.model.vo;

public class Program
{
	private String mId;			// 작성자 id
	private int pCode;  		// 공연번호
	private String pTitle; 		// 제목
	private String pStartdate; 	// 시작 날짜
	private String pEnddate;	// 종료 날짜
	private String pCategory; 	// 카테고리
	private String pGrade; 		// 관람등급
	private int pTime; 			// 관람소요시간
	private String pCity; 		// 도시명
	private String pPlace; 		// 장소
	private int pPrice; 		// 가격
	private float pScore; 		// 리뷰 평점
	private String pPoster; 	// 포스터 이미지 경로
	private String pDetail; 	// 상세 이미지 경로
	private char pParking; 		// 주차 가능여부
	private char pValid; 		// 공연 게시 여부
	private char pBest; 		// 이달의 추천 여부
	private String rContent;
	private String rWriterId;
	
	
	public Program() {

	}
	
	public Program(int pCode, String pCategory, String pTitle, String pStartdate, String pEnddate, String pPlace, int pPrice,
			char pParking, String pPoster, String rContent, String rWriterId) {
		super();
		this.pCode = pCode;
		this.pCategory = pCategory;
		this.pTitle = pTitle;
		this.pStartdate = pStartdate;
		this.pEnddate = pEnddate;
		this.pPlace = pPlace;
		this.pPrice = pPrice;
		this.pParking = pParking;
		this.pPoster = pPoster;
		this.rContent = rContent;
		this.rWriterId = rWriterId;
	}

	public Program(int pCode, String pCategory, String pTitle, String pStartdate, String pEnddate, String pCity,
			String pPlace, int pPrice, float pScore, String pGrade, int pTime, char pParking, char pBest,
			String pPoster, String pDetail, char pValid) {
		super();
		this.pCode = pCode;
		this.pCategory = pCategory;
		this.pTitle = pTitle;
		this.pStartdate = pStartdate;
		this.pEnddate = pEnddate;
		this.pCity = pCity;
		this.pPlace = pPlace;
		this.pPrice = pPrice;
		this.pScore = pScore;
		this.pGrade = pGrade;
		this.pTime = pTime;
		this.pParking = pParking;
		this.pBest = pBest;
		this.pPoster = pPoster;
		this.pDetail = pDetail;
		this.pValid = pValid;
	}

	public int getpCode() {
		return pCode;
	}

	public void setpCode(int pCode) {
		this.pCode = pCode;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpStartdate() {
		return pStartdate;
	}

	public void setpStartdate(String pStartdate) {
		this.pStartdate = pStartdate;
	}

	public String getpEnddate() {
		return pEnddate;
	}

	public void setpEnddate(String pEnddate) {
		this.pEnddate = pEnddate;
	}

	public String getpCity() {
		return pCity;
	}

	public void setpCity(String pCity) {
		this.pCity = pCity;
	}

	public String getpPlace() {
		return pPlace;
	}

	public void setpPlace(String pPlace) {
		this.pPlace = pPlace;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public float getpScore() {
		return pScore;
	}

	public void setpScore(float pScore) {
		this.pScore = pScore;
	}

	public String getpGrade() {
		return pGrade;
	}

	public void setpGrade(String pGrade) {
		this.pGrade = pGrade;
	}

	public int getpTime() {
		return pTime;
	}

	public void setpTime(int pTime) {
		this.pTime = pTime;
	}

	public char getpParking() {
		return pParking;
	}

	public void setpParking(char pParking) {
		this.pParking = pParking;
	}

	public char getpBest() {
		return pBest;
	}

	public void setpBest(char pBest) {
		this.pBest = pBest;
	}

	public String getpPoster() {
		return pPoster;
	}

	public void setpPoster(String pPoster) {
		this.pPoster = pPoster;
	}

	public String getpDetail() {
		return pDetail;
	}

	public void setpDetail(String pDetail) {
		this.pDetail = pDetail;
	}

	public char getpValid() {
		return pValid;
	}

	public void setpValid(char pValid) {
		this.pValid = pValid;
	}
	
	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}
	
	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getrWriterId() {
		return rWriterId;
	}

	public void setrWriterId(String rWriterId) {
		this.rWriterId = rWriterId;
	}

	@Override
	public String toString() {
		return "Program [mId=" + mId + ", pCode=" + pCode + ", pTitle=" + pTitle + ", pStartdate=" + pStartdate
				+ ", pEnddate=" + pEnddate + ", pCategory=" + pCategory + ", pGrade=" + pGrade + ", pTime=" + pTime
				+ ", pCity=" + pCity + ", pPlace=" + pPlace + ", pPrice=" + pPrice + ", pScore=" + pScore + ", pPoster="
				+ pPoster + ", pDetail=" + pDetail + ", pParking=" + pParking + ", pValid=" + pValid + ", pBest="
				+ pBest + ", rContent=" + rContent + ", rWriterId=" + rWriterId + "]";
	}


}