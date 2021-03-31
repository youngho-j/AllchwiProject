package com.rebuild.project.vo.community;

import java.sql.Timestamp;

public class CommunityVO {
	private int commu_num;
	private int class_num;
	private String commu_title;
	private Timestamp commu_regdate;
	private int ml_num;
	
	public CommunityVO(int commu_num, int class_num, String commu_title, Timestamp commu_regdate) {
		super();
		this.commu_num = commu_num;
		this.class_num = class_num;
		this.commu_title = commu_title;
		this.commu_regdate = commu_regdate;
	}
	public int getCommu_num() {
		return commu_num;
	}
	public void setCommu_num(int commu_num) {
		this.commu_num = commu_num;
	}
	public int getClass_num() {
		return class_num;
	}
	public void setClass_num(int class_num) {
		this.class_num = class_num;
	}
	public String getCommu_title() {
		return commu_title;
	}
	public void setCommu_title(String commu_title) {
		this.commu_title = commu_title;
	}
	public Timestamp getCommu_regdate() {
		return commu_regdate;
	}
	public void setCommu_regdate(Timestamp commu_regdate) {
		this.commu_regdate = commu_regdate;
	}
	public int getMl_num() {
		return ml_num;
	}
	public void setMl_num(int ml_num) {
		this.ml_num = ml_num;
	}
	
	
}
