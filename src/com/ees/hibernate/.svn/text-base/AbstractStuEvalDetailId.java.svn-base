package com.ees.hibernate;

/**
 * AbstractStuEvalDetailId entity provides the base persistence definition of
 * the StuEvalDetailId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStuEvalDetailId implements java.io.Serializable {

	// Fields

	private StuEvaluation stuEvaluation;
	private StuQuestionnaire stuQuestionnaire;
	private Integer qscore;

	// Constructors

	/** default constructor */
	public AbstractStuEvalDetailId() {
	}

	/** minimal constructor */
	public AbstractStuEvalDetailId(StuEvaluation stuEvaluation,
			StuQuestionnaire stuQuestionnaire) {
		this.stuEvaluation = stuEvaluation;
		this.stuQuestionnaire = stuQuestionnaire;
	}

	/** full constructor */
	public AbstractStuEvalDetailId(StuEvaluation stuEvaluation,
			StuQuestionnaire stuQuestionnaire, Integer qscore) {
		this.stuEvaluation = stuEvaluation;
		this.stuQuestionnaire = stuQuestionnaire;
		this.qscore = qscore;
	}

	// Property accessors

	public StuEvaluation getStuEvaluation() {
		return this.stuEvaluation;
	}

	public void setStuEvaluation(StuEvaluation stuEvaluation) {
		this.stuEvaluation = stuEvaluation;
	}

	public StuQuestionnaire getStuQuestionnaire() {
		return this.stuQuestionnaire;
	}

	public void setStuQuestionnaire(StuQuestionnaire stuQuestionnaire) {
		this.stuQuestionnaire = stuQuestionnaire;
	}

	public Integer getQscore() {
		return this.qscore;
	}

	public void setQscore(Integer qscore) {
		this.qscore = qscore;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractStuEvalDetailId))
			return false;
		AbstractStuEvalDetailId castOther = (AbstractStuEvalDetailId) other;

		return ((this.getStuEvaluation() == castOther.getStuEvaluation()) || (this
				.getStuEvaluation() != null
				&& castOther.getStuEvaluation() != null && this
				.getStuEvaluation().equals(castOther.getStuEvaluation())))
				&& ((this.getStuQuestionnaire() == castOther
						.getStuQuestionnaire()) || (this.getStuQuestionnaire() != null
						&& castOther.getStuQuestionnaire() != null && this
						.getStuQuestionnaire().equals(
								castOther.getStuQuestionnaire())))
				&& ((this.getQscore() == castOther.getQscore()) || (this
						.getQscore() != null && castOther.getQscore() != null && this
						.getQscore().equals(castOther.getQscore())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getStuEvaluation() == null ? 0 : this.getStuEvaluation()
						.hashCode());
		result = 37
				* result
				+ (getStuQuestionnaire() == null ? 0 : this
						.getStuQuestionnaire().hashCode());
		result = 37 * result
				+ (getQscore() == null ? 0 : this.getQscore().hashCode());
		return result;
	}

}