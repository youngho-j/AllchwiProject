package com.rebuild.project.vo.admin;

public class PicsListVO {
	private int picNum;
	private String org_filename;
	private String save_filename;
	private long filesize;
	
	public PicsListVO() {}

	public PicsListVO(int picNum, String org_filename, String save_filename, long filesize) {
		super();
		this.picNum = picNum;
		this.org_filename = org_filename;
		this.save_filename = save_filename;
		this.filesize = filesize;
	}

	public int getPicNum() {
		return picNum;
	}

	public void setPicNum(int picNum) {
		this.picNum = picNum;
	}

	public String getOrg_filename() {
		return org_filename;
	}

	public void setOrg_filename(String org_filename) {
		this.org_filename = org_filename;
	}

	public String getSave_filename() {
		return save_filename;
	}

	public void setSave_filename(String save_filename) {
		this.save_filename = save_filename;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	
}
