package cn.test.email.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class TQuestion implements Serializable{
	
	private Integer id; 
	
	private Integer pid;
	
	private String label;

    private String title;

    private String _option;

    private String answer;
    
    private  Integer type;

    private Integer rank=1;
    
    private List<String> ops=new ArrayList<String>();
    
    private Date created;

	public TQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TQuestion(Integer id, Integer pid,String label, String title, String _option, String answer, Integer type,
			Integer rank, List<String> ops, Date created) {
		super();
		this.id = id;
		this.pid = pid;
		this.label = label;
		this.title = title;
		this._option = _option;
		this.answer = answer;
		this.type = type;
		this.rank = rank;
		this.ops = ops;
		this.created = created;
	}
	
	

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String get_option() {
		return _option;
	}

	public void set_option(String _option) {
		this._option = _option;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public List<String> getOps() {
		return ops;
	}

	public void setOps(List<String> ops) {
		this.ops = ops;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date date) {
		this.created = date;
	}

	@Override
	public String toString() {
		return "TQuestion [id=" + id + ", label=" + label + ", title=" + title + ", _option=" + _option + ", answer="
				+ answer + ", type=" + type + ", rank=" + rank + ", ops=" + ops + ", created="
				+ created + "]";
	}
    
    

}
