package cn.test.email.model;

public class Condition {
	
	private String label;
	
	private Integer rank;
	
	private String type;

	public Condition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Condition(String label, Integer rank, String type) {
		super();
		this.label = label;
		this.rank = rank;
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Condition [label=" + label + ", rank=" + rank + ", type=" + type + "]";
	}
	
	
}
