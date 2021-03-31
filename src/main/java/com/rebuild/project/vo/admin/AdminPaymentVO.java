package com.rebuild.project.vo.admin;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AdminPaymentVO {
	private int ml_num;
	private String id;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "Asia/Seoul")
	private	Timestamp pay_regdate;
	private String class_title;
	private String pay_way;
	private int final_price;
	
	public AdminPaymentVO() {}

	public AdminPaymentVO(int ml_num, String id, Timestamp pay_regdate, String class_title, String pay_way,
			int final_price) {
		super();
		this.ml_num = ml_num;
		this.id = id;
		this.pay_regdate = pay_regdate;
		this.class_title = class_title;
		this.pay_way = pay_way;
		this.final_price = final_price;
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



	public Timestamp getPay_regdate() {
		return pay_regdate;
	}



	public void setPay_regdate(Timestamp pay_regdate) {
		this.pay_regdate = pay_regdate;
	}



	public String getClass_title() {
		return class_title;
	}



	public void setClass_title(String class_title) {
		this.class_title = class_title;
	}



	public String getPay_way() {
		return pay_way;
	}



	public void setPay_way(String pay_way) {
		this.pay_way = pay_way;
	}



	public int getFinal_price() {
		return final_price;
	}



	public void setFinal_price(int final_price) {
		this.final_price = final_price;
	}


	




	
	

}
