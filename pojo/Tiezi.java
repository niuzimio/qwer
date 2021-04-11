package com.web.teacher.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Tiezi {
  	public int getTid() {
		return Tid;
	}
	public void setTid(int tid) {
		Tid = tid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getLnum() {
		return lnum;
	}
	public void setLnum(Integer lnum) {
		this.lnum = lnum;
	}
	  private int Tid;
  	  private String uname;
	  private String title;//鏍囬
      private String content;//鍐呭
      private String section;//鏉垮潡
      @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	  @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
      private Date modifyDate;//鏈�鍚庝慨鏀规棩鏈�
      private Integer lnum;//鐐硅禐鏁�
      private Integer jsign;//鍔犵簿鏍囧織浣�
      public Integer getJsign() {
		return jsign;
	}
	public void setJsign(Integer jsign) {
		this.jsign = jsign;
	}
	public String getJsignStr() {
			if(jsign==null)
			{
				return "";
			}
			if(jsign==1) {
				return "精华";
			}
			else {
				return "普通";
			}
	}
}
