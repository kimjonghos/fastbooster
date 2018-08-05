package com.teamwith15.dto;

import java.util.ArrayList;
import java.util.List;

import com.teamwith15.vo.RequireSkillVO;

public class RequireSkillDTO {
	private String recruitId;
	private String skillId;
	public RequireSkillDTO() {
		super();
	}
	public RequireSkillDTO(String recruitId, String skillId) {
		super();
		this.recruitId = recruitId;
		this.skillId = skillId;
	}
	public String getRecruitId() {
		return recruitId;
	}
	public String getSkillId() {
		return skillId;
	}
	public void setRecruitId(String recruitId) {
		this.recruitId = recruitId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	
	public RequireSkillVO toVO() {
		List<RequireSkillDTO> temp=new ArrayList<RequireSkillDTO>();
		temp.add(this);
		RequireSkillVO vo = new RequireSkillVO(temp);
		return vo;
	}
	
	public String toString() {
		return "RequireSkillDTO [recruitId=" + recruitId + ", skillId=" + skillId + "]";
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequireSkillDTO other = (RequireSkillDTO) obj;
		if (recruitId == null) {
			if (other.recruitId != null)
				return false;
		} else if (!recruitId.equals(other.recruitId))
			return false;
		if (skillId == null) {
			if (other.skillId != null)
				return false;
		} else if (!skillId.equals(other.skillId))
			return false;
		return true;
	}
	
}
