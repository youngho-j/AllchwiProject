package com.rebuild.project.vo.admin;

import java.sql.Timestamp;


public class MemberListVO {
	private String id;
	private int ml_num;
	private int mb_num;
	private String mb_name;
	private Timestamp mb_regdate;
	private int mb_auth;
	private int nowclass;
	private int totclass;
	private String mb_nickname;

	public MemberListVO() {}

	public MemberListVO(String id, int ml_num, int mb_num, String mb_name, Timestamp mb_regdate, int mb_auth,
			int nowclass, int totclass, String mb_nickname) {
		super();
		this.id = id;
		this.ml_num = ml_num;
		this.mb_num = mb_num;
		this.mb_name = mb_name;
		this.mb_regdate = mb_regdate;
		this.mb_auth = mb_auth;
		this.nowclass = nowclass;
		this.totclass = totclass;
		this.mb_nickname = mb_nickname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMl_num() {
		return ml_num;
	}

	public void setMl_num(int ml_num) {
		this.ml_num = ml_num;
	}

	public int getMb_num() {
		return mb_num;
	}

	public void setMb_num(int mb_num) {
		this.mb_num = mb_num;
	}

	public String getMb_name() {
		return mb_name;
	}

	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}

	public Timestamp getMb_regdate() {
		return mb_regdate;
	}

	public void setMb_regdate(Timestamp mb_regdate) {
		this.mb_regdate = mb_regdate;
	}

	public int getMb_auth() {
		return mb_auth;
	}

	public void setMb_auth(int mb_auth) {
		this.mb_auth = mb_auth;
	}

	public int getNowclass() {
		return nowclass;
	}

	public void setNowclass(int nowclass) {
		this.nowclass = nowclass;
	}

	public int getTotclass() {
		return totclass;
	}

	public void setTotclass(int totclass) {
		this.totclass = totclass;
	}

	public String getMb_nickname() {
		return mb_nickname;
	}

	public void setMb_nickname(String mb_nickname) {
		this.mb_nickname = mb_nickname;
	}


	


	
	
	
}
