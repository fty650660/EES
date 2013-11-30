package com.ees.hibernate;

import java.util.Date;
import java.util.Set;

/**
 * TeaEvaluation entity. @author MyEclipse Persistence Tools
 */
public class TeaEvaluation extends AbstractTeaEvaluation implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TeaEvaluation() {
	}

	/** minimal constructor */
	public TeaEvaluation(Integer markId) {
		super(markId);
	}

	/** full constructor */
	public TeaEvaluation(Integer markId, Course course,
			Teacher teacherByTeaTid, Teacher teacherByLisTid, String cname,
			String reason, String dept, String teaClass, String courseType,
			String ageLevel, String teaTime, String teaPlace, Date subTime,
			Set teaEvalDetails) {
		super(markId, course, teacherByTeaTid, teacherByLisTid, cname, markId,
				markId, reason, dept, teaClass, courseType, ageLevel, teaTime,
				teaPlace, teaPlace, subTime, teaEvalDetails);
	}

}
