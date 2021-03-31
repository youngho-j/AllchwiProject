package com.rebuild.project.vo.admin;

public class BigsmallCategoryVO {
	private int bcategory_num;
	private String bcategory_name;
	
	private int scategory_num;
	private String scategory_name;
	
	public BigsmallCategoryVO() {}

	public BigsmallCategoryVO(int bcategory_num, String bcategory_name, int scategory_num, String scategory_name) {
		super();
		this.bcategory_num = bcategory_num;
		this.bcategory_name = bcategory_name;
		this.scategory_num = scategory_num;
		this.scategory_name = scategory_name;
	}

	public int getBcategory_num() {
		return bcategory_num;
	}

	public void setBcategory_num(int bcategory_num) {
		this.bcategory_num = bcategory_num;
	}

	public String getBcategory_name() {
		return bcategory_name;
	}

	public void setBcategory_name(String bcategory_name) {
		this.bcategory_name = bcategory_name;
	}

	public int getScategory_num() {
		return scategory_num;
	}

	public void setScategory_num(int scategory_num) {
		this.scategory_num = scategory_num;
	}

	public String getScategory_name() {
		return scategory_name;
	}

	public void setScategory_name(String scategory_name) {
		this.scategory_name = scategory_name;
	}

}
