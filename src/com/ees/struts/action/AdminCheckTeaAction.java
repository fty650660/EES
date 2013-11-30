package com.ees.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ees.hibernate.AdministratorDAO;

public class AdminCheckTeaAction extends DispatchAction {
	
	public ActionForward showAllTeaCourseListByFaculty(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> allTeaList = null;
		allTeaList=adminDao.showAllTeaList();
		
		List<String> facultyList = null;
		facultyList=adminDao.showFaculty();
		
		System.out.println(allTeaList);

		//计算机学院所有教师的列表
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : allTeaList) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
					+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
					+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]+ "\",\"TITLE\":\"" + obj[6]
					+ "\",\"CID\":\"" + obj[7] + "\",\"CNAME\":\"" + obj[8]
					+ "\",\"COURSETYPE\":\"" + obj[9] + "\",\"SUMAVG\":\"" + obj[10] 
					+ "\",\"NUM\":\"" + obj[11] + "\"},";
			count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("allTeaString", subData);
		
		//系名字符串
		count = 0;
		String facultyData = "{Rows:[";
		for (String str : facultyList) {
			facultyData += "{\"FACULT\":\"" + str + "\"},";
			count++;
		}
		String subFacultyData = facultyData.substring(0, facultyData.length() - 1);
		subFacultyData += "],Total:" + count + "}";
		System.out.println(subFacultyData);
		request.setAttribute("facultyString", subFacultyData);
				
		return mapping.findForward("teaListByFaculty");
	}
	
	public ActionForward showAllTeaCourseListByXn(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> allTeaList = null;
		allTeaList=adminDao.showAllTeaList();
				
		List<String> xnList=null;
		xnList=adminDao.showXn();
		
		System.out.println(allTeaList);

		//计算机学院所有教师的列表
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : allTeaList) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
				+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
				+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]+ "\",\"TITLE\":\"" + obj[6]
				+ "\",\"CID\":\"" + obj[7] + "\",\"CNAME\":\"" + obj[8]
				+ "\",\"COURSETYPE\":\"" + obj[9] + "\",\"SUMAVG\":\"" + obj[10] 
				+ "\",\"NUM\":\"" + obj[11] + "\"},";
		count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("allTeaString", subData);		
		
		//学年字符串
		count = 0;
		String xnData = "{Rows:[";
		for (String str : xnList) {
			xnData += "{\"XN\":\"" + str + "\"},";
			count++;
		}
		String subXnData = xnData.substring(0, xnData.length() - 1);
		subXnData += "],Total:" + count + "}";
		System.out.println(subXnData);
		request.setAttribute("xnString", subXnData);
		
		return mapping.findForward("teaListByXn");
	}
	
	public ActionForward showAllTeaCourseListBySearch(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> allTeaList = null;
		allTeaList=adminDao.showAllTeaList();
				
		System.out.println(allTeaList);

		//计算机学院所有教师的列表
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : allTeaList) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
				+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
				+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]+ "\",\"TITLE\":\"" + obj[6]
				+ "\",\"CID\":\"" + obj[7] + "\",\"CNAME\":\"" + obj[8]
				+ "\",\"COURSETYPE\":\"" + obj[9] + "\",\"SUMAVG\":\"" + obj[10] 
				+ "\",\"NUM\":\"" + obj[11] + "\"},";
		count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("allTeaString", subData);
		
		return mapping.findForward("teaListBySearch");
	}
	
	public ActionForward showByCourseCount(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> allTeaList = null;
		allTeaList=adminDao.showTeaListByCourseCount(request.getParameter("FACULT"),request.getParameter("XN"),Integer.parseInt(request.getParameter("XQ")),request.getParameter("TITLE"));
				
		System.out.println(allTeaList);

		//计算机学院所有教师的列表
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : allTeaList) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
 				+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
 				+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]+ "\",\"TITLE\":\"" + obj[6]
 				+ "\",\"CID\":\"" + obj[7] + "\",\"CNAME\":\"" + obj[8]
 				+ "\",\"COURSETYPE\":\"" + obj[9] + "\",\"SUMAVG\":\"" + obj[10] 
 				+ "\",\"NUM\":\"" + obj[11] + "\"},";
 		count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("allTeaString", subData);
		
		return mapping.findForward("findByCourseCount");
	}
	
	public ActionForward showByYou(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> allTeaList = null;
		allTeaList=adminDao.showTeaListByYou(request.getParameter("FACULT"),request.getParameter("XN"),Integer.parseInt(request.getParameter("XQ")),request.getParameter("TITLE"));
				
		System.out.println(allTeaList);

		//计算机学院所有教师的列表
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : allTeaList) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
  				+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
  				+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]+ "\",\"TITLE\":\"" + obj[6]
  				+ "\",\"CID\":\"" + obj[7] + "\",\"CNAME\":\"" + obj[8]
  				+ "\",\"COURSETYPE\":\"" + obj[9] + "\",\"SUMAVG\":\"" + obj[10] 
  				+ "\",\"NUM\":\"" + obj[11] + "\"},";
  		count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("allTeaString", subData);
		
		return mapping.findForward("findByYou");
	}
	
	public ActionForward showByLiang(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> allTeaList = null;
		allTeaList=adminDao.showTeaListByLiang(request.getParameter("FACULT"),request.getParameter("XN"),Integer.parseInt(request.getParameter("XQ")),request.getParameter("TITLE"));
				
		System.out.println(allTeaList);

		//计算机学院所有教师的列表
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : allTeaList) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
				+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
				+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]+ "\",\"TITLE\":\"" + obj[6]
				+ "\",\"CID\":\"" + obj[7] + "\",\"CNAME\":\"" + obj[8]
				+ "\",\"COURSETYPE\":\"" + obj[9] + "\",\"SUMAVG\":\"" + obj[10] 
				+ "\",\"NUM\":\"" + obj[11] + "\"},";
		count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("allTeaString", subData);
		
		return mapping.findForward("findByLiang");
	}
	
	public ActionForward showByZhong(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> allTeaList = null;
		allTeaList=adminDao.showTeaListByZhong(request.getParameter("FACULT"),request.getParameter("XN"),Integer.parseInt(request.getParameter("XQ")),request.getParameter("TITLE"));
				
		System.out.println(allTeaList);

		//计算机学院所有教师的列表
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : allTeaList) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
  				+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
  				+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]+ "\",\"TITLE\":\"" + obj[6]
  				+ "\",\"CID\":\"" + obj[7] + "\",\"CNAME\":\"" + obj[8]
  				+ "\",\"COURSETYPE\":\"" + obj[9] + "\",\"SUMAVG\":\"" + obj[10] 
  				+ "\",\"NUM\":\"" + obj[11] + "\"},";
  		count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("allTeaString", subData);
		
		return mapping.findForward("findByZhong");
	}
	
	public ActionForward showByCha(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> allTeaList = null;
		allTeaList=adminDao.showTeaListByCha(request.getParameter("FACULT"),request.getParameter("XN"),Integer.parseInt(request.getParameter("XQ")),request.getParameter("TITLE"));
				
		System.out.println(allTeaList);

		//计算机学院所有教师的列表
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : allTeaList) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
  				+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
  				+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]+ "\",\"TITLE\":\"" + obj[6]
  				+ "\",\"CID\":\"" + obj[7] + "\",\"CNAME\":\"" + obj[8]
  				+ "\",\"COURSETYPE\":\"" + obj[9] + "\",\"SUMAVG\":\"" + obj[10] 
  				+ "\",\"NUM\":\"" + obj[11] + "\"},";
  		count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("allTeaString", subData);
		
		return mapping.findForward("findByCha");
	}
	
	public ActionForward showByBuhege(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> allTeaList = null;
		allTeaList=adminDao.showTeaListByBuhege(request.getParameter("FACULT"),request.getParameter("XN"),Integer.parseInt(request.getParameter("XQ")),request.getParameter("TITLE"));
				
		System.out.println(allTeaList);

		//计算机学院所有教师的列表
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : allTeaList) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
  				+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
  				+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]+ "\",\"TITLE\":\"" + obj[6]
  				+ "\",\"CID\":\"" + obj[7] + "\",\"CNAME\":\"" + obj[8]
  				+ "\",\"COURSETYPE\":\"" + obj[9] + "\",\"SUMAVG\":\"" + obj[10] 
  				+ "\",\"NUM\":\"" + obj[11] + "\"},";
  		count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("allTeaString", subData);
		
		return mapping.findForward("findByBuhege");
	}
	
	public ActionForward showByNotEvalued(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> allTeaList = null;
		allTeaList=adminDao.showTeaListByNotEvalued(request.getParameter("FACULT"),request.getParameter("XN"),Integer.parseInt(request.getParameter("XQ")),request.getParameter("TITLE"));
				
		System.out.println(allTeaList);

		//计算机学院所有教师的列表
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : allTeaList) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
  				+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
  				+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]+ "\",\"TITLE\":\"" + obj[6]
  				+ "\",\"CID\":\"" + obj[7] + "\",\"CNAME\":\"" + obj[8]
  				+ "\",\"COURSETYPE\":\"" + obj[9] + "\",\"SUMAVG\":\"" + obj[10] 
  				+ "\",\"NUM\":\"" + obj[11] + "\"},";
  		count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("allTeaString", subData);
		
		return mapping.findForward("findByNotEvalued");
	}
	
	
	public ActionForward xnXq(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> allXnXqList = null;
	    allXnXqList=adminDao.showXnXq();
		
		int count = 0;
		String xnData = "{Rows:[";
		for (Object[] obj : allXnXqList) {
			xnData += "{\"XN\":\"" + obj[0]+ "\",\"XQ\":\"" + obj[1] + "\"},";
			count++;
		}
		String subXnData = xnData.substring(0, xnData.length() - 1);
		subXnData += "],Total:" + count + "}";
		System.out.println(subXnData);
		request.setAttribute("xnxqString", subXnData);
	
		return mapping.findForward("xnXq");
	}
	
	public ActionForward showAllTitleByXn(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> allTitleListXn = null;
		allTitleListXn=adminDao.showAllTitleListXn(request.getParameter("XN"));
				
		System.out.println(allTitleListXn);

		
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : allTitleListXn) {
			data += "{\"FACULT\":\"" + obj[0] + "\",\"XN\":\"" + obj[1]
					+ "\",\"XQ\":\"" + obj[2] + "\",\"TITLE\":\"" + obj[3]
					+ "\",\"COURSECOUNT\":\"" + obj[4] + "\",\"YOU\":\"" + obj[5]
					+ "\",\"LIANG\":\"" + obj[6] + "\",\"ZHONG\":\"" + obj[7]
					+ "\",\"CHA\":\"" + obj[8]+ "\",\"BUHEGE\":\"" + obj[9] + "\",\"NOTEVALUED\":\"" + obj[10] + "\"},";
			count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("allTitleStringXn", subData);
		
		return mapping.findForward("teaTitleByXn");
	}
	
	public ActionForward showAllTitleByXnXq(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> allTitleListXnXq = null;
		allTitleListXnXq=adminDao.showAllTitleListXnXq(request.getParameter("XN"),Integer.parseInt(request.getParameter("XQ")));
				
		System.out.println(allTitleListXnXq);

		//计算机学院所有教师的列表
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : allTitleListXnXq) {
			data += "{\"FACULT\":\"" + obj[0] + "\",\"XN\":\"" + obj[1]
					+ "\",\"XQ\":\"" + obj[2] + "\",\"TITLE\":\"" + obj[3]
					+ "\",\"COURSECOUNT\":\"" + obj[4] + "\",\"YOU\":\"" + obj[5]
					+ "\",\"LIANG\":\"" + obj[6] + "\",\"ZHONG\":\"" + obj[7]
				    + "\",\"CHA\":\"" + obj[8]+ "\",\"BUHEGE\":\"" + obj[9] + "\",\"NOTEVALUED\":\"" + obj[10] + "\"},";
			count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("allTitleStringXnXq", subData);
		
		return mapping.findForward("teaTitleByXnXq");
	}

	public ActionForward showByXN(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> list = null;
		list=adminDao.showByXN(request.getParameter("XN"),request.getParameter("FACULT") );
		
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : list) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
					+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
					+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]
					+ "\",\"CID\":\"" + obj[6] + "\",\"CNAME\":\"" + obj[7]
					+ "\",\"COURSETYPE\":\"" + obj[8] + "\",\"SUMAVG\":\"" + obj[9] 
					+ "\",\"NUM\":\"" + obj[10] + "\"},";
			count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("showByXNString", subData);
		
		return mapping.findForward("showTeaByXN");
	}
	
	public ActionForward showByTnameF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> list = null;
		list=adminDao.showByTnameF(request.getParameter("TNAME"),request.getParameter("FACULT") );
		
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : list) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
					+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
					+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]
					+ "\",\"CID\":\"" + obj[6] + "\",\"CNAME\":\"" + obj[7]
					+ "\",\"COURSETYPE\":\"" + obj[8] + "\",\"SUMAVG\":\"" + obj[9] 
					+ "\",\"NUM\":\"" + obj[10] + "\"},";
			count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("showByTnameString", subData);
		
		return mapping.findForward("showTeaByTname");
	}
	
	public ActionForward showByTnameY(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> list = null;
		list=adminDao.showByTnameY(request.getParameter("TNAME"),request.getParameter("XN") );
		
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : list) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
					+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
					+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]
					+ "\",\"CID\":\"" + obj[6] + "\",\"CNAME\":\"" + obj[7]
					+ "\",\"COURSETYPE\":\"" + obj[8] + "\",\"SUMAVG\":\"" + obj[9] 
					+ "\",\"NUM\":\"" + obj[10] + "\"},";
			count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("showByTnameString", subData);
		
		return mapping.findForward("showTeaByTname");
	}
	
	public ActionForward showByCnameF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> list = null;
		list=adminDao.showByCnameF(request.getParameter("CNAME"),request.getParameter("FACULT") );
		
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : list) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
					+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
					+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]
					+ "\",\"CID\":\"" + obj[6] + "\",\"CNAME\":\"" + obj[7]
					+ "\",\"COURSETYPE\":\"" + obj[8] + "\",\"SUMAVG\":\"" + obj[9] 
					+ "\",\"NUM\":\"" + obj[10] + "\"},";
			count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("showByCnameString", subData);
		
		return mapping.findForward("showTeaByCname");
	}
	
	public ActionForward showByCnameY(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> list = null;
		list=adminDao.showByCnameY(request.getParameter("CNAME"),request.getParameter("XN") );
		
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : list) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
					+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
					+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]
					+ "\",\"CID\":\"" + obj[6] + "\",\"CNAME\":\"" + obj[7]
					+ "\",\"COURSETYPE\":\"" + obj[8] + "\",\"SUMAVG\":\"" + obj[9] 
					+ "\",\"NUM\":\"" + obj[10] + "\"},";
			count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("showByCnameString", subData);
		
		return mapping.findForward("showTeaByCname");
	}
	
	public ActionForward showByCourseTypeF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> list = null;
		list=adminDao.showByCourseTypeF(request.getParameter("COURSETYPE"),request.getParameter("FACULT") );
		
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : list) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
					+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
					+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]
					+ "\",\"CID\":\"" + obj[6] + "\",\"CNAME\":\"" + obj[7]
					+ "\",\"COURSETYPE\":\"" + obj[8] + "\",\"SUMAVG\":\"" + obj[9] 
					+ "\",\"NUM\":\"" + obj[10] + "\"},";
			count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("showByCourseTypeString", subData);
		
		return mapping.findForward("showTeaByCourseType");
	}
	
	public ActionForward showByCourseTypeY(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AdministratorDAO adminDao=new AdministratorDAO();
		List<Object[]> list = null;
		list=adminDao.showByCourseTypeY(request.getParameter("COURSETYPE"),request.getParameter("XN") );
		
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : list) {
			data += "{\"XN\":\"" + obj[0] + "\",\"XQ\":\"" + obj[1]
					+ "\",\"DEPT\":\"" + obj[2] + "\",\"FACULT\":\"" + obj[3]
					+ "\",\"TID\":\"" + obj[4] + "\",\"TNAME\":\"" + obj[5]
					+ "\",\"CID\":\"" + obj[6] + "\",\"CNAME\":\"" + obj[7]
					+ "\",\"COURSETYPE\":\"" + obj[8] + "\",\"SUMAVG\":\"" + obj[9] 
					+ "\",\"NUM\":\"" + obj[10] + "\"},";
			count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("showByCourseTypeString", subData);
		
		return mapping.findForward("showTeaByCourseType");
	}
}
