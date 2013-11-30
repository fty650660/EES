package com.ees.hibernate;

/**
 * CourseTypeId entity. @author MyEclipse Persistence Tools
 */
public class CourseTypeId extends AbstractCourseTypeId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public CourseTypeId() {
	}

	/** minimal constructor */
	public CourseTypeId(Integer id) {
		super(id);
	}

	/** full constructor */
	public CourseTypeId(Integer id, String courseType, Integer ture) {
		super(id, courseType, ture);
	}

}
