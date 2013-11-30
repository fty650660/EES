package com.ees.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ees.hibernate.Mail;
import com.ees.hibernate.MailDAO;
import com.ees.struts.form.MailListForm;

public class MailListAction extends DispatchAction {

	public ActionForward stuMailList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String type = (String) request.getSession().getAttribute("role");
		String sid = request.getSession().getAttribute("ID").toString();
		System.out.println("The role type:" + type);

		MailListForm mailListForm = (MailListForm) form;
		System.out.println("FORM :" + mailListForm);
		String adminName = mailListForm.getAdminName();
		Mail filterMail = new Mail();
		MailDAO mailDao = new MailDAO();
		List<Mail> mailList = null;

		if (adminName != null && !adminName.isEmpty()) {
			filterMail.setTname(mailListForm.getAdminName().trim());
			filterMail.setSid(sid);
			mailList = mailDao.findByExample(filterMail);
			System.out.println("mailDAO in filter:" + mailDao);
		} else {
			mailList = mailDao.findBySid(sid);
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
		
		String type = (String) request.getSession().getAttribute("role");
		String tid =  request.getSession().getAttribute("ID").toString();
		System.out.println("The role type:" + type);
		
		MailListForm mailListForm = (MailListForm) form;
		MailDAO mailDao = new MailDAO();
		List<Object[]> mailList = null;
		
		
		if (mailListForm.getFilterOption() == null) {
			mailList = mailDao.findMails(tid);
		} else if(mailListForm.getFilterOption().equals("1")){
			String fuzzyName = "%" + mailListForm.getStuClName() + "%";
			mailList = mailDao.filterByClass(tid, fuzzyName);			
		} else {
			String fuzzyName = "%" + mailListForm.getStuClName() + "%";
			mailList = mailDao.filterByName(tid, fuzzyName);
		}

		System.out.println(mailList);

		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : mailList) {
			data += "{\"ThID\":\"" + obj[0] + "\",\"TName\":\"" + obj[1]
					+ "\",\"Theme\":\"" + obj[2] + "\",\"SName\":\"" + obj[3]
					+ "\",\"CLName\":\"" + obj[4] + "\",\"Sub_Time\":\""
					+ obj[5] + "\"},";
			count++;
		}
		data += "],Total:" + count + "}";
		request.setAttribute("mailListString", data);
		request.setAttribute("type", type);

		return mapping.findForward("adminMailList");

	}
}
