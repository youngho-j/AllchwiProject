package com.rebuild.project.vo.admin;

public class CertiVO {
	private String certif_name;
	private int certif_num;
	
	public CertiVO() {}

	public CertiVO(String certif_name, int certif_num) {
		super();
		this.certif_name = certif_name;
		this.certif_num = certif_num;
	}

	public String getCertif_name() {
		return certif_name;
	}

	public void setCertif_name(String certif_name) {
		this.certif_name = certif_name;
	}

	public int getCertif_num() {
		return certif_num;
	}

	public void setCertif_num(int certif_num) {
		this.certif_num = certif_num;
	}

	
	
}
