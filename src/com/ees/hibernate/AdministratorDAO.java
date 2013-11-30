package com.ees.hibernate;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Administrator entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ees.hibernate.Administrator
 * @author MyEclipse Persistence Tools
 */

public class AdministratorDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AdministratorDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String LEVEL = "level";
	
	public static final String XN="XN";
	public static final String XQ="XQ";
	public static final String DEPT="Dept";
	public static final String FACULTY="faculty";
	public static final String TID="TID";
	public static final String TNAME="TName";
	public static final String CNAME="CName";
	public static final String COURSETYPE="CourseType";
	public static final String CID="CID";
	public static final String SUMAVG="SumAvg";
	public static final String NUM="Num";
	
	public static final String TITLE="Title";
	public static final String COURSECOUNT="CourseCount";
	public static final String YOU="You";
	public static final String LIANG="Liang";
	public static final String ZHONG="Zhong";
	public static final String CHA="Cha";
	public static final String NOTEVALUED="NotEvalued";
	public static final String BUHEGE="Buhege";

	public List showAllTeaList() {
		String sql = "SELECT DISTINCT cc.XN,cc.XQ,Dept,faculty,cc.TID,dbo.Teacher.TName,dbo.Teacher.Title,cc.CID,cc.CName,cc.CourseType," +
				"(SELECT SumScore/Number FROM dbo.TeaEvalRes " +
				"WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS SumAvg," +
				"(SELECT Number FROM dbo.TeaEvalRes " +
				"WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS Num " +
				"FROM dbo.Teacher RIGHT JOIN dbo.ChooseClass AS cc ON dbo.Teacher.TID = cc.TID LEFT JOIN dbo.TeaEvalRes ON cc.CID = dbo.TeaEvalRes.CID AND cc.TID = dbo.TeaEvalRes.TID AND cc.XN = dbo.TeaEvalRes.XN AND cc.XQ = dbo.TeaEvalRes.XQ " +
				"WHERE dbo.Teacher.Dept='计算机科学与信息学院'";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(DEPT, Hibernate.STRING)
				.addScalar(FACULTY,Hibernate.STRING)
				.addScalar(TID, Hibernate.STRING)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(TITLE, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(COURSETYPE, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.INTEGER)
				.addScalar(NUM, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List showTeaListByCourseCount(String faculty, String xn, int xq, String title) {
			String sql = " SELECT DISTINCT XN,XQ,Dept,faculty,TID,TName,Title,CID,CName,CourseType,SumAvg,Num " +
					"FROM dbo.EvaluTeaCS_View0 WHERE faculty='"+faculty+"' AND XN='"+xn+"' AND XQ="+xq+" AND Title='"+title+"'";
			Query query = getSession().createSQLQuery(sql)
					.addScalar(XN, Hibernate.STRING)
					.addScalar(XQ, Hibernate.INTEGER)
					.addScalar(DEPT, Hibernate.STRING)
					.addScalar(FACULTY,Hibernate.STRING)
					.addScalar(TID, Hibernate.STRING)
					.addScalar(TNAME, Hibernate.STRING)
					.addScalar(TITLE, Hibernate.STRING)
					.addScalar(CID, Hibernate.STRING)
					.addScalar(CNAME, Hibernate.STRING)
					.addScalar(COURSETYPE, Hibernate.STRING)
					.addScalar(SUMAVG, Hibernate.INTEGER)
					.addScalar(NUM, Hibernate.INTEGER);
			List list = query.list();
			return list;
	
	}
	
	public List showTeaListByYou(String faculty, String xn, int xq, String title) {
		String sql = " SELECT DISTINCT XN,XQ,Dept,faculty,TID,TName,Title,CID,CName,CourseType,SumAvg,Num "
				+ "FROM dbo.EvaluTeaCS_View0 WHERE faculty='"
				+ faculty
				+ "' AND XN='"
				+ xn
				+ "' AND XQ="
				+ xq
				+ " AND Title='"
				+ title
				+ "' AND SumAvg>=90";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(DEPT, Hibernate.STRING)
				.addScalar(FACULTY, Hibernate.STRING)
				.addScalar(TID, Hibernate.STRING)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(TITLE, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(COURSETYPE, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.INTEGER)
				.addScalar(NUM, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List showTeaListByLiang(String faculty, String xn, int xq, String title) {
		String sql = " SELECT DISTINCT XN,XQ,Dept,faculty,TID,TName,Title,CID,CName,CourseType,SumAvg,Num "
				+ "FROM dbo.EvaluTeaCS_View0 WHERE faculty='"
				+ faculty
				+ "' AND XN='"
				+ xn
				+ "' AND XQ="
				+ xq
				+ " AND Title='"
				+ title
				+ "' AND SumAvg>=80 AND SumAvg<90";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(DEPT, Hibernate.STRING)
				.addScalar(FACULTY, Hibernate.STRING)
				.addScalar(TID, Hibernate.STRING)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(TITLE, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(COURSETYPE, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.INTEGER)
				.addScalar(NUM, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List showTeaListByZhong(String faculty, String xn, int xq, String title) {
		String sql = " SELECT DISTINCT XN,XQ,Dept,faculty,TID,TName,Title,CID,CName,CourseType,SumAvg,Num "
				+ "FROM dbo.EvaluTeaCS_View0 WHERE faculty='"
				+ faculty
				+ "' AND XN='"
				+ xn
				+ "' AND XQ="
				+ xq
				+ " AND Title='"
				+ title
				+ "' AND SumAvg>=70 AND SumAvg<80";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(DEPT, Hibernate.STRING)
				.addScalar(FACULTY, Hibernate.STRING)
				.addScalar(TID, Hibernate.STRING)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(TITLE, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(COURSETYPE, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.INTEGER)
				.addScalar(NUM, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List showTeaListByCha(String faculty, String xn, int xq, String title) {
		String sql = " SELECT DISTINCT XN,XQ,Dept,faculty,TID,TName,Title,CID,CName,CourseType,SumAvg,Num "
				+ "FROM dbo.EvaluTeaCS_View0 WHERE faculty='"
				+ faculty
				+ "' AND XN='"
				+ xn
				+ "' AND XQ="
				+ xq
				+ " AND Title='"
				+ title
				+ "' AND SumAvg>=60 AND SumAvg<70";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(DEPT, Hibernate.STRING)
				.addScalar(FACULTY, Hibernate.STRING)
				.addScalar(TID, Hibernate.STRING)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(TITLE, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(COURSETYPE, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.INTEGER)
				.addScalar(NUM, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List showTeaListByBuhege(String faculty, String xn, int xq, String title) {
		String sql = " SELECT DISTINCT XN,XQ,Dept,faculty,TID,TName,Title,CID,CName,CourseType,SumAvg,Num "
				+ "FROM dbo.EvaluTeaCS_View0 WHERE faculty='"
				+ faculty
				+ "' AND XN='"
				+ xn
				+ "' AND XQ="
				+ xq
				+ " AND Title='"
				+ title
				+ "' AND SumAvg<60";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(DEPT, Hibernate.STRING)
				.addScalar(FACULTY, Hibernate.STRING)
				.addScalar(TID, Hibernate.STRING)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(TITLE, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(COURSETYPE, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.INTEGER)
				.addScalar(NUM, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List showTeaListByNotEvalued(String faculty, String xn, int xq, String title) {
		String sql = " SELECT DISTINCT XN,XQ,Dept,faculty,TID,TName,Title,CID,CName,CourseType,SumAvg,Num "
				+ "FROM dbo.EvaluTeaCS_View0 WHERE faculty='"
				+ faculty
				+ "' AND XN='"
				+ xn
				+ "' AND XQ="
				+ xq
				+ " AND Title='"
				+ title
				+ "' AND SumAvg IS NULL";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(DEPT, Hibernate.STRING)
				.addScalar(FACULTY, Hibernate.STRING)
				.addScalar(TID, Hibernate.STRING)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(TITLE, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(COURSETYPE, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.INTEGER)
				.addScalar(NUM, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List showAllTitleListXn(String xn) {
		String sql = "SELECT DISTINCT faculty,XN,XQ,Title," +
				"(SELECT COUNT(CID) FROM dbo.EvaluTeaCS_View0 AS v1 WHERE v1.XN=v0.XN AND v1.XQ=v0.XQ AND v1.Title=v0.Title AND v1.faculty=v0.faculty) AS CourseCount, " +
				"(SELECT COUNT(SumAvg) FROM dbo.EvaluTeaCS_View0 AS v1 WHERE v1.XN=v0.XN AND v1.XQ=v0.XQ AND v1.Title=v0.Title AND v1.faculty=v0.faculty  AND SumAvg>=90) AS You,  " +
				"(SELECT COUNT(SumAvg) FROM dbo.EvaluTeaCS_View0 AS v1 WHERE v1.XN=v0.XN AND v1.XQ=v0.XQ AND v1.Title=v0.Title AND v1.faculty=v0.faculty  AND SumAvg>=80 AND SumAvg<90) AS Liang,  " +
				"(SELECT COUNT(SumAvg) FROM dbo.EvaluTeaCS_View0 AS v1 WHERE v1.XN=v0.XN AND v1.XQ=v0.XQ AND v1.Title=v0.Title AND v1.faculty=v0.faculty  AND SumAvg>=70 AND SumAvg<80) AS Zhong,  " +
				"(SELECT COUNT(SumAvg) FROM dbo.EvaluTeaCS_View0 AS v1 WHERE v1.XN=v0.XN AND v1.XQ=v0.XQ AND v1.Title=v0.Title AND v1.faculty=v0.faculty  AND SumAvg>=60 AND SumAvg<70) AS Cha,  " +
				"(SELECT COUNT(SumAvg) FROM dbo.EvaluTeaCS_View0 AS v1 WHERE v1.XN=v0.XN AND v1.XQ=v0.XQ AND v1.Title=v0.Title AND v1.faculty=v0.faculty  AND SumAvg<60) AS Buhege,  " +
				"(SELECT COUNT(CID) FROM dbo.EvaluTeaCS_View0 AS v1 WHERE v1.XN=v0.XN AND v1.XQ=v0.XQ AND v1.Title=v0.Title AND v1.faculty=v0.faculty  AND SumAvg IS NULL) AS NotEvalued " +
				"FROM dbo.EvaluTeaCS_View0 AS v0 WHERE v0.XN='"+xn+"'";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(FACULTY,Hibernate.STRING)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(TITLE, Hibernate.STRING)
				.addScalar(COURSECOUNT, Hibernate.INTEGER)
				.addScalar(YOU, Hibernate.INTEGER)
				.addScalar(LIANG, Hibernate.INTEGER)
				.addScalar(ZHONG, Hibernate.INTEGER)
				.addScalar(CHA, Hibernate.INTEGER)
				.addScalar(BUHEGE, Hibernate.INTEGER)
				.addScalar(NOTEVALUED, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List showAllTitleListXnXq(String xn,int xq) {
		String sql = "SELECT DISTINCT faculty,XN,XQ,Title," +
				"(SELECT COUNT(CID) FROM dbo.EvaluTeaCS_View0 AS v1 WHERE v1.XN=v0.XN AND v1.XQ=v0.XQ AND v1.Title=v0.Title AND v1.faculty=v0.faculty) AS CourseCount, " +
				"(SELECT COUNT(SumAvg) FROM dbo.EvaluTeaCS_View0 AS v1 WHERE v1.XN=v0.XN AND v1.XQ=v0.XQ AND v1.Title=v0.Title AND v1.faculty=v0.faculty  AND SumAvg>=90) AS You,  " +
				"(SELECT COUNT(SumAvg) FROM dbo.EvaluTeaCS_View0 AS v1 WHERE v1.XN=v0.XN AND v1.XQ=v0.XQ AND v1.Title=v0.Title AND v1.faculty=v0.faculty  AND SumAvg>=80 AND SumAvg<90) AS Liang,  " +
				"(SELECT COUNT(SumAvg) FROM dbo.EvaluTeaCS_View0 AS v1 WHERE v1.XN=v0.XN AND v1.XQ=v0.XQ AND v1.Title=v0.Title AND v1.faculty=v0.faculty  AND SumAvg>=70 AND SumAvg<80) AS Zhong,  " +
				"(SELECT COUNT(SumAvg) FROM dbo.EvaluTeaCS_View0 AS v1 WHERE v1.XN=v0.XN AND v1.XQ=v0.XQ AND v1.Title=v0.Title AND v1.faculty=v0.faculty  AND SumAvg>=60 AND SumAvg<70) AS Cha,  " +
				"(SELECT COUNT(SumAvg) FROM dbo.EvaluTeaCS_View0 AS v1 WHERE v1.XN=v0.XN AND v1.XQ=v0.XQ AND v1.Title=v0.Title AND v1.faculty=v0.faculty  AND SumAvg<60) AS Buhege,  " +
				"(SELECT COUNT(CID) FROM dbo.EvaluTeaCS_View0 AS v1 WHERE v1.XN=v0.XN AND v1.XQ=v0.XQ AND v1.Title=v0.Title AND v1.faculty=v0.faculty  AND SumAvg IS NULL) AS NotEvalued " +
				"FROM dbo.EvaluTeaCS_View0 AS v0 WHERE v0.XN='"+xn+"' AND v0.XQ="+xq;
		Query query = getSession().createSQLQuery(sql)
				.addScalar(FACULTY,Hibernate.STRING)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(TITLE, Hibernate.STRING)
				.addScalar(COURSECOUNT, Hibernate.INTEGER)
				.addScalar(YOU, Hibernate.INTEGER)
				.addScalar(LIANG, Hibernate.INTEGER)
				.addScalar(ZHONG, Hibernate.INTEGER)
				.addScalar(CHA, Hibernate.INTEGER)
				.addScalar(BUHEGE, Hibernate.INTEGER)
				.addScalar(NOTEVALUED, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List showByXN(String xn, String faculty) {
		String sql = "SELECT DISTINCT cc.XN,cc.XQ,Dept,faculty,cc.TID,dbo.Teacher.TName,cc.CID,cc.CName,cc.CourseType,"
				+ "(SELECT SumScore/Number FROM dbo.TeaEvalRes "
				+ "WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS SumAvg,"
				+ "(SELECT Number FROM dbo.TeaEvalRes "
				+ "WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS Num "
				+ "FROM dbo.Teacher RIGHT JOIN dbo.ChooseClass AS cc ON dbo.Teacher.TID = cc.TID LEFT JOIN dbo.TeaEvalRes ON cc.CID = dbo.TeaEvalRes.CID AND cc.TID = dbo.TeaEvalRes.TID AND cc.XN = dbo.TeaEvalRes.XN AND cc.XQ = dbo.TeaEvalRes.XQ "
				+ "WHERE dbo.Teacher.Dept='计算机科学与信息学院'" + " AND cc.XN='" + xn + "' AND dbo.Teacher.faculty='" + faculty + "'";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(DEPT, Hibernate.STRING)
				.addScalar(FACULTY, Hibernate.STRING)
				.addScalar(TID, Hibernate.STRING)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(COURSETYPE, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.INTEGER)
				.addScalar(NUM, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}

	public List showByTnameF(String tname, String faculty) {
		String sql = "SELECT DISTINCT cc.XN,cc.XQ,Dept,faculty,cc.TID,dbo.Teacher.TName,cc.CID,cc.CName,cc.CourseType,"
				+ "(SELECT SumScore/Number FROM dbo.TeaEvalRes "
				+ "WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS SumAvg,"
				+ "(SELECT Number FROM dbo.TeaEvalRes "
				+ "WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS Num "
				+ "FROM dbo.Teacher RIGHT JOIN dbo.ChooseClass AS cc ON dbo.Teacher.TID = cc.TID LEFT JOIN dbo.TeaEvalRes ON cc.CID = dbo.TeaEvalRes.CID AND cc.TID = dbo.TeaEvalRes.TID AND cc.XN = dbo.TeaEvalRes.XN AND cc.XQ = dbo.TeaEvalRes.XQ "
				+ "WHERE dbo.Teacher.Dept='计算机科学与信息学院'" + " AND dbo.Teacher.TName='" + tname + "' AND dbo.Teacher.faculty='" + faculty + "'";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(DEPT, Hibernate.STRING)
				.addScalar(FACULTY, Hibernate.STRING)
				.addScalar(TID, Hibernate.STRING)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(COURSETYPE, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.INTEGER)
				.addScalar(NUM, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List showByTnameY(String tname, String xn) {
		String sql = "SELECT DISTINCT cc.XN,cc.XQ,Dept,faculty,cc.TID,dbo.Teacher.TName,cc.CID,cc.CName,cc.CourseType,"
				+ "(SELECT SumScore/Number FROM dbo.TeaEvalRes "
				+ "WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS SumAvg,"
				+ "(SELECT Number FROM dbo.TeaEvalRes "
				+ "WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS Num "
				+ "FROM dbo.Teacher RIGHT JOIN dbo.ChooseClass AS cc ON dbo.Teacher.TID = cc.TID LEFT JOIN dbo.TeaEvalRes ON cc.CID = dbo.TeaEvalRes.CID AND cc.TID = dbo.TeaEvalRes.TID AND cc.XN = dbo.TeaEvalRes.XN AND cc.XQ = dbo.TeaEvalRes.XQ "
				+ "WHERE dbo.Teacher.Dept='计算机科学与信息学院'" + " AND dbo.Teacher.TName='" + tname + "' AND cc.XN='" + xn + "'";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(DEPT, Hibernate.STRING)
				.addScalar(FACULTY, Hibernate.STRING)
				.addScalar(TID, Hibernate.STRING)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(COURSETYPE, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.INTEGER)
				.addScalar(NUM, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List showByCnameF(String cname, String faculty) {
		String sql = "SELECT DISTINCT cc.XN,cc.XQ,Dept,faculty,cc.TID,dbo.Teacher.TName,cc.CID,cc.CName,cc.CourseType,"
				+ "(SELECT SumScore/Number FROM dbo.TeaEvalRes "
				+ "WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS SumAvg,"
				+ "(SELECT Number FROM dbo.TeaEvalRes "
				+ "WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS Num "
				+ "FROM dbo.Teacher RIGHT JOIN dbo.ChooseClass AS cc ON dbo.Teacher.TID = cc.TID LEFT JOIN dbo.TeaEvalRes ON cc.CID = dbo.TeaEvalRes.CID AND cc.TID = dbo.TeaEvalRes.TID AND cc.XN = dbo.TeaEvalRes.XN AND cc.XQ = dbo.TeaEvalRes.XQ "
				+ "WHERE dbo.Teacher.Dept='计算机科学与信息学院'" + " AND cc.CNAME='" + cname + "' AND dbo.Teacher.faculty='" + faculty + "'";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(DEPT, Hibernate.STRING)
				.addScalar(FACULTY, Hibernate.STRING)
				.addScalar(TID, Hibernate.STRING)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(COURSETYPE, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.INTEGER)
				.addScalar(NUM, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List showByCnameY(String cname, String xn) {
		String sql = "SELECT DISTINCT cc.XN,cc.XQ,Dept,faculty,cc.TID,dbo.Teacher.TName,cc.CID,cc.CName,cc.CourseType,"
				+ "(SELECT SumScore/Number FROM dbo.TeaEvalRes "
				+ "WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS SumAvg,"
				+ "(SELECT Number FROM dbo.TeaEvalRes "
				+ "WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS Num "
				+ "FROM dbo.Teacher RIGHT JOIN dbo.ChooseClass AS cc ON dbo.Teacher.TID = cc.TID LEFT JOIN dbo.TeaEvalRes ON cc.CID = dbo.TeaEvalRes.CID AND cc.TID = dbo.TeaEvalRes.TID AND cc.XN = dbo.TeaEvalRes.XN AND cc.XQ = dbo.TeaEvalRes.XQ "
				+ "WHERE dbo.Teacher.Dept='计算机科学与信息学院'" + " AND cc.CNAME='" + cname + "' AND cc.XN='" + xn + "'";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(DEPT, Hibernate.STRING)
				.addScalar(FACULTY, Hibernate.STRING)
				.addScalar(TID, Hibernate.STRING)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(COURSETYPE, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.INTEGER)
				.addScalar(NUM, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List showByCourseTypeF(String coursetype, String faculty) {
		String sql = "SELECT DISTINCT cc.XN,cc.XQ,Dept,faculty,cc.TID,dbo.Teacher.TName,cc.CID,cc.CName,cc.CourseType,"
				+ "(SELECT SumScore/Number FROM dbo.TeaEvalRes "
				+ "WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS SumAvg,"
				+ "(SELECT Number FROM dbo.TeaEvalRes "
				+ "WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS Num "
				+ "FROM dbo.Teacher RIGHT JOIN dbo.ChooseClass AS cc ON dbo.Teacher.TID = cc.TID LEFT JOIN dbo.TeaEvalRes ON cc.CID = dbo.TeaEvalRes.CID AND cc.TID = dbo.TeaEvalRes.TID AND cc.XN = dbo.TeaEvalRes.XN AND cc.XQ = dbo.TeaEvalRes.XQ "
				+ "WHERE dbo.Teacher.Dept='计算机科学与信息学院'" + " AND cc.CourseType='" + coursetype + "' AND dbo.Teacher.faculty='" + faculty + "'";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(DEPT, Hibernate.STRING)
				.addScalar(FACULTY, Hibernate.STRING)
				.addScalar(TID, Hibernate.STRING)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(COURSETYPE, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.INTEGER)
				.addScalar(NUM, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List showByCourseTypeY(String coursetype, String xn) {
		String sql = "SELECT DISTINCT cc.XN,cc.XQ,Dept,faculty,cc.TID,dbo.Teacher.TName,cc.CID,cc.CName,cc.CourseType,"
				+ "(SELECT SumScore/Number FROM dbo.TeaEvalRes "
				+ "WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS SumAvg,"
				+ "(SELECT Number FROM dbo.TeaEvalRes "
				+ "WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ) AS Num "
				+ "FROM dbo.Teacher RIGHT JOIN dbo.ChooseClass AS cc ON dbo.Teacher.TID = cc.TID LEFT JOIN dbo.TeaEvalRes ON cc.CID = dbo.TeaEvalRes.CID AND cc.TID = dbo.TeaEvalRes.TID AND cc.XN = dbo.TeaEvalRes.XN AND cc.XQ = dbo.TeaEvalRes.XQ "
				+ "WHERE dbo.Teacher.Dept='计算机科学与信息学院'" + " AND cc.CourseType='" + coursetype + "' AND cc.XN='" + xn + "'";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(XN, Hibernate.STRING)
				.addScalar(XQ, Hibernate.INTEGER)
				.addScalar(DEPT, Hibernate.STRING)
				.addScalar(FACULTY, Hibernate.STRING)
				.addScalar(TID, Hibernate.STRING)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(COURSETYPE, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.INTEGER)
				.addScalar(NUM, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List showFaculty() {
		String sql = "SELECT DISTINCT faculty FROM dbo.Teacher WHERE Dept='计算机科学与信息学院'";
		Query query = getSession().createSQLQuery(sql).addScalar(FACULTY,
				Hibernate.STRING);
		List list = query.list();
		return list;
	}
	
	public List showXn() {
		String sql = "SELECT DISTINCT XN FROM dbo.ChooseClass";
		Query query = getSession().createSQLQuery(sql).addScalar(XN,
				Hibernate.STRING);
		List list = query.list();
		return list;
	}
	
	public List showXnXq() {
		String sql = "SELECT DISTINCT XN,XQ FROM dbo.ChooseClass";
		Query query = getSession().createSQLQuery(sql).addScalar(XN,
				Hibernate.STRING).addScalar(XQ, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}
	
	public List<String> fillSelectList() {

		String sql = "SELECT dbo.Administrator.Name FROM dbo.Administrator";
		Query query = getSession().createSQLQuery(sql).addScalar(NAME,
				Hibernate.STRING);
		List selectList = query.list();

		return selectList;
	}

	public void save(Administrator transientInstance) {
		log.debug("saving Administrator instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Administrator persistentInstance) {
		log.debug("deleting Administrator instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Administrator findById(java.lang.Integer id) {
		log.debug("getting Administrator instance with id: " + id);
		try {
			Administrator instance = (Administrator) getSession().get(
					"com.ees.hibernate.Administrator", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Administrator instance) {
		log.debug("finding Administrator instance by example");
		try {
			List results = getSession()
					.createCriteria("com.ees.hibernate.Administrator")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Administrator instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Administrator as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List findAll() {
		log.debug("finding all Administrator instances");
		try {
			String queryString = "from Administrator";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Administrator merge(Administrator detachedInstance) {
		log.debug("merging Administrator instance");
		try {
			Administrator result = (Administrator) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Administrator instance) {
		log.debug("attaching dirty Administrator instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Administrator instance) {
		log.debug("attaching clean Administrator instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}