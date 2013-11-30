package com.ees.hibernate;

/**
 * StuEvalDetailId entity. @author MyEclipse Persistence Tools
 */
public class StuEvalDetailId extends AbstractStuEvalDetailId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public StuEvalDetailId() {
	}

	/** minimal constructor */
	public StuEvalDetailId(StuEvaluation stuEvaluation,
			StuQuestionnaire stuQuestionnaire) {
		super(stuEvaluation, stuQuestionnaire);
	}

	/** full constructor */
	public StuEvalDetailId(StuEvaluation stuEvaluation,
			StuQuestionnaire stuQuestionnaire, Integer qscore) {
		super(stuEvaluation, stuQuestionnaire, qscore);
	}

}
