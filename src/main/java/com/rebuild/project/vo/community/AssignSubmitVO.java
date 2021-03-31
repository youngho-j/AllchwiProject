package com.rebuild.project.vo.community;

import java.sql.Timestamp;

public class AssignSubmitVO {
	private int sub_num;
	private int assign_num;
	private int ml_num;
	private String sub_content;
	private Timestamp sub_regdate;
	//data
	private int assigndata_num;
	private String assign_orgFilename;
	private String assign_saveFilename;
	private Timestamp assigndata_regdate;
	//pro_num
	private int pro_num;
	private String mb_name;
	
	public String getMb_name() {
		return mb_name;
	}

	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}

	public int getPro_num() {
		return pro_num;
	}

	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}
	//
	public AssignSubmitVO() {}

	public AssignSubmitVO(int sub_num, int assign_num, int ml_num, String sub_content, Timestamp sub_regdate) {
		super();
		this.sub_num = sub_num;
		this.assign_num = assign_num;
		this.ml_num = ml_num;
		this.sub_content = sub_content;
		this.sub_regdate = sub_regdate;
	}

	public int getSub_num() {
		return sub_num;
	}

	public void setSub_num(int sub_num) {
		this.sub_num = sub_num;
	}

	public int getAssign_num() {
		return assign_num;
	}

	public void setAssign_num(int assign_num) {
		this.assign_num = assign_num;
	}

	public int getMl_num() {
		return ml_num;
	}

	public void setMl_num(int ml_num) {
		this.ml_num = ml_num;
	}

	public String getSub_content() {
		return sub_content;
	}

	public void setSub_content(String sub_content) {
		this.sub_content = sub_content;
	}

	public Timestamp getSub_regdate() {
		return sub_regdate;
	}

	public void setSub_regdate(Timestamp sub_regdate) {
		this.sub_regdate = sub_regdate;
	}

	public int getAssigndata_num() {
		return assigndata_num;
	}

	public void setAssigndata_num(int assigndata_num) {
		this.assigndata_num = assigndata_num;
	}

	public String getAssign_orgFilename() {
		return assign_orgFilename;
	}

	public void setAssign_orgFilename(String assign_orgFilename) {
		this.assign_orgFilename = assign_orgFilename;
	}

	public String getAssign_saveFilename() {
		return assign_saveFilename;
	}

	public void setAssign_saveFilename(String assign_saveFilename) {
		this.assign_saveFilename = assign_saveFilename;
	}

	public Timestamp getAssigndata_regdate() {
		return assigndata_regdate;
	}

	public void setAssigndata_regdate(Timestamp assigndata_regdate) {
		this.assigndata_regdate = assigndata_regdate;
	}
	
	
	
}
