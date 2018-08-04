//작성자 : 황규진
package com.teamwith15.dao;

import java.util.List;

import com.teamwith15.dto.InterviewAnswerDTO;

public interface InterviewAnswerDAO {
	/** 간단 면접 답변 추가 */
	public int addInterviewAnswer(InterviewAnswerDTO interviewAnswer) throws Exception;
	/** 간단 면접 답변 삭제*/
	public int removeInterviewAnswerByInterviewAnswerId(String interviewAnswerId) throws Exception;
	/** interview_answer_id에 해당하는 레코드의 interview_content를 수정한다.*/
	public int updateInterviewAnswer(InterviewAnswerDTO interviewAnswer) throws Exception;
	/** interview_answer_id에 해당하는 레코드의 모든 속성을 수정한다.*/
	public int updateInterviewAnswerAll(InterviewAnswerDTO interviewAnswer) throws Exception;
	/** interviewAnswerId가 일치하는 하나의 InterviewAnswerDTO 객체 반환*/
	public InterviewAnswerDTO searchInterviewAnswerByInterviewAnswerId(String interviewAnswerId) throws Exception;
	/** interviwe_question_id가 일치하는 모든 InterviewAnswerDTO 객체 반환*/
	public List<InterviewAnswerDTO> searchInterviewAnswerByInterviewQuestionId(String interviewQuestionId) throws Exception;
	/** application_id가 일치하는 모든 InterviewAnswerDTO 객체 반환*/
	public List<InterviewAnswerDTO> searchInterviewAnswerByApplicationId(String applicationId) throws Exception;
	/** interview_question_id와 application_id가 일치하는 InterviewAnswerDTO 객체 반환*/
	public InterviewAnswerDTO searchInterviewAnswer(InterviewAnswerDTO interviewAnswer) throws Exception;
	/** 모든 간단 면접 답변 레코드 불러오기*/
	public List<InterviewAnswerDTO> searchInterviewAnswerAll() throws Exception;
	/** 간단 면접 답변 키값 불러오기 */
	public List<String> getInterviewAnswerId() throws Exception;
} 
