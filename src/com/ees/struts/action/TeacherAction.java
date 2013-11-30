/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.ees.struts.action;

import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ees.javabean.DBBean;
/** 
 * MyEclipse Struts
 * Creation date: 12-07-2011
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
@Entity
public class TeacherAction extends BaseAction {
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
	public ActionForward getTeacherCourse(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String id=request.getSession().getAttribute("ID").toString();
			DBBean dbBean=new DBBean();
			String sql="SELECT * FROM dbo.TeacherAll WHERE TID="+id+"";
			ArrayList<HashMap<Object, Object>> clist=dbBean.execute(sql);
			int count=0;
			String evlnum="";
			String data="{Rows:[";
			for (HashMap<Object, Object> item : clist) {
				if (item.get("EVLNUM")!= null) {
				if (item.get("EVLNUM")=="null") {
					evlnum="0";
				}else {
					evlnum=item.get("EVLNUM").toString();
				}
				}

				data+="{" +
				"\"CID\":\""+item.get("CID").toString()+"\"," +
				"\"TNAME\":\""+item.get("TNAME").toString()+"\"," +
				"\"TID\":\""+item.get("TID").toString()+"\"," +
				"\"CNAME\":\""+item.get("CNAME").toString()+"\"," +
				"\"COURSETYPE\":\""+item.get("COURSETYPE").toString()+"\"," +
				"\"XN\":\""+item.get("XN").toString()+"\"," +
				"\"CNO\":\""+item.get("CLASSNUM").toString()+"\"," +
				"\"XQ\":\""+item.get("XQ").toString()+"\"," +
				"\"NUM\":\""+item.get("NUM").toString()+"\"," +
				"\"EVLNUM\":\""+evlnum+"\"" +
				"},";
				
				count++;
			}
			data=data.substring(0, data.length()-1);
			data+="],Total:"+count+"}";
			request.setAttribute("datastring",data);
			
			//
			return mapping.findForward("teacherCourse");
	
	}
	
	
	
	public ActionForward getValresult(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id=request.getSession().getAttribute("ID").toString();
		String cid=request.getParameter("CID");
		DBBean dbBean=new DBBean();
		String sql="SELECT Category1/Number AS Category1,Category2/Number AS Category2,Category3/Number AS Category3,Category4/Number AS Category4, (Category1+Category2+Category3+Category4)/Number AS  Category5 FROM dbo.TeacherEvaluation WHERE CID="+cid+" AND TID="+id+"";
		ArrayList<HashMap<Object, Object>> clist=dbBean.execute(sql);
		HashMap<Object, Object> item=clist.get(0);
		//String bbString=item.get("CATEGORY1").toString();
		//int aa=(Integer)item.get("Category1");
		int[] str = {Integer.parseInt(item.get("CATEGORY1").toString()),Integer.parseInt(item.get("CATEGORY2").toString()),Integer.parseInt(item.get("CATEGORY3").toString()),Integer.parseInt(item.get("CATEGORY4").toString()),Integer.parseInt(item.get("CATEGORY5").toString())};  
int[] weight={15,50,15,20,100};
		
			String aString="";

		for (int i = 0; i < str.length; i++) {
			str[i]=str[i]*100/weight[i];	
			aString="data"+i;
			request.setAttribute(""+aString+"",str[i]);
		}
		

		
		return mapping.findForward("showResult");
	}
}