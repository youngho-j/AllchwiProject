package com.rebuild.project.vo.admin;

import java.sql.Timestamp;

public class AdminRemitVO {
	private Timestamp rem_regdate;
	private String rem_bank;
	private int rem_pay;
	private String rem_account;
	private int rem_status;
	private int pay_num;
	private int ml_num;
	private String tutor_nickname;
	private String class_title;
	private int rem_revenue;
	
	public AdminRemitVO() {}

	public AdminRemitVO(Timestamp rem_regdate, String rem_bank, int rem_pay, String rem_account, int rem_status,
			int pay_num, int ml_num, String tutor_nickname, String class_title, int rem_revenue) {
		super();
		this.rem_regdate = rem_regdate;
		this.rem_bank = rem_bank;
		this.rem_pay = rem_pay;
		this.rem_account = rem_account;
		this.rem_status = rem_status;
		this.pay_num = pay_num;
		this.ml_num = ml_num;
		this.tutor_nickname = tutor_nickname;
		this.class_title = class_title;
		this.rem_revenue = rem_revenue;
	}

	public Timestamp getRem_regdate() {
		return rem_regdate;
	}

	public void setRem_regdate(Timestamp rem_regdate) {
		this.rem_regdate = rem_regdate;
	}

	public String getRem_bank() {
		return rem_bank;
	}

	public void setRem_bank(String rem_bank) {
		this.rem_bank = rem_bank;
	}

	public int getRem_pay() {
		return rem_pay;
	}

	public void setRem_pay(int rem_pay) {
		this.rem_pay = rem_pay;
	}

	public String getRem_account() {
		return rem_account;
	}

	public void setRem_account(String rem_account) {
		this.rem_account = rem_account;
	}

	public int getRem_status() {
		return rem_status;
	}

	public void setRem_status(int rem_status) {
		this.rem_status = rem_status;
	}

	public int getPay_num() {
		return pay_num;
	}

	public void setPay_num(int pay_num) {
		this.pay_num = pay_num;
	}

	public int getMl_num() {
		return ml_num;
	}

	public void setMl_num(int ml_num) {
		this.ml_num = ml_num;
	}

	public String getTutor_nickname() {
		return tutor_nickname;
	}

	public void setTutor_nickname(String tutor_nickname) {
		this.tutor_nickname = tutor_nickname;
	}

	public String getClass_title() {
		return class_title;
	}

	public void setClass_title(String class_title) {
		this.class_title = class_title;
	}

	public int getRem_revenue() {
		return rem_revenue;
	}

	public void setRem_revenue(int rem_revenue) {
		this.rem_revenue = rem_revenue;
	}
	
	
	
	
	
}
