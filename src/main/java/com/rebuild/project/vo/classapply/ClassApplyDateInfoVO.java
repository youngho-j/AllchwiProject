package com.rebuild.project.vo.classapply;

import java.sql.Timestamp;

public class ClassApplyDateInfoVO {
	private int class_num;
	private int date_num;
	private int pro_num;
	private Timestamp class_date;
	private String class_title;
	private String tutor_nickname;
	private String tutor_phone;
	private Timestamp apply_regdate;
	private int apply_auth;
	
	public ClassApplyDateInfoVO() {}

	public ClassApplyDateInfoVO(int class_num, int date_num, int pro_num, Timestamp class_date, String class_title,
			String tutor_nickname, String tutor_phone, Timestamp apply_regdate, int apply_auth) {
		super();
		this.class_num = class_num;
		this.date_num = date_num;
		this.pro_num = pro_num;
		this.class_date = class_date;
		this.class_title = class_title;
		this.tutor_nickname = tutor_nickname;
		this.tutor_phone = tutor_phone;
		this.apply_regdate = apply_regdate;
		this.apply_auth = apply_auth;
	}

	public int getClass_num() {
		return class_num;
	}

	public void setClass_num(int class_num) {
		this.class_num = class_num;
	}

	public int getDate_num() {
		return date_num;
	}

	public void setDate_num(int date_num) {
		this.date_num = date_num;
	}

	public int getPro_num() {
		return pro_num;
	}

	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}

	public Timestamp getClass_date() {
		return class_date;
	}

	public void setClass_date(Timestamp class_date) {
		this.class_date = class_date;
	}

	public String getClass_title() {
		return class_title;
	}

	public void setClass_title(String class_title) {
		this.class_title = class_title;
	}

	public String getTutor_nickname() {
		return tutor_nickname;
	}

	public void setTutor_nickname(String tutor_nickname) {
		this.tutor_nickname = tutor_nickname;
	}

	public int getApply_auth() {
		return apply_auth;
	}

	public void setApply_auth(int apply_auth) {
		this.apply_auth = apply_auth;
	}

	public String getTutor_phone() {
		return tutor_phone;
	}

	public void setTutor_phone(String tutor_phone) {
		this.tutor_phone = tutor_phone;
	}

	public Timestamp getApply_regdate() {
		return apply_regdate;
	}

	public void setApply_regdate(Timestamp apply_regdate) {
		this.apply_regdate = apply_regdate;
	}
	
	
	
}
