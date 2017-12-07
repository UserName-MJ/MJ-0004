package cn.test.email.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class TExamQuestion implements Serializable{

	   private Integer id;

	    private String title;

	    private String _option;

	    private String answer;
	    
	    private  String type;

	    private Integer sid;
	    
	    private Integer rank=1;
	    
	    private List<String> ops=new ArrayList<String>();
	    
	    
	    
	    
	   


		public Integer getRank() {
			return rank;
		}

		public void setRank(Integer rank) {
			this.rank = rank;
		}

		public Integer getSid() {
			return sid;
		}

		public void setSid(Integer sid) {
			this.sid = sid;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title == null ? null : title.trim();
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
	        this.answer = answer == null ? null : answer.trim();
	    }

		public List<String> getOps() {
			return ops;
		}

		public void setOps(List<String> ops) {
			this.ops = ops;
		}
	    
	    
}
