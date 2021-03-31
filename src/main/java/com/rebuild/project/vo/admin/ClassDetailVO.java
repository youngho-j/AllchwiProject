package com.rebuild.project.vo.admin;

public class ClassDetailVO {
	private String class_title;
	private int class_form;
	private int class_hour;
	private int class_min;
	private int class_max;
	private int class_price;
	private String tutor_about;
	private String class_about;
	private String class_target;
	private String tutor_nickname;
	private String tutor_phone;
	private String class_address;
	private String sloc_name;
	private String bloc_name;
	private int pro_num;
	
	public ClassDetailVO() {}

	public ClassDetailVO(String class_title, int class_form, int class_hour, int class_min, int class_max,
			int class_price, String tutor_about, String class_about, String class_target, String tutor_nickname,
			String tutor_phone, String class_address, String sloc_name, String bloc_name, int pro_num) {
		super();
		this.class_title = class_title;
		this.class_form = class_form;
		this.class_hour = class_hour;
		this.class_min = class_min;
		this.class_max = class_max;
		this.class_price = class_price;
		this.tutor_about = tutor_about;
		this.class_about = class_about;
		this.class_target = class_target;
		this.tutor_nickname = tutor_nickname;
		this.tutor_phone = tutor_phone;
		this.class_address = class_address;
		this.sloc_name = sloc_name;
		this.bloc_name = bloc_name;
		this.pro_num = pro_num;
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

	public int getClass_hour() {
		return class_hour;
	}

	public void setClass_hour(int class_hour) {
		this.class_hour = class_hour;
	}

	public int getClass_min() {
		return class_min;
	}

	public void setClass_min(int class_min) {
		this.class_min = class_min;
	}

	public int getClass_max() {
		return class_max;
	}

	public void setClass_max(int class_max) {
		this.class_max = class_max;
	}

	public int getClass_price() {
		return class_price;
	}

	public void setClass_price(int class_price) {
		this.class_price = class_price;
	}

	public String getTutor_about() {
		return tutor_about;
	}

	public void setTutor_about(String tutor_about) {
		this.tutor_about = tutor_about;
	}

	public String getClass_about() {
		return class_about;
	}

	public void setClass_about(String class_about) {
		this.class_about = class_about;
	}

	public String getClass_target() {
		return class_target;
	}

	public void setClass_target(String class_target) {
		this.class_target = class_target;
	}

	public String getTutor_nickname() {
		return tutor_nickname;
	}

	public void setTutor_nickname(String tutor_nickname) {
		this.tutor_nickname = tutor_nickname;
	}

	public String getTutor_phone() {
		return tutor_phone;
	}

	public void setTutor_phone(String tutor_phone) {
		this.tutor_phone = tutor_phone;
	}

	public String getClass_address() {
		return class_address;
	}

	public void setClass_address(String class_address) {
		this.class_address = class_address;
	}

	public String getSloc_name() {
		return sloc_name;
	}

	public void setSloc_name(String sloc_name) {
		this.sloc_name = sloc_name;
	}

	public String getBloc_name() {
		return bloc_name;
	}

	public void setBloc_name(String bloc_name) {
		this.bloc_name = bloc_name;
	}

	public int getPro_num() {
		return pro_num;
	}

	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}

	
	
	
	
	
}
