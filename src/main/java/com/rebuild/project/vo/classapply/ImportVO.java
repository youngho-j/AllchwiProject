package com.rebuild.project.vo.classapply;

public class ImportVO {
	private String init;
	private String pg;
	private String pay_method;
	private String name;
	private String bemail;
	private String bname;
	private String btel;
	private String baddr;
	private String bpostcode;
	
	public ImportVO() {}
	
	public ImportVO(String init, String pg, String pay_method, String name, String bemail, String bname, String btel,
			String baddr, String bpostcode) {
		super();
		this.init = init;
		this.pg = pg;
		this.pay_method = pay_method;
		this.name = name;
		this.bemail = bemail;
		this.bname = bname;
		this.btel = btel;
		this.baddr = baddr;
		this.bpostcode = bpostcode;
	}

	public String getInit() {
		return init;
	}

	public void setInit(String init) {
		this.init = init;
	}

	public String getPg() {
		return pg;
	}

	public void setPg(String pg) {
		this.pg = pg;
	}

	public String getPay_method() {
		return pay_method;
	}

	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBemail() {
		return bemail;
	}

	public void setBemail(String bemail) {
		this.bemail = bemail;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBtel() {
		return btel;
	}

	public void setBtel(String btel) {
		this.btel = btel;
	}

	public String getBaddr() {
		return baddr;
	}

	public void setBaddr(String baddr) {
		this.baddr = baddr;
	}

	public String getBpostcode() {
		return bpostcode;
	}

	public void setBpostcode(String bpostcode) {
		this.bpostcode = bpostcode;
	}
}
