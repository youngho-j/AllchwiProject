package com.rebuild.project.vo.location;

public class SmallLocationVO {
	private int sloc_num;
	private int bloc_num;
	private String sloc_name;
	
	public SmallLocationVO() {}

	public SmallLocationVO(int sloc_num, int bloc_num, String sloc_name) {
		super();
		this.sloc_num = sloc_num;
		this.bloc_num = bloc_num;
		this.sloc_name = sloc_name;
	}

	public int getSloc_num() {
		return sloc_num;
	}

	public void setSloc_num(int sloc_num) {
		this.sloc_num = sloc_num;
	}

	public int getBloc_num() {
		return bloc_num;
	}

	public void setBloc_num(int bloc_num) {
		this.bloc_num = bloc_num;
	}

	public String getSloc_name() {
		return sloc_name;
	}

	public void setSloc_name(String sloc_name) {
		this.sloc_name = sloc_name;
	}
}
