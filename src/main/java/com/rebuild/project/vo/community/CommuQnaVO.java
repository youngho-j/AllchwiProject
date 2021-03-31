package com.rebuild.project.vo.community;

import java.sql.Timestamp;

import com.rebuild.project.vo.login.MemberInfoVO;
import com.rebuild.project.vo.login.ProfileVO;

public class CommuQnaVO {
	private int commu_num;
	private int qna_num;
	private int ml_num;
	private int qna_ref;
	private int qna_lev;
	private String qna_content;
	private Timestamp qna_regdate;
	private int pro_num;
	private String tutor_nickname;
	private MemberInfoVO miv;
	private ProfileVO pfv;
	public CommuQnaVO() {}
	
	public CommuQnaVO(int commu_num, int qna_num, int ml_num, int qna_ref, int qna_lev, String qna_content,
			Timestamp qna_regdate, MemberInfoVO miv, ProfileVO pfv) {
		super();
		this.commu_num = commu_num;
		this.qna_num = qna_num;
		this.ml_num = ml_num;
		this.qna_ref = qna_ref;
		this.qna_lev = qna_lev;
		this.qna_content = qna_content;
		this.qna_regdate = qna_regdate;
		this.miv = miv;
		this.pfv = pfv;
	}

	public int getCommu_num() {
		return commu_num;
	}
	public void setCommu_num(int commu_num) {
		this.commu_num = commu_num;
	}
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public int getMl_num() {
		return ml_num;
	}
	public void setMl_num(int ml_num) {
		this.ml_num = ml_num;
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
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public Timestamp getQna_regdate() {
		return qna_regdate;
	}
	public void setQna_regdate(Timestamp qna_regdate) {
		this.qna_regdate = qna_regdate;
	}
	public MemberInfoVO getMiv() {
		return miv;
	}
	public void setMiv(MemberInfoVO miv) {
		this.miv = miv;
	}
	public ProfileVO getPfv() {
		return pfv;
	}
	public void setPfv(ProfileVO pfv) {
		this.pfv = pfv;
	}

	public int getPro_num() {
		return pro_num;
	}

	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}

	public String getTutor_nickname() {
		return tutor_nickname;
	}

	public void setTutor_nickname(String tutor_nickname) {
		this.tutor_nickname = tutor_nickname;
	}
	


}
