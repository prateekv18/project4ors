package com.rays.ors.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public abstract class BaseBean implements Serializable, DropdownListBean, Comparable<BaseBean> {
	// Non-business primary key
	protected long id;

	// Contains USER ID who created this database record
	protected String createdBy;

	// Contains USER ID who modified this database record
	protected String modifiedBy;

	// Contains Created Timestamp of database record
	protected Timestamp createdDateTime;

	// Contains modified Timestamp of database record
	protected Timestamp modifiedDateTime;

	// accessor
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Timestamp getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Timestamp modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public int compareTo(BaseBean next) {
		return getValue().compareTo(next.getValue());
	}
}
