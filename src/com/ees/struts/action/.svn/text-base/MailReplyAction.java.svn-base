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
import com.ees.hibernate.MailReply;
import com.ees.hibernate.MailReplyDAO;
import com.ees.struts.form.ShowMailReplyForm;

public class MailReplyAction extends DispatchAction {

	public ActionForward showMailReply(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ShowMailReplyForm showMailReplyForm = (ShowMailReplyForm) form;

		String thid = request.getParameter("thid");

		MailDAO mailDao = new MailDAO();
		Mail mail = mailDao.findById(Integer.parseInt(thid));

		showMailReplyForm.setSname(mail.getSname());
		showMailReplyForm.setTname(mail.getTname());
		showMailReplyForm.setTheme(mail.getTheme());
		showMailReplyForm.setSubtime(new java.sql.Date(mail.getSubTime()
				.getTime()));
		showMailReplyForm.setDetails(mail.getDetails());

		MailReply mailReply = new MailReply();
		mailReply.setThId(Integer.parseInt(thid));
		MailReplyDAO mailReplyDao = new MailReplyDAO();
		List<MailReply> mailReplyList = mailReplyDao.findByThId(Integer.parseInt(thid));
		request.setAttribute("mailReplyList", mailReplyList);

		return mapping.findForward("showMailReply");
	}

	public ActionForward newReply(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer type = Integer.parseInt((String) request.getSession()
				.getAttribute("role"));
		System.out.println("tpye in newReply:" + type);

		ShowMailReplyForm showMailReplyForm = (ShowMailReplyForm) form;
		MailReply newMailReply = new MailReply();
		MailReplyDAO mailReplyDao = new MailReplyDAO();

		newMailReply.setThId(showMailReplyForm.getThid());
		newMailReply.setReply(showMailReplyForm.getReply());
		newMailReply.setSubTime(new java.util.Date());
		if (type == 1)
			newMailReply.setIsFromStu(new Boolean(true));
		else
			newMailReply.setIsFromStu(new Boolean(false));
		mailReplyDao.save(newMailReply);

		String URI = "/MailReply.do?method=showMailReply&thid="
				+ showMailReplyForm.getThid();

		return new ActionForward(URI, true);
	}

}
