package com.teamwith15.dao;

import java.util.List;

import com.teamwith15.vo.MemberCommentVO;

public interface MemberCommentDAO {
	// ��� ��������
	public List<MemberCommentVO> searchMemberComment() throws Exception;
}
