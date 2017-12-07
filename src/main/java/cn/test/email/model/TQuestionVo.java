package cn.test.email.model;

public class TQuestionVo {

	private Integer lid;
	private String lname;
	private Integer lCount;
	private Integer lu;
	
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Integer getlCount() {
		return lCount;
	}
	public void setlCount(Integer lCount) {
		this.lCount = lCount;
	}
	public Integer getLu() {
		return lu;
	}
	public void setLu(Integer lu) {
		this.lu = lu;
	}
	@Override
	public String toString() {
		return "TQuestionVo [lid=" + lid + ", lname=" + lname + ", lCount=" + lCount + ", lu=" + lu + "]";
	}
	
	
	
}
