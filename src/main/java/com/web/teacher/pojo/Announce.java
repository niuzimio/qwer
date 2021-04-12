package com.web.teacher.pojo;

import java.security.Timestamp;
import java.util.Date;

public class Announce {
	private int aid;
	private String anume;
	private String acontent;
	private Date atime;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public String getAnume() {
		return anume;
	}
	public void setAnume(String anume) {
		this.anume = anume;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public Date getAtime() {
		return atime;
	}
	public void setAtime(Timestamp atime) {
		this.atime = atime;
	}
	
}
