package cn.test.email.model;

import java.io.Serializable;

/**
 * 
 * @author AdminMcj
 *
 */
public class TPaperHistoryVo implements Serializable{

	private Integer uid;
	
	private Integer pid;
	
	private Integer qid;
	
	private Integer type;
	
	private Integer state;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	
}
