package com.rebuild.project.vo.community;

import java.sql.Timestamp;

public class NoticeVO {
	private int notice_num;
	private int commu_num;
	private int class_num;
	private String notice_title;
	private String notice_content;
	private int notice_view;
	private Timestamp notice_regdate;
	
	public NoticeVO() {}

	public NoticeVO(int notice_num, int commu_num, int class_num, String notice_title, String notice_content,
			int notice_view, Timestamp notice_regdate) {
		super();
		this.notice_num = notice_num;
		this.commu_num = commu_num;
		this.class_num = class_num;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_view = notice_view;
		this.notice_regdate = notice_regdate;
	}

	public int getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
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

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public int getNotice_view() {
		return notice_view;
	}

	public void setNotice_view(int notice_view) {
		this.notice_view = notice_view;
	}

	public Timestamp getNotice_regdate() {
		return notice_regdate;
	}

	public void setNotice_regdate(Timestamp notice_regdate) {
		this.notice_regdate = notice_regdate;
	}
}
