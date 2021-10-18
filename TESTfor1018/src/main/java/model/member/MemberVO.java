package model.member;

public class MemberVO {
	/*MID VARCHAR(10) PRIMARY KEY,
	MPW VARCHAR(15)*/
	
	private String mid;
	private String mpw;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mid: " + mid + ", mpw: " + mpw + "]";
	}
	
}
