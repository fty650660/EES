package com.ees.hibernate;

/**
 * AbstractStuEvalDetail entity provides the base persistence definition of the
 * StuEvalDetail entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStuEvalDetail implements java.io.Serializable {

	// Fields

	private StuEvalDetailId id;
	private StuQuestionnaire stuQuestionnaire;
	private StuEvaluation stuEvaluation;

	// Constructors

	/** default constructor */
	public AbstractStuEvalDetail() {
	}

	/** full constructor */
	public AbstractStuEvalDetail(StuEvalDetailId id,
			StuQuestionnaire stuQuestionnaire, StuEvaluation stuEvaluation) {
		this.id = id;
		this.stuQuestionnaire = stuQuestionnaire;
		this.stuEvaluation = stuEvaluation;
	}

	// Property accessors

	public StuEvalDetailId getId() {
		return this.id;
	}

	public void setId(StuEvalDetailId id) {
		this.id = id;
	}

	public StuQuestionnaire getStuQuestionnaire() {
		return this.stuQuestionnaire;
	}

	public void setStuQuestionnaire(StuQuestionnaire stuQuestionnaire) {
		this.stuQuestionnaire = stuQuestionnaire;
	}

	public StuEvaluation getStuEvaluation() {
		return this.stuEvaluation;
	}

	public void setStuEvaluation(StuEvaluation stuEvaluation) {
		this.stuEvaluation = stuEvaluation;
	}

}