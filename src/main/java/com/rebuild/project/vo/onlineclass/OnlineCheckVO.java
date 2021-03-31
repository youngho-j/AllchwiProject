package com.rebuild.project.vo.onlineclass;

import java.sql.Timestamp;

public class OnlineCheckVO {
	private int check_num;
	private int ml_num;
	private int online_num;
	private int view_point;
	private Timestamp view_regdate;
	
	public OnlineCheckVO() {}
	
	public OnlineCheckVO(int check_num, int ml_num, int online_num, int view_point, Timestamp view_regdate) {
		super();
		this.check_num = check_num;
		this.ml_num = ml_num;
		this.online_num = online_num;
		this.view_point = view_point;
		this.view_regdate = view_regdate;
	}

	public int getCheck_num() {
		return check_num;
	}

	public void setCheck_num(int check_num) {
		this.check_num = check_num;
	}

	public int getMl_num() {
		return ml_num;
	}

	public void setMl_num(int ml_num) {
		this.ml_num = ml_num;
	}

	public int getOnline_num() {
		return online_num;
	}

	public void setOnline_num(int online_num) {
		this.online_num = online_num;
	}

	public int getView_point() {
		return view_point;
	}

	public void setView_point(int view_point) {
		this.view_point = view_point;
	}

	public Timestamp getView_regdate() {
		return view_regdate;
	}

	public void setView_regdate(Timestamp view_regdate) {
		this.view_regdate = view_regdate;
	}
	
}
