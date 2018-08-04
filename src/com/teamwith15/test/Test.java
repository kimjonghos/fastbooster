package com.teamwith15.test;

import java.util.ArrayList;
import java.util.List;

import com.teamwith15.service.TeamService;
import com.teamwith15.util.Criteria;
import com.teamwith15.vo.TeamSimpleVO;

public class Test {

	public static void main(String[] args) throws Exception {
		TeamService service = TeamService.getInstance();
/*
		List<FaqVO> getFaq(String teamId)
		List<FaqVO> list = service.getFaq("team-1");
		for(FaqVO obj : list) {
			System.out.println(obj);
		}
*/
/*
		List<TeamSimpleVO> getMyTeam(Criteria cri, String memberId)
		List<TeamSimpleVO> list = service.getMyTeam(new Criteria(), "jo");
		for(TeamSimpleVO obj : list) {
			System.out.println(obj);
		}
*/
/*
		TeamSimpleVO getTeamSimple(String teamId)
		TeamSimpleVO obj = service.getTeamSimple("team-2");
		System.out.println(obj);
*/
/*		
 		TeamSimpleVO getJoinedTeam(Criteria cri, String teamId)
		TeamSimpleVO obj = service.getJoinedTeam(new Criteria(), "team-1");
		System.out.println(obj);
*/
/*		
		List<RequireSkillVO> getRequireSkills(String recruitId)
		List<RequireSkillVO> list = service.getRequireSkills("recruit-8");
		for(RequireSkillVO obj : list) {
			System.out.println(obj);
		}
*/
/*		
		List<RecruitVO> getRecruitInfo(String teamId)
		List<RecruitVO> list = service.getRecruitInfo("team-11");
		for(RecruitVO obj : list) {
			System.out.println(obj);
		}
*/
/*
		int registerComment(CommentVO comment)
		CommentVO comment = new CommentVO();
		comment.setCommentContent("안녕하세요");
		comment.setTeamId("team-1");
		comment.setMemberId("kim");
		comment.setCommentUpdateDate("2018-06-01");
		int res = service.registerComment(comment);
		System.out.println(res);
*/		
/*		
		int removeComment(String commentId)
		int res = service.removeCommnet("comment-11");
		System.out.println(res);
*/
/*		
		int updateComment(String commentId, String commentContent)
		int res = service.updateComment("comment-10", "수정된 내용입니다");
		System.out.println(res);
*/
/*		
		List<CommentVO> getComments(String teamId)
		List<CommentVO> list = service.getComments("team-1");
		for(CommentVO obj : list) {
			System.out.println(obj);
		}
*/
/*
		List<TeamSimpleVO> getRecentTeam(Criteria cri)
		Criteria cri = new Criteria();
		List<TeamSimpleVO> list = service.getRecentTeam(cri);
		for(TeamSimpleVO obj : list) {
			System.out.println(obj);
		}
*/
/*		
		int registerFaq(List<FaqVO> faq)
		FaqVO faq1 = new FaqVO();
		FaqVO faq2 = new FaqVO();
		FaqVO faq3 = new FaqVO();
		faq1.setFaqQuestion("질문1");
		faq2.setFaqQuestion("질문2");
		faq3.setFaqQuestion("질문3");
		faq1.setFaqAnswer("답변1");
		faq2.setFaqAnswer("답변2");
		faq3.setFaqAnswer("답변3");
		faq1.setTeamId("team-1");
		faq2.setTeamId("team-1");
		faq3.setTeamId("team-1");
		List<FaqVO> list = new ArrayList<FaqVO>();
		list.add(faq1);
		list.add(faq2);
		list.add(faq3);
		int result = service.registerFaq(list);
		System.out.println(result);
*/		
/*		
		List<String> registerRecruit(List<RecruitVO> recruit)
		RecruitVO recruit1 = new RecruitVO();
		RecruitVO recruit2 = new RecruitVO();
		RecruitVO recruit3 = new RecruitVO();
		recruit1.setTeamId("team-1");
		recruit2.setTeamId("team-1");
		recruit3.setTeamId("team-1");
		recruit1.setRecruitPeopleNum("2");
		recruit2.setRecruitPeopleNum("1");
		recruit3.setRecruitPeopleNum("3");
		recruit1.setRecruitPreference("군필자 우대합니다");
		recruit3.setRecruitExplain("개발 잘하셔야 해요");
		recruit1.setRoleId("role-1");
		recruit2.setRoleId("role-2");
		recruit3.setRoleId("role-3");
		List<RecruitVO> list = new ArrayList<RecruitVO>();
		list.add(recruit1);
		list.add(recruit2);
		list.add(recruit3);
		List<String> result = service.registerRecruit(list);
		for(String str : result) {
			System.out.println(str);
		}
*/
/*		
		int registerRequireSkill(List<RequireSkillVO> requireSkill)
		List<RequireSkillVO> list = new ArrayList<RequireSkillVO>();
		for(int i = 1; i <= 20; i++) {
			RequireSkillVO obj = new RequireSkillVO();
			obj.setRecruitId("recruit-10");
			obj.setSkillId("skill-" + i);
			list.add(obj);
		}
		System.out.println(service.registerRequireSkill(list));
*/
/*		
		String registerTeam(TeamDetailVO team)
		TeamDetailVO team = new TeamDetailVO();
		team.setTeamProjectName("새로운 프로젝트");
		team.setTeamName("FAST BOOSTER 팀");
		team.setTeamSummary("테스트를 위한 새로운 팀입니다.");
		team.setTeamContent("테스트를 위한 새로운 팀의 내용 입력 부분입니다");
		team.setProjectCategoryId("project_category-2");
		team.setRegionId("region-1");
		team.setTeamEndDate("2018-11-02");
		team.setTeamPic("asdswe.jpg");
		team.setMemberId("kim");
		team.setRoleId("role-1");
		System.out.println(service.registerTeam(team));
*/
/*		
		TeamDetailVO getTeamInfo(String teamId)
		TeamDetailVO team = service.getTeamInfo("team-12");
		System.out.println(team);
*/
/*		
		int updateFaq(List<FaqVO> faq)
		FaqVO faq1 = new FaqVO();
		FaqVO faq2 = new FaqVO();
		FaqVO faq3 = new FaqVO();
		faq1.setFaqId("faq-7");
		faq2.setFaqId("faq-8");
		faq3.setFaqId("faq-9");
		faq1.setFaqQuestion("수정된 질문1");
		faq2.setFaqQuestion("수정된 질문2");
		faq3.setFaqQuestion("수정된 질문3");
		faq1.setFaqAnswer("수정된 답변1");
		faq2.setFaqAnswer("수정된 답변2");
		faq3.setFaqAnswer("수정된 답변3");
		faq1.setTeamId("team-1");
		faq2.setTeamId("team-1");
		faq3.setTeamId("team-1");
		List<FaqVO> list = new ArrayList<FaqVO>();
		list.add(faq1);
		list.add(faq2);
		list.add(faq3);
		int result = service.updateFaq(list);
		System.out.println(result);
*/
/*		
		List<String> updateRecruit(List<RecruitVO> recruit)
		RecruitVO recruit1 = new RecruitVO();
		RecruitVO recruit2 = new RecruitVO();
		RecruitVO recruit3 = new RecruitVO();
		recruit1.setRecruitId("recruit-10");
		recruit2.setRecruitId("recruit-11");
		recruit3.setRecruitId("recruit-12");
		recruit1.setTeamId("team-1");
		recruit2.setTeamId("team-1");
		recruit3.setTeamId("team-1");
		recruit1.setRecruitPeopleNum("2");
		recruit2.setRecruitPeopleNum("1");
		recruit3.setRecruitPeopleNum("3");
		recruit1.setRecruitPreference("수정된 사항");
		recruit2.setRecruitPreference("수정된 사항");
		recruit3.setRecruitExplain("수정된 설명");
		recruit2.setRecruitExplain("수정된 설명");
		recruit1.setRoleId("role-1");
		recruit2.setRoleId("role-2");
		recruit3.setRoleId("role-3");
		List<RecruitVO> list = new ArrayList<RecruitVO>();
		list.add(recruit1);
		list.add(recruit2);
		list.add(recruit3);
		List<String> result = service.updateRecruit(list);
		for(String str : result) {
			System.out.println(str);
		}
*/
/*		
		List<RequireSkillDTO> removeRequireSkill(List<RequireSkillVO> requireSkill)
		List<RequireSkillVO> list = new ArrayList<RequireSkillVO>();
		for(int i = 1; i <= 20; i++) {
			RequireSkillVO obj = new RequireSkillVO();
			obj.setRecruitId("recruit-10");
			obj.setSkillId("skill-" + i);
			list.add(obj);
		}
		List<RequireSkillDTO> result = service.removeRequireSkill(list);
		for(RequireSkillDTO obj : result) {
			System.out.println(obj);
		}
*/
/*		
		String updateTeam(TeamDetailVO team)
		TeamDetailVO team = new TeamDetailVO();
		team.setTeamId("team-12");
		team.setTeamProjectName("수정된");
		team.setTeamName("수정된");
		team.setTeamSummary("수정");
		team.setTeamContent("수정된");
		team.setProjectCategoryId("project_category-2");
		team.setRegionId("region-1");
		team.setTeamEndDate("2018-11-02");
		team.setTeamPic("asdswe.jpg");
		team.setMemberId("kim");
		team.setRoleId("role-1");
		System.out.println(service.updateTeam(team));
*/
/*		
		int changeTeamStatus(int status, String teamId)
		System.out.println(service.changeTeamStatus(1, "team-12"));
*/
/*
		List<TeamSimpleVO> getTeamListByTeamId(Criteria cri)
		Criteria cri = new Criteria();
		List<String> list = new ArrayList<String>();
		list.add("team-1");
		list.add("team-4");
		list.add("team-6");
		cri.addCriteria("teamIdList", list);
		
		List<TeamSimpleVO> result = service.getTeamListByTeamId(cri);
		
		for(TeamSimpleVO str : result) {
			System.out.println(str);
		}
*/
	}

}
