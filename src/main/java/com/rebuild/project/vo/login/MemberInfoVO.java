package com.rebuild.project.vo.login;

import java.sql.Timestamp;

public class MemberInfoVO {
	private int mb_num;
	private int ml_num;
	private int pro_num;
	private String mb_name;
	private String mb_phone;
	private String mb_nickname;
	private String mb_about;
	private int mb_auth;
	private String mb_reason;
	private Timestamp mb_regdate;
	
	public MemberInfoVO() {}

	public MemberInfoVO(int mb_num, int ml_num, int pro_num, String mb_name, String mb_phone, String mb_nickname,
			String mb_about, int mb_auth, String mb_reason, Timestamp mb_regdate) {
		super();
		this.mb_num = mb_num;
		this.ml_num = ml_num;
		this.pro_num = pro_num;
		this.mb_name = mb_name;
		this.mb_phone = mb_phone;
		this.mb_nickname = mb_nickname;
		this.mb_about = mb_about;
		this.mb_auth = mb_auth;
		this.mb_reason = mb_reason;
		this.mb_regdate = mb_regdate;
	}

	public int getMb_num() {
		return mb_num;
	}

	public void setMb_num(int mb_num) {
		this.mb_num = mb_num;
	}

	public int getMl_num() {
		return ml_num;
	}

	public void setMl_num(int ml_num) {
		this.ml_num = ml_num;
	}

	public int getPro_num() {
		return pro_num;
	}

	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}

	public String getMb_name() {
		return mb_name;
	}

	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}

	public String getMb_phone() {
		return mb_phone;
	}

	public void setMb_phone(String mb_phone) {
		this.mb_phone = mb_phone;
	}

	public String getMb_nickname() {
		return mb_nickname;
	}

	public void setMb_nickname(String mb_nickname) {
		this.mb_nickname = mb_nickname;
	}

	public String getMb_about() {
		return mb_about;
	}

	public void setMb_about(String mb_about) {
		this.mb_about = mb_about;
	}

	public int getMb_auth() {
		return mb_auth;
	}

	public void setMb_auth(int mb_auth) {
		this.mb_auth = mb_auth;
	}

	public String getMb_reason() {
		return mb_reason;
	}

	public void setMb_reason(String mb_reason) {
		this.mb_reason = mb_reason;
	}

	public Timestamp getMb_regdate() {
		return mb_regdate;
	}

	public void setMb_regdate(Timestamp mb_regdate) {
		this.mb_regdate = mb_regdate;
	}
}
