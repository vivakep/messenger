package com.bsm.rest.messenger.model;

import java.util.Date;

public class Profile {
	private long id;
	private String firstName, lastName, profileName;
	private Date createDate;

	public Profile(long id, String firstName, String lastName, String profileName, Date createDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profileName = profileName;
		this.createDate = createDate;
	}

	public Profile() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}