package com.teamwith15.dao;

import java.util.List;

import com.teamwith15.dto.ApplicationDTO;

public interface ApplicationDAO {	
	/** Appliction_tb에 레코드 추가*/
	public int addApplication(ApplicationDTO application) throws Exception;
	/** application_id에 해당하는 레코드 삭제*/
	public int removeApplicationByApplicationId(String applicationId) throws Exception;
	/** application_id에 해당하는 레코드의 application_status값 수정 */
	public int updateApplicationStatusByApplicationId(ApplicationDTO application) throws Exception;
	/** application_id에 해당하는 레코드의 모든 속성값 수정*/
	public int updateApplicationAll(ApplicationDTO application) throws Exception;
	/** application_id에 해당하는 레코드 검색 */
	public ApplicationDTO searchApplicationByApplicationId(String applicationId) throws Exception;
	/** 특정 회원의 지원내역 검색 (내 지원내역 검색에 사용)*/
	public List<ApplicationDTO> searchApplicationByMemberId(String memberId) throws Exception;
	/** 특정 팀에 지원한 지원자의 지원내역 검색 (내 팀 지원자 보기에 사용)*/
	public List<ApplicationDTO> searchApplicationByTeamId(String teamId) throws Exception;
	/** 모든 지원내역 불러오기*/
	public List<ApplicationDTO> searchApplicationAll() throws Exception;
	public List<String> getApplicationId() throws Exception;
}
