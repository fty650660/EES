package com.ees.struts.action;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Transaction;

import com.ees.hibernate.CourseDAO;
import com.ees.hibernate.HibernateSessionFactory;
import com.ees.hibernate.TeaEvalDetail;
import com.ees.hibernate.TeaEvalDetailDAO;
import com.ees.hibernate.TeaEvalDetailId;
import com.ees.hibernate.TeaEvalRes;
import com.ees.hibernate.TeaEvalResDAO;
import com.ees.hibernate.TeaEvalResId;
import com.ees.hibernate.TeaEvaluation;
import com.ees.hibernate.TeaEvaluationDAO;
import com.ees.hibernate.TeaQuestionnaire;
import com.ees.hibernate.TeaQuestionnaireDAO;
import com.ees.hibernate.TeacherDAO;
import com.ees.struts.form.TeaEvalutionForm;

public class TeaEvaluationAction extends DispatchAction {

	// 显示同系教师课程列表
	public ActionForward showFacultyCourse(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String tid = (String) request.getSession().getAttribute("ID");
		TeacherDAO teacherDao = new TeacherDAO();
		List<Object[]> courseList = null;

		courseList = teacherDao.findCourseList(tid);

		System.out.println(courseList);

		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : courseList) {
			data += "{\"TID\":\"" + obj[0] + "\",\"TName\":\"" + obj[1]+ "\",\"Title\":\"" + obj[2]
					+ "\",\"Dept\":\"" + obj[3] + "\",\"facult\":\"" + obj[4]
					+ "\",\"XN\":\"" + obj[5] + "\",\"XQ\":\"" + obj[6]
					+ "\",\"CID\":\"" + obj[7] + "\",\"CNAME\":\"" + obj[8]
					+ "\",\"CLASSNUM\":\"" + obj[9] + "\",\"CourseType\":\""
					+ obj[10] + "\",\"ISEVALU\":\"" + obj[11] + "\"},";
			count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("courseListString", subData);

		return mapping.findForward("sameFacultyCourse");
	}

	// 自动填写评价表的相关字段
	public ActionForward fillinEvaluTable(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		TeaEvalutionForm teaEvaluForm = (TeaEvalutionForm) form;
		String lisname = (String) request.getSession().getAttribute("tname");
		String lisid = (String) request.getSession().getAttribute("ID");
		request.getSession().setAttribute("teaid", teaEvaluForm.getTeaid());
		request.getSession().setAttribute("cid", teaEvaluForm.getCid());
		// String teaid = request.getParameter("teaid");
		// String teaname = request.getParameter("teaname");
		// String cid = request.getParameter("cid");
		// String cname = request.getParameter("cname");
		// String dept = request.getParameter("dept");
		// String coursetype = request.getParameter("coursetype");

		// teaEvaluForm.setDept(dept);
		// teaEvaluForm.setCname(cname);
		// teaEvaluForm.setTeaname(teaname);
		// teaEvaluForm.setCoursetype(coursetype);
		// teaEvaluForm.setCid(cid);
		// teaEvaluForm.setTeaid(teaid);

		teaEvaluForm.setLisid(lisid);
		teaEvaluForm.setLisname(lisname);
		teaEvaluForm.setSubtime(new Date(new java.util.Date().getTime()));

		TeaEvaluationDAO teaEvaluDao = new TeaEvaluationDAO();
		List markIdList = teaEvaluDao.evaluIsExist(teaEvaluForm.getTeaid(),
				teaEvaluForm.getLisid(), teaEvaluForm.getCid(),
				teaEvaluForm.getXn(), teaEvaluForm.getXq(), teaEvaluForm.getClassnum());
		TeaQuestionnaireDAO teaQueDao = new TeaQuestionnaireDAO();

		// 拼接问题字符串
		List<TeaQuestionnaire> questList = teaQueDao.findAll();
		String questions = "[";
		for (TeaQuestionnaire obj : questList) {
			questions += "{\"QID\":\"" + obj.getQid() + "\",\"Content\":\""
					+ obj.getContent() + "\",\"Weight\":\"" + obj.getWeight()
					+ "\"},";
		}

		String strQuestions = questions.substring(0, questions.length() - 1);
		strQuestions += "]";
		request.getSession().setAttribute("Questions", strQuestions);

		// 判断是否已经评价过
		if (markIdList.isEmpty()) {

			return mapping.findForward("loadForAddEvalu");

		} else {
			// 如果已经评价过则直接读取内容以供之后的修改
			int markId = (Integer) markIdList.get(0);
			TeaEvaluation teaEvalu = teaEvaluDao.findById(markId);
			teaEvaluForm.setTeaclass(teaEvalu.getTeaClass());
			teaEvaluForm.setTeatime(teaEvalu.getTeaTime());
			teaEvaluForm.setTealocation(teaEvalu.getTeaPlace());
			teaEvaluForm.setReason(teaEvalu.getReason());
			teaEvaluForm.setAgelevel(teaEvalu.getAgeLevel());
			// 读取detail和res表中的内容，然后用于在表格里显示

			TeaEvalDetailDAO teaDetailDao = new TeaEvalDetailDAO();
			List<TeaEvalDetail> scoreList = teaDetailDao.findByProperty(
					"teaEvaluation", teaEvalu);
			// System.out.println(scoreList.get(0).getId().getQscore());
			for(int i=0;i<12;i++){
				switch(scoreList.get(i).getId().getQid()){
				case 1:
					teaEvaluForm.setQ1(scoreList.get(i).getId().getQscore().toString());break;
				case 2:
					teaEvaluForm.setQ2(scoreList.get(i).getId().getQscore().toString());break;
				case 3:
					teaEvaluForm.setQ3(scoreList.get(i).getId().getQscore().toString());break;
				case 4:
					teaEvaluForm.setQ4(scoreList.get(i).getId().getQscore().toString());break;
				case 5:
					teaEvaluForm.setQ5(scoreList.get(i).getId().getQscore().toString());break;
				case 6:
					teaEvaluForm.setQ6(scoreList.get(i).getId().getQscore().toString());break;
				case 7:
					teaEvaluForm.setQ7(scoreList.get(i).getId().getQscore().toString());break;
				case 8:
					teaEvaluForm.setQ8(scoreList.get(i).getId().getQscore().toString());break;
				case 9:
					teaEvaluForm.setQ9(scoreList.get(i).getId().getQscore().toString());break;
				case 10:
					teaEvaluForm.setQ10(scoreList.get(i).getId().getQscore().toString());break;
				case 11:
					teaEvaluForm.setQ11(scoreList.get(i).getId().getQscore().toString());break;
				case 12:
					teaEvaluForm.setSum(scoreList.get(i).getId().getQscore().toString());break;
				}
			}
			
			/*teaEvaluForm.setQ1(scoreList.get(0).getId().getQscore().toString());
			teaEvaluForm.setQ2(scoreList.get(1).getId().getQscore().toString());
			teaEvaluForm.setQ3(scoreList.get(2).getId().getQscore().toString());
			teaEvaluForm.setQ4(scoreList.get(3).getId().getQscore().toString());
			teaEvaluForm.setQ5(scoreList.get(4).getId().getQscore().toString());
			teaEvaluForm.setQ6(scoreList.get(5).getId().getQscore().toString());
			teaEvaluForm.setQ7(scoreList.get(6).getId().getQscore().toString());
			teaEvaluForm.setQ8(scoreList.get(7).getId().getQscore().toString());
			teaEvaluForm.setQ9(scoreList.get(8).getId().getQscore().toString());
			teaEvaluForm
					.setQ10(scoreList.get(9).getId().getQscore().toString());
			teaEvaluForm.setQ11(scoreList.get(10).getId().getQscore()
					.toString());
			teaEvaluForm.setSum(scoreList.get(11).getId().getQscore()
					.toString());*/

			// TeaEvalutionForm oldForm=new TeaEvalutionForm();
			// oldForm=teaEvaluForm;
			// 为之后可能修改评价表准备每个题目的具体分数
			request.getSession().setAttribute("markId", markId);
			request.getSession().setAttribute("oq1", teaEvaluForm.getQ1());
			request.getSession().setAttribute("oq2", teaEvaluForm.getQ2());
			request.getSession().setAttribute("oq3", teaEvaluForm.getQ3());
			request.getSession().setAttribute("oq4", teaEvaluForm.getQ4());
			request.getSession().setAttribute("oq5", teaEvaluForm.getQ5());
			request.getSession().setAttribute("oq6", teaEvaluForm.getQ6());
			request.getSession().setAttribute("oq7", teaEvaluForm.getQ7());
			request.getSession().setAttribute("oq8", teaEvaluForm.getQ8());
			request.getSession().setAttribute("oq9", teaEvaluForm.getQ9());
			request.getSession().setAttribute("oq10", teaEvaluForm.getQ10());
			request.getSession().setAttribute("oq11", teaEvaluForm.getQ11());
			request.getSession().setAttribute("osum", teaEvaluForm.getSum());

			return mapping.findForward("checkEvalu");
		}

	}

	// 添加新的评论
	public ActionForward addEvaluation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TeaEvalutionForm teaEvalForm = (TeaEvalutionForm) form;
		// String lisid=(String)request.getSession().getAttribute("ID");
		// String teaid=(String)request.getSession().getAttribute("teaid");
		// String cid=(String)request.getSession().getAttribute("cid");
		TeaEvaluation teaEvalu = new TeaEvaluation();
		TeaEvaluationDAO teaEvalDao = new TeaEvaluationDAO();
		TeaEvalDetail teaEvalDetail = new TeaEvalDetail();
		TeaEvalDetailId teaDetailId = new TeaEvalDetailId();
		TeaEvalDetailDAO teaEvalDetailDao = new TeaEvalDetailDAO();
		TeaEvalResDAO teaResDao = new TeaEvalResDAO();
		TeaEvalRes teaRes = new TeaEvalRes();
		TeaEvalResId teaResId = new TeaEvalResId();

		TeacherDAO teaDao = new TeacherDAO();
		CourseDAO couDao = new CourseDAO();
		System.out.println("CID:" + teaEvalForm.getCid());

		List markIdList = teaEvalDao.evaluIsExist(teaEvalForm.getTeaid(),
				teaEvalForm.getLisid(), teaEvalForm.getCid(),
				teaEvalForm.getXn(), teaEvalForm.getXq(), teaEvalForm.getClassnum());

		if (markIdList.isEmpty()) {
			
//			Transaction tx=HibernateSessionFactory.getSession().beginTransaction();

			// 把基本信息插入到TeaEvaluation表中
			teaEvalu.setDept(teaEvalForm.getDept());
			teaEvalu.setTeaClass(teaEvalForm.getTeaclass());
			teaEvalu.setCname(teaEvalForm.getCname());
			teaEvalu.setCourse(couDao.findById(teaEvalForm.getCid()));
			teaEvalu.setCourseType(teaEvalForm.getCoursetype());
			teaEvalu.setTeacherByTeaTid(teaDao.findById(teaEvalForm.getTeaid()));
			teaEvalu.setAgeLevel(teaEvalForm.getAgelevel());
			teaEvalu.setTeaTime(teaEvalForm.getTeatime());
			teaEvalu.setTeaPlace(teaEvalForm.getTealocation());
			teaEvalu.setReason(teaEvalForm.getReason());
			// teaEvalu.setTeacherByLisTid(teaDao.findById(lisid));
			teaEvalu.setTeacherByLisTid(teaDao.findById(teaEvalForm.getLisid()));
			teaEvalu.setSubTime(teaEvalForm.getSubtime());
			teaEvalu.setXn(teaEvalForm.getXn());
			teaEvalu.setXq(teaEvalForm.getXq());
			teaEvalu.setClassNum(teaEvalForm.getClassnum());
			teaEvalDao.save(teaEvalu);

			// 把Q1~Q11和sum（Q12）的每项得分插入到TeaEvalDetail表中
			// int markID=teaEvalDao.findMarkID(teaEvalForm.getTeaid(),
			// teaEvalForm.getLisid(), teaEvalForm.getCid());
			
			String test=teaEvalForm.getQ1();
			teaDetailId.setTeaEvaluation(teaEvalu);
			teaDetailId.setQid(1);
			teaDetailId.setQscore(Integer.parseInt(teaEvalForm.getQ1()));
			teaEvalDetail.setId(teaDetailId);
			teaEvalDetailDao.save(new TeaEvalDetail(teaDetailId, teaEvalu));

			teaDetailId.setQid(2);
			teaDetailId.setQscore(Integer.parseInt(teaEvalForm.getQ2()));
			teaEvalDetail.setId(teaDetailId);
			teaEvalDetailDao.save(new TeaEvalDetail(teaDetailId, teaEvalu));

			teaDetailId.setQid(3);
			teaDetailId.setQscore(Integer.parseInt(teaEvalForm.getQ3()));
			teaEvalDetail.setId(teaDetailId);
			teaEvalDetailDao.save(new TeaEvalDetail(teaDetailId, teaEvalu));

			teaDetailId.setQid(4);
			teaDetailId.setQscore(Integer.parseInt(teaEvalForm.getQ4()));
			teaEvalDetail.setId(teaDetailId);
			teaEvalDetailDao.save(new TeaEvalDetail(teaDetailId, teaEvalu));

			teaDetailId.setQid(5);
			teaDetailId.setQscore(Integer.parseInt(teaEvalForm.getQ5()));
			teaEvalDetail.setId(teaDetailId);
			teaEvalDetailDao.save(new TeaEvalDetail(teaDetailId, teaEvalu));

			teaDetailId.setQid(6);
			teaDetailId.setQscore(Integer.parseInt(teaEvalForm.getQ6()));
			teaEvalDetail.setId(teaDetailId);
			teaEvalDetailDao.save(new TeaEvalDetail(teaDetailId, teaEvalu));

			teaDetailId.setQid(7);
			teaDetailId.setQscore(Integer.parseInt(teaEvalForm.getQ7()));
			teaEvalDetail.setId(teaDetailId);
			teaEvalDetailDao.save(new TeaEvalDetail(teaDetailId, teaEvalu));

			teaDetailId.setQid(8);
			teaDetailId.setQscore(Integer.parseInt(teaEvalForm.getQ8()));
			teaEvalDetail.setId(teaDetailId);
			teaEvalDetailDao.save(new TeaEvalDetail(teaDetailId, teaEvalu));

			teaDetailId.setQid(9);
			teaDetailId.setQscore(Integer.parseInt(teaEvalForm.getQ9()));
			teaEvalDetail.setId(teaDetailId);
			teaEvalDetailDao.save(new TeaEvalDetail(teaDetailId, teaEvalu));

			teaDetailId.setQid(10);
			teaDetailId.setQscore(Integer.parseInt(teaEvalForm.getQ10()));
			teaEvalDetail.setId(teaDetailId);
			teaEvalDetailDao.save(new TeaEvalDetail(teaDetailId, teaEvalu));

			teaDetailId.setQid(11);
			teaDetailId.setQscore(Integer.parseInt(teaEvalForm.getQ11()));
			teaEvalDetail.setId(teaDetailId);
			teaEvalDetailDao.save(new TeaEvalDetail(teaDetailId, teaEvalu));

			teaDetailId.setQid(12);
			teaDetailId.setQscore(Integer.parseInt(teaEvalForm.getSum()));
			teaEvalDetail.setId(teaDetailId);
			teaEvalDetailDao.save(new TeaEvalDetail(teaDetailId, teaEvalu));
			
//			tx.commit();

			// 把本次评价结果存入/更新到TeaEvalRes表中；先判断表中是否有该教师和课程对应的记录，如果没有则insert
			// 如果已经存在就进行update
			if (teaResDao.findIsExist(teaEvalForm.getTeaid(),
					teaEvalForm.getCid(),teaEvalForm.getXn(),teaEvalForm.getXq())) {
				System.out.println("Haha~you saw me!");
				teaResDao.updateRes(teaEvalForm.getQ1(), teaEvalForm.getQ2(),
						teaEvalForm.getQ3(), teaEvalForm.getQ4(),
						teaEvalForm.getQ5(), teaEvalForm.getQ6(),
						teaEvalForm.getQ7(), teaEvalForm.getQ8(),
						teaEvalForm.getQ9(), teaEvalForm.getQ10(),
						teaEvalForm.getQ11(), teaEvalForm.getSum(), 1,
						teaEvalForm.getTeaid(), teaEvalForm.getCid(),
						teaEvalForm.getXn(), teaEvalForm.getXq());

			} else {
				teaResId.setCourse(couDao.findById(teaEvalForm.getCid()));
				teaResId.setTeacher(teaDao.findById(teaEvalForm.getTeaid()));
				teaResId.setCname(teaEvalForm.getCname());
				teaResId.setQ1(teaEvalForm.getQ1());
				teaResId.setQ2(teaEvalForm.getQ2());
				teaResId.setQ3(teaEvalForm.getQ3());
				teaResId.setQ4(teaEvalForm.getQ4());
				teaResId.setQ5(teaEvalForm.getQ5());
				teaResId.setQ6(teaEvalForm.getQ6());
				teaResId.setQ7(teaEvalForm.getQ7());
				teaResId.setQ8(teaEvalForm.getQ8());
				teaResId.setQ9(teaEvalForm.getQ9());
				teaResId.setQ10(teaEvalForm.getQ10());
				teaResId.setQ11(teaEvalForm.getQ11());
				teaResId.setSumScore(teaEvalForm.getSum());
				teaResId.setNumber(1);
				teaResId.setXn(teaEvalForm.getXn());
				teaResId.setXq(teaEvalForm.getXq());
				teaRes.setId(teaResId);
				teaResDao.save(teaRes);
			}

			// return mapping.findForward("evaluSuccess");
			String URI = "form/successAddEvaluation.jsp";
			return new ActionForward(URI, true);

		} else {
			// return mapping.findForward("alreadyEvalu");
			String URI = "form/teacherEvaluation.jsp";
			return new ActionForward(URI, true);
		}

		// return null;
	}

	// 修改评价表
	public ActionForward updateEvaluation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TeaEvalutionForm oldForm =
		// (TeaEvalutionForm)request.getSession().getAttribute("oldForm");
		String oq1 = (String) request.getSession().getAttribute("oq1");
		String oq2 = (String) request.getSession().getAttribute("oq2");
		String oq3 = (String) request.getSession().getAttribute("oq3");
		String oq4 = (String) request.getSession().getAttribute("oq4");
		String oq5 = (String) request.getSession().getAttribute("oq5");
		String oq6 = (String) request.getSession().getAttribute("oq6");
		String oq7 = (String) request.getSession().getAttribute("oq7");
		String oq8 = (String) request.getSession().getAttribute("oq8");
		String oq9 = (String) request.getSession().getAttribute("oq9");
		String oq10 = (String) request.getSession().getAttribute("oq10");
		String oq11 = (String) request.getSession().getAttribute("oq11");
		String osum = (String) request.getSession().getAttribute("osum");
		int markId = (Integer) request.getSession().getAttribute("markId");
		String tid = (String) request.getSession().getAttribute("teaid");
		String cid = (String) request.getSession().getAttribute("cid");
		TeaEvalutionForm teaEvaluForm = (TeaEvalutionForm) form;

		TeaEvaluationDAO teaEvaluDao = new TeaEvaluationDAO();
		teaEvaluDao
				.updateEvaluation(teaEvaluForm.getTeaclass(),
						teaEvaluForm.getAgelevel(), teaEvaluForm.getTeatime(),
						teaEvaluForm.getTealocation(),
						teaEvaluForm.getReason(), markId);
		
//		Transaction tx=HibernateSessionFactory.getSession().beginTransaction();

		TeaEvalDetailDAO teaDetailDao = new TeaEvalDetailDAO();
		teaDetailDao.updateEvaluDetail(markId, 1,
				Integer.parseInt(teaEvaluForm.getQ1()));
		teaDetailDao.updateEvaluDetail(markId, 2,
				Integer.parseInt(teaEvaluForm.getQ2()));
		teaDetailDao.updateEvaluDetail(markId, 3,
				Integer.parseInt(teaEvaluForm.getQ3()));
		teaDetailDao.updateEvaluDetail(markId, 4,
				Integer.parseInt(teaEvaluForm.getQ4()));
		teaDetailDao.updateEvaluDetail(markId, 5,
				Integer.parseInt(teaEvaluForm.getQ5()));
		teaDetailDao.updateEvaluDetail(markId, 6,
				Integer.parseInt(teaEvaluForm.getQ6()));
		teaDetailDao.updateEvaluDetail(markId, 7,
				Integer.parseInt(teaEvaluForm.getQ7()));
		teaDetailDao.updateEvaluDetail(markId, 8,
				Integer.parseInt(teaEvaluForm.getQ8()));
		teaDetailDao.updateEvaluDetail(markId, 9,
				Integer.parseInt(teaEvaluForm.getQ9()));
		teaDetailDao.updateEvaluDetail(markId, 10,
				Integer.parseInt(teaEvaluForm.getQ10()));
		teaDetailDao.updateEvaluDetail(markId, 11,
				Integer.parseInt(teaEvaluForm.getQ11()));
		teaDetailDao.updateEvaluDetail(markId, 12,
				Integer.parseInt(teaEvaluForm.getSum()));

		TeaEvalResDAO teaResDao = new TeaEvalResDAO();
		teaResDao.updateRes(
				((Integer) (Integer.parseInt(teaEvaluForm.getQ1()) - Integer
						.parseInt(oq1))).toString(),
				((Integer) (Integer.parseInt(teaEvaluForm.getQ2()) - Integer
						.parseInt(oq2))).toString(),
				((Integer) (Integer.parseInt(teaEvaluForm.getQ3()) - Integer
						.parseInt(oq3))).toString(),
				((Integer) (Integer.parseInt(teaEvaluForm.getQ4()) - Integer
						.parseInt(oq4))).toString(),
				((Integer) (Integer.parseInt(teaEvaluForm.getQ5()) - Integer
						.parseInt(oq5))).toString(),
				((Integer) (Integer.parseInt(teaEvaluForm.getQ6()) - Integer
						.parseInt(oq6))).toString(),
				((Integer) (Integer.parseInt(teaEvaluForm.getQ7()) - Integer
						.parseInt(oq7))).toString(),
				((Integer) (Integer.parseInt(teaEvaluForm.getQ8()) - Integer
						.parseInt(oq8))).toString(),
				((Integer) (Integer.parseInt(teaEvaluForm.getQ9()) - Integer
						.parseInt(oq9))).toString(), ((Integer) (Integer
						.parseInt(teaEvaluForm.getQ10()) - Integer
						.parseInt(oq10))).toString(), ((Integer) (Integer
						.parseInt(teaEvaluForm.getQ11()) - Integer
						.parseInt(oq11))).toString(), ((Integer) (Integer
						.parseInt(teaEvaluForm.getSum()) - Integer
						.parseInt(osum))).toString(), 0, tid, cid, teaEvaluForm.getXn(), teaEvaluForm.getXq());
		
//		tx.commit();

		String URI = "form/updateTeacherEvaluation.jsp";

		return new ActionForward(URI, true);
		// return mapping.findForward("updateSuccess");
	}

	// 显示教师自己的课程列表
	public ActionForward myCourseList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String tid = (String) request.getSession().getAttribute("ID");
		TeacherDAO teacherDao = new TeacherDAO();
		List<Object[]> myCourseList = null;

		myCourseList = teacherDao.findMyCourse(tid);

		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : myCourseList) {
			data += "{\"Dept\":\"" + obj[0] + "\",\"facult\":\"" + obj[1]
					+ "\",\"XN\":\"" + obj[2] + "\",\"XQ\":\"" + obj[3]
					+ "\",\"TID\":\"" + obj[4] + "\",\"TName\":\"" + obj[5]
					+ "\",\"CID\":\"" + obj[6] + "\",\"CNAME\":\"" + obj[7]
					+ "\",\"CourseType\":\"" + obj[8]+ "\",\"ISEVALU\":\"" + obj[9] + "\"},";
			count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("myCourseList", subData);

		return mapping.findForward("teacherOwnCourse");
	}

	// 查看一门课程的具体评价结果
	public ActionForward oneCourseResult(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		TeaEvalutionForm teaForm = (TeaEvalutionForm) form;
		TeaEvalResDAO teaResDao = new TeaEvalResDAO();
		List<Object[]> oneCourseScoreList = null;

//		oneCourseScoreList = teaResDao.oneCourseScores(teaForm.getTeaid(),
//				teaForm.getCid(), teaForm.getXn(), teaForm.getXq());

		oneCourseScoreList = teaResDao.oneCourseScores(teaForm.getTeaid(),
				teaForm.getCid(), teaForm.getXn(), teaForm.getXq());
		
		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : oneCourseScoreList) {
			data += "{\"CName\":\"" + obj[0] + "\",\"CID\":\"" + obj[1]
					+ "\",\"Q1\":\"" + obj[2] + "\",\"Q2\":\"" + obj[3]
					+ "\",\"Q3\":\"" + obj[4] + "\",\"Q4\":\"" + obj[5]
					+ "\",\"Q5\":\"" + obj[6] + "\",\"Q6\":\"" + obj[7]
					+ "\",\"Q7\":\"" + obj[8] + "\",\"Q8\":\"" + obj[9]
					+ "\",\"Q9\":\"" + obj[10] + "\",\"Q10\":\"" + obj[11]
					+ "\",\"Q11\":\"" + obj[12] + "\",\"QSum\":\"" + obj[13]
					+ "\",\"Number\":\"" + obj[14] + "\",\"TName\":\"" + obj[15]+ "\"},";
			count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("courseScores", subData);

		return mapping.findForward("courseEvaluScore");

	}

	// 查看所有已评课程的评价结果
	public ActionForward courseResults(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TeaEvalutionForm teaForm = (TeaEvalutionForm) form;
		TeaEvalResDAO teaResDao = new TeaEvalResDAO();
		String tid = request.getSession().getAttribute("ID").toString();
		String cid = "";
		List<Object[]> courseList = null;

		courseList = teaResDao.courseScores(tid, cid);

		int count = 0;
		String data = "{Rows:[";
		for (Object[] obj : courseList) {
			data += "{\"CName\":\"" + obj[0] + "\",\"CID\":\"" + obj[1]
					+ "\",\"Q1\":\"" + obj[2] + "\",\"Q2\":\"" + obj[3]
					+ "\",\"Q3\":\"" + obj[4] + "\",\"Q4\":\"" + obj[5]
					+ "\",\"Q5\":\"" + obj[6] + "\",\"Q6\":\"" + obj[7]
					+ "\",\"Q7\":\"" + obj[8] + "\",\"Q8\":\"" + obj[9]
					+ "\",\"Q9\":\"" + obj[10] + "\",\"Q10\":\"" + obj[11]
					+ "\",\"Q11\":\"" + obj[12] + "\",\"QSum\":\"" + obj[13]
					+ "\",\"Number\":\"" + obj[14] + "\"},";
			count++;
		}
		String subData = data.substring(0, data.length() - 1);
		subData += "],Total:" + count + "}";
		System.out.println(subData);
		request.setAttribute("courseScores", subData);

		return mapping.findForward("courseEvaluScore");

	}

	// 查看图表形式的评价结果
	public ActionForward teaScoreCharts(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("q1", request.getParameter("q1"));
		request.setAttribute("q2", request.getParameter("q2"));
		request.setAttribute("q3", request.getParameter("q3"));
		request.setAttribute("q4", request.getParameter("q4"));
		request.setAttribute("q5", request.getParameter("q5"));
		request.setAttribute("q6", request.getParameter("q6"));
		request.setAttribute("q7", request.getParameter("q7"));
		request.setAttribute("q8", request.getParameter("q8"));
		request.setAttribute("q9", request.getParameter("q9"));
		request.setAttribute("q10", request.getParameter("q10"));
		request.setAttribute("q11", request.getParameter("q11"));
		request.setAttribute("qsum", request.getParameter("qsum"));

		return mapping.findForward("teacherScoreCharts");
	}
}
