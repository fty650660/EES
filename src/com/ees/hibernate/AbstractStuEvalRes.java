package com.ees.hibernate;

/**
 * AbstractStuEvalRes entity provides the base persistence definition of the
 * StuEvalRes entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStuEvalRes implements java.io.Serializable {

	// Fields

	private StuEvalResId id;
	private Teacher teacher;
	private Course course;

	// Constructors

	/** default constructor */
	public AbstractStuEvalRes() {
	}

	/** full constructor */
	public AbstractStuEvalRes(StuEvalResId id, Teacher teacher, Course course) {
		this.id = id;
		this.teacher = teacher;
		this.course = course;
	}

	// Property accessors

	public StuEvalResId getId() {
		return this.id;
	}

	public void setId(StuEvalResId id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}