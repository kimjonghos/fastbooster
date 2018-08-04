package com.teamwith15.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.teamwith15.dao.MainProfileDAO;
import com.teamwith15.dao.MemberPraiseDAO;
import com.teamwith15.dao.MemberProjectCategoryDAO;
import com.teamwith15.dao.MemberSearchDAO;
import com.teamwith15.dao.MemberSkillDAO;
import com.teamwith15.dto.MemberPraiseDTO;
import com.teamwith15.dto.MemberProjectCategoryDTO;
import com.teamwith15.dto.MemberSkillDTO;
import com.teamwith15.util.Criteria;
import com.teamwith15.vo.MainProfileVO;
import com.teamwith15.vo.MemberPraiseCntVO;
import com.teamwith15.vo.MemberPraiseVO;
import com.teamwith15.vo.MemberProjectCategoryVO;
import com.teamwith15.vo.MemberSearchVO;
import com.teamwith15.vo.MemberSimpleVO;
import com.teamwith15.vo.MemberSkillVO;

public class MemberService {
	private static MemberService memberService;

	private SqlSessionFactory factory;
	private SqlSession session;

	private MainProfileDAO mainProfileDAO;
	private MemberPraiseDAO memberPraiseDAO;
	private MemberProjectCategoryDAO memberProjectCategoryDAO;
	private MemberSearchDAO memberSearchDAO;
	private MemberSkillDAO memberSkillDAO;

	static {
		memberService = new MemberService();
	}

	private MemberService() {
		String file = "com/teamwith15/config/config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		factory = new SqlSessionFactoryBuilder().build(is);
	}

	public static MemberService getInstance() {
		if (memberService == null) {
			memberService = new MemberService();
		}
		return memberService;
	}

	public void openSession() {
		session = factory.openSession();
	}

	public void commitSession() {
		session.commit();
	}

	public void closeSession() {
		session.close();
	}

	public MainProfileVO getMainProfile(String memberId) throws Exception {
		mainProfileDAO = session.getMapper(MainProfileDAO.class);
		MainProfileVO result = mainProfileDAO.searchMainProfile(memberId);
		return result;
	}

	public List<MemberSearchVO> getBestMember(Criteria cri) throws Exception {
		if (cri == null) {
			return null;
		}
		memberSearchDAO = session.getMapper(MemberSearchDAO.class);
		List<MemberSearchVO> result = memberSearchDAO.searchMemberByPraiseCnt(cri);
		return result;
	}

	public List<MemberSearchVO> getRecentMember(Criteria cri) throws Exception {
		if (cri == null) {
			return null;
		}
		memberSearchDAO = session.getMapper(MemberSearchDAO.class);
		List<MemberSearchVO> result = memberSearchDAO.searchRecentMember(cri);
		return result;
	}

	public List<String> getMemberByProjectCategoryId(List<String> projectCategoryId) throws Exception {
		if (projectCategoryId == null) {
			return null;
		}
		memberProjectCategoryDAO = session.getMapper(MemberProjectCategoryDAO.class);
		List<MemberProjectCategoryDTO> temp = memberProjectCategoryDAO.searchMemberByProjectCategory(projectCategoryId);
		List<String> result = new ArrayList<String>();
		for (MemberProjectCategoryDTO m : temp) {
			result.add(m.getMemberId());
		}
		return result;
	}

	public List<MemberSimpleVO> getMemberByRoleRegion(Criteria cri) throws Exception {
		if (cri == null) {
			return null;
		}
		memberSearchDAO = session.getMapper(MemberSearchDAO.class);
		List<MemberSearchVO> temp = memberSearchDAO.searchMemberByRoleRegion(cri);
		List<MemberSimpleVO> result = new ArrayList<MemberSimpleVO>();
		for (MemberSearchVO m : temp) {
			MemberSimpleVO ms = new MemberSimpleVO();
			ms.setMemberId(m.getMemberId());
			ms.setMemberName(m.getMemberName());
			ms.setMemberPic(m.getMemberPic());
			result.add(ms);
		}
		return result;
	}

	public List<String> getMemberBySkillId(List<String> skillId) throws Exception {
		if (skillId == null) {
			return null;
		}
		memberSkillDAO = session.getMapper(MemberSkillDAO.class);
		List<MemberSkillDTO> temp = memberSkillDAO.searchMemberBySkill(skillId);
		List<String> result = new ArrayList<String>();
		for (MemberSkillDTO m : temp) {
			result.add(m.getMemberId());
		}
		return result;
	}

	public Criteria searchMemberRoleRegion(String memberId) throws Exception {
		if (memberId == null) {
			return null;
		}
		memberSearchDAO = session.getMapper(MemberSearchDAO.class);
		MemberSearchVO temp = memberSearchDAO.searchMemberByMemberId(memberId);
		Criteria result = new Criteria();
		result.addCriteria("memberRegion1", temp.getRegionId1());
		result.addCriteria("memberRegion2", temp.getRegionId2());
		result.addCriteria("memberRole", temp.getRoleId());

		return result;
	}

	public List<String> getMemberProjectCategory(String memberId) throws Exception {
		if (memberId == null) {
			return null;
		}
		memberProjectCategoryDAO = session.getMapper(MemberProjectCategoryDAO.class);
		List<MemberProjectCategoryDTO> temp = memberProjectCategoryDAO.searchProjectCategoryByMember(memberId);
		List<String> result = new ArrayList<String>();
		for (MemberProjectCategoryDTO m : temp) {
			result.add(m.getProjectCategoryId());
		}

		return result;
	}

	public MemberSkillVO getMemberSkill(String memberId) throws Exception {
		if (memberId == null) {
			return null;
		}
		memberSkillDAO = session.getMapper(MemberSkillDAO.class);
		List<MemberSkillDTO> temp = memberSkillDAO.searchSkillByMember(memberId);
		MemberSkillVO result = new MemberSkillVO(temp);

		return result;
	}

	public List<MemberPraiseCntVO> getMemberPraiseCnt(String memberId) throws Exception {
		if (memberId == null) {
			return null;
		}
		memberPraiseDAO = session.getMapper(MemberPraiseDAO.class);
		List<MemberPraiseCntVO> result = memberPraiseDAO.searchMemberPraiseCnt(memberId);

		return result;
	}

	public int removeMemberProjectCategory(String memberId) throws Exception {
		if (memberId == null) {
			return -1;
		}
		memberProjectCategoryDAO = session.getMapper(MemberProjectCategoryDAO.class);
		int result = memberProjectCategoryDAO.removeMemberProjectCategoryByMemberId(memberId);

		return result;
	}

	public int updateMemberProjectCategory(MemberProjectCategoryVO memberProjectCategory) throws Exception {
		if (memberProjectCategory == null) {
			return -1;
		}
		memberProjectCategoryDAO = session.getMapper(MemberProjectCategoryDAO.class);
		int result = memberProjectCategoryDAO
				.removeMemberProjectCategoryByMemberId(memberProjectCategory.getMemberId());
		if (result == 0) {
			return -1;
		}

		for (MemberProjectCategoryDTO m : memberProjectCategory.toDTO()) {
			memberProjectCategoryDAO.addMemberProjectCategory(m);
		}
		return result;
	}

	public int removeMemberSkill(String memberId) throws Exception {
		if (memberId == null) {
			return -1;
		}
		memberSkillDAO = session.getMapper(MemberSkillDAO.class);
		int result = memberSkillDAO.reomveMemberAllSkill(memberId);

		return result;
	}

	public int updateMemberSkill(MemberSkillVO memberSkill) throws Exception {
		if (memberSkill == null) {
			return -1;
		}
		int result = memberSkillDAO.reomveMemberAllSkill(memberSkill.getMemberId());
		if (result == 0) {
			return -1;
		}
		for (MemberSkillDTO m : memberSkill.toDTO()) {
			memberSkillDAO.addMemberSkill(m);
		}

		return result;
	}

	public int updateMemberPraise(List<MemberPraiseVO> praise) throws Exception {
		if (praise == null || praise.isEmpty()) {
			return -1;
		}
		memberPraiseDAO = session.getMapper(MemberPraiseDAO.class);
		int result = memberPraiseDAO.removeMemberPraise(praise.get(0).toDTO());
		for (MemberPraiseVO m : praise) {
			result = memberPraiseDAO.addMemberPraise(m.toDTO());
			if (result != 1) {
				return -1;
			}
		}

		return result;
	}

	public int removeMemberPraise(String memberId) throws Exception {
		if (memberId == null) {
			return -1;
		}
		memberPraiseDAO = session.getMapper(MemberPraiseDAO.class);
		int result = memberPraiseDAO.removeMemberAllPraise(memberId);

		return result;
	}

	public List<MemberPraiseVO> getMemberPriase(String actor, String target) throws Exception {
		if (actor == null || target == null) {
			return null;
		}
		memberPraiseDAO = session.getMapper(MemberPraiseDAO.class);
		List<MemberPraiseDTO> temp = memberPraiseDAO.searchMemberPraise(new MemberPraiseDTO(actor, target, ""));
		List<MemberPraiseVO> result = new ArrayList<MemberPraiseVO>();
		for (MemberPraiseDTO m : temp) {
			result.add(m.toVO());
		}
		return result;
	}

}
