package com.ees.hibernate;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * StuEvalRes entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ees.hibernate.StuEvalRes
 * @author MyEclipse Persistence Tools
 */

public class StuEvalResDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StuEvalResDAO.class);

	// property constants

	public void save(StuEvalRes transientInstance) {
		log.debug("saving StuEvalRes instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StuEvalRes persistentInstance) {
		log.debug("deleting StuEvalRes instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StuEvalRes findById(com.ees.hibernate.StuEvalResId id) {
		log.debug("getting StuEvalRes instance with id: " + id);
		try {
			StuEvalRes instance = (StuEvalRes) getSession().get(
					"com.ees.hibernate.StuEvalRes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StuEvalRes instance) {
		log.debug("finding StuEvalRes instance by example");
		try {
			List results = getSession()
					.createCriteria("com.ees.hibernate.StuEvalRes")
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
		log.debug("finding StuEvalRes instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from StuEvalRes as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all StuEvalRes instances");
		try {
			String queryString = "from StuEvalRes";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StuEvalRes merge(StuEvalRes detachedInstance) {
		log.debug("merging StuEvalRes instance");
		try {
			StuEvalRes result = (StuEvalRes) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StuEvalRes instance) {
		log.debug("attaching dirty StuEvalRes instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StuEvalRes instance) {
		log.debug("attaching clean StuEvalRes instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}