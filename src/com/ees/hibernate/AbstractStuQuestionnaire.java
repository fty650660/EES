package com.ees.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractStuQuestionnaire entity provides the base persistence definition of
 * the StuQuestionnaire entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStuQuestionnaire implements java.io.Serializable {

	// Fields

	private Integer qid;
	private String content;
	private Integer category;
	private Integer weight;
	private Set stuEvalDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractStuQuestionnaire() {
	}

	/** minimal constructor */
	public AbstractStuQuestionnaire(Integer qid, String content,
			Integer category, Integer weight) {
		this.qid = qid;
		this.content = content;
		this.category = category;
		this.weight = weight;
	}

	/** full constructor */
	public AbstractStuQuestionnaire(Integer qid, String content,
			Integer category, Integer weight, Set stuEvalDetails) {
		this.qid = qid;
		this.content = content;
		this.category = category;
		this.weight = weight;
		this.stuEvalDetails = stuEvalDetails;
	}

	// Property accessors

	public Integer getQid() {
		return this.qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCategory() {
		return this.category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Set getStuEvalDetails() {
		return this.stuEvalDetails;
	}

	public void setStuEvalDetails(Set stuEvalDetails) {
		this.stuEvalDetails = stuEvalDetails;
	}

}