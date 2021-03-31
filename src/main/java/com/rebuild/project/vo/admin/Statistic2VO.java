package com.rebuild.project.vo.admin;

public class Statistic2VO {
	private String title;
	private int cnt;
	
	public Statistic2VO() {}

	public Statistic2VO(String title, int cnt) {
		super();
		this.title = title;
		this.cnt = cnt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
}
