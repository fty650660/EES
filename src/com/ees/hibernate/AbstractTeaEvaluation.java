package com.ees.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTeaEvaluation entity provides the base persistence definition of the
 * TeaEvaluation entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTeaEvaluation implements java.io.Serializable {

	// Fields

	private Integer markId;
	private Course course;
	private Teacher teacherByTeaTid;
	private Teacher teacherByLisTid;
	private String xn;
	private Integer xq;
	private Integer classNum;
	private String cname;
	private String reason;
	private String dept;
	private String teaClass;
	private String courseType;
	private String ageLevel;
	private String teaTime;
	private String teaPlace;
	private Date subTime;
	private Set teaEvalDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTeaEvaluation() {
	}

	/** minimal constructor */
	public AbstractTeaEvaluation(Integer markId) {
		this.markId = markId;
	}

	/** full constructor */
	public AbstractTeaEvaluation(Integer markId, Course course,
			Teacher teacherByTeaTid, Teacher teacherByLisTid, String xn,
			Integer xq, Integer classNum, String cname, String reason,
			String dept, String teaClass, String courseType, String ageLevel,
			String teaTime, String teaPlace, Date subTime, Set teaEvalDetails) {
		this.markId = markId;
		this.course = course;
		this.teacherByTeaTid = teacherByTeaTid;
		this.teacherByLisTid = teacherByLisTid;
		this.xn = xn;
		this.xq = xq;
		this.classNum = classNum;
		this.cname = cname;
		this.reason = reason;
		this.dept = dept;
		this.teaClass = teaClass;
		this.courseType = courseType;
		this.ageLevel = ageLevel;
		this.teaTime = teaTime;
		this.teaPlace = teaPlace;
		this.subTime = subTime;
		this.teaEvalDetails = teaEvalDetails;
	}

	// Property accessors

	public Integer getMarkId() {
		return this.markId;
	}

	public void setMarkId(Integer markId) {
		this.markId = markId;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacherByTeaTid() {
		return this.teacherByTeaTid;
	}

	public void setTeacherByTeaTid(Teacher teacherByTeaTid) {
		this.teacherByTeaTid = teacherByTeaTid;
	}

	public Teacher getTeacherByLisTid() {
		return this.teacherByLisTid;
	}

	public void setTeacherByLisTid(Teacher teacherByLisTid) {
		this.teacherByLisTid = teacherByLisTid;
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

	public Integer getClassNum() {
		return this.classNum;
	}

	public void setClassNum(Integer classNum) {
		this.classNum = classNum;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getTeaClass() {
		return this.teaClass;
	}

	public void setTeaClass(String teaClass) {
		this.teaClass = teaClass;
	}

	public String getCourseType() {
		return this.courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getAgeLevel() {
		return this.ageLevel;
	}

	public void setAgeLevel(String ageLevel) {
		this.ageLevel = ageLevel;
	}

	public String getTeaTime() {
		return this.teaTime;
	}

	public void setTeaTime(String teaTime) {
		this.teaTime = teaTime;
	}

	public String getTeaPlace() {
		return this.teaPlace;
	}

	public void setTeaPlace(String teaPlace) {
		this.teaPlace = teaPlace;
	}

	public Date getSubTime() {
		return this.subTime;
	}

	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}

	public Set getTeaEvalDetails() {
		return this.teaEvalDetails;
	}

	public void setTeaEvalDetails(Set teaEvalDetails) {
		this.teaEvalDetails = teaEvalDetails;
	}

}