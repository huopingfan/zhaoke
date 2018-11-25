package com.fh.bean.user;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserBean 
{
	private String cuserid;
	private String cloginid;
	private String cimgurl;
	private String cusername;
	private String cuserpwd;
	private String cemail;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dbirthday;
	private Integer nvalid;
	private String czwid;
	private Integer nsex;
	private String cdeptid;
	private String cdeptname;
	private String czwname;
	private String usersex;
	private Integer errorcount;
	
	
	
	
	
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getCdeptname() {
		return cdeptname;
	}
	public void setCdeptname(String cdeptname) {
		this.cdeptname = cdeptname;
	}
	public String getCzwname() {
		return czwname;
	}
	public void setCzwname(String czwname) {
		this.czwname = czwname;
	}
	public Integer getErrorcount() {
		return errorcount;
	}
	public void setErrorcount(Integer errorcount) {
		this.errorcount = errorcount;
	}
	public String getCuserid() {
		return cuserid;
	}
	public void setCuserid(String cuserid) {
		this.cuserid = cuserid;
	}
	public String getCloginid() {
		return cloginid;
	}
	public void setCloginid(String cloginid) {
		this.cloginid = cloginid;
	}
	public String getCimgurl() {
		return cimgurl;
	}
	public void setCimgurl(String cimgurl) {
		this.cimgurl = cimgurl;
	}
	public String getCusername() {
		return cusername;
	}
	public void setCusername(String cusername) {
		this.cusername = cusername;
	}
	public String getCuserpwd() {
		return cuserpwd;
	}
	public void setCuserpwd(String cuserpwd) {
		this.cuserpwd = cuserpwd;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public Date getDbirthday() {
		return dbirthday;
	}
	public void setDbirthday(Date dbirthday) {
		this.dbirthday = dbirthday;
	}
	public Integer getNvalid() {
		return nvalid;
	}
	public void setNvalid(Integer nvalid) {
		this.nvalid = nvalid;
	}
	public String getCzwid() {
		return czwid;
	}
	public void setCzwid(String czwid) {
		this.czwid = czwid;
	}
	public Integer getNsex() {
		return nsex;
	}
	public void setNsex(Integer nsex) {
		this.nsex = nsex;
	}
	public String getCdeptid() {
		return cdeptid;
	}
	public void setCdeptid(String cdeptid) {
		this.cdeptid = cdeptid;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
