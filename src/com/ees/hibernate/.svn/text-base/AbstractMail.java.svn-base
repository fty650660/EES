package com.ees.hibernate;

import java.util.Date;

/**
 * AbstractMail entity provides the base persistence definition of the Mail
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMail implements java.io.Serializable {

	// Fields

	private Integer thId;
	private String sid;
	private String sname;
	private String tid;
	private String tname;
	private String theme;
	private String details;
	private Date subTime;
	private Boolean isFromTea;

	// Constructors

	/** default constructor */
	public AbstractMail() {
	}

	/** minimal constructor */
	public AbstractMail(Integer thId, String sid, String tid) {
		this.thId = thId;
		this.sid = sid;
		this.tid = tid;
	}

	/** full constructor */
	public AbstractMail(Integer thId, String sid, String sname, String tid,
			String tname, String theme, String details, Date subTime,
			Boolean isFromTea) {
		this.thId = thId;
		this.sid = sid;
		this.sname = sname;
		this.tid = tid;
		this.tname = tname;
		this.theme = theme;
		this.details = details;
		this.subTime = subTime;
		this.isFromTea = isFromTea;
	}

	// Property accessors

	public Integer getThId() {
		return this.thId;
	}

	public void setThId(Integer thId) {
		this.thId = thId;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getSubTime() {
		return this.subTime;
	}

	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}

	public Boolean getIsFromTea() {
		return this.isFromTea;
	}

	public void setIsFromTea(Boolean isFromTea) {
		this.isFromTea = isFromTea;
	}

}