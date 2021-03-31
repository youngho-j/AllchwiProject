package com.rebuild.project.vo.profileImg;

import java.sql.Timestamp;

public class ProfileImgVO {
	private int pro_num;
	private Object pro_img;
	private String pro_filename;
	private Timestamp pro_regdate;
	
	public ProfileImgVO() {}

	public ProfileImgVO(int pro_num, Object pro_img, String pro_filename, Timestamp pro_regdate) {
		super();
		this.pro_num = pro_num;
		this.pro_img = pro_img;
		this.pro_filename = pro_filename;
		this.pro_regdate = pro_regdate;
	}

	public int getPro_num() {
		return pro_num;
	}

	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}

	public Object getPro_img() {
		return pro_img;
	}

	public void setPro_img(Object pro_img) {
		this.pro_img = pro_img;
	}

	public String getPro_filename() {
		return pro_filename;
	}

	public void setPro_filename(String pro_filename) {
		this.pro_filename = pro_filename;
	}

	public Timestamp getPro_regdate() {
		return pro_regdate;
	}

	public void setPro_regdate(Timestamp pro_regdate) {
		this.pro_regdate = pro_regdate;
	}

	
	
}
