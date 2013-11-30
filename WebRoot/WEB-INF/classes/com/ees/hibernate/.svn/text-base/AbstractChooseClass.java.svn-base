package com.ees.hibernate;

/**
 * AbstractChooseClass entity provides the base persistence definition of the
 * ChooseClass entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractChooseClass implements java.io.Serializable {

	// Fields

	private ChooseClassId id;
	private Teacher teacher;
	private Student student;
	private Course course;

	// Constructors

	/** default constructor */
	public AbstractChooseClass() {
	}

	/** full constructor */
	public AbstractChooseClass(ChooseClassId id, Teacher teacher,
			Student student, Course course) {
		this.id = id;
		this.teacher = teacher;
		this.student = student;
		this.course = course;
	}

	// Property accessors

	public ChooseClassId getId() {
		return this.id;
	}

	public void setId(ChooseClassId id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}