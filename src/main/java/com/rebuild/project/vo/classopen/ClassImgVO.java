package com.rebuild.project.vo.classopen;

import java.sql.Timestamp;

public class ClassImgVO {
	private int cover_num;
	private int class_num;
	private String cover_name;
	private Object cover_file;
	private Timestamp cover_regdate;
	
	public ClassImgVO() {}

	public ClassImgVO(int cover_num, int class_num, String cover_name, Object cover_file, Timestamp cover_regdate) {
		super();
		this.cover_num = cover_num;
		this.class_num = class_num;
		this.cover_name = cover_name;
		this.cover_file = cover_file;
		this.cover_regdate = cover_regdate;
	}

	public int getCover_num() {
		return cover_num;
	}

	public void setCover_num(int cover_num) {
		this.cover_num = cover_num;
	}

	public int getClass_num() {
		return class_num;
	}

	public void setClass_num(int class_num) {
		this.class_num = class_num;
	}

	public String getCover_name() {
		return cover_name;
	}

	public void setCover_name(String cover_name) {
		this.cover_name = cover_name;
	}

	public Object getCover_file() {
		return cover_file;
	}

	public void setCover_file(Object cover_file) {
		this.cover_file = cover_file;
	}

	public Timestamp getCover_regdate() {
		return cover_regdate;
	}

	public void setCover_regdate(Timestamp cover_regdate) {
		this.cover_regdate = cover_regdate;
	}

	
	
}
