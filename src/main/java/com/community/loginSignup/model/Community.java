package com.community.loginSignup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.community.login.Signup.enums.PrivatePublic;


@Entity
public class Community {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int communityId;
	
	@Column(name="community_name")
	private String communityName;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private PrivatePublic status;

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PrivatePublic getStatus() {
		return status;
	}

	public void setStatus(PrivatePublic status) {
		this.status = status;
	}
}
