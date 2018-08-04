package com.teamwith15.vo;

import com.teamwith15.dto.RequireSkillDTO;

public class RequireSkillVO {
	private String recruitId;
	private String skillId;
	public RequireSkillDTO toDTO() {
		RequireSkillDTO requireSkillDTO = new RequireSkillDTO();
		requireSkillDTO.setRecruitId(recruitId);
		requireSkillDTO.setSkillId(skillId);
		return requireSkillDTO;
	}
	public RequireSkillVO() {
		super();
	}
	public RequireSkillVO(String recruitId, String skillId) {
		super();
		this.recruitId = recruitId;
		this.skillId = skillId;
	}
	public String getRecruitId() {
		return recruitId;
	}
	public void setRecruitId(String recruitId) {
		this.recruitId = recruitId;
	}
	public String getSkillId() {
		return skillId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	@Override
	public String toString() {
		return "RequireSkillVO [recruitId=" + recruitId + ", skillId=" + skillId + "]";
	}
}
