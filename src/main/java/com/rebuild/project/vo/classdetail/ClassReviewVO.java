package com.rebuild.project.vo.classdetail;

import java.sql.Timestamp;

import com.rebuild.project.vo.login.MemberInfoVO;
import com.rebuild.project.vo.login.ProfileVO;

public class ClassReviewVO {
	private int review_num;
	private int class_num;
	private int ml_num;
	private int pro_num;
	private double tot_avg;
	private int curr_avg;
	private int ready_avg;
	private int kind_avg;
	private int time_avg;
	private int curr_rating;
	private int ready_rating;
	private int kind_rating;
	private int time_rating;
	private String review_content;
	private int review_status;
	private int cnt;
	private String tutor_nickname;
	private ProfileVO pfv;
	private MemberInfoVO miv;
	private Timestamp review_regdate;

	public ClassReviewVO() {
	}

	public ClassReviewVO(int review_num, int class_num, int ml_num, double tot_avg, int curr_avg, int ready_avg,
			int kind_avg, int time_avg, int curr_rating, int ready_rating, int kind_rating, int time_rating,
			String review_content, int review_status, ProfileVO pfv, MemberInfoVO miv, Timestamp review_regdate) {
		super();
		this.review_num = review_num;
		this.class_num = class_num;
		this.ml_num = ml_num;
		this.tot_avg = tot_avg;
		this.curr_avg = curr_avg;
		this.ready_avg = ready_avg;
		this.kind_avg = kind_avg;
		this.time_avg = time_avg;
		this.curr_rating = curr_rating;
		this.ready_rating = ready_rating;
		this.kind_rating = kind_rating;
		this.time_rating = time_rating;
		this.review_content = review_content;
		this.review_status = review_status;
		this.pfv = pfv;
		this.miv = miv;
		this.review_regdate = review_regdate;
	}
	
	public int getPro_num() {
		return pro_num;
	}

	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
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

	public double getTot_avg() {
		return tot_avg;
	}

	public void setTot_avg(double tot_avg) {
		this.tot_avg = tot_avg;
	}

	public int getCurr_avg() {
		return curr_avg;
	}

	public void setCurr_avg(int curr_avg) {
		this.curr_avg = curr_avg;
	}

	public int getReady_avg() {
		return ready_avg;
	}

	public void setReady_avg(int ready_avg) {
		this.ready_avg = ready_avg;
	}

	public int getKind_avg() {
		return kind_avg;
	}

	public void setKind_avg(int kind_avg) {
		this.kind_avg = kind_avg;
	}

	public int getTime_avg() {
		return time_avg;
	}

	public void setTime_avg(int time_avg) {
		this.time_avg = time_avg;
	}

	public int getCurr_rating() {
		return curr_rating;
	}

	public void setCurr_rating(int curr_rating) {
		this.curr_rating = curr_rating;
	}

	public int getReady_rating() {
		return ready_rating;
	}

	public void setReady_rating(int ready_rating) {
		this.ready_rating = ready_rating;
	}

	public int getKind_rating() {
		return kind_rating;
	}

	public void setKind_rating(int kind_rating) {
		this.kind_rating = kind_rating;
	}

	public int getTime_rating() {
		return time_rating;
	}

	public void setTime_rating(int time_rating) {
		this.time_rating = time_rating;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public int getReview_status() {
		return review_status;
	}

	public void setReview_status(int review_status) {
		this.review_status = review_status;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getTutor_nickname() {
		return tutor_nickname;
	}

	public void setTutor_nickname(String tutor_nickname) {
		this.tutor_nickname = tutor_nickname;
	}
	
	public ProfileVO getPfv() {
		return pfv;
	}

	public void setPfv(ProfileVO pfv) {
		this.pfv = pfv;
	}

	public MemberInfoVO getMiv() {
		return miv;
	}

	public void setMiv(MemberInfoVO miv) {
		this.miv = miv;
	}

	public Timestamp getReview_regdate() {
		return review_regdate;
	}

	public void setReview_regdate(Timestamp review_regdate) {
		this.review_regdate = review_regdate;
	};

}
