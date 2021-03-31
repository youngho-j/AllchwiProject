package com.rebuild.project.vo.admin;

public class SalesVO {
	private int pay_num;
	private String class_name;
	private String tutor_name;
	private int pay;
	private int revenue;
	
	public SalesVO() {}

	public SalesVO(int pay_num, String class_name, String tutor_name, int pay, int revenue) {
		super();
		this.pay_num = pay_num;
		this.class_name = class_name;
		this.tutor_name = tutor_name;
		this.pay = pay;
		this.revenue = revenue;
	}

	public int getPay_num() {
		return pay_num;
	}

	public void setPay_num(int pay_num) {
		this.pay_num = pay_num;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getTutor_name() {
		return tutor_name;
	}

	public void setTutor_name(String tutor_name) {
		this.tutor_name = tutor_name;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	
	
	
	
}
