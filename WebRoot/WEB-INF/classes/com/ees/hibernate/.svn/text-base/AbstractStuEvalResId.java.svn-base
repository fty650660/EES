package com.ees.hibernate;

/**
 * AbstractStuEvalResId entity provides the base persistence definition of the
 * StuEvalResId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStuEvalResId implements java.io.Serializable {

	// Fields

	private Course course;
	private Teacher teacher;
	private Integer category1;
	private Integer category2;
	private Integer category3;
	private Integer category4;
	private Integer number;
	private String cname;
	private String classNum;

	// Constructors

	/** default constructor */
	public AbstractStuEvalResId() {
	}

	/** minimal constructor */
	public AbstractStuEvalResId(Course course, Teacher teacher) {
		this.course = course;
		this.teacher = teacher;
	}

	/** full constructor */
	public AbstractStuEvalResId(Course course, Teacher teacher,
			Integer category1, Integer category2, Integer category3,
			Integer category4, Integer number, String cname, String classNum) {
		this.course = course;
		this.teacher = teacher;
		this.category1 = category1;
		this.category2 = category2;
		this.category3 = category3;
		this.category4 = category4;
		this.number = number;
		this.cname = cname;
		this.classNum = classNum;
	}

	// Property accessors

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

	public Integer getCategory1() {
		return this.category1;
	}

	public void setCategory1(Integer category1) {
		this.category1 = category1;
	}

	public Integer getCategory2() {
		return this.category2;
	}

	public void setCategory2(Integer category2) {
		this.category2 = category2;
	}

	public Integer getCategory3() {
		return this.category3;
	}

	public void setCategory3(Integer category3) {
		this.category3 = category3;
	}

	public Integer getCategory4() {
		return this.category4;
	}

	public void setCategory4(Integer category4) {
		this.category4 = category4;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getClassNum() {
		return this.classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractStuEvalResId))
			return false;
		AbstractStuEvalResId castOther = (AbstractStuEvalResId) other;

		return ((this.getCourse() == castOther.getCourse()) || (this
				.getCourse() != null && castOther.getCourse() != null && this
				.getCourse().equals(castOther.getCourse())))
				&& ((this.getTeacher() == castOther.getTeacher()) || (this
						.getTeacher() != null && castOther.getTeacher() != null && this
						.getTeacher().equals(castOther.getTeacher())))
				&& ((this.getCategory1() == castOther.getCategory1()) || (this
						.getCategory1() != null
						&& castOther.getCategory1() != null && this
						.getCategory1().equals(castOther.getCategory1())))
				&& ((this.getCategory2() == castOther.getCategory2()) || (this
						.getCategory2() != null
						&& castOther.getCategory2() != null && this
						.getCategory2().equals(castOther.getCategory2())))
				&& ((this.getCategory3() == castOther.getCategory3()) || (this
						.getCategory3() != null
						&& castOther.getCategory3() != null && this
						.getCategory3().equals(castOther.getCategory3())))
				&& ((this.getCategory4() == castOther.getCategory4()) || (this
						.getCategory4() != null
						&& castOther.getCategory4() != null && this
						.getCategory4().equals(castOther.getCategory4())))
				&& ((this.getNumber() == castOther.getNumber()) || (this
						.getNumber() != null && castOther.getNumber() != null && this
						.getNumber().equals(castOther.getNumber())))
				&& ((this.getCname() == castOther.getCname()) || (this
						.getCname() != null && castOther.getCname() != null && this
						.getCname().equals(castOther.getCname())))
				&& ((this.getClassNum() == castOther.getClassNum()) || (this
						.getClassNum() != null
						&& castOther.getClassNum() != null && this
						.getClassNum().equals(castOther.getClassNum())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCourse() == null ? 0 : this.getCourse().hashCode());
		result = 37 * result
				+ (getTeacher() == null ? 0 : this.getTeacher().hashCode());
		result = 37 * result
				+ (getCategory1() == null ? 0 : this.getCategory1().hashCode());
		result = 37 * result
				+ (getCategory2() == null ? 0 : this.getCategory2().hashCode());
		result = 37 * result
				+ (getCategory3() == null ? 0 : this.getCategory3().hashCode());
		result = 37 * result
				+ (getCategory4() == null ? 0 : this.getCategory4().hashCode());
		result = 37 * result
				+ (getNumber() == null ? 0 : this.getNumber().hashCode());
		result = 37 * result
				+ (getCname() == null ? 0 : this.getCname().hashCode());
		result = 37 * result
				+ (getClassNum() == null ? 0 : this.getClassNum().hashCode());
		return result;
	}

}