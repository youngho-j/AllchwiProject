package com.rebuild.project.vo.wishlist;

import java.sql.Timestamp;

public class WishListVO {
	private int wish_num;
	private int class_num;
	private int ml_num;
	private Timestamp wish_regdate;
	public WishListVO() {};
	public WishListVO(int class_num, int ml_num) {
		super();
		this.class_num = class_num;
		this.ml_num = ml_num;
	}
	public WishListVO(int wish_num, int class_num, int ml_num, Timestamp wish_regdate) {
		super();
		this.wish_num = wish_num;
		this.class_num = class_num;
		this.ml_num = ml_num;
		this.wish_regdate = wish_regdate;
	}

	public int getWish_num() {
		return wish_num;
	}
	public void setWish_num(int wish_num) {
		this.wish_num = wish_num;
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
	public Timestamp getWish_regdate() {
		return wish_regdate;
	}
	public void setWish_regdate(Timestamp wish_regdate) {
		this.wish_regdate = wish_regdate;
	};
	
	
	
}
