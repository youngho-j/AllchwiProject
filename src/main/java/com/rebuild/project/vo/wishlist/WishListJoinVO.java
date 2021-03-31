package com.rebuild.project.vo.wishlist;


public class WishListJoinVO {
	private int class_num;
	private String class_title;
	private int class_form;
	private int class_price;
	private String sloc_name;
	private int cover_num;
	private double class_rating;
	
	public WishListJoinVO() {}

	public WishListJoinVO(int class_num, String class_title, int class_form, int class_price, String sloc_name,
			int cover_num, double class_rating) {
		super();
		this.class_num = class_num;
		this.class_title = class_title;
		this.class_form = class_form;
		this.class_price = class_price;
		this.sloc_name = sloc_name;
		this.cover_num = cover_num;
		this.class_rating = class_rating;
	}

	public int getClass_num() {
		return class_num;
	}

	public void setClass_num(int class_num) {
		this.class_num = class_num;
	}

	public String getClass_title() {
		return class_title;
	}

	public void setClass_title(String class_title) {
		this.class_title = class_title;
	}

	public int getClass_form() {
		return class_form;
	}

	public void setClass_form(int class_form) {
		this.class_form = class_form;
	}

	public int getClass_price() {
		return class_price;
	}

	public void setClass_price(int class_price) {
		this.class_price = class_price;
	}

	public String getSloc_name() {
		return sloc_name;
	}

	public void setSloc_name(String sloc_name) {
		this.sloc_name = sloc_name;
	}

	public int getCover_num() {
		return cover_num;
	}

	public void setCover_num(int cover_num) {
		this.cover_num = cover_num;
	}

	public double getClass_rating() {
		return class_rating;
	}

	public void setClass_rating(double class_rating) {
		this.class_rating = class_rating;
	}
	
	
	
	
}
