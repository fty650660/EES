package com.ees.hibernate;

/**
 * StuEvalResId entity. @author MyEclipse Persistence Tools
 */
public class StuEvalResId extends AbstractStuEvalResId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public StuEvalResId() {
	}

	/** minimal constructor */
	public StuEvalResId(Course course, Teacher teacher) {
		super(course, teacher);
	}

	/** full constructor */
	public StuEvalResId(Course course, Teacher teacher, Integer category1,
			Integer category2, Integer category3, Integer category4,
			Integer number, String cname, String classNum) {
		super(course, teacher, category1, category2, category3, category4,
				number, cname, classNum);
	}

}
