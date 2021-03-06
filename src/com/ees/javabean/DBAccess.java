package com.ees.javabean;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.Entity;

@Entity
public class DBAccess {

	private String drv = "com.microsoft.jdbc.sqlserver.SQLServerDriver";

	private String url = "jdbc:sqlserver://localhost:1433;databaseName=EES1;";

	private String usr = "sa";

	private String pwd = "12345";

	private Connection conn = null;

	private Statement stm = null;

	private ResultSet rs = null;

	public boolean createConn() {
		boolean b = false;
		try {
			Class.forName(drv).newInstance();
			conn = DriverManager.getConnection(url, usr, pwd);
			b = true;
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		return b;
	}

	public boolean update(String sql) {
		boolean b = false;
		try {
			stm = conn.createStatement();
			stm.execute(sql);
			b = true;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return b;
	}
	
	public String updateWithPro(String sid,String cid,String Reason,String CName) {
		boolean b = false;
		try {
			CallableStatement stm = conn.prepareCall("{call check_user(?,?,?,?)}");
			//CallableStatement stm = conn.prepareCall("EXECUTE check_user N'"+sid+"', N'"+cid+"',N'"+Reason+"', N'"+CName+"',N'';");
			stm.setString(1, sid);
			stm.setString(2, cid);
			stm.setString(3, Reason);
			stm.setString(4, CName);
			stm.execute();
			rs = stm.getResultSet();
			if (rs!=null) {
				b = true;
				return convertResultSetToArrayList(rs).get(0).toString();
				
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}
	
	public int updateReturnId(String sql) {
		int id=0;
		//sql="INSERT INTO dbo.StuEvaluation ( SID, CID, Reason, CName ) VALUES  ( '070712110117','071210T290', 'gfhjlkhjl', 'null') SELECT @@IDENTITY AS SEQUENCE";
		try {
			stm = conn.createStatement();
			stm.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			rs = stm.getGeneratedKeys();      //ResultSet 指示键值
			rs.next();
			id = rs.getInt(1);     //得到第一个键值
			rs.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return id;
	}
	
	
	private ArrayList<HashMap<Object, Object>> convertResultSetToArrayList(
			ResultSet rs) throws Exception {
		// 获取rs 集合信息对象
		ResultSetMetaData rsmd = rs.getMetaData();
		// 创建数组列表集合对象
		ArrayList<HashMap<Object, Object>> tempList = new ArrayList<HashMap<Object, Object>>();
		HashMap<Object, Object> tempHash = null;
		// 填充数组列表集合
		while (rs.next()) {
			// 创建键值对集合对象
			tempHash = new HashMap<Object, Object>();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				// 遍历每列数据，以键值形式存在对象tempHash中
				tempHash.put(rsmd.getColumnName(i + 1).toUpperCase(), rs
						.getString(rsmd.getColumnName(i + 1)));
			}
			// 第一个键值对，存储在tempList列表集合对象中
			tempList.add(tempHash);
		}
		return tempList;// 返回填充完毕的数组列表集合对象
	}
	
	
	
	
public ArrayList<HashMap<Object, Object>> executeSql(String strSql)
	throws Exception {

stm = conn.createStatement();
//logger.info("###############::执行SQL语句操作(查询数据):" + strSql);
rs = stm.executeQuery(strSql);
conn.commit();
if (null != rs) {
	return convertResultSetToArrayList(rs);
}
return null;
}

	public void query(String sql) {
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
		} catch (Exception e) {
		}
	}
	
	public String getvalquery(String sql) {
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			String re=getValue("Weight");
			return re;
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean next() {
		boolean b = false;
		try {
			if(rs.next())b = true;
		} catch (Exception e) {
		}
		return b;		
	}
	
	public String getValue(String field) {
		String value = null;
		try {
			if(rs!=null)value = rs.getString(0);
		} catch (Exception e) {
		}
		return value;
	}

	public void closeConn() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
		}
	}

	public void closeStm() {
		try {
			if (stm != null)
				stm.close();
		} catch (SQLException e) {
		}
	}

	public void closeRs() {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getDrv() {
		return drv;
	}

	public void setDrv(String drv) {
		this.drv = drv;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public Statement getStm() {
		return stm;
	}

	public void setStm(Statement stm) {
		this.stm = stm;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}
}
