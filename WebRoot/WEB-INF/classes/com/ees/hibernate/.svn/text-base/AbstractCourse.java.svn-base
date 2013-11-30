package com.ees.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractCourse entity provides the base persistence definition of the Course
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCourse implements java.io.Serializable {

	// Fields

	private String cid;
	private String cname;
	private Set stuEvaluations = new HashSet(0);
	private Set teaEvalReses = new HashSet(0);
	private Set teaEvaluations = new HashSet(0);
	private Set chooseClasses = new HashSet(0);
	private Set stuEvalReses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCourse() {
	}

	/** minimal constructor */
	public AbstractCourse(String cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}

	/** full constructor */
	public AbstractCourse(String cid, String cname, Set stuEvaluations,
			Set teaEvalReses, Set teaEvaluations, Set chooseClasses,
			Set stuEvalReses) {
		this.cid = cid;
		this.cname = cname;
		this.stuEvaluations = stuEvaluations;
		this.teaEvalReses = teaEvalReses;
		this.teaEvaluations = teaEvaluations;
		this.chooseClasses = chooseClasses;
		this.stuEvalReses = stuEvalReses;
	}

	// Property accessors

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set getStuEvaluations() {
		return this.stuEvaluations;
	}

	public void setStuEvaluations(Set stuEvaluations) {
		this.stuEvaluations = stuEvaluations;
	}

	public Set getTeaEvalReses() {
		return this.teaEvalReses;
	}

	public void setTeaEvalReses(Set teaEvalReses) {
		this.teaEvalReses = teaEvalReses;
	}

	public Set getTeaEvaluations() {
		return this.teaEvaluations;
	}

	public void setTeaEvaluations(Set teaEvaluations) {
		this.teaEvaluations = teaEvaluations;
	}

	public Set getChooseClasses() {
		return this.chooseClasses;
	}

	public void setChooseClasses(Set chooseClasses) {
		this.chooseClasses = chooseClasses;
	}

	public Set getStuEvalReses() {
		return this.stuEvalReses;
	}

	public void setStuEvalReses(Set stuEvalReses) {
		this.stuEvalReses = stuEvalReses;
	}

}