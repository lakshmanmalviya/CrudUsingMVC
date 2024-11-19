package com.abhiyantrikitech.dto;

public class DownloadRequest {
	private long id;
	private long userId;
	private long projectId;
	private String reason;
	private String status;
	private String createdBy;
	private String createdDt;
	private String approvedBy;
	private String approvedDt;
	private String recordUpdate;
	private String lastUpdatedDt;
	private String lastUpdatedBy;

	public String getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(String lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(String createdDt) {
		this.createdDt = createdDt;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getApprovedDt() {
		return approvedDt;
	}

	public void setApprovedDt(String approvedDt) {
		this.approvedDt = approvedDt;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getRecordUpdate() {
		return recordUpdate;
	}

	public void setRecordUpdate(String recordUpdate) {
		this.recordUpdate = recordUpdate;
	}
}
