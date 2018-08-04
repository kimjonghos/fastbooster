package com.teamwith15.dao;

import java.util.List;
import java.util.Map;

import com.teamwith15.util.Criteria;
import com.teamwith15.vo.MemberSearchVO;

public interface MemberSearchDAO {
	public List<MemberSearchVO> searchMemberAll() throws Exception;

	public MemberSearchVO searchMemberByMemberId(String memberId) throws Exception;

	public List<MemberSearchVO> searchMemberByRoleRegion(Criteria cri) throws Exception;

	public List<MemberSearchVO> searchRecentMember(Criteria cri) throws Exception;

	public List<MemberSearchVO> searchMemberByPraiseCnt(Criteria cri) throws Exception;

	public List<MemberSearchVO> searchMember(Criteria cri) throws Exception;

}
