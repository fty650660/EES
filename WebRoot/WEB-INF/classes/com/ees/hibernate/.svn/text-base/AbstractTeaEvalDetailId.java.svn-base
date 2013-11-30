package com.ees.hibernate;

/**
 * AbstractTeaEvalDetailId entity provides the base persistence definition of
 * the TeaEvalDetailId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTeaEvalDetailId implements java.io.Serializable {

	// Fields

	private TeaEvaluation teaEvaluation;
	private Integer qid;
	private Integer qscore;

	// Constructors

	/** default constructor */
	public AbstractTeaEvalDetailId() {
	}

	/** minimal constructor */
	public AbstractTeaEvalDetailId(TeaEvaluation teaEvaluation, Integer qid) {
		this.teaEvaluation = teaEvaluation;
		this.qid = qid;
	}

	/** full constructor */
	public AbstractTeaEvalDetailId(TeaEvaluation teaEvaluation, Integer qid,
			Integer qscore) {
		this.teaEvaluation = teaEvaluation;
		this.qid = qid;
		this.qscore = qscore;
	}

	// Property accessors

	public TeaEvaluation getTeaEvaluation() {
		return this.teaEvaluation;
	}

	public void setTeaEvaluation(TeaEvaluation teaEvaluation) {
		this.teaEvaluation = teaEvaluation;
	}

	public Integer getQid() {
		return this.qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
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
		if (!(other instanceof AbstractTeaEvalDetailId))
			return false;
		AbstractTeaEvalDetailId castOther = (AbstractTeaEvalDetailId) other;

		return ((this.getTeaEvaluation() == castOther.getTeaEvaluation()) || (this
				.getTeaEvaluation() != null
				&& castOther.getTeaEvaluation() != null && this
				.getTeaEvaluation().equals(castOther.getTeaEvaluation())))
				&& ((this.getQid() == castOther.getQid()) || (this.getQid() != null
						&& castOther.getQid() != null && this.getQid().equals(
						castOther.getQid())))
				&& ((this.getQscore() == castOther.getQscore()) || (this
						.getQscore() != null && castOther.getQscore() != null && this
						.getQscore().equals(castOther.getQscore())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTeaEvaluation() == null ? 0 : this.getTeaEvaluation()
						.hashCode());
		result = 37 * result
				+ (getQid() == null ? 0 : this.getQid().hashCode());
		result = 37 * result
				+ (getQscore() == null ? 0 : this.getQscore().hashCode());
		return result;
	}

}