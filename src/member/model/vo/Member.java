package member.model.vo;

import java.sql.Date;

public class Member
{
	private String mId;
	private String mPw;
	private String mName;
	private String mPhone;
	private String mAccess;
	private char mAllow;
	private int mAge;
	private Date mJoindate;
	private Date mDropdate;
	private char mValid;
	private String mRoute;

	public Member() {

	}

	// 로그인용 생성자
	public Member(String mId, String mPw) {
		super();
		this.mId = mId;
		this.mPw = mPw;
	}

	// 구글가입용 생성자
	public Member(String mId, String mName, String mRoute) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mRoute = mRoute;
	}

	// 회원가입용 생성자
	public Member(String mId, String mPw, String mName, String mPhone, String mAccess, int mAge) {
		super();
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mPhone = mPhone;
		this.mAccess = mAccess;
		this.mAge = mAge;
	}


	// 정보 불러오기용 생성자
	public Member(String mId, String mPw, String mName, String mPhone, String mAccess, char mAllow, int mAge,
			Date mJoindate, Date mDropdate, char mValid, String mRoute) {
		super();
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mPhone = mPhone;
		this.mAccess = mAccess;
		this.mAllow = mAllow;
		this.mAge = mAge;
		this.mJoindate = mJoindate;
		this.mDropdate = mDropdate;
		this.mValid = mValid;
		this.mRoute = mRoute;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		this.mPw = mPw;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmPhone() {
		return mPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public String getmAccess() {
		return mAccess;
	}

	public void setmAccess(String mAccess) {
		this.mAccess = mAccess;
	}

	public char getmAllow() {
		return mAllow;
	}

	public void setmAllow(char mAllow) {
		this.mAllow = mAllow;
	}

	public int getmAge() {
		return mAge;
	}

	public void setmAge(int mAge) {
		this.mAge = mAge;
	}

	public Date getmJoindate() {
		return mJoindate;
	}

	public void setmJoindate(Date mJoindate) {
		this.mJoindate = mJoindate;
	}

	public Date getmDropdate() {
		return mDropdate;
	}

	public void setmDropdate(Date mDropdate) {
		this.mDropdate = mDropdate;
	}

	public char getmValid() {
		return mValid;
	}

	public void setmValid(char mValid) {
		this.mValid = mValid;
	}

	public String getmRoute() {
		return mRoute;
	}

	public void setmRoute(String mRoute) {
		this.mRoute = mRoute;
	}

	@Override
	public String toString() {
		return "Member [mId=" + mId + ", mPw=" + mPw + ", mName=" + mName + ", mPhone=" + mPhone + ", mAccess="
				+ mAccess + ", mAllow=" + mAllow + ", mAge=" + mAge + ", mJoindate=" + mJoindate + ", mDropdate="
				+ mDropdate + ", mValid=" + mValid + ", mRoute=" + mRoute + "]";
	}
}