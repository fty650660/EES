package com.ees.struts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ees.hibernate.Administrator;
import com.ees.hibernate.AdministratorDAO;
import com.ees.hibernate.Mail;
import com.ees.hibernate.MailDAO;
import com.ees.struts.form.WriteMailForm;

public class MailAction extends DispatchAction {

	public ActionForward writeMailAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String student = request.getSession().getAttribute("ID").toString();
		System.out.println("Sutdent SID is here:" + student);

		WriteMailForm writeMailForm = (WriteMailForm) form;

		String fillselect = request.getParameter("fillselect");

		System.out.println(fillselect);

		AdministratorDAO adminDao = new AdministratorDAO();
		List<Administrator> admin = adminDao.findByName(fillselect);

		Mail mail = new Mail();
		MailDAO mailDao = new MailDAO();

		
		mail.setTid(admin.get(0).getId().toString());
		mail.setTname(fillselect);
		mail.setSid((String) request.getSession().getAttribute("ID"));
		mail.setSname((String) request.getSession().getAttribute("sname"));
		mail.setTheme(writeMailForm.getTheme());
		mail.setDetails(writeMailForm.getDetails());
		mail.setSubTime(new Date());
		mail.setIsFromTea(false);

		mailDao.save(mail);

		try {
			PrintWriter out = response.getWriter();
			out.println("邮件发送成功~！");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ActionForward fillSelectAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List selectList = null;
		AdministratorDAO adminDao = new AdministratorDAO();
		selectList = adminDao.fillSelectList();

		for (int i = 0; i < selectList.size(); i++) {
			System.out.println(selectList.get(i));
		}

		request.setAttribute("selectlist", selectList);

		return mapping.findForward("fillSelect");
	}

	public ActionForward stuMailList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String type = (String)request.getSession().getAttribute("role") ;
		String ID = (String)request.getSession().getAttribute("ID");
		System.out.println("The role type:" + type);

		MailDAO mailDao = new MailDAO();
		List<Mail> mailList = null;
		
		switch (Integer.parseInt(type)) {
		case 1:
			mailList=mailDao.findBySid(ID);
			break;
		case 2:
			break;
		case 3:
			mailList=mailDao.findByTid(ID);
			break;
		}
		
		System.out.println(mailList);

		int count = 0;
		String data = "{Rows:[";
		for (Mail mail : mailList) {
			data += "{\"ThID\":\"" + mail.getThId() + "\",\"TName\":\""
					+ mail.getTname() + "\",\"Theme\":\"" + mail.getTheme()
					+ "\",\"SName\":\"" + mail.getSname()
					+ "\",\"Sub_Time\":\"" + mail.getSubTime() + "\"},";
			count++;
		}
		data += "],Total:" + count + "}";
		request.setAttribute("mailListString", data);
		request.setAttribute("type", type);

		return mapping.findForward("stuMailList");
	}
	
	public ActionForward adminMailList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String type = (String)request.getSession().getAttribute("role") ;
		String ID = (String)request.getSession().getAttribute("ID");
		System.out.println("The role type:" + type);

		MailDAO mailDao = new MailDAO();
		List<Mail> mailList = null;
		
		switch (Integer.parseInt(type)) {
		case 1:
			mailList=mailDao.findBySid(ID);
			break;
		case 2:
			break;
		case 3:
			mailList=mailDao.findByTid(ID);
			break;
		}
		
		System.out.println(mailList);

		int count = 0;
		String data = "{Rows:[";
		for (Mail mail : mailList) {
			data += "{\"ThID\":\"" + mail.getThId() + "\",\"TName\":\""
					+ mail.getTname() + "\",\"Theme\":\"" + mail.getTheme()
					+ "\",\"SName\":\"" + mail.getSname()
					+ "\",\"Sub_Time\":\"" + mail.getSubTime() + "\"},";
			count++;
		}
		data += "],Total:" + count + "}";
		request.setAttribute("mailListString", data);
		request.setAttribute("type", type);

		return mapping.findForward("adminMailList");
	}
}
