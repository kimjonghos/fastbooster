package com.teamwith15.dao;

import java.util.List;

import com.teamwith15.vo.TeamLeaderVO;

public interface TeamLeaderDAO {
	public List<TeamLeaderVO> searchTeamLeader(String teamId);
}
