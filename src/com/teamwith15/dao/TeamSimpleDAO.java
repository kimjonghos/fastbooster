//�ۼ��� : Ȳ����
package com.teamwith15.dao;

import java.util.List;
import java.util.Map;

import com.teamwith15.util.Criteria;
import com.teamwith15.vo.TeamSimpleVO;

public interface TeamSimpleDAO {
	/** ��� �� ���� ���� �ֽż����� ã��*/
	public List<TeamSimpleVO> searchRecentTeamSimple(Criteria cri) throws Exception;
	/** Ư�� ȸ���� �� ���� ���� ã��*/
	public List<TeamSimpleVO> searchMyTeamSimple(String memberId) throws Exception;
	/** ��� �� ���� ���� �ҷ�����*/
	public List<TeamSimpleVO> searchTeamSimpleAll() throws Exception;
	
	public List<TeamSimpleVO> searchTeamSimpleAllByMemberId(Map<String, Object> paramMap) throws Exception;
	
	public List<TeamSimpleVO> searchTeamSimpleAllByTeamId(Criteria cir) throws Exception;
	
	public TeamSimpleVO searchTeamSimple(String teamId) throws Exception;
}
