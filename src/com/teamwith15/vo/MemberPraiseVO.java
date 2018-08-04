package com.teamwith15.vo;

import com.teamwith15.dto.MemberPraiseDTO;

public class MemberPraiseVO {
	private String actorMemberId;
	private String targetMemberId;
	private String praiseId;
	public MemberPraiseDTO toDTO() {
		MemberPraiseDTO memberPraiseDTO = new MemberPraiseDTO();
		memberPraiseDTO.setActorMemberId(actorMemberId);
		memberPraiseDTO.setTargetMemberId(targetMemberId);
		memberPraiseDTO.setPraiseId(praiseId);
		return memberPraiseDTO;
	}
	public MemberPraiseVO() {
		super();
	}
	public MemberPraiseVO(String actorMemberId, String targetMemberId, String praiseId) {
		super();
		this.actorMemberId = actorMemberId;
		this.targetMemberId = targetMemberId;
		this.praiseId = praiseId;
	}
	public String getActorMemberId() {
		return actorMemberId;
	}
	public void setActorMemberId(String actorMemberId) {
		this.actorMemberId = actorMemberId;
	}
	public String getTargetMemberId() {
		return targetMemberId;
	}
	public void setTargetMemberId(String targetMemberId) {
		this.targetMemberId = targetMemberId;
	}
	public String getPraiseId() {
		return praiseId;
	}
	public void setPraiseId(String praiseId) {
		this.praiseId = praiseId;
	}
	@Override
	public String toString() {
		return "PraiseVO [actorMemberId=" + actorMemberId + ", targetMemberId=" + targetMemberId + ", praiseId="
				+ praiseId + "]";
	}
}
