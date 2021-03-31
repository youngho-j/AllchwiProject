package com.rebuild.project.vo.classdetail;

import java.sql.Timestamp;

import com.rebuild.project.vo.login.MemberInfoVO;
import com.rebuild.project.vo.login.ProfileVO;

public class ClassQnaVO {
	private int qna_num;
	private int class_num;
	private int ml_num;
	private String qna_content;
	private int qna_ref;
	private int qna_lev;
	private int qna_status;
	private int pro_num;
	private String tutor_nickname;
	private ProfileVO pfv;
	private MemberInfoVO miv;
	private Timestamp qna_regdate;
	public ClassQnaVO() {};
	public ClassQnaVO(int qna_num, int class_num, int ml_num, String qna_content, int qna_ref, int qna_lev,
			ProfileVO pfv, MemberInfoVO miv, Timestamp qna_regdate) {
		super();
		this.qna_num = qna_num;
		this.class_num = class_num;
		this.ml_num = ml_num;
		this.qna_content = qna_content;
		this.qna_ref = qna_ref;
		this.qna_lev = qna_lev;
		this.pfv = pfv;
		this.miv = miv;
		this.qna_regdate = qna_regdate;
	}

	public ClassQnaVO(int class_num, int ml_num, String qna_content,int qna_lev) {
		super();
		this.class_num = class_num;
		this.ml_num = ml_num;
		this.qna_content = qna_content;
		this.qna_lev = qna_lev;
	}
	public ClassQnaVO(int qna_num, int class_num, int ml_num, String qna_content, int qna_ref, int qna_lev,
			Timestamp qna_regdate) {
		super();
		this.qna_num = qna_num;
		this.class_num = class_num;
		this.ml_num = ml_num;
		this.qna_content = qna_content;
		this.qna_ref = qna_ref;
		this.qna_lev = qna_lev;
		this.qna_regdate = qna_regdate;
	}
	
	public ClassQnaVO(int qna_num, int class_num, int ml_num, String qna_content, int qna_ref, int qna_lev,
			int qna_status, int pro_num, String tutor_nickname, Timestamp qna_regdate) {
		super();
		this.qna_num = qna_num;
		this.class_num = class_num;
		this.ml_num = ml_num;
		this.qna_content = qna_content;
		this.qna_ref = qna_ref;
		this.qna_lev = qna_lev;
		this.qna_status = qna_status;
		this.pro_num = pro_num;
		this.tutor_nickname = tutor_nickname;
		this.qna_regdate = qna_regdate;
	}
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public int getClass_num() {
		return class_num;
	}
	public void setClass_num(int class_num) {
		this.class_num = class_num;
	}
	public int getMl_num() {
		return ml_num;
	}
	public void setMl_num(int ml_num) {
		this.ml_num = ml_num;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public int getQna_ref() {
		return qna_ref;
	}
	public void setQna_ref(int qna_ref) {
		this.qna_ref = qna_ref;
	}
	public int getQna_lev() {
		return qna_lev;
	}
	public void setQna_lev(int qna_lev) {
		this.qna_lev = qna_lev;
	}
	public ProfileVO getpfv() {
		return pfv;
	}
	public void setpfv(ProfileVO pfv) {
		this.pfv = pfv;
	}
	public MemberInfoVO getMiv() {
		return miv;
	}
	public void setMiv(MemberInfoVO miv) {
		this.miv = miv;
	}
	public Timestamp getQna_regdate() {
		return qna_regdate;
	}
	public void setQna_regdate(Timestamp qna_regdate) {
		this.qna_regdate = qna_regdate;
	}
	public int getQna_status() {
		return qna_status;
	}
	public void setQna_status(int qna_status) {
		this.qna_status = qna_status;
	}
	public String getTutor_nickname() {
		return tutor_nickname;
	}
	public void setTutor_nickname(String tutor_nickname) {
		this.tutor_nickname = tutor_nickname;
	}
	public int getPro_num() {
		return pro_num;
	}
	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}
	
}
