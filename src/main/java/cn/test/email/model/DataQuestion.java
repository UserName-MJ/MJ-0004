package cn.test.email.model;

public class DataQuestion {

	private Integer uid;
	private Integer count;
	private Integer cuo;
	private String datatime;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getCuo() {
		return cuo;
	}
	public void setCuo(Integer cuo) {
		this.cuo = cuo;
	}
	public String getDatatime() {
		return datatime;
	}
	public void setDatatime(String datatime) {
		this.datatime = datatime;
	}
	@Override
	public String toString() {
		return "DataQuestion [uid=" + uid + ", count=" + count + ", cuo=" + cuo + ", datatime=" + datatime + "]";
	}
	
	
	
}
