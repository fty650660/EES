package com.ees.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractStudent entity provides the base persistence definition of the
 * Student entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStudent implements java.io.Serializable {

	// Fields

	private String sid;
	private String sname;
	private String password;
	private String dept;
	private String major;
	private String grade;
	private String class_;
	private String clname;
	private Set stuEvaluations = new HashSet(0);
	private Set chooseClasses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractStudent() {
	}

	/** minimal constructor */
	public AbstractStudent(String sid, String sname, String password) {
		this.sid = sid;
		this.sname = sname;
		this.password = password;
	}

	/** full constructor */
	public AbstractStudent(String sid, String sname, String password,
			String dept, String major, String grade, String class_,
			String clname, Set stuEvaluations, Set chooseClasses) {
		this.sid = sid;
		this.sname = sname;
		this.password = password;
		this.dept = dept;
		this.major = major;
		this.grade = grade;
		this.class_ = class_;
		this.clname = clname;
		this.stuEvaluations = stuEvaluations;
		this.chooseClasses = chooseClasses;
	}

	// Property accessors

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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getClname() {
		return this.clname;
	}

	public void setClname(String clname) {
		this.clname = clname;
	}

	public Set getStuEvaluations() {
		return this.stuEvaluations;
	}

	public void setStuEvaluations(Set stuEvaluations) {
		this.stuEvaluations = stuEvaluations;
	}

	public Set getChooseClasses() {
		return this.chooseClasses;
	}

	public void setChooseClasses(Set chooseClasses) {
		this.chooseClasses = chooseClasses;
	}

}