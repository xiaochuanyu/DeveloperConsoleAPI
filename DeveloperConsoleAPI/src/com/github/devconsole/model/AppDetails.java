package com.github.devconsole.model;

import java.util.Date;

public class AppDetails {

	private String description;
	private String changelog;
	private Date lastStoreUpdate;

	public AppDetails(String description, String changelog, Long lastStoreUpdate) {
		this.description = description;
		this.changelog = changelog;
		this.lastStoreUpdate = lastStoreUpdate == null ? null : new Date(lastStoreUpdate);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getChangelog() {
		return changelog;
	}

	public void setChangelog(String changelog) {
		this.changelog = changelog;
	}

	public Date getLastStoreUpdate() {
		return lastStoreUpdate == null ? null : (Date) lastStoreUpdate.clone();
	}

	public void setLastStoreUpdate(Date lastStoreUpdate) {
		this.lastStoreUpdate = lastStoreUpdate == null ? null : (Date) lastStoreUpdate.clone();
	}

}
