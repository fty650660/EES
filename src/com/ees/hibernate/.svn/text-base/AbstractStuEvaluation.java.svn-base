package com.ees.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractStuEvaluation entity provides the base persistence definition of the
 * StuEvaluation entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStuEvaluation implements java.io.Serializable {

	// Fields

	private String markId;
	private Student student;
	private Course course;
	private String reason;
	private String cname;
	private Set stuEvalDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractStuEvaluation() {
	}

	/** minimal constructor */
	public AbstractStuEvaluation(String markId, Student student, Course course) {
		this.markId = markId;
		this.student = student;
		this.course = course;
	}

	/** full constructor */
	public AbstractStuEvaluation(String markId, Student student, Course course,
			String reason, String cname, Set stuEvalDetails) {
		this.markId = markId;
		this.student = student;
		this.course = course;
		this.reason = reason;
		this.cname = cname;
		this.stuEvalDetails = stuEvalDetails;
	}

	// Property accessors

	public String getMarkId() {
		return this.markId;
	}

	public void setMarkId(String markId) {
		this.markId = markId;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set getStuEvalDetails() {
		return this.stuEvalDetails;
	}

	public void setStuEvalDetails(Set stuEvalDetails) {
		this.stuEvalDetails = stuEvalDetails;
	}

}