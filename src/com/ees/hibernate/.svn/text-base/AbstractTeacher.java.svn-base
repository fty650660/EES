package com.ees.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTeacher entity provides the base persistence definition of the
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTeacher implements java.io.Serializable {

	// Fields

	private String tid;
	private String tname;
	private String password;
	private String dept;
	private String faculty;
	private Set stuEvalReses = new HashSet(0);
	private Set chooseClasses = new HashSet(0);
	private Set teaEvaluationsForLisTid = new HashSet(0);
	private Set teaEvalReses = new HashSet(0);
	private Set teaEvaluationsForTeaTid = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTeacher() {
	}

	/** minimal constructor */
	public AbstractTeacher(String tid, String tname, String password,
			String dept) {
		this.tid = tid;
		this.tname = tname;
		this.password = password;
		this.dept = dept;
	}

	/** full constructor */
	public AbstractTeacher(String tid, String tname, String password,
			String dept, String faculty, Set stuEvalReses, Set chooseClasses,
			Set teaEvaluationsForLisTid, Set teaEvalReses,
			Set teaEvaluationsForTeaTid) {
		this.tid = tid;
		this.tname = tname;
		this.password = password;
		this.dept = dept;
		this.faculty = faculty;
		this.stuEvalReses = stuEvalReses;
		this.chooseClasses = chooseClasses;
		this.teaEvaluationsForLisTid = teaEvaluationsForLisTid;
		this.teaEvalReses = teaEvalReses;
		this.teaEvaluationsForTeaTid = teaEvaluationsForTeaTid;
	}

	// Property accessors

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

	public String getFaculty() {
		return this.faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public Set getStuEvalReses() {
		return this.stuEvalReses;
	}

	public void setStuEvalReses(Set stuEvalReses) {
		this.stuEvalReses = stuEvalReses;
	}

	public Set getChooseClasses() {
		return this.chooseClasses;
	}

	public void setChooseClasses(Set chooseClasses) {
		this.chooseClasses = chooseClasses;
	}

	public Set getTeaEvaluationsForLisTid() {
		return this.teaEvaluationsForLisTid;
	}

	public void setTeaEvaluationsForLisTid(Set teaEvaluationsForLisTid) {
		this.teaEvaluationsForLisTid = teaEvaluationsForLisTid;
	}

	public Set getTeaEvalReses() {
		return this.teaEvalReses;
	}

	public void setTeaEvalReses(Set teaEvalReses) {
		this.teaEvalReses = teaEvalReses;
	}

	public Set getTeaEvaluationsForTeaTid() {
		return this.teaEvaluationsForTeaTid;
	}

	public void setTeaEvaluationsForTeaTid(Set teaEvaluationsForTeaTid) {
		this.teaEvaluationsForTeaTid = teaEvaluationsForTeaTid;
	}

}