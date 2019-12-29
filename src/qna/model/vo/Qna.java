package qna.model.vo;

import java.sql.Date;

public class Qna {
	
	private int qNum; //게시글 번호
	private String qId; // 글쓴이 아이디
	private String qTitle; //글제목
	private String qContent; // 본문
	private Date qDate; // 날짜
	private int pCode; //공연 코드
	private String qAnswer; //답변
	private String qCompletedOrNot; //답변 여부 O,X 기본값 X
	
	private String pTitle; //공연제목
	
	
	public Qna() {
		
	}


	public Qna(int qNum, String qId, String qTitle, String qContent, Date qDate, int pCode, String qAnswer,
			String qCompletedOrNot) {
		super();
		this.qNum = qNum;
		this.qId = qId;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qDate = qDate;
		this.pCode = pCode;
		this.qAnswer = qAnswer;
		this.qCompletedOrNot = qCompletedOrNot;
	}

	
	//인서트용 매개변수 생성자
	public Qna(String qId, String qTitle, String qContent,int pCode) {
		this.qId=qId;
		this.qTitle=qTitle;
		this.qContent=qContent;
		this.pCode=pCode;
	}






	public String getqCompletedOrNot() {
		return qCompletedOrNot;
	}





	public void setqCompletedOrNot(String qCompletedOrNot) {
		this.qCompletedOrNot = qCompletedOrNot;
	}





	public int getqNum() {
		return qNum;
	}


	public void setqNum(int qNum) {
		this.qNum = qNum;
	}


	public String getqId() {
		return qId;
	}


	public void setqId(String qId) {
		this.qId = qId;
	}


	public String getqTitle() {
		return qTitle;
	}


	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}


	public String getqContent() {
		return qContent;
	}


	public void setqContent(String qContent) {
		this.qContent = qContent;
	}


	public Date getqDate() {
		return qDate;
	}


	public void setqDate(Date qDate) {
		this.qDate = qDate;
	}


	public int getpCode() {
		return pCode;
	}


	public void setpCode(int pCode) {
		this.pCode = pCode;
	}


	public String getqAnswer() {
		return qAnswer;
	}


	public void setqAnswer(String qAnswer) {
		this.qAnswer = qAnswer;
	}

	
	public String getpTitle() {
		return pTitle;
	}


	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}


	@Override
	public String toString() {
		return "Qna [qNum=" + qNum + ", qId=" + qId + ", qTitle=" + qTitle + ", qContent=" + qContent + ", qDate="
				+ qDate + ", pCode=" + pCode + ", qAnswer=" + qAnswer + ", qCompletedOrNot=" + qCompletedOrNot + "]";
	}


}
