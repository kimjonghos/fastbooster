package com.teamwith15.test;

import java.util.ArrayList;
import java.util.List;

import com.teamwith15.service.MemberService;
import com.teamwith15.util.Criteria;
import com.teamwith15.vo.MemberPraiseVO;
import com.teamwith15.vo.MemberProjectCategoryVO;
import com.teamwith15.vo.MemberSkillVO;

public class MemberServiceTest {

	public static void main(String[] args) {
		MemberService ms = MemberService.getInstance();
		Criteria cri = new Criteria();
		cri.setPage(0);
		cri.setPerPageNum(10);
	
	/*	System.out.println("1: "+ms.getBestMember(cri));
		System.out.println("2: "+ms.getMainProfile("jo"));
		
		List<String> projectCategoryId = new ArrayList<String>();
		projectCategoryId.add("project-category-1");
		System.out.println("3: "+ms.getMemberByProjectCategoryId(projectCategoryId));
		
		List<String> a = new ArrayList<String>();
		a.add("role-1");
		cri.addCriteria("roleList", a);
		List<String> b =new ArrayList<String>();
		b.add("region-1");
		cri.addCriteria("regionList", b);
		System.out.println("4: "+ms.getMemberByRoleRegion(cri));
		
		List<String> ss = new ArrayList<String>();
		ss.add("skill-1");
		System.out.println("4: "+ms.getMemberBySkillId(ss));
		System.out.println("5: "+ms.getMemberPraiseCnt("jo"));
		System.out.println("6: "+ms.getMemberPriase("jo", "yim"));
		System.out.println("7: "+ms.getMemberProjectCategory("jo"));
		
		System.out.println("8: "+ms.getMemberSkill("jo"));
		System.out.println("9: "+ms.getRecentMember(cri));
		System.out.println("10: "+ms.removeMemberPraise("jo"));
		System.out.println("11: "+ms.removeMemberProjectCategory("jo"));
		System.out.println("12: "+ms.removeMemberSkill("jo"));
		System.out.println("13: "+ms.searchMemberRoleRegion("joo"));
		List<MemberPraiseVO> praise = new ArrayList<MemberPraiseVO>();
		praise.add(new MemberPraiseVO("jo", "yim", "praise-1"));
		System.out.println("14: "+ms.updateMemberPraise(praise));
		List<MemberProjectCategoryVO> memberProjectCategory = new ArrayList<MemberProjectCategoryVO>();
		//memberProjectCategory.add(new MemberProjectCategoryVO("kim", "project-category-1"));
		//System.out.println("15: "+ms.updateMemberProjectCategory(memberProjectCategory));
		List<MemberSkillVO> memberSkill = new ArrayList<MemberSkillVO>();
		memberSkill.add(new MemberSkillVO("kim", "skill-1", "3"));
		System.out.println("16: "+ms.updateMemberSkill(memberSkill));
		*/
	}
}
