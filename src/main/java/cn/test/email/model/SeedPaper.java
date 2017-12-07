package cn.test.email.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SeedPaper implements Serializable{

	private Integer id;
	private String spname; 
	private Integer sqnum;
	private Integer sminute;
	private String stime;
	private Integer pid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public Integer getSqnum() {
		return sqnum;
	}
	public void setSqnum(Integer sqnum) {
		this.sqnum = sqnum;
	}
	public Integer getSminute() {
		return sminute;
	}
	public void setSminute(Integer sminute) {
		this.sminute = sminute;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
}
