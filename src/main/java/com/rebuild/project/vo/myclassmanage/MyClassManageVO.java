package com.rebuild.project.vo.myclassmanage;

import java.sql.Timestamp;

public class MyClassManageVO {
	private int class_num;
	private String class_title;
	private int date_num;
	private int apply_num;
	private int ml_num;
	private int pro_num;
	private String mb_name;
	private String mb_nickname;
	private int apply_auth;
	private int final_price;
	private int class_fee;
	private Timestamp apply_regdate;
	
	public MyClassManageVO() {}

	public MyClassManageVO(int class_num, String class_title, int date_num, int apply_num, int ml_num, int pro_num,
			String mb_name, String mb_nickname, int apply_auth, int final_price, int class_fee,
			Timestamp apply_regdate) {
		super();
		this.class_num = class_num;
		this.class_title = class_title;
		this.date_num = date_num;
		this.apply_num = apply_num;
		this.ml_num = ml_num;
		this.pro_num = pro_num;
		this.mb_name = mb_name;
		this.mb_nickname = mb_nickname;
		this.apply_auth = apply_auth;
		this.final_price = final_price;
		this.class_fee = class_fee;
		this.apply_regdate = apply_regdate;
	}

	public int getClass_num() {
		return class_num;
	}

	public void setClass_num(int class_num) {
		this.class_num = class_num;
	}

	public String getClass_title() {
		return class_title;
	}

	public void setClass_title(String class_title) {
		this.class_title = class_title;
	}

	public int getDate_num() {
		return date_num;
	}

	public void setDate_num(int date_num) {
		this.date_num = date_num;
	}

	public int getApply_num() {
		return apply_num;
	}

	public void setApply_num(int apply_num) {
		this.apply_num = apply_num;
	}

	public int getMl_num() {
		return ml_num;
	}

	public void setMl_num(int ml_num) {
		this.ml_num = ml_num;
	}

	public int getPro_num() {
		return pro_num;
	}

	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
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

	public int getApply_auth() {
		return apply_auth;
	}

	public void setApply_auth(int apply_auth) {
		this.apply_auth = apply_auth;
	}

	public int getFinal_price() {
		return final_price;
	}

	public void setFinal_price(int final_price) {
		this.final_price = final_price;
	}

	public int getClass_fee() {
		return class_fee;
	}

	public void setClass_fee(int class_fee) {
		this.class_fee = class_fee;
	}

	public Timestamp getApply_regdate() {
		return apply_regdate;
	}

	public void setApply_regdate(Timestamp apply_regdate) {
		this.apply_regdate = apply_regdate;
	}
}
