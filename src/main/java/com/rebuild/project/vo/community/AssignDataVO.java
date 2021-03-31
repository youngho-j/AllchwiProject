package com.rebuild.project.vo.community;

import java.sql.Timestamp;

public class AssignDataVO {
	private int assigndata_num;
	private int sub_num;
	private String assign_orgFilename;
	private String assign_saveFilename;
	private Timestamp assigndata_regdate;
	private long assigndata_size;
	
	public AssignDataVO() {}

	
	


	public AssignDataVO(int assigndata_num, int sub_num, String assign_orgFilename, String assign_saveFilename,
			Timestamp assigndata_regdate, long assigndata_size) {
		super();
		this.assigndata_num = assigndata_num;
		this.sub_num = sub_num;
		this.assign_orgFilename = assign_orgFilename;
		this.assign_saveFilename = assign_saveFilename;
		this.assigndata_regdate = assigndata_regdate;
		this.assigndata_size = assigndata_size;
	}





	public int getAssigndata_num() {
		return assigndata_num;
	}

	public void setAssigndata_num(int assigndata_num) {
		this.assigndata_num = assigndata_num;
	}

	public int getSub_num() {
		return sub_num;
	}

	public void setSub_num(int sub_num) {
		this.sub_num = sub_num;
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





	public long getAssigndata_size() {
		return assigndata_size;
	}





	public void setAssigndata_size(long assigndata_size) {
		this.assigndata_size = assigndata_size;
	}
	
	
	
}
