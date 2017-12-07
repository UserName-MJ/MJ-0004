package cn.test.email.model;

public class Label {
	
	private Integer lid;
	
	private String label;

	public Label() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Label(Integer lid, String label) {
		super();
		this.lid = lid;
		this.label = label;
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Label [lid=" + lid + ", label=" + label + "]";
	}

}
