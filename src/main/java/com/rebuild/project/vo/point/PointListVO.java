package com.rebuild.project.vo.point;

import java.sql.Timestamp;

public class PointListVO {
	private int ml_num;
	private String mb_name;
	private String id;
	private int point_num;
	private int point;
	private String point_name;
	private Timestamp point_regdate;
	private char point_type;
	
	public PointListVO() {}

	public PointListVO(int ml_num, String mb_name, String id, int point_num, int point, String point_name,
			Timestamp point_regdate, char point_type) {
		super();
		this.ml_num = ml_num;
		this.mb_name = mb_name;
		this.id = id;
		this.point_num = point_num;
		this.point = point;
		this.point_name = point_name;
		this.point_regdate = point_regdate;
		this.point_type = point_type;
	}

	public int getMl_num() {
		return ml_num;
	}

	public void setMl_num(int ml_num) {
		this.ml_num = ml_num;
	}

	public String getMb_name() {
		return mb_name;
	}

	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPoint_num() {
		return point_num;
	}

	public void setPoint_num(int point_num) {
		this.point_num = point_num;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getPoint_name() {
		return point_name;
	}

	public void setPoint_name(String point_name) {
		this.point_name = point_name;
	}

	public Timestamp getPoint_regdate() {
		return point_regdate;
	}

	public void setPoint_regdate(Timestamp point_regdate) {
		this.point_regdate = point_regdate;
	}

	public char getPoint_type() {
		return point_type;
	}

	public void setPoint_type(char point_type) {
		this.point_type = point_type;
	}
}
