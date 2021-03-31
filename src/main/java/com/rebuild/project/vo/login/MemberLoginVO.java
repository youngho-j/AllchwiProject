package com.rebuild.project.vo.login;

import java.sql.Timestamp;

public class MemberLoginVO {
	private int ml_num;
	private String id;
	private String pwd;
	private int tutor_auth;
	private int login_auth;
	private Timestamp ml_regdate;
	private char email_auth;
	//a 카카오 유저인지 아닌지 확인 일반 유저 "n", 카카오 유저 - 카카오 유저 고유 아이디
	private String kakaoUser;
	
	public MemberLoginVO() {}

	public MemberLoginVO(int ml_num, String id, String pwd, int tutor_auth, int login_auth, Timestamp ml_regdate,
			char email_auth, String kakaoUser) {
		super();
		this.ml_num = ml_num;
		this.id = id;
		this.pwd = pwd;
		this.tutor_auth = tutor_auth;
		this.login_auth = login_auth;
		this.ml_regdate = ml_regdate;
		this.email_auth = email_auth;
		this.kakaoUser = kakaoUser;
	}

	public int getMl_num() {
		return ml_num;
	}

	public void setMl_num(int ml_num) {
		this.ml_num = ml_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getTutor_auth() {
		return tutor_auth;
	}

	public void setTutor_auth(int tutor_auth) {
		this.tutor_auth = tutor_auth;
	}

	public int getLogin_auth() {
		return login_auth;
	}

	public void setLogin_auth(int login_auth) {
		this.login_auth = login_auth;
	}

	public Timestamp getMl_regdate() {
		return ml_regdate;
	}

	public void setMl_regdate(Timestamp ml_regdate) {
		this.ml_regdate = ml_regdate;
	}

	public char getEmail_auth() {
		return email_auth;
	}

	public void setEmail_auth(char email_auth) {
		this.email_auth = email_auth;
	}

	public String getKakaoUser() {
		return kakaoUser;
	}

	public void setKakaoUser(String kakaoUser) {
		this.kakaoUser = kakaoUser;
	}
}
