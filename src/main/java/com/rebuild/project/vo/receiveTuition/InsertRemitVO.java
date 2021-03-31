package com.rebuild.project.vo.receiveTuition;
public class InsertRemitVO {
	private int pay_num;
	private int rem_pay;

	private String rem_bank;
	private String rem_account;
	private int rem_revenue;
	
	public InsertRemitVO() {}

	public InsertRemitVO(int pay_num, int rem_pay, String rem_bank, String rem_account, int rem_revenue) {
		super();
		this.pay_num = pay_num;
		this.rem_pay = rem_pay;
		this.rem_bank = rem_bank;
		this.rem_account = rem_account;
		this.rem_revenue = rem_revenue;
	}

	public int getPay_num() {
		return pay_num;
	}

	public void setPay_num(int pay_num) {
		this.pay_num = pay_num;
	}

	public int getRem_pay() {
		return rem_pay;
	}

	public void setRem_pay(int rem_pay) {
		this.rem_pay = rem_pay;
	}

	public String getRem_bank() {
		return rem_bank;
	}

	public void setRem_bank(String rem_bank) {
		this.rem_bank = rem_bank;
	}

	public String getRem_account() {
		return rem_account;
	}

	public void setRem_account(String rem_account) {
		this.rem_account = rem_account;
	}

	public int getRem_revenue() {
		return rem_revenue;
	}

	public void setRem_revenue(int rem_revenue) {
		this.rem_revenue = rem_revenue;
	}

	
	
	
}
