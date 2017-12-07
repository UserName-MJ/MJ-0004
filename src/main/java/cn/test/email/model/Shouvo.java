package cn.test.email.model;

import java.util.List;

public class Shouvo{
	private List<TExamQuestion> l;
	private String pname;
	private String time;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<TExamQuestion> getL() {
		return l;
	}
	public void setL(List<TExamQuestion> l) {
		this.l = l;
	}
	
}
