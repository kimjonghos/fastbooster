package com.teamwith15.test;

import java.util.List;

import com.teamwith15.service.ApplicationService;
import com.teamwith15.vo.InterviewVO;

public class KyuTest {
	public static void main(String[] args) {
		//ApplicationService Test
		
		ApplicationService appServ = ApplicationService.getInstance();

//		ApplicationService - getMyInterview test
//		List<InterviewVO> result=appServ.getMyInterview("application-1");
//		for(InterviewVO interview : result) {
//			System.out.println(result);
//		}

//		ApplicationService - getMyApplication test
//		List<MyApplicationVO> result=appServ.getMyApplication("yim");
//		for(MyApplicationVO myApplication : result) {
//			System.out.println(myApplication);
//		}
		
//		ApplicationService - getJoinedTeamId test
//		List<String> result=appServ.getJoinedTeamId("yim");
//		for(String teamId : result) {
//			System.out.println(teamId);
//		}
		
//		ApplicationService - getApplicant test
//		List<ApplicantVO> result=appServ.getApplicant("team-1");
//		for(ApplicantVO applicant : result) {
//			System.out.println(applicant);
//		}
		
//		ApplicationService - getInterview test
//		List<InterviewVO> result=appServ.getInterview("team-1");
//		for(InterviewVO interview : result) {
//			System.out.println(interview);
//		}
		
//		ApplicationService - changeApplicationStatus test
//		appServ.changeApplicationStatus(1, "application-1");
//		ApplicationService - registerInteviewQuestion test
//		List<InterviewVO> param = new ArrayList<InterviewVO>();
//		param.add(new InterviewVO("team-2","질문1번이에용",null,null,null));
//		param.add(new InterviewVO("team-2","질문2번이에용",null,null,null));
//		param.add(new InterviewVO("team-2","질문3번이에용",null,null,null));
//		appServ.registerInteviewQuestion(param);

//		ApplicationService - applyTeam test
//		ApplicationVO application=new ApplicationVO();
//		application.setApplicationFreewriting("받던지 말던지 맘대로해");
//		application.setMemberId("joo");
//		application.setRoleId("role-2");
//		application.setTeamId("team-2");
//		System.out.println(appServ.applyTeam(application));
		
//		ApplicationService - applyTeam test
//		List<InterviewVO> list=new ArrayList<InterviewVO>();
//		InterviewVO interview1=new InterviewVO();
//		interview1.setInterviewAnswerContent("이게 질문인가요?");
//		interview1.setInterviewQuestionId("interview_question-4");
//		interview1.setApplicationId("application-5");
//		InterviewVO interview2=new InterviewVO();
//		interview2.setInterviewAnswerContent("이게 질문인가요2?");
//		interview2.setInterviewQuestionId("interview_question-5");
//		interview2.setApplicationId("application-5");
//		list.add(interview1);
//		list.add(interview2);
//		System.out.println(appServ.applyTeam(list));
	}
}
