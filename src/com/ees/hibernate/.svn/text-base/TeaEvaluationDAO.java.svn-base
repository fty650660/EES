package com.ees.hibernate;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TeaEvaluation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ees.hibernate.TeaEvaluation
 * @author MyEclipse Persistence Tools
 */

public class TeaEvaluationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TeaEvaluationDAO.class);
	// property constants
	public static final String XN = "xn";
	public static final String XQ = "xq";
	public static final String CNAME = "cname";
	public static final String REASON = "reason";
	public static final String DEPT = "dept";
	public static final String TEA_CLASS = "teaClass";
	public static final String COURSE_TYPE = "courseType";
	public static final String AGE_LEVEL = "ageLevel";
	public static final String TEA_TIME = "teaTime";
	public static final String TEA_PLACE = "teaPlace";

	public static final String MARKID = "MarkID";
	private static final String CLASS_NUM = null;

	public int findMarkID(String teaid, String lisid, String cid) {
		String sql = "SELECT dbo.TeaEvaluation.MarkID FROM dbo.TeaEvaluation WHERE TeaTID='"
				+ teaid + "' AND LisTID='" + lisid + "' AND CID='" + cid + "'";
		Query query = getSession().createSQLQuery(sql).addScalar(MARKID,
				Hibernate.INTEGER);
		List markIdList = query.list();
		return (Integer) markIdList.get(0);
	}

	public List evaluIsExist(String teaid, String lisid, String cid, String xn, int xq, int classnum) {
		String sql = "SELECT MarkID FROM dbo.TeaEvaluation WHERE TeaTID='"
				+ teaid + "' AND LisTID='" + lisid + "' AND CID='" + cid + "' AND XN='"+ xn 
				+ "' AND XQ=" + xq + " AND ClassNum=" + classnum;
		Query query = getSession().createSQLQuery(sql).addScalar(MARKID,
				Hibernate.INTEGER);
		List list = query.list();

		return list;
	}

	public void updateEvaluation(String teaclass, String agelevel,
			String teatime, String teaplace, String reason, int markId) {
		Transaction tx = getSession().beginTransaction();
		String sql = "UPDATE dbo.TeaEvaluation SET TeaClass='" + teaclass
				+ "',AgeLevel='" + agelevel + "',TeaTime='" + teatime
				+ "',TeaPlace='" + teaplace + "',Reason='" + reason
				+ "' WHERE MarkID=" + markId;
		getSession().createSQLQuery(sql).executeUpdate();
		tx.commit();
	}

	public void save(TeaEvaluation transientInstance) {
		log.debug("saving TeaEvaluation instance");
		Transaction tx = getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		tx.commit();
	}

	public void delete(TeaEvaluation persistentInstance) {
		log.debug("deleting TeaEvaluation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TeaEvaluation findById(java.lang.Integer id) {
		log.debug("getting TeaEvaluation instance with id: " + id);
		try {
			TeaEvaluation instance = (TeaEvaluation) getSession().get(
					"com.ees.hibernate.TeaEvaluation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TeaEvaluation instance) {
		log.debug("finding TeaEvaluation instance by example");
		try {
			List results = getSession()
					.createCriteria("com.ees.hibernate.TeaEvaluation")
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
		log.debug("finding TeaEvaluation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TeaEvaluation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByXn(Object xn) {
		return findByProperty(XN, xn);
	}

	public List findByXq(Object xq) {
		return findByProperty(XQ, xq);
	}

	public List findByClassNum(Object classNum) {
		return findByProperty(CLASS_NUM, classNum);
	}

	public List findByCname(Object cname) {
		return findByProperty(CNAME, cname);
	}

	public List findByReason(Object reason) {
		return findByProperty(REASON, reason);
	}

	public List findByDept(Object dept) {
		return findByProperty(DEPT, dept);
	}

	public List findByTeaClass(Object teaClass) {
		return findByProperty(TEA_CLASS, teaClass);
	}

	public List findByCourseType(Object courseType) {
		return findByProperty(COURSE_TYPE, courseType);
	}

	public List findByAgeLevel(Object ageLevel) {
		return findByProperty(AGE_LEVEL, ageLevel);
	}

	public List findByTeaTime(Object teaTime) {
		return findByProperty(TEA_TIME, teaTime);
	}

	public List findByTeaPlace(Object teaPlace) {
		return findByProperty(TEA_PLACE, teaPlace);
	}

	public List findAll() {
		log.debug("finding all TeaEvaluation instances");
		try {
			String queryString = "from TeaEvaluation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TeaEvaluation merge(TeaEvaluation detachedInstance) {
		log.debug("merging TeaEvaluation instance");
		try {
			TeaEvaluation result = (TeaEvaluation) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TeaEvaluation instance) {
		log.debug("attaching dirty TeaEvaluation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TeaEvaluation instance) {
		log.debug("attaching clean TeaEvaluation instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}