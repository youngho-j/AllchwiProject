package com.rebuild.project.vo.community;

import java.sql.Timestamp;

public class ArchiveVO {
	private int room_num;
	private int commu_num;
	private String room_title;
	private String room_content;
	private Timestamp room_regdate;
	private int room_view;
	private int horsehead;
	private String org_filename;
	private String save_filename;
	private long filesize;
	
	public ArchiveVO () {}

	public ArchiveVO(int room_num, int commu_num, String room_title, String room_content, Timestamp room_regdate,
			int room_view, int horsehead, String org_filename, String save_filename, long filesize) {
		super();
		this.room_num = room_num;
		this.commu_num = commu_num;
		this.room_title = room_title;
		this.room_content = room_content;
		this.room_regdate = room_regdate;
		this.room_view = room_view;
		this.horsehead = horsehead;
		this.org_filename = org_filename;
		this.save_filename = save_filename;
		this.filesize = filesize;
	}

	public int getRoom_num() {
		return room_num;
	}

	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}

	public int getCommu_num() {
		return commu_num;
	}

	public void setCommu_num(int commu_num) {
		this.commu_num = commu_num;
	}

	public String getRoom_title() {
		return room_title;
	}

	public void setRoom_title(String room_title) {
		this.room_title = room_title;
	}

	public String getRoom_content() {
		return room_content;
	}

	public void setRoom_content(String room_content) {
		this.room_content = room_content;
	}

	public Timestamp getRoom_regdate() {
		return room_regdate;
	}

	public void setRoom_regdate(Timestamp room_regdate) {
		this.room_regdate = room_regdate;
	}

	public int getRoom_view() {
		return room_view;
	}

	public void setRoom_view(int room_view) {
		this.room_view = room_view;
	}

	public int getHorsehead() {
		return horsehead;
	}

	public void setHorsehead(int horsehead) {
		this.horsehead = horsehead;
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
