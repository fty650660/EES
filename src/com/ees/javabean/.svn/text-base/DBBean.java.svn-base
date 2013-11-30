package com.ees.javabean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ees.javabean.DBAccess;
import com.sun.org.apache.regexp.internal.recompile;
import javax.persistence.Entity;

@Entity
public class DBBean {
//数据库验证用户信息
	public boolean valid(String uid, String password) {
		boolean isValid = false;
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			String sql = "SELECT * FROM dbo.Student WHERE SID='"+uid+"' and password='"+password+"'";
			db.query(sql);
			if(db.next()) {
				isValid = true;
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return isValid;
	}
	
	public boolean validTeacher(String uid, String password) {
		boolean isValid = false;
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			String sql = "SELECT* FROM dbo.Teacher WHERE TID='"+uid+"' and password='"+password+"'";
			db.query(sql);
			if(db.next()) {
				isValid = true;
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return isValid;
	}
	
	public boolean validAdmin(String uid, String password) {
		boolean isValid = false;
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			String sql = "SELECT * FROM dbo.Administrator WHERE Name='"+uid+"' and password='"+password+"'";
			db.query(sql);
			if(db.next()) {
				isValid = true;
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return isValid;
	}
	
	public boolean isExist(String username) {
		boolean isExist = false;
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			String sql = "select * from user where username='"+username+"'";
			db.query(sql);
			if(db.next()) {
				isExist = true;
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return isExist;
	}
	
	public boolean isExistBySql(String sql) {
		boolean isExist = false;
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			db.query(sql);
			if(db.next()) {
				isExist = true;
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return isExist;
	}
	
	public boolean query(String sql) {
		boolean isExist = false;
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			db.query(sql);
			if(db.next()) {
				isExist = true;
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return isExist;
	}
	
	public ArrayList<HashMap<Object, Object>> execute(String strSql)
	throws Exception {
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			ArrayList<HashMap<Object, Object>> list=db.executeSql(strSql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
			return list;
		}
		return null;
	}
	
	public String getValue(String strSql)
	throws Exception {
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			String value=db.getvalquery(strSql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
			return value;
		}
		return null;
	}
	
	public void add(int id, int QId,String QScore) {
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			String sql="INSERT dbo.StuEvalDetail ( MarkID, QID, QScore ) VALUES  ( "+id+","+QId+","+QScore+")";
			db.update(sql);
			db.closeStm();
			db.closeConn();
		}
	}
	
	public int addTurnId(String id, String cid,String Reason,String CName,String Cno) {
		DBAccess db = new DBAccess();
		int turnId=0;
		if(db.createConn()) {
			String sql="INSERT INTO dbo.StuEvaluation ( SID, CID, Reason, CName, ClassNum ) VALUES " +
				" ( '"+id+"','"+cid+"', '"+Reason+"', '"+CName+"','"+Cno+"')";
			 turnId=db.updateReturnId(sql);
			db.closeStm();
			db.closeConn();
		}
		return turnId;
	}
	
	public boolean add(String sql){
		DBAccess db=new DBAccess();
		boolean a=false;
		if (db.createConn()) {
			a=db.update(sql);
			db.closeStm();
			db.closeConn();
		}
		return a;
	}
}
