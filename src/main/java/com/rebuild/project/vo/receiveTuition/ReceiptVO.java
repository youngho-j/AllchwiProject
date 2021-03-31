package com.rebuild.project.vo.receiveTuition;

import java.sql.Timestamp;

public class ReceiptVO {
	private String class_title;
	private int class_num;
	private int class_form;
	private Timestamp pay_regdate;
	private int final_price;
	private int class_finish;
	private String id;
	private String mb_nickname;
	private int pro_num;
	private int pay_num;
	private int class_fee;
	
	public ReceiptVO() {}

	public ReceiptVO(String class_title, int class_num, int class_form, Timestamp pay_regdate, int final_price,
			int class_finish, String id, String mb_nickname, int pro_num, int pay_num, int class_fee) {
		super();
		this.class_title = class_title;
		this.class_num = class_num;
		this.class_form = class_form;
		this.pay_regdate = pay_regdate;
		this.final_price = final_price;
		this.class_finish = class_finish;
		this.id = id;
		this.mb_nickname = mb_nickname;
		this.pro_num = pro_num;
		this.pay_num = pay_num;
		this.class_fee = class_fee;
	}

	public String getClass_title() {
		return class_title;
	}

	public void setClass_title(String class_title) {
		this.class_title = class_title;
	}

	public int getClass_num() {
		return class_num;
	}

	public void setClass_num(int class_num) {
		this.class_num = class_num;
	}

	public int getClass_form() {
		return class_form;
	}

	public void setClass_form(int class_form) {
		this.class_form = class_form;
	}

	public Timestamp getPay_regdate() {
		return pay_regdate;
	}

	public void setPay_regdate(Timestamp pay_regdate) {
		this.pay_regdate = pay_regdate;
	}

	public int getFinal_price() {
		return final_price;
	}

	public void setFinal_price(int final_price) {
		this.final_price = final_price;
	}

	public int getClass_finish() {
		return class_finish;
	}

	public void setClass_finish(int class_finish) {
		this.class_finish = class_finish;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMb_nickname() {
		return mb_nickname;
	}

	public void setMb_nickname(String mb_nickname) {
		this.mb_nickname = mb_nickname;
	}

	public int getPro_num() {
		return pro_num;
	}

	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}

	public int getPay_num() {
		return pay_num;
	}

	public void setPay_num(int pay_num) {
		this.pay_num = pay_num;
	}

	public int getClass_fee() {
		return class_fee;
	}

	public void setClass_fee(int class_fee) {
		this.class_fee = class_fee;
	}

	
	
	
}
