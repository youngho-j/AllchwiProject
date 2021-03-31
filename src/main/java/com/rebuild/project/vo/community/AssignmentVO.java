package com.rebuild.project.vo.community;

import java.sql.Timestamp;

public class AssignmentVO {
	private int assign_num;
	private int commu_num;
	private String assign_title;
	private String assign_content;
	private Timestamp assign_regdate;
	
	public AssignmentVO() {}

	public AssignmentVO(int assign_num, int commu_num, String assign_title, String assign_content,
			Timestamp assign_regdate) {
		super();
		this.assign_num = assign_num;
		this.commu_num = commu_num;
		this.assign_title = assign_title;
		this.assign_content = assign_content;
		this.assign_regdate = assign_regdate;
	}

	public int getAssign_num() {
		return assign_num;
	}

	public void setAssign_num(int assign_num) {
		this.assign_num = assign_num;
	}

	public int getCommu_num() {
		return commu_num;
	}

	public void setCommu_num(int commu_num) {
		this.commu_num = commu_num;
	}

	public String getAssign_title() {
		return assign_title;
	}

	public void setAssign_title(String assign_title) {
		this.assign_title = assign_title;
	}

	public String getAssign_content() {
		return assign_content;
	}

	public void setAssign_content(String assign_content) {
		this.assign_content = assign_content;
	}

	public Timestamp getAssign_regdate() {
		return assign_regdate;
	}

	public void setAssign_regdate(Timestamp assign_regdate) {
		this.assign_regdate = assign_regdate;
	}
	
	
}
