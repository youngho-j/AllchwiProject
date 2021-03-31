package com.rebuild.project.vo.classapply;

import java.sql.Timestamp;

public class PaymentVO {
	private int pay_num;
	private int class_num;
	private int ml_num;
	private int apply_num;
	private String pay_way;
	private int final_price;
	private int pay_point;
	private int class_fee;
	private int class_finish;
	private int remit_status;
	private Timestamp pay_regdate;
	
	public PaymentVO() {}

	public PaymentVO(int pay_num, int class_num, int ml_num, int apply_num, String pay_way, int final_price,
			int pay_point, int class_fee, int class_finish, int remit_status, Timestamp pay_regdate) {
		super();
		this.pay_num = pay_num;
		this.class_num = class_num;
		this.ml_num = ml_num;
		this.apply_num = apply_num;
		this.pay_way = pay_way;
		this.final_price = final_price;
		this.pay_point = pay_point;
		this.class_fee = class_fee;
		this.class_finish = class_finish;
		this.remit_status = remit_status;
		this.pay_regdate = pay_regdate;
	}

	public int getPay_num() {
		return pay_num;
	}

	public void setPay_num(int pay_num) {
		this.pay_num = pay_num;
	}

	public int getClass_num() {
		return class_num;
	}

	public void setClass_num(int class_num) {
		this.class_num = class_num;
	}

	public int getMl_num() {
		return ml_num;
	}

	public void setMl_num(int ml_num) {
		this.ml_num = ml_num;
	}

	public int getApply_num() {
		return apply_num;
	}

	public void setApply_num(int apply_num) {
		this.apply_num = apply_num;
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

	public int getPay_point() {
		return pay_point;
	}

	public void setPay_point(int pay_point) {
		this.pay_point = pay_point;
	}

	public int getClass_fee() {
		return class_fee;
	}

	public void setClass_fee(int class_fee) {
		this.class_fee = class_fee;
	}

	public int getClass_finish() {
		return class_finish;
	}

	public void setClass_finish(int class_finish) {
		this.class_finish = class_finish;
	}

	public int getRemit_status() {
		return remit_status;
	}

	public void setRemit_status(int remit_status) {
		this.remit_status = remit_status;
	}

	public Timestamp getPay_regdate() {
		return pay_regdate;
	}

	public void setPay_regdate(Timestamp pay_regdate) {
		this.pay_regdate = pay_regdate;
	}
	
	
	
}
