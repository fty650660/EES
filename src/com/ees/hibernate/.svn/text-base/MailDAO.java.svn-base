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
 * A data access object (DAO) providing persistence and search support for Mail
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ees.hibernate.Mail
 * @author MyEclipse Persistence Tools
 */

public class MailDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MailDAO.class);
	// property constants
	public static final String THID = "thid";
	
	public static final String SID = "sid";
	public static final String SNAME = "sname";
	public static final String TID = "tid";
	public static final String TNAME = "tname";
	public static final String THEME = "theme";
	public static final String DETAILS = "details";
	public static final String IS_FROM_TEA = "is_From_Tea";
	// 一定要谨记！！！ 在写对应的包含下划线的属性名的时候一定要把下划线写上
	// 从这个问题中可以看出Hibernate的SQL查询方式是不经过ORM这个工序的！
	public static final String SUB_TIME = "sub_Time";
	public static final String CLNAME = "clname";

	public List findMails(String ID) {

		String sql = "SELECT dbo.Mail.ThID,dbo.Mail.TName,dbo.Mail.Theme,dbo.Mail.SName,dbo.Student.CLName,dbo.Mail.Sub_Time "
				+ "FROM dbo.Mail,dbo.Student "
				+ "WHERE dbo.Mail.SID=dbo.Student.SID AND dbo.Mail.TID=" + ID;

		Query query = getSession().createSQLQuery(sql)
				.addScalar(THID, Hibernate.INTEGER)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(THEME, Hibernate.STRING)
				.addScalar(SNAME, Hibernate.STRING)
				.addScalar(CLNAME, Hibernate.STRING)
				.addScalar(SUB_TIME, Hibernate.DATE);

		List mailLists = query.list();
		return mailLists;
	}

	public List filterByName(String ID, String Name) {

		String sql = "SELECT dbo.Mail.ThID,dbo.Mail.TName,dbo.Mail.Theme,dbo.Mail.SName,dbo.Student.CLName,dbo.Mail.Sub_Time "
				+ "FROM dbo.Mail,dbo.Student "
				+ "WHERE dbo.Mail.SID=dbo.Student.SID AND dbo.Mail.TID="
				+ ID
				+ " AND dbo.Mail.SName LIKE '" + Name + "'";

		Query query = getSession().createSQLQuery(sql)
				.addScalar(THID, Hibernate.INTEGER)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(THEME, Hibernate.STRING)
				.addScalar(SNAME, Hibernate.STRING)
				.addScalar(CLNAME, Hibernate.STRING)
				.addScalar(SUB_TIME, Hibernate.DATE);

		List mailLists = query.list();
		return mailLists;
	}

	public List filterByClass(String ID, String Name) {
		String sql = "SELECT dbo.Mail.ThID,dbo.Mail.TName,dbo.Mail.Theme,dbo.Mail.SName,dbo.Student.CLName,dbo.Mail.Sub_Time "
				+ "FROM dbo.Mail,dbo.Student "
				+ "WHERE dbo.Mail.SID=dbo.Student.SID AND dbo.Mail.TID="
				+ ID
				+ " AND dbo.Student.CLName LIKE '" + Name + "'";

		Query query = getSession().createSQLQuery(sql)
				.addScalar(THID, Hibernate.INTEGER)
				.addScalar(TNAME, Hibernate.STRING)
				.addScalar(THEME, Hibernate.STRING)
				.addScalar(SNAME, Hibernate.STRING)
				.addScalar(CLNAME, Hibernate.STRING)
				.addScalar(SUB_TIME, Hibernate.DATE);

		List mailLists = query.list();
		return mailLists;
	}

	public void save(Mail transientInstance) {
		log.debug("saving Mail instance");
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

	public void delete(Mail persistentInstance) {
		log.debug("deleting Mail instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Mail findById(java.lang.Integer id) {
		log.debug("getting Mail instance with id: " + id);
		try {
			Mail instance = (Mail) getSession().get("com.ees.hibernate.Mail",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Mail instance) {
		log.debug("finding Mail instance by example");
		try {
			List results = getSession()
					.createCriteria("com.ees.hibernate.Mail")
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
		log.debug("finding Mail instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Mail as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySid(Object sid) {
		return findByProperty(SID, sid);
	}

	public List findBySname(Object sname) {
		return findByProperty(SNAME, sname);
	}

	public List findByTid(Object tid) {
		return findByProperty(TID, tid);
	}

	public List findByTname(Object tname) {
		return findByProperty(TNAME, tname);
	}

	public List findByTheme(Object theme) {
		return findByProperty(THEME, theme);
	}

	public List findByDetails(Object details) {
		return findByProperty(DETAILS, details);
	}

	public List findByIsFromTea(Object isFromTea) {
		return findByProperty(IS_FROM_TEA, isFromTea);
	}

	public List findAll() {
		log.debug("finding all Mail instances");
		try {
			String queryString = "from Mail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Mail merge(Mail detachedInstance) {
		log.debug("merging Mail instance");
		try {
			Mail result = (Mail) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Mail instance) {
		log.debug("attaching dirty Mail instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Mail instance) {
		log.debug("attaching clean Mail instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}