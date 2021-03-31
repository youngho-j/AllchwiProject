package com.rebuild.project.vo.admin;

public class ConfirmClassVO {
	private int class_num;
	private String class_title;
	private int class_auth;
	private String class_address;
	private int cover_num;
	private int people;
	private int wish_count;
	private String tutor_nickname;
	private String id;
	
	public ConfirmClassVO() {}

	public ConfirmClassVO(int class_num, String class_title, int class_auth, String class_address, int cover_num,
			int people, int wish_count, String tutor_nickname, String id) {
		super();
		this.class_num = class_num;
		this.class_title = class_title;
		this.class_auth = class_auth;
		this.class_address = class_address;
		this.cover_num = cover_num;
		this.people = people;
		this.wish_count = wish_count;
		this.tutor_nickname = tutor_nickname;
		this.id = id;
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

	public int getClass_auth() {
		return class_auth;
	}

	public void setClass_auth(int class_auth) {
		this.class_auth = class_auth;
	}

	public String getClass_address() {
		return class_address;
	}

	public void setClass_address(String class_address) {
		this.class_address = class_address;
	}

	public int getCover_num() {
		return cover_num;
	}

	public void setCover_num(int cover_num) {
		this.cover_num = cover_num;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public int getWish_count() {
		return wish_count;
	}

	public void setWish_count(int wish_count) {
		this.wish_count = wish_count;
	}

	public String getTutor_nickname() {
		return tutor_nickname;
	}

	public void setTutor_nickname(String tutor_nickname) {
		this.tutor_nickname = tutor_nickname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
}
