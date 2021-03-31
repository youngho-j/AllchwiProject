package com.rebuild.project.vo.onlineclass;

import java.sql.Timestamp;

public class OnlineClassVO {
	private int online_num;
	private int commu_num;
	private String online_title;
	private String online_content;
	private int online_time;
	private String online_file;
	private Object online_thumbnail;
	private Timestamp online_regdate;

	public OnlineClassVO() {}

	public OnlineClassVO(int online_num, int commu_num, String online_title, String online_content, int online_time,
			String online_file, Object online_thumbnail, Timestamp online_regdate) {
		super();
		this.online_num = online_num;
		this.commu_num = commu_num;
		this.online_title = online_title;
		this.online_content = online_content;
		this.online_time = online_time;
		this.online_file = online_file;
		this.online_thumbnail = online_thumbnail;
		this.online_regdate = online_regdate;
	}

	public int getOnline_num() {
		return online_num;
	}

	public void setOnline_num(int online_num) {
		this.online_num = online_num;
	}

	public int getCommu_num() {
		return commu_num;
	}

	public void setCommu_num(int commu_num) {
		this.commu_num = commu_num;
	}

	public String getOnline_title() {
		return online_title;
	}

	public void setOnline_title(String online_title) {
		this.online_title = online_title;
	}

	public String getOnline_content() {
		return online_content;
	}

	public void setOnline_content(String online_content) {
		this.online_content = online_content;
	}

	public int getOnline_time() {
		return online_time;
	}

	public void setOnline_time(int online_time) {
		this.online_time = online_time;
	}

	public String getOnline_file() {
		return online_file;
	}

	public void setOnline_file(String online_file) {
		this.online_file = online_file;
	}

	public Object getOnline_thumbnail() {
		return online_thumbnail;
	}

	public void setOnline_thumbnail(Object online_thumbnail) {
		this.online_thumbnail = online_thumbnail;
	}

	public Timestamp getOnline_regdate() {
		return online_regdate;
	}

	public void setOnline_regdate(Timestamp online_regdate) {
		this.online_regdate = online_regdate;
	}
	
	
	
}
