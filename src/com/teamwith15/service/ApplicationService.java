//작성자 : 황규진
package com.teamwith15.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.teamwith15.dao.ApplicantDAO;
import com.teamwith15.dao.ApplicationDAO;
import com.teamwith15.dao.InterviewAnswerDAO;
import com.teamwith15.dao.InterviewDAO;
import com.teamwith15.dao.InterviewQuestionDAO;
import com.teamwith15.dao.MyApplicationDAO;
import com.teamwith15.dto.ApplicationDTO;
import com.teamwith15.dto.InterviewAnswerDTO;
import com.teamwith15.dto.InterviewQuestionDTO;
import com.teamwith15.vo.ApplicantVO;
import com.teamwith15.vo.ApplicationVO;
import com.teamwith15.vo.InterviewVO;
import com.teamwith15.vo.MemberSearchVO;
import com.teamwith15.vo.MyApplicationVO;

public class ApplicationService {
	private static ApplicationService applicationService;
	static {
		applicationService=new ApplicationService();
	}
	private SqlSessionFactory factory;
	private SqlSession session;

	private ApplicationService() {
		String config = "com/teamwith15/config/config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(config);
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ApplicationService getInstance() {
		return applicationService;
	}

	private void openSession() {
		session = factory.openSession();
	}

	private void commitSession() {
		session.commit();
	}

	private void closeSession() {
		session.close();
	}

	public List<InterviewVO> getMyInterview(String applicationId) {
		openSession();
		InterviewDAO interviewDAO = session.getMapper(InterviewDAO.class);
		List<InterviewVO> result = interviewDAO.searchInterview(applicationId);
		closeSession();
		return result;
	}

	public List<MyApplicationVO> getMyApplication(String memberId) {
		openSession();
		MyApplicationDAO myApplicationDAO = session.getMapper(MyApplicationDAO.class);
		List<MyApplicationVO> result = null;
		try {
			result = myApplicationDAO.searchMyApplication(memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeSession();
		return result;
	}

	public List<String> getJoinedTeamId(String memberId) {
		openSession();
		ApplicationDAO applicationDAO = session.getMapper(ApplicationDAO.class);
		List<String> result = new ArrayList<String>();
		try {
			List<ApplicationDTO> applications = applicationDAO.searchApplicationByMemberId(memberId);
			for (ApplicationDTO application : applications) {
				result.add(application.getTeamId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeSession();
		return result;
	}

	public List<ApplicantVO> getApplicant(String teamId) {
		openSession();
		ApplicantDAO applicantDAO = session.getMapper(ApplicantDAO.class);
		List<ApplicantVO> result = null;
		try {
			result = applicantDAO.searchApplicantByTeamId(teamId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeSession();

		return result;
	}

	public List<InterviewVO> getInterview(String teamId) {
		openSession();
		InterviewDAO interviewDAO = session.getMapper(InterviewDAO.class);
		List<InterviewVO> result = interviewDAO.searchInterviewAll(teamId);
		closeSession();
		return result;
	}

	public int changeApplicationStatus(int status, String applicationId) {
		openSession();
		ApplicationDAO applicationDAO = session.getMapper(ApplicationDAO.class);
		ApplicationDTO application = new ApplicationDTO();
		application.setApplicationStatus(status);
		application.setApplicationId(applicationId);
		int result = 0;
		try {
			result = applicationDAO.updateApplicationStatusByApplicationId(application);
		} catch (Exception e) {
			e.printStackTrace();
		}
		commitSession();
		closeSession();
		return result;
	}

	public int registerInteviewQuestion(List<InterviewVO> interviewQuestion) {
		openSession();
		InterviewQuestionDAO interviewQuestionDAO = session.getMapper(InterviewQuestionDAO.class);
		int result = 0;
		for (InterviewVO interview : interviewQuestion) {
			InterviewQuestionDTO question = new InterviewQuestionDTO();
			List<String> keys;
			try {
				keys = interviewQuestionDAO.getInterviewQuestionId();
				String id = generateId(keys, "interview_question");
				question.setInterviewQuestionId(id);
				System.out.println(id);
				question.setTeamId(interview.getTeamId());
				question.setInterviewQuestionContent(interview.getInterviewQuestionContent());
				result = interviewQuestionDAO.addInterviewQuestion(question);
			} catch (Exception e) {
				result = 0;
				e.printStackTrace();
			}
		}
		commitSession();
		closeSession();
		return result;
	}

	public int applyTeam(ApplicationVO application) {
		openSession();
		ApplicationDAO applicationDAO = session.getMapper(ApplicationDAO.class);
		ApplicationDTO applicationDTO = null;
		int result = 0;
		try {
			applicationDTO = application.toDTO();
			String id = generateId(applicationDAO.getApplicationId(), "application");
			applicationDTO.setApplicationId(id);
			result = applicationDAO.addApplication(applicationDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		commitSession();
		closeSession();
		return result;
	}

	public int applyTeam(List<InterviewVO> interviewAnswer) {
		openSession();
		InterviewAnswerDAO interviewAnswerDAO = session.getMapper(InterviewAnswerDAO.class);
		int result=0;
		try {
			for (InterviewVO interview : interviewAnswer) {
				InterviewAnswerDTO interviewDTO = new InterviewAnswerDTO();
				List<String> interviewIds = interviewAnswerDAO.getInterviewAnswerId();
				String id = generateId(interviewIds, "interview_answer");
				interviewDTO.setApplicationId(interview.getApplicationId());
				interviewDTO.setInterviewAnswerContent(interview.getInterviewAnswerContent());
				interviewDTO.setInterviewAnswerId(id);
				interviewDTO.setInterviewQuestionId(interview.getInterviewQuestionId());
				result=interviewAnswerDAO.addInterviewAnswer(interviewDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		commitSession();
		closeSession();

		return result;
	}

	public List<MemberSearchVO> getTeamMember(String teamId) {
		openSession();
		ApplicantDAO applicantDAO=session.getMapper(ApplicantDAO.class);
		List<MemberSearchVO> result=null;
		try{
			List<ApplicantVO> applicants=applicantDAO.searchApplicantByTeamId(teamId);
			result=new ArrayList<MemberSearchVO>();
			for(ApplicantVO applicant : applicants) {
				if(Integer.parseInt(applicant.getApplicationStatus())==1) {
					MemberSearchVO teamMember=new MemberSearchVO();
					teamMember.setMemberId(applicant.getMemberId());
					teamMember.setMemberName(applicant.getMemberName());
					teamMember.setMemberPic(applicant.getMemberPic());
					result.add(teamMember);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		closeSession();
		return result;
	}

	private String generateId(List<String> id, String tableName) {
		if (id == null) {
			return tableName + "-" + 1;
		}

		int maxCnt = -1;

		for (String str : id) {
			if (maxCnt < Integer.parseInt(str.split("-")[1])) {
				maxCnt = Integer.parseInt(str.split("-")[1]);
			}
		}

		return tableName + "-" + (maxCnt + 1);
	}
}
