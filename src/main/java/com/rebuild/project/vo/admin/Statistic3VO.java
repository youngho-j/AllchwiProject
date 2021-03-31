package com.rebuild.project.vo.admin;

public class Statistic3VO {
	private int cate_count;
	private String bcategory_name;
	
	public Statistic3VO() {}
	
	public Statistic3VO(int cate_count, String bcategory_name) {
		super();
		this.cate_count = cate_count;
		this.bcategory_name = bcategory_name;
	}

	public int getCate_count() {
		return cate_count;
	}

	public void setCate_count(int cate_count) {
		this.cate_count = cate_count;
	}

	public String getBcategory_name() {
		return bcategory_name;
	}

	public void setBcategory_name(String bcategory_name) {
		this.bcategory_name = bcategory_name;
	}

}
