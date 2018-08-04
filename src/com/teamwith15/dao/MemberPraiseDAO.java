package com.teamwith15.dao;

import java.util.List;

import com.teamwith15.dto.MemberPraiseDTO;
import com.teamwith15.vo.MemberPraiseCntVO;
import com.teamwith15.vo.MemberPraiseVO;

public interface MemberPraiseDAO {
	public int addMemberPraise(MemberPraiseDTO dto) throws Exception;

	public int removeMemberPraise(MemberPraiseDTO dto) throws Exception;

	public int removeMemberAllPraise(String memberId) throws Exception;

	public List<MemberPraiseDTO> searchMemberAllPraise(String memberId) throws Exception;

	public List<MemberPraiseDTO> searchMemberPraise(MemberPraiseDTO dto) throws Exception;

	public List<MemberPraiseCntVO> searchMemberPraiseCnt(String memberId) throws Exception;

	public List<MemberPraiseDTO> searchAllMemberPraise() throws Exception;
}
