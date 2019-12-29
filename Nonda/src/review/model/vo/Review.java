package review.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Review implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int rno;			// 게시글 번호
	private String rtitle;		// 제목 --> 제목 따로 없이 공연이름으로
	private String rcontent;	// 게시글 내용
	private String rwriter;		// 게시글 작성자
	private String rwriterId;	// DB로부터 가져올 게시글 작성자 아이디
	private Date rdate;			// 작성일
	private int rrecommend;		// 추천수
	private int rstar;			// 평점
	private int pcode;			// 공연코드
	private String status;		// 삭제여부('Y'이면 삭제x, 'N'이면 삭제o)
	private String poster;
	private int bno; 			// 예매번호(예매번호 하나당 하나의 리뷰 작성 가능)
	private String rFaceImg;  // 은수추가 - 아바타 이미지 경로
	

	public Review() { }


	public Review(int rno, String rtitle, String rcontent, String rwriter, String rwriterId, Date rdate, int rrecommend,
			int rstar, int pcode, String status, String poster, int bno, String rFaceImg) {
		super();
		this.rno = rno;
		this.rtitle = rtitle;
		this.rcontent = rcontent;
		this.rwriter = rwriter;
		this.rwriterId = rwriterId;
		this.rdate = rdate;
		this.rrecommend = rrecommend;
		this.rstar = rstar;
		this.pcode = pcode;
		this.status = status;
		this.poster = poster;
		this.bno = bno;
		this.rFaceImg = rFaceImg;
	}


	public int getRno() {
		return rno;
	}


	public void setRno(int rno) {
		this.rno = rno;
	}


	public String getRtitle() {
		return rtitle;
	}


	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}


	public String getRcontent() {
		return rcontent;
	}


	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}


	public String getRwriter() {
		return rwriter;
	}


	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}


	public String getRwriterId() {
		return rwriterId;
	}


	public void setRwriterId(String rwriterId) {
		this.rwriterId = rwriterId;
	}


	public Date getRdate() {
		return rdate;
	}


	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}


	public int getRrecommend() {
		return rrecommend;
	}


	public void setRrecommend(int rrecommend) {
		this.rrecommend = rrecommend;
	}


	public int getRstar() {
		return rstar;
	}


	public void setRstar(int rstar) {
		this.rstar = rstar;
	}


	public int getPcode() {
		return pcode;
	}


	public void setPcode(int pcode) {
		this.pcode = pcode;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPoster() {
		return poster;
	}


	public void setPoster(String poster) {
		this.poster = poster;
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}

	
	public String getrFaceImg() {
		return rFaceImg;
	}


	public void setrFaceImg(String rFaceImg) {
		this.rFaceImg = rFaceImg;
	}


	@Override
	public String toString() {
		return "Review [rno=" + rno + ", rtitle=" + rtitle + ", rcontent=" + rcontent + ", rwriter=" + rwriter
				+ ", rwriterId=" + rwriterId + ", rdate=" + rdate + ", rrecommend=" + rrecommend + ", rstar=" + rstar
				+ ", pcode=" + pcode + ", status=" + status + ", poster=" + poster + ", bno=" + bno + ", rFaceImg="
				+ rFaceImg + "]";
	}


}
