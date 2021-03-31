package com.rebuild.project.vo.admin;

public class Statistic1VO {
	private int month;
	private int monthlySum;
	private int monthlyRevenue;
	
	public Statistic1VO () {}

	public Statistic1VO(int month, int monthlySum, int monthlyRevenue) {
		super();
		this.month = month;
		this.monthlySum = monthlySum;
		this.monthlyRevenue = monthlyRevenue;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getMonthlySum() {
		return monthlySum;
	}

	public void setMonthlySum(int monthlySum) {
		this.monthlySum = monthlySum;
	}

	public int getMonthlyRevenue() {
		return monthlyRevenue;
	}

	public void setMonthlyRevenue(int monthlyRevenue) {
		this.monthlyRevenue = monthlyRevenue;
	}
	
	
}
