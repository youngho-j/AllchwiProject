package com.rebuild.project.vo.classdetail;

import java.util.List;

import com.rebuild.project.vo.classopen.CertificateVO;
import com.rebuild.project.vo.classopen.ClassInfoVO;
import com.rebuild.project.vo.classopen.CurriculumVO;


public class ClassDetailVO {
	private int class_num;
	private int ml_num;
	private int sloc_num;
	private int pro_num;
	private String tutor_nickname;
	private String tutor_phone;
	private String class_address;
	private int class_form;
	private int class_max;
	private int class_min;
	private String class_title;
	private int class_price;
	private int class_hour;
	private int class_count;
	private String tutor_about;
	private String class_about;
	private String class_target;
	private String sloc_name;
	private String bloc_name;
	private int bcategory_num;
	private int scategory_num;
	private List<ClassInfoVO> coverList;
	private List<CertificateVO> certList;
	private List<CurriculumVO> curriList;
	//추가
	private String class_date;
	private int cover_num;
	
	public ClassDetailVO() {}
	public ClassDetailVO(int class_num, int ml_num, int sloc_num, int pro_num, String tutor_nickname,
			String tutor_phone, String class_address, int class_form, int class_max, int class_min, String class_title,
			int class_price, int class_hour, int class_count, String tutor_about, String class_about,
			String class_target, String sloc_name, String bloc_name, int bcategory_num, int scategory_num,
			List<ClassInfoVO> coverList, List<CertificateVO> certList, List<CurriculumVO> curriList) {
		super();
		this.class_num = class_num;
		this.ml_num = ml_num;
		this.sloc_num = sloc_num;
		this.pro_num = pro_num;
		this.tutor_nickname = tutor_nickname;
		this.tutor_phone = tutor_phone;
		this.class_address = class_address;
		this.class_form = class_form;
		this.class_max = class_max;
		this.class_min = class_min;
		this.class_title = class_title;
		this.class_price = class_price;
		this.class_hour = class_hour;
		this.class_count = class_count;
		this.tutor_about = tutor_about;
		this.class_about = class_about;
		this.class_target = class_target;
		this.sloc_name = sloc_name;
		this.bloc_name = bloc_name;
		this.bcategory_num = bcategory_num;
		this.scategory_num = scategory_num;
		this.coverList = coverList;
		this.certList = certList;
		this.curriList = curriList;
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
	public int getSloc_num() {
		return sloc_num;
	}
	public void setSloc_num(int sloc_num) {
		this.sloc_num = sloc_num;
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
	public String getTutor_phone() {
		return tutor_phone;
	}
	public void setTutor_phone(String tutor_phone) {
		this.tutor_phone = tutor_phone;
	}
	public String getClass_address() {
		return class_address;
	}
	public void setClass_address(String class_address) {
		this.class_address = class_address;
	}
	public int getClass_form() {
		return class_form;
	}
	public void setClass_form(int class_form) {
		this.class_form = class_form;
	}
	public int getClass_max() {
		return class_max;
	}
	public void setClass_max(int class_max) {
		this.class_max = class_max;
	}
	public int getClass_min() {
		return class_min;
	}
	public void setClass_min(int class_min) {
		this.class_min = class_min;
	}
	public String getClass_title() {
		return class_title;
	}
	public void setClass_title(String class_title) {
		this.class_title = class_title;
	}
	public int getClass_price() {
		return class_price;
	}
	public void setClass_price(int class_price) {
		this.class_price = class_price;
	}
	public int getClass_hour() {
		return class_hour;
	}
	public void setClass_hour(int class_hour) {
		this.class_hour = class_hour;
	}
	public int getClass_count() {
		return class_count;
	}
	public void setClass_count(int class_count) {
		this.class_count = class_count;
	}
	public String getTutor_about() {
		return tutor_about;
	}
	public void setTutor_about(String tutor_about) {
		this.tutor_about = tutor_about;
	}
	public String getClass_about() {
		return class_about;
	}
	public void setClass_about(String class_about) {
		this.class_about = class_about;
	}
	public String getClass_target() {
		return class_target;
	}
	public void setClass_target(String class_target) {
		this.class_target = class_target;
	}
	public String getSloc_name() {
		return sloc_name;
	}
	public void setSloc_name(String sloc_name) {
		this.sloc_name = sloc_name;
	}
	public String getBloc_name() {
		return bloc_name;
	}
	public void setBloc_name(String bloc_name) {
		this.bloc_name = bloc_name;
	}
	public int getBcategory_num() {
		return bcategory_num;
	}
	public void setBcategory_num(int bcategory_num) {
		this.bcategory_num = bcategory_num;
	}
	public int getScategory_num() {
		return scategory_num;
	}
	public void setScategory_num(int scategory_num) {
		this.scategory_num = scategory_num;
	}
	public List<ClassInfoVO> getCoverList() {
		return coverList;
	}
	public void setCoverList(List<ClassInfoVO> coverList) {
		this.coverList = coverList;
	}
	public List<CertificateVO> getCertList() {
		return certList;
	}
	public void setCertList(List<CertificateVO> certList) {
		this.certList = certList;
	}
	public List<CurriculumVO> getCurriList() {
		return curriList;
	}
	public void setCurriList(List<CurriculumVO> curriList) {
		this.curriList = curriList;
	}
	public String getClass_date() {
		return class_date;
	}
	public void setClass_date(String class_date) {
		this.class_date = class_date;
	}
	public int getCover_num() {
		return cover_num;
	}
	public void setCover_num(int cover_num) {
		this.cover_num = cover_num;
	}
	
}