package com.teamwith15.vo;

public class TeamSkillVO {
	private String teamId;
	private String roleId;
	private String skillId;
	public TeamSkillVO() {
		super();
	}
	public TeamSkillVO(String teamId, String roleId, String skillId) {
		super();
		this.teamId = teamId;
		this.roleId = roleId;
		this.skillId = skillId;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getSkillId() {
		return skillId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	@Override
	public String toString() {
		return "TeamSkillVO [teamId=" + teamId + ", roleId=" + roleId + ", skillId=" + skillId + "]";
	}
}
