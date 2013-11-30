package com.ees.hibernate;

/**
 * AbstractCourseTypeId entity provides the base persistence definition of the
 * CourseTypeId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCourseTypeId implements java.io.Serializable {

	// Fields

	private Integer id;
	private String courseType;
	private Integer ture;

	// Constructors

	/** default constructor */
	public AbstractCourseTypeId() {
	}

	/** minimal constructor */
	public AbstractCourseTypeId(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractCourseTypeId(Integer id, String courseType, Integer ture) {
		this.id = id;
		this.courseType = courseType;
		this.ture = ture;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseType() {
		return this.courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public Integer getTure() {
		return this.ture;
	}

	public void setTure(Integer ture) {
		this.ture = ture;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractCourseTypeId))
			return false;
		AbstractCourseTypeId castOther = (AbstractCourseTypeId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getCourseType() == castOther.getCourseType()) || (this
						.getCourseType() != null
						&& castOther.getCourseType() != null && this
						.getCourseType().equals(castOther.getCourseType())))
				&& ((this.getTure() == castOther.getTure()) || (this.getTure() != null
						&& castOther.getTure() != null && this.getTure()
						.equals(castOther.getTure())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getCourseType() == null ? 0 : this.getCourseType()
						.hashCode());
		result = 37 * result
				+ (getTure() == null ? 0 : this.getTure().hashCode());
		return result;
	}

}