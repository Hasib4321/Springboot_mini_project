package com.ClaimService.ClaimService.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Claim {
	@Id
private long statusId;
private String statusdesc;
public long getStatusId() {
	return statusId;
}
public void setStatusId(long statusId) {
	this.statusId = statusId;
}
public String getStatusdesc() {
	return statusdesc;
}
public void setStatusdesc(String statusdesc) {
	this.statusdesc = statusdesc;
}
public Claim(long statusId, String statusdesc) {
	super();
	this.statusId = statusId;
	this.statusdesc = statusdesc;
}
public Claim() {
	super();
	// TODO Auto-generated constructor stub
}


}
