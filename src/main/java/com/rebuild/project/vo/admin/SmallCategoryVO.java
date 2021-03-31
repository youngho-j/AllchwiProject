package com.rebuild.project.vo.admin;

public class SmallCategoryVO {
	private int scategory_num;
	private int bcategory_num;
	private String scategory_name;
	

	public SmallCategoryVO() {
		super();
	}


	public SmallCategoryVO(int scategory_num, int bcategory_num, String scategory_name) {
		super();
		this.scategory_num = scategory_num;
		this.bcategory_num = bcategory_num;
		this.scategory_name = scategory_name;
	}


	public int getScategory_num() {
		return scategory_num;
	}


	public void setScategory_num(int scategory_num) {
		this.scategory_num = scategory_num;
	}


	public int getBcategory_num() {
		return bcategory_num;
	}


	public void setBcategory_num(int bcategory_num) {
		this.bcategory_num = bcategory_num;
	}


	public String getScategory_name() {
		return scategory_name;
	}


	public void setScategory_name(String scategory_name) {
		this.scategory_name = scategory_name;
	}

	
	
	
	
	
}
