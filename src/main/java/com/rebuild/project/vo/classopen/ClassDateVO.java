package com.rebuild.project.vo.classopen;

import java.sql.Timestamp;
import java.util.List;

public class ClassDateVO {
	private int date_num;
	private int class_num;
	private Timestamp class_date;
	private String class_startTime;
	private String class_endTime;
	private String class_comment;
	private String class_msg;
	private int class_month;
	private int time_ref;
	private int time_cnt;
	private Timestamp date_regdate;
	private String class_title; // 추가 (class_info)
	private int class_price; // 추가 (class_info)
	private int class_hour; // 추가 (class_info)
	private int class_count; // 추가 (class_info)
	
	private List<ClassDateVO> list;
	
	public ClassDateVO() {}

	public ClassDateVO(int date_num, int class_num, Timestamp class_date, String class_startTime, String class_endTime,
			String class_comment, String class_msg, int class_month, int time_ref, int time_cnt,
			Timestamp date_regdate) {
		super();
		this.date_num = date_num;
		this.class_num = class_num;
		this.class_date = class_date;
		this.class_startTime = class_startTime;
		this.class_endTime = class_endTime;
		this.class_comment = class_comment;
		this.class_msg = class_msg;
		this.class_month = class_month;
		this.time_ref = time_ref;
		this.time_cnt = time_cnt;
		this.date_regdate = date_regdate;
	}

	public int getDate_num() {
		return date_num;
	}

	public void setDate_num(int date_num) {
		this.date_num = date_num;
	}

	public int getClass_num() {
		return class_num;
	}

	public void setClass_num(int class_num) {
		this.class_num = class_num;
	}

	public Timestamp getClass_date() {
		return class_date;
	}

	public void setClass_date(Timestamp class_date) {
		this.class_date = class_date;
	}

	public String getClass_startTime() {
		return class_startTime;
	}

	public void setClass_startTime(String class_startTime) {
		this.class_startTime = class_startTime;
	}

	public String getClass_endTime() {
		return class_endTime;
	}

	public void setClass_endTime(String class_endTime) {
		this.class_endTime = class_endTime;
	}

	public String getClass_comment() {
		return class_comment;
	}

	public void setClass_comment(String class_comment) {
		this.class_comment = class_comment;
	}

	public String getClass_msg() {
		return class_msg;
	}

	public void setClass_msg(String class_msg) {
		this.class_msg = class_msg;
	}

	public int getClass_month() {
		return class_month;
	}

	public void setClass_month(int class_month) {
		this.class_month = class_month;
	}

	public int getTime_ref() {
		return time_ref;
	}

	public void setTime_ref(int time_ref) {
		this.time_ref = time_ref;
	}

	public int getTime_cnt() {
		return time_cnt;
	}

	public void setTime_cnt(int time_cnt) {
		this.time_cnt = time_cnt;
	}

	public Timestamp getDate_regdate() {
		return date_regdate;
	}

	public void setDate_regdate(Timestamp date_regdate) {
		this.date_regdate = date_regdate;
	}

	// 추가 (class_info)
	
	public String getClass_title() {
		return class_title;
	}

	public void setClass_title(String class_title) {
		this.class_title = class_title;
	}

	public int getClass_price() {
		return class_price;
	}

	public void setClass_price(int class_price) {
		this.class_price = class_price;
	}

	public int getClass_hour() {
		return class_hour;
	}

	public void setClass_hour(int class_hour) {
		this.class_hour = class_hour;
	}

	public int getClass_count() {
		return class_count;
	}

	public void setClass_count(int class_count) {
		this.class_count = class_count;
	}

	public List<ClassDateVO> getList() {
		return list;
	}

	public void setList(List<ClassDateVO> list) {
		this.list = list;
	}
	
	
	
}
