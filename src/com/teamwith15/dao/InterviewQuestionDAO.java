//작성자 : 황규진
package com.teamwith15.dao;

import java.util.List;

import com.teamwith15.dto.InterviewQuestionDTO;

public interface InterviewQuestionDAO {
	/** 간단 면접 답변 추가*/
	public int addInterviewQuestion(InterviewQuestionDTO interviewQuestion) throws Exception;
	/** 간단 면접 답변 삭제*/
	public int removeInterviewQuestion(String interviewQuestionId) throws Exception;
	/** interview_question_id에 해당하는 레코드의 interview_question_content를 변경 (미사용)*/
	public int updateInterviewQuestion(InterviewQuestionDTO interviewQuestion) throws Exception;
	/** interview_question_id에 해당하는 레코드의 모든 속성을 변경 */
	public int updateInterviewQuestionAll(InterviewQuestionDTO interviewQuestion) throws Exception;
	/** 특정 간단 면접 질문 보기*/
	public InterviewQuestionDTO searchInterviewQuestionByInterviewQuestionId(String interviewQuestionId) throws Exception;
	/** 특정 팀의 모든 간단 면접 질문 보기 */
	public List<InterviewQuestionDTO> searchInterviewQuestionByTeamId(String teamId) throws Exception;
	/** 간단 면접 질문의 모든 키값 가져오기 */
	public List<String> getInterviewQuestionId() throws Exception;
}
