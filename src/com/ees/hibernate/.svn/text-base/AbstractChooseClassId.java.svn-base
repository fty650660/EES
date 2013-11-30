package com.ees.hibernate;

/**
 * AbstractChooseClassId entity provides the base persistence definition of the
 * ChooseClassId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractChooseClassId implements java.io.Serializable {

	// Fields

	private Student student;
	private Course course;
	private Teacher teacher;
	private String xn;
	private Integer xq;
	private Double cj;
	private Integer classNum;
	private String courseType;
	private String cname;

	// Constructors

	/** default constructor */
	public AbstractChooseClassId() {
	}

	/** minimal constructor */
	public AbstractChooseClassId(Student student, Course course, Teacher teacher) {
		this.student = student;
		this.course = course;
		this.teacher = teacher;
	}

	/** full constructor */
	public AbstractChooseClassId(Student student, Course course,
			Teacher teacher, String xn, Integer xq, Double cj,
			Integer classNum, String courseType, String cname) {
		this.student = student;
		this.course = course;
		this.teacher = teacher;
		this.xn = xn;
		this.xq = xq;
		this.cj = cj;
		this.classNum = classNum;
		this.courseType = courseType;
		this.cname = cname;
	}

	// Property accessors

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

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getXn() {
		return this.xn;
	}

	public void setXn(String xn) {
		this.xn = xn;
	}

	public Integer getXq() {
		return this.xq;
	}

	public void setXq(Integer xq) {
		this.xq = xq;
	}

	public Double getCj() {
		return this.cj;
	}

	public void setCj(Double cj) {
		this.cj = cj;
	}

	public Integer getClassNum() {
		return this.classNum;
	}

	public void setClassNum(Integer classNum) {
		this.classNum = classNum;
	}

	public String getCourseType() {
		return this.courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractChooseClassId))
			return false;
		AbstractChooseClassId castOther = (AbstractChooseClassId) other;

		return ((this.getStudent() == castOther.getStudent()) || (this
				.getStudent() != null && castOther.getStudent() != null && this
				.getStudent().equals(castOther.getStudent())))
				&& ((this.getCourse() == castOther.getCourse()) || (this
						.getCourse() != null && castOther.getCourse() != null && this
						.getCourse().equals(castOther.getCourse())))
				&& ((this.getTeacher() == castOther.getTeacher()) || (this
						.getTeacher() != null && castOther.getTeacher() != null && this
						.getTeacher().equals(castOther.getTeacher())))
				&& ((this.getXn() == castOther.getXn()) || (this.getXn() != null
						&& castOther.getXn() != null && this.getXn().equals(
						castOther.getXn())))
				&& ((this.getXq() == castOther.getXq()) || (this.getXq() != null
						&& castOther.getXq() != null && this.getXq().equals(
						castOther.getXq())))
				&& ((this.getCj() == castOther.getCj()) || (this.getCj() != null
						&& castOther.getCj() != null && this.getCj().equals(
						castOther.getCj())))
				&& ((this.getClassNum() == castOther.getClassNum()) || (this
						.getClassNum() != null
						&& castOther.getClassNum() != null && this
						.getClassNum().equals(castOther.getClassNum())))
				&& ((this.getCourseType() == castOther.getCourseType()) || (this
						.getCourseType() != null
						&& castOther.getCourseType() != null && this
						.getCourseType().equals(castOther.getCourseType())))
				&& ((this.getCname() == castOther.getCname()) || (this
						.getCname() != null && castOther.getCname() != null && this
						.getCname().equals(castOther.getCname())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStudent() == null ? 0 : this.getStudent().hashCode());
		result = 37 * result
				+ (getCourse() == null ? 0 : this.getCourse().hashCode());
		result = 37 * result
				+ (getTeacher() == null ? 0 : this.getTeacher().hashCode());
		result = 37 * result + (getXn() == null ? 0 : this.getXn().hashCode());
		result = 37 * result + (getXq() == null ? 0 : this.getXq().hashCode());
		result = 37 * result + (getCj() == null ? 0 : this.getCj().hashCode());
		result = 37 * result
				+ (getClassNum() == null ? 0 : this.getClassNum().hashCode());
		result = 37
				* result
				+ (getCourseType() == null ? 0 : this.getCourseType()
						.hashCode());
		result = 37 * result
				+ (getCname() == null ? 0 : this.getCname().hashCode());
		return result;
	}

}