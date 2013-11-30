package com.ees.hibernate;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * MailReply entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ees.hibernate.MailReply
 * @author MyEclipse Persistence Tools
 */

public class MailReplyDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MailReplyDAO.class);
	// property constants
	public static final String TH_ID = "thId";
	public static final String REPLY = "reply";
	public static final String IS_FROM_STU = "isFromStu";

	public void save(MailReply transientInstance) {
		log.debug("saving MailReply instance");
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

	public void delete(MailReply persistentInstance) {
		log.debug("deleting MailReply instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MailReply findById(java.lang.Integer id) {
		log.debug("getting MailReply instance with id: " + id);
		try {
			MailReply instance = (MailReply) getSession().get(
					"com.ees.hibernate.MailReply", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MailReply instance) {
		log.debug("finding MailReply instance by example");
		try {
			List results = getSession()
					.createCriteria("com.ees.hibernate.MailReply")
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
		log.debug("finding MailReply instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from MailReply as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByThId(Object thId) {
		return findByProperty(TH_ID, thId);
	}

	public List findByReply(Object reply) {
		return findByProperty(REPLY, reply);
	}

	public List findByIsFromStu(Object isFromStu) {
		return findByProperty(IS_FROM_STU, isFromStu);
	}

	public List findAll() {
		log.debug("finding all MailReply instances");
		try {
			String queryString = "from MailReply";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MailReply merge(MailReply detachedInstance) {
		log.debug("merging MailReply instance");
		try {
			MailReply result = (MailReply) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MailReply instance) {
		log.debug("attaching dirty MailReply instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MailReply instance) {
		log.debug("attaching clean MailReply instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}