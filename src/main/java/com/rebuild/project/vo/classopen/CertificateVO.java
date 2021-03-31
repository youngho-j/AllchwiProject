package com.rebuild.project.vo.classopen;

import java.sql.Timestamp;

public class CertificateVO {
	private int certif_num; // 자격증 번호
	private int class_num; // 튜터번호
	private String certif_filename; //파일저장이름
	private Object certif_file; //파일 Blob
	private String certif_name; //자격증명
	private Timestamp certif_regdate; //업로드일
	
	
	public CertificateVO () {}


	public CertificateVO(int certif_num, int class_num, String certif_filename, Object certif_file, String certif_name,
			Timestamp certif_regdate) {
		super();
		this.certif_num = certif_num;
		this.class_num = class_num;
		this.certif_filename = certif_filename;
		this.certif_file = certif_file;
		this.certif_name = certif_name;
		this.certif_regdate = certif_regdate;
	}


	public int getCertif_num() {
		return certif_num;
	}


	public void setCertif_num(int certif_num) {
		this.certif_num = certif_num;
	}


	public int getClass_num() {
		return class_num;
	}


	public void setClass_num(int class_num) {
		this.class_num = class_num;
	}


	public String getCertif_filename() {
		return certif_filename;
	}


	public void setCertif_filename(String certif_filename) {
		this.certif_filename = certif_filename;
	}


	public Object getCertif_file() {
		return certif_file;
	}


	public void setCertif_file(Object certif_file) {
		this.certif_file = certif_file;
	}


	public String getCertif_name() {
		return certif_name;
	}


	public void setCertif_name(String certif_name) {
		this.certif_name = certif_name;
	}


	public Timestamp getCertif_regdate() {
		return certif_regdate;
	}


	public void setCertif_regdate(Timestamp certif_regdate) {
		this.certif_regdate = certif_regdate;
	}

	
}
