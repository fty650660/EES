package com.ees.hibernate;

/**
 * AbstractTeaEvalRes entity provides the base persistence definition of the
 * TeaEvalRes entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTeaEvalRes implements java.io.Serializable {

	// Fields

	private TeaEvalResId id;
	private Teacher teacher;
	private Course course;

	// Constructors

	/** default constructor */
	public AbstractTeaEvalRes() {
	}

	/** full constructor */
	public AbstractTeaEvalRes(TeaEvalResId id, Teacher teacher, Course course) {
		this.id = id;
		this.teacher = teacher;
		this.course = course;
	}

	// Property accessors

	public TeaEvalResId getId() {
		return this.id;
	}

	public void setId(TeaEvalResId id) {
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