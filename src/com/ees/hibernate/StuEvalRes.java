package com.ees.hibernate;

/**
 * StuEvalRes entity. @author MyEclipse Persistence Tools
 */
public class StuEvalRes extends AbstractStuEvalRes implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public StuEvalRes() {
	}

	/** full constructor */
	public StuEvalRes(StuEvalResId id, Teacher teacher, Course course) {
		super(id, teacher, course);
	}

}
