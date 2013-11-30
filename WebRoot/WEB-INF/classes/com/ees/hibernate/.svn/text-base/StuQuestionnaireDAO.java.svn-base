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
 * StuQuestionnaire entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ees.hibernate.StuQuestionnaire
 * @author MyEclipse Persistence Tools
 */

public class StuQuestionnaireDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StuQuestionnaireDAO.class);
	// property constants
	public static final String CONTENT = "content";
	public static final String CATEGORY = "category";
	public static final String WEIGHT = "weight";

	public void save(StuQuestionnaire transientInstance) {
		log.debug("saving StuQuestionnaire instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StuQuestionnaire persistentInstance) {
		log.debug("deleting StuQuestionnaire instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StuQuestionnaire findById(java.lang.Integer id) {
		log.debug("getting StuQuestionnaire instance with id: " + id);
		try {
			StuQuestionnaire instance = (StuQuestionnaire) getSession().get(
					"com.ees.hibernate.StuQuestionnaire", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StuQuestionnaire instance) {
		log.debug("finding StuQuestionnaire instance by example");
		try {
			List results = getSession()
					.createCriteria("com.ees.hibernate.StuQuestionnaire")
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
		log.debug("finding StuQuestionnaire instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StuQuestionnaire as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByCategory(Object category) {
		return findByProperty(CATEGORY, category);
	}

	public List findByWeight(Object weight) {
		return findByProperty(WEIGHT, weight);
	}

	public List findAll() {
		log.debug("finding all StuQuestionnaire instances");
		try {
			String queryString = "from StuQuestionnaire";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StuQuestionnaire merge(StuQuestionnaire detachedInstance) {
		log.debug("merging StuQuestionnaire instance");
		try {
			StuQuestionnaire result = (StuQuestionnaire) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StuQuestionnaire instance) {
		log.debug("attaching dirty StuQuestionnaire instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StuQuestionnaire instance) {
		log.debug("attaching clean StuQuestionnaire instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}