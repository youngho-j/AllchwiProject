package com.rebuild.project.vo.admin;

public class CurriVO {
	private int curri_count;
	private String curri_content;
	
	public CurriVO() {}

	public CurriVO(int curri_count, String curri_content) {
		super();
		this.curri_count = curri_count;
		this.curri_content = curri_content;
	}

	public int getCurri_count() {
		return curri_count;
	}

	public void setCurri_count(int curri_count) {
		this.curri_count = curri_count;
	}

	public String getCurri_content() {
		return curri_content;
	}

	public void setCurri_content(String curri_content) {
		this.curri_content = curri_content;
	}
	
	
	
	
}
