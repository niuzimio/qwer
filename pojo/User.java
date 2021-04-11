package com.web.teacher.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {
		public static final int STATUS_DISABLE = 0;		//绂佺敤鐘舵��
		public static final int STATUS_ABLE = 1;		//姝ｅ父鐘舵��
		private int uid;  //涓婚敭  鐢ㄦ埛缂栧彿
		private String uname; //鐢ㄦ埛鍚�
		private String password; //瀵嗙爜
		private Integer flag;  	//鐢ㄦ埛鏉冮檺
		private Integer ukey;       //璐﹀彿鐘舵��
		private String tel;       //鐢佃瘽
		private String sex;    //鎬у埆
		private String image;  //澶村儚
		@DateTimeFormat(pattern="yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
		private Date birth; //鐢熸棩
		private String signature;    // 绛惧悕
		private Integer unum;       //鍏虫敞鏁�
		private Integer tnum;       //鏀惰棌甯栧瓙鏁�
		private Integer fnum;       //绮変笣鏁�
		private Integer snum; //收藏贴数
		public Integer getSnum() {
			return snum;
		}
		public void setSnum(Integer snum) {
			this.snum = snum;
		}
		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Integer getFlag() {
			return flag;
		}
		public void setFlag(Integer flag) {
			this.flag = flag;
		}
		public Integer getUkey() {
			return ukey;
		}
		public void setUkey(Integer ukey) {
			this.ukey = ukey;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public Date getBirth() {
			return birth;
		}
		public void setBirth(Date birth) {
			this.birth = birth;
		}
		public String getSignature() {
			return signature;
		}
		public void setSignature(String signature) {
			this.signature = signature;
		}
		public Integer getUnum() {
			return unum;
		}
		public void setUnum(Integer unum) {
			this.unum = unum;
		}
		public Integer getTnum() {
			return tnum;
		}
		public void setTnum(Integer tnum) {
			this.tnum = tnum;
		}
		public Integer getFnum() {
			return fnum;
		}
		public void setFnum(Integer fnum) {
			this.fnum = fnum;
		}
		public String getUkeyStr() {
			if(ukey==null)
			{
				return "";
			}
			if(ukey==User.STATUS_ABLE) {
				return "正常";
			}
			if(ukey==User.STATUS_DISABLE) {
				return "禁止";
			}
			else {
				return "待解封";
			}

		}
		public String getFlagStr()
		{
			if(flag==null)
			{
				return "";
			}
			if(flag==1)
			{
				return "用户";
			}
			if(flag==2)
			{
				return "帖子管理员";
			}
			else {
				return "系统管理员";
			}
		}

}

