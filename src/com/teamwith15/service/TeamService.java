package com.teamwith15.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.teamwith15.dao.CommentDAO;
import com.teamwith15.dao.FaqDAO;
import com.teamwith15.dao.RecruitDAO;
import com.teamwith15.dao.RequireSkillDAO;
import com.teamwith15.dao.TeamDAO;
import com.teamwith15.dao.TeamDetailDAO;
import com.teamwith15.dao.TeamSimpleDAO;
import com.teamwith15.dao.TeamSkillDAO;
import com.teamwith15.dto.CommentDTO;
import com.teamwith15.dto.FaqDTO;
import com.teamwith15.dto.RecruitDTO;
import com.teamwith15.dto.RequireSkillDTO;
import com.teamwith15.dto.TeamDTO;
import com.teamwith15.util.Criteria;
import com.teamwith15.util.UploadFileUtils;
import com.teamwith15.vo.CommentVO;
import com.teamwith15.vo.FaqVO;
import com.teamwith15.vo.RecruitVO;
import com.teamwith15.vo.RequireSkillVO;
import com.teamwith15.vo.TeamDetailVO;
import com.teamwith15.vo.TeamSimpleVO;
import com.teamwith15.vo.TeamSkillVO;

public class TeamService {
	private static TeamService teamService;

	private SqlSession session;
	private SqlSessionFactory factory;
	
	private FaqDAO faqDAO;
	private TeamSimpleDAO teamSimpleDAO;
	private RequireSkillDAO requireSkillDAO;
	private RecruitDAO recruitDAO;
	private CommentDAO commentDAO;
	private TeamDAO teamDAO;
	private TeamSkillDAO teamSkillDAO;
	private TeamDetailDAO teamDetailDAO;

	static {
		teamService = new TeamService();
	}

	public static TeamService getInstance() {
		return teamService;
	}

	private TeamService() {
		String config = "com/teamwith15/config/config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(config);
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void openSession() {
		session = factory.openSession();
	}

	private void commitSession() {
		session.commit();
	}

	private void closeSession() {
		session.close();
	}

	public List<FaqVO> getFaq(String teamId) throws Exception {
		openSession();

		faqDAO = session.getMapper(FaqDAO.class);

		List<FaqDTO> result = faqDAO.searchFaqByTeamId(teamId);
		List<FaqVO> faq = new ArrayList<FaqVO>();

		for (FaqDTO faqDTO : result) {
			faq.add(faqDTO.toVO());
		}

		closeSession();

		return faq;
	}

	public List<TeamSimpleVO> getMyTeam(Criteria cri, String memberId) throws Exception {
		openSession();
		teamSimpleDAO = session.getMapper(TeamSimpleDAO.class);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("memberId", memberId);
		paramMap.put("page", cri.getPage());
		paramMap.put("perPageNum", cri.getPerPageNum());
		List<TeamSimpleVO> result = teamSimpleDAO.searchTeamSimpleAllByMemberId(paramMap);

		closeSession();

		return result;
	}

	public TeamSimpleVO getTeamSimple(String teamId) throws Exception {
		openSession();
		teamSimpleDAO = session.getMapper(TeamSimpleDAO.class);
		TeamSimpleVO result = teamSimpleDAO.searchTeamSimple(teamId);
		closeSession();
		return result;
	}

	public List<TeamSimpleVO> getJoinedTeam(Criteria cri) throws Exception {
		openSession();
		teamSimpleDAO = session.getMapper(TeamSimpleDAO.class);

		List<TeamSimpleVO> result = teamSimpleDAO.searchTeamSimpleAllByTeamId(cri);

		closeSession();

		return result;
	}

	public List<RequireSkillVO> getRequireSkills(String recruitId) throws Exception {
		openSession();
		requireSkillDAO = session.getMapper(RequireSkillDAO.class);
		List<RequireSkillDTO> list = requireSkillDAO.searchRequireSkillByRecruitId(recruitId);
		List<RequireSkillVO> result = new ArrayList<RequireSkillVO>();

		for (RequireSkillDTO obj : list) {
			result.add(obj.toVO());
		}

		closeSession();
		
		return result;
	}

	public List<RecruitVO> getRecruitInfo(String teamId) throws Exception {
		openSession();
		recruitDAO = session.getMapper(RecruitDAO.class);
		List<RecruitDTO> list = recruitDAO.searchRecruitByTeamId(teamId);
		List<RecruitVO> result = new ArrayList<RecruitVO>();

		for (RecruitDTO obj : list) {
			result.add(obj.toVO());
		}
		
		closeSession();
		
		return result;
	}

	public int registerComment(CommentVO comment) throws Exception {
		openSession();
		commentDAO = session.getMapper(CommentDAO.class);
		List<String> commentId = commentDAO.getId();
		
		String generatedId = generateId(commentId, "comment");
		comment.setCommentId(generatedId);
		int result = commentDAO.addComment(comment.toDTO());
		
		commitSession();
		closeSession();
		
		return result;
	}

	public int removeCommnet(String commentId) throws Exception {
		openSession();
		commentDAO = session.getMapper(CommentDAO.class);
		
		int result = commentDAO.removeCommentByCommentId(commentId);
		
		commitSession();
		closeSession();
		
		return result;
	}

	public int updateComment(String commentId, String commentContent) throws Exception {
		openSession();
		commentDAO = session.getMapper(CommentDAO.class);
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("commentId", commentId);
		paramMap.put("commentContent", commentContent);
		
		int result = commentDAO.updateCommentContent(paramMap);
		
		commitSession();
		closeSession();
		
		return result;
	}

	public List<CommentVO> getComments(String teamId) throws Exception {
		openSession();
		commentDAO = session.getMapper(CommentDAO.class);
		
		List<CommentDTO> list = commentDAO.searchCommentByTeamId(teamId);
		List<CommentVO> result = new ArrayList<CommentVO>();
		
		for(CommentDTO obj : list) {
			result.add(obj.toVO());
		}
		
		closeSession();
		
		return result;
	}

	public List<TeamSimpleVO> getRecentTeam(Criteria cri) throws Exception {
		openSession();
		teamSimpleDAO = session.getMapper(TeamSimpleDAO.class);
		
		List<TeamSimpleVO> result = teamSimpleDAO.searchRecentTeamSimple(cri);
		
		closeSession();
		
		return result;
	}

	public List<String> searchTeam(Criteria cri) throws Exception {
		openSession();
		List<String> result = new ArrayList<String>();
		teamDAO = session.getMapper(TeamDAO.class);
		
		List<TeamDTO> list = teamDAO.searchTeamByCondition(cri);
		
		for(TeamDTO obj : list) {
			result.add(obj.getTeamId());
		}
		
		closeSession();
		
		return result;
	}

	public List<String> searchTeamByRoleSkill(Criteria cri) throws Exception {
		openSession();
		List<String> result = new ArrayList<String>();
		teamSkillDAO = session.getMapper(TeamSkillDAO.class);
		
		List<TeamSkillVO> list = teamSkillDAO.searchTeamByRoleSkill(cri);
		
		for(TeamSkillVO obj : list) {
			result.add(obj.getTeamId());
		}
		
		closeSession();
		
		return result;
	}

	public List<TeamSimpleVO> getTeamListByTeamId(Criteria cri) throws Exception {
		openSession();
		teamSimpleDAO = session.getMapper(TeamSimpleDAO.class);
		
		List<TeamSimpleVO> result = teamSimpleDAO.searchTeamSimpleAllByTeamId(cri);
		
		closeSession();
		
		return result; 
	}
	
	public int registerFaq(List<FaqVO> faq) throws Exception {
		int result = 0;
		openSession();
		faqDAO = session.getMapper(FaqDAO.class);
		
		for(FaqVO obj : faq) {
			List<String> faqId = faqDAO.getId();
			
			String generatedId = generateId(faqId, "faq");
			obj.setFaqId(generatedId);
			
			result += faqDAO.addFaq(obj.toDTO());
		}
		
		commitSession();
		closeSession();
		
		return result;
	}

	public List<String> registerRecruit(List<RecruitVO> recruit) throws Exception {
		List<String> result = new ArrayList<String>();
		openSession();
		recruitDAO = session.getMapper(RecruitDAO.class);
		
		for(RecruitVO obj : recruit) {
			List<String> recruitId = recruitDAO.getId();
			
			String genereatedId = generateId(recruitId, "recruit");
			obj.setRecruitId(genereatedId);
			result.add(genereatedId);
			
			recruitDAO.addRecruit(obj.toDTO());
		}
		
		commitSession();
		closeSession();
		
		return result;
	}

	public int registerRequireSkill(List<RequireSkillVO> recruitSkill) throws Exception {
		int result = 0;
		openSession();
		requireSkillDAO = session.getMapper(RequireSkillDAO.class);
		
		for(RequireSkillVO obj : recruitSkill) {
			result += requireSkillDAO.addRequireSkill(obj.toDTO());
		}
		
		commitSession();
		closeSession();
		
		return result;
	}

	public String registerTeam(TeamDetailVO teamInfo, Part file) throws Exception {
		openSession();
		teamDAO = session.getMapper(TeamDAO.class);
		
		List<String> teamId = teamDAO.getId();
		String generatedId = generateId(teamId, "team");
		
		TeamDTO team = new TeamDTO();
		
		team.setTeamId(generatedId);
		team.setTeamProjectName(teamInfo.getTeamProjectName());
		team.setTeamName(teamInfo.getTeamName());
		team.setTeamSummary(teamInfo.getTeamSummary());
		team.setTeamContent(teamInfo.getTeamContent());
		team.setProjectCategoryId(teamInfo.getProjectCategoryId());
		team.setRegionId(teamInfo.getRegionId());
		team.setTeamEndDate(Date.valueOf(teamInfo.getTeamEndDate()));
		team.setTeamContestName(teamInfo.getTeamContestName());
		team.setTeamContestLink(teamInfo.getTeamContestLink());
		team.setMemberId(teamInfo.getMemberId());
		
		String teamPicPath = UploadFileUtils.uploadFile("c:/teamwith/image/team", generatedId, file);
		team.setTeamPic(teamPicPath);
		
		teamDAO.addTeam(team);
		commitSession();
		closeSession();
		
		return generatedId;
	}

	public int removeTeam(String teamId) throws Exception {
		openSession();
		teamDAO = session.getMapper(TeamDAO.class);
		int result = teamDAO.removeTeamByTeamId(teamId);
		
		commitSession();
		closeSession();
		
		return result;
	}

	public TeamDetailVO getTeamInfo(String teamId) throws Exception {
		openSession();
		teamDetailDAO = session.getMapper(TeamDetailDAO.class);
		
		TeamDetailVO result = teamDetailDAO.searchTeamDetailByTeamId(teamId);
		
		closeSession();
		
		return result;
	}

	public int updateFaq(List<FaqVO> faq) throws Exception {
		int result = 0;
		openSession();
		
		faqDAO = session.getMapper(FaqDAO.class);
		
		for(FaqVO obj : faq) {
			result += faqDAO.updateFaq(obj.toDTO());
		}
		
		commitSession();
		closeSession();
		
		return result;
	}

	public List<String> updateRecruit(List<RecruitVO> recruit) throws Exception {
		openSession();
		List<String> result = new ArrayList<String>();
		
		recruitDAO = session.getMapper(RecruitDAO.class);
		
		for(RecruitVO obj : recruit) {
			recruitDAO.updateRecruit(obj.toDTO());
			result.add(obj.getRecruitId());
		}
		
		commitSession();
		closeSession();
		
		return result;
	}

	public List<RequireSkillDTO> removeRequireSkill(List<RequireSkillVO> requireSkill) throws Exception {
		List<RequireSkillDTO> result = new ArrayList<RequireSkillDTO>();
		openSession();
		requireSkillDAO = session.getMapper(RequireSkillDAO.class);
		
		for(RequireSkillVO obj : requireSkill) {
			requireSkillDAO.removeRequireSkill(obj.toDTO());
			result.add(obj.toDTO());
		}
		
		commitSession();
		closeSession();
		
		return result;
	}

	public int updateRequireSkill(List<RequireSkillVO> recruitSkill) throws Exception {
		return registerRequireSkill(recruitSkill);
	}

	public String updateTeam(TeamDetailVO teamInfo, Part file) throws Exception {
		openSession();
		teamDAO = session.getMapper(TeamDAO.class);
		
		TeamDTO team = new TeamDTO();
		
		team.setTeamId(teamInfo.getTeamId());
		team.setTeamProjectName(teamInfo.getTeamProjectName());
		team.setTeamName(teamInfo.getTeamName());
		team.setTeamSummary(teamInfo.getTeamSummary());
		team.setTeamContent(teamInfo.getTeamContent());
		team.setProjectCategoryId(teamInfo.getProjectCategoryId());
		team.setRegionId(teamInfo.getRegionId());
		team.setTeamEndDate(Date.valueOf(teamInfo.getTeamEndDate()));
		team.setTeamPic(teamInfo.getTeamPic());
		team.setTeamContestName(teamInfo.getTeamContestName());
		team.setTeamContestLink(teamInfo.getTeamContestLink());
		team.setMemberId(teamInfo.getMemberId());
		
		UploadFileUtils.uploadFile("c:/teamwith/image/team", teamInfo.getTeamId(), file);
		
		teamDAO.updateTeam(team);
		
		commitSession();
		closeSession();
		
		return team.getTeamId();
	}

	public int changeTeamStatus(int status, String teamId) throws Exception {
		openSession();
		teamDAO = session.getMapper(TeamDAO.class);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", status);
		map.put("teamId", teamId);
		
		int result = teamDAO.updateTeamStatus(map);
		
		commitSession();
		closeSession();
		
		return result;
	}

	private String generateId(List<String> id, String tableName) {
		if(id == null) {
			return tableName + "-" + 1;
		}
		
		int maxCnt = -1;
		
		for(String str : id) {
			if(maxCnt < Integer.parseInt(str.split("-")[1])) {
				maxCnt = Integer.parseInt(str.split("-")[1]);
			}
		}
		
		return tableName + "-" + (maxCnt + 1);
	}

}
