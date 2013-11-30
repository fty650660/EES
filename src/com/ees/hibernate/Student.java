package com.ees.hibernate;

import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
public class Student extends AbstractStudent implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String sid, String sname, String password) {
		super(sid, sname, password);
	}

	/** full constructor */
	public Student(String sid, String sname, String password, String dept,
			String major, String grade, String class_, String clname,
			Set stuEvaluations, Set chooseClasses) {
		super(sid, sname, password, dept, major, grade, class_, clname,
				stuEvaluations, chooseClasses);
	}

}
