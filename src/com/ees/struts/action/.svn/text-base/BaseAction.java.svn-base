package com.ees.struts.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public abstract class BaseAction extends DispatchAction {
	
	 private BeanUtilsBean  beanUtilsBean; 

	protected static final String SUCCESS_FORWARD = "success";

	protected static final String FAILURE_FORWARD = "failure";

	protected ActionForward successForward; 

	protected ActionForward failureForward;

	protected ActionMapping mapping;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected HttpSession session;

	protected ServletContext application;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		initContext(mapping, request, response);
		String parameter = mapping.getParameter();
		// 如在配置文件中不带则执行
		//if (parameter == null) {
		//	return dispatchMethod(mapping, form, request, response, "doDefault");
		//}
		String method = request.getParameter("method");
		if (method == null) {
			return dispatchMethod(mapping, form, request, response, "doDefault");
		}
		return dispatchMethod(mapping, form, request, response, method);
	}

	protected void initContext(ActionMapping mapping,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.mapping = mapping;
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		this.beanUtilsBean=new BeanUtilsBean();
		this.application = session.getServletContext();
		this.successForward = mapping.findForward(SUCCESS_FORWARD);
		this.failureForward = mapping.findForward(FAILURE_FORWARD);
	}

	public abstract ActionForward doDefault(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public BeanUtilsBean getBeanUtilsBean() {
		return beanUtilsBean;
	}
	protected final Log log = LogFactory.getLog(getClass());
}
