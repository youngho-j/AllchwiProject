package com.rebuild.project.vo.myclasslist;

import java.sql.Timestamp;

public class MyClassListVO {
	private int class_num;
	private int date_num;
	private Timestamp class_date;
	private String class_title;
	private String scategory_name;
	private int cover_num;
	private int class_fee;
	private int apply_auth;
	private double class_rating;
	private Timestamp apply_regdate;
	private Timestamp pay_regdate;
	private String class_startTime;
	private int class_form;
	private int class_finish;
	private int apply_num;
	
	public MyClassListVO() {}

	public MyClassListVO(int class_num, int date_num, Timestamp class_date, String class_title, String scategory_name,
			int cover_num, int class_fee, int apply_auth, double class_rating, Timestamp apply_regdate,
			Timestamp pay_regdate, String class_startTime, int class_form, int class_finish, int apply_num) {
		super();
		this.class_num = class_num;
		this.date_num = date_num;
		this.class_date = class_date;
		this.class_title = class_title;
		this.scategory_name = scategory_name;
		this.cover_num = cover_num;
		this.class_fee = class_fee;
		this.apply_auth = apply_auth;
		this.class_rating = class_rating;
		this.apply_regdate = apply_regdate;
		this.pay_regdate = pay_regdate;
		this.class_startTime = class_startTime;
		this.class_form = class_form;
		this.class_finish = class_finish;
		this.apply_num = apply_num;
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

	public String getScategory_name() {
		return scategory_name;
	}

	public void setScategory_name(String scategory_name) {
		this.scategory_name = scategory_name;
	}

	public int getCover_num() {
		return cover_num;
	}

	public void setCover_num(int cover_num) {
		this.cover_num = cover_num;
	}

	public int getClass_fee() {
		return class_fee;
	}

	public void setClass_fee(int class_fee) {
		this.class_fee = class_fee;
	}

	public int getApply_auth() {
		return apply_auth;
	}

	public void setApply_auth(int apply_auth) {
		this.apply_auth = apply_auth;
	}

	public double getClass_rating() {
		return class_rating;
	}

	public void setClass_rating(double class_rating) {
		this.class_rating = class_rating;
	}

	public Timestamp getApply_regdate() {
		return apply_regdate;
	}

	public void setApply_regdate(Timestamp apply_regdate) {
		this.apply_regdate = apply_regdate;
	}

	public Timestamp getPay_regdate() {
		return pay_regdate;
	}

	public void setPay_regdate(Timestamp pay_regdate) {
		this.pay_regdate = pay_regdate;
	}

	public String getClass_startTime() {
		return class_startTime;
	}

	public void setClass_startTime(String class_startTime) {
		this.class_startTime = class_startTime;
	}

	public int getClass_form() {
		return class_form;
	}

	public void setClass_form(int class_form) {
		this.class_form = class_form;
	}

	public int getClass_finish() {
		return class_finish;
	}

	public void setClass_finish(int class_finish) {
		this.class_finish = class_finish;
	}

	public int getApply_num() {
		return apply_num;
	}

	public void setApply_num(int apply_num) {
		this.apply_num = apply_num;
	}

	
	
	
}
