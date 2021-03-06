package com.ees.hibernate;

import java.util.List;

import net.sf.cglib.transform.impl.AddStaticInitTransformer;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Teacher entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.ees.hibernate.Teacher
  * @author MyEclipse Persistence Tools 
 */

public class TeacherDAO extends BaseHibernateDAO  {
	private static final Logger log = LoggerFactory.getLogger(TeacherDAO.class);
	// property constants
	public static final String TID = "TID";
	public static final String CID = "CID";
	public static final String CNAME = "CNAME";
	public static final String COURSETYPE = "CourseType";

	public static final String TNAME = "tname";
	public static final String PASSWORD = "password";
	public static final String DEPT = "dept";
	public static final String FACULT = "faculty";
	 	
	public static final String XN = "XN";
	public static final String XQ = "XQ";
	public static final String CLASSNUM = "ClassNum";
	public static final String ISEVALU = "isEvalu";
	public static final String TITLE="Title";

	 	public List findCourseList(String tid) {
//	 		String sql = "SELECT DISTINCT dbo.Teacher.TID,dbo.Teacher.TName,dbo.Teacher.Dept,dbo.Teacher.faculty,"
//	 				+ "dbo.ChooseClass.XN,dbo.ChooseClass.XQ,dbo.Course.CID,dbo.Course.CNAME,dbo.ChooseClass.ClassNum,dbo.ChooseClass.CourseType "
//	 				+ "FROM dbo.Teacher,dbo.Course,dbo.ChooseClass WHERE dbo.Teacher.TID=dbo.ChooseClass.TID AND dbo.ChooseClass.CID=dbo.Course.CID "
//	 				+ "AND faculty IN (SELECT dbo.Teacher.faculty FROM dbo.Teacher WHERE TID='"
//	 				+ tid + "') AND dbo.ChooseClass.TID !='" + tid + "'";
		String sql = "SELECT DISTINCT dbo.Teacher.TID,dbo.Teacher.TName,dbo.Teacher.Title,dbo.Teacher.Dept,dbo.Teacher.faculty," +
				"cc.XN,cc.XQ,cc.CID,cc.CNAME,cc.ClassNum,cc.CourseType," +
				"(SELECT MarkID FROM dbo.TeaEvaluation " +
				"WHERE dbo.TeaEvaluation.TeaTID=cc.TID AND dbo.TeaEvaluation.CID=cc.CID AND " +
				"dbo.TeaEvaluation.XN=cc.XN AND dbo.TeaEvaluation.XQ=cc.XQ AND dbo.TeaEvaluation.ClassNum=cc.ClassNum AND LisTID='"+tid+"') AS isEvalu " +
				"FROM dbo.Teacher LEFT JOIN dbo.ChooseClass AS cc ON dbo.Teacher.TID = cc.TID " +
				"WHERE faculty IN (SELECT dbo.Teacher.faculty FROM dbo.Teacher WHERE TID='"+tid+"') AND cc.TID !='"+tid+"'";
  
	 		Query query = getSession().createSQLQuery(sql)
	 				.addScalar(TID, Hibernate.STRING)
	 				.addScalar(TNAME, Hibernate.STRING)
	 				.addScalar(TITLE,Hibernate.STRING)
	 				.addScalar(DEPT, Hibernate.STRING)
	 				.addScalar(FACULT, Hibernate.STRING)
	 				.addScalar(XN, Hibernate.STRING)
	 				.addScalar(XQ, Hibernate.INTEGER)
	 				.addScalar(CID, Hibernate.STRING)
	 				.addScalar(CNAME, Hibernate.STRING)
	 				.addScalar(CLASSNUM, Hibernate.INTEGER)
	 				.addScalar(COURSETYPE, Hibernate.STRING)
	 				.addScalar(ISEVALU, Hibernate.INTEGER);
	 		List courselist = query.list();
	 		return courselist;
	 	}

	 	public List findMyCourse(String tid) {
	 		String sql = "SELECT DISTINCT dbo.Teacher.Dept,dbo.Teacher.faculty,cc.XN,cc.XQ,dbo.Teacher.TID,dbo.Teacher.TName,cc.CID,cc.CNAME,cc.CourseType," +
	 				"(SELECT TID FROM dbo.TeaEvalRes WHERE dbo.TeaEvalRes.TID=cc.TID AND dbo.TeaEvalRes.CID=cc.CID AND dbo.TeaEvalRes.XN=cc.XN AND dbo.TeaEvalRes.XQ=cc.XQ ) AS ISEVALU" +
	 				" FROM dbo.TeaEvalRes RIGHT JOIN dbo.ChooseClass AS cc ON dbo.TeaEvalRes.CID = cc.CID AND dbo.TeaEvalRes.TID = cc.TID AND " +
	 				"dbo.TeaEvalRes.XN = cc.XN AND dbo.TeaEvalRes.XQ = cc.XQ LEFT JOIN dbo.Teacher ON cc.TID = dbo.Teacher.TID WHERE dbo.Teacher.TID='"+tid+"'";
	 		Query query = getSession().createSQLQuery(sql)
	 				.addScalar(DEPT, Hibernate.STRING)
	 				.addScalar(FACULT, Hibernate.STRING)
	 				.addScalar(XN, Hibernate.STRING)
	 				.addScalar(XQ, Hibernate.INTEGER)
	 				.addScalar(TID, Hibernate.STRING)
	 				.addScalar(TNAME, Hibernate.STRING)
	 				.addScalar(CID, Hibernate.STRING)
	 				.addScalar(CNAME, Hibernate.STRING)
	 				.addScalar(COURSETYPE, Hibernate.STRING)
	 				.addScalar(ISEVALU, Hibernate.STRING);
	 		List list=query.list();
	 		return list;
	 	}

	public List findTeacher(String tid, String passwd) {
		String sql = "SELECT TName FROM dbo.Teacher WHERE TID='" + tid
				+ "' AND Password='" + passwd + "'";
		Query query = getSession().createSQLQuery(sql).addScalar(TNAME,
				Hibernate.STRING);
		List list = query.list();
		return list;
	}

    
    public void save(Teacher transientInstance) {
        log.debug("saving Teacher instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Teacher persistentInstance) {
        log.debug("deleting Teacher instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Teacher findById( java.lang.String id) {
        log.debug("getting Teacher instance with id: " + id);
        try {
            Teacher instance = (Teacher) getSession()
                    .get("com.ees.hibernate.Teacher", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Teacher instance) {
        log.debug("finding Teacher instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.ees.hibernate.Teacher")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Teacher instance with property: " + propertyName
            + ", va l ue: " + value);
      try {
         String queryString = "from Teacher as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTname(Object tname
	) {
		return findByProperty(TNAME, tname
		);
	}
	
	public List findByPassword(Object password
	) {
		return findByProperty(PASSWORD, password
		);
	}
	
	public List findByDept(Object dept
	) {
		return findByProperty(DEPT, dept
		);
	}
	
	public List findByFaculty(Object faculty
	) {
		return findByProperty(FACULT, faculty
		);
	}
	

	public List findAll() {
		log.debug("finding all Teacher instances");
		try {
			String queryString = "from Teacher";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Teacher merge(Teacher detachedInstance) {
        log.debug("merging Teacher instance");
        try {
            Teacher result = (Teacher) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Teacher instance) {
        log.debug("attaching dirty Teacher instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Teacher instance) {
        log.debug("attaching clean Teacher instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}