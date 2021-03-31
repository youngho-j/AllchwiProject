package com.rebuild.project.vo.classopen;

import java.sql.Timestamp;

public class CurriculumVO {
	private int curri_num;
	private int class_num;
	private int curri_count;
	private String Curri_content;
	private Timestamp curri_regdate;
	
	public CurriculumVO() {}

	public CurriculumVO(int curri_num, int class_num, int curri_count, String curri_content, Timestamp curri_regdate) {
		super();
		this.curri_num = curri_num;
		this.class_num = class_num;
		this.curri_count = curri_count;
		Curri_content = curri_content;
		this.curri_regdate = curri_regdate;
	}

	public int getCurri_num() {
		return curri_num;
	}

	public void setCurri_num(int curri_num) {
		this.curri_num = curri_num;
	}

	public int getClass_num() {
		return class_num;
	}

	public void setClass_num(int class_num) {
		this.class_num = class_num;
	}

	public int getCurri_count() {
		return curri_count;
	}

	public void setCurri_count(int curri_count) {
		this.curri_count = curri_count;
	}

	public String getCurri_content() {
		return Curri_content;
	}

	public void setCurri_content(String curri_content) {
		Curri_content = curri_content;
	}

	public Timestamp getCurri_regdate() {
		return curri_regdate;
	}

	public void setCurri_regdate(Timestamp curri_regdate) {
		this.curri_regdate = curri_regdate;
	}
}