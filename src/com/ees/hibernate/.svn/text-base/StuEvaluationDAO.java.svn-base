package com.ees.hibernate;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * StuEvaluation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ees.hibernate.StuEvaluation
 * @author MyEclipse Persistence Tools
 */

public class StuEvaluationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StuEvaluationDAO.class);
	// property constants
	public static final String REASON = "reason";
	public static final String CNAME = "cname";

	public void save(StuEvaluation transientInstance) {
		log.debug("saving StuEvaluation instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StuEvaluation persistentInstance) {
		log.debug("deleting StuEvaluation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StuEvaluation findById(java.lang.String id) {
		log.debug("getting StuEvaluation instance with id: " + id);
		try {
			StuEvaluation instance = (StuEvaluation) getSession().get(
					"com.ees.hibernate.StuEvaluation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StuEvaluation instance) {
		log.debug("finding StuEvaluation instance by example");
		try {
			List results = getSession()
					.createCriteria("com.ees.hibernate.StuEvaluation")
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
		log.debug("finding StuEvaluation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StuEvaluation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByReason(Object reason) {
		return findByProperty(REASON, reason);
	}

	public List findByCname(Object cname) {
		return findByProperty(CNAME, cname);
	}

	public List findAll() {
		log.debug("finding all StuEvaluation instances");
		try {
			String queryString = "from StuEvaluation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StuEvaluation merge(StuEvaluation detachedInstance) {
		log.debug("merging StuEvaluation instance");
		try {
			StuEvaluation result = (StuEvaluation) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StuEvaluation instance) {
		log.debug("attaching dirty StuEvaluation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StuEvaluation instance) {
		log.debug("attaching clean StuEvaluation instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}