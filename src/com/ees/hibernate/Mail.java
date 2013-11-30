package com.ees.hibernate;

import java.util.Date;

/**
 * Mail entity. @author MyEclipse Persistence Tools
 */
public class Mail extends AbstractMail implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Mail() {
	}

	/** minimal constructor */
	public Mail(Integer thId, String sid, String tid) {
		super(thId, sid, tid);
	}

	/** full constructor */
	public Mail(Integer thId, String sid, String sname, String tid,
			String tname, String theme, String details, Date subTime,
			Boolean isFromTea) {
		super(thId, sid, sname, tid, tname, theme, details, subTime, isFromTea);
	}

}
