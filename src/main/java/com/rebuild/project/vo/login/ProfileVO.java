package com.rebuild.project.vo.login;

public class ProfileVO {

	private int ml_num;
	private String id;
	private String mb_name;
	private String mb_nickname;
	private String mb_about;
	private int pro_num;
	private Object pro_img;

	public ProfileVO() {}

	public ProfileVO(int ml_num, String id, String mb_name, String mb_nickname, String mb_about, int pro_num,
			Object pro_img) {
		super();
		this.ml_num = ml_num;
		this.id = id;
		this.mb_name = mb_name;
		this.mb_nickname = mb_nickname;
		this.mb_about = mb_about;
		this.pro_num = pro_num;
		this.pro_img = pro_img;
	}

	public int getMl_num() {
		return ml_num;
	}

	public void setMl_num(int ml_num) {
		this.ml_num = ml_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMb_name() {
		return mb_name;
	}

	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}

	public String getMb_nickname() {
		return mb_nickname;
	}

	public void setMb_nickname(String mb_nickname) {
		this.mb_nickname = mb_nickname;
	}

	public String getMb_about() {
		return mb_about;
	}

	public void setMb_about(String mb_about) {
		this.mb_about = mb_about;
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

}
