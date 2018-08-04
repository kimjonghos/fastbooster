package com.teamwith15.dao;

import java.util.List;

import com.teamwith15.dto.MemberTendencyDTO;

public interface MemberTendencyDAO {
	public int addMemberTendency(MemberTendencyDTO dto) throws Exception;

	public int updateTendencyFigure(MemberTendencyDTO dto) throws Exception;

	public int removeMemberTendency(String memberId) throws Exception;

	public List<MemberTendencyDTO> searchMemberTendency(String memberId) throws Exception;

	public List<MemberTendencyDTO> searchAllMemberTendency() throws Exception;
}
