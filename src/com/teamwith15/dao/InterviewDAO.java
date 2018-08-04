package com.teamwith15.dao;

import java.util.List;

import com.teamwith15.vo.InterviewVO;

public interface InterviewDAO {
	public List<InterviewVO> searchInterview(String applicationId);
	public List<InterviewVO> searchInterviewAll(String teamId);
}
