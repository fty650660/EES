package com.ees.hibernate;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TeaQuestionnaire entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ees.hibernate.TeaQuestionnaire
 * @author MyEclipse Persistence Tools
 */

public class TeaQuestionnaireDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TeaQuestionnaireDAO.class);
	// property constants
	public static final String CONTENT = "content";
	public static final String WEIGHT = "weight";

	public void save(TeaQuestionnaire transientInstance) {
		log.debug("saving TeaQuestionnaire instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TeaQuestionnaire persistentInstance) {
		log.debug("deleting TeaQuestionnaire instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TeaQuestionnaire findById(java.lang.Integer id) {
		log.debug("getting TeaQuestionnaire instance with id: " + id);
		try {
			TeaQuestionnaire instance = (TeaQuestionnaire) getSession().get(
					"com.ees.hibernate.TeaQuestionnaire", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TeaQuestionnaire instance) {
		log.debug("finding TeaQuestionnaire instance by example");
		try {
			List results = getSession()
					.createCriteria("com.ees.hibernate.TeaQuestionnaire")
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
		log.debug("finding TeaQuestionnaire instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TeaQuestionnaire as model where model."
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

	public List findByWeight(Object weight) {
		return findByProperty(WEIGHT, weight);
	}

	public List findAll() {
		log.debug("finding all TeaQuestionnaire instances");
		try {
			String queryString = "from TeaQuestionnaire";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TeaQuestionnaire merge(TeaQuestionnaire detachedInstance) {
		log.debug("merging TeaQuestionnaire instance");
		try {
			TeaQuestionnaire result = (TeaQuestionnaire) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TeaQuestionnaire instance) {
		log.debug("attaching dirty TeaQuestionnaire instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TeaQuestionnaire instance) {
		log.debug("attaching clean TeaQuestionnaire instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}