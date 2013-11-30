package com.ees.hibernate;

import java.util.Date;

/**
 * AbstractMailReply entity provides the base persistence definition of the
 * MailReply entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMailReply implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer thId;
	private String reply;
	private Date subTime;
	private Boolean isFromStu;

	// Constructors

	/** default constructor */
	public AbstractMailReply() {
	}

	/** minimal constructor */
	public AbstractMailReply(Integer id, Integer thId) {
		this.id = id;
		this.thId = thId;
	}

	/** full constructor */
	public AbstractMailReply(Integer id, Integer thId, String reply,
			Date subTime, Boolean isFromStu) {
		this.id = id;
		this.thId = thId;
		this.reply = reply;
		this.subTime = subTime;
		this.isFromStu = isFromStu;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getThId() {
		return this.thId;
	}

	public void setThId(Integer thId) {
		this.thId = thId;
	}

	public String getReply() {
		return this.reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Date getSubTime() {
		return this.subTime;
	}

	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}

	public Boolean getIsFromStu() {
		return this.isFromStu;
	}

	public void setIsFromStu(Boolean isFromStu) {
		this.isFromStu = isFromStu;
	}

}