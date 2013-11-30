package com.ees.hibernate;

import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
public class Course extends AbstractCourse implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String cid, String cname) {
		super(cid, cname);
	}

	/** full constructor */
	public Course(String cid, String cname, Set stuEvaluations,
			Set teaEvalReses, Set teaEvaluations, Set chooseClasses,
			Set stuEvalReses) {
		super(cid, cname, stuEvaluations, teaEvalReses, teaEvaluations,
				chooseClasses, stuEvalReses);
	}

}
