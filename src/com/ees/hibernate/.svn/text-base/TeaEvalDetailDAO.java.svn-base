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
 * TeaEvalDetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ees.hibernate.TeaEvalDetail
 * @author MyEclipse Persistence Tools
 */

public class TeaEvalDetailDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TeaEvalDetailDAO.class);

	// property constants

	public static final String MARKID = "MarkID";
	public static final String QID = "QID";
	public static final String QSCORE = "QScore";

	// property constants

	public List findEveryScores(int markId) {
		String sql = "SELECT QID,QScore FROM dbo.TeaEvalDetail WHERE MarkID="
				+ markId;
		Query query = getSession().createSQLQuery(sql)
				.addScalar(QID, Hibernate.STRING)
				.addScalar(QSCORE, Hibernate.STRING);
		List list=query.list();
		return list;
	}
	
	public void updateEvaluDetail(int markId,int qid,int qscore){
		Transaction tx=getSession().beginTransaction();
		String sql="UPDATE dbo.TeaEvalDetail SET QScore="+qscore+" WHERE MarkID="+markId+" AND QID="+qid;
		getSession().createSQLQuery(sql).executeUpdate();
		tx.commit();
	}

	public void save(TeaEvalDetail transientInstance) {
		log.debug("saving TeaEvalDetail instance");
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

	public void delete(TeaEvalDetail persistentInstance) {
		log.debug("deleting TeaEvalDetail instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TeaEvalDetail findById(com.ees.hibernate.TeaEvalDetailId id) {
		log.debug("getting TeaEvalDetail instance with id: " + id);
		try {
			TeaEvalDetail instance = (TeaEvalDetail) getSession().get(
					"com.ees.hibernate.TeaEvalDetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TeaEvalDetail instance) {
		log.debug("finding TeaEvalDetail instance by example");
		try {
			List results = getSession()
					.createCriteria("com.ees.hibernate.TeaEvalDetail")
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
		log.debug("finding TeaEvalDetail instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TeaEvalDetail as model where model."
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
		log.debug("finding all TeaEvalDetail instances");
		try {
			String queryString = "from TeaEvalDetail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TeaEvalDetail merge(TeaEvalDetail detachedInstance) {
		log.debug("merging TeaEvalDetail instance");
		try {
			TeaEvalDetail result = (TeaEvalDetail) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TeaEvalDetail instance) {
		log.debug("attaching dirty TeaEvalDetail instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TeaEvalDetail instance) {
		log.debug("attaching clean TeaEvalDetail instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}