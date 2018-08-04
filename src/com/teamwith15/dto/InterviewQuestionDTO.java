package com.teamwith15.dto;

public class InterviewQuestionDTO {
	private String interviewQuestionId;
	private String teamId;
	private String interviewQuestionContent;
	public InterviewQuestionDTO() {
		super();
	}
	public InterviewQuestionDTO(String interviewQuestionId, String teamId, String interviewQuestionContent) {
		super();
		this.interviewQuestionId = interviewQuestionId;
		this.teamId = teamId;
		this.interviewQuestionContent = interviewQuestionContent;
	}
	public String getInterviewQuestionId() {
		return interviewQuestionId;
	}
	public String getTeamId() {
		return teamId;
	}
	public String getInterviewQuestionContent() {
		return interviewQuestionContent;
	}
	public void setInterviewQuestionId(String interviewQuestionId) {
		this.interviewQuestionId = interviewQuestionId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public void setInterviewQuestionContent(String interviewQuestionContent) {
		this.interviewQuestionContent = interviewQuestionContent;
	}
	public String toString() {
		return "InterviewQuestionDTO [interviewQuestionId=" + interviewQuestionId + ", teamId=" + teamId
				+ ", interviewQuestionContent=" + interviewQuestionContent + "]";
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InterviewQuestionDTO other = (InterviewQuestionDTO) obj;
		if (interviewQuestionContent == null) {
			if (other.interviewQuestionContent != null)
				return false;
		} else if (!interviewQuestionContent.equals(other.interviewQuestionContent))
			return false;
		if (interviewQuestionId == null) {
			if (other.interviewQuestionId != null)
				return false;
		} else if (!interviewQuestionId.equals(other.interviewQuestionId))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		return true;
	}
	
}
