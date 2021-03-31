package com.rebuild.project.vo.location;

public class BigLocationVO {
	private int bloc_num;
	private String bloc_name;
	
	public BigLocationVO() {}

	public BigLocationVO(int bloc_num, String bloc_name) {
		super();
		this.bloc_num = bloc_num;
		this.bloc_name = bloc_name;
	}

	public int getBloc_num() {
		return bloc_num;
	}

	public void setBloc_num(int bloc_num) {
		this.bloc_num = bloc_num;
	}

	public String getBloc_name() {
		return bloc_name;
	}

	public void setBloc_name(String bloc_name) {
		this.bloc_name = bloc_name;
	}
	
	
}
