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
 * TeaEvalRes entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ees.hibernate.TeaEvalRes
 * @author MyEclipse Persistence Tools
 */

public class TeaEvalResDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TeaEvalResDAO.class);

	// property constants

	private static final String SUMSCORE = "SumScore";

	private static final String TNAME = "TName";
	private static final String CNAME = "CName";
	private static final String CID = "CID";
	private static final String Q1AVG = "Q1avg";
	private static final String Q2AVG = "Q2avg";
	private static final String Q3AVG = "Q3avg";
	private static final String Q4AVG = "Q4avg";
	private static final String Q5AVG = "Q5avg";
	private static final String Q6AVG = "Q6avg";
	private static final String Q7AVG = "Q7avg";
	private static final String Q8AVG = "Q8avg";
	private static final String Q9AVG = "Q9avg";
	private static final String Q10AVG = "Q10avg";
	private static final String Q11AVG = "Q11avg";
	private static final String SUMAVG = "Sumavg";
	private static final String NUMBER = "Number";

	public void updateRes(String q1, String q2, String q3, String q4,
			String q5, String q6, String q7, String q8, String q9, String q10,
			String q11, String sumscore, int number, String teaid, String cid,
			String xn, int xq) {
		Transaction tx = getSession().beginTransaction();
		String sql = "UPDATE dbo.TeaEvalRes SET Q1+=" + q1 + ",Q2+=" + q2
				+ ",Q3+=" + q3 + ",Q4+=" + q4 + ",Q5+=" + q5 + ",Q6+=" + q6
				+ ",Q7+=" + q7 + ",Q8+=" + q8 + ",Q9+=" + q9 + ",Q10+=" + q10
				+ ",Q11+=" + q11 + ",SumScore+=" + sumscore + ",Number+="
				+ number + " WHERE TID='" + teaid + "' AND CID='" + cid
				+ "' AND XN='" + xn + "' AND XQ=" + xq;
		getSession().createSQLQuery(sql).executeUpdate();
		tx.commit();
		// getSession().close();
	}

	public List oneCourseScores(String teaid, String cid, String xn, int xq) {
		String sql = "SELECT CName,CID,Q1/Number AS Q1avg, Q2/Number AS Q2avg, Q3/Number AS Q3avg, "
				+ "Q4/Number AS Q4avg, Q5/Number AS Q5avg,Q6/Number AS Q6avg,"
				+ "Q7/Number AS Q7avg,Q8/Number AS Q8avg,Q9/Number AS Q9avg,Q10/Number AS Q10avg,"
				+ "Q11/Number AS Q11avg,SumScore/Number AS Sumavg,Number,TName "
				+ "FROM dbo.TeaEvalRes,dbo.Teacher "
				+ "WHERE dbo.TeaEvalRes.TID=dbo.Teacher.TID AND dbo.TeaEvalRes.TID='"
				+ teaid
				+ "' AND CID LIKE '%"
				+ cid
				+ "%' AND dbo.TeaEvalRes.XN='"
				+ xn
				+ "' AND dbo.TeaEvalRes.XQ=" + xq;
		Query query = getSession().createSQLQuery(sql)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(Q1AVG, Hibernate.STRING)
				.addScalar(Q2AVG, Hibernate.STRING)
				.addScalar(Q3AVG, Hibernate.STRING)
				.addScalar(Q4AVG, Hibernate.STRING)
				.addScalar(Q5AVG, Hibernate.STRING)
				.addScalar(Q6AVG, Hibernate.STRING)
				.addScalar(Q7AVG, Hibernate.STRING)
				.addScalar(Q8AVG, Hibernate.STRING)
				.addScalar(Q9AVG, Hibernate.STRING)
				.addScalar(Q10AVG, Hibernate.STRING)
				.addScalar(Q11AVG, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.STRING)
				.addScalar(NUMBER, Hibernate.INTEGER)
				.addScalar(TNAME, Hibernate.STRING);
		List list = query.list();
		return list;
	}

	public List courseScores(String teaid, String cid) {
		String sql = "SELECT CName,CID,Q1/Number AS Q1avg, Q2/Number AS Q2avg, Q3/Number AS Q3avg, "
				+ "Q4/Number AS Q4avg, Q5/Number AS Q5avg,Q6/Number AS Q6avg,"
				+ "Q7/Number AS Q7avg,Q8/Number AS Q8avg,Q9/Number AS Q9avg,Q10/Number AS Q10avg,"
				+ "Q11/Number AS Q11avg,SumScore/Number AS Sumavg,Number "
				+ "FROM dbo.TeaEvalRes,dbo.Teacher "
				+ "WHERE dbo.TeaEvalRes.TID=dbo.Teacher.TID AND dbo.TeaEvalRes.TID='"
				+ teaid + "' AND CID LIKE '%" + cid + "%'";
		Query query = getSession().createSQLQuery(sql)
				.addScalar(CNAME, Hibernate.STRING)
				.addScalar(CID, Hibernate.STRING)
				.addScalar(Q1AVG, Hibernate.STRING)
				.addScalar(Q2AVG, Hibernate.STRING)
				.addScalar(Q3AVG, Hibernate.STRING)
				.addScalar(Q4AVG, Hibernate.STRING)
				.addScalar(Q5AVG, Hibernate.STRING)
				.addScalar(Q6AVG, Hibernate.STRING)
				.addScalar(Q7AVG, Hibernate.STRING)
				.addScalar(Q8AVG, Hibernate.STRING)
				.addScalar(Q9AVG, Hibernate.STRING)
				.addScalar(Q10AVG, Hibernate.STRING)
				.addScalar(Q11AVG, Hibernate.STRING)
				.addScalar(SUMAVG, Hibernate.STRING)
				.addScalar(NUMBER, Hibernate.INTEGER);
		List list = query.list();
		return list;
	}

	// property constants
	public Boolean findIsExist(String teaid, String cid, String xn, int xq) {
		String sql = "SELECT SumScore FROM dbo.TeaEvalRes WHERE TID='" + teaid
				+ "' AND CID='" + cid + "' AND XN='" + xn + "' AND XQ=" + xq;
		Query query = getSession().createSQLQuery(sql).addScalar(SUMSCORE,
				Hibernate.STRING);
		List list = query.list();
		if (!list.isEmpty())
			return true;
		else
			return false;
	}

	public void save(TeaEvalRes transientInstance) {
		log.debug("saving TeaEvalRes instance");
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

	public void delete(TeaEvalRes persistentInstance) {
		log.debug("deleting TeaEvalRes instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TeaEvalRes findById(com.ees.hibernate.TeaEvalResId id) {
		log.debug("getting TeaEvalRes instance with id: " + id);
		try {
			TeaEvalRes instance = (TeaEvalRes) getSession().get(
					"com.ees.hibernate.TeaEvalRes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TeaEvalRes instance) {
		log.debug("finding TeaEvalRes instance by example");
		try {
			List results = getSession()
					.createCriteria("com.ees.hibernate.TeaEvalRes")
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
		log.debug("finding TeaEvalRes instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TeaEvalRes as model where model."
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
		log.debug("finding all TeaEvalRes instances");
		try {
			String queryString = "from TeaEvalRes";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TeaEvalRes merge(TeaEvalRes detachedInstance) {
		log.debug("merging TeaEvalRes instance");
		try {
			TeaEvalRes result = (TeaEvalRes) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TeaEvalRes instance) {
		log.debug("attaching dirty TeaEvalRes instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TeaEvalRes instance) {
		log.debug("attaching clean TeaEvalRes instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}