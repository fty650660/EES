/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.ees.struts.action;

import com.ees.hibernate.ChooseClass;
import com.ees.javabean.*;
import com.ees.hibernate.ChooseClassDAO;
import com.ees.hibernate.Course;
import com.ees.hibernate.StuEvaluation;
import com.ees.hibernate.StuEvaluationDAO;
import com.ees.hibernate.Student;
import com.ees.hibernate.StudentDAO;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



import com.ees.struts.action.BaseAction;
/** 
 * MyEclipse Struts
 * Creation date: 12-07-2011
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
@Entity
public  class StudentAction extends BaseAction { 
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */


	@Override
	public ActionForward doDefault(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	
			}
	
	
	public ActionForward getQuestionnaire(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("CID", request.getParameter("CID"));
		request.setAttribute("TID", request.getParameter("TID"));
		request.setAttribute("CNO", request.getParameter("CNO"));
		request.setAttribute("CName", request.getParameter("CName"));
		
		DBBean dbBean=new DBBean();
		String sql="SELECT * FROM dbo.StuQuestionnaire ORDER BY QID ASC";
		ArrayList<HashMap<Object, Object>>qlist=dbBean.execute(sql);
		int count=0;
		String Qdata="[";
		for (HashMap<Object, Object> item : qlist) {
			Qdata+="{\"QID\":\""+item.get("QID").toString()+"\",\"Content\":\""+item.get("CONTENT").toString()+"\",\"Weight\":\""+item.get("WEIGHT").toString()+"\"},";
			count++;
		}
		Qdata=Qdata.substring(0, Qdata.length()-1);
		Qdata+="]";
		request.setAttribute("number",count);
		request.setAttribute("datastring",Qdata);
		
		
		
		
		return mapping.findForward("getQuestionnaire");
	}
	
	
	
	public ActionForward questionnaire(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String sid=request.getSession().getAttribute("ID").toString();
		
		String cid=request.getParameter("cid");
		String tid=request.getParameter("tid");
		String cno=request.getParameter("CNO");
		String CName=request.getParameter("CName");
	    String reason=request.getParameter("reason");		
		DBBean dbBean=new DBBean();
		String sql="";
	    String value="";
	    int a=0;
	    
	    sql="SELECT * FROM dbo.StuEvaluation WHERE CID='"+cid+"' AND SID='"+sid+"'";
	    
	    if (!dbBean.isExistBySql(sql)) 
	    	{
				a=dbBean.addTurnId(sid, cid, reason, CName, cno);
				sql="";
		
	   	    
			for(int i = 0; i < 20; i++) {
				    value=request.getParameter("Q"+i);		    
					dbBean.add(a,i+1,value);
			}
	    
		sql="SELECT * FROM dbo.StuEvalRes WHERE cid=  '"+cid+"'  AND TID='"+tid+"' AND CName='"+CName+"' AND ClassNum="+cno+"";
		
		if (!dbBean.isExistBySql(sql)) {
			
			sql="INSERT dbo.StuEvalRes( CID ,TID ,CName ,ClassNum) VALUES  ( '"+cid+"' ,'"+tid+"' ,'"+CName+"' ,'"+cno+"')";
			dbBean.add(sql);
			
		}
		
		for (int i = 1; i <= 4; i++) {
			sql="UPDATE dbo.StuEvalRes SET Category"+i+"=(SELECT SUM(QScore) FROM dbo.StuQuestionnaire RIGHT JOIN dbo.StuEvalDetail ON dbo.StuQuestionnaire.QID = dbo.StuEvalDetail.QID WHERE Category="+i+" AND MarkID="+a+" ) WHERE CID='"+cid+"' AND TID='"+tid+"' AND ClassNum="+cno+"";
			dbBean.query(sql);
		}
		sql="UPDATE dbo.StuEvalRes SET Number +=1 WHERE CID='"+cid+"' AND TID='"+tid+"' AND ClassNum="+cno+"";
			dbBean.query(sql);
		
		}
			return getStudentCourse(mapping, form,request,response);    
	    
		/*Enumeration pNames=request.getParameterNames();
		while(pNames.hasMoreElements()){
		    name=(String)pNames.nextElement();
		    
		for(int i = 1; i <= 20; i++) {
					sss="Q"+i;
					if (sss.equals(name)) {
					    value=request.getParameter(name);
					    sql=name + "=" + value;
					    sScore=value;
						dbBean.add(sid,i,sScore);
					}

				}*/

	}
		
	public ActionForward getStudentCourse(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		String id=request.getSession().getAttribute("ID").toString();
		//
			int count=0;
			DBBean dbBean=new DBBean();
			String data="{Rows:[";
			
			
			String sql="SELECT dbo.ChooseClass.CID,dbo.ChooseClass.SID,dbo.ChooseClass.ClassNum AS CNO,dbo.ChooseClass.TID,TName,dbo.ChooseClass.CNAME,dbo.ChooseClass.CourseType,XN,XQ,'true'=CASE WHEN dbo.StuEvaluation.CName IS NOT NULL THEN '已评价' ELSE '未评价' END FROM dbo.CourseType right join dbo.ChooseClass ON dbo.CourseType.CourseType = dbo.ChooseClass.CourseType right JOIN dbo.Teacher ON dbo.ChooseClass.TID = dbo.Teacher.TID  LEFT join dbo.StuEvaluation ON dbo.ChooseClass.SID = dbo.StuEvaluation.SID AND dbo.ChooseClass.CID = dbo.StuEvaluation.CID WHERE dbo.ChooseClass.SID='"+id+"' AND ture=1";
			ArrayList<HashMap<Object, Object>> qlist=dbBean.execute(sql);
			String Qdata="[";
			for (HashMap<Object, Object> item : qlist) {
				data+="{" +
						"\"CID\":\""+item.get("CID").toString()+"\"," +
						"\"TNAME\":\""+item.get("TNAME").toString()+"\"," +
						"\"TID\":\""+item.get("TID").toString()+"\"," +
						"\"CNAME\":\""+item.get("CNAME").toString()+"\"," +
						"\"COURSETYPE\":\""+item.get("COURSETYPE").toString()+"\"," +
						"\"TRUE\":\""+item.get("TRUE").toString()+"\"," +
						"\"XN\":\""+item.get("XN").toString()+"\"," +
						"\"CNO\":\""+item.get("CNO").toString()+"\"," +
						"\"XQ\":\""+item.get("XQ").toString()+"\"," +
						"},";
			count++;
			}
			data=data.substring(0, data.length()-1);
			data+="],Total:"+count+"}";
			request.setAttribute("datastring",data);
			
			//
			
			
			
			

			
			
			return mapping.findForward("studentCourse");
		}


	}