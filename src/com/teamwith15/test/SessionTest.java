package com.teamwith15.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.teamwith15.dao.InterviewQuestionDAO;
import com.teamwith15.dao.PortfolioContentDAO;
import com.teamwith15.dto.InterviewQuestionDTO;
import com.teamwith15.dto.PortfolioContentDTO;

public class SessionTest {
	public static void main(String[] args) {
		//각 서비스 생성자에서 공통적으로 하는일
		String config = "com/teamwith15/config/config.xml";
		SqlSessionFactory factory = null;
		try {
			InputStream is = Resources.getResourceAsStream(config);
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlSession session = factory.openSession();

		//간단 면접 질문과 포트폴리오 컨텐츠를 추가하는 서비스 메소드
		InterviewQuestionDAO interviewQuestionDAO = session.getMapper(InterviewQuestionDAO.class);
		PortfolioContentDAO portfolioContentDAO = session.getMapper(PortfolioContentDAO.class);
		int result=1;//결과값 저장 변수

		// 간단면접질문 저장로직 
		InterviewQuestionDTO interviewQuestion = new InterviewQuestionDTO();
		interviewQuestion.setInterviewQuestionContent("세션 테스트 질문");
		interviewQuestion.setInterviewQuestionId("interview_question-7");
		interviewQuestion.setTeamId("team-2");
		try {
			interviewQuestionDAO.addInterviewQuestion(interviewQuestion);
		
		// 포트폴리오 컨텐츠 추가 로직
			PortfolioContentDTO pc = new PortfolioContentDTO();
			pc.setPortfolioContentId("portfolio_content-91");
			pc.setPortfolioId("portfolio-1");
			pc.setPortfolioContentOrder(2);
			pc.setLayoutId("t2");
			pc.setPortfolioContentName("portfolio_content-91 name");
			pc.setPortfolioContentValue("portfolio_content-91 value");
			try {
				Integer.parseInt("글자"); //강제로 오류 발생시킴 // 트랜잭션 완료 상황 테스트는 이 라인 주석으로.
				portfolioContentDAO.addPortfolioContent(pc);
			} catch (Exception e) {
				result=0;	//포트폴리오 컨텐츠 추가 실패시
				e.printStackTrace();
			}
		} catch (Exception e) {
			result=0;		//인터뷰퀘스쳔 추가 실패시
			e.printStackTrace();
		}
		
		//결과값에 따라 트랜잭션 처리
		if(result==0) {	
			session.rollback();
		}
		else if(result==1) {
			session.commit();
		}
		session.close();
		System.out.println("완료");
	}
}
